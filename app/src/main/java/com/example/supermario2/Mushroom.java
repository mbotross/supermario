package com.example.supermario2;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;

import java.util.ArrayList;

public class Mushroom {
    Context context;
    Game game;
    Bitmap mushroom;
    Mario mario;
    Rect rectangle;
    ArrayList<Point> mushroomlist=new ArrayList<Point>();
    int x;
    int y = 800;

    public Mushroom(Context context, Game game, Mario mario) {
        this.context = context;
        this.game = game;
        this.mario = mario;



        mushroom = BitmapFactory.decodeResource(context.getResources(), R.drawable.mushroom1);
        mushroomlist.add(new Point(850,800));
    }


    public void initmushroom(){
        x=game.WIDTH/2;
        System.out.println("X value:"+x);
    }
    public void changeMario() {
        mario.type = 2;


    }

    public void intersect() {

    }

    public void draw(Canvas canvas) {

        System.out.println(game.WIDTH);
        System.out.println("x" + x);

        this.rectangle = new Rect(mushroomlist.get(0).x, mushroomlist.get(0).y, mushroomlist.get(0).x+ mushroom.getWidth(), mushroomlist.get(0).y+ mushroom.getHeight());
        if(mushroomlist.get(0).x>0){
        canvas.drawBitmap(mushroom, mushroomlist.get(0).x,mushroomlist.get(0).y, null);}
        if (mushroomlist.get(0).x > 0 /* && collision detection=true*/ ){
            mushroomlist.get(0).x = mushroomlist.get(0).x - 50;
        }
       //else if(/*collision detection=false*/){
        //    x=x+50;
        //}


    }

}
