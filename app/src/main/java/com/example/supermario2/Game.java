package com.example.supermario2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Game extends SurfaceView implements SurfaceHolder.Callback{
    public GameThread thread;

    Mario mario;
    Bitmap wallpaper;
    Obstacles obstacles;
    Blocks blocks;
    Canvas canvas;
    Goomba goomba;
    Mushroom mushroom;
    Levels levels;
    Rect floor;
    int GameState=1;
    int Points=0;

    Paint paint=new Paint();
    int rotate=1;
    int WIDTH;
    int HEIGHT;

    public Game(Context context) {

        super(context);
        getHolder().addCallback(this);
        thread = new GameThread(this);
        mario=new Mario(context,this);
       // blocks=new Blocks(context,this);
        wallpaper= BitmapFactory.decodeResource(getResources(),R.drawable.mariobackground);
        this.obstacles=new Obstacles(context,this,mario);
        this.goomba=new Goomba(context,this,mario);
        this.mushroom=new Mushroom(context,this,mario);
        this.levels=new Levels(context,this,mario);
        levels.initlevel1();
        mario.state=1;
        mario.type=1;


        setFocusable(true);

        //nextshape= BitmapFactory.decodeResource(getResources(),R.drawable.squarepic);


            }

    public Game(Context context, AttributeSet attrs) {

        super(context,attrs);
        thread = new GameThread(this);
        mario=new Mario(context,this);
      //  blocks=new Blocks(context,this);
        wallpaper= BitmapFactory.decodeResource(getResources(),R.drawable.mariobackground);
        this.obstacles=new Obstacles(context,this,mario);
        this.goomba=new Goomba(context,this,mario);
        this.mushroom=new Mushroom(context,this,mario);

        mario.state=1;
        mario.type=1;


        setFocusable(true);




    }



    public void shiftRight(){

    }



    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new GameThread( this);

        thread.start();
    }


    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        thread.interrupt();


    }




    public void update(){
        //mario.collide;
        mario.moveright();


    }

    public Boolean collision(){
//
        System.out.println("collision");
        for(int i=0;i<4;i++) {
            if (mario.rectangle.top == levels.obstacles1[i].rectangle.bottom){
                System.out.println("COLLLIDE");
                return false;
            }
            if (mario.rectangle.intersect(levels.obstacles1[i].rectangle)) {

                return false;


            }
        }

  if(mario.rectangle.intersect(goomba.rectangle)){
      System.out.println("GOOMBAAAA");
      goomba.changeMario();
      return false;
  }

  else if(mario.rectangle.intersect(mushroom.rectangle)){
      mushroom.changeMario();
      return false;
  }

      return true;


    }








    @Override
    public void draw(Canvas canvas){
        Boolean check;
        super.draw(canvas);
        this.canvas=canvas;
        WIDTH=canvas.getWidth();
        HEIGHT=canvas.getHeight();

        Bitmap bit;
        System.out.println("WIDTH:"+canvas.getWidth());
        System.out.println("HEIGHT"+canvas.getHeight());



        canvas.drawBitmap(wallpaper,1,1,null);

        mario.draw(canvas);
       // blocks.draw1(canvas);
        levels.draw(canvas);

        goomba.draw(canvas);
        mushroom.draw(canvas);
        check=collision();









       // postInvalidate();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction()){
            case MotionEvent.ACTION_UP:
                System.out.println("MOVE up");
                System.out.println(HEIGHT);
               //if(mario.marioheight<>HEIGHT-mario.mario.getHeight())//-mario.marioheight)
                if(mario.marioheight>=70 && collision()==true){
                    mario.state=3;
                mario.velocity=-70;}
                //mario.update(0,60);

                break;


            case MotionEvent.ACTION_DOWN:
                if(mario.MOVE>0 && collision()==true){
                    //mario.MOVE=mario.MOVE-100;
                }

                break;


            }

        return true;
    }
}

