package se.onlinepannkaka.models.test;

import static org.junit.Assert.*;

import org.junit.Test;

import se.onlinepannkaka.models.Product;

public class ProductTest
{

	@Test
	public void theProductVariabelsShouldBeSetInTheConstructor()
	{
		final String title = "Pannkaka";
		final String description = "Jetteguuud pannkaka ja lovar!";
		final double price = 10.90;
		final int quantity = 25;
		
		Product product = new Product(title, description, price, quantity);
		
		assertEquals(title, product.getTitle());
		assertEquals(description, product.getDescription());
		assertEquals(price, product.getPrice(), 0);
		assertEquals(quantity, product.getQuantity());
	}

}
