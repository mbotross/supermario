package com.example.supermario2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
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
    int lives=3;
    int level;
    float xcoord,ycoord;
    int mariox,marioy;

    Paint paint=new Paint();
    int rotate=1;
    int WIDTH;
    int HEIGHT;
    int flag;
    Boolean pressed=true;

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
        mario.moveright(mariox,marioy);


    }
    public Boolean collidedown(){


        for(int i=0;i<4;i++) {
            int mariochanged=mario.rectangle.bottom+200;
            //  if(mario.rectangle.intersect(levels.obstacles1.get(i).rectangle)){//&& mario.rectangle.bottom==levels.obstacles1.get(i).rectangle.top){
            //mario.rectangle.bottom = levels.obstacles1.get(i).rectangle.top;
            for (int j = levels.obstacles1.get(i).rectangle.left; j < levels.obstacles1.get(i).rectangle.right; j++) {


                if (mario.rectangle.contains(j, levels.obstacles1.get(i).rectangle.top + mario.mario.getHeight() / 2)) {
                    mario.marioheight = levels.obstacles1.get(i).rectangle.top - mario.mario.getHeight();
                    flag = 1;
                    System.out.println("IM HEREEEEE");


                    return false;


                } else {
                    flag=0;
                    return true;
                }
            }

                System.out.println("mario height"+mariochanged);
                System.out.println("blocj height"+ levels.obstacles1.get(i).rectangle.top);
                System.out.println("block bottom"+levels.obstacles1.get(i).rectangle.bottom);



             //   if(!levels.obstacles1.get(i).rectangle.contains(mario.rectangle)){
               //     flag=0;
                //}




            }

        return true;
    }

    public Boolean collision(){
//
        System.out.println("collision");
        for(int i=0;i<levels.obstacles1.size();i++) {

            if (mario.rectangle.intersect(levels.obstacles1.get(i).rectangle)) {
               return levels.obstacles1.get(i).collide();}

            if(goomba.rectangle.intersect(levels.obstacles1.get(i).rectangle)){
                goomba.intersect();
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
        //points


        ////
        super.draw(canvas);

        this.canvas=canvas;
        WIDTH=canvas.getWidth();
        HEIGHT=canvas.getHeight();


        System.out.println("WIDTH:"+canvas.getWidth());
        System.out.println("HEIGHT"+canvas.getHeight());



        canvas.drawBitmap(wallpaper,1,1,null);

        mario.draw(canvas);
       // blocks.draw1(canvas);

        levels.draw(canvas);

        goomba.draw(canvas);
        mushroom.draw(canvas);
        Paint textpaint=new Paint();
        textpaint.setTextSize(100);
        textpaint.setColor(Color.WHITE);
        textpaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawText("Points: ", 200, 200, textpaint);
        canvas.drawText(Integer.toString(Points), 550, 200, textpaint);

        check=collision();









       // postInvalidate();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        xcoord=event.getX();
        ycoord=event.getY();

        switch(event.getAction()){
            case MotionEvent.ACTION_UP:
                //mario.moveright((int)xcoord,(int)ycoord);
             //   pressed=false;
                pressed=true;
                System.out.println("MOVE up");
                System.out.println(HEIGHT);
               //if(mario.marioheight<>HEIGHT-mario.mario.getHeight())//-mario.marioheight)

                //mario.update(0,60);

                break;


            case MotionEvent.ACTION_DOWN:
                pressed=true;
                //move mario
                System.out.println("Canvas width:"+ canvas.getWidth());
              //  mariox=mario.MOVE+100;
               // mario.moveright((int)xcoord,(int)ycoord);

               // while(pressed) {
                    if (xcoord > WIDTH / 2){//&& ycoord>HEIGHT/2) {
                        if (mario.MOVE < WIDTH / 2){// && xcoord!=mario.MOVE) {

                           // mario.state=1;
                            //mariox = mario.MOVE + 100;
                            mariox = mario.MOVE + 100;
                        }

                    } else if (xcoord < WIDTH / 2){// && ycoord>HEIGHT/2) {
                        if (mario.MOVE > 0 ){//&& xcoord!=mario.MOVE) {
                            pressed=false;

                            //mario.state=2;
                            mariox = mario.MOVE - 100;
                        }
                    }
                if(ycoord<HEIGHT/2 && xcoord>WIDTH/2){

                    if(mario.marioheight>=600 && collision()==true){

                        mario.state=3;
                      //  mariox=mario.MOVE+100;
                        mario.velocity=-70;}}

                else if(ycoord<HEIGHT/2 && xcoord<WIDTH/2){
                    if(mario.marioheight>=600 && collision()==true){
                        pressed=false;
                        mario.state=4;
                      //  mariox=mario.MOVE-100;
                        mario.velocity=-70;}


                }
               // }


              //  if(mario.MOVE>0 && collision()==true){
                    //mario.MOVE=mario.MOVE-100;
                //}

                break;


            }

        return true;
    }
}

