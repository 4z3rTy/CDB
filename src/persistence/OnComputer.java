package persistence;
import java.sql.*;
import java.time.LocalDate;

public class OnComputer {
	static String tbName="computer";

	
	public static void viewComputer(Connection con)
		    throws SQLException {
		
		    Statement stmt = null;
		    String query =
		        "select id, name, company_id from "+ OnComputer.tbName;

		    try {
		        stmt = con.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        while (rs.next()) {
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
    

    public static void viewCompDetails(Connection con,int computerID)
        throws SQLException {

       
        PreparedStatement pstmt = null;   
      
        try {

            pstmt = con.prepareStatement(
            			"SELECT id, name, introduced, discontinued, company_id FROM computer WHERE id=? ");
                   //     "SELECT id, name, introduced, discontinued, company_id FROM "+tbName +"WHERE id=? ");

            pstmt.setInt(1, computerID); 
    	        ResultSet rs = pstmt.executeQuery();
    	        while (rs.next()) {
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
 }
    
}