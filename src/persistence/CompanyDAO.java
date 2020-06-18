package persistence;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Company;
import sqlShenanigans.Xeptions;
import ui.Page;

// TODO: Auto-generated Javadoc
/**
 * The Class CompanyDAO.
 */
public class CompanyDAO{
	
	/** The tb name. */
	static String tbName="company";


/**
 * View company.
 *
 * @param con the con
 * @return the list
 * @throws SQLException the SQL exception
 */
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

/**
 * View some companies.
 *
 * @param con the con
 * @param page the page
 * @return the list
 * @throws SQLException the SQL exception
 */
public List<Company> viewSomeCompanies(Connection con, Page page) throws SQLException {
	
	 PreparedStatement pstmt = null;   
   
   Company company=null;
   List<Company> companies = new ArrayList<Company>();

   try {
       pstmt = con.prepareStatement("SELECT * FROM "+CompanyDAO.tbName+ " ORDER BY id LIMIT ? OFFSET ?");
       
       int limit=page.getAmount();
       int offset=(page.getPage()-1)*page.getAmount();
       pstmt.setInt(1, limit);
       pstmt.setInt(2, offset);
       
       
       ResultSet rs = pstmt.executeQuery();
       company=new Company();
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
       if (pstmt != null) { pstmt.close(); }
   }
   return companies;
}
}


