package ejagruti.finsys.library;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utility {

	// WebDriver driver;

	public void isElementPresent(WebElement ele, int time) {

		// WebElement ele = null;

		for (int i = 0; i < time; i++) {
			try {
				// ele=driver.findElement(By.id(id));
				// driver.findElement(ele);
				ele.isDisplayed();
				System.out.println("Element displayed" + ele);
				break;
			} catch (Exception e) {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e1) {
					System.out.println("Waiting for element to appear on DOM");
				}
			}

		}
		// return ele;

	}

	public static String captureScreenshot(WebDriver driver, String screenshotName) {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;

			File source = ts.getScreenshotAs(OutputType.FILE);

			String dest = System.getProperty("user.dir") + "\\Screenshots\\" + screenshotName + ".png";

			File destination = new File(dest);

			// FileUtils.copyFile(source, new
			// File("./Screenshots/"+screenshotName+".png"));

			FileUtils.copyFile(source, destination);

			System.out.println("Screenshot taken");
			System.out.println(dest);
			return dest;
		} catch (Exception e) {

			System.out.println("Exception while taking screenshot " + e.getMessage());
			return e.getMessage();
		}

	}
}