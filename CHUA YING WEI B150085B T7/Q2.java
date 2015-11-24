/**
 * @(#)Q2.java
 *
 *
 * @CHUA YING WEI
 * @version 1.00 2015/11/10
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.Date;

public class Q2 extends JFrame{
        
 	String name,hp,address;
	Date d=new Date();
  	
    public Q2(){

    	
    	JMenuBar menubar=new JMenuBar();
    	JMenu menu=new JMenu("Menu");
    	JMenuItem item1=new JMenuItem("Create personal detail");
    	JMenuItem item2=new JMenuItem("Display personal detail");
    	JMenuItem item3=new JMenuItem("Exit");
    	
    	menu.add(item1);
    	menu.add(item2);//item into menu
    	menu.addSeparator();
    	menu.add(item3);
    	menubar.add(menu);//menu into menubar
    	setJMenuBar(menubar);//menubar into jframe
    	
    	item1.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    		
    		name=JOptionPane.showInputDialog(null,"Name: ","Fill your Info",JOptionPane.INFORMATION_MESSAGE);
    		hp=JOptionPane.showInputDialog(null,"HP: ","Fill your Info",JOptionPane.INFORMATION_MESSAGE);
    		address=JOptionPane.showInputDialog(null,"Address: ","Fill your Info",JOptionPane.INFORMATION_MESSAGE);
    		
    		try{
    		
    		FileWriter writer=new FileWriter("name.txt");
			BufferedWriter output=new BufferedWriter(writer);
				
				output.write("Name:  "+name);
				output.newLine();
				output.write("HP:  "+hp);
				output.newLine();
				output.write("Address:  "+address);
				output.close();
    		}catch(IOException ioex){
    			ioex.printStackTrace();
    		}
				
    		}//end
    	});
    	
    	item2.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    		try{
    			FileReader reader=new FileReader("name.txt");
				BufferedReader input=new BufferedReader(reader);
				
				String line=input.readLine();
				System.out.println("//////INFO///////");
				System.out.println();
				while(line!=null){
				
				System.out.println(line);
				
				line=input.readLine();
				
				}//end while
				input.close();
    		}catch(IOException ioex){
    			JOptionPane.showMessageDialog(null,"No Record","Error",JOptionPane.ERROR_MESSAGE);
    		}
    		}//end
    	});
    	
    	item3.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    		System.out.println();
    		System.out.println("System Exit at "+d);
    		System.exit(0);
    		}//end
    	});
    } 
    
    public static void main(String[] args){
    
    	
      Q2 f=new Q2();
      f.setSize(300,100);
      f.setTitle("Question 2");
      f.setLocationRelativeTo(null);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     // f.setResizable(false);
      f.setVisible(true);
    }
}
