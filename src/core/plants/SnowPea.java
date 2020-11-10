package core.plants;

import java.awt.image.BufferedImage;

import core.bullets.Bullet;
import core.bullets.SnowBullet;

public class SnowPea extends Plant implements Shoot{
	
	// 冰豌豆射手
	// 加载图片 
	private static BufferedImage[] imgs;
	static {
		imgs = new BufferedImage[18];
		int j=0;
		for(int i=0;i<imgs.length;i+=3) {
			imgs[i] = loadImage("SnowPea"+j+".png");
			imgs[i+1] = loadImage("SnowPea"+j+".png");
			imgs[i+2] = loadImage("SnowPea"+j+".png");
			j++;
		}
	}

	// 获取图片，0-4为生存图片，5为卡片图片
	int index = 1;
	public BufferedImage getImage() {
		if(isWait()|| isStop()||isMove()) {
			return imgs[15];
		}else if(isLife()) {
			return imgs[index++%15];//0-4
		}else {
			return null;
		}
	}

	// 构造器
	public SnowPea() {
		super(71,71);
		live = 5;
	}
	
	// 发射子弹
	public Bullet[] shoot() {
		Bullet[] bs = new Bullet[1];
		bs[0] = new SnowBullet(this.x+this.width,this.y+this.height/2-25);
		return bs;
	}

}
