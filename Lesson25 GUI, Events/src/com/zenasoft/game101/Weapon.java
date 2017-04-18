package com.zenasoft.game101;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Weapon {
	private String desc;
	private String name;
	private int length;
	private boolean isVisible;
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public boolean isVisible() {
		return isVisible;
	}
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	public Rectangle getRectangle(Hunter hun) {
		int x = hun.getX() + Hunter.HUNTER_WIDTH / 2;
		int y = hun.getY() + Hunter.HUNTER_HEIGHT / 2;
		if (hun.getDir() == Direction.LEFT) {
			return new Rectangle(x - length, y - 1, length, 3);
		} else if (hun.getDir() == Direction.UP) {
			return new Rectangle(x - 1, y - length, 3, length);
		} else if (hun.getDir() == Direction.RIGHT) {
			return new Rectangle(x, y - 1, length, 3);
		} else {
			return new Rectangle(x - 1, y, 3, length);
		}
	}
	
	public abstract int attack(Hunter hun, Enemy ene);
	
	public void paint(Hunter hun, Graphics g) {
		if (!isVisible) return;
		
		int x = hun.getX() + Hunter.HUNTER_WIDTH / 2;
		int y = hun.getY() + Hunter.HUNTER_HEIGHT / 2;
		
		g.setColor(Color.blue);
		if(hun.getDir() == Direction.LEFT) {
			g.drawLine(x, y, x - length, y);
		} else if (hun.getDir() == Direction.UP) {
			g.drawLine(x, y, x, y - length);
		} else if (hun.getDir() == Direction.RIGHT) {
			g.drawLine(x, y, x + length, y);
		} else if (hun.getDir() == Direction.DOWN) {
			g.drawLine(x, y, x, y + length);
		}
	}

	public Weapon(String desc, String name) {
		super();
		this.desc = desc;
		this.name = name;
		this.isVisible = false;
	}
	public Weapon() {
		super();
		// TODO Auto-generated constructor stub
	}
}
