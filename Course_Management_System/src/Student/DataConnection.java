package Student;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnection  {
	private String username = "root";
	private String password = "9563";
	private String url      = "jdbc:mysql://localhost:3306/student";
	
	static final String Driver_class = "com.mysql.cj.jdbc.Driver";
  private Connection connect;

  public DataConnection () {
    try {
      // Step 1: Load the JDBC driver
      Class.forName(Driver_class);

      // Step 2: Establish the connection to the database
      connect = DriverManager.getConnection(url, username,password);
      
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

  public Connection getConnection() {
    return connect;
  }
  
	
	  public static void main(String args[]) {
	  
	 System.out.print(new DataConnection ().getConnection());
	  
	 System.out.println("\nHello working !"); }
	 
}