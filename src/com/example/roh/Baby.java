package com.example.roh;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Baby {
     private Bitmap bitmap;
     private int x;
     private int dx;
     
     private int y;
     private Bucket bucket;
     private int speed;
     
     public Baby(Bitmap b,Bucket bu){
    	 
    	 int width=Constants.SCREEN_WIDTH;
    	 int height=Constants.SCREEN_HEIGHT;
    	 
    	 width/=14;
    	 height/=17;
    	 
    	 this.bucket=bu;
    	 this.x=bucket.getX();
    	 this.y=bucket.getY();
    	 bitmap=Bitmap.createScaledBitmap(b, width, height, true);
    	 dx=0;
    	 speed=10;
     }
     public void update(){
    	 dx=speed;
    	 
    	 x+=dx;
    	 
    	 dx=0;
     }
     public void draw(Canvas canvas){
    	 canvas.drawBitmap(bitmap, x,y,null);
     }
     
     
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
     
     
}
