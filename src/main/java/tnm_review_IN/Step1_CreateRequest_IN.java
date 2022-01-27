package tnm_review_IN;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

//import generics.Screenshots;
import lib.Excel;


public class Step1_CreateRequest_IN {

	private WebDriver driver;
	
	public static String xlsFilePath =System.getProperty("user.dir") + "/src/main/resources/testdata/testdata.xls";

		
		// Define the element 
		@FindBy (xpath = ".//*[@id='content-main']/p[2]/a") private WebElement loginToContractor_Link;
		@FindBy (xpath = ".//*[@id='content-main']/form[1]/div/span/input") private WebElement Create_New_Request;
		@FindBy (xpath=".//*[@id='desktop']") private WebElement Email;
		@FindBy (xpath =".//*[@id='body']/div[1]/div[2]/div/div/form/input[4]") private WebElement password;
		@FindBy (id="btn_signin") private WebElement SignIn;
		@FindBy ( xpath = ".//*[@name='btnAddContingentMgr']")  private WebElement Project_Task_Manager_AddButton ;
		@FindBy ( xpath = ".//*[@name='FLD_EMP_WEB_ID']")  private WebElement Email_Id_TextBox ;
		@FindBy ( xpath = ".//*[@name='BTN_GO']")  private WebElement GoButton ;
		@FindBy (xpath = ".//*[@id='content-main']/table[4]/tbody/tr[2]/td[1]/a" ) private WebElement Name ;
		@FindBy ( xpath = ".//input[@name='TEMP TIME APPROVER BUTTON']")  private WebElement UseAsTimeApprover_Button ;
		@FindBy ( xpath = ".//input[@name='TEMP MANAGER FOR CR BUTTON' and @value='Use as Manager']")  private WebElement UseAsManager_Button ;
		
		//Skill Request Page	
		@FindBy (id ="FLD_REQ_TYPE") private WebElement New_Request ;
		@FindBy ( id="FLD_NORMAL_TYPE1") private WebElement Time_Materials ;
		@FindBy (name = "btnContinue") private WebElement Continue ;
		
		//Select Requestor
		@FindBy  (id = "FLD_REQST_CO") private WebElement  Requesting_Company ;
		@FindBy (id= "FLD_REQST_ORG" ) private WebElement Requesting_Organization ;
		@FindBy (xpath = ".//*[@value ='Change requester' and @type ='submit']") private WebElement Change_requester;
		@FindBy (id="FLD_EMP_WEB_ID") private WebElement ext_Email;
		@FindBy (name="BTN_GO") private WebElement goBtn;
		@FindBy (xpath = ".//*[@value ='Search' and @type ='submit']") private WebElement searchBtn;
		@FindBy (xpath = ".//*[@value = 'Use as requester' and @type='submit']") private WebElement useReq;
		
		// Job Role/Skill
		  @FindBy ( xpath= ".//*[@id='JRSS_SELECTION1']") private WebElement Priced_JRSS;
		    @FindBy ( id = "FLD_JOB_ROLE" ) private WebElement Select_JobRole ;
		    @FindBy ( id = "FLD_SKILL_SET") private WebElement Select_SkillSet;
		
		//Project Creation
		    @FindBy ( id="FLD_PROJ_NAME") private WebElement Project_Name;
		    @FindBy (id="FLD_IS_GLOBAL_RESOURCE0") private WebElement GlobalResource_No ;
		    @FindBy ( id="FLD_CONTACT_NAME") private WebElement CustomerName_Refernce ;
		    @FindBy ( xpath = ".//*[@id='FLD_IS_FED_CONTRACT']")  private WebElement Govt_FederalContract ;
		    @FindBy ( id="FLD_CLIENT") private WebElement Client ;
		    @FindBy ( id="FLD_BRAND") private WebElement Brand ;
		    @FindBy ( id="FLD_SECTOR") private WebElement Sector ;
		    @FindBy ( id="FLD_INDUSTRY") private WebElement Industry ;
		    @FindBy ( id="fldRegulatedAcc1") private WebElement FDA ;
		    @FindBy ( id="fldRegulatedAcc2") private WebElement FFIEC ;
		    @FindBy ( id="fldRegulatedAcc4") private WebElement NREG ;
		    
		    @FindBy ( xpath = " .//*[@value='S'] " ) private WebElement Accounting_Type ;
		    @FindBy ( xpath = " .//*[@value='I'] " ) private WebElement Accounting_Type_I ;
		    @FindBy ( xpath = " .//*[@value='Y'] " ) private WebElement ISOC_yes ;
		    @FindBy (id="FLD_CMR_NUM") private WebElement Custnum;
		    @FindBy (id="FLD_PRODUCT_SELECTION") private WebElement Dropdown;
		    @FindBy (id="FLD_CONTACT_NAME") private WebElement Cust_name;
		    //Skill detail Location
		    @FindBy ( xpath=".//*[@id='FLD_WRK_LOC_STATE']" ) private WebElement State_Region_Province;
		    @FindBy ( id="FLD_WRK_LOC_CITY" ) private WebElement City ;
		    @FindBy ( id="FLD_WRK_LOC" ) private WebElement Work_Location ;
		    @FindBy ( name="Continue" ) private WebElement Continue_2 ;
		    @FindBy (id="FLD_ALT_WORK_LOC" ) private WebElement Alternate_Workloc ;
		    @FindBy (xpath= "//*[@id='FLD_FLOW_DOWN_RESTRICTION' and @value='Y']") private WebElement Flowdown_yes;
		    
		  //Skill detail skill price
		    @FindBy ( id="FLD_RQSTD_SKILL_LVL" ) private WebElement Skill_Level;
		    @FindBy (id="FLD_RQSTD_PRICE_LVL" )  private WebElement Price_Level;
		    @FindBy (id="FLD_QTY_SKILL_NEEDED" ) private WebElement Quantity ;
		    @FindBy (xpath =".//*[@id='FLD_ST']") private WebElement ST_time;
		   // @FindBy (xpath = ".//*[contains(text(),'Develop Metrics Appl Devel Progress/Quality')]//following-sibling::td[2]/select") private WebElement CoreSkill1;
		    //@FindBy (xpath = ".//*[contains(text(),'Design from Functional/Non-functional Requirements')]//following-sibling::td[2]/select") private WebElement CoreSkill2;
			@FindBy (xpath = "//*[@id='content-main']/form/table[8]/tbody/tr[2]/td[2]/select") private WebElement CoreSkill1;
			@FindBy (xpath = "//*[@id='content-main']/form/table[8]/tbody/tr[3]/td[2]/select") private WebElement CoreSkill2;
		    
		    @FindBy ( xpath= "//textarea[@id='FLD_SUPPWARN_SUPPSELJUST']") private WebElement SuppSelectionJustification;
		    @FindBy ( id="FLD_SUPPWARN_SUPPSELJUST") private WebElement Supp_JustificationText ;
		    //Skill Summary Page
		    @FindBy (xpath = ".//*[@value='Continue to request summary'] ") private WebElement ContinueToRequestSummary;
		
		 //Review Skill request
		    @FindBy (name = "Submit request") private WebElement SubmitRequest;
		    
		    //Request Created
		    @FindBy ( xpath= ".//*[@id='content-main']/table[1]/tbody/tr/td[1]/h1 ") private WebElement RequestCreated;
		    
		
//		public static String xlsFilePath = System.getProperty("user.dir") + "\\src/test/java\\testdata\\testdata.xls";
		
		@FindBy ( xpath= "//input[@name='fldSelectSuppForReq' and @value='2']") private WebElement secondary_supp;
		@FindBy ( xpath= "//input[@id='PRIMARY_RADIAL_BUTTON']") private WebElement Primary_supp;
	  @FindBy ( xpath= "//a[contains(text(), 'Deselect all')]") private WebElement Deselect_All;
	  @FindBy ( xpath= "//*[contains(text(), 'ADECCO INDIA PRIVATE LIMITED')]//preceding-sibling::input[@name='fldSuppliers']") private WebElement RadioButton_UStestVendor;
		
		
	  @FindBy ( xpath= "//div[@class='passwordless-options']/div[@id='credsDiv']") private WebElement cred_login;
//		@FindBy ( xpath= "//input[@id='otp-input']") private WebElement otp_box;
//		 @FindBy(id = "submit_btn")    private WebElement otp_submit_btn;
		@FindBy ( xpath= "//input[@name='username']") private WebElement login_username;
		@FindBy ( xpath= "//input[@name='password']") private WebElement login_password;
		@FindBy ( id="login-button") private WebElement login_Button ;
		@FindBy(id = "otp-input")	private WebElement passcodeBox;
		@FindBy(id = "submit_btn")	private WebElement SubmitPasscode;
		@FindBy (xpath = "//label[@id='totp_label']") private WebElement Authenticator_App_option;
		@FindBy (xpath = "//input[@id='newTotp-otp-input']") private WebElement EnterAccessCode_Box;
		@FindBy (xpath = "//button[contains(text(),'Next: Verify')]") private WebElement Verify_Button;
		@FindBy (xpath = "//input[@id='otp-input']") private WebElement OTP_TextBox;
		@FindBy (xpath = "//button[@id='submit_btn']") private WebElement OTP_Submit_Button;



	// Initialize the web elements 
	public Step1_CreateRequest_IN(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	// Function to login to the application
	public void login() throws IOException, InterruptedException{

	/*	WebDriverWait wait = new WebDriverWait(driver, 180);
		wait.until(ExpectedConditions.visibilityOf(loginToContractor_Link));

		loginToContractor_Link.click();
		System.out.println("Clicked on  login To CSA Link on HomePage");
		
		WebDriverWait wait00 = new WebDriverWait(driver, 180);
		wait00.until(ExpectedConditions.visibilityOf(cred_login));
		Thread.sleep(3000);*/
		cred_login.click();
		System.out.println("Selected login method--Login with credentials");
		//new login changes

		login_username.clear();
		login_username.sendKeys(Excel.getCellValue(xlsFilePath, "Login", 1, 0));
		login_password.clear();
		login_password.sendKeys(Excel.getCellValue(xlsFilePath, "Login", 1, 1));
		Thread.sleep(1000);

		//Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE).save(System.getProperty("user.dir") + "\\src\\test\\resources\\Screens\\IND");
		login_Button.click();
		System.out.println("Entered credentials and Clicked on  login Button");
		try {

			//Totp_Link.click();
			
			String otpKeyStr = "VUESKO3ATJJPQRG3";
			Totp totp = new Totp(otpKeyStr);
			String twoFactorCode = totp.now();
			
			OTP_TextBox.sendKeys(twoFactorCode);
			System.out.println("value fetched from box= "+OTP_TextBox.getAttribute("value"));
			OTP_Submit_Button.click();
			System.out.println("clicked on OTP submit button");
		}
		catch (Exception e) {
			System.out.println("no OTP screen");
			//e.printStackTrace();
		}	
	}

	//Create Request
	public void Create_New_Request()
  {
  	WebDriverWait wait01 = new WebDriverWait(driver, 180);
		wait01.until(ExpectedConditions.visibilityOf(Create_New_Request));
		
		//Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE).save(System.getProperty("user.dir") + "\\src\\test\\resources\\Screens\\IND");
  	Create_New_Request.click();
  	
  }
	//Skill Request Page
	public void Skill_Request(){
	
		WebDriverWait wait02 = new WebDriverWait(driver, 180);
		wait02.until(ExpectedConditions.visibilityOf(New_Request));
		
		New_Request.click();
		Time_Materials.click();
		//Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE).save(System.getProperty("user.dir") + "\\src\\test\\resources\\Screens\\IND");
		Continue.click();
		
	}
	
	//Select Requestor Page
	public void Select_Requestor(){
		
		
		Change_requester.click();		

		WebDriverWait wait03 = new WebDriverWait(driver, 180);
		wait03.until(ExpectedConditions.visibilityOf(goBtn));
		
		ext_Email.sendKeys("gitgupta@in.ibm.com");
		//ext_Email.sendKeys("csatestde1@c25a0161.toronto.ca.ibm.com");
		
		goBtn.click();
		
		WebDriverWait wait04 = new WebDriverWait(driver, 180);
		wait04.until(ExpectedConditions.visibilityOf(searchBtn));
		
		driver.findElement(By.linkText("Gitika Gupta")).click();
		
		WebDriverWait wait05 = new WebDriverWait(driver, 180);
		wait04.until(ExpectedConditions.visibilityOf(useReq));
		
		useReq.click();
		
				
		WebDriverWait wait06 = new WebDriverWait(driver, 180);
		wait06.until(ExpectedConditions.visibilityOf(Continue));
		
		
		 /* code to capture screenshot */
		//Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE).save(System.getProperty("user.dir") + "\\src\\test\\resources\\Screens\\IND");
		Continue.click();	
		
		
	}
	
	//JRSS
	public void Select_JRSS()
  
  {
	 
		WebDriverWait wait02 = new WebDriverWait(driver, 180);
		wait02.until(ExpectedConditions.visibilityOf(Priced_JRSS));
	 String JR = Excel.getCellValue(xlsFilePath, "Request_creation", 3, 2);
	 String SS = Excel.getCellValue(xlsFilePath, "Request_creation", 3, 3);  
 
	 //Priced_JRSS.click();	
	
  Select JRlistbox = new Select(Select_JobRole);
	JRlistbox.selectByVisibleText(JR);
	
	Select SSlistbox = new Select(Select_SkillSet);
	SSlistbox.selectByVisibleText(SS);
	
	 /* code to capture screenshot */
	//Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE).save(System.getProperty("user.dir") + "\\src\\test\\resources\\Screens\\IND");
		
		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	
	 Continue.click();
	 
  }
	
	//request details
	public void Request_detailpage()
  
  {
		WebDriverWait wait03 = new WebDriverWait(driver, 180);
		wait03.until(ExpectedConditions.visibilityOf(Project_Name));
	Project_Name.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 3, 4));
	Cust_name.sendKeys("test_Sanity_IN");
	GlobalResource_No.click();
	Govt_FederalContract.click();
	
	Project_Task_Manager_AddButton.click();
	String MainWindow=driver.getWindowHandle();

	Set<String> s1=driver.getWindowHandles();     

	Iterator<String> i1=s1.iterator();        

	while(i1.hasNext())         

	{       

	String ChildWindow=i1.next();       

	if(!MainWindow.equalsIgnoreCase(ChildWindow))           

	{           

	System.out.println("Window handler Id of Parent window= "+MainWindow);

	System.out.println("Window handler Id of Child window= "+ChildWindow);

	//Switching to Child window

	driver.switchTo().window(ChildWindow);  

	WebDriverWait wait8 = new WebDriverWait(driver, 160);

	wait8.until(ExpectedConditions.visibilityOf(Email_Id_TextBox));               

	Email_Id_TextBox.sendKeys("gitgupta@in.ibm.com");                                                                     

	GoButton.click();

	WebDriverWait wait07 = new WebDriverWait(driver, 180);

	wait07.until(ExpectedConditions.visibilityOf(Name));

	Name.click();

	WebDriverWait wait08 = new WebDriverWait(driver, 180);

	wait08.until(ExpectedConditions.visibilityOf(UseAsManager_Button));
   
	/* code to capture screenshot */

	//Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE).save(System.getProperty("user.dir") + "\\src\\test\\resources\\Screens\\IND");

	UseAsManager_Button.click();

	}       

	}

	//Switching to Parent window i.e Main Window.

	driver.switchTo().window(MainWindow);
	Client.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 3, 5));
	Brand.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 3, 6));
	Sector.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 3, 7));
	Industry.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 3, 8));
	
	Accounting_Type_I.click();
	
	
	//Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE).save(System.getProperty("user.dir") + "\\src\\test\\resources\\Screens\\IND");
	
	Continue.click();
	}
	
	//skill detail Page
	public void Skill_detailLocationpage()
	{
	WebDriverWait wait04 = new WebDriverWait(driver, 180);
	wait04.until(ExpectedConditions.visibilityOf(State_Region_Province));
  
	 
	 Select st = new Select(State_Region_Province);
		st.selectByVisibleText("Karnataka");
		
 try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
 
 Select ct = new Select(City);
	ct.selectByVisibleText("BANGALORE");
	
	
 try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
 Flowdown_yes.click();
 //Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE).save(System.getProperty("user.dir") + "\\src\\test\\resources\\Screens\\IND");
 Continue_2.click();
  }
 public boolean isAlertPresent() 
 { 
     try 
     { 
  	   driver.switchTo().alert().accept();
         return true;
     
         
     }   // try 
     catch (NoAlertPresentException Ex) 
     { 
         return false; 
     }   // catch 
 //driver.switchTo().alert().accept();
}
  
	//Skill detail skill price
	public void Skill_detail_skillpricepage()
  
  {

	    WebDriverWait wait1 = new WebDriverWait(driver, 160);
		wait1.until(ExpectedConditions.visibilityOf(Skill_Level));
		Select sl = new Select(Skill_Level);
		sl.selectByVisibleText("Band 6G");
		
//		 WebDriverWait wait2 = new WebDriverWait(driver, 160);
//		wait2.until(ExpectedConditions.visibilityOf(Price_Level));
//		Select s2 = new Select(Price_Level);
//		s2.selectByVisibleText("0-1 year");
		
//
//  ST_time.clear();
//  driver.switchTo().alert().accept();
//  ST_time.sendKeys("10");
  
  Select s3 = new Select(CoreSkill1);
	s3.selectByVisibleText("0 No Experience");
	
	Select s4 = new Select(CoreSkill2);
	s4.selectByVisibleText("1 Knowledge/some job experience");
 // ST_time.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"12");
	//Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE).save(System.getProperty("user.dir") + "\\src\\test\\resources\\Screens\\IND");
  Continue_2.click();
	
}
	//Supplier Selection Page
	public void SupplierSelectionPage()
	{
		WebDriverWait wait4 = new WebDriverWait(driver, 180);
		wait4.until(ExpectedConditions.visibilityOf(Continue));
		Primary_supp.click();
		//secondary_supp.click();
		//Deselect_All.click();
		//RadioButton_UStestVendor.click();
		Continue.click();
			
		//supplier warning page
//						WebDriverWait wait51 = new WebDriverWait(driver, 160);
//						wait51.until(ExpectedConditions.visibilityOf(Supp_JustificationText)); 
//
//						Supp_JustificationText.sendKeys("Test");
//						
//						Continue.click();
		//Summary Page
		WebDriverWait wait6 = new WebDriverWait(driver, 160);
		wait6.until(ExpectedConditions.visibilityOf(ContinueToRequestSummary));
		
		ContinueToRequestSummary.click();
		
		
		 /* code to capture screenshot */
		//Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE).save(System.getProperty("user.dir") + "\\src\\test\\resources\\Screens\\IND");
			
			try 
			{
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		
		WebDriverWait wait7 = new WebDriverWait(driver, 160);
		wait7.until(ExpectedConditions.visibilityOf(SubmitRequest));
		
		//Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE).save(System.getProperty("user.dir") + "\\src\\test\\resources\\Screens\\UK");
		//SaveasDraft.click();
		//SubmitRequest.click();
	
	}
	public static boolean isloadComplete(WebDriver driver)
	{
		return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("loaded")
				|| ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
	}
}