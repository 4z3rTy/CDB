package persistence;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import mapper.Mapper;
import model.Company;
import sqlShenanigans.Xeptions;
import ui.Page;

// TODO: Auto-generated Javadoc
/**
 * The Class CompanyDAO.
 */
public class CompanyDAO{
	
	/** The table name. */
	static String tbName="company";


/**
 * View company.
 *
 * @param con the SqlConnection
 * @return The list of all companies queried
 * @throws SQLException 
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
		        while (rs.next()) {
		        	company=Mapper.map1(rs);
		        	companies.add(company);
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
 * @param con the SqlConnection
 * @param page the page number the user wishes to display
 * @return the list of all the companies
 * @throws SQLException
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
    	    company=Mapper.map1(rs);
       		companies.add(company);
       				}
   } catch (SQLException e ) {
       Xeptions.printSQLException(e);
   } finally {
       if (pstmt != null) { pstmt.close(); }
   }
   return companies;
}
}


