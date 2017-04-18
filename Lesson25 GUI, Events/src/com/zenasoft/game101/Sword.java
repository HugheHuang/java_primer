package com.zenasoft.game101;

public class Sword extends Weapon {
	public Sword(String name) {
		this.setName(name);
		this.setDesc("Sword");
		this.setLength(Hunter.HUNTER_WIDTH / 2 + 20);
	}
	@Override
	public int attack(Hunter hun, Enemy ene) {
		return ene.injured(hun);
	}

}
