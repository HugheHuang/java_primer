package com.zenasoft.game101.util;

import java.awt.Color;
import java.awt.Graphics;

import com.zenasoft.game101.Direction;
import com.zenasoft.game101.Enemy;
import com.zenasoft.game101.Hunter;

/*
 * 新建一个类 GameUtil，内含带 static 的函数，聚合所有对象中重复的内容。
 */

public class GameUtil {
	public static boolean checkMiss (int agl, double aglRatio) {
		/* 躲避判定
		 * 1、生成躲避成功范围（敏捷度 * 折算系数）
		 * 2、生成随机数以判定是否躲避成功
		 */
		boolean miss = false;
		double aglRange = agl * aglRatio;
		double aglRandom = GameUtil.randomRange(0,100);
		if (aglRandom < aglRange) {
			miss = true;
		}
		return miss;
	}
	
	public static double randomRange(double start, double end) { // 获取两数之间的随机数 [start, end)
		double a = Math.random()*(end-start)+start;
		return a;
	}
	
	public static int calReduced (int curHP, int opp_attack, int defence) { // 计算实际作用伤害值 damage 和生命减少值 reduced
		int reduced = 0;
		int hp_ori = curHP;
		int basicDamage = 7;
		int damage = opp_attack - defence + basicDamage;
		if (damage < basicDamage) {
			damage = basicDamage;
		}
		curHP -= damage;
		if (curHP > 0) {
			reduced = hp_ori - curHP;
		} else {
			reduced = hp_ori;
		}
		return reduced;
	}
	
	public static void paintIdentity(Graphics g, Object obj) {
		if (obj instanceof Hunter) {
			Hunter hun = (Hunter)obj;
			g.setColor(Color.YELLOW);
			g.drawString(hun.getName(), hun.getX() - 9, hun.getY() - 14);
		} else {
			Enemy ene = (Enemy)obj;
			g.setColor(Color.red);
			g.drawString(ene.getType(), ene.getX() - 9, ene.getY() - 14);
		}
	}
	
	public static void paintLifebar(Graphics g, int x, int y, int width, int curHP, int maxHP) {
		// 绘制血条
		g.setColor(Color.WHITE);
		int lifeBarHeight = 6;	// 血条高度
		double lifeRatio = (double)curHP / maxHP;	// 血条填充百分比
		int lifeFillWidth = (int)(width * lifeRatio + 0.5) - 1;	// 血条填充宽度（-1 是为了立体效果）
		if(lifeFillWidth <= 0 ) {
			lifeFillWidth = 0;	// 避免血条填充宽度为负数
		}
		g.drawRect(x - 1, y - lifeBarHeight - 4, width + 1, lifeBarHeight);
		if (curHP >= maxHP * 0.7) {
			g.setColor(Color.GREEN);
		} else if (curHP >= maxHP * 0.4) {
			g.setColor(Color.ORANGE);
		} else {
			g.setColor(Color.RED);
		}
		g.fillRect(x, y - lifeBarHeight - 3, lifeFillWidth, lifeBarHeight - 2);
	}
	
	public static void getRepelled(Object att, Object inj) {
		// att 是攻方，inj 是受方
		if (inj instanceof Hunter) {
			Hunter hun = (Hunter)inj;
			int bias = 1;
			if (hun.getDir() == Direction.LEFT) {
				hun.setX(hun.getX() + bias * hun.getSpeed() );
			} else if (hun.getDir() == Direction.UP) {
				hun.setY(hun.getY() + bias * hun.getSpeed() );
			} else if (hun.getDir() == Direction.RIGHT) {
				hun.setX(hun.getX() - bias * hun.getSpeed() );
			} else {
				hun.setY(hun.getY() - bias * hun.getSpeed() );
			}
		} else {
			Hunter hun = (Hunter)att;
			Enemy ene = (Enemy)inj;
			int bias = -1;
			if (hun.getDir() == Direction.LEFT) {
				// ene.setX(ene.getX() + bias * ene.getSpeed() * 2);
				ene.setX(ene.getX() + bias * 2);
			} else if (hun.getDir() == Direction.UP) {
				ene.setY(ene.getY() + bias * 2);
			} else if (hun.getDir() == Direction.RIGHT) {
				ene.setX(ene.getX() - bias * 2);
			} else {
				ene.setY(ene.getY() - bias * 2);
			}
		}
		
	}
}
