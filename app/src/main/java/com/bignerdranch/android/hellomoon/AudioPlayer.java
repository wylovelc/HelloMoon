package com.bignerdranch.android.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {

    private MediaPlayer mPlayer;
    private boolean isPause = false;

    public void stop(){
        if(mPlayer !=null){
            mPlayer.release();
            mPlayer=null;
        }
    }

    public void play(Context c){
        stop();

        mPlayer = MediaPlayer.create(c,R.raw.one_small_step);

        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });
        mPlayer.start();
    }

    public void pause(Context c){
        if(mPlayer.isPlaying() &&! isPause){
            mPlayer.pause();
            isPause = true;
        }else {
            mPlayer.start();
            isPause = false;
        }
    }
}
