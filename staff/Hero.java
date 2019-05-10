package staff;

public class Hero extends Staff {
	private int yellow_key = 1;
	private int blue_key = 1;
	private int red_key = 1;

	private int layer;
	private int level;

	public int getYellow_key() {
		return yellow_key;
	}

	public void setYellow_key(int yellow_key) {
		this.yellow_key = yellow_key;
	}

	public int getBlue_key() {
		return blue_key;
	}

	public void setBlue_key(int blue_key) {
		this.blue_key = blue_key;
	}

	public int getRed_key() {
		return red_key;
	}

	public void setRed_key(int red_key) {
		this.red_key = red_key;
	}

	public int getLayer() {
		return layer;
	}

	public void setLayer(int layer) {
		this.layer = layer;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Hero(int life, int attack, int defence, int money, int experience, int yellow_key, int blue_key, int red_key,
			int layer, int level) {
		super(life, attack, defence, money, experience);
		this.yellow_key = yellow_key;
		this.blue_key = blue_key;
		this.red_key = red_key;
		this.layer = layer;
		this.level = level;
	}

	public int attack(Monster monster) {
		int hero_life = getLife();
		int hero_attack = getAttack();
		int hero_defence = getDefence();
		int hero_money = getMoney();
		int hero_experience = getExperience();

		int monster_life = monster.getLife();
		int monster_defence = monster.getDefence();
		int monster_attack = monster.getAttack();

		if (hero_defence > monster_attack && hero_attack > monster_defence) {
			// 如果英雄的攻击力和防御力都要比怪兽大，直接获得金钱和经验
			hero_money = hero_money + monster.getMoney();
			hero_experience = hero_experience + monster.getExperience();
			return 1;
		} else if (hero_defence < monster_attack && hero_attack < monster_defence) {
			// 如果英雄的攻击力和防御力都比怪兽要小，不能打，溜！
			return -1;
		} else if (hero_attack > monster_defence && hero_defence < monster_attack) {
			// hero攻击 > monster防御，hero防御 < monster攻击，可以打，减血
			while (monster_life > 0) {
				monster_life = monster_life - (hero_attack - monster_defence);
				hero_life = hero_life - (monster_attack - hero_defence);
			}
			hero_money = hero_money + monster.getMoney();
			hero_experience = hero_experience + monster.getExperience();
			return 0;
		} else {
			// (hero_attack < monster_defence && hero_defence > monster_attack) 
			// hero攻击 < monster防御，hero防御 > monster攻击，可以打，掉血
			while (monster_life > 0) {
				monster_life = monster_life - (monster_defence - hero_attack);
				hero_life = hero_life - (hero_defence - monster_attack);
			}
			hero_money = hero_money + monster.getMoney();
			hero_experience = hero_experience + monster.getExperience();
			return 0;
		}
	}
}
