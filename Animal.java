
public class Animal {
	private String name;
	private int level;
	private int hp;
	private int attack;
	private int defence;
	private int money;
	private int exprence;
	Animal(String j,int a,int b ,int c,int d,int e,int f){
	    name = j;
		level = a;
		hp=b;
		attack = c;
		defence = d;
		money = e;
		exprence = f;
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
    int getexprence() {
		return exprence;
	}
}
