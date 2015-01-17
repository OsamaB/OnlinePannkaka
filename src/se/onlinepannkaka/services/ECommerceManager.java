package se.onlinepannkaka.services;

import se.onlinepannkaka.exceptions.ECommerceManagerException;
import se.onlinepannkaka.exceptions.RepositoryException;
import se.onlinepannkaka.models.Product;
import se.onlinepannkaka.repositories.ProductRepository;

public final class ECommerceManager
{
	private final ProductRepository pr;

	public ECommerceManager(final ProductRepository pr)
	{
		this.pr = pr;
	}

	public Product createProduct(final Product product)
	{
		try
		{
			return pr.createProduct(product);
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
			return pr.readProduct(title);
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
			return pr.updateProduct(product);
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
			pr.deleteProduct(title);
		}
		catch (RepositoryException e)
		{
			throw new ECommerceManagerException("Could not delete product", e);
		}
	}
}
