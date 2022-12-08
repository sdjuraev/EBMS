package com.example.ebms;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentView {
    @FXML
    TextField searchText, balance;
    @FXML
    Label userName, currentBalance;
    @FXML
    private void SearchUser() throws SQLException {
        DatabaseConnection db=new DatabaseConnection();
        ResultSet resultSet=db.getData("SELECT first, middle, last, balance FROM customer WHERE customerID="+searchText.getText());
        if (resultSet.next()){
            userName.setText(resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3));
            currentBalance.setText(resultSet.getString(4));
        }
    }
    @FXML
    private void addBalance() throws SQLException, ClassNotFoundException {
        DatabaseConnection db=new DatabaseConnection();
        db.insertData("UPDATE customer SET balance ="+balance.getText()+" WHERE customerID="+searchText.getText());
    }
}
