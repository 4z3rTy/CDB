package persistence;
import java.sql.*;

public class OnComputer {

    public static void UpdateComputerName(Connection con,String newName, int computerID)
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
    
    public static void DeleteComputer(Connection con,int computerID)
            throws SQLException {
      
            PreparedStatement pstmt = null;   
          
            try {
                

                pstmt = con.prepareStatement(
                            "DELETE FROM computer WHERE id = ?");

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
                        "SELECT id, name, introduced, discontinued, company_id FROM computer WHERE id= ?");

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
    
    public static void main(String []args)
	{
    	Connection con;
    	long millis=System.currentTimeMillis();  
        java.sql.Date intro=new java.sql.Date(millis);  
    	Date disco=new java.sql.Date(millis);
    	try {
    		con = DriverManager.getConnection(
    		        "jdbc:mysql://localhost:3306/computer-database-db?serverTimezone=UTC",
    		        "root", "root");
    	
    	String dbName="company";
    	Example r= new Example();
    	UpdateComputerName(con,"ZZZ",666);
    	viewCompDetails(con,666);
    	DeleteComputer(con,666);
    	
    	
    			
	}
    	catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
	}
}