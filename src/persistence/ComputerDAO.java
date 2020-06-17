package persistence;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Computer;

import sqlShenanigans.Xeptions;
import ui.Page;

public class ComputerDAO {
	static String tbName="computer";

	
	public List<Computer> viewComputer(Connection con) throws SQLException {
		
		    Statement stmt = null;
		    String query =
		        "select id, name, company_id from "+ ComputerDAO.tbName;
		    Computer computer=null;
		    List<Computer> computers = new ArrayList<Computer>();

		    try {
		        stmt = con.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        computer=new Computer();
		        while (rs.next()) {
		        	computer.setId(rs.getInt("id"));
		        	computer.setName(rs.getString("name"));
		        	computers.add(computer);
		            String computerName = rs.getString("name");
		            int ID = rs.getInt("id");
		            int companyID = rs.getInt("company_id");
		            System.out.println(computerName + "\t" + ID +
		                               "\t" + companyID);
		        }
		    } catch (SQLException e ) {
		        Xeptions.printSQLException(e);
		    } finally {
		        if (stmt != null) { stmt.close(); }
		    }
		    return computers;
	}
	
	
	
	public List<Computer> viewSomeComputer(Connection con, Page page) throws SQLException {
		
		 PreparedStatement pstmt = null;   
	    
	    Computer computer=null;
	    List<Computer> computers = new ArrayList<Computer>();

	    try {
	        pstmt = con.prepareStatement("SELECT * FROM "+ComputerDAO.tbName+ " ORDER BY id LIMIT ? OFFSET ?");
	        
	        int limit=page.getAmount();
	        int offset=(page.getPage()-1)*page.getAmount();
	        pstmt.setInt(1, limit);
	        pstmt.setInt(2, offset);
	        
	        
	        ResultSet rs = pstmt.executeQuery();
	        computer=new Computer();
	        while (rs.next()) {
	        	computer.setId(rs.getInt("id"));
	        	computer.setName(rs.getString("name"));
	        	computers.add(computer);
	            String computerName = rs.getString("name");
	            int ID = rs.getInt("id");
	            int companyID = rs.getInt("company_id");
	            System.out.println(computerName + "\t" + ID +
	                               "\t" + companyID);
	        }
	    } catch (SQLException e ) {
	        Xeptions.printSQLException(e);
	    } finally {
	        if (pstmt != null) { pstmt.close(); }
	    }
	    return computers;
}
	
	
    public static void updateComputerName(Connection con,String newName, int computerID)
        throws SQLException {

        PreparedStatement pstmt = null;   
      
        try {
         

            pstmt = con.prepareStatement(
                        "UPDATE computer SET name=? WHERE id=?");

            pstmt.setString(1, newName);
            pstmt.setInt(2, computerID);
            pstmt.executeUpdate();
        }
        finally {
            if (pstmt != null) pstmt.close();
        }
    }
    
    public static void updateComputerDisc(Connection con,Date date, int computerID)
            throws SQLException {

            PreparedStatement pstmt = null;   
          
            try {
             

                pstmt = con.prepareStatement(
                            "UPDATE computer SET discontinued=? WHERE id=?");

                pstmt.setDate(1, date);
                pstmt.setInt(2, computerID);
                pstmt.executeUpdate();
            }
            finally {
                if (pstmt != null) pstmt.close();
            }
        }
    
    
    public static void insertComputer(Connection con,String computerName, int companyID, Date intro, Date disco)
    		throws SQLException {

    		Statement stmt=null;
    		try {
    		stmt = con.createStatement(
    		ResultSet.TYPE_SCROLL_SENSITIVE,
    		ResultSet.CONCUR_UPDATABLE);

    		ResultSet uprs = stmt.executeQuery(
    		"SELECT * FROM " + tbName);

    		uprs.moveToInsertRow();
    		uprs.updateString("NAME", computerName);
    		uprs.updateInt("COMPANY_ID", companyID);
    		uprs.updateDate("INTRODUCED", intro);
    		uprs.updateDate("DISCONTINUED", disco);
    		//uprs.updateInt("ID", computerID);

    		uprs.insertRow();
    		uprs.beforeFirst();
    		} catch (SQLException e ) {
    		Xeptions.printSQLException(e);
    		} finally {
    		if (stmt != null) { stmt.close(); 
    					}}}
    
    public static void deleteComputer(Connection con,int computerID)
            throws SQLException {
      
            PreparedStatement pstmt = null;   
          
            try {
                

                pstmt = con.prepareStatement(
                            "DELETE FROM computer WHERE id =?");
            		//		"DELETE FROM "+tbName+ "WHERE id =?");

                pstmt.setInt(1, computerID);
                pstmt.executeUpdate();
            }
            finally {
                if (pstmt != null) pstmt.close();
            }
        }
    

    public Computer viewCompDetails(Connection con,int computerID) throws SQLException {

       
        PreparedStatement pstmt = null;   
        Computer computer=null;
        try {

            pstmt = con.prepareStatement(
            			"SELECT id, name, introduced, discontinued, company_id FROM computer WHERE id=? ");
                   //     "SELECT id, name, introduced, discontinued, company_id FROM "+tbName +"WHERE id=? ");

            pstmt.setInt(1, computerID); 
    	        ResultSet rs = pstmt.executeQuery();
    	        
    	        computer = new Computer();
    	        while (rs.next()) {
    	        	computer.setId(rs.getInt("id"));
    				computer.setName(rs.getString("name"));
    				computer.setIntro(rs.getDate("introduced"));
    				computer.setDisco(rs.getDate("discontinued"));
    	        	computer.setC_Id(rs.getInt("id"));
    	        	
    	        	
    	        	String computerName = rs.getString("name");
    	            int ID = rs.getInt("id");
    	            int companyID = rs.getInt("company_id");
    	            Date in=rs.getDate("introduced");
    	            Date di=rs.getDate("discontinued");
    	            System.out.println(ID + "\t" + computerName + "\t" + 
    	                               "\t" + in + "\t" + di + "\t" + companyID);
    	   
    	        				}
        }
        finally {
            if (pstmt != null) pstmt.close();
        }
        return computer;
 }
    
}