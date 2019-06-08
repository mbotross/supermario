package com.example.supermario2;


import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

   Game supermario;
    MediaPlayer song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        song = MediaPlayer.create(MainActivity.this, R.raw.supermusic);
        song.start();

        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

       //setContentView(R.layout.activity_main);
        setContentView(new Game(this));
       // supermario= findViewById(R.id.supermario2);


        //supermario= (com.example.supermario2.Game) findViewById(R.id.supermario2);

    /*    findViewById(R.id.right_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                supermario.shiftRight();
            }
        });
        /*

        findViewById(R.id.left_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                supermario.shiftLeft();
            }
        });
        /*
        findViewById(R.id.rotate_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                supermario.jump();

            }
        });

    */

       /* if(tetris.endgame()){
            System.out.println("END GAME");
            finish();

        }*/

    }
}
