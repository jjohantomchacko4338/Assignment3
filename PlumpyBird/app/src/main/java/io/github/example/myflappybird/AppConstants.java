package io.github.example.plumpybird;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class AppConstants {


    static BitmapBank bitmapBank;
    static GameEngine gameEngine;   //Game Engine Reference object
    static int SCREEN_WIDTH, SCREEN_HEIGHT;
    static int gravity;
    static  int jumpVelocity;
    public static int gapBetweenTopAndBottomTubes;
    static int numberOfTubes;
    static int tubeVelocity;
    static int minTubeOffsetY;
    static int maxTubeOffsetY;
    static int distanceBetweenTubes;
    static Context gameActivityContext;
    static SoundBank soundBank;

    public static void initialization(Context context){

        setScreenSize(context);
        bitmapBank = new BitmapBank(context.getResources());
        setGameConstants();
        gameEngine = new GameEngine();
        soundBank = new SoundBank(context);


    }

    public static SoundBank getSoundBank(){
        return soundBank;
    }

    public static void setGameConstants(){
        AppConstants.gravity = 3;
        AppConstants.jumpVelocity = -40;
        gapBetweenTopAndBottomTubes = 600;
        AppConstants.numberOfTubes = 2;
        AppConstants.tubeVelocity = 12;
        AppConstants.minTubeOffsetY = (int)(AppConstants.gapBetweenTopAndBottomTubes / 2.0);
        AppConstants.maxTubeOffsetY = AppConstants.SCREEN_HEIGHT - AppConstants.minTubeOffsetY - AppConstants.gapBetweenTopAndBottomTubes;
        AppConstants.distanceBetweenTubes = AppConstants.SCREEN_WIDTH * 3/4;
    }

    //Return BitmapBank instance

    public static BitmapBank getBitmapBank(){
        return bitmapBank;
    }

    //Return game engine instance
    public static GameEngine getGameEngine(){
        return gameEngine;
    }

    public static void setScreenSize(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);

        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        AppConstants.SCREEN_WIDTH = width;
        AppConstants.SCREEN_HEIGHT = height;

    }
}
