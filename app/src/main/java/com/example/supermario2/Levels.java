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
    Platform platform;
    int pipetype=1;
    public int var1=24;
    public int var2=32;
    int questiontype=1;
    int endlevel=1;

    public int[] level1=new int [70];//1:block 2:questionmark 3:pipes 4:coins 5: endflag 6: platform
    public int[] level2=new int [20];
    public int[] level3=new int [20];

    public Point[] level1coord=new Point[70];
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
        this.questionmark=new QuestionMark(context,game,mario,400,400,1);
        this.pipes=new Pipes(context,game,mario,400,400,1);
        this.coin=new Coins(context,game,mario,400,400);
        this.platform=new Platform(context,game,mario,300,300);

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
        for(int i=14;i<17;i++){
            level1[i]=2;
        }
        level1[17]=4;
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



        for(int i=30;i<37;i++){
            level1[i]=6;
        }
        level1[37]=3;
        level1[38]=5;
        level1[39]=6;
        for(int i=40;i<43;i++){
            level1[i]=4;
        }
        level1[43]=2;
        level1[44]=6;
        for(int i=45;i<48;i++){
            level1[i]=4;
        }
        for(int i=48;i<54;i++){
            level1[i]=1;
        }
        for(int i=54;i<66;i++){
            level1[i]=4;
        }
        level1[66]=5;


        level1coord[0]=new Point(500,550);
        level1coord[1]=new Point(500+block.Block.getWidth(),550);
        level1coord[2]=new Point(500+2*block.Block.getWidth(),550);
        level1coord[3]=new Point(500+3*block.Block.getWidth(),550);



        level1coord[4]=new Point(2100,550);
        level1coord[5]=new Point(2100+questionmark.questionmark.getWidth(),550);
        level1coord[6]=new Point(2100+2*questionmark.questionmark.getWidth(),550);
        level1coord[7]=new Point(2100+3*questionmark.questionmark.getWidth(),550);

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

        level1coord[25]=new Point(8000,550);
        level1coord[26]=new Point(8000+block.Block.getWidth(),550);
        level1coord[27]=new Point(8000+block.Block.getWidth()+questionmark.questionmark.getWidth(),550);
        level1coord[28]=new Point(8000+2*block.Block.getWidth()+questionmark.questionmark.getWidth(),550);
        level1coord[29]=new Point(8000+2*block.Block.getWidth()+2*questionmark.questionmark.getWidth(),550);

        level1coord[30]=new Point(9500,600);
        level1coord[31]=new Point(9500+platform.platform.getWidth(),600-platform.platform.getHeight());
        level1coord[32]=new Point(9500+2*platform.platform.getWidth(),600-2*platform.platform.getHeight());
        level1coord[33]=new Point(9500+3*platform.platform.getWidth(),600-3*platform.platform.getHeight());

        level1coord[34]=new Point(9500+4*platform.platform.getWidth(),600-2*platform.platform.getHeight());
        level1coord[35]=new Point(9500+5*platform.platform.getWidth(),600-platform.platform.getHeight());
        level1coord[36]=new Point(9500+6*platform.platform.getWidth(),600);

        //pipe
        level1coord[37]=new Point(12500,670);
        level1coord[38]=new Point(13000,450);


        //Level 3
        //platform
        level1coord[39]=new Point(14000,600);
        //coins

        level1coord[40]=new Point(14000,400);
        level1coord[41]=new Point(14000+coin.coin.getWidth(),400);
        level1coord[42]=new Point(14000+2*coin.coin.getWidth(),400);


        level1coord[43]=new Point (15000,500);
        //more platforms
        level1coord[44]=new Point(15500,600);
        //coins
        level1coord[45]=new Point(15500,400);
        level1coord[46]=new Point(15500+coin.coin.getWidth(),400);
        level1coord[47]=new Point(15500+2*coin.coin.getWidth(),400);

        //breakable blocks
        level1coord[48]=new Point(16500,550);
        level1coord[49]=new Point(16500+block.Block.getWidth(),550);
        level1coord[50]=new Point(16500+2*block.Block.getWidth(),550);
        level1coord[51]=new Point(16500+3*block.Block.getWidth(),550);
        level1coord[52]=new Point(16500+4*block.Block.getWidth(),550);
        level1coord[53]=new Point(16500+5*block.Block.getWidth(),550);
        //more coins
        level1coord[54]=new Point(16500,400);
        level1coord[55]=new Point(16500+coin.coin.getWidth(),400);
        level1coord[56]=new Point(16500+2*coin.coin.getWidth(),400);
        level1coord[57]=new Point(16500+3*coin.coin.getWidth(),400);
        level1coord[58]=new Point(16500+4*coin.coin.getWidth(),400);
        level1coord[59]=new Point(16500+5*coin.coin.getWidth(),400);


        level1coord[60]=new Point(18000,800);
        level1coord[61]=new Point(18000+coin.coin.getWidth(),800);
        level1coord[62]=new Point(18000+2*coin.coin.getWidth(),800);

        level1coord[63]=new Point(19000+3*coin.coin.getWidth(),800);
        level1coord[64]=new Point(19000+4*coin.coin.getWidth(),800);
        level1coord[65]=new Point(19000+5*coin.coin.getWidth(),800);

        //end level
        level1coord[66]=new Point(19000+5*coin.coin.getWidth()+600,600);























        for(int i=0;i<67;i++){
            if(level1[i]==1){

                obstacles1.add(new Blocks(context,game,mario,level1coord[i].x,level1coord[i].y));


            }
            else if(level1[i]==2){
                obstacles1.add(new QuestionMark(context,game,mario,level1coord[i].x,level1coord[i].y,questiontype));
                questiontype++;
                if(questiontype==3){
                    questiontype=1;
                }
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
                obstacles1.add(new EndLevel(context,game,mario,level1coord[i].x,level1coord[i].y,endlevel));
                endlevel++;
                if(endlevel==4){
                    endlevel=3;
                }
            }
            else if(level1[i]==6){

                obstacles1.add(new Platform(context,game,mario,level1coord[i].x,level1coord[i].y));
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
