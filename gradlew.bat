package com.example.tetris2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public  class Shape {

    Board board;
    int z=0;
    Paint paint=new Paint();
    int color;
    int clear;
    int xcoord=0,ycoord=0;
    int xbound1,xbound2;
    int boolvar, old;
    public Shape(int color){

        this.paint=paint;
        this.color=color;

    }


    public Rect[] store=new Rect [4];



    public void draw(Canvas canvas) {
        //Paint paint=new Paint();
       // Paint paint2=new Paint();
        paint.setColor(color);
        //paint2.setColor(Color.GRAY);



        if(z==0){
            init();

            canvas.drawRect(store[0], paint);
            canvas.drawRect(store[1], paint);
            canvas.drawRect(store[2], paint);
            canvas.drawRect(store[3], paint);}




        if (z>0 && z<13) {

            /*for (int i = 0; i < 4; i++) {
                canvas.drawRect(store[i], paint2);
            }*/


            for (int i = 0; i < 4; i++) {
                //  canvas.drawRect(store[i],paint2);
                canvas.drawRect(store[i], paint);
            }




        }

        /*if(z==11){


            clear=1;

            //update score
            //call new piece to come move
        }*/

        /*    try { Thread.sleep(500); }
            catch (InterruptedException e) {
                return;
            }*/







    }

    public void update(int xcoord,int ycoord,int rotate){

    }
    public void init(){




    }



}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              