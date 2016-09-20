import javax.swing.*;
import java.io.*;
import java.util.*;

public class SolverKenKen{

	private ArrayList<Cages> cageAL;
	private int size = 0;
	private int numCages = 0; 
	private int[][] returnArr;
	private int currentI = 0;
	private StoreBoard sb;

	public SolverKenKen(ArrayList<Cages> x, int siz, int numC){
		Cages currentCage;
		cageAL = x;
		size = siz;
		numCages = numC;
		returnArr = new int[siz][siz];
		//System.out.println("\n\nThe size is: " + size + "\nThe number of cages is: " + numCages);
		for(int i = 0; i < cageAL.size(); i++){
			currentCage = cageAL.get(i);
			currentCage.CagetoString();
		}
		sb = new StoreBoard();
	}
	
	public void runThrough(String fileName){
		
		for(int i = 0; i < returnArr.length; i++){
			for(int j = 0; j < returnArr.length; j++){
				returnArr[i][j] = 0;
				//System.out.println(returnArr[i][j]);
			}
		}	
	
	
		solveKenKen(0,0);
		JFrame frame = new JFrame();
		KenKenComponent kc = null;
		try{
			kc = new KenKenComponent(fileName, frame);
		}catch(Exception e){
			System.out.println("Cannot find file");
		}

		kc.setNumber(returnArr);
	}




	public boolean solveKenKen(int r, int c){
		
		Cages tempCage = null;

		if(c == size){
			c= 0;
			r = r+1;
		}
		
		if(r == size){
			return true;
		}else{
			for(int i = 1; i <= size; i++){
				int cageDet = sb.determineCage(r,c);
				tempCage = cageAL.get(cageDet);
				tempCage.changeNum(r, c, i);
				returnArr[r][c] = i;
				currentI = i;
				//System.out.println(currentI);

				//put i at row r column c
				boolean p = isLegal(r,c);
				if(p){
					boolean q = solveKenKen(r, c+1);
					
					if(q){
						return true;
					}
				}
				
			}
			returnArr[r][c] = 0;
			tempCage.changeNum(r,c,0);
			
			return false;
		}
	}
	
	public boolean isLegal(int r, int c){
		Cages tempCage;
		StoreBoard sb = new StoreBoard();
		int cageDet = sb.determineCage(r,c);
		tempCage = cageAL.get(cageDet);
		
		if(tempCage.isLegalCheck()){
			//System.out.println("In isLegalSudoku");
			if(isLegalSudoku(r,c,currentI)){	
				//System.out.println("Completely legal!");		
				if(!(tempCage.cageFull())){
					//System.out.println("In isLegalCheck");
					return true;
				}
				return true;
			}
		}
		//System.out.println("There was a violation!!!!");
		return false;
		
	}
	
	
	/*private boolean isLegalSudoku(int r, int c){
		for(int i = 0; i < r; i++){
			if((currentI == returnArr[r][i]) && (returnArr[r][i] != returnArr[r][c])){
				return false;
			}
		}
		for(int i = 0; i < c; i++){
			if(currentI == returnArr[i][c] && returnArr[i][c] != returnArr[r][c]){
				return false;
			}
		}
		return true;
	}
	*/
	 private boolean isLegalSudoku(int x, int y, int num)
	 {
	 	//System.out.println("In the class isLegalSudoku");
	 	boolean p = rule_RowViolation(x,y,num);
	 	boolean q = rule_ColViolation(x,y,num);
     	if(p || q){
     		//System.out.println("Invalid isLegalSudoku");
     		return false;
     	}
     	return true;
     }
	
    private boolean rule_RowViolation(int row, int col, int value) {
        // Find duplicates is a row
        //System.out.println("The value is: " + value + " The size is: " + size + " The col is: " + col + " The row is: " + row);
        for (int j = 0; j < size; j++) {
        	//System.out.println("returnArr is: " + returnArr[row][j]);
            if (j != col && returnArr[row][j] == value) {
            	//System.out.println("INVALID");

                return true;
            }
        }
    	//System.out.println("In row violation");

        return false;
    }


    private boolean rule_ColViolation(int row, int col, int value) {
        // Find duplicates in a region
        //System.out.println("The value is: " + value + "The size is: " + size + " The col is: " + col + " The row is: " + row);

        for (int i = 0; i < size; i++) {
        	//System.out.println("returnArr is: " + returnArr[i][col]);

            if (i != row && returnArr[i][col] == value) {
            	//System.out.println("INVALID");
                return true;
            }
        }
    	//System.out.println("In col violation");

        return false;
    }
	

}
	