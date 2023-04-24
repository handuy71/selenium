package com.mycompany.selenium;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author handu
 */
public class DangKyVayTienOnline {

    public static void main(String[] args) {
// set the path of the Excel file
        String excelFilePath = "D:\\Study\\SQA\\testcase.xlsx";

        // load the Excel file and select the sheet to read from and write to
        try ( FileInputStream fis = new FileInputStream(excelFilePath);  XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
            XSSFSheet sheet1 = workbook.getSheet("Sheet1");
            // set up the web driver
            System.setProperty("webdriver.chrome.driver", "D:\\Study\\SQA\\chromedriver.exe");

            DataFormatter formatter = new DataFormatter();
            // iterate through the rows of data in the Excel sheet
            for (int i = 1; i <= sheet1.getLastRowNum(); i++) {
                WebDriver driver = new ChromeDriver();
                driver.get("http://localhost:3000/bank-loan/open/2/register");
                Row row = sheet1.getRow(i);
                // read the data from the current row
                String hovaten = formatter.formatCellValue(row.getCell(0));
                String sdt = formatter.formatCellValue(row.getCell(1));
                String email = formatter.formatCellValue(row.getCell(2));
                // enter the data in the fields

                input.text(driver.findElement(By.id("input-fullname")), hovaten);
                input.text(driver.findElement(By.id("input-phone")), sdt);
                input.text(driver.findElement(By.id("input-email")), email);

                // click the submit button
                driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeLarge MuiButton-containedSizeLarge css-1v34alj-MuiButtonBase-root-MuiButton-root']")).click();
                int t = 1;
                String expect = "";                
                String note = "Tại giao diện Đăng ký vay tiền online:\n";
                    if (hovaten == null || !Validation.nameFormat(hovaten)) {
                        expect += "Hiển thị thông báo validate trường Họ và tên\n";
                        if (!driver.findElements(By.id("input-fullname-helper-text")).isEmpty()) {
                            t *= 1;
                        } else {
                            t *= 0;
                            note += "Không hiển thị thông báo validate trường Họ và tên\n";
                        }
                    }
                    if (sdt == null || !Validation.numberFormat(sdt)) {
                        expect += "Hiển thị thông báo validate trường Số điện thoại\n";
                        if (!driver.findElements(By.id("input-phone-helper-text")).isEmpty()) {
                            t *= 1;
                        } else {
                            t *= 0;
                            note += "Không hiển thị thông báo validate trường Số điện thoại\n";
                        }
                    }
                    if (email == null || !Validation.emailFormat(email)) {
                        expect += "Hiển thị thông báo validate trường Email\n";
                        if (!driver.findElements(By.id("input-email-helper-text")).isEmpty()) {
                            t *= 1;
                        } else {
                            t *= 0;
                            note += "Không hiển thị thông báo validate trường Email\n";
                        }
                    }
                 if(expect.equals("")) {
                    expect += "Hiển thị giao diện điền mã OTP\n";
                    if (!driver.findElements(By.xpath("//p[contains(text(),'OTP')]")).isEmpty()) {
                        t *= 1;
                    } else {
                        t *= 0;
                    }
                }               
                // write the result in the third column of the Excel sheet
                row.createCell(37).setCellValue(expect);
                Cell resultCell = row.createCell(38);
                if (t == 0) {
                    resultCell.setCellValue("F");
                    row.createCell(39).setCellValue(note);
                } else {
                    resultCell.setCellValue("P");
                }              
                // save the changes to the Excel file
                try ( FileOutputStream fos = new FileOutputStream(excelFilePath)) {
                    workbook.write(fos);
                }
                // quit the web driver
                driver.quit();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
