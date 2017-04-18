package game013;

public class Zombie {
	String type;
	boolean isAlive;
	int curHP;
	int maxHP;
	int attack;
	int defence;
	
	public Zombie(int typeCode){ /*
	���幹�캯��������һ�� int ���͡�
	1 ��ͨ��ʬ
	2 ħ����ʬ
	3 ��ʬ
	*/
		isAlive = true;
		if (typeCode == 1) {
			curHP = 40;
			type = "��ͨ��ʬ";
			attack = 15;
			defence = 5;
		} else if (typeCode == 2) {
			curHP = 35;
			type = "ħ����ʬ";
			attack = 27;
			defence = 3;
		} else if (typeCode == 3) {
			curHP = 40;
			type = "�ֿ���ʬ";
			attack = 10;
			defence = 15;
		} else if (typeCode == 4) {
			curHP = 60;
			type = "��ʬ";
			attack = 30;
			defence = 10;
		} else if (typeCode == 5) {
			curHP = 40;
			type = "��˾ͽ";
			attack = 15;
			defence = 5;
		} else {
			System.out.println("ָ����ʬ���ʹ���");
		}
		maxHP = curHP;
	}
	
	String line1 = "[";
	String line2 = "]";
	
	public void attack(Hunter hun) {
		//������һ�������� return
		if (!isAlive || !hun.isAlive) {
			return;
		}
		
		//zom �Ĺ���
		System.out.println(line1+type+"��"+hun.name+"��������Լ�������գ�"+line2);
		hun.injured(this);// this ��ʾ�Լ���������������Ϊһ���������ݣ���ߴ������ȡ�
		show();
		
		//���Է���������öԷ��� death
		if (!hun.isAlive) {
			hun.death(this);
		}
		
		//����һ�غ�
		System.out.println();
	}
	
	public int calReduced(int hun_attack) { // ����ʵ�������˺�ֵ damage ����������ֵ reduced
		int reduced = 0;
		int hp_ori = curHP;
		int basicDamage = 7;
		int damage = hun_attack - defence + basicDamage;
		if (damage < basicDamage) {
			damage = basicDamage;
		}
		curHP -= damage;
		if (curHP > 0) {
			reduced = hp_ori - curHP;
		} else {
			reduced = hp_ori;
			curHP = 0;
		}
		return reduced;
	}
	
	public void injured(Hunter hun) {
		if (!isAlive || !hun.isAlive) {
			return;
		}
		//hun �� injured
		int reduced = calReduced(hun.attack);
		if (reduced==0) {
			System.out.println(line1+type+" û���ܵ��˺���"+line2);
		} else if (curHP>0) {
			System.out.println(line1 + type+"��������򡭡���ң���"+line2);
			System.out.println(line1+type+" �ܵ��� " + reduced+" ���˺���" +line2);
		} else {
			System.out.println(line1+type+"�����㡭���㡭�����������ء�"+line2);
			System.out.println(line1+type+" �ܵ��� " + reduced+" ���˺���" +line2);
		}
		checkStatus();
		if (isAlive) { // ����������򷴻���
			attack(hun);
		}
	}
	
	public void checkStatus() {
		if (curHP<=0) {
			isAlive = false;
			show();
		} else {
			show();
		}
	}
	
	public void show() {
		String str = "���";
		if (isAlive == false) {
			str = "������";
		}
		System.out.println(line1 + type+" ������ֵ��"+curHP+"/"+maxHP+"����������"+attack+"����������"+defence+"������״̬��"+str+"��"+line2);
	}
	
	public void death(Hunter hun) {
		System.out.println(hun.name+" ɱ����һֻ "+type+"������� "+maxHP+" �㾭��ֵ��");
	}
}