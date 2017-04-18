package game013;

/* 实现功能：

增加躲避
	1、与敏捷 (agility) 有关。
	2、什么情况算是躲避成功：
		定义一个躲避上限：60%，用 agility 与上限进行控制。
		如果躲避成功范围是 20，则生成一个 1-100 的随机数。若生成数<20，则躲避成功。

*/



public class TestGame {
	public static void main (String[] args) {
		Hunter hun = new Hunter("诸葛孔明", "厚颜无耻", 20, 10);
		Zombie zom1 = new Zombie(1);
		Zombie zom2 = new Zombie(2);
		Zombie zom3 = new Zombie(3);
		Zombie zom4 = new Zombie(4);
		Zombie zom5 = new Zombie(5);
		hun.attack(zom5);
		//zom.attack(hun);
		hun.attack(zom5);
	}
}