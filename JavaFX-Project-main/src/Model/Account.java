/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ABD ALL
 */
public class Account {
    private int id;
    private int userId;
    private int accountNumber;
    private String username;
    private String currency;
    private double balance;
    private Date creationDate;

    public Account(int userId, int accountNumber, String username, String currency, double balance, Date creationDate) {
        this.userId = userId;
        this.accountNumber = accountNumber;
        this.username = username;
        this.currency = currency;
        this.balance = balance;
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    // Create a new account in the accounts table
    public int save() throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter = 0;
        String sql = "INSERT INTO accounts (user_id, account_number, username, currency, balance, creation_date) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        ps = c.prepareStatement(sql);
        ps.setInt(1, this.getUserId());
        ps.setInt(2, this.getAccountNumber());
        ps.setString(3, this.getUsername());
        ps.setString(4, this.getCurrency());
        ps.setDouble(5, this.getBalance());
        ps.setDate(6, new java.sql.Date(this.getCreationDate().getTime()));

        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println("Account with account number: " + this.getAccountNumber() + " was added successfully!");
        }

        if (ps != null) {
            ps.close();
        }
        c.close();
        return recordCounter;
    }

    // Get all accounts from the accounts table
    public static ArrayList<Account> getAllAccounts() throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Account> accounts = new ArrayList<>();
        String sql = "SELECT * FROM accounts";
        ps = c.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            int userId = rs.getInt("user_id");
            int accountNumber = rs.getInt("account_number");
            String username = rs.getString("username");
            String currency = rs.getString("currency");
            double balance = rs.getDouble("balance");
            Date creationDate = rs.getDate("creation_date");
            
            Account account = new Account(userId, accountNumber, username, currency, balance, creationDate);
            account.setId(rs.getInt("id"));
            accounts.add(account);
        }

        if (ps != null) {
            ps.close();
        }
        c.close();
        return accounts;
    }

    // Update an existing account in the accounts table
    public int update() throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter = 0;
        String sql = "UPDATE accounts SET user_id = ?, account_number = ?, username = ?, currency = ?, balance = ?, creation_date = ? " +
                "WHERE id = ?";
        ps = c.prepareStatement(sql);
        ps.setInt(1, this.getUserId());
        ps.setInt(2, this.getAccountNumber());
        ps.setString(3, this.getUsername());
        ps.setString(4, this.getCurrency());
        ps.setDouble(5, this.getBalance());
        ps.setDate(6, new java.sql.Date(this.getCreationDate().getTime()));
        ps.setInt(7, this.getId());

        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println("Account with account number: " + this.getAccountNumber() + " was updated successfully!");
        }

        if (ps != null) {
            ps.close();
        }
        c.close();
        return recordCounter;
    }

    // Delete an account from the accounts table
    public int delete() throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter = 0;
        String sql = "DELETE FROM accounts WHERE id = ?";
        ps = c.prepareStatement(sql);
        ps.setInt(1, this.getId());

        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println("Account with account number: " + this.getAccountNumber() + " was deleted successfully!");
        }

        if (ps != null) {
            ps.close();
        }
        c.close();
        return recordCounter;
    }
}
