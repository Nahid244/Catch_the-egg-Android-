package com.example.roh;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;

public class Bucket {
     private Bitmap bitmap;
     private int x;
     private int y;
     
     public Bucket(Bitmap b,int x,int y){
    	 int width=Constants.SCREEN_WIDTH;
    	 int height=Constants.SCREEN_HEIGHT;
    	 
    	 width/=7;
    	 height/=7;
    	 this.x=x;
    	 this.y=y;
    	 
    	 bitmap=Bitmap.createScaledBitmap(b,width,height,true);
    	 
    	 
    	 
     }
     public void update(Point point){
    	 y=point.y-(bitmap.getHeight()/2);
    	 
    	 
     }
     public void draw(Canvas canvas){
    	 
    	 canvas.drawBitmap(bitmap,x,y,null);
    	 
    	 
     }
	public int getbucketWidth(){
		return bitmap.getWidth();
	}
	public int getbucketHeight(){
		return bitmap.getHeight();
	}
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	 public Rect getBounds(){
    	 return new Rect(x,y,x+bitmap.getWidth(),y+bitmap.getHeight());
     }
     
}
