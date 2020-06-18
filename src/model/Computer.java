package model;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Computer.
 */
public class Computer {

		/** The id. */
		int id;
		
		/** The company id. */
		//int company_id;
		Company company;
		
		/** The name. */
		String name;
		
		/** The introduced. */
		Date introduced;
		
		/** The discontinued. */
		Date discontinued;
		
		
	/**
	 * Instantiates a new computer.
	 */
	public Computer() {}
	
	/**
	 * Instantiates a new computer.
	 *
	 * @param id the id
	 */
	public Computer(int id) {
		this.id=id;
		introduced =new Date();
		
	}		
	
	/**
	 * Instantiates a new computer.
	 *
	 * @param id the id
	 * @param name the name
	 */
	public Computer(int id, String name, Date intro, Date disco, Company company)
	{
		this.id=id;
		this.name=name;
		this.introduced=intro;
		this.discontinued=disco;
		this.company=company;
	}
	
	
	
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId()
	{
		return this.id;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Gets the intro.
	 *
	 * @return the intro
	 */
	public Date getIntro()
	{
		return this.introduced;
	}
	
	/**
	 * Gets the disco.
	 *
	 * @return the disco
	 */
	public Date getDisco()
	{
		return this.discontinued;
	}
	
	/**
	 * Gets the c id.
	 *
	 * @return the c id
	 */
	public int getCId()
	{
		return this.company.getId();
	}
	
	
	
	
	/**
	 * Sets the id.
	 *
	 * @param newId the new id
	 */
	public void setId(int newId)
	{
		// Add Exception to prevent setting the id to NULL
		this.id=newId;
		
	}
	
	/**
	 * Sets the c id.
	 *
	 * @param newId the new c id
	 */
	public void setC_Id(int newId)
	{
		// Add Exception to prevent setting the id to NULL
		this.company.setId(newId);
		
	}
	
	/**
	 * Sets the name.
	 *
	 * @param newName the new name
	 */
	public void setName(String newName)
	{
		this.name=newName;
		
	}
	
	/**
	 * Sets the disco.
	 *
	 * @param newDate the new disco
	 */
	public void setDisco(Date newDate)
	{
		this.discontinued=newDate;
	}
	
	/**
	 * Sets the intro.
	 *
	 * @param newDate the new intro
	 */
	public void setIntro(Date newDate)
	{
		this.discontinued=newDate;
	}
}
