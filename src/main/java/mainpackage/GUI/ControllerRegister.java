package mainpackage.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import mainpackage.Logic.SceneSwitcher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opencsv.CSVWriter;



import java.io.FileWriter;
import java.io.IOException;


import javafx.scene.control.Alert.AlertType;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
    private DatePicker dpBirthdate;
    @FXML
    private Label lbWarningMessageRegister;

    @FXML
    public void btRegister(ActionEvent event) {
        String vEmail = tfEmail.getText();
        String vPasswd = tfPasswd.getText();
        String vPasswd2 = tfPasswd2.getText();
        LocalDate vBirthdate = dpBirthdate.getValue();

        if (isValidBirthdate(vBirthdate) && isValidEmail(vEmail) && vPasswd.equals(vPasswd2)) {
            // Write to CSV file
            logger.info("User zu CSV datei zugefügt");
            writeDataToCSV("user.csv", vEmail, vPasswd);
        } else {
           logger.info("falsche Eingabe bei Registrierung");
           displayWarning("Email falsch, \nPasswort falsch \noder Alter unzulässig");
        }


    }


    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }



    private void writeDataToCSV(String filename, String var1, String var2) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filename))) {
            // Create a String array for a single CSV record
            String[] record = {var1, var2};

            // Write the record to the CSV file
            writer.writeNext(record);

            logger.info("Data written to CSV successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private boolean isValidBirthdate(LocalDate vBirthdate) {
        if (vBirthdate == null) {
            return false; // No birthdate provided
        }

        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(vBirthdate, currentDate);

        // Check if the age is at least 18 years
        return age.getYears() >= 18;
    }

    private void displayWarning(String message){
        lbWarningMessageRegister.setText(message);
    }



    @FXML
    public void changeToLogin (){
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.LOGIN, "Login");
        logger.info("Welcome to Login.");
    }


}
