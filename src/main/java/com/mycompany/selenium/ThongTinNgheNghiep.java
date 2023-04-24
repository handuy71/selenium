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
public class ThongTinNgheNghiep {

    public static void main(String[] args) throws MessagingException, FileNotFoundException {
// set the path of the Excel file
        String excelFilePath = "D:\\Study\\SQA\\testcase.xlsx";

        // load the Excel file and select the sheet to read from and write to
        try ( FileInputStream fis = new FileInputStream(excelFilePath);  XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
            XSSFSheet sheet1 = workbook.getSheet("Sheet1");
            XSSFSheet sheet2 = workbook.getSheet("Sheet2");
            XSSFSheet sheet3 = workbook.getSheet("Sheet3");
            // set up the web driver
            System.setProperty("webdriver.chrome.driver", "D:\\Study\\SQA\\chromedriver.exe");

            DataFormatter formatter = new DataFormatter();
            // iterate through the rows of data in the Excel sheet
            Row row = sheet1.getRow(1);
            String hovaten = formatter.formatCellValue(row.getCell(0));
            String sdt = formatter.formatCellValue(row.getCell(1));
            String email = formatter.formatCellValue(row.getCell(2));
            
            row = sheet2.getRow(1);
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
            
            for (int i = 1; i <= sheet3.getLastRowNum(); i++) {

                WebDriver driver = new ChromeDriver();
                driver.get("http://localhost:3000/bank-loan/open/2/register");
                row = sheet3.getRow(i);
                // read the data from the current row                             
                String nghe1 = formatter.formatCellValue(row.getCell(0));
                String nghe2 = formatter.formatCellValue(row.getCell(1));
                String nghe3 = formatter.formatCellValue(row.getCell(2));
                String nghe4 = formatter.formatCellValue(row.getCell(3));
                String nghe5 = formatter.formatCellValue(row.getCell(4));
                String nghe6 = formatter.formatCellValue(row.getCell(5));
                String nghe7 = formatter.formatCellValue(row.getCell(6));
                String nghekhac = formatter.formatCellValue(row.getCell(7));
                String txtnghekhac = formatter.formatCellValue(row.getCell(8));
                String tencongty = formatter.formatCellValue(row.getCell(9));
                String sdtcongty = formatter.formatCellValue(row.getCell(10));
                String diachicongty = formatter.formatCellValue(row.getCell(11));
                String hdld1 = formatter.formatCellValue(row.getCell(12));
                String hdld2 = formatter.formatCellValue(row.getCell(13));
                String hdld3 = formatter.formatCellValue(row.getCell(14));
                String hdld4 = formatter.formatCellValue(row.getCell(15));
                String hdld5 = formatter.formatCellValue(row.getCell(16));
                String hdld6 = formatter.formatCellValue(row.getCell(17));
                String hdldkhac = formatter.formatCellValue(row.getCell(18));
                String txthdldkhac = formatter.formatCellValue(row.getCell(19));
                String luong1 = formatter.formatCellValue(row.getCell(20));
                String luong2 = formatter.formatCellValue(row.getCell(21));
                String luongkhac = formatter.formatCellValue(row.getCell(22));
                String txtluongkhac = formatter.formatCellValue(row.getCell(23));
// trang dang ky vay tien online
                input.text(driver.findElement(By.id("input-fullname")), hovaten);
                input.text(driver.findElement(By.id("input-phone")), sdt);
                input.text(driver.findElement(By.id("input-email")), email);

                // click the submit button
                driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeLarge MuiButton-containedSizeLarge css-1v34alj-MuiButtonBase-root-MuiButton-root']")).click();
                try {
                    Thread.sleep(2000); // 0.5 giây
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
                    driver.findElement(By.name("vehicles.other")).click();
                    input.text(driver.findElement(By.name("vehiclesOther")), txtxekhac);
                }
                //nut submit
                driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium css-sghohy-MuiButtonBase-root-MuiButton-root']")).click();

//trang thong tin nghe nghiep
                //cong ty, co quan
                input.text(driver.findElement(By.name("nameCompany")), tencongty);
                input.text(driver.findElement(By.name("phoneCompany")), sdtcongty);
                input.text(driver.findElement(By.name("addressCompany")), diachicongty);

                // nghe nghiep
                if ("1".equals(nghe1)) {
                    driver.findElement(By.name("job.Cán bộ cấp quản lý")).sendKeys(Keys.SPACE);
                }
                if ("1".equals(nghe2)) {
                    driver.findElement(By.name("job.Cán bộ cấp chuyên viên/nhân viên")).sendKeys(Keys.SPACE);
                }
                if ("1".equals(nghe3)) {
                    driver.findElement(By.name("job.Lực lượng vũ trang")).sendKeys(Keys.SPACE);
                }
                if ("1".equals(nghe4)) {
                    driver.findElement(By.name("job.Kinh doanh có đăng ký (KDCT)")).sendKeys(Keys.SPACE);
                }
                if ("1".equals(nghe5)) {
                    driver.findElement(By.name("job.Nghỉ hưu")).sendKeys(Keys.SPACE);
                }
                if ("1".equals(nghe6)) {
                    driver.findElement(By.name("job.Kinh doanh tự do/lao động thời vụ")).sendKeys(Keys.SPACE);
                }
                if ("1".equals(nghe7)) {
                    driver.findElement(By.name("job.Thất nghiệp/không có việc làm")).sendKeys(Keys.SPACE);
                }
                if ("1".equals(nghekhac)) {
                    driver.findElement(By.name("job.other")).sendKeys(Keys.SPACE);
                    input.text(driver.findElement(By.name("jobOther")), txtnghekhac);
                }

                //Loai hinh hop dong lao dong
                if ("1".equals(hdld1)) {
                    driver.findElement(By.name("typeContractJob.Có thời hạn")).click();
                }
                if ("1".equals(hdld2)) {
                    driver.findElement(By.name("typeContractJob.Không thời hạn")).click();
                }
                if ("1".equals(hdld3)) {
                    driver.findElement(By.name("typeContractJob.Tự do")).click();
                }
                if ("1".equals(hdld4)) {
                    driver.findElement(By.name("typeContractJob.Toàn thời gian")).click();
                }
                if ("1".equals(hdld5)) {
                    driver.findElement(By.name("typeContractJob.Bán thời gian")).click();
                }
                if ("1".equals(hdld6)) {
                    driver.findElement(By.name("typeContractJob.Nghỉ hưu")).click();
                }
                if ("1".equals(hdldkhac)) {
                    driver.findElement(By.name("typeContractJob.other")).sendKeys(Keys.SPACE);
                    input.text(driver.findElement(By.name("typeContractJobOther")), txthdldkhac);
                }

                //hinh thuc nhan luong
                if ("1".equals(luong1)) {
                    driver.findElement(By.name("typeReceiveWage.Tiền mặt")).click();
                }
                if ("1".equals(luong2)) {
                    driver.findElement(By.name("typeReceiveWage.Ngân hàng VPBank")).click();
                }
                if ("1".equals(luongkhac)) {
                    driver.findElement(By.name("typeReceiveWage.other")).sendKeys(Keys.SPACE);
                    input.text(driver.findElement(By.name("typeReceiveWageOther")), txtluongkhac);
                }
                boolean job = Validation.isAnySelected(driver.findElements(By.xpath("//input[contains(@name, 'job.')]")));
                boolean contract = Validation.isAnySelected(driver.findElements(By.xpath("//input[contains(@name, 'typeContractJob.')]")));
                boolean salary = Validation.isAnySelected(driver.findElements(By.xpath("//input[contains(@name, 'typeReceiveWage.')]")));
//submit
                driver.findElement(By.xpath("//button[@type='submit' and contains(@class, 'MuiButton-containedPrimary')]")).click();

                String expect = "";
                String note = "Tại giao diện Thông tin nghề nghiệp:\n";
                int t = 1;

                if (!tencongty.equals("") || !sdtcongty.equals("") || diachicongty.equals("")) {
                    if (tencongty.equals("")) {
                        expect += "Hiển thị thông báo validate trường Tên công ty\n";
                        if (!driver.findElements(By.xpath("//div[descendant::input[@name='nameCompany']]/following-sibling::p")).isEmpty()) {
                            t *= 1;
                        } else {
                            t *= 0;note += "Không hiển thị thông báo validate trường Tên công ty\n";
                        }
                    }
                    if (sdtcongty.equals("") || !Validation.numberFormat(sdtcongty)) {
                        expect += "Hiển thị thông báo validate trường Điện thoại cơ quan\n";
                        if (!driver.findElements(By.xpath("//div[descendant::input[@name='phoneCompany']]/following-sibling::p")).isEmpty()) {
                            t *= 1;
                        } else {
                            t *= 0;note += "Không hiển thị thông báo validate trường Điện thoại cơ quan\n";
                        }
                    }
                    if (diachicongty.equals("")) {
                        expect += "Hiển thị thông báo validate trường Địa chỉ cơ quan\n";
                        if (!driver.findElements(By.xpath("//div[descendant::input[@name='addressCompany']]/following-sibling::p")).isEmpty()) {
                            t *= 1;
                        } else {
                            t *= 0;note += "Không hiển thị thông báo validate trường Địa chỉ cơ quan\n";
                        }
                    }
                }
                if (!job) {
                    expect += "Hiển thị thông báo validate form chọn Nghề nghiệp\n";
                    if (!driver.findElements(By.xpath("//label[contains(text(), 'Nghề nghiệp')]/following-sibling::p")).isEmpty()) {
                        t *= 1;
                    } else {
                        t *= 0;note += "Không hiển thị thông báo validate form chọn Nghề nghiệp\n";
                    }
                }
                if ("1".equals(nghekhac) && txtnghekhac.equals("")) {
                    expect += "Hiển thị thông báo validate trường Ghi rõ nghề nghiệp hiện tại\n";
                    if (!driver.findElements(By.xpath("//div[descendant::input[@name='jobOther']]/following-sibling::p")).isEmpty()) {
                        t *= 1;
                    } else {
                        t *= 0;note += "Không hiển thị thông báo validate trường Ghi rõ nghề nghiệp hiện tại\n";
                    }
                }
                if (!contract) {
                    expect += "Hiển thị thông báo validate form chọn Loại hình hợp đồng lao động\n";
                    if (!driver.findElements(By.xpath("//label[contains(text(), 'Loại hình hợp đồng lao động')]/following-sibling::p")).isEmpty()) {
                        t *= 1;
                    } else {
                        t *= 0;note += "Không hiển thị thông báo validate form chọn Loại hình hợp đồng lao động\n";
                    }
                }
                if ("1".equals(hdldkhac) && txthdldkhac.equals("")) {
                    expect += "Hiển thị thông báo validate trường Ghi rõ Loại hình hợp đồng lao động\n";
                    if (!driver.findElements(By.xpath("//div[descendant::input[@name='typeContractJobOther']]/following-sibling::p")).isEmpty()) {
                        t *= 1;
                    } else {
                        t *= 0;note += "Không hiển thị thông báo validate trường Ghi rõ Loại hình hợp đồng lao động\n";
                    }
                }
                if (!salary) {
                    expect += "Hiển thị thông báo validate form chọn Hình thức nhận lương\n";
                    if (!driver.findElements(By.xpath("//label[contains(text(), 'Hình thức nhận lương')]/following-sibling::p")).isEmpty()) {
                        t *= 1;
                    } else {
                        t *= 0;note += "Không hiển thị thông báo validate form chọn Hình thức nhận lương\n";
                    }
                }
                if ("1".equals(luongkhac) && txtluongkhac.equals("")) {
                    expect += "Hiển thị thông báo validate trường Ghi rõ Hình thức nhận lương\n";
                    if (!driver.findElements(By.xpath("//div[descendant::input[@name='typeReceiveWageOther']]/following-sibling::p")).isEmpty()) {
                        t *= 1;
                    } else {
                        t *= 0;note += "Không hiển thị thông báo validate trường Ghi rõ Hình thức nhận lương\n";
                    }
                }
                if (expect.equals("")) {
                    expect += "Hiển thị giao diện Mục đích vay vốn\n";
                    if (!driver.findElements(By.xpath("//p[contains(text(),'Mục đích vay vốn')]")).isEmpty()) {
                        t *= 1;
                    } else {
                        t *= 0;note += "Không hiển thị giao diện Mục đích vay vốn\n";
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
//            driver.quit();
        } catch (IOException e) {
        }
    }

}
