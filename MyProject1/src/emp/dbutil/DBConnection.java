
package emp.dbutil;
import java.sql.*;

public class DBConnection {
    Connection conn=null;
   public  Statement s;
    public DBConnection()
    {
        String url="jdbc:mysql://localhost:3306/employeemanagementsystem";
        String username="root";
        String password="Rajput#123";
        try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                   conn=DriverManager.getConnection(url,username,password);
                   s=conn.createStatement();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            //System.out.println();
        }
    }
}
