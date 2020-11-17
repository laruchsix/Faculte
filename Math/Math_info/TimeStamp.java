package Math_info;


public class TimeStamp{
	private int compteur;
	
	public TimeStamp(){
		this.compteur = 0;
	}
	
	public TimeStamp(int x){
		this.compteur = x;
	}
	
	public int time(){
		this.compteur += 1;
		return compteur;
	}
	
	public int getTime(){
		return this.compteur;
	}
}
