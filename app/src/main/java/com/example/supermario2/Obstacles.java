package com.example.supermario2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Obstacles {

    Context context;
    Game game;
    Mario mario;
    Rect rectangle;
    int left;
    int top;
    int collide;
    int numbercollide=0;

    public Obstacles(Context context,Game game,Mario mario){
        this.context=context;
        this.game=game;
        this.mario=mario;



    }


    public void draw(Canvas canvas){


    }
    public Boolean collide(){

    return true;
    }




}
