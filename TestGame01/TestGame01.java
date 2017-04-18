public class TestGame01{
	public static void main (String[] args ){
		Hunter h=new Hunter();
		h.name="HUGHE";
		h.life=100;
		h.isLive=true;
		h.weapon="FOOD" ;
		
		Monster m=new Monster();
		m.type="normolzombie";
		m.life=40;
		m.isLive=true;
		
		
		h.fight(m);
		m.show();
		h.show();
	}
}

class Hunter{
	int life;
	String name;
	boolean isLive;
	String weapon;
	
	public void fight(Monster monster){
		System.out.println("----->"+name+"»ÓÎè×Å"+weapon+"É±Ïò"+monster.type+"<-----");
		monster.injured();
	}
    public void show () {
		System.out.println("*****"+name+",life"+isLive+",weapon"+weapon+"******");
	}
		
	
}

class Monster{
	int life;
	String type;
	boolean isLive;
	
	public void injured(){
		System.out.println("*****"+type+"fuck!"+"*****");
		life-=20;
	}
	public void	show () {
		System.out.println(type+",life"+life+",isLive"+isLive);
	}
	
	
}