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
	    CompanyDAO any= new CompanyDAO();
	    Page page=new Page(1);
    	
    	try {
    		page.setMax(page.countDb(con,"computer"));
    		page.calcPages(page.getAmount(),page.getMax());
    		
    		Comp.viewSomeComputer(con, page);
    		page.setMax(page.countDb(con,"computer"));
    		page.calcPages(page.getAmount(),page.getMax());
    		any.viewSomeCompanies(con, page);
    		
	    	con.close();
		
    		}
    	catch (SQLException e) {
    			e.printStackTrace();
    							}

		}

}
