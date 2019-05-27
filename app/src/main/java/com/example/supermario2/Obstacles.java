package com.example.supermario2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Obstacles {
    Game game;
    BitmapFactory bit;
    Context context;
    Bitmap temp;
    public int var1=24;
    public int var2=32;
    public int[][] level1=new int [16][8];
    public int[][] level2=new int [16][8];
    public int[][] level3=new int [16][8];

    //Bitmap [][]level1=new Bitmap[32][8];
    //Bitmap [][]level2=new Bitmap[32][8];
    //Bitmap [][]level3=new Bitmap[32][8];

    public  Obstacles(Context context, Game game){
        this.game=game;
        this.bit=new BitmapFactory();
        this.context=context;
        initlevel1();
    }





    public void initlevel1(){



    }



    public void movebackground(){

      //  while(collision!=1){

            //index the array by 1 and draw t
        }


    int left=0;
    int top=0;
    public void draw(Canvas canvas){


        System.out.println("OBSTACLES");
        //canvas.drawBitmap(level1[5][4],2,4,null);
        //while no collision

        //loop through arrayllist of obstacles and draw them
        //if mario collides with one of the obstacles, go to that obstacles update method and draw

        for(int i=var1;i<var2;i++){
            for(int j=0;j<8;j++){

            //    canvas.drawBitmap(level1[i][j],left,top,null);
                left=left+71;
                if(left>=canvas.getWidth()){
                    left=0;
                    top=top+70;
                }
                if(top>=canvas.getHeight()){
                    top=0;
                }


            }
        }
    }



}
