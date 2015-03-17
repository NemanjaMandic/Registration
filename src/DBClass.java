
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class DBClass {
    Connection conn;
    private String user = "root";
    private String pass = "";
    private String url = "jdbc:mysql://localhost/computerstore";
    public DBClass() {
        try{
            
            conn = DriverManager.getConnection(url,user,pass);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public void writeToDatabase(String user, String name, String last, String gender, String email){
        try{
           Statement st = conn.createStatement();
           int s = st.executeUpdate("INSERT INTO tblLogin VALUES ('" + user + "', '" + name + "', '" + 
                   last + "', '" + gender + "', '"+email+"')");
            JOptionPane.showMessageDialog(null, "Uneto "+s+" podatka");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
