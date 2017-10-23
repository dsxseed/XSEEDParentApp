package Testing;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Capability {

	 public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException { 	
		
		File f = new File("src/main/java");
		File fs =new File(f,"ParentApp-0.5-QAv3.apk");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus5A25");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement> (new URL("http://127.0.0.1:4723/wd/hub"),cap);
		return driver;
	}

}
