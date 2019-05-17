
public class Hero {
	private int level;
	int Life;
	int attack;
	int defence;
	int money;
	int experience;
	int yellowkey;
	int bluekey;
	int redkey;

	Hero() {
		level = 1;
		Life = 1000;
		attack = 50;
		defence = 30;
		money = 0;
		experience = 0;
		yellowkey = 0;
		bluekey = 0;
		redkey = 0;
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

	public void keychange(int a) {
		if (a == 2) {
			redkey = redkey + 1;
		}
		if (a == 3) {
			yellowkey = yellowkey + 1;
		}
		if (a == 4) {
			bluekey = bluekey + 1;
		}
		if (a == 8) {
			yellowkey = yellowkey - 1;
		}
		if (a == 9) {
			redkey = redkey - 1;
		}
		if (a == 10) {
			bluekey = bluekey - 1;
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
			// ���Ӣ�۵Ĺ������ͷ�������Ҫ�ȹ��޴�ֱ�ӻ�ý�Ǯ�;���
			hero_money = hero_money + monster.getMoney();
			hero_experience = hero_experience + monster.getExperience();
			return 1;
		} else if (hero_defence < monster_attack && hero_attack < monster_defence) {
			// ���Ӣ�۵Ĺ������ͷ��������ȹ���ҪС�����ܴ��
			return -1;
		} else if (hero_attack > monster_defence && hero_defence < monster_attack) {
			// hero���� > monster������hero���� < monster���������Դ򣬼�Ѫ
			while (monster_life > 0) {
				monster_life = monster_life - (hero_attack - monster_defence);
				hero_life = hero_life - (monster_attack - hero_defence);
			}
			hero_money = hero_money + monster.getMoney();
			hero_experience = hero_experience + monster.getExperience();
			return 0;
		} else {
			// (hero_attack < monster_defence && hero_defence > monster_attack)
			// hero���� < monster������hero���� > monster���������Դ򣬵�Ѫ
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