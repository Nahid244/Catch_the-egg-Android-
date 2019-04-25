package com.example.roh;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Bhoot {
     private Bitmap bitmap;
     private Rect sourceRect;
     
     private int currentFrame;
     private long frameTicker;
     private int frameNr1;
    
     
     private int timePeriod;
     
     private int spriteWidth;
     private int spriteHeight;
     
     private int x;
     private int y;
     private int speed;
     
    
     
     
     public Bhoot(Bitmap b,int x,int y,int fps,int frameCount1){
    	 int width=Constants.SCREEN_WIDTH;
    	 
    	 int height=Constants.SCREEN_HEIGHT;
    	 width/=2;
    	 height/=4;
    	 this.x=x;
    	 this.y=y;
    	 
    	 bitmap=Bitmap.createScaledBitmap(b, width, height, true);
    	
    	 
    	 spriteWidth=bitmap.getWidth()/frameCount1;
    	 spriteHeight=bitmap.getHeight();
    	 
    	
    	
    	
    	 sourceRect=new Rect(0,0,spriteWidth,spriteHeight);
    	
    	 
    	 
    	 frameNr1=frameCount1;
    	 
    	 
    	 
    	 
    	 
    	 currentFrame=0;
    	 frameTicker=0l;
    	 
    	
    	 timePeriod=1000/fps;
    	 
    	 speed=5;
    	 
     }
     public void update1(long gameTime){
    	 if(gameTime>frameTicker+timePeriod){
    		 frameTicker=gameTime;
    		 currentFrame++;
    		
    		 if(currentFrame>=frameNr1){
    			 currentFrame=0;
    		 }
    	 }
    	 this.sourceRect.left=currentFrame*spriteWidth;
    	 this.sourceRect.right= this.sourceRect.left+spriteWidth;
     }
     
   
     
     
     
     public void update2(){
    	 y+=speed;
    	 if(y>Constants.SCREEN_HEIGHT){
    		 y=-bitmap.getHeight();
    	 }
     }
     
     public void update3(){
    	 y-=speed;
    	 if(y<-bitmap.getHeight()){
    		 y=Constants.SCREEN_HEIGHT;
    	 }
     }
     
     public void draw(Canvas canvas){
    	 Rect lastRect=new Rect(x,y,x+spriteWidth,y+spriteHeight);
    	 canvas.drawBitmap(bitmap,sourceRect,lastRect,null);
     }
     public int getX(){
    	 return x;
     }
     public int getY(){
    	 return y;
     }
    
     
}
