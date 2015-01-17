package se.onlinepannkaka.models;

public final class Product
{

	private final String title;	
	private final String description;
	private final double price;
	private final int quantity;
	
	public Product(String title, String description, double price, int quantity)
	{
		this.title = title;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	public String getTitle()
	{
		return title;
	}

	public String getDescription()
	{
		return description;
	}

	public double getPrice()
	{
		return price;
	}

	public int getQuantity()
	{
		return quantity;
	}

	@Override
	public int hashCode()
	{
		return title.hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		if(hashCode() == obj.hashCode())
		{
			return true;
		}
		return false;
	}
	
	@Override
	public String toString()
	{
		return "PRODUCT [Title: '" + title 
				+ "', Description: '" + description 
				+ "', Price: " + price 
				+ ":-, Quantity: " + quantity + "]";
	}
	
}
