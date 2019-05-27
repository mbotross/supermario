package com.example.supermario2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Mario {
    Game game;
    String form;
    Canvas canvas;
    public int LIVES;
    public int marioheight=800;
    Bitmap mario;
    Bitmap[] marioright=new Bitmap[4];
    BitmapFactory bit;
    Paint paint=new Paint();
    int MOVE=300;
    int xpos,ypos;
    int velocity=0;
    int gravity=20;
    Rect rectangle;

    public Mario(Context context, Game game){
        //super(context);

        this.game=game;
        this.bit=new BitmapFactory();
        this.mario=BitmapFactory.decodeResource(context.getResources(),R.drawable.firstright);

       // this.marioright[0]=(BitmapDrawable) context.getResources().getDrawable(R.drawable.firstright);
        //this.marioright[0]=(BitmapDrawable) context.getResources().getDrawable(R.drawable.firstright);
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

    public void moveright(){
        //check if they press right or left
        //rotate between two bitmaps
        //also check if there aren't any obstacles
        if(MOVE<=canvas.getWidth()/2) {
            MOVE = MOVE + 100;

        }

        //while thing underneath mario is a block, move him
        //if there is a empty space underneath him, game is over and mario dies

    }
    public void moveleft(){

        if(MOVE>0){
            MOVE=MOVE-100;
        }

    }

    public void collide(String position){

        if(position.equals("right")){


        }
        else if(position.equals("left")){

        }
        else if(position.equals("up")){

        }




    }


    int var=0;

    public void update(int xpos,int ypos){
        this.ypos=ypos;
      //  marioheight=marioheight-velocity*10;

    }

    public void draw(Canvas canvas) {
        this.canvas=canvas;
        Paint paint=new Paint();
        paint.setColor(Color.GREEN);
       //if(marioheight<canvas.getHeight()-marioheight){
        velocity+=gravity;
        marioheight+=velocity;//}
        rectangle=new Rect(MOVE, marioheight,MOVE+mario.getWidth(),marioheight+mario.getHeight());
        canvas.drawRect(rectangle,paint);
      //  if(var==0){
        for(int i=0;i<2;i++){
          //marioright[i].setBounds(rectangle);

        }
        canvas.drawBitmap(marioright[var],MOVE,marioheight,null);



        var++;
        if(var==2){
            var=0;
        }








    }



}
