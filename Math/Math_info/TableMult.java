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
				this.tableau[i][j] = ((i+1)*(1+j));
			}
		}
	}
	
	public void printNumber(int current){
		if(current < 10 )
				System.out.print("  " + current + "  ");
			else{
				if(current < 100 )
					System.out.print(" " + current + "  ");
				else{
					if(current < 1000 )
						System.out.print(" " + current + " ");
				}
			}
	}


	public void printline(int i){
		for(int current : this.tableau[i]){
			printNumber(current);
		}
	}

	public void printTableau(){
		System.out.print("     ");
		for(int i=1; i <= this.tableau.length; i++){
			printNumber(i);
		}

		System.out.println();
		for(int i=0; i< this.tableau.length; i++){
			int [] current = this.tableau[i];
			printNumber(i+1);
			printline(i);
			System.out.println();
		}

	}
	


	public static void main(String[] args){
		TableMult tab = new TableMult(15);
		tab.printTableau();
  }
}
