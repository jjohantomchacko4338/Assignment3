package io.github.example.plumpybird;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    GameThread gameThread;

    public GameView(Context context) {
        super(context);
        initView();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        if(!gameThread.isRunning()){
            gameThread = new GameThread(holder);
            gameThread.start();
        }else {
            gameThread.start();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        if(gameThread.isRunning()){
            gameThread.setIsRunning(false);
            boolean reTry = true;

            while (reTry){
                try {
                    gameThread.join();
                    reTry = false;
                }
                catch (InterruptedException ex){

                }
            }
        }
    }
    public void initView(){
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        setFocusable(true);

        gameThread = new GameThread(holder);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        //tap detection
        if(action == MotionEvent.ACTION_DOWN){
            if(AppConstants.getGameEngine().gameState == 0){
                AppConstants.getGameEngine().gameState = 1;
                AppConstants.getSoundBank().playSwoosh();
            }
            else {
                AppConstants.getSoundBank().playWing();
            }

            AppConstants.getGameEngine().birdActivity.setVelocity(AppConstants.jumpVelocity);
        }
        return true;
    }
}
