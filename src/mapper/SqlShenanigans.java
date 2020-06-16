package mapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlShenanigans {

	Connection con;

	public SqlShenanigans(String username , String password){		//Make this a Singleton
	Connection con = null;
	try {
		con = DriverManager.getConnection(
		        "jdbc:mysql://localhost:3306/computer-database-db?serverTimezone=UTC",
		        username, password);
		this.con=con;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
/*
Statement stmt;
try {
	stmt = con.createStatement();

ResultSet rs = stmt.executeQuery("SELECT * FROM computer WHERE ID=42");
if(rs.next())
{
String computer=rs.getString("name");
System.out.println(computer);
}
}
		 
catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
*/
}
	public Connection getCo()
	{
		return this.con;
	}
	
}
	
