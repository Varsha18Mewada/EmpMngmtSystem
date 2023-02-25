
package emp.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Splash extends JFrame implements ActionListener{
   
      Splash(){
          
     getContentPane().setBackground(Color.WHITE);
     setLayout(null);
     
     
    JLabel heading=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
     heading.setBounds(80,30,1200,60);
    heading.setFont(new Font("serif",Font.PLAIN,47));
    heading.setForeground(Color.red);
    add(heading);
    
    ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
   Image i2= i.getImage().getScaledInstance(1000,500,Image.SCALE_DEFAULT);
   ImageIcon i3=new ImageIcon(i2);
   JLabel image=new JLabel(i3);
   image.setBounds(50, 90, 850, 500);
   add(image);
   
   
    JButton clickhere=new JButton("CLICK HERE TO CONTINUE");
    clickhere.setBounds(350,500,300,70);
    clickhere.setBackground(Color.BLACK);
    clickhere.setForeground(Color.WHITE);
     clickhere.setFont(new Font("serif",Font.PLAIN,14));
     clickhere.addActionListener(this);
    this.add(clickhere);
    
    setSize(950,650);
    setLocation(200,50);
    setVisible(true);
    
    while(true)
    {
        heading.setVisible(false);
        try{
            Thread.sleep(500);
        }catch(Exception e)
        {
            
        }
         heading.setVisible(true);
          try{
            Thread.sleep(500);
        }catch(Exception e)
        {
            
        }
    }
    
}
     public void actionPerformed(ActionEvent e)
    {
       setVisible(false);
       new Login();
    }
     public static void main(String[] args) {
       new Splash();
     }
}
   