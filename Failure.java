package de.thu.cradlequizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

//This activity is used when the user fails to answer a question 3 times
//As a result they start over again
public class Failure extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_failure);
        SharedPreferences sharedPreferences = this.getSharedPreferences("SharedData", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        int chosenImageId = sharedPreferences.getInt("chosen_image", 0);
        ImageView chosenImage = findViewById(R.id.imageView3);
        chosenImage.setImageResource(chosenImageId);
        TextView textView = findViewById(R.id.failure);
        textView.setText("Oh noo! " + username + ", it seems like you failed. But it's okay. You can try again :)");
    }

    public void startAgain(View view){
        Intent iquizActivity = new Intent(Failure.this, QuizActivity.class);
        startActivity(iquizActivity);
    }
}