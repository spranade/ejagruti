package ejagruti.finsys.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ejagruti.finsys.config.Startup;
import ejagruti.finsys.library.Helper;
import ejagruti.finsys.library.Utility;
import ejagruti.finsys.results.HTMLReportGenerator;

public class homepage {

	final static Logger logger=Logger.getLogger(homepage.class);
	//public int counter=1;
	String screenshot_path;
	public homepage(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}


	@FindBy(how=How.XPATH,using="//a[@title='Manage Company']")
	WebElement managecompanylink;
	public void clickManageCompany()
	{
		try{
		Helper.highLightElement(Startup.wd,managecompanylink);	
		
		managecompanylink.click();
		System.out.println("Clicked Manage Company link");
		
		screenshot_path=Utility.captureScreenshot(Startup.wd, "clickManageCompany");
		//image= logger.addScreenCapture(screenshot_path);
		//logger.log(LogStatus.INFO, "image3", image);
		
		
			logger.info("User clicked Manage Company link:");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Click Manage Company link ","User should be able to Click on Manage Company Sub Node and application will populate Manage Company Panel in the Middle of the Home Page by showing recently added top 10 Companies created by the logged in user ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("User failed to click Manage Company link:");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Click Manage Company link ","User should be able to Click on Manage Company Sub Node and application will populate Manage Company Panel in the Middle of the Home Page by showing recently added top 10 Companies created by the logged in user ",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH, using="//div/a[contains (text(),'LOGOUT')]")
	WebElement logoutLink;
	public void clicklogoutLink()
	{
		try{
		Helper.highLightElement(Startup.wd,logoutLink);	
		
		logoutLink.click();
		System.out.println("logout successfully");
		screenshot_path=Utility.captureScreenshot(Startup.wd, "clicklogoutLink");
		
			logger.info("User logout successfully:");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "- Click logout link "," User should logout successfully",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("User failed to logout :");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "- Click logout link ","User should logout successfully",""+screenshot_path+"");
		}
	}
	
	/*
	public void chklogout()
	{
		if(logout.isDisplayed()==true)
		{
			System.out.println("Logout link is displayed");
			
		}
		else
		{
			System.out.println("Logout link is not displayed");
		}
	}
	*/
	public boolean checkLogoutLink()
	{
		
		Helper.highLightElement(Startup.wd,logoutLink);	
		//logger.info("verifying logout link");
		return (logoutLink.isDisplayed());
	}
	
	@FindBy(how=How.XPATH,using="//div/span[contains (text(), 'Welcome dummy[FM]')]")
	WebElement pageheading;
	public String verifypageheading()
	{
		
		Helper.highLightElement(Startup.wd,pageheading);	
		
		
		//Assert.assertEquals(pageheading.getText(), "Welcome dummy[FM]", "Heading is correct");
		
		String h = pageheading.getText();		
		//System.out.println(h);
		//logger.info("verifying page heading : "+h);
		return h;	
		
	}
	
	public String verifytitle()
	{
		Assert.assertEquals(Startup.wd.getTitle(), "FinSys (SBDC) - eJagruti Educational Services", "Title is verified");
		
		String t = Startup.wd.getTitle();
		//System.out.println(t);
		return t;
		
			
	}
	
	
}
