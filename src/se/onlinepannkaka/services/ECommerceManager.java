package se.onlinepannkaka.services;

import se.onlinepannkaka.exceptions.ECommerceManagerException;
import se.onlinepannkaka.exceptions.RepositoryException;
import se.onlinepannkaka.models.Product;
import se.onlinepannkaka.repositories.ProductRepository;

public final class ECommerceManager
{
	private final ProductRepository productRepository;

	public ECommerceManager(final ProductRepository productRepository)
	{
		this.productRepository = productRepository;
	}

	public Product createProduct(final Product product)
	{
		try
		{
			return productRepository.createProduct(product);
		}
		catch (RepositoryException e)
		{
			throw new ECommerceManagerException("Could not create product", e);
		}
	}

	public Product readProduct(final String title)
	{
		try
		{
			return productRepository.readProduct(title);
		}
		catch (RepositoryException e)
		{
			throw new ECommerceManagerException("Could not find product", e);
		}
	}

	public Product updateProduct(final Product product)
	{
		try
		{
			return productRepository.updateProduct(product);
		}
		catch (RepositoryException e)
		{
			throw new ECommerceManagerException("Could not update product", e);
		}
	}

	public void deleteProduct(final String title)
	{
		try
		{
			productRepository.deleteProduct(title);
		}
		catch (RepositoryException e)
		{
			throw new ECommerceManagerException("Could not delete product", e);
		}
	}
}
