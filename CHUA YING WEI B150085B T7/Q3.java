/**
 * @version 1.00 2015/11/10
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
 * @(#)Q3.java
 *
 *
 * @CHUA YING WEI 
import java.io.*;
import java.util.Date;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Q3 extends JFrame{
    
    Date d=new Date();
   JTextField field1,field2,field3;
   JButton btn1,btn2,btn3;
   String f1,f2,f3;
   
    public Q3() {
    	setLayout(new GridLayout(3,3,1,1));
    	add(new JLabel("Name: "));
    	add(field1=new JTextField(10));
    	add(btn1=new JButton("Add"));
    	
    	add(new JLabel("Age: "));
    	add(field2=new JTextField(10));
    	add(btn2=new JButton("Browse"));
    	
    	add(new JLabel("Hp: "));
    	add(field3=new JTextField(10));
    	add(btn3=new JButton("Exit"));
    	
    	btn1.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    		
    		f1=field1.getText();
    		f2=field2.getText();
    		f3=field3.getText();
    		
    		try{
    		
    		FileWriter writer=new FileWriter(f1+".txt");
			BufferedWriter output=new BufferedWriter(writer);
				
				output.write(f1);
				output.newLine();
				output.write(f2);
				output.newLine();
				output.write(f3);
				output.close();
			JOptionPane.showMessageDialog(null,"Success Add!","INFO",JOptionPane.INFORMATION_MESSAGE);
			//clear after add
			field1.setText(null);
			field2.setText(null);
			field3.setText(null);
    		}catch(IOException ioex){
    			ioex.printStackTrace();
    		}
				
    		}//end
    	});
    	
    	btn2.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			JFileChooser filechooser=new JFileChooser();
    			
    			filechooser.setCurrentDirectory(new File("."));
   			    filechooser.addChoosableFileFilter(new FileNameExtensionFilter(".txt", "txt")); //use can choose txt only

    			int option=filechooser.showOpenDialog(null);
    			
    			if(option==filechooser.APPROVE_OPTION){
    				//user click  open
    			try{
    			File file = filechooser.getSelectedFile(); //get the file
    			FileReader reader=new FileReader(file);   
				BufferedReader input=new BufferedReader(reader);
				
				String line=input.readLine();
				field1.setText(line);
				line=input.readLine();
				field2.setText(line);
				line=input.readLine();
				field3.setText(line);
				
				input.close();
				}catch(IOException ioex){
    				ioex.printStackTrace();
				
    			}//end catch
    			}//end if

    		}//end
    	});
    	
    	btn3.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    		System.out.println();
    		System.out.println("System Exit at "+d);
    		System.exit(0);
    		}//end
    	});
    }
    
   
    public static void main(String[] args) {
    	
      Q3 f=new Q3();
      f.setSize(400,250);
      f.setTitle("Address Book");
      f.setLocationRelativeTo(null);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     // f.setResizable(false);
      f.setVisible(true);
    }
}
