package io.github.example.plumpybird;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {

        Bitmap background;
        Bitmap[] bird;
        Bitmap tubeTop, tubeBottom;
        Bitmap tube2Top, tube2Bottom;


    public BitmapBank(Resources res) {

        background = BitmapFactory.decodeResource(res, R.drawable.bg2);
        background = scaleImage(background);
        bird = new Bitmap[4];
        bird[0] = BitmapFactory.decodeResource(res, R.drawable.frame_1);
        bird[1] = BitmapFactory.decodeResource(res, R.drawable.frame_2);
        bird[2] = BitmapFactory.decodeResource(res, R.drawable.frame_3);
        bird[3] = BitmapFactory.decodeResource(res, R.drawable.frame_4);
        tubeTop = BitmapFactory.decodeResource(res, R.drawable.tube_top);
        tubeBottom = BitmapFactory.decodeResource(res, R.drawable.tube_bottom);
        tube2Top = BitmapFactory.decodeResource(res, R.drawable.tube2_top);
        tube2Bottom = BitmapFactory.decodeResource(res, R.drawable.tube2_bottom);

    }

    //return tube_top bitmap
    public Bitmap getTubeTop(){
        return tubeTop;
    }
    //return tube bottom
    public Bitmap getTubeBottom(){
        return tubeBottom;
    }
    public Bitmap getTube2Top(){
        return tube2Top;
    }
    //return tube bottom
    public Bitmap getTube2Bottom(){
        return tube2Bottom;
    }

//return tube-width and height
    public int getTubeWidth() {
    return tubeTop.getWidth();
    }
    public int getTubeHeight() {
    return tubeTop.getHeight();
    }


    public Bitmap getBird(int frame){
        return bird[frame];
    }
    public int getBirdWidth(){
        return bird[0].getWidth();
    }
    public int getBirdHeight(){
        return bird[0].getHeight();
    }

    //Return Background
    public Bitmap getBackground(){
        return background;
    }


    //Return Background width
    public int getBackgroundWidth(){
         return background.getWidth();
    }

    //Return Background Height
    public int getBackgroundHeight(){
        return background.getHeight();
    }

    public Bitmap scaleImage(Bitmap bitmap){
        float widthHeightRatio = getBackgroundWidth()/getBackgroundHeight();
        //Multiply widthHeightRatio with the screenHeight to get scaled width of the Bitmap
        //call createScaledBitmap() to create a new bitmap, scaled from an existing bitmap.

        int backgroundScaledWidth = (int) widthHeightRatio * AppConstants.SCREEN_HEIGHT;
        return Bitmap.createScaledBitmap(bitmap, backgroundScaledWidth, AppConstants.SCREEN_HEIGHT,false);

    }
}
