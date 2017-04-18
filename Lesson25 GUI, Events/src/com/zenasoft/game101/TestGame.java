package com.zenasoft.game101;
/* 实现功能：
	增加敌人：吸血鬼、黑暗骑士、牛头怪
	（不同的敌人有不同的攻击方式）
	1. 定义一个新的类来表示吸血鬼
		1.1 新增属性 吸取生命转换率 conversionRate
		1.2 新增方法 吸取生命 getLife()
		1.3 获取生命的方式：把伤害的 conversionRate 转换为生命
	2. 实现
		2.1 在 Hunter 的受伤情况下来决定（在 Vampire 中判断）
		2.2 当 Hunter 受伤之后进行吸备操作
			获取 Hunter 丢失的生命，让 Vampire 的生命增加 丢失生命 * conversionRate
			（注意 Vampire 增加的是 curLife，最大值不应超过 maxLife）
*/

import com.zenasoft.game101.Game;
import com.zenasoft.game101.Hunter;

public class TestGame {
	public static void main (String[] args) {
		// 输入 Hunter 的名称和武器
		Sword calibur = new Sword("七米的咖喱棒");
		Axe decaxe = new Axe("Decaxe");
		LifestealSkill lsAxe = new LifestealSkill(decaxe, 0.54);
		LifestealSkill superSword = new LifestealSkill(new AgilityReductingSkill(calibur, 2), 0.54);
		Hunter hun = new Hunter("诸葛孔明", superSword);
		new Game(hun).start();
	}
}