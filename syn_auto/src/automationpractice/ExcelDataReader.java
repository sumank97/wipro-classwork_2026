package automationpractice;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataReader {
    public static Object[][] getExcelData(String filePath, String sheetName) {
        Workbook workbook = null;
        Object[][] dataMatrix = null;
        
        try {
            FileInputStream file = new FileInputStream(new File(filePath));
            workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheet(sheetName);
            
            int rowCount = sheet.getLastRowNum();
            int colCount = sheet.getRow(0).getLastCellNum();
            
            // Allocate matrix bounds (omitting row 0 header)
            dataMatrix = new Object[rowCount][colCount];
            DataFormatter formatter = new DataFormatter(); // Cleanly formats integers, dates, and text
            
            for (int i = 0; i < rowCount; i++) {
                Row row = sheet.getRow(i + 1); 
                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j);
                    dataMatrix[i][j] = (cell == null) ? "" : formatter.formatCellValue(cell);
                }
            }
        } catch (Exception e) {
            System.err.println("Excel Extraction Aborted: " + e.getMessage());
        } finally {
            try {
                if (workbook != null) workbook.close();
            } catch (IOException ex) {
                System.err.println("Error closing file stream: " + ex.getMessage());
            }
        }
        return dataMatrix;
    }
}
