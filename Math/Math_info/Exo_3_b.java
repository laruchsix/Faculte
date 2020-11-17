package Math_info;

import java.util.Scanner;
import java.util.NoSuchElementException;

public class Exo_3_b {
	public static void main(String[] args){
		TimeStamp compteur = new TimeStamp();
		Scanner scanner = new Scanner(System.in);
		int somme = 0;
		int x;
		do{
			if( !scanner.hasNextInt()){
				break;
			}
			
			x = scanner.nextInt(); 
			compteur.time();
			somme += x;
		}while(true);
		float moyenne = (float) somme / compteur.getTime();
		System.out.println("Voici la somme des entiers : " + somme + "\nLa moyenne des entiers entés : " + moyenne);
  }
}
