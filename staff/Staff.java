package staff;

public class Staff {
	private int life;
	private int attack;
	private int defence;
	private int money;
	private int experience;
	
	public Staff(int life,int attack,int defence,int money,int experience) {
		this.life = life;
		this.attack = attack;
		this.defence = defence;
		this.money = money;
		this.experience = experience;
	}
	
	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getExperience() {
		return experience;
	}
	
	public void setExperience(int experience) {
		this.experience = experience;
	}
}
