package io.github.example.plumpybird;

public class BirdActivity {
    private int birdX, birdY, currentFrame, velocity;
    public static int maxFrame;


    public BirdActivity(){

        birdX = AppConstants.SCREEN_WIDTH/2 - AppConstants.getBitmapBank().getBirdWidth()/2;
        birdY = AppConstants.SCREEN_HEIGHT/2 - AppConstants.getBitmapBank().getBirdHeight()/2;
        currentFrame =0;
        velocity = 0;
        maxFrame = 3;

    }

    //getter and setter methods for current frame
    public int getCurrentFrame(){
        return currentFrame;
    }
    public void setCurrentFrame(int currentFrame){
        this.currentFrame = currentFrame;
    }
    //getter and setter methods for X-coordinate and Y- coordinate
    public int getX(){
        return birdX;
    }
    public int getY(){
        return birdY;
    }

    public void setX(int birdX){
        this.birdX = birdX;
    }
    public void setY(int birdY){
        this.birdY = birdY;
    }
    //getter and setter for velocity
    public int getVelocity(){
         return velocity;
    }

    public void setVelocity(int velocity){
        this.velocity  = velocity;
    }



}
