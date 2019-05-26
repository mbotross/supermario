package com.example.supermario2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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

    Paint paint=new Paint();
    int rotate=1;
    int WIDTH;

    public Game(Context context) {

        super(context);
        getHolder().addCallback(this);
        thread = new GameThread(this);
        mario=new Mario(context,this);
        blocks=new Blocks(context,this);
        wallpaper= BitmapFactory.decodeResource(getResources(),R.drawable.mariobackground);
        this.obstacles=new Obstacles(context,this);



        setFocusable(true);

        //nextshape= BitmapFactory.decodeResource(getResources(),R.drawable.squarepic);


            }

    public Game(Context context, AttributeSet attrs) {

        super(context,attrs);
        getHolder().addCallback(this);
        thread = new GameThread(this);
        mario=new Mario(context,this);
        obstacles=new Obstacles(context,this);





        setFocusable(true);




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
        mario.move();




    }









    @Override
    public void draw(Canvas canvas){

        super.draw(canvas);
        WIDTH=canvas.getWidth();
        Bitmap bit;
        System.out.println("WIDTH:"+canvas.getWidth());
        System.out.println("HEIGHT"+canvas.getHeight());


        Paint textpaint=new Paint();

        textpaint.setTextSize(50);
        textpaint.setColor(Color.RED);
        textpaint.setStyle(Paint.Style.FILL_AND_STROKE);
       // bit=Bitmap.createBitmap(background,0,0,1000,1000);
        canvas.drawBitmap(wallpaper,1,1,null);

   /*     obstacles.draw(canvas);
        System.out.println("WHYYYY");
        if(obstacles.var1>0){
        obstacles.var1--;}
        if(obstacles.var2>0){
        obstacles.var2--;}
        //System.out.println("VAR!"+obstacles.var1);*/
        mario.draw(canvas);
        blocks.draw1(canvas);









       // postInvalidate();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction()){
            case MotionEvent.ACTION_UP:
                System.out.println("MOVE up");
                mario.update(0,60);

                break;



            }

        return true;
    }
}

