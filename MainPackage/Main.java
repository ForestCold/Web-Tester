package MainPackage;

import InterfacePackage.MainInterface;
import javax.swing.JFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Main {

	public static void main(String[] args) {
		
//        WebElement txtbox = Wdriver.findElement(By.name("wd"));
//        txtbox.sendKeys("Glen");
//        
//        WebElement btn = Wdriver.findElement(By.id("su"));
//        btn.click();
        
		//初始化界面
		MainInterface main_interface = new MainInterface();
		main_interface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_interface.setVisible(true);
    }
}

