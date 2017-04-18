package com.zenasoft.game101;

public class Axe extends Weapon {
	public Axe(String name) {
		this.setName(name);
		this.setDesc("Axe");
		this.setLength(Hunter.HUNTER_WIDTH / 2 + 10);
	}
	@Override
	public int attack(Hunter hun, Enemy ene) {
		return ene.injured(hun);
	}
}
