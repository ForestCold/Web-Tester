package TestPackage;

import java.io.File;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import MainPackage.TestDriver;

public class ManualRecord {
	
	public void monitor(String pagenum){
		
		//创建一个记录执行过程日志的文件
		JavascriptExecutor js = (JavascriptExecutor)TestDriver.WDriver;
		
		js.executeScript("var fso = new ActiveXObject(\"Scripting.FileSystemObject\");"
				+ ""
				+ "var tf = fso.CreateTextFile(\"D:\\\\workspaceForWindows\\\\Hanfei\\\\scriptRecords\\\\temp.txt\", true);"
				+ "tf.WriteLine(\"page\");tf.WriteLine(window.location.href);"
				+ "tf.close()"
				+ "");
				
	    record(pagenum);	
	}
	
	public void record(String pagenum){
		
		String exec = "var fso = new ActiveXObject(\"Scripting.FileSystemObject\");"
				+ ""
				+ "var tf = fso.OpenTextFile(\"D:\\\\workspaceForWindows\\\\Hanfei\\\\scriptRecords\\\\temp.txt\",8);"
				+ ""
				+ "for(var i = 0; i < arguments[0].length; i++)"
				+ "{arguments[0][i].onclick = function(){"
				+ "if(this.hasAttribute(\"id\")){tf.WriteLine(\"click\");tf.WriteLine(\"id\");tf.WriteLine(this.id)}"
				+ "else if(this.hasAttribute(\"name\")){tf.WriteLine(\"click\");tf.WriteLine(\"name\");tf.WriteLine(this.name)}"
				+ "else if(this.hasAttribute(\"class\")){tf.WriteLine(\"click\");tf.WriteLine(\"class\");tf.WriteLine(this.className)};"
				+ "}}"
				+ ""
				+ "for(var j = 0; j < arguments[1].length; j++)"
				+ "{arguments[1][j].onchange = function(){"
				+ "if(this.hasAttribute(\"id\")){tf.WriteLine(\"input\");tf.WriteLine(\"id\");tf.WriteLine(this.id);tf.WriteLine(this.value)}"
				+ "else if(this.hasAttribute(\"name\")){tf.WriteLine(\"input\");tf.WriteLine(\"name\");tf.WriteLine(this.name);tf.WriteLine(this.value)}"
				+ "else if(this.hasAttribute(\"class\")){tf.WriteLine(\"input\");tf.WriteLine(\"class\");tf.WriteLine(this.className);tf.WriteLine(this.value)};"
				+ "}}"
				+ ""
				+ "for(var k = 0; k < arguments[2].length; k++)"
				+ "{arguments[2][k].onclick = function(){"
				+ "if(this.hasAttribute(\"id\")){tf.WriteLine(\"click\");tf.WriteLine(\"id\");tf.WriteLine(this.id);}"
				+ "else if(this.hasAttribute(\"name\")){tf.WriteLine(\"click\");tf.WriteLine(\"name\");tf.WriteLine(this.name);}"
				+ "else if(this.hasAttribute(\"class\")){tf.WriteLine(\"click\");tf.WriteLine(\"class\");tf.WriteLine(this.className);}"
				+ "else{tf.WriteLine(\"click\");tf.WriteLine(\"href\");tf.WriteLine(this.href);};"
				+ "tf.WriteLine(\"page\");tf.WriteLine(this.href);"
				+ "tf.close()"
				+ "}}";
		
		int time = Integer.parseInt(pagenum);
		
		List<WebElement> buttons,inputs,links; 

		while(time > 0){
			
			System.out.println(time);

		//创建一个记录执行过程日志的文件
			JavascriptExecutor js = (JavascriptExecutor)TestDriver.WDriver;
				
			//找到可以操作的所有界面元素
			buttons = TestDriver.WDriver.findElements(By.tagName("button")); 
			inputs = TestDriver.WDriver.findElements(By.tagName("input"));
			links = TestDriver.WDriver.findElements(By.tagName("a")); 
			
			System.out.println(buttons);
			System.out.println(inputs);
			System.out.println(links);
			
			js.executeScript(exec, new Object[]{buttons,inputs,links});
			
			//停等，直到页面跳转
			String oldurl = TestDriver.WDriver.getCurrentUrl();
			while(TestDriver.WDriver.getCurrentUrl().equals(oldurl)){
			}
			
		    //让driver指向新的页面
		    String currentHandle = TestDriver.WDriver.getWindowHandle();
		    Set<String> handles = TestDriver.WDriver.getWindowHandles();
		    for(String handle:handles){
		        if(handle.equals(currentHandle))
		            continue;
		        else
		        	TestDriver.WDriver.switchTo().window(handle);
		    } 
		    time -= 1;
		}
		
		TestDriver.WDriver.close();
		System.out.println("停止录制...");
		    
	}
	
}