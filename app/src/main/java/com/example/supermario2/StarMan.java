package com.example.supermario2;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;

import java.util.ArrayList;

public class StarMan {
    Context context;
    Game game;
    Bitmap star;
    Mario mario;
    Rect rectangle;
    ArrayList<Point> starlist = new ArrayList<Point>();
    int x;
    int y = 800;

    public StarMan(Context context, Game game, Mario mario) {
        this.context = context;
        this.game = game;
        this.mario = mario;

        star = BitmapFactory.decodeResource(context.getResources(), R.drawable.star);
        starlist.add(new Point(2000,600));
    }

    public void initmushroom(){
        x=game.WIDTH/2;
    }

    public void changeMario() {
        mario.invincibility = 1;
        //stays invincible for 10 seconds

        // MOVE THIS SOMEWHERE ELSE my friends
/*
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mario.invincibility = 0;*/
    }

    public void draw(Canvas canvas) {

        this.rectangle = new Rect(starlist.get(0).x, starlist.get(0).y, starlist.get(0).x + star.getWidth(), starlist.get(0).y + star.getHeight());
        if(starlist.get(0).x > 0){
            canvas.drawBitmap(star, starlist.get(0).x, starlist.get(0).y, null);}
        starlist.get(0).x = starlist.get(0).x - 50;





    }
}