package de.thu.cradlequizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
//This activity, as the name suggests, shows up at the end when the user completes the quiz
//and it has a button to go back to the beginning of the app again
public class Finish extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        TextView textView = findViewById(R.id.finish);
        Intent intent = getIntent();
        //to display the image of the character that the user has chosen in the beginning
        SharedPreferences sharedPreferences = this.getSharedPreferences("SharedData", Context.MODE_PRIVATE);
        int chosenImageId = sharedPreferences.getInt("chosen_image", 0);
        ImageView chosenImage = findViewById(R.id.imageView2);
        chosenImage.setImageResource(chosenImageId);
        //the username info acquired from the InfoAboutUser activity
        String username = sharedPreferences.getString("username", "");
        textView.setText("Congratulations, " + username + "!\n You are an awesome Monarch!");
    }

    public void goBacktoMainPage(View view) {
        Intent intent = new Intent(Finish.this, MainActivity.class);
        startActivity(intent);
    }
}