/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Model.Account;
import Model.DB;
import View.ViewManager;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Yahya
 */
public class AccountsManagmentController implements Initializable {
    public static Account selectedAccountToUpdate;

    @FXML
    private Button usersManagmentPageBtn;
    @FXML
    private Button accountsPageBtn;
    @FXML
    private Button operationsPageBtn;
    @FXML
    private Button createNewAccountrBtn;
    @FXML
    private Button showAllAccountsBtn;
    @FXML
    private Button updateSelectedAccountBtn;
    @FXML
    private Button deleteSelectedAccountBtn;
    @FXML
    private TextField accontSearchTF;
    @FXML
    private Button searchAccountBtn;
     @FXML
    private TableView<Account> AccManTBview;

    @FXML
    private TableColumn<Account, Integer > idCol;
    @FXML
    private TableColumn<Account, String> accNumCol;
    @FXML
    private TableColumn<Account, String> UserNameCol;
    @FXML
    private TableColumn<Account, String> currencyCol;
    @FXML
    private TableColumn<Account, Double> balanceCol;
    @FXML
    private TableColumn<Account, LocalDate> cDateCol;
   
   
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
 
    
     try {
                 
 idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
    accNumCol.setCellValueFactory(new PropertyValueFactory<>("accountNumber"));
    UserNameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
    currencyCol.setCellValueFactory(new PropertyValueFactory<>("currency"));
    balanceCol.setCellValueFactory(new PropertyValueFactory<>("balance"));
    cDateCol.setCellValueFactory(new PropertyValueFactory<>("creationDate"));
        ArrayList<Account> accounts = Account.getAllAccounts();

        AccManTBview.getItems().addAll(accounts);
    } catch (SQLException | ClassNotFoundException e) {

         System.out.println(e);
        }

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
    private void showAccountCreationPage(ActionEvent event) {
        
        
    }

    @FXML
    private void showAllAccounts(ActionEvent event) {
    }

    @FXML
    private void updateSelectedAccount(ActionEvent event) {
    }

    @FXML
    private void deleteSelectedAccount(ActionEvent event) {
    }

    @FXML
    private void searchForAnAccount(ActionEvent event) {
    }

 
}
