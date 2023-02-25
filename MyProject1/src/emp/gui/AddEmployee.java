
package emp.gui;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import emp.dbutil.DBConnection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import javax.swing.JComboBox;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class AddEmployee extends JFrame implements ActionListener{
    JTextField txtname;
     JTextField txtfname;
     JDateChooser txtdob;
     JTextField txtsal;
     JTextField txtaddress;
     JTextField txtphone;
     JTextField txtemail;
     JComboBox txtedu;
      JTextField txtdesignation;
       JTextField txtadhar;
        JLabel txtempid;
       JButton addemp;
       JButton back; 
       Random rd=new Random();
       int number=rd.nextInt(999999);
       
    public AddEmployee()
    {
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       
    JLabel heading=new JLabel("ADD EMPLOYEE DETAIL");
   heading.setBounds(300, 20, 500, 50);
    heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
    heading.setForeground(Color.BLACK);
    add(heading);
    
    JLabel lblname=new JLabel("Name");
     lblname.setBounds(50,150,150,30);
     lblname.setFont(new Font("serif",Font.PLAIN,20));
     add(lblname);
     
     txtname=new JTextField();
     txtname.setBounds(200,150,150,30);
     add(txtname);
     
     JLabel lblfather=new JLabel("Father's Name");
     lblfather.setBounds(400,150,150,30);
     lblfather.setFont(new Font("serif",Font.PLAIN,20));
     add(lblfather);
     
     txtfname=new JTextField();
     txtfname.setBounds(600,150,150,30);
     add(txtfname);
     
      JLabel lbldob=new JLabel("Date of Birth");
     lbldob.setBounds(50,200,150,30);
     lbldob.setFont(new Font("serif",Font.PLAIN,20));
     add(lbldob);
     
     txtdob=new JDateChooser();
     txtdob.setBounds(200,200,150,30);
     add(txtdob);
     
     JLabel lblsal=new JLabel("Salary");
     lblsal.setBounds(400,200,150,30);
     lblsal.setFont(new Font("serif",Font.PLAIN,20));
     add(lblsal);
     
     txtsal=new JTextField();
     txtsal.setBounds(600,200,150,30);
     add(txtsal);
     
     JLabel lbladdress=new JLabel("Address");
    lbladdress.setBounds(50,250,150,30);
    lbladdress.setFont(new Font("serif",Font.PLAIN,20));
     add(lbladdress);
     
     txtaddress=new JTextField();
     txtaddress.setBounds(200,250,150,30);
     add(txtaddress);
     
      JLabel lblphone=new JLabel("Phone");
     lblphone.setBounds(400,250,150,30);
     lblphone.setFont(new Font("serif",Font.PLAIN,20));
     add(lblphone);
     
     txtphone=new JTextField();
     txtphone.setBounds(600,250,150,30);
     add(txtphone);
     
     JLabel lblemail=new JLabel("Email");
    lblemail.setBounds(50,300,150,30);
    lblemail.setFont(new Font("serif",Font.PLAIN,20));
     add(lblemail);
     
     txtemail=new JTextField();
     txtemail.setBounds(200,300,150,30);
     add(txtemail);
     
      JLabel lbledu=new JLabel("Highest Education");
     lbledu.setBounds(400,300,150,30);
     lbledu.setFont(new Font("serif",Font.PLAIN,20));
     add(lbledu);
     
     String courses[]={"BBA","BCA","B.COM","BTECH","MBA","MA","MTECH","MSC","BSC","PHD"};
     txtedu=new JComboBox(courses);
     txtedu.setBackground(Color.WHITE);
     txtedu.setBounds(600,300,150,30);
     add(txtedu);
     
      JLabel lbldesignation=new JLabel("Designation");
    lbldesignation.setBounds(50,350,150,30);
     lbldesignation.setFont(new Font("serif",Font.PLAIN,20));
     add(lbldesignation);
     
     txtdesignation=new JTextField();
     txtdesignation.setBounds(200,350,150,30);
     add(txtdesignation);
     
     JLabel lbladhar=new JLabel("Adhar Number");
     lbladhar.setBounds(400,350,150,30);
     lbladhar.setFont(new Font("serif",Font.PLAIN,20));
     add(lbladhar);
     
     txtadhar=new JTextField();
     txtadhar.setBounds(600,350,150,30);
     add(txtadhar);
     
      JLabel lblempid=new JLabel("Employee ID");
    lblempid.setBounds(50,400,150,30);
   lblempid.setFont(new Font("serif",Font.PLAIN,20));
     add(lblempid);
     
      txtempid=new JLabel(String.valueOf(number));
     txtempid.setBounds(200,400,150,30);
     add(txtempid);
     
      addemp=new JButton("Add Details");
    addemp.setFont(new Font("serif",Font.BOLD,14));
   addemp.setBounds(250,500,150,40);
   addemp.addActionListener(this);
     addemp.setBackground(Color.BLACK);
     addemp.setForeground(Color.WHITE);
    add(addemp);
    
     back=new JButton("Back");
     back.setFont(new Font("serif",Font.BOLD,14));
    back.setBounds(450,500,150,40);
    back.addActionListener(this);
     back.setBackground(Color.BLACK);
      back.setForeground(Color.WHITE);
    add( back);
    
    
    
    setSize(950,650);
    setLocation(200,50);
    setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        
        if(ae.getSource()==addemp)
        {
            if(!validateInput())
                {
                    JOptionPane.showMessageDialog(null, "Please input all the fields");
                    return;
                }
            try{
                
            String name=txtname.getText();
            String fname=txtfname.getText();
            String dob=((JTextField)txtdob.getDateEditor().getUiComponent()).getText();
            String sal=txtsal.getText();
            String address=txtaddress.getText();
            String phone=txtphone.getText();
            String email=txtemail.getText();
            String edu=(String)txtedu.getSelectedItem();
            String designation=txtdesignation.getText();
            String adhar=txtadhar.getText();
            String empid=txtempid.getText();
                DBConnection conn=new DBConnection();
                String query="insert into employee values('"+name+"','"+fname+"','"
                        +dob+"','"+sal+"','"+address+"','"+phone+"','"+email+" ','"+edu+"','"
                        +designation+"','"+adhar+"','"+empid+"')";
               int result= conn.s.executeUpdate(query);
                if(result==1){
                        JOptionPane.showMessageDialog(null, "Record added successfully!");
                   }
                else{
                    JOptionPane.showMessageDialog(null, "Record not added!");
                }
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }
        else{
            setVisible(false);
            new Home();
        }
    }
    private boolean validateInput() {
         String dob=((JTextField)txtdob.getDateEditor().getUiComponent()).getText();
        if(txtname.getText().isEmpty() || txtfname.getText().isEmpty()||txtsal.getText().isEmpty()
                ||dob.isEmpty() || txtaddress.getText().isEmpty() | txtphone.getText().isEmpty()
                || txtemail.getText().isEmpty() || txtdesignation.getText().isEmpty() 
               || txtadhar.getText().isEmpty() ||txtedu.getSelectedItem()==null)
            return false;
        return true;
    }
    public static void main(String[] args) {
        new AddEmployee();
    }
}
