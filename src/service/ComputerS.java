package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.Computer;
import persistence.ComputerDAO;
import ui.Page;

public class ComputerS {

private ComputerDAO compDAO = new ComputerDAO();
	

	public List<Computer> getAllComputer(Connection con) throws SQLException
	{
		return compDAO.viewComputer(con);
	
	}
	
	public List<Computer> viewSomeComputer(Connection con, int pageNumber) throws SQLException
	{
		Page page = new Page(pageNumber);
		page.setMax(page.countDb(con,"company"));
		page.calcPages(page.getAmount(),page.getMax());
		return compDAO.viewSomeComputer(con, page);
	}
}
