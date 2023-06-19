/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Admin;

import Model.Account;
import View.ViewManager;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.TemporalQueries;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ABD ALL
 */
public class AccountCreateController implements Initializable {

    @FXML
    private Button usersManagmentPageBtn;
    @FXML
    private Button accountsPageBtn;
    @FXML
    private Button operationsPageBtn;
    @FXML
    private TextField AccNumTXT;
    @FXML
    private TextField UStxt;
    @FXML
    private TextField curTxt;
    @FXML
    private Button cancelBtn;
    @FXML
    private TextField usIDtxt;
    @FXML
    private TextField balTXT;
    @FXML
    private Button createAcc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showUsersManagmentPage(ActionEvent event) {
         ViewManager.adminPage.changeSceneToUsersManagment();

    }

    @FXML
    private void showAccountsPage(ActionEvent event) {
         ViewManager.adminPage.changeSceneToAccountsManagment();

    }

    @FXML
    private void showOperationsPage(ActionEvent event) {
    }

    @FXML
    private void createAccAtion(ActionEvent event) throws SQLException, ClassNotFoundException {
            int userId = Integer.parseInt(usIDtxt.getText());
        int accountNumber = Integer.parseInt(AccNumTXT.getText());
        String username = UStxt.getText();
        String currency = curTxt.getText();
        double balance = Double.parseDouble(balTXT.getText());
Date creationDate = new Date();
        Account account = new Account(userId, accountNumber, username, currency, balance, creationDate);
        int result = account.save(); 
        
                ViewManager.adminPage.changeSceneToAccountsManagment();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Account inserted");
        alert.setContentText("Account inserted");
        alert.showAndWait();
        
    }

    @FXML
    private void cancelCreation(ActionEvent event) {
                        ViewManager.adminPage.changeSceneToAccountsManagment();

    }



    
}
