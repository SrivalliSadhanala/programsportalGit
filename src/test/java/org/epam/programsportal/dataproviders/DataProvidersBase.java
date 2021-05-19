package org.epam.programsportal.dataproviders;

import org.epam.programsportal.framework.utilities.ExcelUtilities;
import org.testng.annotations.DataProvider;

import static org.epam.programsportal.constants.ConstantsSetup.*;

public class DataProvidersBase {

    @DataProvider(name="Account Credentials")
    public static Object[][] SignUpCredentialsExcel() {
        Object data[][] = new ExcelUtilities(EXCEL_PATH).getData("credentials");
        return data;
    }

    @DataProvider(name = "College Data")
    public static Object[][] DataforAddCollege() {
        Object data[][] = new ExcelUtilities(EXCEL_PATH).getData("AddCollegeData");
        return data;
    }

    @DataProvider(name = "Search Data")
    public static Object[][] DataforSearch() {
        Object data[][] = new ExcelUtilities(EXCEL_PATH).getData("SearchWords");
        return  data;
    }

}
