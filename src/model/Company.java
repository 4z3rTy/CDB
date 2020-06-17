package model;

public class Company {
	int id;
	String name;
	
	
	public Company() {}
	public Company(int id) {
		this.id=id;
	}		
	public Company(int id, String name)
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
	
	

	public void setId(int newId)
	{
		// Add Exception to prevent setting the id to NULL
		this.id=newId;
		
	}
	public void setName(String newName)
	{
		this.name=newName;
		
	}
}
