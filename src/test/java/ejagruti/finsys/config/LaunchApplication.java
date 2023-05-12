package ejagruti.finsys.config;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ejagruti.finsys.library.Utility;
import ejagruti.finsys.results.HTMLReportGenerator;


public class LaunchApplication {
	
	//static int counter=1;
	Startup c= new Startup();
	static String screenshot_path;
	
/*	@BeforeTest
	@Parameters({"exclude","TestCaseID"})
	public void excludeTest(String exclude, String TestCaseID)
	{
		
		
		
		if(TestCaseID==exclude)
		{
		throw new SkipException("skipping this testcase-----"+TestCaseID);
		}
		
		
	}*/
	
	
	
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
		
	
//	@Parameters({"Browser","url","filepath"})
//	public static void launchApp(String Browser, String url,String filepath)
	@Test
	@Parameters({"Browser","url","filepath","execute_remotely"})
	public static void launchApp(String Browser, String url,String filepath, String execute_remotely)
	{
		
	try{
			if(Browser.equalsIgnoreCase("firefox"))
			{
				
				if(execute_remotely.equalsIgnoreCase("N"))
				{
				System.setProperty("webdriver.firefox.marionette",filepath);
				//System.setProperty("webdriver.geckodriver.driver",filepath);
				Startup.wd = new FirefoxDriver();
				screenshot_path=Utility.captureScreenshot(Startup.wd, "firefox");
				HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Launch the "+Browser+" Browser","Browser should get launched",""+screenshot_path+"");
				}
				else
				{
					DesiredCapabilities dc=new DesiredCapabilities("firefox", "any",org.openqa.selenium.Platform.WINDOWS);
					Startup.wd=new RemoteWebDriver(new URL("http://192.168.0.100:4444/wd/hub"),dc);
				}
			}
	}
	catch(Exception e)
	{
		HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Launch the "+Browser+" Browser","Browser should get launched",""+screenshot_path+"");
	}
			
	
	
	try{
			if(Browser.equalsIgnoreCase("chrome"))
			{
				if(execute_remotely.equalsIgnoreCase("N"))
				{
				System.setProperty("webdriver.chrome.driver",filepath);
				Startup.wd = new ChromeDriver();
				screenshot_path=Utility.captureScreenshot(Startup.wd, "chrome");
				HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Launch the "+Browser+" Browser","Browser should get launched",""+screenshot_path+"");
			
				}
				else
				{
					System.out.println("code will soon come here");
					DesiredCapabilities dc=new DesiredCapabilities("chrome", "any",org.openqa.selenium.Platform.WINDOWS);
					Startup.wd=new RemoteWebDriver(new URL("http://192.168.0.100:4444/wd/hub"),dc);
				}
			}
	}
	
	catch(Exception e)
	{
		HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Launch the "+Browser+" Browser","Browser should get launched",""+screenshot_path+"");
	}
	
	
	
	try{
			if(Browser.equalsIgnoreCase("IE"))
			{
				if(execute_remotely.equalsIgnoreCase("N"))
				{
				System.setProperty("webdriver.ie.driver",filepath);
				Startup.wd = new InternetExplorerDriver();
				screenshot_path=Utility.captureScreenshot(Startup.wd, "IE");
				HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Launch the "+Browser+" Browser","Browser should get launched",""+screenshot_path+"");
			
				}
				else
				{
					System.out.println("code will soon come here");
					DesiredCapabilities dc=new DesiredCapabilities("IE", "any",org.openqa.selenium.Platform.WINDOWS);
					Startup.wd=new RemoteWebDriver(new URL("http://192.168.0.100:4444/wd/hub"),dc);
				}
			}
	}
	catch(Exception e)
	{
		HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Launch the "+Browser+" Browser","Browser should get launched",""+screenshot_path+"");
	}
	
	
	
	
			Startup.wd.get(url);
			Startup.wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			Startup.wd.manage().window().maximize();
			Startup.wd.manage().getCookies().clear();
			screenshot_path=Utility.captureScreenshot(Startup.wd, "url");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Launch the URL of the Application","User should be able to launch the URL of the Application and application should be on the Login Page",""+screenshot_path+"");
	}

	
/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//LaunchApplication exeapl = new LaunchApplication();
		
		
		//LaunchApplication.launchApp("firefox","http://server:90/finsys/login.html","E:\\selenium\\JARS\\gekodriver.exe");
		//LaunchApplication.launchApp("chrome","http://server:90/finsys/login.html","E:\\selenium\\JARS\\chromedriver.exe");
		LaunchApplication.launchApp("IE","http://server:90/finsys/login.html","E:\\selenium\\JARS\\IEDriverServer_32bit_OS.exe");

		
	}
*/
}
