package model;

import java.util.Date;

public class Computer {

		int id;
		int company_id;
		String name;
		Date introduced;
		Date discontinued;
		
		
	
	
	public Computer(int id) {
		this.id=id;
		introduced =new Date();
		
	}		
	
	public Computer(int id, String name)
	{
		this.id=id;
		this.name=name;
	}
	
	
	
	
	public int getId()
	{
		return this.id;
	}
	public String getName()
	{
		return this.name;
	}
	public Date getIntro()
	{
		return this.introduced;
	}
	public Date getDisco()
	{
		return this.discontinued;
	}
	public int getCId()
	{
		return this.company_id;
	}
	
	
	
	
	public void setId(int newId)
	{
		// Add Exception to prevent setting the id to NULL
		this.id=newId;
		
	}
	public void setName(String newName)
	{
		this.name=newName;
		
	}
	public void setDisco(Date newDate)
	{
		this.discontinued=newDate;
	}
}
