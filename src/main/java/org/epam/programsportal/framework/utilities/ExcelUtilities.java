package org.epam.programsportal.framework.utilities;


import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.epam.programsportal.pojo.College;

import java.io.IOException;

import static org.epam.programsportal.constants.ConstantsSetup.EXCEL_PATH;

public class ExcelUtilities  {

    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private XSSFRow row;
    private XSSFCell cell;

    public ExcelUtilities(String excelpath) {
        try {
            workbook = new XSSFWorkbook(excelpath);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setSheetName(String sheetName) {
        this.sheet = workbook.getSheet(sheetName);
    }

    public String getStringCellData(int rowNum, int colNum) {
        return sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
    }

    public String getNumericCellData(int rowNum, int colNum) {
        return sheet.getRow(rowNum).getCell(colNum).getRawValue();
    }

    public int getrowCount() {
        return  sheet.getLastRowNum();
    }

    public int getcolCount() {
        return sheet.getRow(0).getLastCellNum();
    }

    public Object[][] getData(String sheetName) {
        setSheetName(sheetName);
        int rows = getrowCount();
        int cols = getcolCount();
        Object[][] data = new Object[rows][cols];
        for(int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                data[i][j]=getCellData(sheetName,i+1,j);
            }
        }
        return data;
    }

    public String getCellData(String sheetName, int rowNum, int colNum) {
        String cellData  =  "";
        if(rowNum==-1)
            return cellData;
        row = workbook.getSheet(sheetName).getRow(rowNum);
        cell = row.getCell(colNum);
        if(row==null)
            return cellData;
        else if (cell==null)
            return cellData;
        else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA)
            cellData = String.valueOf(getNumericCellData(rowNum,colNum));
        else if (cell.getCellType() == CellType.STRING)
            cellData = getStringCellData(rowNum,colNum);
        else if (cell.getCellType() == CellType.BLANK)
            cellData = "";
        else if (cell.getCellType() == CellType.BOOLEAN)
            cellData = String.valueOf(cell.getBooleanCellValue());
        return cellData;
    }

    /*public static void main(String[] args) {
        ExcelUtilities excel = new ExcelUtilities(EXCEL_PATH);
        excel.setSheetName("credentials");
        System.out.println(excel.getrowCount()+" "+ excel.getcolCount());
        //String str1 = excel.getCellData("credentials",1,1);
        //System.out.println(str1);
    }*/

        public static College getCollegeInfoFromExcelSheet() throws IOException {
        College college = new College();
        workbook = new XSSFWorkbook(EXCEL_PATH);
        sheet = workbook.getSheet("AddCollegeData");
        college.setCollegeName(sheet.getRow(1).getCell(0).getStringCellValue());
        college.setCollegeCity(sheet.getRow(1).getCell(1).getStringCellValue());
        college.setCollegeGroup(sheet.getRow(1).getCell(2).getStringCellValue());
        college.setCollegePtoName(sheet.getRow(1).getCell(3).getStringCellValue());
        college.setCollegePtoEmail(sheet.getRow(1).getCell(4).getStringCellValue());
        return college;
    }



}
