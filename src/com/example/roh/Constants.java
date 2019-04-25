package com.example.roh;

import android.content.Context;

public class Constants {
    public static int SCREEN_WIDTH;
    public static int SCREEN_HEIGHT;
    public static int EGG_CATCH=0;
    public static int Life=5;
    public static int witchCount;
    public static int witchCount1;
    
    public static boolean menu_Running=false;
    public static boolean game_Running=false;
    public static boolean exit_Running=false;
    
    
    
    public static Context CURRENT_CONTEXT;
    public static float scale;
   
    public static String geteggCatch(){
    	return String.format("SCORE::: %d",EGG_CATCH);
    }
    public static String getLives(){
    	return String.format("Lives:::%d", Life);
    }
}
