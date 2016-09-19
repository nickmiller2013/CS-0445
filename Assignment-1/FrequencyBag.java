//Nick Miller
//CS 0445
//Assignment 1
// Due February 8, 2015
//while(currNode != null) is the loop to search through the Nodes


public class FrequencyBag<T>
{

	// TO DO: Instance Variables
	private Node firstNode; 
	private int numOfItems;
	
	private class Node //Sets up the Nodes 
	{
		private T data;
		private int frequency; //Will set the frequency of current Node
		private Node next;
		
		private Node(T aData, Node aNext)
		{
			data = aData; // This sets up the node
			next = aNext;
			frequency = 1; //Sets frequency to 1
		}
		
		private void addFrequency() // Adds to the frequency of the specific Node
		{
			frequency++;
		}
		
		private int getFrequency()
		{
			return frequency;
		}
	}
	
	/**
	 * Constructor
	 * Constructs an empty frequency bag.
	 */
	public FrequencyBag()
	{
		// TO DO
        firstNode = null;
		numOfItems = 0;
	}
	
	/**
	 * Adds new entry into this frequency bag.
	 * @param aData the data to be added into this frequency bag.
	 */
	public void add(T aData)
	{
		// TO DO
		Node currNode = firstNode;
		boolean found = false;
		
		while(currNode != null) //Searches through the Node to see if it should add to the frequency
		{
			if(currNode.data.equals(aData))
			{
				currNode.addFrequency(); //Adds to the frequency of specific Node
				found = true;
				break;
			}
		currNode = currNode.next;
		}
		
		if(!found) //If no Node is found creates a brand new Node
		{
			Node aNode = firstNode;
			firstNode = new Node(aData, aNode);
		}
		
		numOfItems++;
	}
	
	/**
	 * Gets the number of occurrences of aData in this frequency bag.
	 * @param aData the data to be checked for its number of occurrences.
	 * @return the number of occurrences of aData in this frequency bag.
	 */
	public int getFrequencyOf(T aData)
	{
		// TO DO
		Node currNode = firstNode;
		while(currNode != null) //Searches through the Nodes. 
		{
			if(currNode.data.equals(aData))
			{
				return currNode.getFrequency(); //Returns the frequency of currNode
			}
		currNode = currNode.next;
		}
		return 0;
		// TO DO
	}

	/**
	 * Gets the maximum number of occurrences in this frequency bag.
	 * @return the maximum number of occurrences of an entry in this
	 * frequency bag.
	 */
	public int getMaxFrequency()
	{
		// TO DO
		if(firstNode != null)
		{
			Node currNode = firstNode;
			Node highNode = firstNode;
			while(currNode != null)
			{
				//The if() is to figure out which node is greater. 
				if(currNode.getFrequency() >= highNode.getFrequency()) //
				{
					highNode = currNode;
				}
				currNode = currNode.next; //Moves to the next Node in while loop
			}
			return highNode.getFrequency(); //Gets the frequency of the highNode
		}
		else
		{	
			return 0;
		}
	}
	
	/**
	 * Gets the probability of aData
	 * @param aData the specific data to get its probability.
	 * @return the probability of aData
	 */
	public double getProbabilityOf(T aData)
	{
	//This function will get the frequency of a number and divide it by the numOfItems
		// TO DO
		if(firstNode != null)
		{
			boolean check = true;
			double freqTop = 0; //The top number in the division to get probability
			double prob = 0; //The probability amount
			Node currNode = firstNode;
			while(currNode != null)
			{
				if(currNode.data.equals(aData))
				{
					freqTop = (double) currNode.getFrequency();
					check = false;
					break;
				}
				currNode = currNode.next;
			}
			if(!check
			)
			{
				prob = freqTop / (double) numOfItems; //Does the equation to get prob
			}
			return prob;
		}
		else
		{
			return 0;
		}
				
	}

	/**
	 * Empty this bag.
	 */
	public void clear()
	{
		// TO DO
		firstNode = null; // Clears the LinkedList by setting the firstNode to null cutting off the rest of the Nodes
		numOfItems = 0; //Resets numOfItems to 0
	}
	
	/**
	 * Gets the number of entries in this bag.
	 * @return the number of entries in this bag.
	 */
	public int size()
	{
		// TO DO
		return numOfItems; //just simply returns numOfItems
	}
}
