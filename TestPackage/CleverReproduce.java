package TestPackage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class CleverReproduce {
	
	private List<WebElement>  buttons;
	private List<WebElement>  inputs;
	private List<WebElement>  links; 
	private int lengthbtn, lengthipt, lengthlnk, lengthtotal;
	private int[] numbers;//所有找到元素的排序标号。顺序为按钮，输入框，链接。比如有三个按钮；两个输入框，一个链接，三个按钮标号为012，输入框为34，链接为5
	
	public void start(List<WebElement>  _buttons, List<WebElement>  _inputs, List<WebElement>  _links){
		
		System.out.println(_buttons);
		System.out.println(_inputs);
		System.out.println(_links);
		
		//为了方便把列表参数复制到自己的私有变量
		buttons = new ArrayList<WebElement>(_buttons);
		inputs =  new ArrayList<WebElement>(_inputs);
		links =  new ArrayList<WebElement>(_links);
		
		lengthbtn = buttons.size();
		lengthipt = inputs.size();
		lengthlnk = links.size();
		lengthtotal = lengthbtn + lengthipt + lengthlnk;
		
		numbers = new int[lengthtotal];
		
		execute_permutation(lengthtotal, numbers, 0);
		
	}
	
	void execute_permutation(int n, int A[], int cur){
	    if(cur == n){//一种排列成功生成
	    	WebElement ele = null;
	        for(int i = 0; i < n; i++){
	        	int index = A[i];
	        	System.out.println(index);
	        	if(index < lengthbtn){//这是一个按钮标号
	        		ele = buttons.get(index);
	        		ele.click();
	        	}
	        	else if((index >= lengthbtn) && (index < (lengthbtn+lengthipt))){//这是一个输入框标号
	        		ele = inputs.get(index);
	        		ele.sendKeys("呵呵");//这里应该输入些什么？？？？？
	        	}
	        	else if(index >= (lengthbtn+lengthipt)){//这是一个链接标号
	        		ele = links.get(index);
	        		ele.click();//链接是不是也是click？
	        	}
	        	
	        }//end for for loop
	            
	        System.out.println();
	    }
	    else{//递归寻找下一个排列
	        for(int i = 0; i < n; i++){
	            boolean ok = true;
	            for(int j = 0; j < cur; j++){
	                if(i == A[j]) ok = false;
	            }
	            if(ok){
	                A[cur] = i;
	                execute_permutation(n, A, cur+1);
	            }
	        }
	    }
	}//end for function
		
	
}//end for class
