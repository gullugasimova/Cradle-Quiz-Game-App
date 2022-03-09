package de.thu.cradlequizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
//here rank of the user is displayed
//it is called everytime the user reaches a new level
public class Level extends AppCompatActivity {
    int index;
    int correctcount;
    String gender;
    Intent iquizActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        TextView textView = findViewById(R.id.leveltextview);
        SharedPreferences sharedPreferences = this.getSharedPreferences("SharedData", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        int chosenImageId = sharedPreferences.getInt("chosen_image", 0);
        ImageView chosenImage = findViewById(R.id.imageView4);
        chosenImage.setImageResource(chosenImageId);
        //After opening this activity and then going back to QuizActivity,
        //the QuizActivity resets itself. As a result, the all the necessary data is kind of lost.
        //(starts at 0 again)
        //that's why every time this activity is called, it retrieves the saved data
        //to send it back to QuizActivity again so that the progress isn't lost.
        //In addition index is incremented so that when the user goes back to the game,
        //they can continue with the next question
        Intent intent = getIntent();
        String level = intent.getStringExtra("level");
        textView.setText("Congratulations, " + username + "!" + "\n You have reached \"" + level + "\"\n Click the button below to continue.");
        index = intent.getIntExtra("index",0);
        index++;
        correctcount = intent.getIntExtra("correctcount", 0);
        iquizActivity = new Intent(this, QuizActivity.class);
        //"Monarch" is the last level that's why this opens the Finish activity
        if(level.equals("Monarch")) {
            Intent intent1 = new Intent(this, Finish.class);
            startActivity(intent1);
        }
    }

    //Back to game button that leads to the QuizActivity
    public void continueGame(View view){
        //Sends the incremented index and correctcount again back to QuizActivity
        iquizActivity.putExtra("returnedIndex", index);
        iquizActivity.putExtra("correctcount", correctcount);
        startActivity(iquizActivity);
    }
}