package se.onlinepannkaka.exceptions;

public final class RepositoryException extends Exception
{
	private static final long serialVersionUID = 4581062601250525991L;

	public RepositoryException(String message, Exception e)
	{
		super(message, e);
	}

	public RepositoryException(String message)
	{
		super(message);
	}

}
