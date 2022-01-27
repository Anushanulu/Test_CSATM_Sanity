package tnm_review_GB_main;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

//import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import io.github.bonigarcia.wdm.WebDriverManager;
import lib.Excel;
import tnm_review_GB.Step1_CreateRequest_GB;

public class CreateRequest_GB {
	
	//public static Logger log = Logger.getLogger("TnM");

	public static String xlsFilePath =System.getProperty("user.dir") + "\\src\\main\\resources\\testdata\\testdata.xls";
	//public static String xlsFilePath =System.getProperty("user.dir") + "\testdata.xls";
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
		//String url="https://pesproxy051.boulder.ibm.com/procurement/csa/common/enUS/index.html";
		//String url="https://w3south-limited-use-preprod.cpc.ibm.com/procurement/csa/common/protect/Connector.wss";
					   FirefoxBinary firefoxfBinary = new FirefoxBinary();
				       System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/geckodriver.exe");
				       //System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver");
					  
				       FirefoxOptions firefoxOptions = new FirefoxOptions();
				      // firefoxOptions.addArguments("-private");
				       
					  //firefoxOptions.setHeadless(true);
					   //firefoxOptions.setBinary(firefoxfBinary);
				        driver = new FirefoxDriver(firefoxOptions);
//		 System.setProperty("webdriver.chrome.driver", "C://Users//SriSwathiAnushaNulu//Documents//Softwares//chromedriver_win32//chromedriver.exe");
//				        driver=new ChromeDriver();
				       driver.manage().window().maximize();
				       driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
				      		
		                  
		                    url = Excel.getCellValue(xlsFilePath, sheet, 1, 2);
		                    driver.get(url);
					driver.manage().window().maximize();
					
					System.out.println("The Browser is Launched");
			
		
		    
	}	

  @Test(priority=0)
	public void RIPC_Login() throws IOException, InterruptedException, TimeoutException 
	{
	  Step1_CreateRequest_GB login = new Step1_CreateRequest_GB(driver);
		login.login();
	}	
  @Test(priority=1)
	public void switching_insta() 
	{

	  Step1_CreateRequest_GB insta = new Step1_CreateRequest_GB(driver);
	  insta.switch_instance();
		
	}
  @Test(priority=2)
	public void create_req() 
	{

	  Step1_CreateRequest_GB req = new Step1_CreateRequest_GB(driver);
	  req.Create_New_Request();
		
	}
  @Test(priority=3)
	public void switch_cntry() 
	{

	  Step1_CreateRequest_GB cntry = new Step1_CreateRequest_GB(driver);
		cntry.switch_country();
		
	}	
  @Test(priority=4)
	public void skill_req() 
	{

	  Step1_CreateRequest_GB skillreq = new Step1_CreateRequest_GB(driver);
		skillreq.Skill_Request();
		
	}		
  @Test(priority=5)
	public void chang_requestor() 
	{

	  Step1_CreateRequest_GB chngreq = new Step1_CreateRequest_GB(driver);
	  chngreq.Change_Requestor();
		
	}	
  @Test(priority=6)
	public void select_requestor() 
	{

	  Step1_CreateRequest_GB selectreq = new Step1_CreateRequest_GB(driver);
	  selectreq.Select_Requestor();
		
	}
  @Test(priority=7)
	public void select_jrss() 
	{

	  Step1_CreateRequest_GB jrss = new Step1_CreateRequest_GB(driver);
		jrss.Select_JRSS();
		
	}
  @Test(priority=8)
	public void req_details() 
	{

	  Step1_CreateRequest_GB reqdetials = new Step1_CreateRequest_GB(driver);
	  reqdetials.Request_detailpage();
		
	}
  @Test(priority=9)
	public void loc_details() 
	{

	  Step1_CreateRequest_GB loc = new Step1_CreateRequest_GB(driver);
		loc.Skill_detailLocationpage();
		
	}
  @Test(priority=10)
 	public void alert_call() 
 	{

 	  Step1_CreateRequest_GB call = new Step1_CreateRequest_GB(driver);
	   call.isAlertPresent();
 		
 	}
  @Test(priority=11)
 	public void rates_details() throws InterruptedException 
 	{

 	  Step1_CreateRequest_GB rate = new Step1_CreateRequest_GB(driver);
	   rate.Skill_detail_skillpricepage();
 		
 	}
  @Test(priority=12)
 	public void sup_slection() throws InterruptedException 
 	{

 	  Step1_CreateRequest_GB sup = new Step1_CreateRequest_GB(driver);
		sup.SupplierSelectionPage();
 		
 	}				
	}
