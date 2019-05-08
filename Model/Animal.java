package Model;

public class Animal {
	
	private String name;
	private int level;
	private int hp;
	private int attack;
	private int defence;
	private int money;
	private int experience;
	public Animal(String j,int a,int b ,int c,int d,int e,int f){
	    name = j;
		level = a;
		hp=b;
		attack = c;
		defence = d;
		money = e;
		experience = f;
	}
    public int gethp() {
		return hp;
	}
	public int getattack() {
		return hp;
	}
    public int getdefence() {
		return defence;
	}
    public int getmoney() {
		return money;
	}
    public int getexperience() {
		return experience;
	}
public void printstate() {
	System.out.println("  hp:  "+this.hp+"    "+"  money:  "+this.money+"    "+"  experience:  "+this.experience+"    ");
	
}
}
