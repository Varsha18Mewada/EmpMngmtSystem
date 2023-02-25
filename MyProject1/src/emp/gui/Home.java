
package emp.gui;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Home extends JFrame implements ActionListener{
     JButton addemp;
     JButton update;
      JButton view;
      JButton delete;
    public Home()
    {
       setLayout(null);
       
    ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
   Image i2= i.getImage().getScaledInstance(1000,500,Image.SCALE_DEFAULT);
   ImageIcon i3=new ImageIcon(i2);
   JLabel image=new JLabel(i3);
   image.setBounds(0, 0, 1000, 500);
   add(image);
   
    JLabel heading=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
     heading.setBounds(500,20,500,40);
    heading.setFont(new Font("Raleway",Font.BOLD,25));
    heading.setForeground(Color.BLACK);
    image.add(heading);
       
     addemp=new JButton("Add Employee");
    addemp.setFont(new Font("serif",Font.BOLD,14));
   addemp.setBounds(520,80,150,40);
   addemp.addActionListener(this);
    image.add(addemp);
    
       view=new JButton("View Employees");
     view.setFont(new Font("serif",Font.BOLD,14));
   view.setBounds(700,80,150,40);
   view.addActionListener(this);
    image.add(view);
    
      update=new JButton("Update Employee");
      update.setFont(new Font("serif",Font.BOLD,14));
   update.setBounds(520,140,150,40);
  update.addActionListener(this);
    image.add(update);
    
     delete=new JButton("Delete Employee");
     delete.setFont(new Font("serif",Font.BOLD,14));
   delete.setBounds(700,140,150,40);
   delete.addActionListener(this);
    image.add(delete);
    
        setSize(1000,550);
        setLocation(180,100);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==addemp)
        {
            setVisible(false);
            new AddEmployee();
        }else if(ae.getSource()==view)
        {
         setVisible(false);
         new ViewEmployee();
        }else if(ae.getSource()==update)
        {
           setVisible(false);
           new ViewEmployee();
        }else{
            setVisible(false);
         new RemoveEmployee();
        }
    }
    public static void main(String[] args) {
        new Home();
    }
}
