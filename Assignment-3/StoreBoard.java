/*
 * Reads in a file containing the contents of the puzzle
 * Stores the board appropriately into cages in arraylist
 */
 
 	//Must have .txt files in the right folder or will not work. 
 	//The .txt files in the compressed files that will work are 3x3_1.txt, and 9x9_2.txt

import java.io.*;
import java.util.*;


public class StoreBoard {


  public static int[][] returnArray;
  public static ArrayList<Cages> StoreBoard = new ArrayList<Cages>();
  
  public static void main(String[] args){
  		String fileName;
		
		Scanner inFile = new Scanner(System.in);
		System.out.println("Please enter the file name: ");
		fileName = inFile.next();
		getBoard(fileName);
		////System.out.println("The cage of 3x3 is: " + determineCage(3,3));
	}
  
  public static void getBoard(String fileName){
    	BufferedReader br = null;
    	int BoardSize = 0;
      	int numCages = 0;

  	  try {
		String sCurrentLine;
		br = new BufferedReader(new FileReader(fileName));
     	//Scanner sc = new Scanner(new File(filename));
     	Boolean done = false;
      
      	int currentCageNumber = 0;
      	String s = null;
      	try{
      		BoardSize = Integer.parseInt(br.readLine());
      		numCages = Integer.parseInt(br.readLine());
      	}catch(Exception e){}
      	returnArray = new int[BoardSize][BoardSize];
      	//System.out.println(BoardSize + " and " + numCages);
      	int n = 0;
		
		try{
			s = br.readLine();
		}catch(Exception e){
		}
		while(s != null){
      	
       		String[] splitter;
       		String[] splitter2;
      		splitter = s.split(",");
      		if(splitter.length == 3){
      			n++;
      			//System.out.println(splitter[0] + " and " + splitter[1] + " and " + splitter[2]);
      			Cages cg = new Cages(Integer.parseInt(splitter[0]), splitter[1], Integer.parseInt(splitter[2]));
      			for(int j = 0; j < Integer.parseInt(splitter[2]); j++){
      				//System.out.println(j);
      				//System.out.println("In for loop");
      				try{
      					s = br.readLine();
      				}catch(Exception e){}
      				splitter2 = s.split(",");
	      			for(int i = 0; i < splitter2.length; i++){
      					//System.out.println(splitter2[i]);
      				}
      				//System.out.println("Right before addBlock");
      				cg.addBlock(Integer.parseInt(splitter2[0]), Integer.parseInt(splitter2[1]));
      				//System.out.println("Right after addBlock");

      			}
      			StoreBoard.add(cg);

      		}
      		//System.out.println("Out of if loop");
      		/*for(int i = 0; i < splitter.length; i++){
      			//System.out.println(splitter[i]);
      		}*/
      		try{
      			s = br.readLine();
      		}catch(Exception e){}
      		//System.out.println(s);
      		//System.out.println(n);
      		//System.out.println(StoreBoard.size());
      	}

      }
      catch(FileNotFoundException e){
      	//System.out.println("Filename not working.. ");
      }
      catch(NullPointerException e){}
      
      goThroughAll();
      SolverKenKen skk = new SolverKenKen(StoreBoard,BoardSize,numCages);
      skk.runThrough(fileName);
      
      
      
      
	}
	
	static void goThroughAll(){
		Cages currentCage;
		//System.out.println(StoreBoard.size());
		for(int i = 0; i < StoreBoard.size(); i++){
			currentCage = StoreBoard.get(i);
			currentCage.CagetoString();
		}
	}
	
	static int searchThroughCoordinates(int r, int c){
		Cages currentCage;
		//System.out.println(StoreBoard.size());
		for(int i = 0; i < StoreBoard.size(); i++){
			currentCage = StoreBoard.get(i);
			int returnCor = currentCage.coordinateRet(r,c);
			if(returnCor != -1){
				return returnCor;
			}

		}
		return -1;
	}
	
	static int determineCage(int r, int c){
		Cages currentCage;
		//System.out.println(StoreBoard.size());
		for(int i = 0; i < StoreBoard.size(); i++){
			currentCage = StoreBoard.get(i);
			int returnCor = currentCage.coordinateRet(r,c);
			if(returnCor != -1){
				return i;
			}
		}
		return -1;
	}
	
	
	//boolean isLegal
	
	
	
	
	
	
}