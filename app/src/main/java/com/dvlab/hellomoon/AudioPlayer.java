package com.dvlab.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {

    private MediaPlayer mediaPlayer;

    public void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    public void pause() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    public void play(Context context) {
        if (mediaPlayer == null) {
            startMediaPlayer(context);
        }

        // restarting
        if (mediaPlayer.isPlaying()) {
            stop();
            startMediaPlayer(context);
        }

        mediaPlayer.start();
    }

    private void startMediaPlayer(Context context) {
        mediaPlayer = MediaPlayer.create(context, R.raw.one_small_step);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });
    }

}
