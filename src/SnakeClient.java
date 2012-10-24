//0.1:形成一个程序运行的屏幕,并实现屏幕关闭功能
//0.2:画出一个能运动的物体
//0.3:将一条蛇画出来
//0.4:使蛇能简单地向一个方向动起来
//0.5:使蛇能向四个个方向动起来
//0.6:开始出现食物，而且蛇也可以开始吃食物
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SnakeClient extends Frame{
	public final static int WIDTH = 600;
	public final static int HEIGHT = 600;
	
	
	Snake  snake = new Snake(this);
	Food  food = new Food(this);
	
	public void lanch(){
		this.setBounds(200,100, WIDTH,HEIGHT);
		this.setTitle("佳墩软件——贪吃蛇");
		this.setVisible(true);
		this.setResizable(false);
		//实现程序运行关闭的功能
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(-1);
			}
		});
		this.addKeyListener(new KeyMointer());
		new Thread(new PaintThread()).start();
	}
	
	//画图函数
	public void paint(Graphics g){
		snake.paint(g);
		food.paint(g);
		g.drawString("蛇的长度"+snake.number, 20, 50);
	}

	//起线程，一个PaintThread类
	class PaintThread implements Runnable{
		public void run() {
			//while（true）保持蛇能一直运行
			while(true){
				repaint();
					try {
						Thread.sleep(250);//物体运行太快了，这是减慢速度而用
					} catch (InterruptedException e) {
						e.printStackTrace();
					}				
			}
		}
	}
	
	//对键盘的蛇的控制
	class KeyMointer extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			snake.keyPress(e);
		}
	}
	
	public static void main(String[] args){
		SnakeClient snakeClient = new SnakeClient();
		snakeClient.lanch();
	}
}
