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
    int left,top;
    ArrayList<Point> starlist = new ArrayList<Point>();
    int x;
    int y = 800;

    public StarMan(Context context, Game game, Mario mario,int left,int top) {
        this.context = context;
        this.game = game;
        this.mario = mario;
        this.left=left;
        this.top=top;

        star = BitmapFactory.decodeResource(context.getResources(), R.drawable.star);
        starlist.add(new Point(left,top));

    }

    public void initmushroom(){
        x=game.WIDTH/2;
    }

    public void changeMario() {
        mario.invincibility = 1;
        if(game.GameState==1){
            game.Points=game.Points+1000;
        }

    }

    public void draw(Canvas canvas) {


        System.out.println("left star:"+left);
        this.rectangle = new Rect(starlist.get(0).x, starlist.get(0).y, starlist.get(0).x + star.getWidth(), starlist.get(0).y + star.getHeight());


        if(starlist.get(0).x > 0){
            System.out.println("DRAWWW MEE");
            canvas.drawBitmap(star, starlist.get(0).x, starlist.get(0).y, null);}
        starlist.get(0).x = starlist.get(0).x - 50;
        System.out.println("new x"+starlist.get(0).x);





    }
}