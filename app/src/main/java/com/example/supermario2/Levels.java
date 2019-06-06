package com.example.supermario2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;

import java.util.ArrayList;

public class Levels {
    Game game;
    BitmapFactory bit;
    Context context;
    Bitmap temp;
    Blocks block;
    QuestionMark questionmark;
    Pipes pipes;
    Mario mario;
    Coins coin;
    int pipetype=1;
    public int var1=24;
    public int var2=32;

    public int[] level1=new int [60];//1:block 2:questionmark 3:pipes 4:coins 5: endflag
    public int[] level2=new int [20];
    public int[] level3=new int [20];

    public Point[] level1coord=new Point[60];
    public Point[] level2coord=new Point[20];
    public Point[] level3coord=new Point[20];

    public ArrayList<Obstacles> obstacles1=new ArrayList<Obstacles>();
    public ArrayList<Obstacles> obstacles2=new ArrayList<Obstacles>();
    public ArrayList<Obstacles> obstacles3=new ArrayList<Obstacles>();

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
        this.pipes=new Pipes(context,game,mario,400,400,1);
        this.coin=new Coins(context,game,mario,400,400);

    }





    public void initlevel1(){
        for(int i=0;i<4;i++){
            level1[i]=1;
        }
        for(int i=4;i<8;i++){
            level1[i]=1;
        }
        level1[8]=3;
        for(int i=9;i<13;i++){
            level1[i]=4;
        }
        level1[13]=3;
        for(int i=14;i<18;i++){
            level1[i]=2;
        }
        level1[18]=5;
        for(int i=19;i<22;i++){
            level1[i]=3;
        }
        for(int i=22;i<25;i++){
            level1[i]=4;
        }
        level1[25]=1;
        level1[26]=2;
        level1[27]=1;
        level1[28]=2;
        level1[29]=1;




        level1coord[0]=new Point(500,600);
        level1coord[1]=new Point(500+block.Block.getWidth(),600);
        level1coord[2]=new Point(500+2*block.Block.getWidth(),600);
        level1coord[3]=new Point(500+3*block.Block.getWidth(),600);



        level1coord[4]=new Point(2100,600);
        level1coord[5]=new Point(2100+questionmark.questionmark.getWidth(),600);
        level1coord[6]=new Point(2100+2*questionmark.questionmark.getWidth(),600);
        level1coord[7]=new Point(2100+3*questionmark.questionmark.getWidth(),600);

        level1coord[8]=new Point(1700,770);


        level1coord[9]=new Point(500,400);
        level1coord[10]=new Point(500+coin.coin.getWidth(),400);
        level1coord[11]=new Point(500+2*coin.coin.getWidth(),400);
        level1coord[12]=new Point(500+3*coin.coin.getWidth(),400);

        level1coord[13]=new Point(2900,650);

        level1coord[14]=new Point(3400,550);
        level1coord[15]=new Point(3600,550);
        level1coord[16]=new Point(3800,550);
        level1coord[17]=new Point(3600,350);

        level1coord[18]=new Point(4300,440);
        //pipes
        level1coord[19]=new Point(5400,680);
        level1coord[20]=new Point(6700,770);
        level1coord[21]=new Point(7500,650);
        //coins
        level1coord[22]=new Point(5450,480);
        level1coord[23]=new Point(6750,570);
        level1coord[24]=new Point(7550,450);

        level1coord[25]=new Point(8000,600);
        level1coord[26]=new Point(8000+block.Block.getWidth(),600);
        level1coord[27]=new Point(8000+block.Block.getWidth()+questionmark.questionmark.getWidth(),600);
        level1coord[28]=new Point(8000+2*block.Block.getWidth()+questionmark.questionmark.getWidth(),600);
        level1coord[29]=new Point(8000+2*block.Block.getWidth()+2*questionmark.questionmark.getWidth(),600);










        for(int i=0;i<30;i++){
            if(level1[i]==1){

                obstacles1.add(new Blocks(context,game,mario,level1coord[i].x,level1coord[i].y));


            }
            else if(level1[i]==2){
                obstacles1.add(new QuestionMark(context,game,mario,level1coord[i].x,level1coord[i].y));
            }


            else if(level1[i]==3){
                obstacles1.add(new Pipes(context,game,mario,level1coord[i].x,level1coord[i].y,pipetype));
                pipetype++;
                if(pipetype==4){
                    pipetype=1;
                }
            }
            else if(level1[i]==4){
                obstacles1.add(new Coins(context,game,mario,level1coord[i].x,level1coord[i].y));
            }
            else if(level1[i]==5){
                obstacles1.add(new EndLevel(context,game,mario,level1coord[i].x,level1coord[i].y));
            }

        }














    }


    public void initlevel2(){



    }


    public void movebackground(){

      //  while(collision!=1){

            //index the array by 1 and draw t
        }


    int left=0;
    int top=0;
    public void draw(Canvas canvas){

        if(game.level==1){
        for(int i=0;i<obstacles1.size();i++){
            obstacles1.get(i).draw(canvas);
        }}
        else if(game.level==2){
            for(int i=0;i<obstacles1.size();i++){
                obstacles1.get(i).draw(canvas);
            }

        }
        else if(game.level==3){
            for(int i=0;i<obstacles1.size();i++){
                obstacles1.get(i).draw(canvas);
            }
        }



        //canvas.drawBitmap(level1[5][4],2,4,null);
        //while no collision

        //loop through arrayllist of obstacles and draw them
        //if mario collides with one of the obstacles, go to that obstacles update method and draw

    }



}
