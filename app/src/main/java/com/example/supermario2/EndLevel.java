package com.example.supermario2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class EndLevel extends Obstacles {

    Bitmap flag;
    Bitmap castle;
    int type;
    public EndLevel(Context context, Game game, Mario mario,int left,int top,int type) {
        super(context, game, mario);
        this.flag= BitmapFactory.decodeResource(context.getResources(),R.drawable.flag);
        this.castle=BitmapFactory.decodeResource(context.getResources(),R.drawable.castle);

        this.left=left;
        this.top=top;
        this.type=type;
    }

    public void draw(Canvas canvas){
        if(type==1 ){
        rectangle=new Rect(left,top,left+flag.getWidth(),top+flag.getHeight());
        //if(left>0){
        canvas.drawBitmap(flag,left,top,null);//}
        if(mario.MOVE>=canvas.getWidth()/2 && game.pressed && game.collideright()) {
            // if (left > 0) {
            left = left - 20;
            //  }
        }}
        else if(type==2 ){
            rectangle=new Rect(left,top,left+castle.getWidth(),top+castle.getHeight());
            //if(left>0){
            canvas.drawBitmap(castle,left,top,null);//}
            if(mario.MOVE>=canvas.getWidth()/2 && game.pressed && game.collideright()) {
                // if (left > 0) {
                left = left - 20;
                //  }
            }


        }

    }




    public Boolean collide(){
        if(numbercollide==0) {

            game.level++;

        }
        numbercollide++;
        if(game.level==4){
            game.level=3;
        }

        return true;
    }

}
