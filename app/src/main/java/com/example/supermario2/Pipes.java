package com.example.supermario2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import java.util.Timer;

public class Pipes extends Obstacles {

    Bitmap pipes;
    Bitmap pipes2;
    int type;
    Timer timer=new Timer();

    public Pipes(Context context, Game game, Mario mario,int left,int top,int type) {
        super(context, game, mario);
        this.context=context;
        this.game=game;
        this.mario=mario;
        this.left=left;
        this.top=top;
        this.type=type;
        pipes= BitmapFactory.decodeResource(context.getResources(),R.drawable.pipe);
        pipes2=BitmapFactory.decodeResource(context.getResources(),R.drawable.secondpipe);



    }

    public Boolean collide(){

        return true;
    }

    public void draw(Canvas canvas){

        if(type==1) {
            rectangle = new Rect(left, top, left + pipes.getWidth(), top + pipes.getHeight());
            //if (left > 0) {
                canvas.drawBitmap(pipes, left, top, null);
            //}
            if (mario.MOVE >= canvas.getWidth() / 2 && game.pressed) {
               // if (left > 0) {
                    left = left - 20;
               // }
            }
        }
        else if(type==2){
            System.out.println("HELLOOOOOOOO");
            rectangle = new Rect(left, top, left + pipes2.getWidth(), top + pipes2.getHeight());
            //if (left > 0) {
                canvas.drawBitmap(pipes2, left, top, null);
           // }
            if (mario.MOVE >= canvas.getWidth() / 2 && game.pressed) {
                //if (left > 0) {
                    left = left - 20;
                //}
            }


        }

    }



}
