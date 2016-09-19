//Nick Miller
//CS 445
//Assignment 1
import java.io.File;
import java.io.FileNotFoundException; import java.io.PrintWriter;
import java.util.Scanner;

public class CharacterFrequency
{	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		FrequencyBag<String> fb = new FrequencyBag<String>(); //Creates a new object
		String fileName = "letter1.txt";
		try
		{

			Scanner fileData = new Scanner(new File(fileName)); //Opens the file letter.txt
			while (fileData.hasNext())
         	{
           		String line = fileData.next(); //Gets each word seperate in the txt document
         		StringBuilder k = new StringBuilder(line.toLowerCase()); //Seperates each word into a StringBuilder set
				for(int i = 0; i < k.length(); i++)
				{
					String c = String.valueOf(k.charAt(i)); // Goes through and puts a certain character from the word in the StringBuilder into c
					fb.add(c.toLowerCase()); // Adds the letter (or c) to the
				}           		
			} // end while
         	fileData.close(); //Closes the file
		}
		catch (FileNotFoundException e) {//Catches the FileNotFoundException
			System.out.println("Scanner error opening the file " + fileName); System.out.println(e.getMessage());
		}
        int n = 0;
        //Prints out each letter and its frequency
        System.out.println("\nCharacter:  Frequency \n---------------------\n---------------------");
        String[] printFreq = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        for(int z = 0; z < printFreq.length; z++){
			n = fb.getFrequencyOf(printFreq[z]);
			System.out.println(printFreq[z] + ": " + n);
        	
        }
	}
}