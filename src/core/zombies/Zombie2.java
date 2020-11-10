package core.zombies;

import java.awt.image.BufferedImage;

public class Zombie2 extends Zombie{
	
	// 旗子僵尸
	// 加载图片
	private static BufferedImage imgs[];
	static {
		imgs = new BufferedImage[30];
		int j=0;
		for(int i=0;i<imgs.length;i+=3) {
			imgs[i] = loadImage("zombie2"+j+".png");
			imgs[i+1] = loadImage("zombie2"+j+".png");
			imgs[i+2] = loadImage("zombie2"+j+".png");
			j++;
		}
	}
	
	// 设置图片,0-4为生存，5-9为攻击
	int index = 0;
	public BufferedImage getImage() {
		if(isLife()) {
			return imgs[index++%15];//0-4
		}else if(isAttack()) {
			return imgs[index++%15+15];//5-9
		}else{
			return null;
		}
	}	
	// 构造器
	public Zombie2() {
		super(166,144);
		live = 15;
		xSpeed = 3;
	}
	
	// 僵尸移动
	public void step() {
		this.x-=xSpeed;
	}
	
	// 僵尸的停止状态结束
	public void goRun() {
		xSpeed = 3;
	}
	
}
