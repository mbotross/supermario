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
    int left, top;
    int nodraw=0;

    public Mushroom(Context context, Game game, Mario mario,int left,int top) {
        this.context = context;
        this.game = game;
        this.mario = mario;
        this.left=left;
        this.top=top;



        mushroom = BitmapFactory.decodeResource(context.getResources(), R.drawable.mushroom1);
        mushroomlist.add(new Point(850,800));
        mushroomlist.add(new Point(12500,400));
    }


    public void initmushroom(){
        x=game.WIDTH/2;
        System.out.println("X value:"+x);
    }
    public void changeMario() {
        mario.type = 2;
        nodraw=1;




    }

    public void intersect() {

    }

    public void draw(Canvas canvas, int i) {

        System.out.println(game.WIDTH);
        System.out.println("x" + x);

        this.rectangle = new Rect(mushroomlist.get(i).x, mushroomlist.get(i).y, mushroomlist.get(i).x + mushroom.getWidth(), mushroomlist.get(i).y + mushroom.getHeight());
        if(nodraw==0){
        canvas.drawBitmap(mushroom, mushroomlist.get(i).x, mushroomlist.get(i).y, null);}

      //  mushroomlist.get(i).x = mushroomlist.get(i).x - 50;



    }

}
