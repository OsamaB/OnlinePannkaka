package se.onlinepannkaka.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import se.onlinepannkaka.exceptions.RepositoryException;
import se.onlinepannkaka.models.Product;

public final class MySQLRepository implements ProductRepository
{
	private final String url = "jdbc:mysql://localhost:3306/onlinepannkaka";
	private final String username = "online";
	private final String password = "pannkaka";

	@Override
	public Product createProduct(Product product) throws RepositoryException
	{
		try (final Connection connection = DriverManager.getConnection(url, username, password))
		{
			connection.setAutoCommit(false);
			try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO "
					+ "products (title, description, price, quantity) "
					+ "VALUES (?, ?, ?, ?);"))
			{
				stmt.setString(1, product.getTitle());
				stmt.setString(2, product.getDescription());
				stmt.setDouble(3, product.getPrice());
				stmt.setInt(4, product.getQuantity());

				if (stmt.executeUpdate() == 1)
				{
					connection.commit();
					return new Product(product.getTitle(), product.getDescription(), product.getPrice(), product.getQuantity());
				}
			}
			catch (SQLException e)
			{
				connection.rollback();
			}

			throw new RepositoryException("Could not add product");

		}
		catch (SQLException e)
		{
			throw new RepositoryException("Could not connect to DB", e);
		}
	}

	@Override
	public Product readProduct(String title) throws RepositoryException
	{

		try (final Connection connection = DriverManager.getConnection(url, username, password))
		{
			connection.setAutoCommit(false);
			try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM products WHERE title = ?"))
			{
				stmt.setString(1, title);
				ResultSet rs = stmt.executeQuery();
				if (rs.next())
				{
					connection.commit();
					return new Product(title, rs.getString("description"), rs.getDouble("price"), rs.getInt("quantity"));
				}

			}
			catch (SQLException e)
			{
				connection.rollback();
			}

			throw new RepositoryException("Could not get user");

		}
		catch (SQLException e)
		{
			throw new RepositoryException("Could not connect to DB", e);
		}

	}

	@Override
	public Product updateProduct(Product product) throws RepositoryException
	{
		try (final Connection connection = DriverManager.getConnection(url, username, password))
		{
			connection.setAutoCommit(false);
			try (PreparedStatement stmt = connection.prepareStatement("UPDATE products SET title = ?, description = ?, price = ?, quantity = ? WHERE title = ?"))
			{
				stmt.setString(1, product.getTitle());
				stmt.setString(2, product.getDescription());
				stmt.setDouble(3, product.getPrice());
				stmt.setInt(4, product.getQuantity());
				stmt.setString(5, product.getTitle());

				if (stmt.executeUpdate() == 1)
				{
					connection.commit();
					return new Product(product.getTitle(), product.getDescription(), product.getPrice(), product.getQuantity());
				}
			}
			catch (SQLException e)
			{
				connection.rollback();
			}

			throw new RepositoryException("Could not update product");

		}
		catch (SQLException e)
		{
			throw new RepositoryException("Could not connect to DB", e);
		}
	}

	@Override
	public void deleteProduct(String title) throws RepositoryException
	{
		try (final Connection connection = DriverManager.getConnection(url, username, password))
		{
			connection.setAutoCommit(false);
			try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM products WHERE title = ?"))
			{
				stmt.setString(1, title);
				if (stmt.executeUpdate() == 1)
				{
					connection.commit();
				}

			}
			catch (SQLException e)
			{
				connection.rollback();
				throw new RepositoryException("Could not delete product");
			}


		}
		catch (SQLException e)
		{
			throw new RepositoryException("Could not connect to DB", e);
		}
	}

}
