package ejagruti.finsys.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ejagruti.finsys.config.Startup;
import ejagruti.finsys.library.excludeTestCase;
import ejagruti.finsys.results.HTMLReportGenerator;

public class TestCaseListener implements ITestListener {

	public String TestCaseID=null;
	public String exclude=null;
	
	public void onFinish(ITestContext test) {
		// TODO Auto-generated method stub
		
		System.out.println("on Finish-----"+test.getName());
		
		HTMLReportGenerator.TestCaseEnd();
		
	}
	
	
//	public void onStartExclude(String exclude, String TestCaseID){
//		
//		excludeTestCase ex = new excludeTestCase();
//		ex.excludeTest(exclude, TestCaseID);
//	}

	
	
	public void onStart(ITestContext test) {
		// TODO Auto-generated method stub
		
		

		System.out.println("Started Context. "+ test.getName());
		System.out.println("Started Context. "+ test.getAttributeNames());
		System.out.println("context--"+test.getCurrentXmlTest());
		//System.out.println("context----"+test.getCurrentXmlTest().getParameters());
		//System.out.println("context----"+test.getCurrentXmlTest().getTestParameters());
		System.out.println("context----"+test.getCurrentXmlTest().getAllParameters().get("TestCaseID"));
		System.out.println("context----"+test.getCurrentXmlTest().getAllParameters().get("exclude"));
		System.out.println("context--"+test.getCurrentXmlTest().getAllParameters());
		System.out.println("context--"+test);
		//HTMLReportGenerator.TestCaseStart("Launch Application", "Launch Application");
		
				
		TestCaseID=test.getCurrentXmlTest().getAllParameters().get("TestCaseID");
		exclude=test.getCurrentXmlTest().getAllParameters().get("exclude");
		
		HTMLReportGenerator.TestCaseStart(test.getName(),test.getName());
		
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult test) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult test) {
		// TODO Auto-generated method stub
		
		//HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - "+test.getTestClass()+"-","skip testcase","");
		System.out.println("test case failed"+test.getTestName()+"----"+test.getTestClass()+"----"+test.getClass());
	}

	public void onTestSkipped(ITestResult test) {
		// TODO Auto-generated method stub
		
		//HTMLReportGenerator.TestCaseStart(test.getName(),test.getName());
		
		//HTMLReportGenerator.TestCaseStart("Launch Application", "Launch Application");
		
		//HTMLReportGenerator.StepDetails("SKIP",(Startup.counter++)+ " - skip testcase","skip testcase","");
		HTMLReportGenerator.StepDetails("SKIP",(Startup.counter++)+ " - "+test.getTestClass()+"-","skip testcase","");
		System.out.println("test case skipped"+test.getTestName()+"----"+test.getTestClass()+"----"+test.getClass());
	}

	public void onTestStart(ITestResult test) {
		// TODO Auto-generated method stub
		
		excludeTestCase ex = new excludeTestCase();
		ex.excludeTest(exclude, TestCaseID);

		
		String result = test.getName();
		System.out.println("\n Test started is :"+result);
		
		System.out.println("----- "+ test.getAttributeNames());
		System.out.println("----- "+ test.getTestName());
		System.out.println("----- "+ test.getParameters());
		
		if (test.getParameters().length != 0) {
			 
			String params = "";
			 
			for (Object parameter : test.getParameters()) {
			 
			params += parameter.toString() + ",";
			
			}
			System.out.println("Parameteres are :"+params);
		}
		
			
		
		//HTMLReportGenerator.TestCaseStart("Launch Application", "Launch Application");
		
	}

	public void onTestSuccess(ITestResult test) {
		// TODO Auto-generated method stub
		
		//HTMLReportGenerator.TestCaseStart(test.getName(),test.getName());
		
		//HTMLReportGenerator.TestCaseStart("Launch Application", "Launch Application");
		
	}

	
	
}
