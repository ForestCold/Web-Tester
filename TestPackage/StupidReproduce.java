package TestPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.ini4j.spi.BeanTool;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import InterfacePackage.MainInterface;
import MainPackage.TestDriver;

public class StupidReproduce {
	
	static List<String>item_list = new ArrayList<String>();
	public static TestDriver test_driver = new TestDriver();
	
	static String temp;
	static String flag;
	static String current_page;
	static String type;
	static String element;
	static String value;
	
	public static void reproduce(File test_file) throws IOException, InterruptedException{
		
		prepare(test_file);
		System.out.println(item_list);
		int index = 0;
		boolean init = true;
		
		while(index < item_list.size()){
			
				temp = item_list.get(index);

				if(temp.equals("page")){
					//打开了新的页面
					current_page = item_list.get(++index);
					if(init){
	    				test_driver.init();
	    				init = false;
					}
    		    	test_driver.loadHomeUrl(current_page);
				
				}else{
				
					//获取需要操作的元素
					type = item_list.get(++index);
					element = item_list.get(++index);
					WebElement e = findEle(type,element);
					
					switch(temp){
						case "click":{
							JavascriptExecutor js = (JavascriptExecutor)TestDriver.WDriver; 
							js.executeScript("arguments[0].click();", e);  
							break;
						}
						case "input":{
							value = item_list.get(++index);
							e.sendKeys(value);
							break;
						}
						//......		
					}
				}
				index++;
		}
		
		System.out.println("回放完成！");
		Thread.sleep(1000);
		TestDriver.WDriver.close();
		
	}
	
	//初始化
	private static void prepare(File test_file) throws IOException{
		
		FileReader fr;
		BufferedReader br;
		
		fr = new FileReader(test_file);
		br = new BufferedReader(fr);
		
		//将文件读入事件列表
		try {
			while((temp = br.readLine()) !=null ){
				item_list.add(temp);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			br.close();
			fr.close();
		}
	}
	
	//获取界面元素
	private static WebElement findEle(String type,String element){
		
		WebElement ele = null;
		
		switch(type){
			case "text":{
				System.out.println("yes");
				ele = TestDriver.WDriver.findElement(By.linkText(element));  
				break;
			}
			case "class":{
				ele = TestDriver.WDriver.findElement(By.className(element)); 
				break;
			}
			case "id":{
				ele = TestDriver.WDriver.findElement(By.id(element)); 
				break;
			}
			case "name":{
				ele = TestDriver.WDriver.findElement(By.name(element)); 
				break;
			}
			case "href":{
				String loc = "//a[@href = " + "'" + element + "'" + "]";
				ele = TestDriver.WDriver.findElement(By.xpath(loc));
				break;
			}
		}
		return ele;
	}

}
