
package com.example.supermario2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;

import java.util.ArrayList;

public class Plant extends Obstacles{

    Bitmap plant, plant2;
    Bitmap plants[]=new Bitmap[2];
    Rect rectangle;
    int x;
    int y=800;

    int change=0;
    int plantflag;
    ArrayList<Point> plantslist=new ArrayList<Point>();
    ArrayList<Rect> plantslistrect=new ArrayList<Rect>();
    ArrayList<Integer>plantimage=new ArrayList<Integer>();
    ArrayList<Integer> booleanplant=new ArrayList<Integer>();

    //ArrayList<Integer> plantsmotion=new ArrayList<Integer>();

    public Plant(Context context, Game game, Mario mario){
        super(context,game,mario);
        this.context=context;
        this.game=game;
        this.mario=mario;

        plant = BitmapFactory.decodeResource(context.getResources(),R.drawable.plant);
        plant2= BitmapFactory.decodeResource(context.getResources(),R.drawable.planttwo);
        plants[0]=plant;
        plants[1]=plant2;
        plantslist.add(new Point(1700,570));
        plantslist.add(new Point(12500,500));



        //plantslist.add(new Point(2300,800));
        //plantslist.add(new Point(2700,800));

        //plantslist.add(new Point(5700,800));
        //plantslist.add(new Point(4000,800));
        //plantslist.add(new Point(3400,800));

        plantslistrect.add(new Rect(1700, 570, 1700+ plant.getWidth(), 570 + plant.getHeight()));
        plantslistrect.add(new Rect(12500, 570, 15000+ plant.getWidth(), 570 + plant.getHeight()));
        for(int i=0;i<plantslist.size();i++){
            plantimage.add(i);
            booleanplant.add(i);
        }

        //plantslistrect.add(new Rect(2300, 800, 2300+ plant.getWidth(), 800 + plant.getHeight()));
        //plantslistrect.add(new Rect(2700, 800, 2700+ plant.getWidth(), 800 + plant.getHeight()));
        //plantslistrect.add(new Rect(5700, 800, 5700+ plant.getWidth(), 800 + plant.getHeight()));
        //plantslistrect.add(new Rect(4000, 800, 4000+ plant.getWidth(), 800 + plant.getHeight()));
        //plantslistrect.add(new Rect(3400, 800, 3400+ plant.getWidth(), 800 + plant.getHeight()));
        /*for(int i=0;i<plantslist.size();i++){
            plantsmotion.add(0);
        }*/
    }

    public void changeMario(){
        if(mario.type==1 && game.lives>1 && mario.invincibility==0){
            game.lives--;
            if(game.lives==0){
                game.GameState=0;
            }
        }

        else if(mario.type==2 && mario.invincibility==0){
            mario.type=1;
        }
    }
    /*
        public Boolean collideleft(){
            Boolean check=false;

            for(int i=0;i<plantslist.size();i++) {
                for (int j = 0; j < game.levels.obstacles1.size(); j++) {
                    if ((plantslistrect.get(i).intersect(game.levels.obstacles1.get(j).rectangle) && plantslistrect.get(i).right>=game.levels.obstacles1.get(j).rectangle.right) || plantslist.get(i).x<0) {
                        if (plantsmotion.get(i) == 0) {
                            plantsmotion.set(i, 1);
                        }
                    }
                }

               /* for(int k=0;k<plantslist.size();k++){
                    if(plantslistrect.get(i).intersect(plantslistrect.get(k))&& plantslistrect.get(i).right>=plantslistrect.get(k).right){
                        if (plantsmotion.get(i) == 0) {
                            plantsmotion.set(i, 1);
                        }
                    }

                }*//*
        }
        return check;
    }
    public Boolean collideright(){
        Boolean check=false;

        for(int i=0;i<plantslist.size();i++) {
            for (int j = 0; j < game.levels.obstacles1.size(); j++) {
                if (plantslistrect.get(i).intersect(game.levels.obstacles1.get(j).rectangle) && plantslistrect.get(i).right<game.levels.obstacles1.get(j).rectangle.right) {
                    System.out.println("COLLIDE MEEE");
                    if (plantsmotion.get(i) == 1) {
                        plantsmotion.set(i, 0);
                    }
                }
            }

         /*   for(int k=0;k<plantslist.size();k++){
                if(plantslistrect.get(i).intersect(plantslistrect.get(k))&& plantslistrect.get(i).right<plantslistrect.get(k).right){
                    if (plantsmotion.get(i) == 1) {
                        plantsmotion.set(i, 0);
                    }
                }

            }*//*
        }
        return check;
    }
*/
    public Boolean CollideMario(){
        Boolean check=false;
        for(int i=0;i<plantslistrect.size();i++){
            if(Rect.intersects(plantslistrect.get(i),mario.rectangle)){
                plantslist.remove(i);
                plantslistrect.remove(i);
                plantimage.remove(i);
                booleanplant.remove(i);

                return true;
            }

        }


        return check;
    }

    public void draw(Canvas canvas,int i,int change) {

        //destroy=collideright();
        //destroy=collideleft();
/*
        if(CollideMario()){
            plantslist.remove(i);
            plantslistrect.remove(i);
            //plantsmotion.remove(i);
        }
        //Paint paint=new Paint();
*/


            int x = plantslist.get(i).x;
            int y = plantslist.get(i).y;
            int var=plantimage.get(i);


            rectangle = new Rect(x, y, x + plant.getWidth(), y + plant.getHeight());
            plantslistrect.set(i, rectangle);

            if (change == 1) {
                //Thread.sleep(5000);

                canvas.drawBitmap(plants[var], x, y, null);
               // plantflag = 1;

                //wait(5000);
            } else {
                canvas.drawBitmap(plants[var], x - 40000, y, null);
                //plantflag = 0;
            }


            if (mario.MOVE >= canvas.getWidth() / 2 && game.pressed && game.collideright()) {
                plantslist.get(i).x = plantslist.get(i).x - 20;
            }




            if(var==0){
            plantimage.set(i,++var);}
            else if(var==1){
                plantimage.set(i,--var);
            }


    }
}