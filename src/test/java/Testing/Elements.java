package Testing;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

public class Elements extends Capability {
    
	@Test
	public static void Login() throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		//WebElement m;
		//Map<WebElement,String> m1 =new HashMap<>();
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,500); 
		//driver.findElementByAndroidUIAutomator("text(\"OS\")").click();
		driver.findElementByClassName("android.widget.EditText").sendKeys("8130572556");
		//driver.findElement(By.xpath("//android.widget.TextView[@text='Enter Mobile number']")).sendKeys("8130572556");
		driver.pressKeyCode(AndroidKeyCode.BACK);
		driver.findElement(By.xpath("//android.widget.TextView[@index='2']")).click();
		Thread.sleep(2000);
		String text=driver.findElementByClassName("android.widget.TextView").getText();
		System.out.println(text);
		//confirm if we have a successful login
		//XSEED Parent App, your partner in
		//tracking your child�s performance.
		/*if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("android.widget.TextView[@text='Welcome']"))).isDisplayed()){
		System.out.println("Successful login");	
		}*/
		String Parent = driver.findElementById("com.xseed.dx.parent:id/tv_welcome_parent_name").getText();
		//String Parent = driver.findElement(By.xpath("android.widget.TextView[@index='1']")).getText();
		String Child = driver.findElementById("com.xseed.dx.parent:id/tv_welcome_child_name").getText();
		System.out.println(Parent + Child );
		driver.findElementById("com.xseed.dx.parent:id/tv_welcome_report").click();
		ReportPage.ChildInfo(driver);
		ReportPage.SubjectTab(driver);
		SkillsReport.SkillsTab(driver);
		ReportPage.Logout(driver);
		//driver.findElementById("com.xseed.dx.parent:id/tv_welcome_wrong_account").click();
/*		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		driver.findElementByClassName("android.widget.EditText").sendKeys("Hello");
		driver.findElement(By.xpath("//android.widget.Button[@index='1']")).click();
		TouchAction t = new TouchAction(driver);
		t.
		System.out.println("hello");
		driver.close();*/
	}

}
