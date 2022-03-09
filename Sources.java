package de.thu.cradlequizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
//List of the sources of the images of the characters used in this project
public class Sources extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sources);
        //to be able to show the hyperlinks that have been provided in strings.xml in res/values folder
        TextView t1 = findViewById(R.id.source1);
        t1.setMovementMethod(LinkMovementMethod.getInstance());
        TextView t2 = findViewById(R.id.source2);
        t2.setMovementMethod(LinkMovementMethod.getInstance());
        TextView t3 = findViewById(R.id.source3);
        t3.setMovementMethod(LinkMovementMethod.getInstance());
        TextView t4 = findViewById(R.id.source4);
        t4.setMovementMethod(LinkMovementMethod.getInstance());
        TextView t5 = findViewById(R.id.source5);
        t5.setMovementMethod(LinkMovementMethod.getInstance());
        TextView t6 = findViewById(R.id.source6);
        t6.setMovementMethod(LinkMovementMethod.getInstance());
        TextView t7 = findViewById(R.id.source7);
        t7.setMovementMethod(LinkMovementMethod.getInstance());
        TextView t8 = findViewById(R.id.source8);
        t8.setMovementMethod(LinkMovementMethod.getInstance());

    }
}