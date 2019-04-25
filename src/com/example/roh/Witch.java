package com.example.roh;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Witch {
      private Bitmap bitmap;
      private Rect sourceRect;
      
      private long frameTicker;
      private int currentFrame;
      private int frameNr;
      private int timePeriod;
      
      private int spriteWidth;
      private int spriteHeight;
      
      private int x;
      private int y;
      private int speed;
      
      private Bhoot bhoot;
      public Witch(Bitmap b,Bhoot bh,int fps,int framecount){
    	  int width=Constants.SCREEN_WIDTH;
    	  int height=Constants.SCREEN_HEIGHT;
     	width-=width/4;
     	 height/=4;
     	 this.bhoot=bh;
     	 
     	 this.x=bhoot.getX();
     	 this.y=bhoot.getY();
     	 this.speed=5;
     	 
     	 bitmap=Bitmap.createScaledBitmap(b, width, height, true);
     	 spriteWidth=bitmap.getWidth()/framecount;
     	 spriteHeight=bitmap.getHeight();
     	 
     	 sourceRect=new Rect(0,0,spriteWidth,spriteHeight);
     	 
     	 currentFrame=0;
     	 frameTicker=0l;
     	 frameNr=framecount;
     	 timePeriod=1000/fps;
    	  
      }
      public void updateSprite(long gameTime){
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
      public void updateSpeed(){
    	 this.y=bhoot.getY();
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
      public int getWidth(){
    	  return spriteWidth;
    	  
      }
      public int getHeight(){
    	  return spriteHeight;
      }
      
}
