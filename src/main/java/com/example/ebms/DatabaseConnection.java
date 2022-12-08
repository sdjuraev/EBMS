package com.example.ebms;

import com.mysql.cj.exceptions.CJCommunicationsException;
import com.mysql.cj.jdbc.ConnectionImpl;

import java.sql.*;
import java.util.concurrent.ExecutionException;

public class DatabaseConnection {
    ResultSet resultSet;

    public void insertData(String sqlcommand) throws ClassNotFoundException, SQLException {
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ebmsdatabase","root","");
        Statement state=con.createStatement();
        if (state.executeUpdate(sqlcommand)>0){
            System.out.printf("Data inserted");
        }else
        {
            System.out.printf("ERROR");
        }
        con.close();
    }

    public ResultSet getData(String sqlcommand) throws SQLException {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebmsdatabase", "root", "");

            Statement state = con.createStatement();
            resultSet = state.executeQuery(sqlcommand);
            return resultSet;
        }
        catch (Exception exp){
            System.out.println(exp.getMessage());
        }
        return resultSet;
    }



}
