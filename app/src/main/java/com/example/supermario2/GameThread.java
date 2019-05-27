package com.example.supermario2;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameThread extends Thread {
    // public static Canvas board;
    private Game game;
    private SurfaceHolder surfaceholder;
    boolean isitok;
    Canvas board;






    public GameThread( Game game) {


        this.game = game;
    }

    @Override
    public void run(){
        surfaceholder=game.getHolder();
        while( !Thread.interrupted() ) {
            //You might want to do game specific processing in a method you call here
            Canvas c = this.surfaceholder.lockCanvas(null);
            try { synchronized(surfaceholder)
            {  //this.game.update();
                System.out.println("HEREEEEE");
                this.game.draw(c);
                this.game.update();
                System.out.println("HEREEE");
                /*if(this.game.endgame()){
                    System.out.println("Interrupt thread");
                    Thread.interrupt();
                }*/
            }
            } catch (Exception e) { }
            finally { if ( c != null )
            { surfaceholder.unlockCanvasAndPost(c); } }
            // Set the frame rate by setting this delay
            try
            { Thread.sleep(100); } catch (InterruptedException e)
            { // Thread was interrupted while sleeping.
                return; } }
    }


}