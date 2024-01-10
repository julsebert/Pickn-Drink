package mainpackage.GUI;

import com.opencsv.exceptions.CsvValidationException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import mainpackage.Logic.SceneSwitcher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.IOException;


public class
ControllerLogin {

    // Logger
    private static final Logger logger = LogManager.getLogger(ControllerLogin.class);


    @FXML
    private TextField tfEmailLogin;

    @FXML
    private TextField tfPasswdLogin;

    private String vEmailLogin;
    private String vPasswdLogin;

    private boolean vLoginCheckMail;
    private boolean vLoginCheckPW;
    // SceneSwitcher
    @FXML
    public void changeToDrinks(){
        // Read from CSV file
        vLoginCheckMail = false;
        vLoginCheckPW = false;
        vEmailLogin = tfEmailLogin.getText();
        vPasswdLogin = tfPasswdLogin.getText();
        readDataFromCSV("user.csv");

        if(vLoginCheckPW == true && vLoginCheckMail == true) {
            SceneSwitcher.getInstance().switchScene(SceneSwitcher.DRINKS, "Drinks");
            logger.info("Welcome to Drinks.");
        }
        else
        {
            System.out.println("Email oder Kennwort sind falsch.");
        }
    }

    private void readDataFromCSV(String filename) {
        try (CSVReader reader = new CSVReader(new FileReader(filename))) {
            // Read all records from the CSV file
            String[] record;
            int vSpalte = 1;
            while ((record = reader.readNext()) != null) {
                // Process each field in the record
                for (String field : record) {

                    if(vSpalte == 1 && field.equals(vEmailLogin))
                    {
                        //ok
                        System.out.println("Mail OK");
                        vLoginCheckMail = true;
                    }
                    else if (vSpalte == 1)
                    {
                        System.out.println("Login Email existiert nicht");

                    }

                    if (vSpalte == 2 &&  field.equals(vPasswdLogin))
                    {
                        //ok
                        System.out.println("PW OK");
                        vLoginCheckPW = true;
                    }
                    else if(vSpalte == 2)
                    {
                        System.out.println("Kennwort ist falsch");
                    }
                    System.out.print(field + " ");
                    vSpalte ++;
                }

                System.out.println(); // Move to the next line for the next record
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void changeToRegister(){
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.REGISTER, "Register");
        logger.info("Now you can sign in.");
    }
}
