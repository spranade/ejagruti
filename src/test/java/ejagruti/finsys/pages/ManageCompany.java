package ejagruti.finsys.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import ejagruti.finsys.config.Startup;
import ejagruti.finsys.library.Helper;
import ejagruti.finsys.library.Utility;
import ejagruti.finsys.results.HTMLReportGenerator;

public class ManageCompany {
	
	final static Logger logger = Logger.getLogger(ManageCompany.class);
	//public int counter=1;
	//public String comname; 
	String screenshot_path;
	public ManageCompany(WebDriver wd) {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(wd, this);
	}
	
	
	@FindBy(how=How.XPATH,using="//span[@class='l-btn-text'][contains(text(),'New')]")
	WebElement newbutton;
	public void clickNewbutton()
	{
		try{
		Helper.highLightElement(Startup.wd,newbutton);	
		newbutton.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "clickNewbutton");		
		
			System.out.println("Clicked New button");
			logger.info("User clicked New Button:");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "- Click on New Icon which is at the Top of displayed List ","User should be able to click on New Icon present at the top of Displayed list and application will show new Company  details ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			System.out.println("Failed to click New button");
			logger.error("User failed to click New Button:");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "- Click on New Icon which is at the Top of displayed List ","User should be able to click on New Icon present at the top of Displayed list and application will show new Company  details  ",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH, using="//span/span[contains (text(),'Destroy')]")
	WebElement destroy;
	public void clickDestroy()
	{
		try{
		
		Helper.highLightElement(Startup.wd,destroy);	
		
		destroy.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "clickDestroy");
		
		
			System.out.println("Clicked Destroy button");
			logger.info("User clicked Destroy Button:");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "- Click Destroy Button ","",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			System.out.println("Failed to click Destroy button");
			logger.error("User failed to click New Button:");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "- Click Destroy Button ","",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH,using="//input[@name='name']")
	WebElement companyname;
	public void enterCompanyName(String cname)
	{
		try{
		Helper.highLightElement(Startup.wd,companyname);	
		
		companyname.sendKeys(cname);
		//comxpath="//tr[@id='datagrid-row-r1-2-0']/td/div[contains(text(),'"+cname+"')]";
		screenshot_path=Utility.captureScreenshot(Startup.wd, "enterCompanyName");
		System.out.println("company name entered : "+cname);
		logger.info("company name entered : "+cname);
	
			logger.info("Company name entered:"+cname);
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "- Enter company name "+cname+"","Company Name: Accepts any Characters in between 3 to 20 characters e.g. TCS ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("company name entered is wrong or company name not entered:"+cname);
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "- Enter company name "+cname+"","Company Name: Accepts any Characters in between 3 to 20 characters e.g. TCS ",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH,using="//select[@id='companytype']")
	WebElement companytype;
	public void selectCompanyType(String comtype)
	{
		try{
		Helper.highLightElement(Startup.wd,companytype);	
		
		Select ctype = new Select(companytype);
		ctype.selectByVisibleText(comtype);
		System.out.println("selected company type : "+comtype);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "selectCompanyType");
		
			logger.info("selected company type:"+comtype);
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "- Select company type "+comtype+"","",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("selected company type is wrong or company type not selected:"+comtype);
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "- Select company type "+comtype+"","",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH, using="//div[@id='subtype']/select[@name='subtype']")
	WebElement subtype;
	public void selectSubtype(String stype)
	{
		try{
		Helper.highLightElement(Startup.wd,subtype);	
		
		Select selsubtype = new Select(subtype);
		selsubtype.selectByVisibleText(stype);
		System.out.println("selected subtype : "+stype);		
		screenshot_path=Utility.captureScreenshot(Startup.wd, "selectSubtype");
		
			logger.info("selected company subtype:"+stype);
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "- Select company subtype "+stype+"","",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("selected company subtype is wrong or company subtype not selected:"+stype);
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "- Select company subtype "+stype+"","",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH, using="//span/textarea[@class='textbox-text validatebox-text textbox-prompt']")	
	//*[@class='dv-table']/tbody/tr[2]/td[4]/span/textarea
	WebElement address;
	public void enterAddress(String caddress)
	{
		try{
		Helper.highLightElement(Startup.wd,address);	
		
		address.sendKeys(caddress);
		System.out.println("Entered address : "+caddress);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "enterAddress");
	
			logger.info("Entered address:"+caddress);
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "- Enter address "+caddress+"","Address: Accepts any Characters upto 300 characters length",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("Entered address is wrong :"+caddress);
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "- Enter address "+caddress+"","Address: Accepts any Characters upto 300 characters length",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH, using="//table/tbody/tr[3]/td[2]/span/input[1]")
	//*[@class='dv-table']/tbody/tr[3]/td[2]/span/input[1]
	WebElement phone;
	public void enterPhone(String phn)
	{
		try{
		Helper.highLightElement(Startup.wd,phone);	
		
		phone.sendKeys(phn);
		System.out.println("Entered phone no : "+phn);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "enterPhone");
		
			logger.info("Entered phone no:"+phn);
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "- Enter phone no "+phn+"","Phone: Accepts only 10 digit number",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("Entered phone no is wrong :"+phn);
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "- Enter phone no "+phn+"","Phone: Accepts only 10 digit number",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH, using="//input[@name='email']")
	//*[@class='dv-table']/tbody/tr[3]/td[4]/input
	WebElement CompanyEmail;
	public void enterCompanyEmail(String cemail)
	{
		try{
		Helper.highLightElement(Startup.wd,CompanyEmail);	
		
		CompanyEmail.sendKeys(cemail);
		System.out.println("entered company email address : "+cemail);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "enterCompanyEmail");
		
			logger.info("entered company email address:"+cemail);
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "- Enter company email address "+cemail+"","Email: Accepts valid email format which must contains @ and . Sign",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("entered company email address is wrong :"+cemail);
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "- Enter company email address "+cemail+"","Email: Accepts valid email format which must contains @ and . Sign",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH, using="//input[@name='pan']")
	//*[@class='dv-table']/tbody/tr[4]/td[2]/input
	WebElement PAN;
	public void enterPan(String pan)
	{
		try{
		Helper.highLightElement(Startup.wd,PAN);	
		
		PAN.sendKeys(pan);
		System.out.println("entered PAN no : "+pan);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "enterPan");
		
			logger.info("entered PAN no:"+pan);
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "- Enter PAN no "+pan+"","",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("entered PAN no is wrong :"+pan);
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "- Enter PAN no "+pan+"","",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH, using="//input[@name='tin']")
	//*[@class='dv-table']/tbody/tr[4]/td[4]/input
	WebElement TIN;
	public void enterTin(String tin)
	{
		try{
		Helper.highLightElement(Startup.wd,TIN);	
		
		TIN.sendKeys(tin);
		System.out.println("entered TIN no : "+tin);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "enterTin");
		
			logger.info("entered TIN no:"+tin);
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "- Enter TIN no "+tin+"","",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("entered TIN no is wrong :"+tin);
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "- Enter TIN no "+tin+"","",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH, using="//table/tbody/tr[5]/td[2]/span/input[1]")
	//table/tbody/tr/td/span//input[@name='mobile']/ preceding-sibling:: input
	//*[@class='dv-table']/tbody/tr[5]/td[2]/span/input[1]
	WebElement mobile;
	public void enterMobile(String mob)
	{
		try{
		Helper.highLightElement(Startup.wd,mobile);	
		
		mobile.sendKeys(mob);
		System.out.println("entered mobile no : "+mob);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "enterMobile");
		
			logger.info("entered mobile no:"+mob);
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "- Enter mobile no "+mob+"","Mobile: Accepts only 10 digit number",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("entered mobile no is wrong :"+mob);
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "- Enter mobile no "+mob+"","Mobile: Accepts only 10 digit number",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH, using="//input[@name='website']")
	//*[@class='dv-table']/tbody/tr[5]/td[4]/input
	WebElement website;
	public void enterWebsite(String web)
	{
		try{
		Helper.highLightElement(Startup.wd,website);	
		
		website.sendKeys(web);
		System.out.println("entered website : "+web);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "enterWebsite");
		
			logger.info("entered website:"+web);
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "- Enter website "+web+"","",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("entered website is wrong :"+web);
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "- Enter website "+web+"","",""+screenshot_path+"");
		}
	}

	@FindBy(how=How.XPATH, using="//select[@id='countryid'][@name='countryname']")
	//*[@class='dv-table']/tbody/tr[6]/td[2]
	WebElement CountryName;
	public void selectCountry(String country)
	{
		try{
		Helper.highLightElement(Startup.wd,CountryName);	
		
		Select selcountry = new Select(CountryName);
		selcountry.selectByVisibleText(country);
		System.out.println("selected country : "+country);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "selectCountry");
		
			logger.info("selected country:"+country);
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "- Select country "+country+"","",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("selected country is wrong or country is not selected:"+country);
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "- Select country "+country+"","",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH, using="//div[@id='stateid']/select[@id='stateidlist'][@name='state']")
	//*[@class='dv-table']/tbody/tr[6]/td[4]
	WebElement StateName;
	public void selectState(String state)
	{
		try{
		Helper.highLightElement(Startup.wd,StateName);	
		
		Select selstate= new Select(StateName);
		selstate.selectByVisibleText(state);
		System.out.println("selected state : "+state);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "selectState");
		
			logger.info("selected state:"+state);
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "- Select state "+state+"","",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("selected state is wrong or state is not selected:"+state);
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "- Select state "+state+"","",""+screenshot_path+"");
		}
	}
	
	
	@FindBy(how=How.XPATH, using="//div[@id='cityid']/select[@id='citylist'][@name='city']")
	//*[@class='dv-table']/tbody/tr[7]/td[2]
	WebElement CityName;
	public void selectCity(String city)
	{
		try{
		Helper.highLightElement(Startup.wd,CityName);	
		
		Select selcity=new Select(CityName);
		selcity.selectByVisibleText(city);
		System.out.println("selected city : "+city);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "selectCity");
	
			logger.info("selected city:"+city);
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "- Select city "+city+"","",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("selected city is wrong or city is not selected:"+city);
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "- Select city "+city+"","",""+screenshot_path+"");
		}
	}
	
	
	@FindBy (how=How.XPATH, using="//table/tbody/tr[8]/td[2]/span/input[1]")
	//table/tbody/tr/td/span//input[@name='totalemployee']/ preceding-sibling:: input
	//*[@class='dv-table']/tbody/tr[8]/td[2]
	WebElement Totalemp;
	public void enterTotalemp(String tno)
	{
		try{
		Helper.highLightElement(Startup.wd,Totalemp);	
		
		Totalemp.sendKeys(tno);
		System.out.println("entered total no of employees : "+tno);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "enterTotalemp");
		
			logger.info("entered total no of employees:"+tno);
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "- Entered total no of employees "+tno+"","Total Employee: Accepts only number between 100000-999999",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("entered total no of employees is wrong :"+tno);
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "- Enter total no of employees "+tno+"","Total Employee: Accepts only number between 100000-999999",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH, using="//span[.='Save']")
	WebElement SaveButton;
	public void clickSaveButton()
	{
		try{
		Helper.highLightElement(Startup.wd,SaveButton);	
		
		SaveButton.click();
		System.out.println("clicked save button");
		screenshot_path=Utility.captureScreenshot(Startup.wd, "clickSaveButton");
		
			logger.info("User clicked save Button:");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "- Click save button ","User should be able to click on Save button and application will try to submit the given details  ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("User failed to click save Button:");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "- Click save button ","User should be able to click on Save button and application will try to submit the given details ",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH, using="//span[.='Cancel']")
	WebElement CancelButton;
	public void clickCancelButton()
	{
		try{
		Helper.highLightElement(Startup.wd,CancelButton);	
		
		CancelButton.click();
		System.out.println("clicked Cancel button");
		screenshot_path=Utility.captureScreenshot(Startup.wd, "clickCancelButton");
		
			logger.info("User clicked Cancel Button:");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "- Click Cancel button ","",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("User failed to click Cancel Button:");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "- Click Cancel button ","",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH, using="//tr[@id='datagrid-row-r1-2-0']")
	WebElement companies;
	
	public String verifyCompany()
	{
		
		Helper.highLightElement(Startup.wd,companies);		
		
		
		System.out.println( "*****"+companies.getText()+"*****");
//		logger.info("verifying comany name : "+companies.getText());
		return companies.getText();
		
//		if (companies.getText().contains(comname))
//		{
//			System.out.println("New company added successfully");
//		}
//		else
//		{
//			System.out.println("new company not added");
//		}
	}
	
}
