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
public class TaiSanDamBao {

    public static void main(String[] args) throws MessagingException, FileNotFoundException {
// set the path of the Excel file
        String excelFilePath = "D:\\Study\\SQA\\testcase.xlsx";

        // load the Excel file and select the sheet to read from and write to
        try ( FileInputStream fis = new FileInputStream(excelFilePath);  XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
            XSSFSheet sheet1 = workbook.getSheet("Sheet1");
            XSSFSheet sheet2 = workbook.getSheet("Sheet2");
            XSSFSheet sheet3 = workbook.getSheet("Sheet3");
            XSSFSheet sheet4 = workbook.getSheet("Sheet4");
            XSSFSheet sheet5 = workbook.getSheet("Sheet5");
            XSSFSheet sheet6 = workbook.getSheet("Sheet6");
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

            row = sheet3.getRow(1);
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

            row = sheet4.getRow(1);
            String mucdichvay = formatter.formatCellValue(row.getCell(0));

            String muaotomoi = formatter.formatCellValue(row.getCell(1));
            String muaotocu = formatter.formatCellValue(row.getCell(2));
            String hoanvonoto = formatter.formatCellValue(row.getCell(3));
            String txtvaymuaoto = formatter.formatCellValue(row.getCell(4));

            String tscd = formatter.formatCellValue(row.getCell(5));
            String vonmorong = formatter.formatCellValue(row.getCell(6));
            String vonluudong = formatter.formatCellValue(row.getCell(7));
            String thauchi = formatter.formatCellValue(row.getCell(8));
            String txtvaykinhdoanh = formatter.formatCellValue(row.getCell(9));

            String muabdssudung = formatter.formatCellValue(row.getCell(10));
            String muabdskinhdoanh = formatter.formatCellValue(row.getCell(11));
            String muabdskhac = formatter.formatCellValue(row.getCell(12));
            String txtmuabdskhac = formatter.formatCellValue(row.getCell(13));
            String chungcu = formatter.formatCellValue(row.getCell(14));
            String nhadat = formatter.formatCellValue(row.getCell(15));
            String dat = formatter.formatCellValue(row.getCell(16));
            String bdschuagiay = formatter.formatCellValue(row.getCell(17));
            String bdscogiay = formatter.formatCellValue(row.getCell(18));
            String bdskhac = formatter.formatCellValue(row.getCell(19));
            String txtbdskhac = formatter.formatCellValue(row.getCell(20));
            String txtvaymuabds = formatter.formatCellValue(row.getCell(21));

            String xaynhasudung = formatter.formatCellValue(row.getCell(22));
            String xaynhakinhdoanh = formatter.formatCellValue(row.getCell(23));
            String xaynhakhac = formatter.formatCellValue(row.getCell(24));
            String txtxaynhakhac = formatter.formatCellValue(row.getCell(25));
            String txtvayxaynha = formatter.formatCellValue(row.getCell(26));

            String txtvaykhac = formatter.formatCellValue(row.getCell(27));

            String sotien = formatter.formatCellValue(row.getCell(28));
            String thoihan = formatter.formatCellValue(row.getCell(29));

            String trano1 = formatter.formatCellValue(row.getCell(30));
            String trano2 = formatter.formatCellValue(row.getCell(31));
            String trano3 = formatter.formatCellValue(row.getCell(32));
            String trano4 = formatter.formatCellValue(row.getCell(33));
            String tranokhac = formatter.formatCellValue(row.getCell(34));
            String txttranokhac = formatter.formatCellValue(row.getCell(35));
            String dexuat = formatter.formatCellValue(row.getCell(36));

            row = sheet5.getRow(1);
            String thunhap1 = formatter.formatCellValue(row.getCell(0));
            String cotuc1 = formatter.formatCellValue(row.getCell(1));
            String loinhuan1 = formatter.formatCellValue(row.getCell(2));
            String ttaisan1 = formatter.formatCellValue(row.getCell(3));
            String thunhapkhac1 = formatter.formatCellValue(row.getCell(4));
            String thunhap2 = formatter.formatCellValue(row.getCell(5));
            String cotuc2 = formatter.formatCellValue(row.getCell(6));
            String loinhuan2 = formatter.formatCellValue(row.getCell(7));
            String ttaisan2 = formatter.formatCellValue(row.getCell(8));
            String thunhapkhac2 = formatter.formatCellValue(row.getCell(9));
            String thunhap3 = formatter.formatCellValue(row.getCell(10));
            String cotuc3 = formatter.formatCellValue(row.getCell(11));
            String loinhuan3 = formatter.formatCellValue(row.getCell(12));
            String ttaisan3 = formatter.formatCellValue(row.getCell(13));
            String thunhapkhac3 = formatter.formatCellValue(row.getCell(14));
            String sinhhoat = formatter.formatCellValue(row.getCell(15));
            String tragoclai = formatter.formatCellValue(row.getCell(16));
            String chiphikhac = formatter.formatCellValue(row.getCell(17));
            String thunhapbatthuong = formatter.formatCellValue(row.getCell(18));
            for (int i = 1; i <= sheet6.getLastRowNum(); i++) {
//            for (int i = 3; i <= 5; i++) {
                WebDriver driver = new ChromeDriver();
                driver.get("http://localhost:3000/bank-loan/open/2/register");
//            for (int i = sheet.getLastRowNum(); i >=38 ; i--) {
                row = sheet6.getRow(i);
                // read the data from the current row               

                String taisan = formatter.formatCellValue(row.getCell(0));
                String sohuu = formatter.formatCellValue(row.getCell(1));
                String quanhe = formatter.formatCellValue(row.getCell(2));
                String dangthechap = formatter.formatCellValue(row.getCell(3));

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
                    driver.findElement(By.name("job.Cán bộ cấp chuyên viên/nhân viên")).click();
                }
                if ("1".equals(nghe3)) {
                    driver.findElement(By.name("job.Lực lượng vũ trang")).click();
                }
                if ("1".equals(nghe4)) {
                    driver.findElement(By.name("job.Kinh doanh có đăng ký (KDCT)")).click();
                }
                if ("1".equals(nghe5)) {
                    driver.findElement(By.name("job.Nghỉ hưu")).click();
                }
                if ("1".equals(nghe6)) {
                    driver.findElement(By.name("job.Kinh doanh tự do/lao động thời vụ")).click();
                }
                if ("1".equals(nghe7)) {
                    driver.findElement(By.name("job.Thất nghiệp/không có việc làm")).click();
                }
                if ("1".equals(nghekhac)) {
                    driver.findElement(By.name("job.other")).click();
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
                    driver.findElement(By.name("typeContractJob.other")).click();
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
                    driver.findElement(By.name("typeReceiveWage.other")).click();
                    input.text(driver.findElement(By.name("typeReceiveWageOther")), txtluongkhac);
                }

                //submit
                driver.findElement(By.xpath("//button[@type='submit' and contains(@class, 'MuiButton-containedPrimary')]")).click();
//trang muc dich vay von

                driver.findElement(By.xpath("//input[@name='selectLoanPurpose' and @value='" + mucdichvay + "']")).sendKeys(Keys.SPACE);
                if ("Vay mua ô tô".equals(mucdichvay)) {
                    if ("1".equals(muaotomoi)) {
                        driver.findElement(By.name("loanPurpose.Vay mua ô tô.purpose.Mua xe ô tô mới")).click();
                    }
                    if ("1".equals(muaotocu)) {
                        driver.findElement(By.name("loanPurpose.Vay mua ô tô.purpose.Mua xe ô tô đã qua sử dụng")).click();
                    }
                    if ("1".equals(hoanvonoto)) {
                        driver.findElement(By.name("loanPurpose.Vay mua ô tô.purpose.Hoàn vốn / Bù đắp mua xe ô tô")).click();
                    }
                    input.text(driver.findElement(By.name("loanPurpose.Vay mua ô tô.description.content")), txtvaymuaoto);
                }
                if ("Vay phục vụ hoạt động sản xuất kinh doanh".equals(mucdichvay)) {
                    if ("1".equals(tscd)) {
                        driver.findElement(By.name("loanPurpose.Vay phục vụ hoạt động sản xuất kinh doanh.purpose.Vay đầu tư TSCĐ")).click();
                    }
                    if ("1".equals(vonmorong)) {
                        driver.findElement(By.name("loanPurpose.Vay phục vụ hoạt động sản xuất kinh doanh.purpose.Vay bổ sung vốn / mở rộng / phát triển kinh doanh")).click();
                    }
                    if ("1".equals(vonluudong)) {
                        driver.findElement(By.name("loanPurpose.Vay phục vụ hoạt động sản xuất kinh doanh.purpose.Vay bổ sung vốn lưu động theo hạn mức")).click();
                    }
                    if ("1".equals(thauchi)) {
                        driver.findElement(By.name("loanPurpose.Vay phục vụ hoạt động sản xuất kinh doanh.purpose.Vay thấu chi Tài khoản thanh toán HKD")).click();
                    }
                    input.text(driver.findElement(By.name("loanPurpose.Vay phục vụ hoạt động sản xuất kinh doanh.description.content")), txtvaykinhdoanh);
                }
                if ("Vay mua bất động sản".equals(mucdichvay)) {
                    if ("1".equals(muabdssudung)) {
                        driver.findElement(By.name("loanPurpose.Vay mua bất động sản.purpose.Để sử dụng")).click();
                    }
                    if ("1".equals(muabdskinhdoanh)) {
                        driver.findElement(By.name("loanPurpose.Vay mua bất động sản.purpose.Để kinh doanh")).click();
                    }
                    if ("1".equals(muabdskhac)) {
                        driver.findElement(By.name("loanPurpose.Vay mua bất động sản.purpose.other")).click();
                        input.text(driver.findElement(By.name("loanPurpose.Vay mua bất động sản.purposeOther")), txtmuabdskhac);
                    }
                    if ("1".equals(chungcu)) {
                        driver.findElement(By.name("loanPurpose.Vay mua bất động sản.type.option.Chung cư")).click();
                    }
                    if ("1".equals(nhadat)) {
                        driver.findElement(By.name("loanPurpose.Vay mua bất động sản.type.option.Nhà đất")).click();
                    }
                    if ("1".equals(dat)) {
                        driver.findElement(By.name("loanPurpose.Vay mua bất động sản.type.option.Đất")).click();
                    }
                    if ("1".equals(bdschuagiay)) {
                        driver.findElement(By.name("loanPurpose.Vay mua bất động sản.type.option.BĐS chưa có giấy tờ chứng minh quyền sở hữu, sử dụng")).click();
                    }
                    if ("1".equals(bdscogiay)) {
                        driver.findElement(By.name("loanPurpose.Vay mua bất động sản.type.option.BĐS có giấy tờ chứng minh quyền sở hữu, sử dụng")).click();
                    }
                    if ("1".equals(bdskhac)) {
                        driver.findElement(By.name("loanPurpose.Vay mua bất động sản.type.option.other")).click();
                        input.text(driver.findElement(By.name("loanPurpose.Vay mua bất động sản.type.optionOther")), txtbdskhac);
                    }
                    input.text(driver.findElement(By.name("loanPurpose.Vay mua bất động sản.description.content")), txtvaymuabds);
                }
                if ("Vay xây nhà / sửa nhà".equals(mucdichvay)) {
                    if ("1".equals(xaynhasudung)) {
                        driver.findElement(By.name("loanPurpose.Vay xây nhà / sửa nhà.purpose.Để sử dụng")).click();
                    }
                    if ("1".equals(xaynhakinhdoanh)) {
                        driver.findElement(By.name("loanPurpose.Vay xây nhà / sửa nhà.purpose.Để kinh doanh")).click();
                    }
                    if ("1".equals(xaynhakhac)) {
                        driver.findElement(By.name("loanPurpose.Vay xây nhà / sửa nhà.purpose.other")).click();
                        input.text(driver.findElement(By.name("loanPurpose.Vay xây nhà / sửa nhà.purposeOther")), txtxaynhakhac);
                    }
                    input.text(driver.findElement(By.name("loanPurpose.Vay xây nhà / sửa nhà.description.content")), txtvayxaynha);
                }
                if ("other".equals(mucdichvay)) {
                    input.text(driver.findElement(By.name("loanPurpose.other.content")), txtvaykhac);
                }

                input.text(driver.findElement(By.name("priceLoan")), sotien);
                driver.findElement(By.id("select-time-loan")).click();
                driver.findElement(By.xpath("//li[@data-value='" + thoihan + "']")).click();
                if ("1".equals(trano1)) {
                    driver.findElement(By.name("debtPaymentMethod.Trả gốc đều hàng tháng, lãi trả hàng tháng")).click();
                }
                if ("1".equals(trano2)) {
                    driver.findElement(By.name("debtPaymentMethod.Trả gốc, lãi đều hàng tháng (Niên kim)")).click();
                }
                if ("1".equals(trano3)) {
                    driver.findElement(By.name("debtPaymentMethod.Trả gốc cuối kỳ, lãi hàng tháng")).click();
                }
                if ("1".equals(trano4)) {
                    driver.findElement(By.name("debtPaymentMethod.Trả gốc tăng dần, lãi giảm dần")).click();
                }
                if ("1".equals(tranokhac)) {
                    driver.findElement(By.name("debtPaymentMethod.other")).click();
                    input.text(driver.findElement(By.name("debtPaymentMethodOther")), txttranokhac);
                }
                input.text(driver.findElement(By.name("otherSuggestions")), dexuat);
                driver.findElement(By.xpath("//button[@type='submit']")).click();
//Trang nguon tra no                

                input.text(driver.findElement(By.name("wage")), thunhap1);
                input.text(driver.findElement(By.name("dividend")), cotuc1);
                input.text(driver.findElement(By.name("profit")), loinhuan1);
                input.text(driver.findElement(By.name("propertyRentalIncome")), ttaisan1);
                input.text(driver.findElement(By.name("otherIncome")), thunhapkhac1);
                input.text(driver.findElement(By.name("wageWifeOrHusband")), thunhap2);
                input.text(driver.findElement(By.name("dividendWifeOrHusband")), cotuc2);
                input.text(driver.findElement(By.name("profitWifeOrHusband")), loinhuan2);
                input.text(driver.findElement(By.name("propertyRentalIncomeWifeOrHusband")), ttaisan2);
                input.text(driver.findElement(By.name("otherIncomeWifeOrHusband")), thunhapkhac2);
                input.text(driver.findElement(By.name("wageSupporter")), thunhap3);
                input.text(driver.findElement(By.name("dividendSupporter")), cotuc3);
                input.text(driver.findElement(By.name("profitSupporter")), loinhuan3);
                input.text(driver.findElement(By.name("propertyRentalIncomeSupporter")), ttaisan3);
                input.text(driver.findElement(By.name("otherIncomeSupporter")), thunhapkhac3);

                input.text(driver.findElement(By.name("costOfLiving")), sinhhoat);
                input.text(driver.findElement(By.name("interestPaymentsOnLoans")), tragoclai);
                input.text(driver.findElement(By.name("otherCosts")), chiphikhac);
                input.text(driver.findElement(By.name("otherExtraordinaryIncome")), thunhapbatthuong);

                driver.findElement(By.xpath("//button[@type='submit' ]")).click();
//trang tai san dam bao

                input.text(driver.findElement(By.name("collaterals.0.name")), taisan);
                input.text(driver.findElement(By.name("collaterals.0.owner")), sohuu);
                input.text(driver.findElement(By.name("collaterals.0.relationOwnerAndCustomer")), quanhe);
                driver.findElement(By.cssSelector("input[name='collaterals.0.status'][value='" + dangthechap + "']")).click();

                driver.findElement(By.xpath("//button[@type='submit']")).click();

                String expect = "";
                String note = "Tại giao diện Thông tin tài sản đảm bảo";
                int t = 1;
                if (taisan.equals("")) {
                    expect += "Hiển thị thông báo validate trường Tên tài sản\n";
                    if (!driver.findElements(By.xpath("//div[descendant::input[@name='collaterals.0.name']]/following-sibling::p")).isEmpty()) {
                        t *= 1;
                    } else {
                        t *= 0;note += "Không hiển thị thông báo validate trường Tên tài sản\n";
                    }
                }
                if (sohuu.equals("") || !Validation.nameFormat(sohuu)) {
                    expect += "Hiển thị thông báo validate trường Tên chủ sở hữu\n";
                    if (!driver.findElements(By.xpath("//div[descendant::input[@name='collaterals.0.owner']]/following-sibling::p")).isEmpty()) {
                        t *= 1;
                    } else {
                        t *= 0;note += "Không hiển thị thông báo validate trường Tên chủ sở hữu\n";
                    }
                }
                if (quanhe.equals("")) {
                    expect += "Hiển thị thông báo validate trường Mối quan hệ của chủ sở hữu TSBĐ và khách hàng vay vốn\n";
                    if (!driver.findElements(By.xpath("//div[descendant::input[@name='collaterals.0.relationOwnerAndCustomer']]/following-sibling::p")).isEmpty()) {
                        t *= 1;
                    } else {
                        t *= 0;note += "Không hiển thị thông báo validate trường Mối quan hệ của chủ sở hữu TSBĐ và khách hàng vay vốn\n";
                    }
                }
                if (expect.equals("")) {
                    expect += "Hiển thị giao diện Cam kết\n";
                    if (!driver.findElements(By.xpath("//p[contains(text(),'Cam kết')]")).isEmpty()) {
                        t *= 1;
                    } else {
                        t *= 0;note += "Không hiển thị giao diện Cam kết\n";
                    }
                }
//                driver.navigate().refresh();
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
            // quit the web driver
//            driver.quit();

        } catch (IOException e) {
        }
    }

}
