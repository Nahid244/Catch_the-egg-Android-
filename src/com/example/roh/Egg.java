package com.example.roh;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Egg {
     private Bitmap bitmap;
     private int x;
     private int dx;
     
     private int y;
     private int speed;
     private Chicken c;
     private Bitmap bitmap2;
   
   
     
     public Egg(Bitmap b,Bitmap b2,Chicken c){
    	 this.c=c;
    	 int width=Constants.SCREEN_WIDTH;
    	 int height=Constants.SCREEN_HEIGHT;
    	 
    	 width/=14;
    	 height/=17;
    	 this.x=c.getchickenX();
    	 this.y=c.getchickenY()+(c.getspriteHeight()/3);
    	 
    	 speed=8;
    	 bitmap=Bitmap.createScaledBitmap(b, width, height, true);
    	 bitmap2=Bitmap.createScaledBitmap(b2, width, height, true);
    	 
    	dx=0;
    	
    	
     }
     public void update(){
    	 dx=-speed;
    	
    		 x+=dx; 
    	  dx=0;
    	
     }
     public void draw(Canvas canvas){
    	 if(x<bitmap2.getWidth()){
    		 canvas.drawBitmap(bitmap2,x,y,null);
    	 }
    	
    	 else{
    	 canvas.drawBitmap(bitmap,x,y,null);
    	
    	 }
    	 
    	 
     }
     public int geteggX(){
    	 return x;
     }
     public int geteggY(){
    	 return y;
     }
     public int geteggWidth(){
    	 return bitmap.getWidth();
     }
     public int geteggHeight(){
    	 return bitmap.getHeight();
     }
     
     
}