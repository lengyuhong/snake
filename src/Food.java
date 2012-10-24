import java.awt.*;
import java.awt.event.*;

public class Food {
	public static int WIDTH = 20;
	public static int HEIGHT = 20;
	private boolean isLive = true;//�ж�ʳ��ʳ���Ƿ��Ѿ�������
	int x = 300,y = 300;//x,y��ʾʳ����ֵĵص�
	SnakeClient sc;
	public Food(SnakeClient sc){
		x = ((int)(Math.random()*29))*Snake.WIDTH;
		y = (int)(Math.random()*29+1)*Snake.HEIGHT;
		isLive = true;
		this.sc = sc;
	}
	
	public boolean isLive() {
		return isLive;
	}

	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	//�����ʳ�ﻨ����
	public void paint(Graphics g){
		if(isLive==true){
			Color c = g.getColor();
			g.setColor(Color.red);
			g.fillRect(x, y, WIDTH, HEIGHT);
			g.setColor(c);
		}
	}
	
	public Rectangle getRec(){
		return new Rectangle(x,y,WIDTH,HEIGHT);
	}
}
