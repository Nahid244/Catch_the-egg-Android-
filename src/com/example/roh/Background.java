package com.example.roh;

import android.graphics.Bitmap;
import android.graphics.Canvas;


public class Background {
     private Bitmap bitmap;
     private int x,y;
     private double speed;
     
     public Background(Bitmap b){
    	 bitmap=b;
    	 x=0;
    	 y=0;
    	 speed=0.01;
    	
    	 
     }
     public void update(){
    	 
     }
     public void draw(Canvas canvas){
    	 ///resizing bit map;

    	 
    	 int width=Constants.SCREEN_WIDTH;
    	 int height=Constants.SCREEN_HEIGHT;
    	Bitmap b=Bitmap.createScaledBitmap(bitmap,width,height,true);
    	 canvas.drawBitmap(b,x,y,null);
    
    	
     }
}

