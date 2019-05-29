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
    Bitmap[] superright=new Bitmap[4];
    Bitmap[] marioleft=new Bitmap[4];
    BitmapFactory bit;
    Paint paint=new Paint();
    int MOVE=300;
    int xpos,ypos;
    int velocity=0;
    int gravity=10;
    Rect rectangle;
    int state;//1:right 2:left 3:Jump
    int type;//1:normal, 2:Super 3:Invincible

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
        this.superright[0]=BitmapFactory.decodeResource(context.getResources(),R.drawable.superfirstright);


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

    public void update(){
        if(type==1) {
            if (marioheight < game.HEIGHT - (mario.getHeight() + 120) && state == 3) {
                velocity += gravity;
                marioheight += velocity;
                if (marioheight>800){
                    marioheight=800;
                }

            }


        }
        else if(type==2){
            if (marioheight < game.HEIGHT - (superright[0].getHeight() ) && state == 3) {
                velocity += gravity;
                marioheight+=velocity;
                if(marioheight>740){
                    marioheight=740;
                }


            }


        }



    }

    public void draw(Canvas canvas) {
        this.canvas=canvas;
        Paint paint=new Paint();
        paint.setColor(Color.GREEN);

        update();
        System.out.println("MARIO HEIGHT:"+marioheight);
        System.out.println("GAME HEIGHT:"+(game.HEIGHT-mario.getHeight()-100));

        rectangle=new Rect(MOVE, marioheight,MOVE+mario.getWidth(),marioheight+mario.getHeight());
        //canvas.drawRect(rectangle,paint);
        if(type==1) {
            if (state == 1)
                canvas.drawBitmap(marioright[var], MOVE, marioheight, null);
            else if (state == 2) {
                canvas.drawBitmap(marioright[var], MOVE, marioheight, null);

            } else if (state == 3) {
                canvas.drawBitmap(marioright[1], MOVE, marioheight, null);
            }
        }

        else if(type==2){
            canvas.drawBitmap(superright[0],MOVE,marioheight,null);
        }


        var++;
        if(var==2){
            var=0;
        }







       }



}
