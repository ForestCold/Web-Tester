package MainPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestDriver {

	public static DesiredCapabilities ieCapabilities;
	public static WebDriver WDriver;
	public static Actions action;

	public void init(){
		//����driver·��
	    //�����������û��Ĭ�ϰ�װ��C�̣���Ҫ�ƶ���·��
		
	    /*
	     *System.setProperty("webdriver.firefox.bin", "D:\\workspaceForWindows\\MyTesting\\firefox.exe"); 
		 *System.setProperty("webdriver.chrome.driver","D:\\workspaceForWindows\\MyTesting\\chromedriver.exe");
		 */	

		
		//����һ��WebDriverʵ��
		//For Chrome
		  /*System.setProperty("webdriver.chrome.driver","D:\\workspaceForWindows\\MyTesting\\chromedriver.exe");
		  WDriver = new ChromeDriver();*/
		 
		
		//For IE
		System.setProperty("webdriver.ie.driver","D:\\workspaceForWindows\\Hanfei\\IEDriverServer.exe");
		ieCapabilities = DesiredCapabilities.internetExplorer();
		WDriver = new InternetExplorerDriver(ieCapabilities);
		ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		action = new Actions(WDriver);
		
	}
	
	public void loadHomeUrl(String url){
		//���ز��Խ���·��
	    WDriver.get(url);
	    WDriver.manage().window().maximize();
	}
	
}
