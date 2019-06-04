package com.example.supermario2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class QuestionMark extends Obstacles{


    Bitmap questionmark;
    Mushroom mushroom;
    static int questiontype=1;
    public QuestionMark(Context context, Game game, Mario mario, int left, int top) {
        super(context,game,mario);
        // super(context, game);
        this.questionmark= BitmapFactory.decodeResource(context.getResources(),R.drawable.questionmark);
        //top=300;
        //left=500;
        this.left=left;
        this.top=top;


    }


    public void draw(Canvas canvas){



        rectangle=new Rect(left,top,left+questionmark.getWidth(),top+questionmark.getHeight());
        //if(left>0){
            canvas.drawBitmap(questionmark,left,top,null);//}
        if(mario.MOVE>=canvas.getWidth()/2 && game.pressed && game.collideright()) {
           // if (left > 0) {
                left = left - 20;
          //  }
        }

        if(questiontype==1){
            mushroom=new Mushroom(context,game,mario);


        }


    }


    public Boolean collide(){
        if(numbercollide==0){
        game.Points=game.Points+10;}
        numbercollide++;
        questionmark=BitmapFactory.decodeResource(context.getResources(),R.drawable.dottedblock);
        if(mario.rectangle.top<=rectangle.bottom+10){
            return false;
        }
        else{
        return true;}
    }
}
