package com.zenasoft.game101;

public class Minotaur extends Enemy {
	public Minotaur() {
		setType("The Minotaur");
		setMaxHP(55);
		setCurHP(getMaxHP());
		setAttack(13);
		setDefence(5);
		setAgl(40);
		setAglRatio(0.55);
		setAlive(true);
	}

	@Override
	public void attack(Hunter hun) {
		// 任意一方死亡则 return
		if(!isAlive()) {
			return;
		}
		if(!hun.isAlive()) {
			return;
		}
		
		// KillerCobra 的攻击
		System.out.println(line1+ getType() + " 攻击了 " + hun.getName() + "。" + line2);
		hun.injured(this);
		
		//若对方死亡则调用对方的 death
		if (!hun.isAlive()) {
			hun.die(this);
		}
	}
}
