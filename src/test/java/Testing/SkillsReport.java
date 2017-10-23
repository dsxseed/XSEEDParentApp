package Testing;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SkillsReport extends Capability{
	
	public static void SkillsTab(AndroidDriver<AndroidElement> d){
		String SkillsTab = "//android.widget.TextView[@text='Skills']";
		String BlibRing ="com.xseed.dx.parent:id/iv_ring";
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(d,500); 
		
		String Skill1= "com.xseed.dx.parent:id/tv_report_title1";
		String Skill2= "com.xseed.dx.parent:id/tv_report_title2";
		String Skill1Perc = "com.xseed.dx.parent:id/tv_report_percent1";
		String Skill2Perc = "com.xseed.dx.parent:id/tv_report_percent2";
		String SkillModule = "com.xseed.dx.parent:id/tv_row_report_title";
		String SkillPerf = "com.xseed.dx.parent:id/tv_row_report_status";
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SkillsTab))).click();
		String Skil1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Skill1))).getText();
		String Skil2= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Skill2))).getText();
		String Skil1Perc= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Skill1Perc))).getText();
		String Skil2Perc= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Skill2Perc))).getText();
		System.out.println(Skil1+ " "+ Skil1Perc+ " "+ Skil2+" "+ Skil2Perc);
		ReportPage.verticalScroll(d);
		
		List<AndroidElement> ModuleSkill1 = d.findElements(By.id(SkillModule ));
		int i =ModuleSkill1.size();
		for (int j=0;j<i;j++){
			System.out.println(ModuleSkill1.get(j).getText());
		}
		//System.out.println(ModuleSub1.toString());
		List<AndroidElement> PerformSkill1 = d.findElements(By.id(SkillPerf));
		i =PerformSkill1.size();
		for (int j=0;j<i;j++){
			System.out.println(PerformSkill1.get(j).getText());
		}
		
		
		
	}

}
