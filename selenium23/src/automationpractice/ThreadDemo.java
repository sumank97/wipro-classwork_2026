package automationpractice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ThreadDemo
{
    public static void getTestDataFromExcel() throws Exception
    {
        FileInputStream file =
                new FileInputStream("C:\\Users\\Admin\\Desktop\\TestData.xlsx");

        Workbook workbook =
                WorkbookFactory.create(file);

        Sheet sheet =
                workbook.getSheet("Sheet1");

        Row row =
                sheet.getRow(0);

        Cell cell =
                row.getCell(0);

        String data =
                cell.getStringCellValue();

        System.out.println(data);

        workbook.close();
    }

    public static void main(String[] args) throws Exception
    {
        getTestDataFromExcel();
    }
}