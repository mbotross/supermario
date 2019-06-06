package com.example.supermario2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import java.util.ArrayList;

public class Mushrooms extends Obstacles {

    Bitmap mushroom;
    Rect rectangle;
    int x;
    int y=800;
    int var=0;
    int change=0;
    ArrayList<Point> mushroomlist=new ArrayList<Point>();
    ArrayList<Rect> mushroomlistrect=new ArrayList<Rect>();
    ArrayList<Integer> mushroommotion=new ArrayList<Integer>();



    public Mushrooms(Context context, Game game, Mario mario){
        super(context,game,mario);
        this.context=context;
        this.game=game;
        this.mario=mario;



        mushroom= BitmapFactory.decodeResource(context.getResources(), R.drawable.mushroom1);

        mushroomlist.add(new Point(850,800));
        mushroomlist.add(new Point(12500,400));
        mushroomlist.add(new Point(3000,800));

    


        mushroomlistrect.add(new Rect(850, 800, 850+ mushroom.getWidth(), 800 + mushroom.getHeight()));
        mushroomlistrect.add(new Rect(12500, 400, 12500+ mushroom.getWidth(), 400 + mushroom.getHeight()));
        mushroomlistrect.add(new Rect(3000, 800, 3000+ mushroom.getWidth(), 800 + mushroom.getHeight()));

        for(int i=0;i<mushroomlist.size();i++){
            mushroommotion.add(0);
        }
        }



    





    public Boolean collideleft(){
        Boolean check=false;

        for(int i=0;i<mushroomlist.size();i++) {
            for (int j = 0; j < game.levels.obstacles1.size(); j++) {
                if ((Rect.intersects(mushroomlistrect.get(i),game.levels.obstacles1.get(j).rectangle)&& mushroomlistrect.get(i).right>=game.levels.obstacles1.get(j).rectangle.right) || mushroomlist.get(i).x<0) {
                    if (mushroommotion.get(i) == 0) {
                        mushroommotion.set(i, 1);
                    }
                }
            }


        }
        return check;
    }
    public Boolean collideright(){
        Boolean check=false;

        for(int i=0;i<mushroomlist.size();i++) {
            for (int j = 0; j < game.levels.obstacles1.size(); j++) {
                if (Rect.intersects(mushroomlistrect.get(i),game.levels.obstacles1.get(j).rectangle)&& mushroomlistrect.get(i).right<game.levels.obstacles1.get(j).rectangle.right) {
                    System.out.println("COLLIDE MEEE");
                    if (mushroommotion.get(i) == 1) {
                        mushroommotion.set(i, 0);
                    }
                }
            }

         /*   for(int k=0;k<mushroomlist.size();k++){
                if(mushroomlistrect.get(i).intersect(mushroomlistrect.get(k))&& mushroomlistrect.get(i).right<mushroomlistrect.get(k).right){
                    if (mushroommotion.get(i) == 1) {
                        mushroommotion.set(i, 0);
                    }
                }

            }*/
        }
        return check;
    }


    public Boolean CollideMario(){
        Boolean check=false;
        for(int i=0;i<mushroomlistrect.size();i++){
            if(mushroomlistrect.get(i).intersect(mario.rectangle)){
                mario.type=2;

                return true;

            }

        }


        return check;
    }




    public void draw(Canvas canvas, int i) {
        Boolean destroy=true;//CollideMario();


        destroy=collideright();
        destroy=collideleft();

        if(CollideMario()){
            mushroomlist.remove(i);
            mushroomlistrect.remove(i);
            mushroommotion.remove(i);
        }
        Paint paint=new Paint();

        int x = mushroomlist.get(i).x;
        int y = mushroomlist.get(i).y;
        System.out.println(game.WIDTH);
        System.out.println("x" + x);

        rectangle = new Rect(x, 800, x + mushroom.getWidth(), 800 + mushroom.getHeight());
        mushroomlistrect.set(i,rectangle);


        if (mushroommotion.get(i)== 0) {
            canvas.drawBitmap(mushroom, x, 800, null);
            //canvas.drawRect(rectangle,paint);
            mushroomlist.get(i).x = mushroomlist.get(i).x - 50;

        }


        if (mushroommotion.get(i) == 1) {
            canvas.drawBitmap(mushroom, x, 800, null);
            mushroomlist.get(i).x = mushroomlist.get(i).x + 50;
        }





    }






}
