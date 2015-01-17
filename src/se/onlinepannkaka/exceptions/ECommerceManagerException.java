package se.onlinepannkaka.exceptions;

public final class ECommerceManagerException extends RuntimeException
{
	private static final long serialVersionUID = 8478971257612191617L;

	public ECommerceManagerException(String message, Exception e)
	{
		super(message, e);
	}

	public ECommerceManagerException(String message)
	{
		super(message);
	}

}
