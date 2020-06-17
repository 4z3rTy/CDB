package mapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnector {  // Lazy Initialization Singleton

	static Connection con;
	static SqlConnector instance=null;
	public static SqlConnector getInstance(String username, String password)
	{
		if(instance==null)
		{
			instance=new SqlConnector(username, password);
		}
		return instance;
	}
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
	
	public Connection getCo()
	{
		return SqlConnector.con;
	}
	
}
	
