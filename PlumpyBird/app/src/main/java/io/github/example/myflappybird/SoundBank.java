package io.github.example.plumpybird;

import android.content.Context;
import android.media.MediaPlayer;

public class SoundBank {

    Context context;
    MediaPlayer swoosh, point,hit,wing;

    public SoundBank(Context context){
        this.context = context;
        swoosh = MediaPlayer.create(context,R.raw.sfx_swooshing);
        point = MediaPlayer.create(context,R.raw.sfx_point);
        hit = MediaPlayer.create(context,R.raw.sfx_hit);
        wing = MediaPlayer.create(context,R.raw.sfx_wing);

    }

    public void playSwoosh(){
        if (swoosh!=null)
        {
            swoosh.start();
        }
    }
    public void playPoint(){
        if (point!=null)
        {
            point.start();
        }
    }
    public void playhit(){
        if (hit!=null)
        {
            hit.start();
        }
    }
    public void playWing(){
        if (wing!=null)
        {
            wing.start();
        }
    }
}
