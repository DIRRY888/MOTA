
public class Hero {
	int level;
	int Life;
	int attack;
	int defence;
	int money;
	int experience;
	int yellowkey;
	int bluekey;
	int redkey;
	private int uniqueKey;

	public Hero() {
		level = 1;
		Life = 1000;
		attack = 50;
		defence = 30;
		money = 0;
		experience = 0;
		yellowkey = 0;
		bluekey = 0;
		redkey = 0;
		uniqueKey = 0;
	}

	int getLife() {
		return Life;
	}

	int getAttack() {
		return attack;
	}

	int getDefence() {
		return defence;
	}

	int getMoney() {
		return money;
	}

	int getExperience() {
		return experience;
	}

	public void printstate() {
		System.out.println("  hp:  " + this.Life + "    " + "  money:  " + this.money + "    " + "  experience:  "
				+ this.experience + "    ");
		System.out.println("  yellowkey:  " + this.yellowkey + "    " + "  bluekey:  " + this.bluekey + "    "
				+ "  redkey:  " + this.redkey + "    ");
	}

	public void keychange(int meet) {
		if (meet == 21) {
			redkey = redkey + 1;
		}
		if (meet == 22) {
			yellowkey = yellowkey + 1;
		}
		if (meet == 20) {
			bluekey = bluekey + 1;
		}
		if (meet == 11) {
			yellowkey = yellowkey - 1;
		}
		if (meet == 9) {
			redkey = redkey - 1;
		}
		if (meet == 8) {
			bluekey = bluekey - 1;
		}
		if (meet == 23) {
			uniqueKey = uniqueKey + 1;
		}
		if (meet == 10) {
			uniqueKey = uniqueKey - 1;
		}
			
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