package ejagruti.finsys.modules;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ejagruti.finsys.config.Startup;
import ejagruti.finsys.library.Utility;
import ejagruti.finsys.pages.ManageCompany;
import ejagruti.finsys.pages.homepage;
import ejagruti.finsys.results.HTMLReportGenerator;

public class CreateCompanyModule  {

	final static Logger logger=Logger.getLogger(CreateCompanyModule.class);
	//public int counter=1;
	String screenshot_path;
	
	//HTMLReportGenerator ext = new HTMLReportGenerator();
	
//	public void clickManageCompany()
//	{
//		
//	}
	

/*	
	
	@BeforeTest
	@Parameters({"exclude","TestCaseID"})
	public void excludeTest(String exclude, String TestCaseID)
	{
		
		
		
		
		System.out.println("~~~~"+exclude+"~~~~");
		System.out.println("~~~~"+TestCaseID+"~~~~");
		
		
		if(exclude.contains(TestCaseID))
			
			
//		{
//		throw new SkipException("skipping this testcase-----"+TestCaseID);
//		}
		
		{
		
		String[] arr = exclude.split(",");
		String finalString = null;
		String result = null;
		for(String i: arr){
	          System.out.println(i);
	          if(i.indexOf('-') > 0)
	          {
	        	    String[] dashes = i.split("-");
	                String first = dashes[0];
	                String second = dashes[1];
	                
	                for (int j = Integer.parseInt(first); j < Integer.parseInt(second) + 1; j++)
	                {
	                    finalString += Integer.toString(j) + ",";
	                   
	                }
	          }
	      }
		
		System.out.println(exclude);
		if(exclude.contains("-"))
		{
		result = exclude.replaceAll("-",",");
		}
		if (result.contains("null"))
		result = result+finalString.replaceAll("null",",");
		System.out.println(result);
		
		String[] nos = result.split(",");

		 int[] b = new int[nos.length];
		    for (int i = 0; i < nos.length; i++) {
		        b[i] = Integer.parseInt(nos[i]);
		    }

		    for(int i=0;i<b.length;i++)
		    {
		    	System.out.println(b[i]);
		    	
		    	if(Integer.parseInt(TestCaseID)==b[i])
				{
		    		
				throw new SkipException("skipping this testcase-----"+TestCaseID);
				}
		    }
		
//		    for(int i=0;i<b.length;i++)
//		    {
//		    	System.out.println(b[i]);
//		    	
//		    	if(TestCaseID==b[i])
//				{
//				throw new SkipException("skipping this testcase-----"+TestCaseID);
//				}
//		    }

		}
	}
	
	
*/	

	
	@Test
	@Parameters({"CompanyName", "CompanyType", "Subtype", "addr", "phn", "cemail", "pan", "tin", "mob", "web", "country", "state", "city", "totemp"})
	public void clickNewCompany(String CompanyName, String CompanyType, String Subtype, String addr, String phn, String cemail, String pan, String tin, String mob, String web, String country, String state, String city, String totemp) throws Exception
	{
		
		homepage hm = new homepage(Startup.wd);
		hm.clickManageCompany();
		
		//HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Click Manage Company","Click Manage Company ","");
		//Startup.wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Startup.wd.switchTo().frame(0);
		
		ManageCompany mn = new ManageCompany(Startup.wd);
		mn.clickNewbutton();
		Thread.sleep(5000);
		mn.enterCompanyName(CompanyName);
		mn.selectCompanyType(CompanyType);
		mn.selectSubtype(Subtype);
		mn.enterAddress(addr);
		mn.enterPhone(phn);
		mn.enterCompanyEmail(cemail);
		mn.enterPan(pan);
		mn.enterTin(tin);
		mn.enterMobile(mob);
		mn.enterWebsite(web);
		mn.selectCountry(country);	
		mn.selectState(state);	
		mn.selectCity(city);	
		mn.enterTotalemp(totemp);	
		mn.clickSaveButton();
		
		Thread.sleep(6000);
		String cxpath= mn.verifyCompany();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "verifyCompany");
		
		System.out.println(cxpath);
		if(cxpath.contains(CompanyName))
		{	
			System.out.println("new company added successfully : "+CompanyName);
			logger.info("new company added successfully : "+CompanyName);
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++)+ " - Check for newly created company on the Top Of displayed Company List : "+CompanyName,"User should able to see newly created company on the Top Of displayed company list ",""+screenshot_path+"");
		}
		else
		{
			System.out.println("new company not added");
			logger.info("new company not added");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+" - Check for newly created company on the Top Of displayed Company List : "+CompanyName,"User should able to see newly created company on the Top Of displayed company list ",""+screenshot_path+"");
		}
		
		Startup.wd.switchTo().defaultContent();
//		homepage hm = new homepage(Startup.wd);
		hm.clicklogoutLink();
		
		
	}


	
	
//	public void clickLogOut()
//	{
//		
//	}
	
	/*
	public static void main(String[] args) throws Exception {
		//LaunchApplication la= new LaunchApplication();
		LaunchApplication.launchApp("IE","http://server:90/finsys/login.html","E:\\selenium\\JARS\\IEDriverServer_32bit_OS.exe");
		//LaunchApplication.launchApp("Firefox","http://localhost/finsys/login.html","E:\\selenium\\JARS\\gekodriver.exe");

		loginModule lm = new loginModule();
	
		lm.login("dummyfm", "passw0rd");
		
		CreateCompanyModule cm = new CreateCompanyModule();
		//cm.clickManageCompany();
		cm.clickNewCompany("Ejagruti2020", "IT", "Service", "Warje Pune", "1234567890", "admin@ejagruti.com", "jashd234235325", "ashdg234252", "1234567890", "www.ejagruti.com", "INDIA", "MAHARASHTRA", "PUNE", "500");
		//cm.clickLogOut();
	
				
	}
	
	*/
	
	
	
}
