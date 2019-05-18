
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
	int bluebottle;
	int redbottle;
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
    	 bluebottle=0;
    	 redbottle=0;
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
    	System.out.println("  attack:  "+this.attack+"    "+"  defence:  "+this.defence);
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
	public void changebottle(int i) {
		if(i==15) {
    		redbottle = redbottle+1;
    	}
		if(i==16) {
    		bluebottle = bluebottle+1;
    	}
		
	}
	public void upgrade() {
		this.level = this.level +1;
		this.hp =  (int) (attack*2.2);
		this.attack = (int) (attack*1.9);
		this.defence = (int) (defence*1.7);
		
	}
   
}