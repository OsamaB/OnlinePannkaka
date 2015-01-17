package se.onlinepannkaka;

import se.onlinepannkaka.models.Product;
import se.onlinepannkaka.repositories.MySQLRepository;
import se.onlinepannkaka.services.ECommerceManager;

public class Main
{

	public static void main(String[] args)
	{
		ECommerceManager man = new ECommerceManager(new MySQLRepository());
		
		man.deleteProduct("Klassisk pannkaka");

		man.createProduct(new Product("Klassisk pannkaka", "En gammaldags god pannkaka", 10.95, 50));
		
		System.out.println(man.readProduct("Klassisk pannkaka"));

	}

}
