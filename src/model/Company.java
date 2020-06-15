package model;

public class Company {
	int id;
	String name;
	
	
	
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
	
	
//	The list of companies should be exhaustive, and therefore will not require any update, deletion etc... !!!!!!!!!!!!!!!!!!!!!!!
	
	
	/*
	public void setId(int newId)
	{
		// Add Exception to prevent setting the id to NULL
		this.id=newId;
		
	}
	public void setNme(String newName)
	{
		this.name=newName;
		
	}
*/
}
