package com.example.supermario2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class QuestionMark extends Obstacles{


    Bitmap questionmark;
   Mushrooms mushroom;
   int questiontype=1;
   Coins coin;
   int drawit=0;
    public QuestionMark(Context context, Game game, Mario mario, int left, int top,int questiontype) {
        super(context,game,mario);
        // super(context, game);
        this.questionmark= BitmapFactory.decodeResource(context.getResources(),R.drawable.questionmark);
        //top=300;
        //left=500;
        this.left=left;
        this.top=top;

        this.questiontype=questiontype;
    }


    public void draw(Canvas canvas){



        rectangle=new Rect(left,top,left+questionmark.getWidth(),top+30+questionmark.getHeight());

        canvas.drawBitmap(questionmark,left,top,null);//}
        if(mario.MOVE>=canvas.getWidth()/2 && game.pressed && game.collideright()) {
           // if (left > 0) {
                left = left - 20;
          //  }
        }

        if(drawit==1){
            coin.draw(canvas);
            if(Rect.intersects(mario.rectangle,coin.rectangle)){
            coin.collide();}
            //mushroom=new Mushroom(context,game,mario,left,top);


        }
        else if(drawit==2){


        }


    }


    public Boolean collide(){
        if(numbercollide==0 && game.GameState==1){
        game.Points=game.Points+10;}
        numbercollide++;
        questionmark=BitmapFactory.decodeResource(context.getResources(),R.drawable.dottedblock);
        if(questiontype==1){
            coin=new Coins(context,game,mario,left,top-150);
            drawit=1;

            //game.levels.obstacles1.add(coin);

        }
        else if(questiontype==2){
           mushroom=new Mushrooms(context,game,mario);



        }


        return true;

    }


}
