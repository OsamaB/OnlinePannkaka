package se.onlinepannkaka.repositories;
import se.onlinepannkaka.exceptions.RepositoryException;
import se.onlinepannkaka.models.Product;

public interface ProductRepository
{
	public Product createProduct(Product product) throws RepositoryException;
	
	public Product readProduct(String title) throws RepositoryException;
	
	public Product updateProduct(Product product) throws RepositoryException;
	
	public void deleteProduct(String title) throws RepositoryException;
}
