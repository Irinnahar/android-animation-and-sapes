package com.example.irinnahar_comp304sec001_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FrameActivity extends MenuActivity {
    AnimationDrawable mFrameAnimation = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
//        Handle start button
        final Button onButton = (Button) findViewById(R.id.startBtn);
        onButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startAnimation();
            }
        });

        // Handle Stop Button
        final Button offButton = (Button) findViewById(R.id.stopBtn);
        offButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stopAnimation();
            }
        });
    }

    private void startAnimation()
    {

        ImageView img = (ImageView)findViewById(R.id.frameImg);
        ImageView defaultImg = (ImageView)findViewById(R.id.defaultImg);
        defaultImg.setVisibility(View.GONE);

        BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.img1);
        BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.img2);
        BitmapDrawable frame3 = (BitmapDrawable)getResources().getDrawable(R.drawable.img3);
        BitmapDrawable frame4 = (BitmapDrawable)getResources().getDrawable(R.drawable.img4);
        BitmapDrawable frame5 = (BitmapDrawable)getResources().getDrawable(R.drawable.img5);
        BitmapDrawable frame6 = (BitmapDrawable)getResources().getDrawable(R.drawable.img6);
        BitmapDrawable frame7 = (BitmapDrawable)getResources().getDrawable(R.drawable.img7);
        BitmapDrawable frame8 = (BitmapDrawable)getResources().getDrawable(R.drawable.img8);

        // Get the background, which has been compiled to an AnimationDrawable object.
        int reasonableDuration = 300;
        mFrameAnimation = new AnimationDrawable();
        mFrameAnimation.setOneShot(false);	// loop continuously
        mFrameAnimation.addFrame(frame1, reasonableDuration);
        mFrameAnimation.addFrame(frame2, reasonableDuration);
        mFrameAnimation.addFrame(frame3, reasonableDuration);
        mFrameAnimation.addFrame(frame4, reasonableDuration);
        mFrameAnimation.addFrame(frame5, reasonableDuration);
        mFrameAnimation.addFrame(frame6, reasonableDuration);
        mFrameAnimation.addFrame(frame7, reasonableDuration);
        mFrameAnimation.addFrame(frame8, reasonableDuration);

        img.setBackground(mFrameAnimation);

        mFrameAnimation.setVisible(true,true);
        mFrameAnimation.start();
    }
    private void stopAnimation()
    {
        mFrameAnimation.stop();
        mFrameAnimation.setVisible(false,false);

    }



}