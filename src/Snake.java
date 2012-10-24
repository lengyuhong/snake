import java.awt.*;
import java.awt.event.*;

public class Snake {
	final static int WIDTH = 20;//����Ŀ�
	final static int HEIGHT = 20;//����ĸ�
	final static int maxLong = 900;//������еĽ���	
	enum Direction{Left,Up,Right,Down};
	
	int number = 5;//���м���

	int[] X = new int[maxLong];
	int[] Y = new int[maxLong]; 
	Direction snakeDirection = Direction.Down;
	SnakeClient sc;
	
	//���캯��
	public Snake(SnakeClient sc){
		this.number = 5;
		for(int i=0;i<=number;i++){
			X[i] = 100;
			Y[i] = 100+i*HEIGHT;
		}
		this.snakeDirection = Direction.Right;
		this.sc = sc;
	}

	//�����ĸ�������ƶ�
	public void move(){
		if(this.snakeDirection==Direction.Down){
			for(int i=0;i<number;i++){
				X[i] = X[i+1];
				Y[i] = Y[i+1];
			}
			Y[number] = Y[number]+HEIGHT; 
		}
		else if(this.snakeDirection==Direction.Right){
			for(int i=0;i<number;i++){
				X[i] = X[i+1];
				Y[i] = Y[i+1];
			}
			X[number] += WIDTH;
		}
		else if(this.snakeDirection==Direction.Up){
			for(int i=0;i<number;i++){
				X[i] = X[i+1];
				Y[i] = Y[i+1];
			}
			Y[number] = Y[number]-HEIGHT; 
		}
		if(this.snakeDirection==Direction.Left){
			for(int i=0;i<number;i++){
				X[i] = X[i+1];
				Y[i] = Y[i+1];
			}
			X[number] -= WIDTH;
		}
	}



	//���߻�����
	public void paint(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.BLUE);
		for(int i=0;i<=number;i++){
			g.fillRect(X[i],Y[i], WIDTH, HEIGHT);
		}
		g.setColor(c);
		move();
		eatFood(this.sc.food);
	}
	
	//��������ߵĿ���
	public void keyPress(KeyEvent e){
		int press = e.getKeyCode();
		switch(press){
			case KeyEvent.VK_LEFT:
				this.snakeDirection = Direction.Left;
				break;
			case KeyEvent.VK_UP:
				this.snakeDirection = Direction.Up;
				break;
			case KeyEvent.VK_RIGHT:
				this.snakeDirection = Direction.Right;
				break;
			case KeyEvent.VK_DOWN:
				this.snakeDirection = Direction.Down;
				break;
		}
		
	}
	
	//�߳Ե���ʳ��
	public void eatFood(Food food){
		//��ײ���
		if(this.getRec().intersects(food.getRec())){
			number++;
			X[number] = sc.food.getX();
			Y[number] = sc.food.getY();
			this.sc.food.setX(((int)(Math.random()*29))*Snake.WIDTH);
			this.sc.food.setY((int)(Math.random()*29+1)*Snake.HEIGHT);
		}
	}
	
	public Rectangle getRec(){
		return new Rectangle(X[number],Y[number],WIDTH,HEIGHT);
	}
		
	
}
