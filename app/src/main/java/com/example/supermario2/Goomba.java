package com.example.supermario2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import java.util.ArrayList;

public class Goomba extends Obstacles{

    Bitmap goomba1,goomba2;
    Bitmap goombas[]=new Bitmap[2];
    Rect rectangle;
    int x;
    int y=800;
    int var=0;
    int change=0;
    ArrayList<Point> goombaslist=new ArrayList<Point>();
    ArrayList<Rect> goombaslistrect=new ArrayList<Rect>();
    ArrayList<Integer> goombasmotion=new ArrayList<Integer>();
    ArrayList<Integer> booleangoomba=new ArrayList<Integer>();
    ArrayList<Integer>goombaimage=new ArrayList<Integer>();



    public Goomba(Context context,Game game,Mario mario){
        super(context,game,mario);
        this.context=context;
        this.game=game;
        this.mario=mario;



        goomba1=BitmapFactory.decodeResource(context.getResources(),R.drawable.goombatwo);
        goomba2= BitmapFactory.decodeResource(context.getResources(),R.drawable.goomba);
        goombas[0]=goomba1;
        goombas[1]=goomba2;
        goombaslist.add(new Point(1500,800));
        goombaslist.add(new Point(2300,800));


        goombaslist.add(new Point(5700,800));
        goombaslist.add(new Point(4000,800));
        goombaslist.add(new Point(3400,800));
        goombaslist.add(new Point(10000,800));
        goombaslist.add(new Point(11000,800));






        goombaslistrect.add(new Rect(1500, 800, 1500+ goomba1.getWidth(), 800 + goomba1.getHeight()));
        goombaslistrect.add(new Rect(2300, 800, 2300+ goomba1.getWidth(), 800 + goomba1.getHeight()));

        goombaslistrect.add(new Rect(5700, 800, 5700+ goomba1.getWidth(), 800 + goomba1.getHeight()));
        goombaslistrect.add(new Rect(4000, 800, 4000+ goomba1.getWidth(), 800 + goomba1.getHeight()));
        goombaslistrect.add(new Rect(3400, 800, 3400+ goomba1.getWidth(), 800 + goomba1.getHeight()));
        goombaslistrect.add(new Rect(10000, 800, 10000+ goomba1.getWidth(), 800 + goomba1.getHeight()));
        goombaslistrect.add(new Rect(11000, 800, 11000+ goomba1.getWidth(), 800 + goomba1.getHeight()));


        for(int i=0;i<goombaslist.size();i++){
            goombasmotion.add(0);
            booleangoomba.add(0);
            goombaimage.add(0);
        }



    }



    public void changeMario(){
        if(mario.type==1 && game.lives>=1 && mario.invincibility==0){
            game.lives--;
            if(game.lives==0){
                game.GameState=0;
            }
        }

        else if(mario.type==2 && mario.invincibility==0){
            mario.type=1;
            mario.marioheight=800;
        }
    }


    public Boolean collideleft(){
        Boolean check=false;

        for(int i=0;i<goombaslist.size();i++) {
            for (int j = 0; j < game.levels.obstacles1.size(); j++) {
                if ((Rect.intersects(goombaslistrect.get(i),game.levels.obstacles1.get(j).rectangle)&& goombaslistrect.get(i).right>=game.levels.obstacles1.get(j).rectangle.right) || goombaslist.get(i).x<0) {
                    if (goombasmotion.get(i) == 0) {
                        goombasmotion.set(i, 1);
                    }
                }
            }

           /* for(int k=0;k<goombaslist.size();k++){
                if(goombaslistrect.get(i).intersect(goombaslistrect.get(k))&& goombaslistrect.get(i).right>=goombaslistrect.get(k).right){
                    if (goombasmotion.get(i) == 0) {
                        goombasmotion.set(i, 1);
                    }
                }

            }*/
        }
        return check;
    }
    public Boolean collideright(){
        Boolean check=false;

        for(int i=0;i<goombaslist.size();i++) {
            for (int j = 0; j < game.levels.obstacles1.size(); j++) {
                if (Rect.intersects(goombaslistrect.get(i),game.levels.obstacles1.get(j).rectangle)&& goombaslistrect.get(i).right<game.levels.obstacles1.get(j).rectangle.right) {
                    System.out.println("COLLIDE MEEE");
                    if (goombasmotion.get(i) == 1) {
                        goombasmotion.set(i, 0);
                    }
                }
            }

         /*   for(int k=0;k<goombaslist.size();k++){
                if(goombaslistrect.get(i).intersect(goombaslistrect.get(k))&& goombaslistrect.get(i).right<goombaslistrect.get(k).right){
                    if (goombasmotion.get(i) == 1) {
                        goombasmotion.set(i, 0);
                    }
                }

            }*/
        }
        return check;
    }


    public Boolean CollideMario(){
        Boolean check=false;
        for(int i=0;i<goombaslistrect.size();i++){
            if(Rect.intersects(goombaslistrect.get(i),mario.rectangle)){
                goombaslist.remove(i);
                goombaslistrect.remove(i);
                goombasmotion.remove(i);
                booleangoomba.remove(i);
                goombaimage.remove(i);
                return true;
            }

        }


        return check;
    }


    public void goombaintersect(int index){
        /*for(int i=0;i<goombaslist.size();i++){
            for(int j=0;j<goombaslist.size();j++) {
                if (goombaslistrect.get(i).intersect(goombaslistrect.get(j))){
                    change=1;
                }

            }

        }*/


       // change=1;

    }

    public void draw(Canvas canvas,int i,int changes) {
                Boolean destroy=true;//CollideMario();


              destroy=collideright();
              destroy=collideleft();

              /*  if(CollideMario()){
                    goombaslist.remove(i);
                    goombaslistrect.remove(i);
                    goombasmotion.remove(i);
                }*/
                Paint paint=new Paint();

                int x = goombaslist.get(i).x;
                int y = goombaslist.get(i).y;
                System.out.println(game.WIDTH);
                System.out.println("x" + x);
                int var=goombaimage.get(i);

                rectangle = new Rect(x, 800, x + goomba1.getWidth(), 800 + goomba1.getHeight());
                goombaslistrect.set(i,rectangle);


                if (goombasmotion.get(i)== 0) {
                    canvas.drawBitmap(goombas[var], x, 800, null);
                    //canvas.drawRect(rectangle,paint);
                    goombaslist.get(i).x = goombaslist.get(i).x - 50;

                }


                    if (goombasmotion.get(i) == 1) {
                        canvas.drawBitmap(goombas[var], x, 800, null);
                        goombaslist.get(i).x = goombaslist.get(i).x + 50;
                    }





                if(var==0){
                    goombaimage.set(i,++var);}
                else if(var==1){
                    goombaimage.set(i,--var);
                }
            }






}
