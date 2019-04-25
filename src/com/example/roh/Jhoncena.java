package com.example.roh;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Jhoncena {
     private Bitmap jhon;
     private Rect sourceRect;
     private Bitmap back;
     
     private int x;
     private int y;
     
     private int currentFrame;
     private int frameNr;
     private int timePeriod;
     private long frameTicker;
     
     private int spriteWidth;
     private int spriteHeight;
     
     public Jhoncena(Bitmap a,Bitmap b,int fps, int frameCount){
    	 int width=Constants.SCREEN_WIDTH;
    	 int height=Constants.SCREEN_HEIGHT;
    	 
    	 back=Bitmap.createScaledBitmap(b, width, height, true);
    	 
    	width/=7;
    	height/=10;
    	
    	this.x=Constants.SCREEN_WIDTH/2;
    	this.y=Constants.SCREEN_HEIGHT/2;
    	
    	jhon=Bitmap.createScaledBitmap(a, width, height, true);
    	spriteWidth=jhon.getWidth()/frameCount;
    	spriteHeight=jhon.getHeight();
    	sourceRect =new Rect(0,0,spriteWidth,spriteHeight);
    	
    	frameNr=frameCount;
    	currentFrame=0;
    	frameTicker=0l;
    	timePeriod=1000/fps;
    	
    	
    	 
    	 
     }
     public void update(long gameTime){
    	 if(gameTime>frameTicker+timePeriod){
    		 frameTicker=gameTime;
    		 currentFrame++;
    		
    		 if(currentFrame>=frameNr){
    			 currentFrame=0;
    		 }
    	 }
    	 this.sourceRect.left=currentFrame*spriteWidth;
    	 this.sourceRect.right= this.sourceRect.left+spriteWidth;
     }
     public void draw(Canvas canvas){
    	 
    	 canvas.drawBitmap(back, 0, 0,null);
    	 
    	 Rect lastRect=new Rect(x,y,x+jhon.getWidth(),y+jhon.getHeight());
    	 canvas.drawBitmap(jhon, sourceRect, lastRect,null);
     }
     
}
