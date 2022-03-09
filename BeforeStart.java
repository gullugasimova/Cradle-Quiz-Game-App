package de.thu.cradlequizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
//Activity to welcome the user after they introduce themselves
public class BeforeStart extends AppCompatActivity {
    Intent iquizActivity;
    String gender;
    int chosenImageId;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_start);
        TextView textView = findViewById(R.id.beforestart);
        //to get the data from InfoAboutUser activity
        SharedPreferences sharedPreferences = this.getSharedPreferences("SharedData", Context.MODE_PRIVATE);
        username = sharedPreferences.getString("username", "");
        //to display the image of the character that the user has chosen
        chosenImageId = sharedPreferences.getInt("chosen_image", 0);
        ImageView chosenImage = findViewById(R.id.imageView);

        chosenImage.setImageResource(chosenImageId);
        textView.setText( "Hi, " + username + ", welcome to Cradle!\n" +
                "You are currently at Foundation level.\n So let's start.\n GOOD LUCK!");
    }

    //Quiz begins by clicking the "begin" button
    public void beginGame(View view){
        iquizActivity = new Intent(BeforeStart.this, QuizActivity.class);
        startActivity(iquizActivity);
    }
}