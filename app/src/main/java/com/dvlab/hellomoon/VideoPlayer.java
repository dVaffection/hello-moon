package com.dvlab.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.SurfaceHolder;

public class VideoPlayer {

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

    public void play(Context context, SurfaceHolder surfaceHolder) {
        if (mediaPlayer == null) {
            startMediaPlayer(context, surfaceHolder);
        }

        // restarting
        if (mediaPlayer.isPlaying()) {
            stop();
            startMediaPlayer(context, surfaceHolder);
        }

        mediaPlayer.start();
    }

    private void startMediaPlayer(Context context, SurfaceHolder surfaceHolder) {
//        Uri uri = Uri.parse("android.resource://com.dvlab.hellomoon/raw/apollo_17_stroll");
//        mediaPlayer = MediaPlayer.create(context, uri, surfaceHolder);

        mediaPlayer = MediaPlayer.create(context, R.raw.apollo_17);
        mediaPlayer.setDisplay(surfaceHolder);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });
    }

}
