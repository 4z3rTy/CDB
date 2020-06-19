package sqlShenanigans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// TODO: 
/**
 * The Class SqlConnector.
 */
public class SqlConnector {  // Lazy Initialization Singleton

	/** The connection. */
  private static Connection con;
	

	
	/**
	 * Gets the single instance of SqlConnector.

	 * @return single instance of SqlConnector
	 */
	public static Connection getInstance()
	{
		if(con==null)
		{
			new SqlConnector();
		}
		return con;
	}
	
	
	
	/**
	 * Instantiates a new sql connector.
	 */
	private SqlConnector(){	
		try {
			String username="root";
			String password="root";
			con = DriverManager.getConnection(
			        "jdbc:mysql://localhost:3306/computer-database-db?serverTimezone=UTC",
			        username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	

		}


	
}
	
