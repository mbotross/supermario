package com.example.supermario2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Mario {
    Game game;
    Bitmap mario;
    String form;
    Canvas canvas;
    public int LIVES;
    public int marioheight=800;
    Bitmap [] marioright=new Bitmap[4];
    BitmapFactory bit;
    Paint paint=new Paint();
    int MOVE=300;
    int xpos,ypos,gravity,velocity;

    public Mario(Context context, Game game){
        //super(context);

        this.game=game;
        this.bit=new BitmapFactory();
        this.marioright[0]= BitmapFactory.decodeResource(context.getResources(),R.drawable.firstright);
        this.marioright[1]= BitmapFactory.decodeResource(context.getResources(),R.drawable.secondright);
       // this.marioright[2]= BitmapFactory.decodeResource(context.getResources(),R.drawable.thirdright);
        //this.marioright[3]= BitmapFactory.decodeResource(context.getResources(),R.drawable.fourthright);
        //this.marioright[0]= BitmapFactory.decodeResource(context.getResources(),R.drawable.firstleft);
        //this.marioright[1]= BitmapFactory.decodeResource(context.getResources(),R.drawable.secondleft);
        //this.marioright[2]= BitmapFactory.decodeResource(context.getResources(),R.drawable.thirdleft);
        //this.marioright[3]= BitmapFactory.decodeResource(context.getResources(),R.drawable.fourthleft);



    }

    public void initmario(){



    }

    public void jump(){


    }

    public void move(){
        //check if they press right or left
        //rotate between two bitmaps
        //also check if there aren't any obstacles
        if(MOVE<=canvas.getWidth()/2) {
            MOVE = MOVE + 100;
            if (MOVE >= game.WIDTH) {
                MOVE = 300;
            }
        }

        //while thing underneath mario is a block, move him
        //if there is a empty space underneath him, game is over and mario dies

    }

    public void collide(){




    }


    int var=0;

    public void update(int xpos,int ypos){
        this.ypos=ypos;
        marioheight=marioheight-ypos;

    }

    public void draw(Canvas canvas) {
        this.canvas=canvas;
      //  if(var==0){
        canvas.drawBitmap(marioright[var],MOVE,marioheight,null);
        try {
            game.thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        canvas.drawBitmap(marioright[var],MOVE,marioheight+ypos,null);

        var++;
        if(var==2){
            var=0;
        }
       /* else if(var==1){
            canvas.drawBitmap(marioright[var],MOVE,marioheight,null);
            var--;
        }*/







    }



}
