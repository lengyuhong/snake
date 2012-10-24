//0.1:�γ�һ���������е���Ļ,��ʵ����Ļ�رչ���
//0.2:����һ�����˶�������
//0.3:��һ���߻�����
//0.4:ʹ���ܼ򵥵���һ����������
//0.5:ʹ�������ĸ�����������
//0.6:��ʼ����ʳ�������Ҳ���Կ�ʼ��ʳ��
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
		this.setTitle("�Ѷ��������̰����");
		this.setVisible(true);
		this.setResizable(false);
		//ʵ�ֳ������йرյĹ���
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(-1);
			}
		});
		this.addKeyListener(new KeyMointer());
		new Thread(new PaintThread()).start();
	}
	
	//��ͼ����
	public void paint(Graphics g){
		snake.paint(g);
		food.paint(g);
		g.drawString("�ߵĳ���"+snake.number, 20, 50);
	}

	//���̣߳�һ��PaintThread��
	class PaintThread implements Runnable{
		public void run() {
			//while��true����������һֱ����
			while(true){
				repaint();
					try {
						Thread.sleep(250);//��������̫���ˣ����Ǽ����ٶȶ���
					} catch (InterruptedException e) {
						e.printStackTrace();
					}				
			}
		}
	}
	
	//�Լ��̵��ߵĿ���
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
