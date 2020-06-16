package persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import mapper.SqlShenanigans;

public class SqlTest {

	public static void main(String[] args) {
    	long millis=System.currentTimeMillis();  
        java.sql.Date intro=new java.sql.Date(millis);  
    	Date disco=new java.sql.Date(millis);
    	
    	OnCompany r= new OnCompany();
    	OnComputer s=new OnComputer();
    	SqlShenanigans server=new SqlShenanigans("root","root");
	    Connection con=server.getCo();
    	
    	try {
    		s.insertComputer(con,"XXX",42,disco,disco);
	    	//OnComputer.viewComputer(con);
	    	//OnComputer.viewCompDetails(con, 574);
	    	//OnComputer.deleteComputer(con, 666);
	    	con.close();
		
    		}
    	catch (SQLException e) {
    		// TODO Auto-generated catch block
    			e.printStackTrace();
    							}

		}

}
