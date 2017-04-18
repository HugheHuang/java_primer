package com.zenasoft.game101;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.zenasoft.game101.util.GameUtil;

public abstract class Enemy {
	// 绘图属性
	private int x;
	private int y;
	private int width;
	private int height;
	private int speed;
	
	// 常规属性
	private String type;
	private boolean isAlive;
	private int curHP;
	private int maxHP;
	private int attack;
	private int defence;
	private int agl;
	private double aglRatio;
	
	protected String line1 = "[";
	protected String line2 = "]";
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public int getCurHP() {
		return curHP;
	}

	public void setCurHP(int curHP) {
		this.curHP = curHP;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public int getAgl() {
		return agl;
	}

	public void setAgl(int agl) {
		this.agl = agl;
	}

	public double getAglRatio() {
		return aglRatio;
	}

	public void setAglRatio(double aglRatio) {
		this.aglRatio = aglRatio;
	}

	public String getLine1() {
		return line1;
	}

	public String getLine2() {
		return line2;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Rectangle getRectangle() {
		return new Rectangle(x, y, width, height);
	}
	
	public Enemy() {
		x = 100;
		y = 100;
		width = 30;
		height = 30;
	}
	
	public void paint(Graphics g) {
		if(!isAlive) {
			return;
		}
		g.setColor(Color.gray);
		g.fillRect(x, y, width, height);
		// 绘制名字
		GameUtil.paintIdentity(g, this);
		// 绘制血条
		GameUtil.paintLifebar(g, x, y, width, curHP, maxHP);
	}

	public abstract void attack(Hunter hun);
	
	public int injured(Hunter hun) {
		// 接触后弹
		GameUtil.getRepelled(hun, this);
		
		//判断是否躲避成功
		int reduced = 0;
		if (GameUtil.checkMiss(agl, aglRatio)) {
			System.out.println(line1+type+" 躲避成功，没有受到伤害。"+line2);
			show();
		} else {
			//zom 的 injured
			reduced = GameUtil.calReduced(curHP, hun.getAttack(), defence);	// 获取丢失的生命
			curHP -= reduced;	// 减去丢失的生命
			if (reduced==0) {
				System.out.println(line1+type+" 没有受到伤害。"+line2);
			} else if (curHP>0) {
				System.out.println(line1 + type+"：“"+hun.getName()+"……你敢！”"+line2);
				System.out.println(line1+type+" 受到了 " + reduced+" 点伤害。" +line2);
			} else {
				System.out.println(line1+type+"：“你……你……呃呜呜呜呜”"+line2);
				System.out.println(line1+type+" 受到了 " + reduced+" 点伤害。" +line2);
				die();
				return reduced;
			}
			show();
		}
		// 如果还活着则反击。
		attack(hun);
		return reduced;
	}
	
	public void die() {
		if (curHP<=0) {
			isAlive = false;
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
		System.out.println(hun.getName()+" 杀死了一只 "+type+"，获得了 "+maxHP+" 点经验值。");
	}
}