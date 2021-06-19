package com.example.irinnahar_comp304sec001_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawmenu, menu);

        menu.findItem(R.id.canvas_menu_item).setIntent(new Intent(this, CanvasPaintActivity.class));
        menu.findItem(R.id.framed_menu_item).setIntent(new Intent(this, FramedAnimationActivity.class));
        menu.findItem(R.id.tween_menu_item).setIntent(new Intent(this, TweenAnimationActivity.class));
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