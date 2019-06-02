package com.example.supermario2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Pipes extends Obstacles {

    Bitmap pipes;
    public Pipes(Context context, Game game, Mario mario,int left,int top) {
        super(context, game, mario);
        this.context=context;
        this.game=game;
        this.mario=mario;
        this.left=left;
        this.top=top;
        pipes= BitmapFactory.decodeResource(context.getResources(),R.drawable.pipe);

    }

    public void draw(Canvas canvas){



        rectangle=new Rect(left,top,left+pipes.getWidth(),top+pipes.getHeight());
        if(left>0){
            canvas.drawBitmap(pipes,left,top,null);}
        if(mario.MOVE>=canvas.getWidth()/2) {
            if (left > 0) {
                left = left - 20;
            }
        }


    }



}
