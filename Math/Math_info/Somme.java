package Math_info;

import java.util.Scanner;

public class Somme{
  public static void main(String[] args){
	Scanner scanner = new Scanner(System.in); 
	try(scanner){
		System.out.print("Entrez l'entier :");
		int nbr = scanner.nextInt();

		int compteur = 0;
		int c = 0;
		while(compteur <= nbr){
			c += compteur;
			compteur ++;
		}
		System.out.print(c +"\n");
	}
  }
}
