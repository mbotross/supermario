package com.example.supermario2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.ArrayList;

public class Blocks extends Obstacles{
    Bitmap Block;
    int top;
    int left;
    Rect rectangle;

    ArrayList<Bitmap> blocksarr=new ArrayList<>();
    public Blocks(Context context, Game game) {
        super(context, game);
        this.Block= BitmapFactory.decodeResource(context.getResources(),R.drawable.block);
        top=30;
        left=500;
        init();


    }

    public void init(){
        for(int i=0;i<4;i++){
            blocksarr.add(Block);
        }
    }

    public void update(){


    }
    public void draw1(Canvas canvas){
        Paint paint=new Paint();
        paint.setColor(Color.GREEN);
        for(int i=0;i<blocksarr.size();i++){
            rectangle=new Rect(left,top,left+Block.getWidth(),top+Block.getHeight());
            canvas.drawBitmap(blocksarr.get(i),left,top,null);
          //  canvas.drawRect(rectangle,paint);
            left=left+Block.getWidth();



        }
        left=500;


    }
    public void draw2(Canvas canvas){



    }
    public void draw3(Canvas canvas){



    }


}
