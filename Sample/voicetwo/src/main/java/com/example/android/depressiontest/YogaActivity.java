package com.example.android.depressiontest;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;


public class YogaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga);

        VideoView videoView = (VideoView) findViewById(R.id.videoYoga);  //casting to VideoView is not Strictly required above API level 26
        //Set MediaController  to enable play, pause, forward, etc options.
        final MediaController mediaController= new MediaController(this){

            @Override
            public void show() {
                super.show(0);//Default no auto hide timeout
            }
            @Override
            public void hide() {
                //DOES NOTHING
            }

            //Handle BACK button
            @Override
            public boolean dispatchKeyEvent(KeyEvent event) {
                if(event.getKeyCode() == KeyEvent.KEYCODE_BACK){
                    super.hide();//Hide mediaController
                    finish();//Close this activity
                    return true;//If press Back button, finish here
                }
                //If not Back button, other button (volume) work as usual.
                return super.dispatchKeyEvent(event);
            }

            void setVisible(boolean visible){//USE THIS FUNCTION INSTEAD
                if(visible)
                    super.show();
                else
                    super.hide();
            }
        };

        mediaController.setAnchorView(videoView);
        mediaController.requestFocus();

        //Location of Media File
        Uri uri = Uri.parse("android.resource://com.example.android.depressiontest/" + R.raw.yogavideo);

        //Starting VideoView By Setting MediaController and URI
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer mp) {
                mediaController.show(0);
            }
        });


    }
}