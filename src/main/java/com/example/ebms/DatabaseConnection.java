package com.example.ebms;

import com.mysql.cj.jdbc.ConnectionImpl;

import java.sql.*;

public class DatabaseConnection {

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

    public ResultSet showData(String sqlcommand) throws SQLException {
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ebmsdatabase","root","");
        Statement state=con.createStatement();
        ResultSet resultSet=state.executeQuery(sqlcommand);

        return resultSet;
    }



}
