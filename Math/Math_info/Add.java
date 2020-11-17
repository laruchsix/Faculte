package Math_info;

public class Add	 {
  public static void main(String[] args){
	 int compteur = 0;
	 for( String i : args){
	 	int current = Integer.parseInt(i);
	 	compteur += current;
	 }
	 System.out.print(compteur+"\n");
  }
}
