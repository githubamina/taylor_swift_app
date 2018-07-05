package com.example.android.theswiftappv2;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.media.AudioManager.AUDIOFOCUS_GAIN;
import static android.media.AudioManager.AUDIOFOCUS_LOSS;

/**
 * Created by Mia on 27/11/2017.
 */

public class reputation extends AppCompatActivity {


    //CREATE AN INSTANCE OF MEDIAPLAYER
    private MediaPlayer songPlayer;


    //CREATE AUDIOMANAGER OBJECT INSTANCE SO THAT WE CAN REQUEST AUDIO FOCUS
    private AudioManager mAudioManager;


    //HERE WE CREATE AN INSTANCE OF ONAUDIOFOCUSCHANGE LISTENER TO TELL US IF ANOTHER APP/THE PHONE NEEDS AUDIO FOCUS
    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {


                //AND HERE WE TELL OUR APP WHAT TO DO WITH OUR AUDIO WHEN THE AUDIO FOCUS OF THE DEVICE CHANGES
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        songPlayer.pause();
                        songPlayer.seekTo(0);
                    } else if (focusChange == AUDIOFOCUS_GAIN) {
                        // Pause playback
                        songPlayer.start();
                    } else if (focusChange == AUDIOFOCUS_LOSS) {
                        // Lower the volume, keep playing
                        releaseMediaPlayer();
                    }
                }
            };



    //!!COMPLETION LISTENRE CREATED this is the on completion listener set as a global variable so that we only need to create this
    //one instance of it, rather than have it listed below where we call it and have a new instance
    //created everytime the audio stops.
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reputation);


        //INITIALIZE AUDIOMANAGER OBJECT AND PASS IN AUDIO_SERVICE IN ORDER TO USE AUDIO SYSTEM SERVICES TO REQUEST FOCUS
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);


        Button play = (Button) findViewById(R.id.play);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                //RELEASE MEDIA RESOURCES BEFORE PLAYING A NEW SOUND
                releaseMediaPlayer();

                // REQUEST AUDIO PLAYBACK FOCUS USING AUDIOMANAGER CLASS METHOD, AND THEN STORE THE RESULT(WHETHER OR NOT FOCUS IS GRANTED) IN A VARIABLE SO THAT
                // WE CAN VERIFY THAT IT HAS BEEN GRANTED BEFORE GOING AHEAD AND TRYING TO PLAY AUDIO
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        //SPECIFY THE STREAM TYPE OF OUR AUDIO (IE. MUSIC, NOTIFICATIONS, ALARM, ETC)
                        AudioManager.STREAM_MUSIC,
                        // REQUEST THE TYPE OF FOCUS WE WANT
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);


                //USING THE VARIABLE CREATED ABOVE, CHECK TO SEE IF AUDIOFOCUS HAS BEEN GRANTED AND IF SO,
                //BEGIN AUDIO PLAYBACK
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Start playback


                    songPlayer = MediaPlayer.create(reputation.this, R.raw.dwoht);
                    songPlayer.start();


                    //ON COMPLETION LISTENR (THE GLOBAL VARIABLE CREATED ABOVE) IS CALLED HERE!!!
                    songPlayer.setOnCompletionListener(mCompletionListener);

                    Button pause = (Button) findViewById(R.id.pause);

                    pause.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            songPlayer.pause();
                        }
                    });
                }
            }
        });


        TextView shoplink = (TextView) findViewById(R.id.shopLink);

        shoplink.setOnClickListener(new View.OnClickListener() {
            //The code in this method will be executed when the welcome view is clicked on.
            @Override
            public void onClick(View view){
                Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://store.taylorswift.com/"));
                startActivity(browser);
            }});

        TextView tourlink = (TextView) findViewById(R.id.tourLink);

        tourlink.setOnClickListener(new View.OnClickListener() {
            //The code in this method will be executed when the welcome view is clicked on.
            @Override
            public void onClick(View view){
                Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://taylorswift.ontouraccess.com/"));
                startActivity(browser);
            }});


    }


        //HERE IS WHERE WE STOP THE AUDIO AND RELEASE RESOURCES IF thE USER SWITCHES TO ANOTHER ACTIVITY OR LEAVES THE APP
        @Override
        protected void onStop () {
            super.onStop();
            releaseMediaPlayer();

        }



        //HELPER METHOD CREATED TO RELEASE MEDIA PLAYER RESOURCES
        private void releaseMediaPlayer () {
            // If the media player is not null, then it may be currently playing a sound.
            if (songPlayer != null) {
                // Regardless of the current state of the media player, release its resources
                // because we no longer need it.
                songPlayer.release();

                // Set the media player back to null. For our code, we've decided that
                // setting the media player to null is an easy way to tell that the media player
                // is not configured to play an audio file at the moment.
                songPlayer = null;

                // ABANDON AUDIO FOCUS WHEN PLAYBACK IS COMPLETE SO OTHER APPS CAN SUCCESSFULLY REQUEST FOCUS
                mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
            }
        }


}
