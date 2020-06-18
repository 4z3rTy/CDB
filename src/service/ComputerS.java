package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import model.Computer;
import persistence.ComputerDAO;
import ui.Page;

// TODO: Auto-generated Javadoc
/**
 * The Class ComputerS.
 */
public class ComputerS {

/** The comp DAO. */
private ComputerDAO compDAO = new ComputerDAO();
	

	/**
	 * Gets the all computer.
	 *
	 * @param con the con
	 * @return the all computer
	 * @throws SQLException the SQL exception
	 */
	public List<Computer> getAllComputer(Connection con) throws SQLException
	{
		return compDAO.viewComputer(con);
	
	}
	
	/**
	 * View some computer.
	 *
	 * @param con the con
	 * @param pageNumber the page number
	 * @return the list
	 * @throws SQLException the SQL exception
	 */
	
	  public Computer getCompDetails(Connection con,int computerID) throws SQLException {
		  return compDAO.viewCompDetails(con, computerID);
	  }
	  
	public Computer viewSomeComputer(Connection con, int pageNumber) throws SQLException
	{
		Page page = new Page(pageNumber);
		page.setMax(page.countDb(con,"company"));
		page.calcPages(page.getAmount(),page.getMax());
		return compDAO.viewSomeComputer(con, page);
	}
	
	
	public void updateComputerName(Connection con,String newName, int computerID) throws SQLException {
		compDAO.updateComputerName(con, newName, computerID);
	}
	
	 public int updateComputerDisc(Connection con,Date intr, Date disc, int computerID)
	            throws SQLException {
		 return compDAO.updateComputerDisc(con, intr, disc, computerID);
	 }
	 
	 
	 public void insertComputer(Connection con,String computerName, int companyID, Date intro, Date disco)
	    		throws SQLException {
		 compDAO.insertComputer(con, computerName, companyID, intro, disco);
	 }
	
	 public void deleteComputer(Connection con,int computerID)
	            throws SQLException {
		 compDAO.deleteComputer(con, computerID);
	 }
	
	//TODO Add the rest of the methods from the DAO 
}
