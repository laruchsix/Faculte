package Math_info;

import java.util.Scanner;


public class TableMult {
	private int[][] tableau;
	
	public TableMult(int len){
		this.tableau = new int [len][len];
		this.initTableau();
	}
	
	public void initTableau(){
		for( int i=0; i< this.tableau.length ; i++){
			for( int j = 0 ; j< this.tableau.length ; j++){
				this.tableau[i][j] = (i*j);
			}
		}
	}
	
	


	public static void main(String[] args){
		
  }
}
