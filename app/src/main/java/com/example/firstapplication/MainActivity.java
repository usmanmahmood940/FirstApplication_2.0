package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(
                MainActivity.this,"Activity Created",Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this,"Activity Created2.0",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(MainActivity.this,"Activity Started",Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(MainActivity.this,"Activity Resumed",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(MainActivity.this,"Activity Paused",Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(MainActivity.this,"Activity Stopped",Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();

        Toast.makeText(MainActivity.this,"Activity Destroyed",Toast.LENGTH_SHORT).show();

    }
    /* Exit app on double back pressed*/


  // Method 1 :
    boolean backPressed = false;
    @Override
    public void onBackPressed(){
        if(backPressed){
            super.onBackPressed();
            return;
        }
        this.backPressed = true;
        Toast.makeText(MainActivity.this,"Press Back again to exit",Toast.LENGTH_LONG).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                backPressed = false;
            }
        },3000);
    }

    // Method 2 :
    /*
    boolean backPressed = false;
    private final long timePeriod = 3000;
    CountDownTimer countDownTimer;
    public void onBackPressed() {
        if(backPressed){
            super.onBackPressed();
            countDownTimer.cancel();
            return;
        }
        Toast.makeText(MainActivity.this,"Press Back again to exit",Toast.LENGTH_SHORT).show();
        countDownTimer = new CountDownTimer(timePeriod,2900) {

            @Override
            public void onTick(long millisUntilFinished) {
                backPressed = true;


            }

            @Override
            public void onFinish() {
                backPressed = false;
            }
        }.start();
    }*/

    // Method 3 :
   /* Timer objTimer;
    boolean backPressed = false;
    public void onBackPressed() {
        if(backPressed){
            super.onBackPressed();
            objTimer.cancel();
            return;
        }
        Toast.makeText(MainActivity.this,"Press Back again to exit",Toast.LENGTH_SHORT).show();
        objTimer = new Timer();
        objTimer.schedule(new TimerTask(){
            @Override
            public void run() {
                if(!backPressed){
                    backPressed = true;
                }
                else {
                    backPressed = false;
                    objTimer.cancel();
                }

            }
        },0,3000);

    }
    */

    // Method 4
  /* private long pressedTime;

    @Override
    public void onBackPressed(){

        if(pressedTime + 3000 > System.currentTimeMillis() ) {
            super.onBackPressed();
            return;
        }
        else
            Toast.makeText(MainActivity.this,"Press Back again to exit",Toast.LENGTH_LONG).show();

        pressedTime = System.currentTimeMillis();
    }*/


}