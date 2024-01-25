package mainpackage.GUI;

import com.opencsv.exceptions.CsvValidationException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import mainpackage.Logic.SceneSwitcher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opencsv.CSVReader;


import java.io.FileReader;
import java.io.IOException;

import javafx.scene.control.Label;

public class ControllerLogin {

    // Logger
    private static final Logger logger = LogManager.getLogger(ControllerLogin.class);

    // Verknüpfung zu FXML
    @FXML
    private TextField tfEmailLogin;

    @FXML
    private TextField tfPasswdLogin;

    @FXML
    private Label lbWarningLabel;

    private String vEmailLogin;
    private String vPasswdLogin;

    private boolean vLoginCheckMail;
    private boolean vLoginCheckPW;

    // SceneSwitcher
    @FXML
    private void changeToDrinks(){
        // Read from CSV file
        vLoginCheckMail = false;
        vLoginCheckPW = false;
        vEmailLogin = tfEmailLogin.getText();
        vPasswdLogin = tfPasswdLogin.getText();
        readDataFromCSV("user.csv");

        if(vLoginCheckPW && vLoginCheckMail) {
            SceneSwitcher.getInstance().switchScene(SceneSwitcher.DRINKS, "Drinks");
            logger.info("Welcome to Drinks. Successful login.");
        }
        else
        {
            displayWarning("invalid e-mail\nor password");
            logger.info("Login failed.");
        }
    }

    @FXML
    private void changeToRegister(){
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.REGISTER, "Register");
        logger.info("Changed to register.");
    }

    // Methoden

    //Methode doppelt sich mit Controller Register, könnte ausgelagert werden -> wie mit Ihnen besprochen ist es hier so in Ordnung.
    private void displayWarning(String message) {
        // Display the warning message in the Label
        lbWarningLabel.setText(message);
        lbWarningLabel.setStyle("-fx-text-fill: #ff0000;" );
        logger.info("Warning label has been set.");
    }

    // Methode liest die File aus
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
                        logger.info("Mail OK.");
                        vLoginCheckMail = true;
                    }
                    else if (vSpalte == 1)
                    {
                       logger.info("Login Email does not excits.");

                    }

                    if (vSpalte == 2 &&  field.equals(vPasswdLogin))
                    {
                        //ok
                        logger.info("PW OK");
                        vLoginCheckPW = true;
                    }
                    else if(vSpalte == 2)
                    {
                        logger.info("Password is incorrect.");
                    }
                    System.out.print(field + " ");
                    vSpalte ++;
                }

                System.out.println(); // Move to the next line for the next record
            }
        } catch (IOException | CsvValidationException e) {
            logger.error("Exception occured: " + e);
        }
    }
}
