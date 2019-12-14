package com.example.supermario2;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        Button buttons =(Button) findViewById(R.id.start);

        buttons.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

               Intent intent=new Intent(getApplicationContext(),GameActivity.class);
               startActivity(intent);
            }
        });




    }


}
