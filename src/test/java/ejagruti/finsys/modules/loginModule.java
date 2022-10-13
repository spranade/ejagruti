package ejagruti.finsys.modules;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ejagruti.finsys.config.Startup;
import ejagruti.finsys.library.Utility;
import ejagruti.finsys.pages.homepage;
import ejagruti.finsys.pages.loginPage;
import ejagruti.finsys.results.HTMLReportGenerator;

public class loginModule  {
	
	final static Logger logger=Logger.getLogger(loginModule.class);
	//public int counter=1;
	String screenshot_path;

	/*
	
	@BeforeTest
	@Parameters({"exclude","TestCaseID"})
	public void excludeTest(String exclude, String TestCaseID)
	{
		
		
		
		
		System.out.println("~~~~"+exclude+"~~~~");
		System.out.println("~~~~"+TestCaseID+"~~~~");
		
		if(exclude.contains(TestCaseID))
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
		    		
		    		
//		    		HTMLReportGenerator.StepDetails("SKIP",(Startup.counter++)+ " - skip testcase","skip testcase","");
//		    		System.out.println("test case skipped");
		    		
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

//		    Arrays.sort(b);
//		    for(int i=0;i<b.length;i++)
//			    System.out.println(b[i]);
//		    
//		    String[] stringNums = new String[b.length];
//		    int i = 0;
//		    while (i < b.length) {
//		        stringNums[i] = String.valueOf(b[i++]);
//		    }
//		    
//		    for(int j=0;j<b.length;j++)
//		    {
//		    	System.out.println(stringNums[j]);
//		    	if(TestCaseID.equals(stringNums[j]))
//		    		throw new SkipException("skipping this testcase-----"+TestCaseID);
//		    }
		    
		    
		
//		if(result.contains(TestCaseID))
//		{
//		throw new SkipException("skipping this testcase-----"+TestCaseID);
//		}
		
		}
	}
	
	
	
*/
	

	
	
	
	@Test
	@Parameters({"loginusername","loginpassword"})
	public void login(String loginusername, String loginpassword) throws Exception
	{
	
		
		loginPage lp = new loginPage(Startup.wd);
		lp.verifyloginPage();
		lp.EnterUserName(loginusername);
		lp.enterPassword(loginpassword);
		lp.clickLoginButton();
		
		Thread.sleep(5000);
		homepage hm = new homepage(Startup.wd);
		String title = hm.verifytitle();
		
		screenshot_path=Utility.captureScreenshot(Startup.wd, "verifytitle");
		
		if(title.equalsIgnoreCase("FinSys (SBDC) - eJagruti Educational Services"))
		{
			System.out.println("Title is verified : "+title);
			logger.info("Title is verified : "+title);
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Title is verified successfully: "+title+"","Application title should be correct ",""+screenshot_path+"");
		}
		else
		{
			System.out.println("Title is not correct");
			logger.error("Title is not correct");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Title is not verified : "+title+"","Application title should be correct ",""+screenshot_path+"");
		}
		
		
		String heading=hm.verifypageheading();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "verifypageheading");
		
		if(heading.equalsIgnoreCase("Welcome dummy[FM]"))
		{
			System.out.println("Heading is correct : "+heading);
			logger.info("Heading is correct : "+heading);
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Heading is correct: "+heading+"","Application should be on the Home Page after performing Login Operation ",""+screenshot_path+"");
		}
		else
		{
			System.out.println("Heading is not correct");
			logger.error("Heading is not correct");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Heading is not correct: "+heading+"","Application should be on the Home Page after performing Login Operation ",""+screenshot_path+"");
		}
		Thread.sleep(5000);
		
		screenshot_path=Utility.captureScreenshot(Startup.wd, "checkLogoutLink");
		
		if(hm.checkLogoutLink()==true)
		{
			System.out.println("Logout link is displayed");
			logger.info("Logout link is displayed");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Logout link is displayed","Logout link should be displayed ",""+screenshot_path+"");
		}
		else
		{
			System.out.println("Logout link is not displayed");
			logger.error("Logout link is not displayed");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Logout link is not displayed"," Logout link should be displayed",""+screenshot_path+"");
		}
	}




}
