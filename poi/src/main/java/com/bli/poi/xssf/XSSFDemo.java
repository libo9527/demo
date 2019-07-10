package com.bli.poi.xssf;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author bo li
 * @date 2019-07-09 10:05
 */
public class XSSFDemo {

    public static void main(String[] args) throws IOException {
        test();
    }

    private static final String FILENAME = "/Users/libo/IdeaProjects/demo/poi/src/main/java/com/bli/poi/xssf/test.xlsx";

    private static void test() throws IOException {
        try (FileInputStream fis = new FileInputStream(FILENAME)) {
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            System.out.println("Data dump:\n");
            for (int k = 0; k < wb.getNumberOfSheets(); k++){
                XSSFSheet sheet = wb.getSheetAt(k);
                int rows = sheet.getPhysicalNumberOfRows();
                System.out.println("Sheet " + k + " \"" + wb.getSheetName(k) + "\" has " + rows
                        + " row(s).");

                int lastRowNum = sheet.getLastRowNum();
                System.out.println("Sheet " + k + " \"" + wb.getSheetName(k) + "\" last row num is " + lastRowNum + ".\n" );

                for (int r = 0; r < rows; r++) {
                    XSSFRow row = sheet.getRow(r);
                    if (row == null){
                        continue;
                    }
                    System.out.println("\nROW " + row.getRowNum() + " has " + row.getPhysicalNumberOfCells() + " cell(s).");
                    for (int c = 0; c < row.getLastCellNum(); c++) {
                        XSSFCell cell = row.getCell(c);
                        String value;
                        if (cell != null){
                            switch (cell.getCellType()) {

                                case FORMULA:
                                    value = "FORMULA value=" + cell.getCellFormula();
                                    break;

                                case NUMERIC:
                                    value = "NUMERIC value=" + cell.getNumericCellValue();
                                    break;

                                case STRING:
                                    value = "STRING value=" + cell.getStringCellValue();
                                    break;

                                case BLANK:
                                    value = "<BLANK>";
                                    break;

                                case BOOLEAN:
                                    value = "BOOLEAN value-" + cell.getBooleanCellValue();
                                    break;

                                case ERROR:
                                    value = "ERROR value=" + cell.getErrorCellValue();
                                    break;

                                default:
                                    value = "UNKNOWN value of type " + cell.getCellType();
                            }
                            System.out.println("CELL col=" + cell.getColumnIndex() + " VALUE="
                                    + value);
                        }
                    }
                }
            }
        }
    }
}
