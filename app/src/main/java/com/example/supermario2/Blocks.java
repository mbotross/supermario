package com.example.supermario2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import java.util.ArrayList;

public class Blocks extends Obstacles {
    Bitmap Block;

   // int top;
    //int left;
    //Rect rectangle;
    int breakit=0;
    ArrayList<Bitmap> blocksarr=new ArrayList<>();
    public Blocks(Context context, Game game,Mario mario,int left,int top) {
        super(context,game,mario);
        // super(context, game);
        this.Block= BitmapFactory.decodeResource(context.getResources(),R.drawable.block);
        //top=300;
        //left=500;
        this.left=left;
        this.top=top;

        init();


    }

    public void init(){
        for(int i=0;i<4;i++){
            blocksarr.add(Block);
        }
    }

    public Boolean collide(){
        if(numbercollide==0 && game.GameState==1){
        game.Points=game.Points+10;}
        numbercollide++;

        if(mario.rectangle.top<=rectangle.bottom+10){
            breakit=1;

            return false;
        }

        return true;

    }

    public void draw(Canvas canvas){



        rectangle=new Rect(left,top,left+Block.getWidth(),top+30+Block.getHeight());
        if(breakit==0){
        canvas.drawBitmap(Block,left,top,null);
        }
        else if(breakit==1){
           int index=  game.levels.obstacles1.indexOf(this);
            game.levels.obstacles1.remove(index);

        }


        if(mario.MOVE>=canvas.getWidth()/2 && game.pressed && game.collideright()) {

                left = left - 20;

        }


    }



}
