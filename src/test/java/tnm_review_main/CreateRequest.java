package tnm_review_main;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//import io.github.bonigarcia.wdm.WebDriverManager;
import lib.Excel;
import tnm_review_GB.Step1_CreateRequest_GB;
import tnm_review_IN.Step1_CreateRequest_IN;
//import tnm_review_IND.Step1_CreateRequest_Ind;
import tnm_review_US.Step1_CreateRequest_US;

@Listeners(generics.TestNG_Listeners.class)
public class CreateRequest {

	//public static Logger log = Logger.getLogger("TnM");

	public static String xlsFilePath =System.getProperty("user.dir") + "/src/main/resources/testdata/testdata.xls";
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
		// FirefoxBinary firefoxfBinary = new FirefoxBinary();
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/geckodriver.exe");
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		// firefoxOptions.addArguments("-private");

		//firefoxOptions.setHeadless(true);
		 //firefoxOptions.setBinary(firefoxfBinary);
		// driver = new FirefoxDriver(firefoxOptions);
		driver = new FirefoxDriver(firefoxOptions);
		System.out.println("launched browser");

		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		url = Excel.getCellValue(xlsFilePath, "Login", 1, 2);
		//url="https://pesproxy051.boulder.ibm.com/procurement/csa/common/enUS/index.html";
		System.out.println("xlsFilePath is "+xlsFilePath);
                 System.out.println(" Url is "+url);
		driver.get(url); 
		System.out.println("Loaded URL in browser");
		driver.manage().window().maximize();



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
	@Test(priority=11)
	public void switching_insta() 
	{

		Step1_CreateRequest_GB insta = new Step1_CreateRequest_GB(driver);
		insta.switch_instance();

	}
	@Test(priority=12)
	public void create_req_GB() 
	{

		Step1_CreateRequest_GB req = new Step1_CreateRequest_GB(driver);
		req.Create_New_Request();

	}
	@Test(priority=13)
	public void switch_cntry() 
	{

		Step1_CreateRequest_GB cntry = new Step1_CreateRequest_GB(driver);
		cntry.switch_country();

	}	
	@Test(priority=14)
	public void skill_req_GB() 
	{

		Step1_CreateRequest_GB skillreq = new Step1_CreateRequest_GB(driver);
		skillreq.Skill_Request();

	}		
	@Test(priority=15)
	public void chang_requestor() 
	{

		Step1_CreateRequest_GB chngreq = new Step1_CreateRequest_GB(driver);
		chngreq.Change_Requestor();

	}	
	@Test(priority=16)
	public void select_requestor_GB() 
	{

		Step1_CreateRequest_GB selectreq = new Step1_CreateRequest_GB(driver);
		selectreq.Select_Requestor();

	}
	@Test(priority=17)
	public void select_jrss_GB() 
	{

		Step1_CreateRequest_GB jrss = new Step1_CreateRequest_GB(driver);
		jrss.Select_JRSS();

	}
	@Test(priority=18)
	public void req_details_GB() 
	{

		Step1_CreateRequest_GB reqdetials = new Step1_CreateRequest_GB(driver);
		reqdetials.Request_detailpage();

	}
	@Test(priority=19)
	public void loc_details_GB() 
	{

		Step1_CreateRequest_GB loc = new Step1_CreateRequest_GB(driver);
		loc.Skill_detailLocationpage();

	}
	@Test(priority=20)
	public void alert_call_GB() 
	{

		Step1_CreateRequest_GB call = new Step1_CreateRequest_GB(driver);
		call.isAlertPresent();

	}
	@Test(priority=21)
	public void rates_details_GB() throws InterruptedException 
	{

		Step1_CreateRequest_GB rate = new Step1_CreateRequest_GB(driver);
		rate.Skill_detail_skillpricepage();

	}
	@Test(priority=22)
	public void sup_slection_GB() throws InterruptedException 
	{

		Step1_CreateRequest_GB sup = new Step1_CreateRequest_GB(driver);
		sup.SupplierSelectionPage();

	}	
	@Test(priority=23)
	public void switching_inst_US() 
	{

		Step1_CreateRequest_US insta = new Step1_CreateRequest_US(driver);
		insta.switch_instance();
	}
	@Test(priority=24)
	public void create_req_US() 
	{

		Step1_CreateRequest_US req = new Step1_CreateRequest_US(driver);
		req.Create_New_Request();
	}
	@Test(priority=25)
	public void switch_cntry_US() 
	{

		Step1_CreateRequest_US cntry = new Step1_CreateRequest_US(driver);
		cntry.switch_country();
	}
	@Test(priority=26)
	public void skill_req_US() 
	{

		Step1_CreateRequest_US skillreq = new Step1_CreateRequest_US(driver);
		skillreq.Skill_Request();

	}		
	@Test(priority=27)
	public void chang_requestor_US() 
	{

		Step1_CreateRequest_US chngreq = new Step1_CreateRequest_US(driver);
		chngreq.Change_Requestor();

	}	
	@Test(priority=28)
	public void select_requestor_US() 
	{

		Step1_CreateRequest_US selectreq = new Step1_CreateRequest_US(driver);
		selectreq.Select_Requestor();

	}
	@Test(priority=29)
	public void select_jrss_US() 
	{

		Step1_CreateRequest_US jrss = new Step1_CreateRequest_US(driver);
		jrss.Select_JRSS();

	}
	@Test(priority=30)
	public void req_details_US() 
	{

		Step1_CreateRequest_US reqdetials = new Step1_CreateRequest_US(driver);
		reqdetials.Request_detailpage();

	}
	@Test(priority=31)
	public void loc_details_US() throws InterruptedException 
	{

		Step1_CreateRequest_US loc = new Step1_CreateRequest_US(driver);
		loc.Skill_detailLocationpage();

	}
	@Test(priority=32)
	public void alert_call_US() 
	{

		Step1_CreateRequest_US call = new Step1_CreateRequest_US(driver);
		call.isAlertPresent();

	}
	@Test(priority=33)
	public void rates_details_US() 
	{

		Step1_CreateRequest_US rate = new Step1_CreateRequest_US(driver);
		rate.Skill_detail_skillpricepage();

	}
	@Test(priority=34)
	public void sup_slection_US() throws InterruptedException 
	{

		Step1_CreateRequest_US sup = new Step1_CreateRequest_US(driver);
		sup.SupplierSelectionPage();

	}				

}