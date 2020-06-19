package persistence;

import java.sql.Connection;
import java.sql.SQLException;

import sqlShenanigans.SqlConnector;
import ui.Page;

public class DAOTest {

	public static void main(String[] args) throws SQLException {
    	
	    Connection con=SqlConnector.getInstance();
	    ComputerDAO Comp= new ComputerDAO();
	    CompanyDAO any= new CompanyDAO();
	    Page page=new Page(1);
    	
    	try {
    		page.setMax(page.countDb("computer"));
    		page.calcPages(page.getAmount(),page.getMax());
    		
    		Comp.viewSomeComputer(page);
    		page.setMax(page.countDb("computer"));
    		page.calcPages(page.getAmount(),page.getMax());
    		any.viewSomeCompanies(page);
    		
	    	con.close();
		
    		}
    	catch (SQLException e) {
    			e.printStackTrace();
    							}

		}

}
