package com.example.supermario2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class EndLevel extends Obstacles {

    Bitmap flag;
    public EndLevel(Context context, Game game, Mario mario,int left,int top) {
        super(context, game, mario);
        this.flag= BitmapFactory.decodeResource(context.getResources(),R.drawable.flag);
        this.left=left;
        this.top=top;
    }

    public void draw(Canvas canvas){

        rectangle=new Rect(left,top,left+flag.getWidth(),top+flag.getHeight());
        //if(left>0){
        canvas.drawBitmap(flag,left,top,null);//}
        if(mario.MOVE>=canvas.getWidth()/2 && game.pressed && game.collideright()) {
            // if (left > 0) {
            left = left - 20;
            //  }
        }

    }



    public Boolean collide(){


        return true;
    }

}
