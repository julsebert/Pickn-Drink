package mainpackage.GUI;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import mainpackage.Logic.SceneSwitcher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opencsv.CSVWriter;



import java.io.FileWriter;
import java.io.IOException;



import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ControllerRegister {

    // Logger
    private static final Logger logger = LogManager.getLogger(ControllerRegister.class);

    // Verknüpfung zu FXML
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

    // Methoden
    @FXML
    private void btRegister() {
        String vEmail = tfEmail.getText();
        String vPasswd = tfPasswd.getText();
        String vPasswd2 = tfPasswd2.getText();
        LocalDate vBirthdate = dpBirthdate.getValue();

        if (isValidBirthdate(vBirthdate) && isValidEmail(vEmail) && vPasswd.equals(vPasswd2)) {
            // Write to CSV file
            logger.info("User added to CSV.");
            writeDataToCSV("user.csv", vEmail, vPasswd);
            lbWarningMessageRegister.setText("registration successful");
            lbWarningMessageRegister.setStyle("-fx-text-fill: #6A68D1;");
        } else {
           logger.warn("Wrong input in register.");
           displayWarning("wrong e-mail, \nwrong password \nor illegal age");
        }
    }


    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        logger.info("We are checking if the email is valid.");
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
            logger.error("Exception occured: " + e);
        }
    }


    private boolean isValidBirthdate(LocalDate vBirthdate) {
        if (vBirthdate == null) {
            return false; // No birthdate provided
        }

        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(vBirthdate, currentDate);

        logger.info("We are checking if you are over 18 years old.");
        // Check if the age is at least 18 years
        return age.getYears() >= 18;
    }

    //Methode doppelt sich mit Controller Login, könnte ausgelagert werden. -> wie mit Ihnen besprochen ist es hier so in Ordnung.
    private void displayWarning(String message){
        lbWarningMessageRegister.setText(message);
        lbWarningMessageRegister.setStyle("-fx-text-fill: #ff0000;" );
        logger.info("Warning message in register has been set.");
    }

    // SceneSwitcher
    @FXML
    private void changeToLogin (){
        SceneSwitcher.getInstance().switchScene(SceneSwitcher.LOGIN, "Login");
        logger.info("Welcome to Login.");
    }


}
