package com.example.ebms;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CustomerView {
    @FXML
    TextField customerID, name, middle, last, address, cadastre, phone;
    @FXML
    Label currentDate, tempo;
    @FXML
    DatePicker datePicker;
    @FXML
    public void autoLoadCustomerID(){

        long number = (long) Math.floor(Math.random() * 9_000_000L) + 1_000_000L;
        customerID.setText(String.valueOf(number));
        customerID.setEditable(false);
        datePicker.setValue(LocalDate.now());
    }
    @FXML
  public void addUserdatebase() throws SQLException, ClassNotFoundException {
        try {
            DatabaseConnection dcon=new DatabaseConnection();

            String sqlCommand;
            sqlCommand = "INSERT into customer (customerID, first, last, middle, address,  regdate, cadastre, phone) VALUES" +
                    "("+customerID.getText()+",'"+name.getText()+"','"+middle.getText()+"','"+
                    last.getText()+"','"+address.getText()+"','"+datePicker.getValue()+ "','"
                    +cadastre.getText()+"','"+phone.getText()+"')";
            dcon.insertData(sqlCommand);

        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        catch (ClassNotFoundException exs){
            System.out.println(exs.getMessage());
        }
    }
}
