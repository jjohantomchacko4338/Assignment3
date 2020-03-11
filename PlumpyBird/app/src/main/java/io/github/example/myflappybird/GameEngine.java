package io.github.example.plumpybird;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class GameEngine {

    BackgroundImage backgroundImage;
    BirdActivity birdActivity;
    static int gameState;
    ArrayList<Tube> tubes;
    Random random;
    int score;
    int scoringTube;
    Paint scorePaint;

    public GameEngine() {
        backgroundImage = new BackgroundImage();
        birdActivity = new BirdActivity();
        gameState = 0;    // 0 = not Started, 1 = Game Started, 2 = Game Over
        tubes = new ArrayList<>();
        random = new Random();
        for (int i = 0; i < AppConstants.numberOfTubes; i++) {
            int tubeX = AppConstants.SCREEN_WIDTH + i * AppConstants.distanceBetweenTubes;
            //Get TopTubeOffsetY
            int topTubeOffsetY = AppConstants.minTubeOffsetY + random.nextInt(AppConstants.maxTubeOffsetY - AppConstants.minTubeOffsetY + 1);
            //now create Yube objects
            Tube tube = new Tube(tubeX, topTubeOffsetY);
            tubes.add(tube);

        }
        score = 0;
        scoringTube = 0;
        scorePaint = new Paint();
        scorePaint.setColor(Color.RED);
        scorePaint.setTextSize(100);
        scorePaint.setTextAlign(Paint.Align.LEFT);
    }

    public void updateAndDrawTubes(Canvas canvas) {
        if (gameState == 1) {
            if ((tubes.get(scoringTube).getTubeX() < birdActivity.getX() + AppConstants.getBitmapBank().getBirdWidth())
                    && (tubes.get(scoringTube).getTopTubeOffsetY() > birdActivity.getY()
                    || tubes.get(scoringTube).getBottomTubeY() < (birdActivity.getY() +
                    AppConstants.getBitmapBank().getBirdHeight()))
            ) {
                //go to Game Over Screen
                gameState = 2;

                Log.d("Game", "Over");
                       AppConstants.getSoundBank().playhit();
                Context context = AppConstants.gameActivityContext;
                Intent intent = new Intent(context,GameOver.class);
                intent.putExtra("score",score);
                context.startActivity(intent);
                ((Activity)context).finish();
            } else if (tubes.get(scoringTube).getTubeX() < birdActivity.getX() - AppConstants.getBitmapBank().getTubeWidth()) {
                score++;
                scoringTube++;
                if (scoringTube > AppConstants.numberOfTubes - 1) {
                    scoringTube = 0;
                }
                  AppConstants.getSoundBank().playPoint();
            }
            for (int i = 0; i < AppConstants.numberOfTubes; i++) {
                if (tubes.get(i).getTubeX() < -AppConstants.getBitmapBank().getTubeWidth()) {
                    tubes.get(i).setTubeX(tubes.get(i).getTubeX() + AppConstants.numberOfTubes * AppConstants.distanceBetweenTubes);
                    int topTubeOffsetY = AppConstants.minTubeOffsetY + random.nextInt(AppConstants.maxTubeOffsetY - AppConstants.minTubeOffsetY + 1);
                    tubes.get(i).setTopTubeOffsetY(topTubeOffsetY);
                    tubes.get(i).setTubeColor();
                }
                tubes.get(i).setTubeX(tubes.get(i).getTubeX() - AppConstants.tubeVelocity);
                if (tubes.get(i).getTubeColor() == 0) {

                    canvas.drawBitmap(AppConstants.getBitmapBank().getTubeTop(), tubes.get(i).getTubeX(), tubes.get(i).getTopTubeY(), null);
                    canvas.drawBitmap(AppConstants.getBitmapBank().getTubeBottom(), tubes.get(i).getTubeX(), tubes.get(i).getBottomTubeY(), null);
                } else {
                    canvas.drawBitmap(AppConstants.getBitmapBank().getTubeTop(), tubes.get(i).getTubeX(), tubes.get(i).getTopTubeY(), null);
                    canvas.drawBitmap(AppConstants.getBitmapBank().getTubeBottom(), tubes.get(i).getTubeX(), tubes.get(i).getBottomTubeY(), null);
                }


            }
            canvas.drawText("Points:" + score, 0, 110, scorePaint);
        }
    }

    public void updateAndDrawBackgroundImage(Canvas canvas) {
        backgroundImage.setX(backgroundImage.getX() - backgroundImage.getVelocity());
        if (backgroundImage.getX() < -AppConstants.getBitmapBank().getBackgroundWidth()) {
            backgroundImage.setX(0);
        }
        canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getX(), backgroundImage.getY(), null);

        if (backgroundImage.getX() < -(AppConstants.getBitmapBank().getBackgroundWidth() - AppConstants.SCREEN_WIDTH)) {
            canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getX() +
                    AppConstants.getBitmapBank().getBackgroundWidth(), backgroundImage.getY(), null);
        }
    }

    public void updateAndDrawBird(Canvas canvas) {


        if (gameState == 1) {


            if (birdActivity.getY() < (AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapBank().getBirdHeight()) || birdActivity.getVelocity() < 0) {
                birdActivity.setVelocity(birdActivity.getVelocity() + AppConstants.gravity);
                birdActivity.setY(birdActivity.getY() + birdActivity.getVelocity());
            }
        }

        int currentFrame = birdActivity.getCurrentFrame();
        canvas.drawBitmap(AppConstants.getBitmapBank().getBird(currentFrame), birdActivity.getX(), birdActivity.getY(), null);
        currentFrame++;
        //if frame exceeds max frame, intialise it to 0.

        if (currentFrame > birdActivity.maxFrame) {
            currentFrame = 0;

        }
        birdActivity.setCurrentFrame(currentFrame);
    }

}
