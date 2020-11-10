package core.plants;

import java.awt.image.BufferedImage;

public class Blover extends Plant{
	
	// 吹风草
	// 加载图片
	private static BufferedImage[] imgs;
	static {
		imgs = new BufferedImage[18];
		int j=0;
		for(int i=0;i<imgs.length;i+=3) {
			imgs[i] = loadImage("Blover"+j+".png");
			imgs[i+1] = loadImage("Blover"+j+".png");
			imgs[i+2] = loadImage("Blover"+j+".png");
			j++;
		}
	}
	
	// 获取图片，0-4为生存图片，5为卡片图片
	int index = 2;
	public BufferedImage getImage() {
		if(isWait()|| isStop()||isMove()) {
			return imgs[15];
		}else if(isLife()||isClick()) {
			return imgs[index++%15];//0-4
		}else {
			return null;
		}
	}
	
	// 吹风草独有的可点击状态
	public static final int CLICK = 5;
	
	// 判断状态
	public boolean isClick() {
		return state==CLICK;
	}
	
	// 改变状态
	public void goClick() {
		state = CLICK;
	}
	
	// 构造器
	public Blover() {
		super(90,80);
		live = 3;
	}
	
}
