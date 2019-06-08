package com.example.supermario2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import static java.lang.Math.abs;

public class Game extends SurfaceView implements SurfaceHolder.Callback{
    public GameThread thread;

    Mario mario;
    Bitmap wallpaper;
    Obstacles obstacles;
    Blocks blocks;
    Canvas canvas;
    Goomba goomba;

    Mushrooms mushrooms;
    StarMan star,star2;
    Levels levels;
    Plant plant;
    Rect floor;
    int GameState=1;
    int Points=0;
    int lives=3;
    int level=1;
    float xcoord,ycoord;
    int mariox,marioy;
    int changeplant=1;
    int changeplant2=1;

    Paint paint=new Paint();
    int rotate=1;
    int WIDTH;
    int HEIGHT;
    int flag=0;
    int goombachange=0;
    int goombacounter=0;
    Boolean pressed=true;

    public Game(Context context) {

        super(context);
        getHolder().addCallback(this);
        thread = new GameThread(this);
        mario=new Mario(context,this);
       // blocks=new Blocks(context,this);
        wallpaper= BitmapFactory.decodeResource(getResources(),R.drawable.mariobackground);
        this.obstacles=new Obstacles(context,this,mario);
        this.goomba=new Goomba(context,this,mario);
        this.mushrooms=new Mushrooms(context,this,mario);
        this.plant = new Plant(context, this,mario);
      //  this.mushroom=new Mushroom(context,this,mario,1,1);
       // this.mushroom2=new Mushroom(context,this,mario,1,1);
        this.star=new StarMan(context, this,mario,2000,400);
        this.star2=new StarMan(context,this,mario,40000,400);
        this.levels=new Levels(context,this,mario);
        levels.initlevel1();
        mario.state=1;
        mario.type=1;


        setFocusable(true);

        //nextshape= BitmapFactory.decodeResource(getResources(),R.drawable.squarepic);


            }

    public Game(Context context, AttributeSet attrs) {

        super(context,attrs);
        thread = new GameThread(this);
        mario=new Mario(context,this);
      //  blocks=new Blocks(context,this);
        wallpaper= BitmapFactory.decodeResource(getResources(),R.drawable.mariobackground);
        this.obstacles=new Obstacles(context,this,mario);
        this.goomba=new Goomba(context,this,mario);

        this.star=new StarMan(context, this,mario,2000,6000);
        this.plant=new Plant(context, this,mario);


        mario.state=1;
        mario.type=1;


        setFocusable(true);




    }



    public void shiftRight(){

    }



    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new GameThread( this);

        thread.start();
    }


    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        thread.interrupt();


    }




    public void update(){
        //mario.collide;
        mario.moveright(mariox,marioy);


    }
    public Boolean collidedown1(){


        for(int i=0;i<4;i++) {
            int mariochanged=mario.rectangle.bottom+200;
            //  if(mario.rectangle.intersect(levels.obstacles1.get(i).rectangle)){//&& mario.rectangle.bottom==levels.obstacles1.get(i).rectangle.top){
            //mario.rectangle.bottom = levels.obstacles1.get(i).rectangle.top;
            for (int j = levels.obstacles1.get(i).rectangle.left; j < levels.obstacles1.get(i).rectangle.right; j++) {


                if (mario.rectangle.contains(j, levels.obstacles1.get(i).rectangle.top + mario.mario.getHeight() / 2)) {
                    mario.marioheight = levels.obstacles1.get(i).rectangle.top - mario.mario.getHeight();
                    flag = 1;
                    System.out.println("IM HEREEEEE");


                    return false;


                } else {
                    flag=0;
                    return true;
                }
            }

                System.out.println("mario height"+mariochanged);
                System.out.println("block height"+ levels.obstacles1.get(i).rectangle.top);
                System.out.println("block bottom"+levels.obstacles1.get(i).rectangle.bottom);



             //   if(!levels.obstacles1.get(i).rectangle.contains(mario.rectangle)){
               //     flag=0;
                //}




            }

        return true;
    }


    public Boolean collidedown(){
        Boolean check=true;


        for(int i=0;i<levels.obstacles1.size();i++) {
            if (mario.rectangle.bottom >= levels.obstacles1.get(i).rectangle.top
                   // && mario.MOVE > levels.obstacles1.get(i).rectangle.left - 30
                    && mario.rectangle.top<levels.obstacles1.get(i).rectangle.top&&
                    mario.MOVE < levels.obstacles1.get(i).rectangle.right + 30 && !(levels.obstacles1.get(i) instanceof Coins) &&
                    Rect.intersects(mario.rectangle, levels.obstacles1.get(i).rectangle) ) {
                    mario.marioheight = levels.obstacles1.get(i).rectangle.top - mario.rectangle.height() + 30;
                    // flag = 1;
                    check = false;




            }


            // }

        }
        goomba.CollideMario();


        return check;


    }

    public Obstacles currentobject(){
        Obstacles currentobject;
        int compare;
        int comparey;
        int compare2;
        int compare2y;
        compare=abs(mario.rectangle.centerX()-levels.obstacles1.get(0).rectangle.centerX());
        comparey=abs(mario.rectangle.centerY()-levels.obstacles1.get(0).rectangle.centerY());
        currentobject=levels.obstacles1.get(0);
        for(int i=1;i<levels.obstacles1.size();i++){
            compare2=abs(mario.rectangle.centerX()-levels.obstacles1.get(i).rectangle.centerX());
            compare2y=abs(mario.rectangle.centerY()-levels.obstacles1.get(i).rectangle.centerY());
            if(compare2<compare &&compare2y<comparey){
                compare=compare2;
                comparey=compare2y;
                currentobject=levels.obstacles1.get(i);
            }



        }

        return currentobject;

    }


    public Boolean collideleft(){
        Boolean check=true;
        Obstacles currentobject;
        currentobject=currentobject();
        for(int i=0;i<levels.obstacles1.size();i++) {

            if (mario.rectangle.left <= levels.obstacles1.get(i).rectangle.right
                    && mario.rectangle.bottom >= levels.obstacles1.get(i).rectangle.top
                    && !(mario.rectangle.top >= levels.obstacles1.get(i).rectangle.bottom)
                    && Rect.intersects(mario.rectangle,levels.obstacles1.get(i).rectangle)
                    && mario.rectangle.right>=levels.obstacles1.get(i).rectangle.right
                    && (mario.marioheight==800|| mario.marioheight==670)) {
               mario.MOVE = levels.obstacles1.get(i).rectangle.right+ mario.mario.getWidth();
                if(!(levels.obstacles1.get(i) instanceof Coins)) {
                    System.out.println("mario" + mario.rectangle.centerY());
                    System.out.println("object" + currentobject.rectangle.centerY());
                    //mario.MOVE=levels.obstacles1.get(i).rectangle.right;
                    check = false;
                }
            }
        }

        return check;




    }
    public Boolean collideright(){
        Boolean check=true;
        Obstacles currentobject;
      //  currentobject=currentobject();

    //   if(mario.rectangle.centerY()>=currentobject.rectangle.centerY()){
      //      return true;
       // }

        for(int i=0;i<levels.obstacles1.size();i++) {
            if (mario.rectangle.right >= levels.obstacles1.get(i).rectangle.left //mario is intersecting the object
                    && mario.rectangle.bottom >= levels.obstacles1.get(i).rectangle.top //mario is above things
                    && !(mario.rectangle.top >= levels.obstacles1.get(i).rectangle.bottom) //mario is under things
                    && mario.rectangle.left < levels.obstacles1.get(i).rectangle.right //msrio is on the left of the object
                    && (mario.marioheight == 800 || mario.marioheight==670)//mario is on the ground
                    && !(levels.obstacles1.get(i) instanceof Coins)
                    && !(levels.obstacles1.get(i) instanceof EndLevel)) {
                   mario.MOVE = levels.obstacles1.get(i).rectangle.left - mario.mario.getWidth() - 20;

                   System.out.println("mario" + mario.rectangle.centerY());
                   // System.out.println("object" + currentobject.rectangle.centerY());
                   check = false;

            }



        }


        return check;



    }


    public Boolean collideup(){
        Boolean check=true;

        for(int i=0;i<levels.obstacles1.size();i++) {


                    if ((mario.rectangle.top <= levels.obstacles1.get(i).rectangle.bottom ) && !(levels.obstacles1.get(i) instanceof Pipes ) && !(levels.obstacles1.get(i) instanceof EndLevel) && !(levels.obstacles1.get(i)instanceof Coins)){// && levels.obstacles1.get(i).rectangle.bottom<600) {//mario.rectangle.contains(levels.obstacles1.get(i).rectangle.centerX(),levels.obstacles1.get(i).rectangle.bottom)){//mario.rectangle.intersect(levels.obstacles1.get(i).rectangle) && ) {
                        //if((levels.obstacles1.get(i).rectangle.left>mario.rectangle.left && levels.obstacles1.get(i).rectangle.right<mario.rectangle.right)
                        //||(levels.obstacles1.get(i).rectangle.left<mario.rectangle.left && levels.obstacles1.get(i).rectangle.right>mario.rectangle.right)
                        //||(levels.obstacles1.get(i).rectangle.left>mario.rectangle.left && levels.obstacles1.get(i).rectangle.right<mario.rectangle.right)) {

                            for(int j=levels.obstacles1.get(i).rectangle.left;j<levels.obstacles1.get(i).rectangle.right;j++){
                                if(mario.rectangle.contains(j,levels.obstacles1.get(i).rectangle.bottom)){
                                    check = levels.obstacles1.get(i).collide();
                                    mario.marioheight = levels.obstacles1.get(i).rectangle.bottom ;

                                    check = false;

                                }
                            }

                       // }
        }
                    else{
                        check=true;
                    }

        }

        return check;
    }



    public Boolean collision(){
//
        System.out.println("collision");
        for(int i=0;i<levels.obstacles1.size();i++) {

            //  if (mario.rectangle.intersect(levels.obstacles1.get(i).rectangle)) {
            //   return levels.obstacles1.get(i).collide();}
            if (levels.obstacles1.get(i) instanceof EndLevel && Rect.intersects(mario.rectangle,levels.obstacles1.get(i).rectangle)) {
                 levels.obstacles1.get(i).collide();
            }

            if (levels.obstacles1.get(i) instanceof Coins && Rect.intersects(mario.rectangle,levels.obstacles1.get(i).rectangle)) {
                levels.obstacles1.get(i).collide();
            }

        }
    for(int i=0;i<goomba.goombaslist.size();i++) {

        if (Rect.intersects(goomba.goombaslistrect.get(i),mario.rectangle) && goomba.booleangoomba.get(i)==0 && (mario.state==1|| mario.state==2)) {
            System.out.println("GOOMBAAAA");
            if(mario.invincibility==0){
            goomba.changeMario();}
            else if(mario.invincibility==1){
                goomba.CollideMario();
            }
            goomba.booleangoomba.set(i,1);

            return false;
        }
    }
        for(int i=0;i<plant.plantslist.size();i++) {

            if (Rect.intersects(plant.plantslistrect.get(i),mario.rectangle)&& plant.booleanplant.get(i)==0 ) {
                if(mario.invincibility==0){
                plant.changeMario();}
                else if(mario.invincibility==1){
                    plant.CollideMario();
                }
                plant.booleanplant.set(i,1);
                return false;
            }
        }





    if(mario.rectangle.intersect(star.rectangle)){
      star.changeMario();
      return false;
    }
        if(mario.rectangle.intersect(star2.rectangle)){
            star2.changeMario();
            return false;
        }



      return true;


    }








    @Override
    public void draw(Canvas canvas){
        Paint textpaint=new Paint();
        textpaint.setTextSize(100);
        textpaint.setColor(Color.WHITE);

        Boolean check;

        //points


        ////
        super.draw(canvas);

        this.canvas=canvas;
        WIDTH=canvas.getWidth();
        HEIGHT=canvas.getHeight();


        System.out.println("WIDTH:"+canvas.getWidth());
        System.out.println("HEIGHT"+canvas.getHeight());



        canvas.drawBitmap(wallpaper,1,1,null);

        mario.draw(canvas);
       // blocks.draw1(canvas);

        levels.draw(canvas);

        for(int i=0;i<goomba.goombaslist.size();i++){
        goomba.draw(canvas ,i,goombachange);

        }
        for(int i=0;i<mushrooms.mushroomlist.size();i++){
            mushrooms.draw(canvas,i);

        }
        for(int i=0;i<plant.plantslist.size();i++){
            try {
                plant.draw(canvas,i,changeplant2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            changeplant++;
            if(changeplant>1 && changeplant<25){
                changeplant2=1;
            }
            else if(changeplant>25 && changeplant<50){
                changeplant2=2;
                if(changeplant==49){
                    changeplant=1;
                }
            }

        }


      //  mushroom.draw(canvas,0);
       // mushroom2.draw(canvas,1);
        star.draw(canvas);
        star2.draw(canvas);

        textpaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawText("Points: ", 150, 200, textpaint);
        canvas.drawText(Integer.toString(Points), 500, 200, textpaint);
        canvas.drawText("Level: ",800,200,textpaint);
        canvas.drawText(Integer.toString(level),1100,200,textpaint);
        canvas.drawText("Lives: ",1300,200,textpaint);
        canvas.drawText(Integer.toString(lives),1600,200,textpaint);
        check=collision();


        //end game
        if(GameState==0){
        textpaint.setTextSize(200);
        canvas.drawText("GAME OVER!",canvas.getWidth()/2-550,500,textpaint);}















       // postInvalidate();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        xcoord=event.getX();
        ycoord=event.getY();

        switch(event.getAction()){
            case MotionEvent.ACTION_UP:

                pressed=false;
               // pressed=true;
                System.out.println("MOVE up");
                System.out.println(HEIGHT);


                break;


            case MotionEvent.ACTION_DOWN:
                pressed=true;
                //move mario
                System.out.println("Canvas width:"+ canvas.getWidth());
              //  mariox=mario.MOVE+100;
               // mario.moveright((int)xcoord,(int)ycoord);

                //while(pressed) {
                    if (xcoord > WIDTH / 2){//&& ycoord>HEIGHT/2) {
                        if ((mario.MOVE < WIDTH / 2 ) && collideright()){// && xcoord!=mario.MOVE) {

                            mariox = mario.MOVE + 100;
                        }

                    } else if (xcoord < WIDTH / 2 && collideleft()){// && ycoord>HEIGHT/2) {
                        if (mario.MOVE > 0 ){//&& xcoord!=mario.MOVE) {
                            pressed=false;



                            mariox = mario.MOVE - 100;
                        }
                    }
                if(ycoord<HEIGHT/2 && xcoord>WIDTH/2){

                    if(mario.marioheight>=600 && collideup()){

                        mario.state=3;
                      //  mariox=mario.MOVE+100;
                        mario.velocity=-70;}}

                else if(ycoord<HEIGHT/2 && xcoord<WIDTH/2 ){

                    if(mario.marioheight>=600 && collideup()){
                      //  pressed=false;
                        mario.state=4;

                        mario.velocity=-70;}


                }


                break;


            }

        return true;
    }
}

