package game013;

public class Zombie {
	String type;
	boolean isAlive;
	int curHP;
	int maxHP;
	int attack;
	int defence;
	
	public Zombie(int typeCode){ /*
	定义构造函数，传入一个 int 类型。
	1 普通僵尸
	2 魔法僵尸
	3 大僵尸
	*/
		isAlive = true;
		if (typeCode == 1) {
			curHP = 40;
			type = "普通僵尸";
			attack = 15;
			defence = 5;
		} else if (typeCode == 2) {
			curHP = 35;
			type = "魔法僵尸";
			attack = 27;
			defence = 3;
		} else if (typeCode == 3) {
			curHP = 40;
			type = "钢盔僵尸";
			attack = 10;
			defence = 15;
		} else if (typeCode == 4) {
			curHP = 60;
			type = "大僵尸";
			attack = 30;
			defence = 10;
		} else if (typeCode == 5) {
			curHP = 40;
			type = "王司徒";
			attack = 15;
			defence = 5;
		} else {
			System.out.println("指定僵尸类型错误。");
		}
		maxHP = curHP;
	}
	
	String line1 = "[";
	String line2 = "]";
	
	public void attack(Hunter hun) {
		//若任意一方死亡则 return
		if (!isAlive || !hun.isAlive) {
			return;
		}
		
		//zom 的攻击
		System.out.println(line1+type+"："+hun.name+"，你我相约，岂不美哉？"+line2);
		hun.injured(this);// this 表示自己，将自身整体做为一个参数传递，提高代码灵活度。
		show();
		
		//若对方死亡则调用对方的 death
		if (!hun.isAlive) {
			hun.death(this);
		}
		
		//另起一回合
		System.out.println();
	}
	
	public int calReduced(int hun_attack) { // 计算实际作用伤害值 damage 和生命减少值 reduced
		int reduced = 0;
		int hp_ori = curHP;
		int basicDamage = 7;
		int damage = hun_attack - defence + basicDamage;
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
	
	public void injured(Hunter hun) {
		if (!isAlive || !hun.isAlive) {
			return;
		}
		//hun 的 injured
		int reduced = calReduced(hun.attack);
		if (reduced==0) {
			System.out.println(line1+type+" 没有受到伤害。"+line2);
		} else if (curHP>0) {
			System.out.println(line1 + type+"：“诸葛村夫……你敢！”"+line2);
			System.out.println(line1+type+" 受到了 " + reduced+" 点伤害。" +line2);
		} else {
			System.out.println(line1+type+"：“你……你……呃呜呜呜呜”"+line2);
			System.out.println(line1+type+" 受到了 " + reduced+" 点伤害。" +line2);
		}
		checkStatus();
		if (isAlive) { // 如果还活着则反击。
			attack(hun);
		}
	}
	
	public void checkStatus() {
		if (curHP<=0) {
			isAlive = false;
			show();
		} else {
			show();
		}
	}
	
	public void show() {
		String str = "存活";
		if (isAlive == false) {
			str = "已死亡";
		}
		System.out.println(line1 + type+" 的生命值："+curHP+"/"+maxHP+"，攻击力："+attack+"，防御力："+defence+"，生命状态："+str+"。"+line2);
	}
	
	public void death(Hunter hun) {
		System.out.println(hun.name+" 杀死了一只 "+type+"，获得了 "+maxHP+" 点经验值。");
	}
}