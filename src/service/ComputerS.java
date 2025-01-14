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
	 * @return the all computer
	 * @throws SQLException the SQL exception
	 */
	public List<Computer> getAllComputer() throws SQLException
	{
		return compDAO.viewComputer();
	
	}
	
	/**
	 * View some computer.
	 *
	 * @param pageNumber the page number
	 * @return the list
	 * @throws SQLException the SQL exception
	 */
	
	  public Computer getCompDetails(int computerID) throws SQLException {
		  return compDAO.viewCompDetails( computerID);
	  }
	  
	public Computer viewSomeComputer(Connection con, int pageNumber) throws SQLException
	{
		Page page = new Page(pageNumber);
		page.setMax(page.countDb("company"));
		page.calcPages(page.getAmount(),page.getMax());
		return compDAO.viewSomeComputer( page);
	}
	
	
	public void updateComputerName(String newName, int computerID) throws SQLException {
		compDAO.updateComputerName( newName, computerID);
	}
	
	 public int updateComputerDisc(Date intr, Date disc, int computerID)
	            throws SQLException {
		 return compDAO.updateComputerDisc( intr, disc, computerID);
	 }
	 
	 
	 public void insertComputer(String computerName, int companyID, Date intro, Date disco)
	    		throws SQLException {
		 compDAO.insertComputer( computerName, companyID, intro, disco);
	 }
	
	 public void deleteComputer(int computerID)
	            throws SQLException {
		 compDAO.deleteComputer( computerID);
	 }
	
	//TODO Add the rest of the methods from the DAO 
}
