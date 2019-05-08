package Model;

public class Hero {
	private int level;//Ó¢ÐÛµÈ¼¶
	public int hp;
	public int attack;
	public int defence;
	public int money;
	public int experience;
	int yellowkey;
	int bluekey;
	int redkey;
    public Hero(){
    	level = 1;
    	hp=1000;
    	attack =50;
    	defence = 30;
    	money = 0;
    	experience = 0;
    	yellowkey = 0;
    	bluekey = 0;
    	redkey = 0;
    }
    public int gethp() {
		return hp;
	}
	public int getattack() {
		return attack;
	}
	public int getdefence() {
		return defence;
	}
	public  int getmoney() {
		return money;
	}
	public int getexperience() {
		return experience;
	}
    public void printstate() {
    	System.out.println("  hp:  "+this.hp+"    "+"  money:  "+this.money+"    "+"  experience:  "+this.experience+"    ");
    	
    }
    
}
