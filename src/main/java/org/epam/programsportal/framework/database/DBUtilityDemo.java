package org.epam.programsportal.framework.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtilityDemo {
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://EPINHYDW0087:3306/programs", "qa", "qa123");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from colleges");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
