package TestPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import MainPackage.TestDriver;

public class ScanElement {
	
	public List<WebElement>  buttons = new ArrayList<WebElement>();
	public List<WebElement>  inputs = new ArrayList<WebElement>();
	public List<WebElement>  links = new ArrayList<WebElement>();
	
	public void set(){
		
		//…®√ËΩÁ√Ê‘™Àÿ
		buttons = TestDriver.WDriver.findElements(By.tagName("button")); 
		inputs = TestDriver.WDriver.findElements(By.tagName("input"));
		links = TestDriver.WDriver.findElements(By.tagName("a"));

	}

}
