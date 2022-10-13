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

public class loginPage {
	
	final static Logger logger=Logger.getLogger(loginPage.class);
	//public int counter=1;
	String screenshot_path;
	public loginPage(WebDriver wd) {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(wd, this);
	}
	
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Username']")
	WebElement username;
	public void EnterUserName(String loginusername)
	{
		try{
		Helper.highLightElement(Startup.wd,username);		
				
		username.sendKeys(loginusername);
		System.out.println("Username entered:"+loginusername);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "EnterUserName");
		System.out.println("===="+screenshot_path+"====");
		
			logger.info("Username entered:"+loginusername);
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "- Enter valid username "+loginusername+"","User should be able to enter valid username ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("Username entered is wrong or username not entered:"+loginusername);
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "- Entered invalid username "+loginusername+"","User should be able to enter valid username ",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH,using="//input[@type='password'][@placeholder='Password']")
	//div[2]/span/input[1]
	WebElement password;
	public void enterPassword(String loginpassword)
	{
		try{
		Helper.highLightElement(Startup.wd,password);		
			
		
		password.sendKeys(loginpassword);
		System.out.println("password entered:"+loginpassword);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "enterPassword");
		System.out.println("===="+screenshot_path+"====");
		
			logger.info("login password entered:"+loginpassword);
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "- Enter valid password "+loginpassword+"","User should be able to enter valid password ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("login password entered is wrong or login password is not entered: "+loginpassword);
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "- Enter invalid password "+loginpassword+"","User should be able to enter valid password ",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH,using="//div/a/span/span[contains (text(),Login)]")
	//div[4]/a
	WebElement LoginButton;
	public void clickLoginButton()
	{
		try{
		Helper.highLightElement(Startup.wd,LoginButton);		
		screenshot_path=Utility.captureScreenshot(Startup.wd, "clickLoginButton");
		LoginButton.click();
		System.out.println("Clicked Login Button");
		System.out.println("===="+screenshot_path+"====");
		
			logger.info("User clicked Login Button:");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "- Click on Login button ","User should be able to click on Login button and application should perform Login Operation ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("User failed to click Login Button:");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "- Click on Login button ","User should be able to click on Login button and application should perform Login Operation",""+screenshot_path+"");
		}
	}
	
	public void clearFields()
	{
		username.clear();
		password.clear();
	}
	
	
	public void verifyloginPage()
	{
		
		String title=Startup.wd.getTitle();
		Assert.assertEquals("SBDC - Small Business Development Co.", title);
		System.out.println("Login page is displayed");
	}
	
	@FindBy(how=How.XPATH, using="//div[@id='error']")
	WebElement errormsg;
	public void verifyErrorMessage()
	{
		String err=errormsg.getText();
		Assert.assertEquals("Please Enter Valid Username or Password!!!", err);
		System.out.println(errormsg.getAttribute("innerhtml"));
		System.out.println(errormsg.getText());
		
	}
	
}
