package se.onlinepannkaka;

import se.onlinepannkaka.models.Product;
import se.onlinepannkaka.repositories.MySQLRepository;
import se.onlinepannkaka.services.ECommerceManager;

public class Main
{

	public static void main(String[] args)
	{
		ECommerceManager man = new ECommerceManager(new MySQLRepository());
		
		man.createProduct(new Product("Klassisk pannkaka", "En gammaldags god pannkaka", 10.95, 50));

//		man.updateProduct(new Product("Klassisk pannkaka", "Fortfarande en gammaldags god pannkaka", 10.95, 40));
		
//		man.deleteProduct("Klassisk pannkaka");
		
		System.out.println(man.readProduct("Klassisk pannkaka"));

	}

}
