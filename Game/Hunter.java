package game013;

public class Hunter {
	//生命
	int maxHP;
	int curHP;
	boolean isAlive;
	//攻击与防御
	int attack;
	int defence;
	//经验与级数
	int level;
	int xp;
	//敏捷度与折算系数
	int agl;
	double aglRatio;
	//字符串
	String name;
	String weapon;
	
	public Hunter() {}
	public Hunter(String name, String weapon, int attack, int defence) {
		this.name = name;
		this.weapon = weapon;
		this.attack = attack;
		this.defence = defence;
		maxHP = 100;
		curHP = 100;
		level = 1;
		isAlive = true;
		xp = 0;
		agl = 35;
		aglRatio = 0.6;
		
	}
	
	String line1 = ">----- ";
	String line2 = " -----<";
	
	public void attack(Zombie zom) {
		//如果任何一方死亡，则 return
		if (!isAlive || !zom.isAlive) {
			return;
		}
		
		//hun 的攻击
		System.out.println(line1+name+weapon+" 地向 "+zom.type+" 说：无耻老贼！岂不知天下之人，皆愿生啖你肉！安敢在此饶舌！"+line2);
		zom.injured(this);// this 表示自己，将自身整体做为一个参数传递，提高代码灵活度。
		
		//若对方死亡则调用对方的 death，并累加经验值。
		if (zom.isAlive==false) {
			zom.death(this);
			getXp(zom);
		}
		checkStatus();
		
		//另起一回合
		System.out.println();
	}
	
	public int calReduced (int zom_attack) { // 计算实际作用伤害值 damage 和生命减少值 reduced
		int reduced = 0;
		int hp_ori = curHP;
		int basicDamage = 7;
		int damage = zom_attack - defence + basicDamage;
		if (damage < basicDamage) {
			damage = basicDamage;
		}
		curHP -= damage;
		if (curHP > 0) {
			reduced = hp_ori - curHP;
		} else {
			reduced = hp_ori;
			curHP = 0;
		}
		return reduced;
	}
	
	public boolean checkMiss (int agl, double aglRatio) {
		/* 躲避判定
		 * 1、生成躲避成功范围（敏捷度 * 折算系数）
		 * 2、生成随机数以判定是否躲避成功
		 */
		boolean miss = false;
		double aglRange = agl * aglRatio;
		double aglRandom = randomRange(1,100);
		if (aglRandom < aglRange) {
			miss = true;
		}
		return miss;
	}
	
	public static double randomRange(double start, double end) { // 获取两数之间的随机数
		double a = Math.random()*(end-start)+start;
		return a;
	}
	
	public void injured(Zombie zom) {
		//若任意一方死亡则 return
		if (!isAlive || !zom.isAlive) {
			return;
		}
		//判断是否躲避成功
		if (checkMiss(agl, aglRatio)) {
			System.out.println(line1+name+" 躲避成功，没有受到伤害。"+line2);
			return;
		}
		
		//若躲避不成功，则继续 hun 的 injured
		int reduced = calReduced(zom.attack);
		if (reduced==0) {
			System.out.println(line1+name+" 没有受到伤害。"+line2);
		} else if (curHP>0) {
			System.out.println(line1 + name+"：“法克！”"+line2);
			System.out.println(line1+name+" 受到了 " + reduced+" 点伤害。" +line2);
		} else {
			System.out.println(line1+name+"：“席巴！！”"+line2);
			System.out.println(line1+name+" 受到了 " + reduced+" 点伤害。" +line2);
		}
		checkStatus();
	}
	
	public void checkStatus() {
		int xpNeeded = calXpNeeded(level);
		while (xp >= xpNeeded) {
			levelUp();
			xpNeeded = calXpNeeded(level);
		}
		
		if (curHP<=0) {
			isAlive = false;
			show(xpNeeded);
		} else {
			show(xpNeeded);
		}
	}
	
	public int calXpNeeded(int level) {
		int xpNeeded = (level*level+level)*25;
		return xpNeeded;
	}
	
	public void getXp (Zombie zom) {
		xp += zom.maxHP;
	}
	
	public void show(int xpNeeded) {
		String str = "存活";
		if (isAlive==false) {
			str = "已死亡";
		}
		System.out.println(line1 + name+" 的生命值："+curHP+"/"+maxHP+"，武器："+weapon+"，攻击力："+attack+"，防御力："+defence+"，生命状态："+str+"。"+line2);
		System.out.println(line1 + name + " 当前 "+level+" 级，经验值："+xp+"/"+xpNeeded+"。"+line2);
	}
	
	public void levelUp() {
		level += 1;
		attack += 4;
		maxHP += 20;
		curHP = maxHP;
		defence += 3;
	}
	
	public void death(Zombie zom) {
		System.out.println(name+" 被 "+zom.type+" 杀死了。游戏结束！");
	}
}
