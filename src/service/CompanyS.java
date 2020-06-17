package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.Company;
import persistence.CompanyDAO;
import ui.Page;

public class CompanyS {

private CompanyDAO anyDAO = new CompanyDAO();
	

	public List<Company> getAllCompanies(Connection con) throws SQLException
	{
		return anyDAO.viewCompany(con);
	
	}
	
	public List<Company> viewSomeCompanies(Connection con, int pageNumber) throws SQLException
	{
		Page page = new Page(pageNumber);
		page.setMax(page.countDb(con,"company"));
		page.calcPages(page.getAmount(),page.getMax());
		return anyDAO.viewSomeCompanies(con, page);
	}
}
