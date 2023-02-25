
package emp.gui;


import emp.dbutil.DBConnection;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class UpdateEmployee extends JFrame implements ActionListener{
   
     JTextField txtfname,txtedu,txtaddress,txtphone,txtsal,txtemail,txtdesignation;
  
        JLabel txtempid;
       JButton addemp;
       JButton back; 
      String empid;
       
    public UpdateEmployee(String empid)
    {
        this.empid=empid;
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       
    JLabel heading=new JLabel("UPDATE EMPLOYEE DETAIL");
   heading.setBounds(300, 20, 500, 50);
    heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
    heading.setForeground(Color.BLACK);
    add(heading);
    
    JLabel lblname=new JLabel("Name");
     lblname.setBounds(50,150,150,30);
     lblname.setFont(new Font("serif",Font.PLAIN,20));
     add(lblname);
     
      JLabel txtname=new JLabel();
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
     
      JLabel  txtdob=new JLabel();
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
     
     txtedu=new JTextField();
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
     
    JLabel txtadhar=new JLabel();
     txtadhar.setBounds(600,350,150,30);
     add(txtadhar);
     
      JLabel lblempid=new JLabel("Employee ID");
    lblempid.setBounds(50,400,150,30);
   lblempid.setFont(new Font("serif",Font.PLAIN,20));
     add(lblempid);
     
      txtempid=new JLabel();
     txtempid.setBounds(200,400,150,30);
     add(txtempid);
     
    
     
      addemp=new JButton("Update Employee Details");
    addemp.setFont(new Font("serif",Font.BOLD,14));
   addemp.setBounds(250,500,200,40);
   addemp.addActionListener(this);
     addemp.setBackground(Color.BLACK);
     addemp.setForeground(Color.WHITE);
    add(addemp);
    
     back=new JButton("Back");
     back.setFont(new Font("serif",Font.BOLD,14));
    back.setBounds(500,500,150,40);
    back.addActionListener(this);
     back.setBackground(Color.BLACK);
      back.setForeground(Color.WHITE);
    add( back);
    
    
       try{
           DBConnection conn=new DBConnection();
           String query="select * from employee where empId='"+empid+"'";
          ResultSet rs= conn.s.executeQuery(query);
          while(rs.next())
          {
              txtname.setText(rs.getString("name"));
              txtfname.setText(rs.getString("fname"));
              txtdob.setText(rs.getString("dob"));
              txtaddress.setText(rs.getString("address"));
              txtsal.setText(rs.getString("salary"));
              txtphone.setText(rs.getString("phone"));
              txtemail.setText(rs.getString("email"));
              txtedu.setText(rs.getString("education"));
              txtdesignation.setText(rs.getString("designation"));
              txtadhar.setText(rs.getString("adhar"));
              txtempid.setText(rs.getString("empid"));
          }
       }catch(Exception e)
       {
        e.printStackTrace();   
       }
    
    setSize(950,650);
    setLocation(200,50);
    setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        
        if(ae.getSource()==addemp)
        {    
            String fname=txtfname.getText();
            String sal=txtsal.getText();
            String address=txtaddress.getText();
            String phone=txtphone.getText();
            String email=txtemail.getText();
            String edu=txtedu.getText();
            String designation=txtdesignation.getText();
           
            
             try{
                DBConnection conn=new DBConnection();
                String query="update employee set fname='"+fname+"',salary='"+sal+"',address='"+address+
                        "',phone='"+phone+"',email='"+email+" ',education='"+edu+"',designation='"
                        +designation+"'where empid= '"+empid+"'";
               int result= conn.s.executeUpdate(query);
                if(result==1){
                        JOptionPane.showMessageDialog(null, "Record Updated successfully!");
                        setVisible(false);
                        new Home();
                   }
                else{
                    JOptionPane.showMessageDialog(null, "Record not Updated!");
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
    
    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}
