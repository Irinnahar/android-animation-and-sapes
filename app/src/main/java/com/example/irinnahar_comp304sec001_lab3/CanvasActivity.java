package com.example.irinnahar_comp304sec001_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class CanvasActivity extends MenuActivity {
    private ImageView reusableImageView;
    TextView textViewX;
    TextView textViewY;

    //variable initializaion
    private int startx = 10;
    private int starty = 10;
    private int endx=100;
    private int endy=100;


    private Paint paint;
    private Bitmap bitmap;
    private Canvas canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        //create the paint for our drawings
        paint = new Paint();
        paint.setColor(Color.MAGENTA);
        //paint.setStrokeMiter((float)0.5);
        paint.setStrokeWidth(30);

        //creating a bitmap as content view for the image
        bitmap = Bitmap.createBitmap((int) getWindowManager()
                .getDefaultDisplay().getWidth(), (int) getWindowManager()
                .getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);
        //tell canvas about the content view
        canvas = new Canvas(bitmap);
        //set the background for your drawings
        canvas.drawColor(Color.CYAN); //background
        //setup the image

        //setup the image view
        reusableImageView = (ImageView)findViewById(R.id.ImageViewForDrawing);
        //tell image view for the bitmap format/content
        reusableImageView.setImageBitmap(bitmap);
        reusableImageView.setVisibility(View.VISIBLE);
        textViewX  = (TextView) findViewById(R.id.textView1);
        textViewY  = (TextView) findViewById(R.id.textView2);

        final ImageButton downButton = (ImageButton) findViewById(R.id.arrow_down);
        downButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                drawDown();
            }
            });

        //  Draw right button
        final ImageButton rightButton = (ImageButton) findViewById(R.id.arrow_right);
        rightButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                drawRight();
            }
        });

        //  Draw up button
        final ImageButton upButton = (ImageButton) findViewById(R.id.arrow_up);
        upButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                drawUp();
            }
        });

        //  Draw right button
        final ImageButton leftButton = (ImageButton) findViewById(R.id.arrow_left);
        leftButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                drawLeft();
            }
        });
        //reusableImageView.setImageResource(R.drawable.green_rect);
    }// end of onCreate

    public void clearCanvas(View v)
    {
        canvas.drawColor(Color.CYAN);
        startx = 10;
        starty = 10;
        endx = 100;
        endy = 100;
    }
    public void startDrawing(View v)
    {
        canvas.drawPoint(15,15,paint);
    }
    public void drawLine(Canvas canvas)
    {
        textViewY.setText("Y : " + String.valueOf(endy));
        textViewX.setText("X : " + String.valueOf(endx));

        //canvas.drawLine(100,100,300,300,paint);
        canvas.drawLine(startx, starty, endx, endy, paint);
        startx = endx;
        starty = endy;
    }

    public void drawRight() {
        endx = endx+10;
        drawLine( canvas);
    }

    public void drawDown() {
        endy = endy+10;
        drawLine( canvas);
    }
    public void drawUp() {
        endy = endy-10;
        drawLine( canvas);
    }
    public void drawLeft() {
        endx = endx-10;
        drawLine( canvas);
    }
}