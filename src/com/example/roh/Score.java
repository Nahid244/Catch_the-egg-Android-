package com.example.roh;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Score {
     
      private int x;
      private int y;
      
      private int x2;
      private int y2;
      
      public Score(){
    	 
    	  
    	  x=Constants.SCREEN_WIDTH/2-(Constants.SCREEN_WIDTH/8);
    	  y=Constants.SCREEN_WIDTH/20;
    	  
    	  
    	  y2=Constants.SCREEN_HEIGHT-(Constants.SCREEN_WIDTH/20);
    	  
      }
      public void draw(Canvas canvas){
    	
    	  Paint paint=new Paint();
    	paint.setTextSize(Constants.SCREEN_WIDTH/15);
    	 paint.setColor(Color.GREEN);
    	  
    	  canvas.drawText(Constants.geteggCatch(), x, y, paint);
    	  canvas.drawText(Constants.getLives(), x, y2, paint);
      }
      
}
