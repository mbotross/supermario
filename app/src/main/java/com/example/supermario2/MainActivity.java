package com.example.supermario2;


import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends Activity {

   Game supermario;
   int gameflag=0;
    MediaPlayer song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        song = MediaPlayer.create(MainActivity.this, R.raw.supermusic);
        song.start();

        super.onCreate(savedInstanceState);
        //this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        Button buttons =(Button) findViewById(R.id.start);

        buttons.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){



               Intent intent=new Intent(getApplicationContext(),GameActivity.class);
               startActivity(intent);
            }
        });




       // setContentView(new Game(this));

    }

   /* public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.start:
                startActivity(new Intent(this, Game.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/
}
