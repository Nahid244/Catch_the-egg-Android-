package com.example.roh;

import java.util.ArrayList;
import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback{
    private MainThread thread;
  
  
  
    private Bitmap bitmap;
    private Background back;
    
  
    
    private Bhoot bhoot;
   private Bhoot bhoot2;
    private Bucket bucket;
    
    private Chicken[] chicken=new Chicken[4];
    private Point point;
    private ArrayList<Egg> egg0=new ArrayList<Egg>();
    private ArrayList<Egg> egg1=new ArrayList<Egg>();
    private ArrayList<Egg> egg2=new ArrayList<Egg>();
    private ArrayList<Egg> egg3=new ArrayList<Egg>();
    private ArrayList<Baby> baby=new ArrayList<Baby>();
    
     private Random r=new Random();
    private Score score;
     private int ran;
     
     private Witch witch;
     private Witch witch2;
     
     private Menu menu;
     private Jhoncena jhon;
     
     private ArrayList<Pumkin> pumkin=new ArrayList<Pumkin>();
     
	public GamePanel(Context context) {
		super(context);
		
		
		
		getHolder().addCallback(this);
		Constants.CURRENT_CONTEXT=context;
		 ///for resizing bitmap;
		 Constants.scale=getContext().getResources().getDisplayMetrics().density;
		
		thread=new MainThread(getHolder(),this);
		
		
		//bitmap=BitmapFactory.decodeResource(getResources(),R.drawable.my);
		menu=new Menu(BitmapFactory.decodeResource(getResources(), R.drawable.menu),BitmapFactory.decodeResource(getResources(), R.drawable.play),BitmapFactory.decodeResource(getResources(), R.drawable.exit));
		
		back=new Background(BitmapFactory.decodeResource(getResources(),R.drawable.back));
		
		
		
		bhoot=new Bhoot(BitmapFactory.decodeResource(getResources(),R.drawable.bhoot),Constants.SCREEN_WIDTH-(Constants.SCREEN_WIDTH/3),0,17,2);
		witch=new Witch(BitmapFactory.decodeResource(getResources(), R.drawable.witch),bhoot,17,3);
		
		point=new Point(Constants.SCREEN_WIDTH/9,0);
		bhoot2=new Bhoot(BitmapFactory.decodeResource(getResources(),R.drawable.bhoot2),Constants.SCREEN_WIDTH-(Constants.SCREEN_WIDTH/3),0,17,2);
		witch2=new Witch(BitmapFactory.decodeResource(getResources(), R.drawable.witch2),bhoot2,17,3);
		bucket=new Bucket(BitmapFactory.decodeResource(getResources(),R.drawable.bucket),Constants.SCREEN_WIDTH/9,0);
		
		chicken[0]=new Chicken(BitmapFactory.decodeResource(getResources(),R.drawable.chicken),Constants.SCREEN_WIDTH-(Constants.SCREEN_WIDTH/4),Constants.SCREEN_HEIGHT-(Constants.SCREEN_HEIGHT/4),10,2);
		
		
		
		chicken[1]=new Chicken(BitmapFactory.decodeResource(getResources(),R.drawable.chicken),Constants.SCREEN_WIDTH-(Constants.SCREEN_WIDTH/4),Constants.SCREEN_HEIGHT-(Constants.SCREEN_HEIGHT/2),10,2);
		chicken[2]=new Chicken(BitmapFactory.decodeResource(getResources(),R.drawable.chicken),Constants.SCREEN_WIDTH-(Constants.SCREEN_WIDTH/4),(Constants.SCREEN_HEIGHT/2)-(Constants.SCREEN_HEIGHT/4),10,2);
		chicken[3]=new Chicken(BitmapFactory.decodeResource(getResources(),R.drawable.chicken),Constants.SCREEN_WIDTH-(Constants.SCREEN_WIDTH/4),(Constants.SCREEN_HEIGHT/2)-(Constants.SCREEN_HEIGHT/2),10,2);
		
		jhon=new Jhoncena(BitmapFactory.decodeResource(getResources(), R.drawable.jhoncena),BitmapFactory.decodeResource(getResources(), R.drawable.back),17,3);
		
		score=new Score();
		Constants.witchCount=0;
		Constants.witchCount1=0;
		Constants.menu_Running=true;
		
		setFocusable(true);
	}
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		
		thread=new MainThread(getHolder(),this);
		thread.setRunning(true);
		thread.start();
	}
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		
		
	}
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry=true;
		while(retry){
			try{
				thread.setRunning(false);
				thread.join();
			}catch(Exception e){
				
			}
			retry=false;
		}
		
	}
	public boolean onTouchEvent(MotionEvent event){
	
		switch(event.getAction()){
		case MotionEvent.ACTION_DOWN:
			
			 if(Constants.game_Running==false && Constants.menu_Running==false &&  Constants.exit_Running){
            	 Constants.game_Running=false;
					Constants.menu_Running=true;
					Constants.exit_Running=false;
             }
			
			
			if(Constants.menu_Running && Constants.game_Running==false && Constants.exit_Running==false){
				if((int)event.getX()>=menu.getplayX() && (int)event.getX()<=(menu.getplayX()+menu.getplayWidth())&& (int)event.getY()>=menu.getplayY() && (int)event.getY()<=(menu.getplayY()+menu.getplayHeight())){
					
					Constants.EGG_CATCH=0;
					Constants.Life=5;
					
					
					Constants.game_Running=true;
					Constants.menu_Running=false;
					Constants.exit_Running=false;
				}
             if((int)event.getX()>=menu.getexitX() && (int)event.getX()<=(menu.getexitX()+menu.getexitWidth())&& (int)event.getY()>=menu.getexitY() && (int)event.getY()<=(menu.getexitY()+menu.getexitHeight())){
					
					Constants.game_Running=false;
					Constants.menu_Running=false;
					Constants.exit_Running=false;
					
					System.exit(0);
				}
            
				
			}
			
		case MotionEvent.ACTION_MOVE:
			point.set((int)event.getX(),(int)event.getY() );
		
			
		
		
		}
		return true;
		//return super.onTouchEvent(event);
		
	}
	public void update(){
		
		if(Constants.exit_Running){
			jhon.update(System.currentTimeMillis());
		}
		
		if(Constants.Life==0){
			Constants.game_Running=false;
			Constants.exit_Running=true;
		}
		
	
		if(Constants.game_Running){
		
		if(Constants.Life>0){
		
		ran=r.nextInt(120);
		
		if(ran==4){
			Constants.witchCount++;
			
		}
		if(Constants.witchCount>0){
			Constants.witchCount++;
			
		}
		if(Constants.witchCount>=6){
			Constants.witchCount=0;
		}
		
		
		if(ran==80){
			Constants.witchCount1++;
			pumkin.add(new Pumkin(BitmapFactory.decodeResource(getResources(), R.drawable.pumkin),witch2));
		}
		if(Constants.witchCount1>0){
			Constants.witchCount1++;
		}
		if(Constants.witchCount1>=6){
			
			Constants.witchCount1=0;
		}
	   
		if(Constants.witchCount>=3 && Constants.witchCount<=5){
			if(Constants.witchCount==5){
				pumkin.add(new Pumkin(BitmapFactory.decodeResource(getResources(), R.drawable.pumkin),witch));
			}
		witch.updateSprite(System.currentTimeMillis());
		witch.updateSpeed();
		}
		if(Constants.witchCount1>=3 && Constants.witchCount1<=5){
			
			if(Constants.witchCount1==5){
				pumkin.add(new Pumkin(BitmapFactory.decodeResource(getResources(), R.drawable.pumkin),witch2));
			}
			
			witch2.updateSprite(System.currentTimeMillis());
			witch2.updateSpeed();
			}
		
			 bhoot.update1(System.currentTimeMillis());
				bhoot.update2();
		
		for(int i=0;i<pumkin.size();i++){
			pumkin.get(i).update();
			
			
			if(pumkin.get(i).getBounds().intersect(bucket.getBounds())){
				Constants.Life--;
				pumkin.remove(i);
				i--;
			}
			
			if(pumkin.get(i).getX()<0){
				pumkin.remove(i);
				i--;
			}
		}
				
		
		bhoot2.update1(System.currentTimeMillis());
		bhoot2.update3();
		int n=r.nextInt(61);
		
		if(n==15){
			egg0.add(new Egg(BitmapFactory.decodeResource(getResources(), R.drawable.egg),BitmapFactory.decodeResource(getResources(), R.drawable.egg_break),chicken[0]));
		}
		if(n==30){
			egg1.add(new Egg(BitmapFactory.decodeResource(getResources(), R.drawable.egg),BitmapFactory.decodeResource(getResources(), R.drawable.egg_break),chicken[1]));
		}
		if(n==45){
			egg2.add(new Egg(BitmapFactory.decodeResource(getResources(), R.drawable.egg),BitmapFactory.decodeResource(getResources(), R.drawable.egg_break),chicken[2]));
		}
		if(n==60){
			egg3.add(new Egg(BitmapFactory.decodeResource(getResources(), R.drawable.egg),BitmapFactory.decodeResource(getResources(), R.drawable.egg_break),chicken[3]));
		}
		for(int i=0;i<egg0.size();i++){
			egg0.get(i).update();
			if(egg0.get(i).geteggX()<-egg0.get(i).geteggWidth() ||((egg0.get(i).geteggX()<(bucket.getX()+bucket.getbucketWidth()/2))  && (egg0.get(i).geteggY()>(bucket.getY())) && (egg0.get(i).geteggY()<(bucket.getY()+bucket.getbucketHeight())))){
				
				if(((egg0.get(i).geteggX()<(bucket.getX()+bucket.getbucketWidth()/2))  && (egg0.get(i).geteggY()>(bucket.getY())) && (egg0.get(i).geteggY()<(bucket.getY()+bucket.getbucketHeight())))){
					Constants.EGG_CATCH++;
					baby.add(new Baby(BitmapFactory.decodeResource(getResources(), R.drawable.baby),bucket));
				}
				
				egg0.remove(i);
				i--;
			}
		}
		for(int i=0;i<egg1.size();i++){
			egg1.get(i).update();
			if(egg1.get(i).geteggX()<-egg1.get(i).geteggWidth() || ((egg1.get(i).geteggX()<(bucket.getX()+bucket.getbucketWidth()/2))  && (egg1.get(i).geteggY()>(bucket.getY())) && (egg1.get(i).geteggY()<(bucket.getY()+bucket.getbucketHeight())))){
				if(((egg1.get(i).geteggX()<(bucket.getX()+bucket.getbucketWidth()/2))  && (egg1.get(i).geteggY()>(bucket.getY())) && (egg1.get(i).geteggY()<(bucket.getY()+bucket.getbucketHeight())))){
					Constants.EGG_CATCH++;
					baby.add(new Baby(BitmapFactory.decodeResource(getResources(), R.drawable.baby),bucket));
				}
				
				egg1.remove(i);
				i--;
			}
		}
		for(int i=0;i<egg2.size();i++){
			egg2.get(i).update();
			if(egg2.get(i).geteggX()<-egg2.get(i).geteggWidth() || ((egg2.get(i).geteggX()<(bucket.getX()+bucket.getbucketWidth()/2))  && (egg2.get(i).geteggY()>(bucket.getY())) && (egg2.get(i).geteggY()<(bucket.getY()+bucket.getbucketHeight())))){
				
				if(((egg2.get(i).geteggX()<(bucket.getX()+bucket.getbucketWidth()/2))  && (egg2.get(i).geteggY()>(bucket.getY())) && (egg2.get(i).geteggY()<(bucket.getY()+bucket.getbucketHeight())))){
					Constants.EGG_CATCH++;
					baby.add(new Baby(BitmapFactory.decodeResource(getResources(), R.drawable.baby),bucket));
				}
				
				egg2.remove(i);
				i--;
			}
		}
		for(int i=0;i<egg3.size();i++){
			egg3.get(i).update();
			if(egg3.get(i).geteggX()<-egg3.get(i).geteggWidth() || ((egg3.get(i).geteggX()<(bucket.getX()+bucket.getbucketWidth()/2))  && (egg3.get(i).geteggY()>(bucket.getY())) && (egg3.get(i).geteggY()<(bucket.getY()+bucket.getbucketHeight())))){
				
				if(((egg3.get(i).geteggX()<(bucket.getX()+bucket.getbucketWidth()/2))  && (egg3.get(i).geteggY()>(bucket.getY())) && (egg3.get(i).geteggY()<(bucket.getY()+bucket.getbucketHeight())))){
					Constants.EGG_CATCH++;
					baby.add(new Baby(BitmapFactory.decodeResource(getResources(), R.drawable.baby),bucket));
				}
				
				egg3.remove(i);
				i--;
			}
		}
		for(int i=0;i<baby.size();i++){
			baby.get(i).update();
			
			if(baby.get(i).getX()>Constants.SCREEN_WIDTH){
				baby.remove(i);
				i--;
			}
			
			
		}
		for(int i=0;i<4;i++){
		chicken[i].update(System.currentTimeMillis());}
		bucket.update(point);
		
		}
		}
		
	}
	public void draw(Canvas canvas){
		super.draw(canvas);
		//canvas.drawColor(Color.BLUE);
		if(Constants.menu_Running){
			Constants.game_Running=false;
			Constants.exit_Running=false;
			menu.draw(canvas);
		}
		if(Constants.exit_Running){
			jhon.draw(canvas);
		}
		
		
		
		if(Constants.game_Running){
	back.draw(canvas);
	
	score.draw(canvas);
	
	if(Constants.Life>0){
	
	for(int i=0;i<baby.size();i++){
		baby.get(i).draw(canvas);
	}
	
		for(int i=0;i<egg0.size();i++){
		   
			egg0.get(i).draw(canvas);
		}
		for(int i=0;i<egg1.size();i++){
			egg1.get(i).draw(canvas);
		}
		for(int i=0;i<egg2.size();i++){
			egg2.get(i).draw(canvas);
		}
		for(int i=0;i<egg3.size();i++){
			egg3.get(i).draw(canvas);
		}
		
	for(int i=0;i<4;i++){
		chicken[i].draw(canvas);}
	
	
	
	if(Constants.witchCount>=3 && Constants.witchCount<=5){
		witch.draw(canvas);
		}
	else{
		bhoot.draw(canvas);
	}
	
	if(Constants.witchCount1>=3 && Constants.witchCount1<=5){
		witch2.draw(canvas);
		}
	else{
	bhoot2.draw(canvas);
	}
	
	for(int i=0;i<pumkin.size();i++){
		pumkin.get(i).draw(canvas);
	}
	
	bucket.draw(canvas);
		
	}
	}
	}
}
