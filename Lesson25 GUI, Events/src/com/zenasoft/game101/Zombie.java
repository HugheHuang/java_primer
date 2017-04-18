package com.zenasoft.game101;
import com.zenasoft.game101.Hunter;

public class Zombie extends Enemy {
	public Zombie(int typeCode){ /*
	定义构造函数，传入一个 int 类型。
	1 普通司徒
	2 魔法司徒
	3 钢盔司徒
	4 大司徒
	5 王司徒
	*/
		setAlive(true);
		setAglRatio(0.67);
		if (typeCode == 1) {
			setType("普通司徒");
			setMaxHP(40);
			setAttack(15);
			setDefence(8);
			setAgl(20);
		} else if (typeCode == 2) {
			setType("魔法司徒");
			setMaxHP(35);
			setAttack(27);
			setDefence(5);
			setAgl(25);
		} else if (typeCode == 3) {
			setType("钢盔司徒");
			setMaxHP(40);
			setAttack(10);
			setDefence(19);
			setAgl(14);
		} else if (typeCode == 4) {
			setType("大司徒");
			setMaxHP(60);
			setAttack(30);
			setDefence(10);
			setAgl(35);
		} else if (typeCode == 5) {
			setMaxHP(100);
			setType("王司徒");
			setAttack(30);
			setDefence(15);
			setAgl(40);
		} else {
			System.out.println("指定司徒类型错误。");
		}
		setCurHP(getMaxHP());
	}
	
	public void attack(Hunter hun) {
		//若任意一方死亡则 return
		if (!isAlive() || !hun.isAlive()) {
			return;
		}
		
		//zom 的攻击
		System.out.println(line1+getType()+"："+hun.getName()+"，你我相约，岂不美哉？"+line2);
		hun.injured(this);// this 表示自己，将自身整体做为一个参数传递，提高代码灵活度。
		
		//若对方死亡则调用对方的 death
		if (!hun.isAlive()) {
			hun.die(this);
		}
	}
}