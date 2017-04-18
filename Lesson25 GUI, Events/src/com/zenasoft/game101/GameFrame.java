package com.zenasoft.game101;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame {

	private GamePanel gp;
	private Hunter hun;
	private Enemy ene;
	
	public static final int GAMEFRAME_WIDTH = 800;
	public static final int GAMEFRAME_HEIGHT = 450;
	
	public static void main(String[] args) {
		new GameFrame();
	}
	
	public GameFrame() {
		hun = new Hunter("诸葛孔明", new LifestealSkill(new AgilityReductingSkill(new Sword("七米的咖喱棒"), 2), 0.54));
		// hun = new Hunter("诸葛孔明", new Sword("七米的咖喱棒"));
		hun.setFigure(10, 10, 8);
		ene = new Vampire(3);
		
		this.setLocation(300, 300);
		this.setSize(GAMEFRAME_WIDTH, GAMEFRAME_HEIGHT);
		this.setTitle("荒野猎人");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		gp = new GamePanel();
		this.add(gp);
		this.addKeyListener(new MyKeyEvent());
		
		this.setVisible(true);
		
	}
	
	private class GamePanel extends JPanel {
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.setColor(Color.black);
			g.fillRect(0, 0, GAMEFRAME_WIDTH, GAMEFRAME_HEIGHT);
			if(!hun.isAlive()) {
				paintDeathCurtain(g);
				return;
			}
			hun.paint(g);
			hun.getWeapon().paint(hun, g);
			ene.paint(g);
		}
	}
	
	
	private void paintDeathCurtain(Graphics g) {
		g.setColor(Color.RED);
		for(int i = 0; i <= GAMEFRAME_WIDTH; i += 20) {
			for(int j = 700; j >= -400; j -= 100) {
				g.drawString("Game Over!", i + j, i);
			}
		}
	}
	
	private class MyKeyEvent extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			super.keyPressed(e);
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				hun.setDir(Direction.LEFT);
				hun.move();
			} else if(e.getKeyCode() == KeyEvent.VK_UP) {
				hun.setDir(Direction.UP);
				hun.move();
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				hun.setDir(Direction.RIGHT);
				hun.move();
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				hun.setDir(Direction.DOWN);
				hun.move();
			} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				hun.getWeapon().setVisible(true);
			}
			// 如果 hunter 碰到 enemy，则 hunter 受伤
			if (checkOverlapped()) {
				hun.injured(ene);
			}
			// 如果 hunter 的 weapon 碰到 enemy，则 enemy 受伤
			if (checkOverlapped(hun.getWeapon())) {
				hun.attack(ene);
			}
			gp.repaint();
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			super.keyReleased(e);
			if(e.getKeyCode() == KeyEvent.VK_SPACE) {
				hun.getWeapon().setVisible(false);
			}
			gp.repaint();
		}
		
		private boolean checkOverlapped() {
			return hun.getRectangle().intersects(ene.getRectangle());
		}
		
		private boolean checkOverlapped(Weapon weapon) {
			if (!weapon.isVisible()) {
				return false;
			}
			return weapon.getRectangle(hun).intersects(ene.getRectangle());
		}
		
	}
}
