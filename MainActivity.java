package com.uok.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    /**
     *This is the main activity class of the application stop watch class in here stop functionality has implemented
     * @auther Nadun Dilhara
     * @version 1.0
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**
         * savedInstanceState state is reference to a bundle object that is passed into the oncreate methothd
         */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /**
                 * This method functions loading screen
                 */
                Intent loadingScreen = new Intent(MainActivity.this, About.class);
                startActivity(loadingScreen);
                finish();
            }
        }, 3000);
    }
}