package staff;

public class Monster extends Staff {
	private String name = null;

	public Monster(int life,int attack,int defence,int money,int experience,String name) {
		super(life, attack, defence, money, experience);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
