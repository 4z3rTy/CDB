package persistence;

import java.sql.Connection;
import java.sql.SQLException;

import sqlShenanigans.SqlConnector;
import ui.Page;

public class DAOTest {

	public static void main(String[] args) throws SQLException {
    	
    	SqlConnector server=SqlConnector.getInstance("root", "root");
	    Connection con=server.getCo();
	    ComputerDAO Comp= new ComputerDAO();
	    Page page=new Page();
		page.setAmount(5);
		page.setPages(1);
		int wow=-2;
    	
    	try {
    		wow=Comp.countDb(con);
    		System.out.println(wow);
    		Comp.viewSomeComputer(con, page);
	    	con.close();
		
    		}
    	catch (SQLException e) {
    			e.printStackTrace();
    							}

		}

}
