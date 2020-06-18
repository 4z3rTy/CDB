package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.Company;
import persistence.CompanyDAO;
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
	 * @param con the con
	 * @return the all companies
	 * @throws SQLException the SQL exception
	 */
	public List<Company> getAllCompanies(Connection con) throws SQLException
	{
		return anyDAO.viewCompany(con);
	
	}
	
	/**
	 * View some companies.
	 *
	 * @param con the con
	 * @param pageNumber the page number
	 * @return the list
	 * @throws SQLException the SQL exception
	 */
	public List<Company> viewSomeCompanies(Connection con, int pageNumber) throws SQLException
	{
		Page page = new Page(pageNumber);
		page.setMax(page.countDb(con,"company"));
		page.calcPages(page.getAmount(),page.getMax());
		return anyDAO.viewSomeCompanies(con, page);
	}
}
