package Math_info;

import java.util.Scanner;
import java.util.NoSuchElementException;

public class Exo_3 {
	public static void main(String[] args){
		TimeStamp compteur = new TimeStamp();
		int somme = 0;
		int x;
		Scanner scanner = new Scanner(System.in);
		do{
			try{ 
				x = scanner.nextInt(); 
			}
			catch(NoSuchElementException Exception){
				break;
			}
			compteur.time();
			somme += x;
		}while(true);
		float moyenne = (float) somme / compteur.getTime();
		System.out.println("Voici la somme des entiers : " + somme + "\nLa moyenne des entiers entés : " + moyenne);
  }
}
