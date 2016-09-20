
public class LInfiniteInteger implements InfiniteIntegerInterface
{
	private Node firstNode;
	private Node lastNode;
	private int numberOfDigits;
	private boolean isNegative;
	
	/**
	 * Constructor: Constructs this infinite integer from a string
	 * representing an integer.
	 * @param s  a string represents an integer
	 */
	public LInfiniteInteger(String s)
	{
		// TO DO
	}

	/**
	 * Constructor: Constructs this infinite integer from an integer.
	 * @param anInteger  an integer
	 */
	public LInfiniteInteger(int anInteger)
	{
		// TO DO
	}

	/**
	 * Gets the number of digits of this infinite integer.
	 * @return an integer representing the number of digits
	 * of this infinite integer.
	 */
	public int getNumberOfDigits()
	{
		// TO DO
	}

	/**
	 * Checks whether this infinite integer is a negative number.
	 * @return true if this infinite integer is a negative number.
	 * Otherwise, return false.
	 */
	public boolean isNegative()
	{
		// TO DO
	}

	/**
	 * Calculates the result of this infinite integer plus anInfiniteInteger
	 * @param anInfiniteInteger the infinite integer to be added to this
	 * infinite integer.
	 * @return a NEW infinite integer representing the result of this
	 * infinite integer plus anInfiniteInteger
	 */
	public InfiniteIntegerInterface plus(final InfiniteIntegerInterface anInfiniteInteger)
	{		
		// TO DO
	}

	/**
	 * Calculates the result of this infinite integer subtracted by anInfiniteInteger
	 * @param anInfiniteInteger the infinite integer to subtract.
	 * @return a NEW infinite integer representing the result of this
	 * infinite integer subtracted by anInfiniteInteger
	 */
	public InfiniteIntegerInterface minus(final InfiniteIntegerInterface anInfiniteInteger)
	{
		// TO DO
	}
	
	/**
	 * Generates a string representing this infinite integer. If this infinite integer
	 * is a negative number a minus symbol should be in the front of numbers. For example,
	 * "-12345678901234567890". But if the infinite integer is a positive number, no symbol
	 * should be in the front of the numbers (e.g., "12345678901234567890").
	 * @return a string representing this infinite integer number.
	 */
	public String toString()
	{
		// TO DO
	}
	
	/**
	 * Compares this infinite integer with anInfiniteInteger
	 * @return either -1, 0, or 1 as follows:
	 * If this infinite integer is less than anInfiniteInteger, return -1.
	 * If this infinite integer is equal to anInfiniteInteger, return 0.
	 * If this infinite integer is greater than anInfiniteInteger, return 1.
	 */
	public int compareTo(InfiniteIntegerInterface anInfiniteInteger)
	{
		// TO DO
	}

	/**
	 * Calculates the result of this infinite integer multiplied by anInfiniteInteger
	 * @param anInfiniteInteger the multiplier.
	 * @return a NEW infinite integer representing the result of this
	 * infinite integer multiplied by anInfiniteInteger.
	 */
	public InfiniteIntegerInterface multiply(final InfiniteIntegerInterface anInfiniteInteger)
	{
		// TO DO
	}
	
	private class Node
	{
		private int data;
		private Node next;
		private Node previous;
		
		private Node(Node previousNode, int aData, Node nextNode)
		{
			previous = previousNode;
			data = aData;
			next = nextNode;
		}
		
		private Node(int aData)
		{
			this(null, aData, null);
		}
	}
}
