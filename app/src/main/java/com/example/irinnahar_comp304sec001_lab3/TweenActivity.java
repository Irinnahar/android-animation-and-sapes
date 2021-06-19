package com.example.irinnahar_comp304sec001_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class TweenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);

        //        Handle start button
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.tween);
        ImageView img = (ImageView) findViewById(R.id.earthImage);
        final Button onButton = (Button) findViewById(R.id.TweenStratBtn);
        onButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startAnimation(animation, img);
            }
        });

        // Handle Stop Button
        final Button offButton = (Button) findViewById(R.id.TweenStopBtn);
        offButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                stopAnimation(animation, img);
            }
        });
    }

    private void startAnimation(Animation animation, ImageView img) {
        img.startAnimation(animation);
    }

    private void stopAnimation(Animation animation, View img) {
        img.clearAnimation();
    }
}