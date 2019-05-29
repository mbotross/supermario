package com.example.supermario2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;

import java.util.ArrayList;

public class Goomba {
    Context context;
    Game game;
    Bitmap goomba1,goomba2;
    Bitmap goombas[]=new Bitmap[2];
    Mario mario;
    Rect rectangle;
    int x;
    int y=800;
    int var=0;
    ArrayList<Point> goombaslist=new ArrayList<Point>();

    public Goomba(Context context,Game game,Mario mario){
        this.context=context;
        this.game=game;
        this.mario=mario;



        goomba1=BitmapFactory.decodeResource(context.getResources(),R.drawable.goombatwo);
        goomba2= BitmapFactory.decodeResource(context.getResources(),R.drawable.goomba);
        goombas[0]=goomba1;
        goombas[1]=goomba2;
       goombaslist.add(new Point(1500,800));

    }



    public void changeMario(){
        if(mario.type==1){
            game.GameState=0;

        }
        else if(mario.type==2){
            mario.type=1;
        }






    }
    public void intersect(){

    }

    public void draw(Canvas canvas){
        int x=goombaslist.get(0).x;
        int y=goombaslist.get(0).y;
        System.out.println(game.WIDTH);
        System.out.println("x"+x);

        rectangle=new Rect(x,800,x+goomba1.getWidth(),800+goomba1.getHeight());

        if(x>0){
            canvas.drawBitmap(goombas[var],x,800,null);
            goombaslist.get(0).x=goombaslist.get(0).x-50;}

        var++;
        if(var==2){
            var=0;
        }
    }


}
