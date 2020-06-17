package ui;

public class Page {
	 int itemsNb=10;
	 int maxItems;
	 int pagesNb;
	 
	 public void page(int amount)
	 {
		 this.itemsNb=amount;
	 }
	
	public int getAmount()
	{
		return itemsNb;
	}
	
	public void setAmount(int amount)
	{
		this.itemsNb=amount;
	}

	public int getMax()
	{
		return maxItems;
	}
	
	public void setMax(int db_max)
	{
		this.maxItems=db_max;
	}
	
	public int getPages()
	{
		return pagesNb;
	}
	
	public void setPages(int p)
	{
		this.pagesNb=p;
	}
	
	public void calcPages(int items,int max)
	{
		int result=max%items;
		if(result>0)
		{
			result=1;
		}
		else
		{
			result=0;
		}
		this.pagesNb=(max/items)+result;
	}
}
