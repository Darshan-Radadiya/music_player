package com.example.music_player;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private Button mPlay, mPause;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPause = findViewById(R.id.pause);
        mPlay = findViewById(R.id.play);
        mMediaPlayer = MediaPlayer.create(this, R.raw.bum_tum);

        mPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mMediaPlayer.start();
            }
        });
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(MainActivity.this, "I am done",Toast.LENGTH_LONG).show();
                releaseMediaPlyer();
            }
        });
        mPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMediaPlayer.pause();
            }
        });

    }

    private void releaseMediaPlyer()
    {
    if (mMediaPlayer!=null)
        {
          mMediaPlayer.release();
           mMediaPlayer=null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlyer();
    }
}
