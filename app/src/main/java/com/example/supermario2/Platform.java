package com.example.supermario2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;


public class Platform extends Obstacles {


    Bitmap platform;
    Mushroom mushroom;

    public Platform(Context context, Game game, Mario mario, int left, int top) {
        super(context,game,mario);
        // super(context, game);
        this.platform= BitmapFactory.decodeResource(context.getResources(),R.drawable.platform);
        //top=300;
        //left=500;
        this.left=left;
        this.top=top;

    }


    public void draw(Canvas canvas) {


        rectangle = new Rect(left, top, left + platform.getWidth(), top + platform.getHeight());
        //if(left>0){
        canvas.drawBitmap(platform, left, top, null);//}
        //canvas.drawRect(rectangle,paint);
        if (mario.MOVE >= canvas.getWidth() / 2 && game.pressed && game.collideright()) {
            // if (left > 0) {
            left = left - 20;
            //  }
        }

    }


    }