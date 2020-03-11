package io.github.example.plumpybird;

import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;

public class GameThread extends Thread {

    //Object Reference for surfaceHolder
    SurfaceHolder surfaceHolder;
    //To detect if the thread is running or not
    boolean isRunning;
    //Loop start Time and duration
    long startTime, loopTime;
    //Delay between screen refreshes in milliseconds
    long Delay = 33;


    public GameThread(SurfaceHolder surfaceHolder){

        this.surfaceHolder = surfaceHolder;
        isRunning = true;

    }

    @Override
    public void run() {
        //loop until its false
        while (isRunning){
            startTime = SystemClock.uptimeMillis();
            //canvas lock
            Canvas canvas = surfaceHolder.lockCanvas(null);
            if(canvas != null){
                synchronized (surfaceHolder){
                    AppConstants.getGameEngine().updateAndDrawBackgroundImage(canvas);
                    AppConstants.getGameEngine().updateAndDrawBird(canvas);
                    AppConstants.getGameEngine().updateAndDrawTubes(canvas);

                    //unlock canvas
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
            //loop time
            loopTime = SystemClock.uptimeMillis() - startTime;
            //making sure if we update the right amount per second
              if(loopTime<Delay){
                  try {
                      Thread.sleep(Delay-loopTime);
                  }
                  catch (InterruptedException e){
                      Log.e("Interrupted","Interrupted during sleep");
                  }
              }
        }
    }

    //return whether the thread is running
    public boolean isRunning(){
        return isRunning;
    }
    //sets the thread state, false = stopped, true = running
    public void setIsRunning(boolean state){
        isRunning = state;
    }
}
