package com.zenasoft.game101;
import java.util.ArrayList;
import java.util.List;

import com.zenasoft.game101.util.GameUtil;

public class Game {

	Hunter hun;
	List<Enemy> enemies;
	
	public Game(Hunter hun) {
		this.hun = hun;
		enemies = new ArrayList<Enemy>();
		enemies.add(new Zombie(1));
		enemies.add(new Zombie(1));
		enemies.add(new Zombie(1));
		enemies.add(new Zombie(2));
		enemies.add(new Zombie(3));
		enemies.add(new Zombie(4));
		enemies.add(new Vampire(1));
		enemies.add(new Vampire(2));
		enemies.add(new Vampire(3));
		enemies.add(new Vampire(3));
		enemies.add(new Vampire(3));
		enemies.add(new Vampire(3));
		enemies.add(new Vampire(3));
		enemies.add(new Vampire(3));
//		enemies.add(new KillerCobra());
//		enemies.add(new Minotaur());
	}
	
	public void start() {
		// 1、一直进行判断。
		while (true) {
			// 2、生成随机数 [0, enemies.size())，表示战斗对象。
			int ran = (int)GameUtil.randomRange(0, enemies.size());
			Enemy enemyChosen = enemies.get(ran);
			hun.attack(enemyChosen);
			if(!enemyChosen.isAlive()) {
				enemies.remove(ran);
			}
			
			// 3、如果 Hunter 死亡则调用 end() 后 return。
			if (!hun.isAlive()) {
				end();
				return;
			}
			// 4、如果所有 enemies 死亡则调用 end() 后 return。
			if (enemies.size() <= 0) {
				end();
				return;
			}
			
			// 以下段落可以让程序休息 1 秒钟。
			try {
				System.out.println("\n------------------- 寻找对手中 -------------------");
				Thread.sleep(1000);
			} catch (Exception e){
			}
		}
	}
	
	public void end() {
		// 判断 Hunter 是否死亡。没有则输出通关信息。
		if (hun.isAlive()) {
			System.out.println("恭喜过关！");
		} else {
			System.out.println("天有不测风云，是否重新来过？");
		}
		return;
	}
}
