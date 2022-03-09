package de.thu.cradlequizgame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int imageId = getResources().getIdentifier("@drawable/opening_image", null, this.getPackageName());
        ImageView image = findViewById(R.id.openingImage);
        image.setImageResource(imageId);
        TextView textView = findViewById(R.id.welcometextview);
        textView.setText("CRADLE QUIZ GAME");
    }

    public void introductionButton(View view) {
        Intent intent = new Intent(MainActivity.this, InfoAboutUser.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.rules, menu);
        getMenuInflater().inflate(R.menu.info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch(item.getItemId()){
            case R.id.rules:
                intent = new Intent(MainActivity.this,
                        Rules.class);
                startActivity(intent);
                return true;
            case R.id.info:
                intent = new Intent(MainActivity.this, Info.class);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}