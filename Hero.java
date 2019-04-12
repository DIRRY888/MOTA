
public class Hero {
	private int level;//Ó¢ÐÛµÈ¼¶
	int hp;
    int attack;
	int defence;
	int money;
	int exprence;
	int yellowkey;
	int bluekey;
	int redkey;
    Hero(){
    	level = 1;
    	hp=500;
    	attack =50;
    	defence = 30;
    	money = 0;
    	exprence = 0;
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
    int getexprence() {
		return exprence;
	}
    
}
