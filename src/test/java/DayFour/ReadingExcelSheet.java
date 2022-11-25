package DayFour;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


public class ReadingExcelSheet {
	@Test
	public void testData() throws Exception {
        File src=new File("\"C:\\Users\\abishett\\Desktop\\SapienTestData.xlsx\"");
        try
        {
            FileInputStream fis=new FileInputStream(src);
            XSSFWorkbook wb=new XSSFWorkbook(fis);
            XSSFSheet sh1=wb.getSheet("LoginData");
            XSSFRow r1=sh1.getRow(0);
            XSSFCell c1=r1.getCell(0);
            String username=c1.getStringCellValue();
            System.out.println(username);
            wb.close();
            
        }catch(FileNotFoundException e) {
        	System.out.println("Please check data file path"+e.getMessage());
        }catch(IOException e) {
        	System.out.println("Something went wrong IO"+e.getMessage());
        }
    }

}