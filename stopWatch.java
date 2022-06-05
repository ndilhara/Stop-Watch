package com.uok.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class stopWatch extends AppCompatActivity {

    /**
     *
     * This is the stop watch class in here stop functionality has implemented
     * @auther Nadun Dilhara
     * @version 1.0
     */
    Button About;
    Button clockBTN;

    boolean clock;
    int Seconds =0;
    String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**
         * This method perform switching pages between stopwatch and About
         */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Timer();

        About = (Button) findViewById(R.id.button4);
        clockBTN = findViewById(R.id.clock);

        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(stopWatch.this,MainActivity3.class);
                startActivity(intent);
            }
        });


        clockBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(stopWatch.this, com.uok.stopwatch.About.class);
                startActivity(intent);
            }
        });
    }
    public void onStart(View view){
        /***
         * This method start stop watch
         */
        clock=true;
    }
    public void onStop(View view){
        /***
         * This method stop stop watch
         */
        clock=false;
    }
    public void onReset(View view){
        /***
         * This method reset the count of  stop watch
         */
        clock=false;
        Seconds =0;
    }
    private void Timer(){

        /***
         * This method function the main part of stopwatch
         * In here count the stop watch time
         */
        TextView timer=findViewById(R.id.timer);
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                //This method do the calculation part of the time
                int minutes= Seconds /3600;
                int Seconds=(stopWatch.this.Seconds %3600)/60;
                int miliSeconds = stopWatch.this.Seconds %60;
                time=String.format("%02d:%02d:%02d",minutes,Seconds,miliSeconds);
                timer.setText(time);
                if (clock){
                    stopWatch.this.Seconds++;
                }
                handler.postDelayed(this,1);
            }
        });
    }




}