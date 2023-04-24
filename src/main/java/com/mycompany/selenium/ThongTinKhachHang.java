package com.mycompany.selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.mail.*;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author handu
 */
public class ThongTinKhachHang {

    public static void main(String[] args) throws MessagingException, FileNotFoundException {
// set the path of the Excel file
        String excelFilePath = "D:\\Study\\SQA\\testcase.xlsx";

        // load the Excel file and select the sheet to read from and write to
        try ( FileInputStream fis = new FileInputStream(excelFilePath);  XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
            XSSFSheet sheet1 = workbook.getSheet("Sheet1");
            XSSFSheet sheet2 = workbook.getSheet("Sheet2");
            // set up the web driver
            System.setProperty("webdriver.chrome.driver", "D:\\Study\\SQA\\chromedriver.exe");
            DataFormatter formatter = new DataFormatter();
            Row row = sheet1.getRow(1);
            String hovaten = formatter.formatCellValue(row.getCell(0));
            String sdt = formatter.formatCellValue(row.getCell(1));
            String email = formatter.formatCellValue(row.getCell(2));
            
            for (int i = 1; i <= sheet2.getLastRowNum(); i++) {
                WebDriver driver = new ChromeDriver();
                driver.get("http://localhost:3000/bank-loan/open/2/register");
                row = sheet2.getRow(i);
                // read the data from the current row                
                String gioitinh = formatter.formatCellValue(row.getCell(0));
                String ngaysinh = formatter.formatCellValue(row.getCell(1));
                String cccd = formatter.formatCellValue(row.getCell(2));
                String ngaycap = formatter.formatCellValue(row.getCell(3));
                String noicap = formatter.formatCellValue(row.getCell(4));
                String hokhau = formatter.formatCellValue(row.getCell(5));
                String noio = formatter.formatCellValue(row.getCell(6));
                String honnhan = formatter.formatCellValue(row.getCell(7));
                String txthonnhankhac = formatter.formatCellValue(row.getCell(8));
                String hocvan = formatter.formatCellValue(row.getCell(9));
                String txthocvankhac = formatter.formatCellValue(row.getCell(10));
                String nha1 = formatter.formatCellValue(row.getCell(11));
                String nha2 = formatter.formatCellValue(row.getCell(12));
                String nha3 = formatter.formatCellValue(row.getCell(13));
                String nha4 = formatter.formatCellValue(row.getCell(14));
                String nha5 = formatter.formatCellValue(row.getCell(15));
                String nhakhac = formatter.formatCellValue(row.getCell(16));
                String txtnhakhac = formatter.formatCellValue(row.getCell(17));
                String xe1 = formatter.formatCellValue(row.getCell(18));
                String xe2 = formatter.formatCellValue(row.getCell(19));
                String xekhac = formatter.formatCellValue(row.getCell(20));
                String txtxekhac = formatter.formatCellValue(row.getCell(21));

// trang dang ky vay tien online
                input.text(driver.findElement(By.id("input-fullname")), hovaten);
                input.text(driver.findElement(By.id("input-phone")), sdt);
                input.text(driver.findElement(By.id("input-email")), email);

                // click the submit button
                driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeLarge MuiButton-containedSizeLarge css-1v34alj-MuiButtonBase-root-MuiButton-root']")).click();
                try {
                    Thread.sleep(5000); // 0.5 giây
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
// trang OTP
                String otp = "";
                while ("".equals(otp)) {
                    otp = input.getOTP();
                }
                List<WebElement> inputs = driver.findElements(By.cssSelector("div.MuiInputBase-root input[type='text']"));
                for (int j = 0; j < otp.length(); j++) {
                    char digit = otp.charAt(j);
                    inputs.get(j).sendKeys(Character.toString(digit));
                }
//trang thong tin khach hang
                //gioi tinh

                driver.findElement(By.cssSelector("input[name='gender'][value='" + gioitinh + "']")).click();

                //ngay sinh
                driver.findElement(By.name("birthday")).click();
                driver.findElement(By.name("birthday")).sendKeys(ngaysinh);
                //cccd,cmt,ho chieu
                input.text(driver.findElement(By.name("idNumber")), cccd);
                //ngay cap
                driver.findElement(By.name("issuedDate")).click();
                driver.findElement(By.name("issuedDate")).sendKeys(ngaycap);
                //noi cap
                input.text(driver.findElement(By.name("issuedPlace")), noicap);
                //ho khau
                input.text(driver.findElement(By.name("permanentAddress")), hokhau);
                //noi o
                input.text(driver.findElement(By.name("currentResidence")), noio);
                //tinh trang hon nhan               
                driver.findElement(By.xpath("//input[@name='marital' and @value='" + honnhan + "']")).click();
                if (!driver.findElements(By.name("maritalOther")).isEmpty()) {
                    input.text(driver.findElement(By.name("maritalOther")), txthonnhankhac);
                }

                //trinh do hoc van
                driver.findElement(By.xpath("//input[@name='academicLevel' and @value='" + hocvan + "']")).click();
                if (!driver.findElements(By.name("academicLevelOther")).isEmpty()) {
                    input.text(driver.findElement(By.name("academicLevelOther")), txthocvankhac);
                }

                //hinh thu so huu nha o
                if ("1".equals(nha1)) {
                    driver.findElement(By.name("homeOwnership.Nhà riêng và trả hoàn toàn")).click();
                }
                if ("1".equals(nha2)) {
                    driver.findElement(By.name("homeOwnership.Nhà riêng và thế chấp")).click();
                }
                if ("1".equals(nha3)) {
                    driver.findElement(By.name("homeOwnership.Nhà công ty cung cấp")).click();
                }
                if ("1".equals(nha4)) {
                    driver.findElement(By.name("homeOwnership.Nhà thuê")).click();
                }
                if ("1".equals(nha5)) {
                    driver.findElement(By.name("homeOwnership.Nhà ở cùng bố mẹ, bạn bè, họ hàng")).click();
                }
                if ("1".equals(nhakhac)) {
                    driver.findElement(By.name("homeOwnership.other")).click();
                    input.text(driver.findElement(By.name("homeOwnershipOther")), txtnhakhac);
                }
                //phuong tien di lai
                if ("1".equals(xe1)) {
                    driver.findElement(By.name("vehicles.Ô tô")).click();
                }
                if ("1".equals(xe2)) {
                    driver.findElement(By.name("vehicles.Xe máy")).click();
                }
                if ("1".equals(xekhac)) {
                    driver.findElement(By.name("vehicles.other")).sendKeys(Keys.SPACE);
                    input.text(driver.findElement(By.name("vehiclesOther")), txtxekhac);
                }
                //nut submit
                driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium css-sghohy-MuiButtonBase-root-MuiButton-root']")).click();
                String expect = "";
                String note = "Tại giao diện Thông tin khách hàng:\n";
                int t = 1;

                if (ngaysinh.equals("")) {
                    expect += "Hiển thị thông báo validate trường Ngày sinh\n";
                    if (!driver.findElements(By.xpath("//div[descendant::input[@name='birthday']]/following-sibling::p")).isEmpty()) {
                        t *= 1;
                    } else {
                        t *= 0;
                        note += "Không hiển thị thông báo validate trường Ngày sinh\n";
                    }
                }
                if (cccd.equals("") || !Validation.codeFormat(cccd)) {
                    expect += "Hiển thị thông báo validate trường Số CCCD/CMND/Hộ chiếu\n";
                    if (!driver.findElements(By.xpath("//div[descendant::input[@name='idNumber']]/following-sibling::p")).isEmpty()) {
                        t *= 1;
                    } else {
                        t *= 0;
                        note += "Không hiển thị thông báo validate trường Số CCCD/CMND/Hộ chiếu\n";
                    }
                }
                if (ngaycap.equals("")) {
                    expect += "Hiển thị thông báo validate trường Ngày cấp\n";
                    if (!driver.findElements(By.xpath("//div[descendant::input[@name='issuedDate']]/following-sibling::p")).isEmpty()) {
                        t *= 1;
                    } else {
                        t *= 0;
                        note += "Không hiển thị thông báo validate trường Ngày cấp\n";
                    }
                }
                if (noicap.equals("")) {
                    expect += "Hiển thị thông báo validate trường Nơi cấp\n";
                    if (!driver.findElements(By.xpath("//div[descendant::input[@name='issuedPlace']]/following-sibling::p")).isEmpty()) {
                        t *= 1;
                    } else {
                        t *= 0;
                        note += "Không hiển thị thông báo validate trường Nơi cấp\n";
                    }
                }

                if (hokhau.equals("")) {
                    expect += "Hiển thị thông báo validate trường Hộ khẩu thường trú\n";
                    if (!driver.findElements(By.xpath("//div[descendant::input[@name='permanentAddress']]/following-sibling::p")).isEmpty()) {
                        t *= 1;
                    } else {
                        t *= 0;
                        note += "Không hiển thị thông báo validate trường Hộ khẩu thường trú\n";
                    }
                }
                if (noio.equals("")) {
                    expect += "Hiển thị thông báo validate trường Nơi ở hiện tại\n";
                    if (!driver.findElements(By.xpath("//div[descendant::input[@name='currentResidence']]/following-sibling::p")).isEmpty()) {
                        t *= 1;
                    } else {
                        t *= 0;
                        note += "Không hiển thị thông báo validate trường Nơi ở hiện tại\n";
                    }
                }
                if (honnhan.equals("other") && txthonnhankhac.equals("")) {
                    expect += "Hiển thị thông báo validate trường Ghi rõ tình trạng hôn nhân\n";
                    if (!driver.findElements(By.xpath("//div[descendant::input[@name='maritalOther']]/following-sibling::p")).isEmpty()) {
                        t *= 1;
                    } else {
                        t *= 0;
                        note += "Không hiển thị thông báo validate trường Ghi rõ tình trạng hôn nhân\n";
                    }
                }
                if (!driver.findElements(By.name("academicLevelOther")).isEmpty() && txthocvankhac.equals("")) {
                    expect += "Hiển thị thông báo validate trường Ghi rõ trình độ học vấn\n";
                    if (!driver.findElements(By.xpath("//div[descendant::input[@name='academicLevelOther']]/following-sibling::p")).isEmpty()) {
                        t *= 1;
                    } else {
                        t *= 0;
                        note += "Không hiển thị thông báo validate trường Ghi rõ trình độ học vấn\n";
                    }
                }
                if ("0".equals(nha1) && "0".equals(nha2) && "0".equals(nha3) && "0".equals(nha4) && "0".equals(nha5) && "0".equals(nhakhac)) {
                    expect += "Hiển thị thông báo validate form Chọn hình thức nhà ở\n";
                    if (!driver.findElements(By.xpath("//label[contains(text(), 'Hình thức sở hữu nhà ở')]/following-sibling::p")).isEmpty()) {
                        t *= 1;
                    } else {
                        t *= 0;
                        note += "Không hiển thị thông báo form Chọn hình thức nhà ở";
                    }
                }
                if ("1".equals(nhakhac)) {
                    if (txtnhakhac.equals("")) {
                        expect += "Hiển thị thông báo validate trường Ghi rõ hình thức sở hữu nhà\n";
                        if (!driver.findElements(By.xpath("//div[descendant::input[@name='homeOwnership.other']]/following-sibling::p")).isEmpty()) {
                            t *= 1;
                        } else {
                            t *= 0;
                            note += "Không hiển thị thông báo validate trường Ghi rõ hình thức sở hữu nhà\n";
                        }
                    }
                }
                if ("0".equals(xe1) && "0".equals(xe2) && "0".equals(xekhac)) {
                    expect += "Hiển thị thông báo validate form Chọn phương tiện đi lại\n";
                    if (!driver.findElements(By.xpath("//label[contains(text(), 'Phương tiện đi lại')]/following-sibling::p")).isEmpty()) {
                        t *= 1;
                    } else {
                        t *= 0;note += "Không hiển thị thông báo validate form Chọn phương tiện đi lại\n";
                    }
                }
                if ("1".equals(xekhac)) {
                    if (txtxekhac.equals("")) {
                        expect += "Hiển thị thông báo validate trường Ghi rõ phương tiện đi lại\n";
                        if (!driver.findElements(By.xpath("//div[descendant::input[@name='vehicles.other']]/following-sibling::p")).isEmpty()) {
                            t *= 1;
                        } else {
                            t *= 0;note += "Không hiển thị thông báo validate trường Ghi rõ phương tiện đi lại\n";
                        }
                    }
                }
                if (expect.equals("")) {
                    expect += "Hiển thị giao diện Thông tin nghề nghiệp\n";
                    if (!driver.findElements(By.xpath("//p[contains(text(),'Thông tin nghề nghiệp')]")).isEmpty()) {
                        t *= 1;
                    } else {
                        t *= 0;note += "Không hiển thị giao diện Thông tin nghề nghiệp\n";
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
                try ( FileOutputStream fos = new FileOutputStream(excelFilePath)) {
                    workbook.write(fos);
                }
                driver.quit();
            }

            // save the changes to the Excel file
            // quit the web driver
        } catch (IOException e) {
        }
    }

}
