package com.example.roh;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Pumkin {
     private Bitmap bitmap;
     private int x;
     private int dx;
     
     private int y;
     private Witch witch;
     
     private int speed;
    
     
     public Pumkin(Bitmap b,Witch w){
    	 int width=Constants.SCREEN_WIDTH;
    	 int height=Constants.SCREEN_HEIGHT;
    	 
    	 width/=16;
    	 height/=16;
    	 
    	 this.witch=w;
    	 
    	 this.x=w.getX()+w.getWidth()/2;
    	 this.y=w.getY()+w.getHeight()/2;
    	 
    	 bitmap=Bitmap.createScaledBitmap(b, width, height, true);
    	 
    	 speed=8;
    	dx=0;
    	 
     }
     public void update(){
    	 
    	dx=-speed;
    		 x+=dx; 
    	 
    	 dx=0;
    	
     }
     public void draw(Canvas canvas){
    	 canvas.drawBitmap(bitmap,x,y,null);
     }
     public int getX(){
    	 return x;
     }
     
     public int getY(){
    	 return y;
     }
     public Rect getBounds(){
    	 return new Rect(x+bitmap.getWidth()/8,y+bitmap.getHeight()/8,(x+bitmap.getWidth()-(bitmap.getWidth()/8)),(y+bitmap.getHeight())-(bitmap.getHeight()/8));
     }
     
}
