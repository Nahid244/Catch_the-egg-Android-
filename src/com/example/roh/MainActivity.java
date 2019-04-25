package com.example.roh;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
////ALL RIGHTS ARE RESERVED BY MACH_NAHID
//for any complain contact me at maknahid24@gmail.com;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        Constants.SCREEN_WIDTH=dm.widthPixels;
        Constants.SCREEN_HEIGHT=dm.heightPixels;
       
       
        
        setContentView(new GamePanel(this));
    }

   
}
/// android:theme="@android:style/Theme.NoTitleBar.Fullscreen"