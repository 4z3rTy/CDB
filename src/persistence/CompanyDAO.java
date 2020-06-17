package persistence;
import java.sql.*;

public class CompanyDAO{
	static String tbName="company";


public static void viewCompany(Connection con)
	    throws SQLException {

		    Statement stmt = null;
		    String query =
		        "select id, name from "+ tbName;
	
		    try {
		        stmt = con.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        while (rs.next()) {
		            String companyName = rs.getString("name");
		            int companyID = rs.getInt("id");
		            System.out.println(companyName + "\t" 
		                           			+ companyID);
		        }
		    } catch (SQLException e ) {
		        Xeptions.printSQLException(e);
		    } finally {
		        if (stmt != null) { stmt.close(); }
		    }
		}
}
