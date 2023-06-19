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
import java.time.ZoneId;
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
public class UpdateAccountController implements Initializable {
    private Account oldACC;

    @FXML
    private Button usersManagmentPageBtn;
    @FXML
    private Button accountsPageBtn;
    @FXML
    private Button operationsPageBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private TextField usIDtxt;
    @FXML
    private TextField AccountNumTXT;
    @FXML
    private TextField Usertxt;
    @FXML
    private TextField curruncyText;
    @FXML
    private TextField balanceTXT;
    private DatePicker creationDate;
    @FXML
    private Button UPdateAcc;
    @FXML
    private DatePicker updatenDate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            //old account var to store the user to update

    this.oldACC = Controller.Admin.AccountsManagmentController.selectedAccountToUpdate;
    usIDtxt.setText(String.valueOf(oldACC.getUserId()));
    AccountNumTXT.setText(String.valueOf(oldACC.getAccountNumber()));
    Usertxt.setText(oldACC.getUsername());
    curruncyText.setText(oldACC.getCurrency());
    balanceTXT.setText(String.valueOf(oldACC.getBalance()));
        creationDate.setValue(oldACC.getCreationDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

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
    private void cancelUP(ActionEvent event) {
                                ViewManager.adminPage.changeSceneToAccountsManagment();

    }


    @FXML
    private void UPdateAccAtion(ActionEvent event) throws SQLException, ClassNotFoundException {
         int userId = Integer.parseInt(usIDtxt.getText());
    int accountNumber = Integer.parseInt(AccountNumTXT.getText());
    String username = Usertxt.getText();
    String currency = curruncyText.getText();
    double balance = Double.parseDouble(balanceTXT.getText());
    LocalDate selectedDate = updatenDate.getValue();
    Date creationDate = Date.from(selectedDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    oldACC.setUserId(userId);
    oldACC.setAccountNumber(accountNumber);
    oldACC.setUsername(username);
    oldACC.setCurrency(currency);
    oldACC.setBalance(balance);
    oldACC.setCreationDate(creationDate);
    int result = oldACC.update();
        if (result > 0) {
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Account Updated");
        alert.setContentText("Account Updated");
        alert.showAndWait();
        
   
        
    }}

    @FXML
    private void updateDateAct(ActionEvent event) {
          LocalDate selectedDate = creationDate.getValue();
    if (selectedDate != null) {
        System.out.println("Selected date: " + selectedDate);
    } else {
        System.out.println("No date selected");
    }
    }
    
}
