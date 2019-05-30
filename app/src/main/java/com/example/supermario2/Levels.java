package com.example.supermario2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;

public class Levels {
    Game game;
    BitmapFactory bit;
    Context context;
    Bitmap temp;
    Blocks block;
    QuestionMark questionmark;
    Mario mario;
    public int var1=24;
    public int var2=32;

    public int[] level1=new int [16];//1:block 2:questionmark
    public int[] level2=new int [16];
    public int[] level3=new int [16];

    public Point[] level1coord=new Point[16];
    public Point[] level2coord=new Point[16];
    public Point[] level3coord=new Point[16];

    public Obstacles obstacles1[]=new Obstacles [16];

   //Bitmap [][]level1=new Bitmap[32][8];
    //Bitmap [][]level2=new Bitmap[32][8];
    //Bitmap [][]level3=new Bitmap[32][8];

    public  Levels(Context context, Game game,Mario mario){
        this.game=game;
        this.bit=new BitmapFactory();
        this.context=context;
        this.mario=mario;
        this.block=new Blocks(context,game,mario,300,500);
        this.questionmark=new QuestionMark(context,game,mario,400,400);

    }





    public void initlevel1(){
        for(int i=0;i<4;i++){
            level1[i]=1;
        }
        for(int i=4;i<8;i++){
            level1[i]=2;
        }

        level1coord[0]=new Point(500,300);
        level1coord[1]=new Point(500+block.Block.getWidth(),300);
        level1coord[2]=new Point(500+2*block.Block.getWidth(),300);
        level1coord[3]=new Point(500+3*block.Block.getWidth(),300);

        level1coord[4]=new Point(700,450);
        level1coord[5]=new Point(700+questionmark.questionmark.getWidth(),450);
        level1coord[6]=new Point(700+2*questionmark.questionmark.getWidth(),450);
        level1coord[7]=new Point(700+3*questionmark.questionmark.getWidth(),450);



        for(int i=0;i<8;i++){
            if(level1[i]==1){

                obstacles1[i]=new Blocks(context,game,mario,level1coord[i].x,level1coord[i].y);


            }
            else if(level1[i]==2){
                obstacles1[i]=new QuestionMark(context,game,mario,level1coord[i].x,level1coord[i].y);
            }
        }














    }



    public void movebackground(){

      //  while(collision!=1){

            //index the array by 1 and draw t
        }


    int left=0;
    int top=0;
    public void draw(Canvas canvas){


        for(int i=0;i<8;i++){
            obstacles1[i].draw(canvas);
        }



        //canvas.drawBitmap(level1[5][4],2,4,null);
        //while no collision

        //loop through arrayllist of obstacles and draw them
        //if mario collides with one of the obstacles, go to that obstacles update method and draw

    }



}
