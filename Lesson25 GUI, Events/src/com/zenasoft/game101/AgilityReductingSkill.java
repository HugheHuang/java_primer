package com.zenasoft.game101;

public class AgilityReductingSkill extends SkillDecorator {
	private Weapon weapon;
	private int aglSub;
	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	public int getAglSub() {
		return aglSub;
	}
	public void setAglSub(int aglSub) {
		this.aglSub = aglSub;
	}

	public AgilityReductingSkill(Weapon weapon, int aglReduced) {
		super();
		this.weapon = weapon;
		this.aglSub = aglReduced;
		this.setLength(weapon.getLength());
		this.setName(weapon.getName());
	}
	@Override
	public String getDesc() {
		return "Agility reductive " + weapon.getDesc().toLowerCase();
	}

	@Override
	public int attack(Hunter hun, Enemy ene) {
		int eneReduced = weapon.attack(hun, ene);
		if(eneReduced > 0) {
			reduceAgility(ene);
		}
		return eneReduced;
	}
	
	public void reduceAgility(Enemy ene) {
		int curAgl = ene.getAgl() - aglSub;
		if(curAgl < 0) {
			curAgl = 0;
		}
		ene.setAgl(curAgl);
		System.out.println(ene.getLine1() + ene.getType() + " 的敏捷度降低为 " + curAgl + "。" + ene.getLine2());
	}

}
