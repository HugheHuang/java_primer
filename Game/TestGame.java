package game013;

/* ʵ�ֹ��ܣ�

���Ӷ��
	1�������� (agility) �йء�
	2��ʲô������Ƕ�ܳɹ���
		����һ��������ޣ�60%���� agility �����޽��п��ơ�
		�����ܳɹ���Χ�� 20��������һ�� 1-100 �����������������<20�����ܳɹ���

*/



public class TestGame {
	public static void main (String[] args) {
		Hunter hun = new Hunter("������", "�����޳�", 20, 10);
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