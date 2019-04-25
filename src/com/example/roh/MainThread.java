package com.example.roh;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread{
     public static final int MAX_FPS=360;
     private double averageFPS;
     private SurfaceHolder surfaceholder;
     private GamePanel gamepanel;
     private boolean running;
     public static Canvas canvas;
     
     public void setRunning(boolean b){
    	 running=b;
     }
     
     public MainThread(SurfaceHolder s,GamePanel g){
    	 super();
    	 surfaceholder=s;
    	 gamepanel=g;
     }
     public void run(){
    	 long startTime;
    	 long timeMillis=1000/MAX_FPS;
    	 long waitTime;
    	 int frameCount=0;
    	 long totalTime=0;
    	 long targetTime=1000/MAX_FPS;
    	 
    	 while(running){
    		 startTime=System.nanoTime();
    		 canvas=null;
    		 try{
    			 canvas=this.surfaceholder.lockCanvas();
    			 synchronized(surfaceholder){
    				this.gamepanel.update();
    				this.gamepanel.draw(canvas);
    				
    			 } 
    			 
    		 }catch(Exception e){
    			 
    		 }finally{
    			 if(canvas!=null){
    				 try{
    					 surfaceholder.unlockCanvasAndPost(canvas);
    				 }catch(Exception e){
    					 
    				 }
    			 }
    		 }
    		 timeMillis=System.nanoTime()-(startTime/1000000);
    		 
    		 
    		 waitTime=targetTime- timeMillis;
    		 try{
    			 if(waitTime>0){
    				 this.sleep(waitTime);
    			 }
    			 
    			 
    		 }catch(Exception e){
    			 
    		 }
    		 totalTime+=System.nanoTime()-startTime;
    		 frameCount++;
    		 if(frameCount==MAX_FPS){
    			 averageFPS=((totalTime/frameCount)/1000000);
    			 frameCount=0;
    			 totalTime=0;
    			 System.out.println(averageFPS);
    		 }
    	 }
     }
}
