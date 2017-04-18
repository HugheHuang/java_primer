public class TestGame02{
	public static void main (String[] args ){
		Hunter h=new Hunter();
		h.name="HUGHE";
		h.life=100;
		h.isLive=true;
		h.weapon="FOOD" ;
		
		Monster m=new Monster();
		m.type="normolzombie";
		m.life=100;
		m.isLive=true;
		
		
		}
		while(h.life>0){
		if (m.life<0){
			m.life=0;
		}
		if (h.life<0){
			h.life=0;
		}
		h.fight(m);
		m.show();
		h.show();
		if(m.life>0){
		System.out.println("CONTINUE!");
		m.fight(h);
		m.show();
		h.show();}
		
		else {
				System.out.println("YOUWIN!");
				break;
		}
		}
		if(h.life==0){
			System.out.println("GAMEOVER!");
		}
	}
}

class Hunter{
	int life;
	String name;
	boolean isLive;
	String weapon;
	
	public void fight(Monster monster){
		System.out.println(name+"»ÓÎè×Å"+weapon+"É±Ïò"+monster.type);
		monster.injured();
	}
    public void show () {
		System.out.println(name+",life"+life);
	}
	public void injured(){
		life-=30;
	}	
	
}

class Monster{
	int life;
	String type;
	boolean isLive;
	
	public void injured(){
		System.out.println(type+":fuck!");
		life-=20;
	}

	public void	show () {
		System.out.println(type+",life"+life);
	}
	public void fight(Hunter hunter){
		System.out.println(type+":fightback!");
		hunter.injured();
	}
	
}