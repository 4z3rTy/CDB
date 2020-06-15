package persistence;
import java.sql.*;

public class OnComputer {

    public static void UpdateComputerNum(int newName, int computerID)
        throws SQLException {

        Connection con = null;
        PreparedStatement pstmt = null;   
      
        try {
            con = DriverManager.getConnection(
                      "jdbc:default:connection");

            pstmt = con.prepareStatement(
                        "UPDATE COMPUTER " +
                        "SET NAME = ? " +
                        "WHERE ID = ?");

            pstmt.setInt(1, newName);
            pstmt.setInt(2, computerID);
            pstmt.executeUpdate();
        }
        finally {
            if (pstmt != null) pstmt.close();
        }
    }
    
    public static void DeleteComputer(int computerID)
            throws SQLException {

            Connection con = null;
            PreparedStatement pstmt = null;   
          
            try {
                con = DriverManager.getConnection(
                          "jdbc:default:connection");

                pstmt = con.prepareStatement(
                            "DELETE FROM COMPUTER WHERE ID = ?");

                pstmt.setInt(1, computerID);
                pstmt.executeUpdate();
            }
            finally {
                if (pstmt != null) pstmt.close();
            }
        }
    

    public static void viewCompDetails(int computerID)
        throws SQLException {

        Connection con = null;
        PreparedStatement pstmt = null;   
      
        try {
            con = DriverManager.getConnection(
                      "jdbc:default:connection");

            pstmt = con.prepareStatement(
                        "SELECT NAME, INTRODUCED, DISCONTINUED, COMPANY_ID " +
                        "WHERE ID = ?");

            pstmt.setInt(1, computerID);  //Remove ?
            pstmt.executeUpdate();
        }
        finally {
            if (pstmt != null) pstmt.close();
        }
    }
}