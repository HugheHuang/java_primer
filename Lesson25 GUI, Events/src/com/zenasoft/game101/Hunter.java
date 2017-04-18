package com.zenasoft.game101;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.zenasoft.game101.util.GameUtil;

public class Hunter {
	// Hunter 角色图形属性
	public static final int HUNTER_WIDTH = 30;
	public static final int HUNTER_HEIGHT = 30;
	public static final int HUNTER_EYE_RADIUS = 5;
	private int x, y, speed;
	private Direction dir;
	//生命
	private int maxHP;
	private int curHP;
	private boolean isAlive;
	//攻击与防御
	private int attack;
	private int defence;
	//经验与级数
	private int level;
	private int exp;
	//敏捷度与折算系数
	private int agl;
	private double aglRatio;
	//字符串
	private String name;
	private Weapon weapon;
	
	public int getMaxHP() {
		return maxHP;
	}
	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}
	public int getCurHP() {
		return curHP;
	}
	public void setCurHP(int curHP) {
		this.curHP = curHP;
	}
	public boolean isAlive() {
		return isAlive;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
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
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
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
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public String getLine1() {
		return line1;
	}
	public String getLine2() {
		return line2;
	}
	public Direction getDir() {
		return dir;
	}
	public void setDir(Direction dir) {
		this.dir = dir;
	}
	public void setFigure(int x, int y, int speed) {
		this.x = x;
		this.y = y;
		this.speed = speed;
	}
	public Rectangle getRectangle() {
		return new Rectangle(x, y, HUNTER_WIDTH, HUNTER_HEIGHT);
	}
	
	public Hunter(String name, Weapon weapon) {
		this.name = name;
		this.weapon = weapon;
		attack = 12;
		defence = 18;
		maxHP = 100;
		curHP = maxHP;
		level = 1;
		isAlive = true;
		exp = 0;
		agl = 15;
		aglRatio = 0.8;
		dir = Direction.RIGHT;	// 默认角色朝向为右
	}
	
	private String line1 = ">----- ";
	private String line2 = " -----<";
	
	// 绘制角色，传入画笔
	public void paint(Graphics g) {
		// 绘制角色身体
		g.setColor(Color.red);
		g.fillRect(x, y, HUNTER_WIDTH, HUNTER_HEIGHT);
		// 绘制角色眼睛（和朝向有关）
		int eyeSize = HUNTER_EYE_RADIUS * 2;
		int eyeX = 0, eyeY = 0;
		if(dir == Direction.RIGHT) {
			eyeX = x + HUNTER_WIDTH - eyeSize;
			eyeY = y + HUNTER_HEIGHT / 2 - HUNTER_EYE_RADIUS;
		} else if(dir == Direction.LEFT) {
			eyeX = x;
			eyeY = y + HUNTER_HEIGHT / 2 - HUNTER_EYE_RADIUS;
		} else if(dir == Direction.UP) {
			eyeX = x + HUNTER_WIDTH / 2 - HUNTER_EYE_RADIUS;
			eyeY = y;
		} else if(dir == Direction.DOWN) {
			eyeX = x + HUNTER_WIDTH / 2 - HUNTER_EYE_RADIUS;
			eyeY = y + HUNTER_HEIGHT - eyeSize;
		}
		g.setColor(Color.black);
		g.fillOval(eyeX, eyeY, eyeSize, eyeSize);
		
		// 绘制名字
		GameUtil.paintIdentity(g, this);
		
		// 绘制血条
		GameUtil.paintLifebar(g, x, y, HUNTER_WIDTH, curHP, maxHP);
		
	}
	
	public void attack(Enemy ene) {
		//如果任何一方死亡，则 return
		if (!isAlive || !ene.isAlive()) {
			return;
		}
		
		//hun 的攻击
		System.out.println(line1+name+" 使用 "+weapon.getDesc()+" "+weapon.getName()+" 向 "+ene.getType()+" 发起攻击！"+line2);
		weapon.attack(this, ene);
		
		//若对方死亡则调用对方的 death，并累加经验值。
		if (!ene.isAlive()) {
			ene.death(this);
			getExp(ene);
		}
		checkStatus();
		
		//另起一回合
		System.out.println();
	}
	
	// 由 Enemy 造成伤害
	public int injured(Enemy ene) {
		//若任意一方死亡则 return
		if (!isAlive || !ene.isAlive()) {
			return 0;
		}
		
		// 碰到则退后
		GameUtil.getRepelled(ene, this);
		
		//判断是否躲避成功
		if (GameUtil.checkMiss(agl, aglRatio)) {
			System.out.println(line1+name+" 躲避成功，没有受到伤害。"+line2);
			show(calXpNeeded(level));
			return 0;
		}
		
		//若躲避不成功，则继续 hun 的 injured
		int reduced = GameUtil.calReduced(curHP, ene.getAttack(), defence);	// 获取丢失的生命
		curHP -= reduced;	// 减去丢失的生命
		if (reduced == 0) {
			System.out.println(line1+name+" 没有受到伤害。"+line2);
		} else if (curHP>0) {
			System.out.println(line1 + name+"：“法克！”"+line2);
			System.out.println(line1+name+" 受到了 " + reduced+" 点伤害。" +line2);
		} else {
			System.out.println(line1+name+"：“席巴！！”"+line2);
			System.out.println(line1+name+" 受到了 " + reduced+" 点伤害。" +line2);
		}
		
		// 检查生命状态
		checkStatus();
		return reduced;
	}
	
	public void checkStatus() {
		int expNeeded = calXpNeeded(level);
		while (exp >= expNeeded) {
			levelUp();
			expNeeded = calXpNeeded(level);
		}
		
		if (curHP <= 0) {
			isAlive = false;
			show(expNeeded);
		} else {
			show(expNeeded);
		}
	}
	
	public int calXpNeeded(int level) {
		int xpNeeded = (level*level+level)*25;
		return xpNeeded;
	}
	
	public void getExp (Enemy ene) {
		exp += ene.getMaxHP();
	}
	
	public void show(int expNeeded) {
		String str = "存活";
		if (isAlive==false) {
			str = "已死亡";
		}
		System.out.println(line1 + name+" 的生命值："+curHP+"/"+maxHP+"，武器："+weapon.getDesc()+" "+weapon.getName()+"，攻击力："+attack+"，防御力："+defence+"，生命状态："+str+"。"+line2);
		System.out.println(line1 + name + " 当前 "+level+" 级，经验值："+exp+"/"+expNeeded+"。"+line2);
	}
	
	public void levelUp() {
		level += 1;
		attack += 4;
		maxHP += 20;
		curHP = maxHP;
		defence += 3;
		System.out.println(line1 + name + " 升级了！" + line2);
	}
	
	public void die(Enemy enemy) {
		System.out.println(name+" 被 "+enemy.getType()+" 杀死了。游戏结束！");
	}
	
	public void move() {
		if(dir == Direction.LEFT) {
			this.x -= speed;
		} else if (dir == Direction.UP) {
			this.y -= speed;
		} else if (dir == Direction.RIGHT) {
			this.x += speed;
		} else if (dir == Direction.DOWN) {
			this.y += speed;
		}
	}
}
