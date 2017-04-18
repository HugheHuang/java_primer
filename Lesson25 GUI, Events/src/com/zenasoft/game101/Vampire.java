package com.zenasoft.game101;

import com.zenasoft.game101.Hunter;

public class Vampire extends Enemy {
	private double conversionRate;
	
	public double getConversionRate() {
		return conversionRate;
	}

	public void setConversionRate(double conversionRate) {
		this.conversionRate = conversionRate;
	}

	public Vampire(int typeCode){ /*
		定义构造函数，传入一个 int 类型。
		1 吸血蝙蝠
		2 吸血鬼
		3 吸血鬼王
		4 
		5 
		*/
		setAlive(true);
		setAglRatio(0.67);
		if (typeCode == 1) {
			setType("吸血蝙蝠");
			setMaxHP(40);
			setAttack(15);
			setDefence(8);
			setAgl(20);
			setConversionRate(0.45);
		} else if (typeCode == 2) {
			setType("吸血鬼");
			setMaxHP(35);
			setAttack(27);
			setDefence(5);
			setAgl(25);
			setConversionRate(0.66);
		} else if (typeCode == 3) {
			setType("吸血鬼王");
			setMaxHP(40);
			setAttack(10);
			setDefence(19);
			setAgl(14);
			setConversionRate(0.80);
		} else {
			System.out.println("指定吸血鬼类型错误。");
		}
		setCurHP(getMaxHP());
	}
		
	// 吸血的方法：传入 Hunter 受到的伤害
	public void hpUp(int hun_reduced) {
		int lifeAdded = (int)(hun_reduced * conversionRate + 0.5);
		setCurHP(getCurHP() + lifeAdded);
		if (getCurHP() >= getMaxHP()) {
			setCurHP(getMaxHP());
			System.out.println(line1+getType()+" 在吸血后处于满血状态。"+line2);
		} else if (hun_reduced != 0) {
			System.out.println(line1+getType()+" 吸取了 "+lifeAdded+" 生命。生命值："+getCurHP()+"。"+line2);
		}
	}
	
	public void attack(Hunter hun) {
		//若任意一方死亡则 return
		if (!isAlive() || !hun.isAlive()) {
			return;
		}
		
		//vam 的攻击，攻击的同时增加生命
		System.out.println(line1+getType()+" 向 "+hun.getName()+" 袭来。"+line2);
		int hun_reducedHP = hun.injured(this);	// this 表示自己，将自身整体做为一个参数传递，提高代码灵活度。
		hpUp(hun_reducedHP);
		
		//若对方死亡则调用对方的 death
		if (!hun.isAlive()) {
			hun.die(this);
		}
	}
}
