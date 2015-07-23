package com.dvlab.hellomoon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HelloMoonFragment extends Fragment {

    private VideoPlayer videoPlayer = new VideoPlayer();
    private SurfaceView surfaceView;
    private Button videoPlayButton;
    private Button videoPauseButton;
    private Button videoStopButton;

    private AudioPlayer audioPlayer = new AudioPlayer();
    private Button audioPlayButton;
    private Button audioPauseButton;
    private Button audioStopButton;

    public HelloMoonFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hello_moon, container, false);

        surfaceView = (SurfaceView) view.findViewById(R.id.hellomoon_surface);
        final SurfaceHolder surfaceHolder = surfaceView.getHolder();

        videoPlayButton = (Button) view.findViewById(R.id.hellomoon_video_play_button);
        videoPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoPlayer.play(getActivity(), surfaceHolder);
            }
        });

        videoPauseButton = (Button) view.findViewById(R.id.hellomoon_video_pause_button);
        videoPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoPlayer.pause();
            }
        });

        videoStopButton = (Button) view.findViewById(R.id.hellomoon_video_stop_button);
        videoStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoPlayer.stop();
            }
        });

        // ----------------------------------------------------------------

        audioPlayButton = (Button) view.findViewById(R.id.hellomoon_play_button);
        audioPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioPlayer.play(getActivity());
            }
        });

        audioPauseButton = (Button) view.findViewById(R.id.hellomoon_pause_button);
        audioPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioPlayer.pause();
            }
        });

        audioStopButton = (Button) view.findViewById(R.id.hellomoon_stop_button);
        audioStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioPlayer.stop();
            }
        });

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        audioPlayer.stop();
        videoPlayer.stop();
    }
}
