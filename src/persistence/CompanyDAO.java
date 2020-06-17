package persistence;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Company;
import sqlShenanigans.Xeptions;

public class CompanyDAO{
	static String tbName="company";


public List<Company> viewCompany(Connection con) throws SQLException {
	   

		    Statement stmt = null;
		    String query =
		        "select id, name from "+ tbName;
		    Company company=null;
		    List<Company> companies = new ArrayList<Company>();
	
		    try {
		        stmt = con.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        company= new Company();
		        while (rs.next()) {
		        	company.setId(rs.getInt("id"));
		        	company.setName(rs.getString("name"));
		        	companies.add(company);
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
		    
		    return companies;
}
}


