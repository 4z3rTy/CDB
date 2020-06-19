package service;

import java.sql.SQLException;
import java.util.List;

import model.Company;
import persistence.CompanyDAO;
import sqlShenanigans.SqlConnector;
import ui.Page;

// TODO: Auto-generated Javadoc
/**
 * The Class CompanyS.
 */
public class CompanyS {

/** The any DAO. */
private CompanyDAO anyDAO = new CompanyDAO();
	

	/**
	 * Gets the all companies.
	 *
	 * @return the all companies
	 * @throws SQLException the SQL exception
	 */
	public List<Company> getAllCompanies() throws SQLException
	{
		SqlConnector.getInstance();
		return anyDAO.viewCompany();
	
	}
	
	/**
	 * View some companies.
	 *
	 * @param con the con
	 * @param pageNumber the page number
	 * @return the list
	 * @throws SQLException the SQL exception
	 */
	public List<Company> viewSomeCompanies(int pageNumber) throws SQLException
	{
		Page page = new Page(pageNumber);
		page.setMax(page.countDb("company"));
		page.calcPages(page.getAmount(),page.getMax());
		return anyDAO.viewSomeCompanies(page);
	}
}
