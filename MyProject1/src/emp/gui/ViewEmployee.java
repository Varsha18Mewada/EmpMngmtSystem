
package emp.gui;
import emp.dbutil.DBConnection;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class ViewEmployee extends JFrame implements ActionListener{
    JTable tbl;
    Choice cempid;
    
    JButton searchemp,print,update,back;
    public ViewEmployee()
    {
      getContentPane().setBackground(Color.WHITE);
     setLayout(null);
     
     JLabel  search=new JLabel("Search by Employee Id");
     search.setBounds(20,20,150,20);
     add(search);
     
     cempid=new Choice();
     cempid.setBounds(180,20,150,20);
     add(cempid);
                    try{
                       DBConnection conn=new DBConnection();
                       ResultSet rs=conn.s.executeQuery("select * from employee");
                      while(rs.next())
                       {
                           cempid.add(rs.getString("empid"));
                       }
                       }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
     tbl=new JTable();
                    try{
                       DBConnection conn=new DBConnection();
                       ResultSet rs=conn.s.executeQuery("select * from employee");
                       tbl.setModel(DbUtils.resultSetToTableModel(rs));
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
     JScrollPane jsp=new JScrollPane(tbl);
  
     jsp.setBounds(0,100,1000,600);
     add(jsp);
     
     searchemp =new JButton("Search");
      searchemp.setBounds(20,70,80,20);
      searchemp.addActionListener(this);
       searchemp.setFont(new Font("serif",Font.BOLD,14));
      searchemp.setForeground(Color.BLACK);
      add(searchemp);
      
   print =new JButton("Print");
       print.setBounds(120,70,80,20);
      print.addActionListener(this);
      print.setFont(new Font("serif",Font.BOLD,14));
      print.setForeground(Color.BLACK);
      add( print);
      
      update =new JButton("Update");
     update.setBounds(220,70,80,20);
     update.addActionListener(this);
      update.setFont(new Font("serif",Font.BOLD,14));
      update.setForeground(Color.BLACK);
      add( update);
      
      back =new JButton("Back");
      back.setBounds(320,70,80,20);
      back.addActionListener(this);
       back.setFont(new Font("serif",Font.BOLD,14));
      back.setForeground(Color.BLACK);
      add( back);
      
     setSize(1000,500);
    setLocation(200,50);
    setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
     if(ae.getSource()==searchemp)
     {
         String query="select * from employee where empid='"+ cempid.getSelectedItem()+"'";
         try{
             DBConnection conn=new DBConnection();
             ResultSet rs=conn.s.executeQuery(query);
             tbl.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e)
         {
             e.printStackTrace();
         }
     } else if(ae.getSource()==print)
     {
         try{
          tbl.print();   
         }catch(Exception e)
         {
             e.printStackTrace();
         }
       
     }else if(ae.getSource()==update)
     {
         setVisible(false);
         new UpdateEmployee(cempid.getSelectedItem());
     }
     else{
         setVisible(false);
         new Home();
     }
    }
    public static void main(String[] args) {
        new ViewEmployee();
    }
}
