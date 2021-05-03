package com.goveva.qa.upsiTestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.goveva.qa.utilities.Xls_Reader;
import com.govevapss.qa.base.BaseTest;
import com.govevapss.qa.testPageObjects.UpsiSharerPage;

public class TC_Upsi_SharerTest extends BaseTest{

	public static UpsiSharerPage usp;
	public String sharerEmail = randomestring() + "@gmail.com";
	 
	Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir") + "/src/main/java/com/govevapss/qa/testData/UpsiData.xlsx");
	String sheetName = "Sharer";	
	
	@Test(priority =1)

	public void addUpsiSharer() throws InterruptedException, IOException {

		usp =  new UpsiSharerPage(driver);
		
		usp.clickUpsiMenu();
		logger.info("Login Successfull and click on UPSI Menu");
		usp.clickUpsiSharerMenu();
		logger.info("Click on UPSI Sharer sub Menu");
		
		

		/*String sharerNameOnList = driver.findElement(By.xpath("//strong[normalize-space()='Sharer List']")).getText();

		if(sharerNameOnList.equals("Sharer List")) {

			Assert.assertTrue(true);
			logger.info("Test Case Passed");
		}

		else {

			captureScreen(driver,"addUpsiSharer");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}

		*/

        usp.clickAddSharer();
		logger.info("Click On Add Sharer button");

		usp.setSharerName(reader.getCellData(sheetName, "Name", 2));
		logger.info("Sharer Name Added");
		
	
		usp.setSharerCode(reader.getCellData(sheetName, "Sharer Code", 2));
		logger.info("Sharer Code Added");

		
		usp.setSharerDesignation(reader.getCellData(sheetName, "Designation", 2));
		logger.info("Sharer Designation Added");

		
		usp.setSharerDepartment(reader.getCellData(sheetName, "Department", 2));
		logger.info("Sharer Department Added");

		
		usp.selSharerPan();
		logger.info("PAN Selected");

		
		usp.setSharerPan(reader.getCellData(sheetName, "Unique Identifier", 2));
		logger.info("PAN Entered");

		
		usp.setSharerFile(reader.getCellData(sheetName, "Upload Document", 2));
		logger.info("File Uploaded");

		// String email=randomestring()+"@gmail.com";

		
		usp.setSharerEmail(sharerEmail.toLowerCase());
		logger.info("Email Entered");

	
		usp.setSharerMob(reader.getCellData(sheetName, "Mobile Number", 2));
		logger.info("Mob No. Entered");

		
		usp.setSharerTel(reader.getCellData(sheetName, "Tel Number", 2));
		logger.info("Tel No. Entered");

		
		usp.clickSaveButton();
		logger.info("Clicked On Save");

		//boolean res=driver.getPageSource().contains("Sharer added successfully.");
		
		Thread.sleep(2000);
		String msg = driver.findElement(By.id("alertSuccessMessage2")).getText();

		
		Thread.sleep(2000);
		
		usp.clickSaveOKButton();
		
		
		if (msg.equals("Sharer added successfully.")) {
			Assert.assertTrue(true);
			logger.info("Add Sharer Passed");
			reader.addColumn(sheetName, "Test Case Result");

			reader.setCellData(sheetName, "Test Case Result", 2, "PASS");
		}
		else {
			captureScreen(driver, "addUpsiSharer");
			Assert.assertTrue(false);
			logger.info("Add Sharer Failed");

			reader.addColumn(sheetName, "Test Case Result");

			reader.setCellData(sheetName, "Test Case Result", 2, "FAIL");
		}

	
	}

	
	
	
	@Test(priority = 2)

	public void updateDetailsUpsiSharer() throws IOException, InterruptedException {
		
		usp =  new UpsiSharerPage(driver);
		
		usp.clickUpsiMenu();
		logger.info("Login Successfull and click on UPSI Menu");
		usp.clickUpsiSharerMenu();
		logger.info("Click on UPSI Sharer sub Menu");
		
		
		usp.setSharerSearch(sharerEmail);
		logger.info("Search...");

		//ScreenRecorderUtil.startRecord("CheckingLinks");
		
		usp.clickEditIconSharer();
		logger.info("Clicked On Edit...");

		
		usp.clearSharerName();
		usp.setSharerName(reader.getCellData(sheetName, "Name", 3));
		logger.info("Sharer Name Updated...");

		
		usp.clearSharerCode();
		usp.setSharerCode(reader.getCellData(sheetName, "Sharer Code", 3));
		logger.info("Sharer Code Updated...");

		
		usp.clearSharerDesignation();
		usp.setSharerDesignation(reader.getCellData(sheetName, "Designation", 3));
		logger.info("Sharer Designation Updated...");

		
		usp.clearSharerDepartment();
		usp.setSharerDepartment(reader.getCellData(sheetName, "Department", 3));
		logger.info("Sharer Department Updated...");

		
		driver.findElement(By.xpath("//i[@class='fa fa-download']")).click();

		
		usp.clearSharerPAN();
		usp.setSharerPan(reader.getCellData(sheetName, "Unique Identifier", 3));
		logger.info("Sharer PAN Updated...");

		
		usp.clearSharerMobile();
		usp.setSharerMob(reader.getCellData(sheetName, "Tel Number", 3));
		logger.info("Sharer Tel Updated...");

		
		usp.clickUpdateButton();
		logger.info("Sharer Updated Successfully...");

		Thread.sleep(2000);
		String msg = driver.findElement(By.id("alertSuccessMessage2")).getText();

		Thread.sleep(2000);
		usp.clickUpdateOkButton();

		if (msg.equals("Sharer updated successfully.")) {
			Assert.assertTrue(true);
			logger.info("Sharer updated Passed");
			reader.setCellData(sheetName, "Test Case Result", 3, "PASS");
		} 
		
		else {
			captureScreen(driver, "updateDetailsUpsiSharer");
			Assert.assertTrue(false);
			logger.info("Sharer updated Failed");
			reader.setCellData(sheetName, "Test Case Result", 3, "FAIL");
		}
	
	}
	
	
	
	
	@Test(priority = 3)
	public void clickOnDownloadFile() throws Exception {
		

		usp =  new UpsiSharerPage(driver);

		usp.clickUpsiMenu();
		logger.info("Login Successfull and click on UPSI Menu");
		
		usp.clickUpsiSharerMenu();
		logger.info("Click on UPSI Sharer sub Menu");
		
		usp.clearSearchTextBox();
		
		usp.setSharerSearch(sharerEmail);
		logger.info("Search...");

	
		usp.clickDownloadIconListScreen();
		logger.info("File Downloaded Successfully...");

		Thread.sleep(3000);
		String msg = driver.findElement(By.xpath("//span[@class = 'cat__core__title']")).getText();

		if (msg.equals("Sharer Lis")) {
			Assert.assertTrue(true);
			logger.info("Sharer Download File Passed");
		
			reader.setCellData(sheetName, "Test Case Result", 4, "PASS");
		} else {
			captureScreen(driver, "clickOnDownloadFile");
			 Assert.assertTrue(false);
			logger.info("Sharer updated Failed");

			reader.setCellData(sheetName, "Test Case Result", 4, "FAIL");
		}
		

	}

	@Test(priority = 4)
	public void checkSharerHistory() throws Exception {
		
		usp =  new UpsiSharerPage(driver);
		
		usp.clickUpsiMenu();
		logger.info("Login Successfull and click on UPSI Menu");
		
		usp.clickUpsiSharerMenu();
		logger.info("Click on UPSI Sharer sub Menu");
	
		usp.clearSearchTextBox();

	
		usp.setSharerSearch(sharerEmail);
		logger.info("Search...");

	
		usp.clickHistoryIcon();
		logger.info("Clicked On History Icon...");

	
		captureScreen(driver, "Sharer History");
		logger.info("Screenshot Taken of History Page...");

	
		usp.clickExpExcelOfHistory();
		logger.info("Download Excel of History Page...");

	
		usp.clickExpPDFOfHistory();
		logger.info("Download Excel of History Page...");

		
		usp.clickCloseIconHistory();
		logger.info("Close History Popup...");

	
		String msg = driver.findElement(By.xpath("//span[@class = 'cat__core__title']")).getText();

		if (msg.equals("Sharer Lis")) {
			Assert.assertTrue(true);
			logger.info("Sharer History Passed");
			

			reader.setCellData(sheetName, "Test Case Result", 5, "PASS");
		} else {
			captureScreen(driver, "checkSharerHistory");
			Assert.assertTrue(false);
			logger.info("Sharer History Failed");

		

			reader.setCellData(sheetName, "Test Case Result", 5, "FAIL");
		}

	

	}

	@Test(priority = 5)
	public void deleteSharerDetails() throws Exception {
		

		usp =  new UpsiSharerPage(driver);
		
		usp.clickUpsiMenu();
		logger.info("Login Successfull and click on UPSI Menu");
		
		usp.clickUpsiSharerMenu();
		logger.info("Click on UPSI Sharer sub Menu");
		
		usp.clearSearchTextBox();
		
		usp.setSharerSearch(sharerEmail);
		logger.info("Search...");

		
		usp.sharerDelete();
		logger.info("Sharer Delete Successfully...");

		
		Thread.sleep(3000);
		String msg = driver.findElement(By.xpath("//span[@class = 'cat__core__title']")).getText();

		if (msg.equals("Sharer List")) {
			Assert.assertTrue(true);
			logger.info("Sharer Deleted Passed");
			

			reader.setCellData(sheetName, "Test Case Result", 6, "PASS");
		} else {
			captureScreen(driver, "deleteSharerDetails");
			Assert.assertTrue(false);
			logger.info("Sharer Deleted Passed");

			reader.setCellData(sheetName, "Test Case Result", 6, "FAIL");
		}

		
	}

	
	
	
	
	
	
	

}
