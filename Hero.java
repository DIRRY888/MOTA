
public class Hero {
	private int level;//Ӣ�۵ȼ�
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
    	System.out.println("  yellowkey:  "+this.yellowkey+"    "+"  bluekey:  "+this.bluekey+"    "+"  redkey:  "+this.redkey+"    ");
    }
    public void keychange(int a) {
    	if(a==2) {
    		redkey = redkey+1;
    	}
    	if(a==3) {
    		yellowkey = yellowkey +1;
    	}
    	if(a==4) {
    		bluekey = bluekey + 1;
    	}
    	if(a==8) {
    		yellowkey = yellowkey - 1;
    	}
    	if(a==9) {
    		redkey = redkey - 1;
    	}
    	if(a==10) {
    		bluekey = bluekey - 1;
    	}
    	
    }
   
}