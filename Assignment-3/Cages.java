import java.io.*;
import java.util.*;


public class Cages {
	private int targetNum = 0;
	private String operatorTar;
	private int sizeTar = 0;
	private int[] xy = new int[3];
	private int[][] cageStore;
	private int currBlock = 0;
	
	public Cages(int target, String operator, int size){
		//System.out.println("In cage setup");
		targetNum = target;
		operatorTar = operator;
		sizeTar = size;
		cageStore = new int[size][3];
		CagetoString();
		
	}
	public void CagetoString(){
		for(int i = 0; i < sizeTar; i++){
			//System.out.println("The x: " + cageStore[i][0] + " the y: " + cageStore[i][1] + " the current number: " + cageStore[i][2]);
		}
	}
	
	public boolean addBlock(int x, int y){
		//System.out.println("In add setup");

		cageStore[currBlock][0] = x;
		cageStore[currBlock][1] = y;
		cageStore[currBlock][2] = 0;
		currBlock++;
		CagetoString();
		return true;
	}
	
	public boolean cageFull(){
		for(int i = 0; i < sizeTar; i++){
			if(cageStore[i][2] == 0){
				return false;
			}

		}
		return true;
	}
		
	
	public boolean changeNum(int x, int y, int numChange){
		for(int i = 0; i < cageStore.length ; i ++){
			if(cageStore[i][0] == x && cageStore[i][1] == y){
				cageStore[i][2] = numChange;
				return true;
			}
		}
		return false;
	}
	
	public boolean isLegalCheck(){
		int[] tempArray = new int[sizeTar];
		for(int i = 0; i < sizeTar; i++){
			tempArray[i] = cageStore[i][2];
		}
		int n = tempArray.length;
		int temp = 0;    
		for (int i = 0; i < n; i++) {
	   		for (int v = 1; v < (n - i); v++) {
       	 		if (tempArray[v - 1] < tempArray[v]) {
        			temp = tempArray[v - 1];
        			tempArray[v - 1] = tempArray[v];
        			tempArray[v] = temp;
       			}
       		}
       	}
       	
		int sumRight = tempArray[0];
		for(int q = 0; q < tempArray.length; q++){
			if(tempArray[q] == 0){
				return true;
			}
		}
		if(operatorTar.equals("-")){
			for(int i = 1; i < tempArray.length; i++){
				sumRight = sumRight - tempArray[i];
			}			
		}else if(operatorTar.equals("+")){
			for(int i = 1; i < cageStore.length; i++){
				sumRight = sumRight + tempArray[i];
			}			
		}else if(operatorTar.equals("*")){
			for(int i = 1; i < cageStore.length; i++){
				sumRight = sumRight * tempArray[i];;
			}		
		}else if(operatorTar.equals("/")){
			for(int i = 1; i < cageStore.length; i++){
				sumRight = sumRight / tempArray[i];;
			}	
		}else if(operatorTar.equals(" ")){
			//System.out.println("Checks in the equals");
			changeNum(cageStore[0][0],cageStore[0][1],targetNum);
		}
		
		if(sumRight == targetNum){
			return true;
		}
		//System.out.println(targetNum + " and " + sumRight);
		//System.out.println("A cage violation. ");
		return false;	
		
	}
	
	public int coordinateRet(int r, int c){
		for(int i = 0; i < cageStore.length; i++){
			if(r == cageStore[i][0] && c == cageStore[i][1]){
				return cageStore[i][2];
			}
		}
		return -1;
	}
		
}			
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				