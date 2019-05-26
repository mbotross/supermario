package com.example.supermario2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import java.util.ArrayList;

public class Blocks extends Obstacles{
    Bitmap Block;
    float top;
    float left;

    ArrayList<Bitmap> blocksarr=new ArrayList<>();
    public Blocks(Context context, Game game) {
        super(context, game);
        this.Block= BitmapFactory.decodeResource(context.getResources(),R.drawable.block);
        top=30;
        left=40;
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

        for(int i=0;i<blocksarr.size();i++){
            canvas.drawBitmap(blocksarr.get(i),left,top,null);
            left=left+Block.getWidth();



        }
        left=40;


    }
    public void draw2(Canvas canvas){



    }
    public void draw3(Canvas canvas){



    }


}
