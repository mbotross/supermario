package com.example.tetris2;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class SquareShape extends Shape {

    Paint paint=new Paint();




   public Board board;

   public Rect [] store=new Rect [4];


   //Rect test=new Rect(100,100,200,200);
    int x=0, y=0;
    int z=0,i=0;


    public SquareShape(Board board){
        super(Color.YELLOW);
        xbound1=4;
        xbound2=-4;

        this.board=board;

    }



    public void init(){

        store[0]=board.tetrisboard[4][0];
        store[1]=board.tetrisboard[5][0];
        store[2]=board.tetrisboard[4][1];
        store[3]=board.tetrisboard[5][1];



    }


    @Override
    public void draw(Canvas canvas) {


        paint.setColor(Color.YELLOW);




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

        if(z==11 || (board.boolarr[5+xcoord][1+z+1]==true || board.boolarr[4+xcoord][1+z+1]==true )){

            clear=1;
           // for(int i=0;i<10;i++){
             //   for(int j=0;j<13;j++){
                    System.out.println("bool :"+ board.boolarr[4][11] + "at");
            System.out.println("bool :"+ board.boolarr[5][11] + "at");
            System.out.println("bool :"+ board.boolarr[4][12] + "at");
            System.out.println("bool :"+ board.boolarr[4][12] + "at");
            old=xcoord;

              //  }
           // }

            //increment the score
            //board.newshape=1;

            //update score
            //call new piece to come move
        }





    }

    @Override
    public void update(int x,int y, int rotate){
       // clear++;
    // if(z<11){
      //  z=z+1;}
    //System.out.println("HELLO!" +board.tetrisboard[5+xcoord][1+z+1]);


        if(board.boolarr[5+xcoord][1+z+1]==false && board.boolarr[4+xcoord][1+z+1]==false){
        z=z+1;
        System.out.println("HEREEEEEE");
        System.out.println("xcoord"+xcoord);
        System.out.println("OLD:"+old);



        store[0]=board.tetrisboard[4+xcoord][z];
        store[1]=board.tetrisboard[5+xcoord][z];
        store[2]=board.tetrisboard[4+xcoord][1+z];
        store[3]=board.tetrisboard[5+xcoord][1+z];


        board.boolarr[4+xcoord][z]=true;
        board.boolarr[5+xcoord][z]=true;
        board.boolarr[4+xcoord][1+z]=true;
        board.boolarr[5+xcoord][1+z]=true;
        //setting top equal to false makes the top row of square equal to false

        board.boolarr[4+boolvar][z-1]=false;
        board.boolarr[5+boolvar][z-1]=false;
        board.boolarr[4+boolvar][1+z-3]=false;
        board.boolarr[5+boolvar][1+z-3]=false;}



    }



    }

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             