package automationpractice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReadDemo
{
    public static void main(String[] args) throws Exception
    {
        FileInputStream file =
                new FileInputStream(
                        "C:/Users/SumanKumar/Desktop/TestData.xlsx");

        Workbook workbook =
                WorkbookFactory.create(file);

        Sheet sheet =
                workbook.getSheet("Sheet1");

        int rows =
                sheet.getPhysicalNumberOfRows();

        DataFormatter formatter =
                new DataFormatter();

        for(int i = 1; i < rows; i++)
        {
            Row row =
                    sheet.getRow(i);

            String fullname =
                    formatter.formatCellValue(row.getCell(1));

            String email =
                    formatter.formatCellValue(row.getCell(2));

            String currentAddress =
                    formatter.formatCellValue(row.getCell(3));

            String permanentAddress =
                    formatter.formatCellValue(row.getCell(4));

            System.out.println("Full Name : " + fullname);

            System.out.println("Email : " + email);

            System.out.println("Current Address : " + currentAddress);

            System.out.println("Permanent Address : " + permanentAddress);

            System.out.println("--------------------------------");
        }

        workbook.close();
    }
}