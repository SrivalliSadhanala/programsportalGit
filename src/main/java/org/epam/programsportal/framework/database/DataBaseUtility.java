package org.epam.programsportal.framework.database;

import org.epam.programsportal.pojo.College;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.epam.programsportal.framework.utilities.ExcelUtilities.getCollegeInfoFromExcelSheet;

public class DataBaseUtility {

    public DataBaseUtility() {
        getDataBaseConnection();
    }

    public static Connection getDataBaseConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://EPINHYDW0087:3306/programs","qa","qa123");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public static ResultSet queryStringTaker(String query) {
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = getDataBaseConnection();
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public static List<String> getCoumnValueWithEqualToConditionQuery(String columnlabel, String tablename, String extractbylabel, String value){
        List<String> listofColumnValues = new ArrayList<>();
        try {
            ResultSet resultSet = querySelectingAttributeWithEqualCondition(columnlabel,tablename,extractbylabel,value);
            while (resultSet.next())
                listofColumnValues.add(resultSet.getString(columnlabel));
        }catch (Exception e){
            e.printStackTrace();
        }
        return listofColumnValues;
    }

    public static List<String> getCoumnValueWithselectAttributeQuery(String attribute,String tablename) {
        List<String> listofColumnValues = new ArrayList<>();
        try {
            ResultSet resultSet = querySelectingAttribute(attribute,tablename);
            while (resultSet.next())
                listofColumnValues.add(resultSet.getString(attribute));
        }catch (Exception e){
            e.printStackTrace();
        }
        return listofColumnValues;
    }

    public static int countOfRecordsForQuery(String query) throws SQLException {
        int count=0;
        count = queryStringTaker(query).getFetchSize();
        return count;
    }

    public static  ResultSet queryReturningEntireTable(String tablename){
        return queryStringTaker("select * from "+ tablename);
    }

    public static  ResultSet querySelectingAttribute(String attribute,String tablename){
        return queryStringTaker("select "+ attribute +" from "+ tablename);
    }

    public static ResultSet querySelectingAttributeWithEqualCondition(String attribute1, String tablename, String attribute2, String value) {
        return queryStringTaker("select "+ attribute1 +" from "+ tablename+" where "+attribute2+" = "+"\""+value+"\"");
    }


    public static PreparedStatement getCountOfInsertedCollegeInDataBase() throws IOException {
        PreparedStatement preparedStatement = null;
        College college = getCollegeInfoFromExcelSheet();
        try {
            preparedStatement = getDataBaseConnection().prepareStatement("select count(*) from colleges where name=? and city=? and colleges.group=? and pto_name=? and pto_email=?");
            preparedStatement.setString(1, college.getCollegeName());
            preparedStatement.setString(3, college.getCollegeCity());
            preparedStatement.setString(2, college.getCollegeGroup());
            preparedStatement.setString(4, college.getCollegePtoName());
            preparedStatement.setString(5, college.getCollegePtoEmail());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return preparedStatement;
    }



}


