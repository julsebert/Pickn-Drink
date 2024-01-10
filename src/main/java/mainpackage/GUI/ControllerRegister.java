package mainpackage.GUI;
import com.opencsv.exceptions.CsvValidationException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mainpackage.Logic.SceneSwitcher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.apache.logging.log4j.message.Message;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.Buffer;

public class ControllerRegister {

    // Logger
    private static final Logger logger = LogManager.getLogger(ControllerRegister.class);
    @FXML
    private Button btRegister; //initialisierung der ids
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfPasswd;
    @FXML
    private TextField tfPasswd2;

    @FXML
    public void btRegister(ActionEvent event) {
        String vEmail = tfEmail.getText();
        String vPasswd = tfPasswd.getText();
        String vPasswd2 = tfPasswd2.getText();
        if (vPasswd.equals(vPasswd2)) {
            // Write to CSV file
            writeDataToCSV("user.csv", vEmail, vPasswd);
        } else {
            System.out.println("Passwort stimmt nicht überein");
        }


    }



    private void writeDataToCSV(String filename, String var1, String var2) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filename))) {
            // Create a String array for a single CSV record
            String[] record = {var1, var2};

            // Write the record to the CSV file
            writer.writeNext(record);

            System.out.println("Data written to CSV successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void changeToLogin (){
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.LOGIN, "Login");
        logger.info("Welcome to Login.");
    }


}
