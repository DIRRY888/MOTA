
public class Hero {
	private int level;//Ó¢ÐÛµÈ¼¶
	int hp;
    int attack;
	int defence;
	int money;
	int experience;
	int yellowkey;
	int bluekey;
	int redkey;
    Hero(){
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
    int gethp() {
		return hp;
	}
	int getattack() {
		return attack;
	}
    int getdefence() {
		return defence;
	}
    int getmoney() {
		return money;
	}
    int getexperience() {
		return experience;
	}
    public void printstate() {
    	System.out.println("  hp:  "+this.hp+"    "+"  money:  "+this.money+"    "+"  experience:  "+this.experience+"    ");
    	
    }
    
}
