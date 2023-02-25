
package emp.gui;
import emp.dbutil.DBConnection;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import javax.swing.*;
public class RemoveEmployee extends JFrame implements ActionListener{
    Choice ch;
    JButton delete,back;
    public RemoveEmployee()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblempid=new JLabel("Employee Id");
        lblempid.setBounds(50,50,100,30);
        add(lblempid);
        
        ch=new Choice();
        ch.setBounds(200,50,150,30);
        add(ch);
        try{
           DBConnection conn=new DBConnection();
           String query="select * from employee";
           ResultSet rs=conn.s.executeQuery(query);
           while(rs.next())
           {
                ch.add(rs.getString("empid"));
           }
          
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(50,100,100,30);
        add(lblname);
        JLabel lblname1=new JLabel();
        lblname1.setBounds(200,100,100,30);
        add(lblname1);
        
         JLabel lblphone=new JLabel("Phone");
        lblphone.setBounds(50,150,100,30);
        add(lblphone);
        JLabel lblphone1=new JLabel();
        lblphone1.setBounds(200,150,100,30);
        add(lblphone1);
        
         JLabel lblemail=new JLabel("Email");
        lblemail.setBounds(50,200,100,30);
        add(lblemail);
        JLabel lblemail1=new JLabel();
        lblemail1.setBounds(200,200,200,30);
        add(lblemail1);
        
        try{
           DBConnection conn=new DBConnection();
           String query="select * from employee where empid = '"+ch.getSelectedItem()+"'";
           ResultSet rs=conn.s.executeQuery(query);
           while(rs.next())
           {
                lblname1.setText(rs.getString("name"));
                lblphone1.setText(rs.getString("phone"));
                lblemail1.setText(rs.getString("email"));
           }
          
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        ch.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent ie){
             try{
           DBConnection conn=new DBConnection();
           String query="select * from employee where empid = '"+ch.getSelectedItem()+"'";
           ResultSet rs=conn.s.executeQuery(query);
           while(rs.next())
           {
                lblname1.setText(rs.getString("name"));
                lblphone1.setText(rs.getString("phone"));
                lblemail1.setText(rs.getString("email"));
           }
          
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        }
        } );
        
    delete =new JButton("Delete");
    delete.setBounds(80,300,100,30);
    delete.setBackground(Color.BLACK);
    delete.setForeground(Color.WHITE);
    delete.addActionListener(this);
    add(delete);
        
     back =new JButton("Back");
    back.setBounds(220,300,100,30);
    back.setBackground(Color.BLACK);
   back.setForeground(Color.WHITE);
    back.addActionListener(this);
    add(back);
    
     ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
   Image i2= i.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
   ImageIcon i3=new ImageIcon(i2);
   JLabel image=new JLabel(i3);
   image.setBounds(300, 0, 650, 400);
   add(image);
    
        setSize(900,450);
        setLocation(150,150);
        setVisible(true);
       
    }
    public void actionPerformed(ActionEvent ae)
    {
     if(ae.getSource()==delete)
     {
      try{
         DBConnection conn=new DBConnection();
         String query="delete from employee where empid = '"+ch.getSelectedItem()+"'";
         int r=conn.s.executeUpdate(query);
         if(r==1)
         {
            JOptionPane.showMessageDialog(null,"Deleted Successfully","Success",JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);
            new Home();
         }else{
            JOptionPane.showMessageDialog(null,"Record not Deleted","Error",JOptionPane.ERROR_MESSAGE);
         }
      } catch(Exception e)
      {
       e.printStackTrace();
      }
     }else{
         setVisible(false);
         new Home();
     }
    }
    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
