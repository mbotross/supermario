package com.example.supermario2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Coins extends Obstacles{
    Boolean drawit=true;
    Bitmap coin;
    public Coins(Context context,Game game, Mario mario, int left,int top){
        super(context,game,mario);
        this.game=game;
        this.context=context;
        this.mario=mario;
        coin= BitmapFactory.decodeResource(context.getResources(),R.drawable.coin);
        this.left=left;
        this.top=top;
    }

    public void collide(){

        game.Points=game.Points+200;

        drawit=false;
        //maybe make sound when mario hits it


    }
    public void draw(Canvas canvas){
        if(drawit==true) {
            rectangle = new Rect(left, top, left + coin.getWidth(), top + coin.getHeight());
            if (left > 0) {
                canvas.drawBitmap(coin, left, top, null);
            }
            if (mario.MOVE >= canvas.getWidth() / 2) {
                if (left > 0) {
                    left = left - 20;
                }
            }
        }

    }




    }
