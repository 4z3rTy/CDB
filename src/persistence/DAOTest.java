package persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import mapper.SqlConnector;

public class DAOTest {

	public static void main(String[] args) {
    	
    	SqlConnector server=SqlConnector.getInstance("root", "root");
	    Connection con=server.getCo();
	    Date d=new Date(0);
	    
    	
    	try {
    		ComputerDAO.insertComputer(con,"XXX",42,d,d);
	    	ComputerDAO.viewComputer(con);
	    	ComputerDAO.viewCompDetails(con, 574);
	    	ComputerDAO.deleteComputer(con, 666);
	    	con.close();
		
    		}
    	catch (SQLException e) {
    		// TODO Auto-generated catch block
    			e.printStackTrace();
    							}

		}

}
