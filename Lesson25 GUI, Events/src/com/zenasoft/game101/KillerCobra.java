package com.zenasoft.game101;
import com.zenasoft.game101.Hunter;

public class KillerCobra extends Enemy {

	public KillerCobra() {
		setType("Cobra");
		setMaxHP(33);
		setCurHP(getMaxHP());
		setAttack(33);
		setDefence(10);
		setAgl(34);
		setAglRatio(0.5);
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
