package org.epam.programsportal.tests.jdbc;

import org.epam.programsportal.framework.database.DataBaseUtility;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestCollegeInserted {

    public static boolean  TestIfCollegeInserted() throws SQLException, IOException {
        PreparedStatement statement =  DataBaseUtility.getCountOfInsertedCollegeInDataBase();
        ResultSet results = statement.executeQuery();
        results.next();
        System.out.println(results.getInt("count(*)"));
        if(results.getInt("count(*)")>=1)
            return true;
        return false;
    }
}


