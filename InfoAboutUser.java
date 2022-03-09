package de.thu.cradlequizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
//This is where all the info from the user is acquired
public class InfoAboutUser extends AppCompatActivity {
    Intent istart;
    //this is to be able to send data to other activities
    SharedPreferences.Editor editor;
    Spinner spinner;
    int lindon;
    int yerin;
    int eithan;
    int ozriel;
    int orthos;
    int littleblue;
    int malice;
    int ziel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_about_user);

        //to display images on screen because src or srcCompat in activity_info_about_user.xml didn't work
        lindon = getResources().getIdentifier("@drawable/lindon",null,this.getPackageName());
        ImageView lindonimage = findViewById(R.id.lindonimage);
        lindonimage.setImageResource(lindon);
        yerin = getResources().getIdentifier("@drawable/yerin",null, this.getPackageName());
        ImageView yerinimage = findViewById(R.id.yerinimage);
        yerinimage.setImageResource(yerin);
        eithan = getResources().getIdentifier("@drawable/eithan",null,this.getPackageName());
        ImageView eithanimage = findViewById(R.id.eithanimage);
        eithanimage.setImageResource(eithan);
        ozriel = getResources().getIdentifier("@drawable/ozriel",null,this.getPackageName());
        ImageView ozrielimage = findViewById(R.id.ozrielimage);
        ozrielimage.setImageResource(ozriel);
        orthos = getResources().getIdentifier("@drawable/orthos",null,this.getPackageName());
        ImageView orthosimage = findViewById(R.id.orthosimage);
        orthosimage.setImageResource(orthos);
        littleblue = getResources().getIdentifier("@drawable/littleblue",null,this.getPackageName());
        ImageView littleblueimage = findViewById(R.id.littleblueimage);
        littleblueimage.setImageResource(littleblue);
        malice = getResources().getIdentifier("@drawable/malice",null,this.getPackageName());
        ImageView maliceimage = findViewById(R.id.maliceimage);
        maliceimage.setImageResource(malice);
        ziel = getResources().getIdentifier("@drawable/ziel",null,this.getPackageName());
        ImageView zielimage = findViewById(R.id.zielimage);
        zielimage.setImageResource(ziel);

        spinner = findViewById(R.id.spinner);
        //"Select your gender" is included because I wanted this sentence to be the default text
        // but couldn't find another way :/
        String[] genders = {"Select your gender","M", "F", "Diverse"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.spinner_item_layout,
                R.id.spinner_item,
                genders);
        spinner.setAdapter(adapter);

        istart = new Intent(this, BeforeStart.class);
        SharedPreferences sharedPreferences = this.getSharedPreferences("SharedData", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    //This button click shows the sources of the images which are listed in Sources Activity
    public void listSources(View view) {
        Intent intent = new Intent(InfoAboutUser.this, Sources.class);
        startActivity(intent);
    }

    @SuppressLint("NonConstantResourceId")
    public void buttonClicked(View view){
        //depending on whether a character is chosen or personal name/nickname is used
        //this data is sent to other activities via shared preferences
        switch (view.getId()){
            case R.id.enterbutton:
                EditText editText = findViewById(R.id.edit_text);
                editor.putString("username", editText.getText().toString());
                editor.putInt("chosen_image", 0);
                editor.apply();
                break;
            case R.id.lindonbutton:
                editor.putString("username", "Lindon");
                //this is to send the int value of the image resource which has been acquired
                //in the onCreate method
                //so that in the other activities the image can be displayed
                editor.putInt("chosen_image", lindon);
                editor.apply();
                break;
            case R.id.yerinbutton:
                editor.putString("username", "Yerin");
                editor.putInt("chosen_image", yerin);
                editor.apply();
                break;
            case R.id.eithanbutton:
                editor.putString("username", "Eithan");
                editor.putInt("chosen_image", eithan);
                editor.apply();
                break;
            case R.id.ozrielbutton:
                editor.putString("username", "Ozriel");
                editor.putInt("chosen_image", ozriel);
                editor.apply();
                break;
            case R.id.orthosbutton:
                editor.putString("username", "Orthos");
                editor.putInt("chosen_image", orthos);
                editor.apply();
                break;
            case R.id.littlebluebutton:
                editor.putString("username", "Little Blue");
                editor.putInt("chosen_image", littleblue);
                editor.apply();
                break;
            case R.id.malicebutton:
                editor.putString("username", "Malice");
                editor.putInt("chosen_image", malice);
                editor.apply();
                break;
            case R.id.zielbutton:
                editor.putString("username", "Ziel");
                editor.putInt("chosen_image", ziel);
                editor.apply();
                break;
            default:
                throw new RuntimeException("Unknown Button ID");
        }
    }

    //this is the next button that leads to BeforeStart activity to welcome the user
    public void beforeGame(View view){
        editor.putString("gender", spinner.getSelectedItem().toString());
        editor.apply();
        startActivity(istart);
    }
}