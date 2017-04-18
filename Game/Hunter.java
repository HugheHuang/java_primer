package game013;

public class Hunter {
	//����
	int maxHP;
	int curHP;
	boolean isAlive;
	//���������
	int attack;
	int defence;
	//�����뼶��
	int level;
	int xp;
	//���ݶ�������ϵ��
	int agl;
	double aglRatio;
	//�ַ���
	String name;
	String weapon;
	
	public Hunter() {}
	public Hunter(String name, String weapon, int attack, int defence) {
		this.name = name;
		this.weapon = weapon;
		this.attack = attack;
		this.defence = defence;
		maxHP = 100;
		curHP = 100;
		level = 1;
		isAlive = true;
		xp = 0;
		agl = 35;
		aglRatio = 0.6;
		
	}
	
	String line1 = ">----- ";
	String line2 = " -----<";
	
	public void attack(Zombie zom) {
		//����κ�һ���������� return
		if (!isAlive || !zom.isAlive) {
			return;
		}
		
		//hun �Ĺ���
		System.out.println(line1+name+weapon+" ���� "+zom.type+" ˵���޳���������֪����֮�ˣ���Ը������⣡�����ڴ����࣡"+line2);
		zom.injured(this);// this ��ʾ�Լ���������������Ϊһ���������ݣ���ߴ������ȡ�
		
		//���Է���������öԷ��� death�����ۼӾ���ֵ��
		if (zom.isAlive==false) {
			zom.death(this);
			getXp(zom);
		}
		checkStatus();
		
		//����һ�غ�
		System.out.println();
	}
	
	public int calReduced (int zom_attack) { // ����ʵ�������˺�ֵ damage ����������ֵ reduced
		int reduced = 0;
		int hp_ori = curHP;
		int basicDamage = 7;
		int damage = zom_attack - defence + basicDamage;
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
	
	public boolean checkMiss (int agl, double aglRatio) {
		/* ����ж�
		 * 1�����ɶ�ܳɹ���Χ�����ݶ� * ����ϵ����
		 * 2��������������ж��Ƿ��ܳɹ�
		 */
		boolean miss = false;
		double aglRange = agl * aglRatio;
		double aglRandom = randomRange(1,100);
		if (aglRandom < aglRange) {
			miss = true;
		}
		return miss;
	}
	
	public static double randomRange(double start, double end) { // ��ȡ����֮��������
		double a = Math.random()*(end-start)+start;
		return a;
	}
	
	public void injured(Zombie zom) {
		//������һ�������� return
		if (!isAlive || !zom.isAlive) {
			return;
		}
		//�ж��Ƿ��ܳɹ�
		if (checkMiss(agl, aglRatio)) {
			System.out.println(line1+name+" ��ܳɹ���û���ܵ��˺���"+line2);
			return;
		}
		
		//����ܲ��ɹ�������� hun �� injured
		int reduced = calReduced(zom.attack);
		if (reduced==0) {
			System.out.println(line1+name+" û���ܵ��˺���"+line2);
		} else if (curHP>0) {
			System.out.println(line1 + name+"�������ˣ���"+line2);
			System.out.println(line1+name+" �ܵ��� " + reduced+" ���˺���" +line2);
		} else {
			System.out.println(line1+name+"����ϯ�ͣ�����"+line2);
			System.out.println(line1+name+" �ܵ��� " + reduced+" ���˺���" +line2);
		}
		checkStatus();
	}
	
	public void checkStatus() {
		int xpNeeded = calXpNeeded(level);
		while (xp >= xpNeeded) {
			levelUp();
			xpNeeded = calXpNeeded(level);
		}
		
		if (curHP<=0) {
			isAlive = false;
			show(xpNeeded);
		} else {
			show(xpNeeded);
		}
	}
	
	public int calXpNeeded(int level) {
		int xpNeeded = (level*level+level)*25;
		return xpNeeded;
	}
	
	public void getXp (Zombie zom) {
		xp += zom.maxHP;
	}
	
	public void show(int xpNeeded) {
		String str = "���";
		if (isAlive==false) {
			str = "������";
		}
		System.out.println(line1 + name+" ������ֵ��"+curHP+"/"+maxHP+"��������"+weapon+"����������"+attack+"����������"+defence+"������״̬��"+str+"��"+line2);
		System.out.println(line1 + name + " ��ǰ "+level+" ��������ֵ��"+xp+"/"+xpNeeded+"��"+line2);
	}
	
	public void levelUp() {
		level += 1;
		attack += 4;
		maxHP += 20;
		curHP = maxHP;
		defence += 3;
	}
	
	public void death(Zombie zom) {
		System.out.println(name+" �� "+zom.type+" ɱ���ˡ���Ϸ������");
	}
}
