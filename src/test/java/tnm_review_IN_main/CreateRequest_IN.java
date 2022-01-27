package tnm_review_IN_main;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import io.github.bonigarcia.wdm.WebDriverManager;
import lib.Excel;
import tnm_review_IN.Step1_CreateRequest_IN;


public class CreateRequest_IN {
	
	//public static Logger log = Logger.getLogger("TnM");

	public static String xlsFilePath =System.getProperty("user.dir") + "\\src\\main\\resources\\testdata\\testdata.xls";
	//public static String xlsFilePath = System.getProperty("./src/TnM_Review_Core/src/main/resources/testdata/testdata.xls");
	public String sheet="Login"; 
	public String url;
	public String id;
	public String paswd;
	public String id_green;
	public String paswd_green;
	public String url_green;
	public String url2;

	public WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		 FirefoxBinary firefoxfBinary = new FirefoxBinary();
	       System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/geckodriver.exe");
	       FirefoxOptions firefoxOptions = new FirefoxOptions();
	      // firefoxOptions.addArguments("-private");
	       
		  //firefoxOptions.setHeadless(true);
		   //firefoxOptions.setBinary(firefoxfBinary);
	        driver = new FirefoxDriver(firefoxOptions);
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		url = Excel.getCellValue(xlsFilePath, "Login", 1, 2);
		
	      
		driver.get(url); 
		driver.manage().window().maximize();
		System.out.println("launching browser");

		
	}	

  @Test(priority=0)
	public void RIPC_Login() throws IOException, InterruptedException 
	{

	  Step1_CreateRequest_IN login = new Step1_CreateRequest_IN(driver);
		login.login();
	}
  @Test(priority=1)
 	public void create_req() 
 	{

	  Step1_CreateRequest_IN req = new Step1_CreateRequest_IN(driver);
		req.Create_New_Request();
 	}
 
  @Test(priority=2)
	public void skill_req() 
	{

	  Step1_CreateRequest_IN skillreq = new Step1_CreateRequest_IN(driver);
		skillreq.Skill_Request();
		
	}		
 	
   @Test(priority=4)
	public void select_requestor() 
	{

	Step1_CreateRequest_IN selectreq = new Step1_CreateRequest_IN(driver);
	  selectreq.Select_Requestor();
		
	}
@Test(priority=5)
	public void select_jrss() 
	{

	Step1_CreateRequest_IN jrss = new Step1_CreateRequest_IN(driver);
		jrss.Select_JRSS();
		
	}
@Test(priority=6)
	public void req_details() 
	{

	Step1_CreateRequest_IN reqdetials = new Step1_CreateRequest_IN(driver);
	  reqdetials.Request_detailpage();
		
	}
@Test(priority=7)
	public void loc_details() 
	{

	Step1_CreateRequest_IN loc = new Step1_CreateRequest_IN(driver);
		loc.Skill_detailLocationpage();
		
	}
@Test(priority=8)
	public void alert_call() 
	{

	Step1_CreateRequest_IN call = new Step1_CreateRequest_IN(driver);
	   call.isAlertPresent();
		
	}
@Test(priority=9)
	public void rates_details() 
	{

	Step1_CreateRequest_IN rate = new Step1_CreateRequest_IN(driver);
	   rate.Skill_detail_skillpricepage();
		
	}
@Test(priority=10)
	public void sup_slection() 
	{

	Step1_CreateRequest_IN sup = new Step1_CreateRequest_IN(driver);
		sup.SupplierSelectionPage();
		
	}				

}

		