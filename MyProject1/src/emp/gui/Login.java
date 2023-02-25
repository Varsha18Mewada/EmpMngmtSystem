
package emp.gui;
import emp.dbutil.DBConnection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class Login extends JFrame implements ActionListener{
    JTextField txtuser;
     JTextField txtpass;
    Login()
    {
      getContentPane().setBackground(Color.WHITE);
     setLayout(null);
     
     JLabel lbluser=new JLabel("Username");
     lbluser.setBounds(40,30,120,30);
     add(lbluser);
      JLabel lblpass=new JLabel("Password");
     lblpass.setBounds(40,80,120,30);
     add(lblpass);
     
     txtuser=new JTextField();
     txtuser.setBounds(170,30,120,30);
     add(txtuser);
      txtpass=new JTextField();
     txtpass.setBounds(170,80,120,30);
     add(txtpass);
     
      JButton login=new JButton("LOGIN");
    login.setBounds(170,160,120,30);
   login.setBackground(Color.BLACK);
    login.setForeground(Color.WHITE);
    login.setFont(new Font("serif",Font.PLAIN,14));
    login.addActionListener(this);
    this.add(login);
    
    ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
   Image i2= i.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
   ImageIcon i3=new ImageIcon(i2);
   JLabel image=new JLabel(i3);
   image.setBounds(300, 0, 200, 200);
   add(image);
    
      setSize(500,300);
    setLocation(450,200);
    setVisible(true);
    }
     public void actionPerformed(ActionEvent ae)
    {
        try{
        String user=txtuser.getText(); 
        String pass=txtpass.getText();
        
        DBConnection conn=new DBConnection();
        String query="select * from login where username = '"+user+"' and password = '"+pass+"'";
        
        ResultSet rs=conn.s.executeQuery(query);
        if(rs.next())
        {
            setVisible(false);
            new Home();
        }
        else{
            JOptionPane.showMessageDialog(null,"Invalid username and password" );
            setVisible(false);
        }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
     
    }
    public static void main(String[] args) {
        new Login();
    }
}