package TestPackage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class CleverReproduce {
	
	private List<WebElement>  buttons;
	private List<WebElement>  inputs;
	private List<WebElement>  links; 
	private int lengthbtn, lengthipt, lengthlnk, lengthtotal;
	private int[] numbers;//�����ҵ�Ԫ�ص������š�˳��Ϊ��ť����������ӡ�������������ť�����������һ�����ӣ�������ť���Ϊ012�������Ϊ34������Ϊ5
	
	public void start(List<WebElement>  _buttons, List<WebElement>  _inputs, List<WebElement>  _links){
		
		System.out.println(_buttons);
		System.out.println(_inputs);
		System.out.println(_links);
		
		//Ϊ�˷�����б�������Ƶ��Լ���˽�б���
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
	    if(cur == n){//һ�����гɹ�����
	    	WebElement ele = null;
	        for(int i = 0; i < n; i++){
	        	int index = A[i];
	        	System.out.println(index);
	        	if(index < lengthbtn){//����һ����ť���
	        		ele = buttons.get(index);
	        		ele.click();
	        	}
	        	else if((index >= lengthbtn) && (index < (lengthbtn+lengthipt))){//����һ���������
	        		ele = inputs.get(index);
	        		ele.sendKeys("�Ǻ�");//����Ӧ������Щʲô����������
	        	}
	        	else if(index >= (lengthbtn+lengthipt)){//����һ�����ӱ��
	        		ele = links.get(index);
	        		ele.click();//�����ǲ���Ҳ��click��
	        	}
	        	
	        }//end for for loop
	            
	        System.out.println();
	    }
	    else{//�ݹ�Ѱ����һ������
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
