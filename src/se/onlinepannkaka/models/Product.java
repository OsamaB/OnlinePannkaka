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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantity;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Product other = (Product) obj;
		if (description == null)
		{
			if (other.description != null) return false;
		}
		else if (!description.equals(other.description)) return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price)) return false;
		if (quantity != other.quantity) return false;
		if (title == null)
		{
			if (other.title != null) return false;
		}
		else if (!title.equals(other.title)) return false;
		return true;
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
