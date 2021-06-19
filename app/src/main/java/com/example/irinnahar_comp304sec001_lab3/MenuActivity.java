package com.example.irinnahar_comp304sec001_lab3;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        menu.findItem(R.id.canvas_menu_item).setIntent(new Intent(this, CanvasActivity.class));
        menu.findItem(R.id.frame_menu_item).setIntent(new Intent(this, FrameActivity.class));
        menu.findItem(R.id.tween_menu_item).setIntent(new Intent(this, TweenActivity.class));
        super.onCreateOptionsMenu(menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        startActivity(item.getIntent());
        super.onOptionsItemSelected(item);
        return true;
    }
}
