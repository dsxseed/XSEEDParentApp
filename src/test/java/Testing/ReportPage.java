package Testing;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

public class ReportPage extends Capability{


	public static void ChildInfo(AndroidDriver<AndroidElement> d) {
		
		String ToolbarTitle = "com.xseed.dx.parent:id/tv_toolbar_title";
		String ProfilePic = "com.xseed.dx.parent:id/iv_report_profilepic";
		String ChildName = "com.xseed.dx.parent:id/tv_report_child_name";
		String ChildTestNo = "com.xseed.dx.parent:id/tv_report_testno";
		String ChildTestDate = "com.xseed.dx.parent:id/tv_report_test_date";
		
		//AndroidDriver<AndroidElement> driver = Capabilities();
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(d,500); 
		System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ToolbarTitle))).getText());
		String Name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ChildName))).getText();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ChildTestNo))).getText();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ChildTestDate))).getText();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ProfilePic)));
	}
	
	
	public static void SubjectTab(AndroidDriver<AndroidElement> d){
		
		String SubjectTab = "android.widget.TextView[@text='Subject']";
		String Subject1 = "com.xseed.dx.parent:id/tv_report_title1";
		String Subject1Marks = "com.xseed.dx.parent:id/tv_report_percent1";
		String Subject2 = "com.xseed.dx.parent:id/tv_report_title2";
		String Subject2Marks = "com.xseed.dx.parent:id/tv_report_percent2";
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(d,500); 
		//d.findElementByClassName(SubjectTab).click();
		String Sub1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Subject1))).getText();
		String Sub2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Subject2))).getText();
		String Mark1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Subject1Marks))).getText();
		String Mark2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Subject2Marks))).getText();
		System.out.println(Sub1+ " "+ Mark1+ " "+ Sub2+" "+ Mark2);
		/*"com.xseed.dx.parent:id/tv_report_rvTitle1" index =0 subject 1 for report module row heading
		"com.xseed.dx.parent:id/tv_report_rvTitle2" index =3 subject 2 for report module row heading
		"com.xseed.dx.parent:id/tv_row_report_title" index =1 will give list of modules of subject 1
		"com.xseed.dx.parent:id/tv_row_report_status" index =2 will give list of module performance of sub1
		
		"com.xseed.dx.parent:id/tv_row_report_title" index =1 will give list of modules of subject 2 // Same as subject 1
		"com.xseed.dx.parent:id/tv_row_report_status" index =2 will give list of module performance of sub2 // Same as subject 1 
		*/		
		verticalScroll(d);
		List<AndroidElement> ModuleSub1 = d.findElements(By.id("com.xseed.dx.parent:id/tv_row_report_title" ));
		int i =ModuleSub1.size();
		for (int j=0;j<i;j++){
			System.out.println(ModuleSub1.get(j).getText());
		}
		//System.out.println(ModuleSub1.toString());
		List<AndroidElement> PerformSub1 = d.findElements(By.id("com.xseed.dx.parent:id/tv_row_report_status"));
		i =PerformSub1.size();
		for (int j=0;j<i;j++){
			System.out.println(PerformSub1.get(j).getText());
		}
		
	}
	 public static void verticalScroll(AndroidDriver<AndroidElement> d)
	    {
		  	Dimension  size=d.manage().window().getSize();
	        int y_start=(int)(size.height*0.60);
	        int y_end=(int)(size.height*0.30);
	        int x=size.width/2;
	        d.swipe(x,y_start,x,y_end,4000);
	    }
	 
	public static void Logout(AndroidDriver<AndroidElement> d){
		
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(d,500); 
		d.pressKeyCode(AndroidKeyCode.BACK);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.xseed.dx.parent:id/tv_welcome_wrong_account"))).click();
	}
	
}
