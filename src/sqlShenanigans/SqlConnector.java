package sqlShenanigans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// TODO: Auto-generated Javadoc
/**
 * The Class SqlConnector.
 */
public class SqlConnector {  // Lazy Initialization Singleton

	/** The con. */
  static Connection con;
	
	/** The instance. */
	static SqlConnector instance=null;
	
	/**
	 * Gets the single instance of SqlConnector.
	 *
	 * @param username the username
	 * @param password the password
	 * @return single instance of SqlConnector
	 */
	public static SqlConnector getInstance(String username, String password)
	{
		if(instance==null)
		{
			instance=new SqlConnector(username, password);
		}
		return instance;
	}
	
	/**
	 * Instantiates a new sql connector.
	 *
	 * @param username the username
	 * @param password the password
	 */
	private SqlConnector(String username , String password){	
	Connection con = null;
	try {
		con = DriverManager.getConnection(
		        "jdbc:mysql://localhost:3306/computer-database-db?serverTimezone=UTC",
		        username, password);
		SqlConnector.con=con;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}
	
	/**
	 * Gets the co.
	 *
	 * @return the co
	 */
	public Connection getCo()
	{
		return SqlConnector.con;
	}
	
}
	
