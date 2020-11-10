package core.zombies;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Zombie3 extends Zombie implements Award{
	
	// 足球僵尸
	// 加载图片
	private static BufferedImage imgs[];
	static {
		imgs = new BufferedImage[33];
		int j=0;
		for(int i=0;i<imgs.length;i+=3) {
			imgs[i] = loadImage("zombie3"+j+".png");
			imgs[i+1] = loadImage("zombie3"+j+".png");
			imgs[i+2] = loadImage("zombie3"+j+".png");
			j++;
		}
	}
	
	// 设置图片,0-5为生存，6-10为攻击
	int index = 0;
	public BufferedImage getImage() {
		if(isLife()) {
			return imgs[index++%18];//0-5
		}else if(isAttack()) {
			return imgs[index++%15+18];//6-10
		}else{
			return null;
		}
	}
	
	// 构造器
	private int awardType;
	public Zombie3() {
		super(154,160);
		live = 25;
		xSpeed = 4;
		Random rand = new Random();
		awardType = rand.nextInt(3);//0-2
	}
	
	// 僵尸移动
	public void step() {
		this.x-=xSpeed;
	}
	
	// 获取奖励类型
	public int getAwardType() {
		return awardType;
	}
	
	// 僵尸的停止状态结束
	public void goRun() {
		xSpeed = 4;
	}
	
}
