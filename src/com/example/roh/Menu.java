package com.example.roh;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Menu {
     private Bitmap bitmap;
     private Bitmap play;
     private Bitmap exit;
     
     private int  play_x;
     private int play_y;
     
     
     
     private int exit_x;
     private int exit_y;
     
     
     public Menu(Bitmap a,Bitmap b,Bitmap c){
    	 int width=Constants.SCREEN_WIDTH;
    	 int height=Constants.SCREEN_HEIGHT;
    	 
    	 bitmap=Bitmap.createScaledBitmap(a, width, height, true);
    	 
    	  int playWidth=Constants.SCREEN_WIDTH;
         int playHeight=Constants.SCREEN_HEIGHT;
         
         playWidth/=15;
         playHeight/=3;
         
         play=Bitmap.createScaledBitmap(b, playWidth, playHeight, true);
         
         int exitWidth=Constants.SCREEN_WIDTH;
         int exitHeight=Constants.SCREEN_HEIGHT;
         
         exitWidth/=15;
         exitHeight/=3;
         
         exit=Bitmap.createScaledBitmap(c, exitWidth, exitHeight, true);
         
         play_x=Constants.SCREEN_WIDTH-(Constants.SCREEN_WIDTH/5);
         play_y=Constants.SCREEN_HEIGHT/2-play.getHeight();
         
         exit_x=Constants.SCREEN_WIDTH/2;
         exit_y=Constants.SCREEN_HEIGHT/2-exit.getHeight();
    	 
     }
     public void draw(Canvas canvas){
    	 
    	 canvas.drawBitmap(bitmap, 0, 0,null);
    	 
    	 canvas.drawBitmap(play, play_x,play_y,null);
    	 canvas.drawBitmap(exit, exit_x,exit_y,null);
    	 
    	 
     }
     public int getplayX(){
    	 return play_x;
     }
     public int getplayY(){
    	 return play_y;
     }
   public int getexitX(){
    	 return exit_x;
     }
   public int getexitY(){
  	 return exit_y;
   }
   
   public int getplayWidth(){
	   return play.getWidth();
   }
   public int getplayHeight(){
	   return play.getHeight();
   }
   public int getexitWidth(){
	   return exit.getWidth();
   }
   public int getexitHeight(){
	   return exit.getHeight();
   }
   
     
}
