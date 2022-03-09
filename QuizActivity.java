package de.thu.cradlequizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
//This is where the quiz game happens
public class QuizActivity extends AppCompatActivity{
    Database database;
    ArrayList<String> questionslist;
    int correctanswer; //correct answer from the database
    int errorcount;    //how many false answers the user has in a row
    int correctcount = 0; //how many correct answers the user have (maximum: 40)
    TextView questiontext;
    Button answerone;
    Button answertwo;
    Button answerthree;
    Button answerfour;
    Button answerfive;
    String level = "Foundation"; //beginning level
    Intent ilevel; //to save data from here and send it to Level activity
    String gender = "";
    private int index = 0; //current number of the question

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        findViewById(R.id.answer1);
        answerone = findViewById(R.id.answer1);
        answertwo = findViewById(R.id.answer2);
        answerthree = findViewById(R.id.answer3);
        answerfour = findViewById(R.id.answer4);
        answerfive = findViewById(R.id.answer5);
        database = new Database();
        questionslist = database.getQuestionsList();
        questiontext = findViewById(R.id.question);

        ilevel = new Intent(this,Level.class);
        //to retrieve data that was probably lost when switching to Level activity
        Intent intent = getIntent();
        //returned index is the index that has been incremented in Level activity
        //so that the user comes back to the next question instead of the same question
        index = intent.getIntExtra("returnedIndex",0);
        //to prevent correct count from starting from 0 everytime
        correctcount = intent.getIntExtra("correctcount", 0);
        SharedPreferences sharedPreferences = this.getSharedPreferences("SharedData", Context.MODE_PRIVATE);
        gender = sharedPreferences.getString("gender", "");
        setQuizQuestions(index);
    }

    public void setQuizQuestions(int i){
        errorcount = 0; //the number of errors is set to zero with every new question
        questiontext.setText(questionslist.get(i));
        answerone.setText(database.getFirstAnswer(questionslist.get(i)));
        answertwo.setText(database.getSecondAnswer(questionslist.get(i)));
        answerthree.setText(database.getThirdAnswer(questionslist.get(i)));
        answerfour.setText(database.getFourthAnswer(questionslist.get(i)));
        answerfive.setText(database.getFifthAnswer(questionslist.get(i)));
        correctanswer = database.getCorrectAnswer(questionslist.get(i));
        //the buttons that have been disabled with the selection of the correct answer
        //are enabled again for the next question
        //and their color is restored to default (in this case black) again
        answerone.setEnabled(true);
        answerone.setBackgroundColor(Color.parseColor("#FF000000"));
        answertwo.setEnabled(true);
        answertwo.setBackgroundColor(Color.parseColor("#FF000000"));
        answerthree.setEnabled(true);
        answerthree.setBackgroundColor(Color.parseColor("#FF000000"));
        answerfour.setEnabled(true);
        answerfour.setBackgroundColor(Color.parseColor("#FF000000"));
        answerfive.setEnabled(true);
        answerfive.setBackgroundColor(Color.parseColor("#FF000000"));
    }

    //the Next button to move to the next question if Level activity hasn't been called
    public void nextButtonClicked(View view){
        index++;
        setQuizQuestions(index);
    }

    public void answersClicked(View view){
        //if the correct answer has been selected then other buttons are disabled and
        //the color of the button turns green. Also levelsdetermined method is called
        // to see whether to open Level activity or not
        //if the false answer has been clicked, then buttons are not disabled as the user
        //has 2 more chances to find the correct one and the button clicked turns red. Also
        //wronganswered method is called to determine what to do based on errorcount
        switch(view.getId()){
            case R.id.answer1:
                if(correctanswer == 1){
                    answerone.setBackgroundColor(Color.parseColor("#32CD32"));
                    correctcount++;
                    answertwo.setEnabled(false);
                    answerthree.setEnabled(false);
                    answerfour.setEnabled(false);
                    answerfive.setEnabled(false);
                    levelsdetermined();
                }else{
                    answerone.setBackgroundColor(Color.parseColor("#ff0000"));
                    errorcount++;
                    wronganswered();
                }
                break;
            case R.id.answer2:
                if(correctanswer == 2){
                    answertwo.setBackgroundColor(Color.parseColor("#32CD32"));
                    correctcount++;
                    answerone.setEnabled(false);
                    answerthree.setEnabled(false);
                    answerfour.setEnabled(false);
                    answerfive.setEnabled(false);
                    levelsdetermined();
                }else{
                    answertwo.setBackgroundColor(Color.parseColor("#ff0000"));
                    errorcount++;
                    wronganswered();
                }
                break;
            case R.id.answer3:
                if(correctanswer == 3){
                    answerthree.setBackgroundColor(Color.parseColor("#32CD32"));
                    correctcount++;
                    answertwo.setEnabled(false);
                    answerone.setEnabled(false);
                    answerfour.setEnabled(false);
                    answerfive.setEnabled(false);
                    levelsdetermined();
                }else{
                    answerthree.setBackgroundColor(Color.parseColor("#ff0000"));
                    errorcount++;
                    wronganswered();
                }
                break;
            case R.id.answer4:
                if(correctanswer == 4){
                    answerfour.setBackgroundColor(Color.parseColor("#32CD32"));
                    correctcount++;
                    answertwo.setEnabled(false);
                    answerthree.setEnabled(false);
                    answerone.setEnabled(false);
                    answerfive.setEnabled(false);
                    levelsdetermined();
                }else{
                    answerfour.setBackgroundColor(Color.parseColor("#ff0000"));
                    errorcount++;
                    wronganswered();
                }
                break;
            case R.id.answer5:
                if(correctanswer == 5){
                    answerfive.setBackgroundColor(Color.parseColor("#32CD32"));
                    correctcount++;
                    answertwo.setEnabled(false);
                    answerthree.setEnabled(false);
                    answerfour.setEnabled(false);
                    answerone.setEnabled(false);
                    levelsdetermined();
                }else{
                    answerfive.setBackgroundColor(Color.parseColor("#ff0000"));
                    errorcount++;
                    wronganswered();
                }
                break;
            default:
                throw new RuntimeException("Unknown Button ID");
        }
    }

    private void wronganswered(){
        //if the user has 1 or 2 times wrongly answered, then do nothing
        if(errorcount == 1 || errorcount == 2) {

        }//but if it's 3 times, then everything is reset and Failure activity is called
        //to start the game again
        else if(errorcount == 3){
            correctcount = 0;
            errorcount = 0;
            index = 0;
            Intent intent = new Intent(this, Failure.class);
            startActivity(intent);
        }
    }

    //here the levels are determined based on the number of correct answers
    //and this data is sent to Level activity along with gender, index, correctcount
    //(the reason is explained above)
    private void levelsdetermined(){
        ilevel.putExtra("gender", gender);
        ilevel.putExtra("index",index);
        ilevel.putExtra("correctcount", correctcount);
        if(correctcount == 1){
            level = "Copper";
            ilevel.putExtra("level", level);
            startActivity(ilevel);
        }else if(correctcount == 2){
            level = "Iron";
            ilevel.putExtra("level", level);
            startActivity(ilevel);
        }else if(correctcount == 3){
            level = "Jade";
            ilevel.putExtra("level", level);
            startActivity(ilevel);
        }else if(correctcount == 5){
            level = "Low Gold";
            ilevel.putExtra("level", level);
            startActivity(ilevel);
        }else if(correctcount == 7){
            level = "High Gold";
            ilevel.putExtra("level", level);
            startActivity(ilevel);
        }else if(correctcount == 10){
            level = "True Gold";
            ilevel.putExtra("level", level);
            startActivity(ilevel);
        }else if(correctcount == 15){
            if(gender.equals("F")){
                level = "Underlady";
                ilevel.putExtra("level", level);
                startActivity(ilevel);
            }else{
                level = "Underlord";
                ilevel.putExtra("level", level);
                startActivity(ilevel);
            }
        }else if(correctcount == 20){
            if(gender.equals("F")){
                level = "Overlady";
                ilevel.putExtra("level", level);
                startActivity(ilevel);
            }else{
                level = "Overlord";
                ilevel.putExtra("level", level);
                startActivity(ilevel);
            }
        }else if(correctcount == 25){
            if(gender.equals("F")){
                level = "Archlady";
                ilevel.putExtra("level", level);
                startActivity(ilevel);
            }else{
                level = "Archlord";
                ilevel.putExtra("level", level);
                startActivity(ilevel);
            }
        }else if(correctcount == 32){
            level = "Herald";
            ilevel.putExtra("level", level);
            startActivity(ilevel);
        }else if(correctcount == 40){
            level = "Monarch";
            ilevel.putExtra("level", level);
            startActivity(ilevel);
        }
    }
}