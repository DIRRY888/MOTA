
public class Animal {
	
	private String name;
	private int level;
	private int hp;
	private int attack;
	private int defence;
	private int money;
	private int experience;
	Animal(String j,int a,int b ,int c,int d,int e,int f){
	    name = j;
		level = a;
		hp=b;
		attack = c;
		defence = d;
		money = e;
		experience = f;
	}
    int gethp() {
		return hp;
	}
	int getattack() {
		return hp;
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
