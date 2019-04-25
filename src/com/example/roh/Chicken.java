package com.example.roh;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Chicken {
      private Bitmap bitmap;
      private Rect sourceRect;
      
      private int frameNr;
      private long frameTicker;
      private int currentFrame;
      private int timePeriod;
      
      private int spriteWidth;
      private int spriteHeight;
      
      private int x;
      private int y;
      
      public Chicken(Bitmap b,int x,int y,int fps,int frameCount){
    	  int width=Constants.SCREEN_WIDTH;
    	  int height=Constants.SCREEN_HEIGHT;
    	  
    	  width/=3;
    	  height/=6;
    	  
    	  this.x=x;
    	  this.y=y;
    	  
    	  bitmap=Bitmap.createScaledBitmap(b, width, height, true);
    	  spriteWidth=bitmap.getWidth()/frameCount;
    	  spriteHeight=bitmap.getHeight();
    	  
    	  sourceRect=new Rect(0,0,spriteWidth,spriteHeight);
    	  
    	  
    	  currentFrame=0;
    	  frameNr=frameCount;
    	  timePeriod=1000/fps;
    	  
    	  frameTicker=0l;
    	  
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
    	  Rect lastRect=new Rect(x,y,x+spriteWidth,y+spriteHeight);
    	  canvas.drawBitmap(bitmap,sourceRect,lastRect,null);
    	  
      }
     public int getchickenX(){
    	 return x;
     }
     public int getchickenY(){
    	 return y;
     }
     public int getspriteWidth(){
    	 return spriteWidth;
     }
     public int getspriteHeight(){
    	 return spriteHeight;
     }
      
}
