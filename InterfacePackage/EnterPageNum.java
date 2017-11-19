package InterfacePackage;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import TestPackage.ManualRecord;

public class EnterPageNum extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	public static ManualRecord record_script = new ManualRecord();
	
	JButton start_rec = new JButton("开始录制");
	JTextField page_num = new JTextField();
	
	public EnterPageNum() {
		
    	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	setVisible(true);
    	setSize(200, 200); 
	    setTitle("输入页面总数");
	    
        start_rec.addActionListener(this);
        
	    Box hbox1 = Box.createHorizontalBox();
	    Box hbox2 = Box.createHorizontalBox();
	    Box vbox = Box.createVerticalBox();
	    
	    hbox1.add(start_rec);
	    hbox2.add(page_num);
	    
	    vbox.add(Box.createVerticalStrut(20));
	    vbox.add(hbox1);
	    vbox.add(Box.createVerticalStrut(20));
	    vbox.add(hbox2);
	    
	    add(vbox, BorderLayout.CENTER);
	    
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
		Object btn = evt.getSource();
		
    	if (btn == start_rec) {
    		
    		String pagenum = page_num.getText();
    		if(pagenum.length() > 0){
    			
        		this.dispose();
        		record_script.monitor(pagenum);	
        		
    		}else{
    			
    			JOptionPane.showMessageDialog(this.getContentPane(),
    					"页面数错误~！", "不行哦！", JOptionPane.ERROR_MESSAGE);
    			
    		}
    		
    	}
		
	}
	
	

}
