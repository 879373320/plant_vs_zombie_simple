package core.plants;

import java.awt.image.BufferedImage;

public class WallNut extends Plant{
	
	// 坚果
	// 加载图片 
	private static BufferedImage[] imgs;
	static {
		imgs = new BufferedImage[18];
		int j=0;
		for(int i=0;i<imgs.length;i+=3) {
			imgs[i] = loadImage("WallNut"+j+".png");
			imgs[i+1] = loadImage("WallNut"+j+".png");
			imgs[i+2] = loadImage("WallNut"+j+".png");
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
	public WallNut() {
		super(65,73);
		live = 10;
	}
}
