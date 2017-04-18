package com.zenasoft.game101;

public class LifestealSkill extends SkillDecorator {
	private Weapon weapon;
	private double conversionRate;
	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	public double getConversionRate() {
		return conversionRate;
	}
	public void setConversionRate(double conversionRate) {
		this.conversionRate = conversionRate;
	}

	public LifestealSkill(Weapon weapon, double conversionRate) {
		super();
		this.weapon = weapon;
		this.conversionRate = conversionRate;
		this.setLength(weapon.getLength());
		this.setName(weapon.getName());
	}
	@Override
	public String getDesc() {
		return "Lifestealing " + weapon.getDesc().toLowerCase();
	}

	@Override
	public int attack(Hunter hun, Enemy ene) {
		int reduced = weapon.attack(hun, ene);
		if(reduced > 0) {
			hpUp(hun, reduced);
		}
		return reduced;
	}
	
	public void hpUp(Hunter hun, int ene_reduced) {
		int lifeAdded = (int)(ene_reduced * conversionRate + 0.5);
		hun.setCurHP(hun.getCurHP() + lifeAdded);
		if (hun.getCurHP() >= hun.getMaxHP()) {
			hun.setCurHP(hun.getMaxHP());
			System.out.println(hun.getLine1()+hun.getName()+" 在吸血后处于满血状态。"+hun.getLine2());
		} else if (ene_reduced != 0) {
			System.out.println(hun.getLine1()+hun.getName()+" 吸取了 "+lifeAdded+" 生命。生命值："+hun.getCurHP()+"。"+hun.getLine2());
		}
	}

}
