package io.github.example.plumpybird;

public class BackgroundImage {

    private int BackgroundImageX,BackgroundImageY,BackgroundImageVelocity;
    public BackgroundImage(){
        BackgroundImageX =0;
        BackgroundImageY =0;
        BackgroundImageVelocity =3;

    }

    //Getter method for receiving the X-coordinate
    public int getX(){
        return BackgroundImageX;
    }
    //Getter method for receiving the Y-coordinate
    public int getY(){
        return BackgroundImageY;
    }
    //Setter method for receiving the X-coordinate
    public void setX(int backgroundImageX){
       this.BackgroundImageX = backgroundImageX;
    }

    //Setter method for receiving the Y-coordinate
    public void setY(int backgroundImageY){
       this.BackgroundImageY = backgroundImageY;
    }

    //Getter method for receiving the Velocity
    public int getVelocity(){
        return BackgroundImageVelocity;
    }

}
