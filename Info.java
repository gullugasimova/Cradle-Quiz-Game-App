package de.thu.cradlequizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
//One of the menus that provides quick info about the info and some relevant links for further interest
public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        TextView t2 = findViewById(R.id.info_book);
        t2.setText("Will Wight lives in Florida, among citrus fruits and slithering sea creatures. He's the New York Times and #1 Kindle Best Selling author of the Traveler's Gate Trilogy, The Elder Empire, and his series of mythical martial arts magic: Cradle.\n"
                +"He graduated from the University of Central Florida in 2013, earning a Master’s of Fine Arts in Creative Writing and a flute of dragon’s bone. He is also, apparently, invisible to cameras.\n"
                +"\nCradle series - a series of epic fantasy novels by Will, a story about Lindon, a 15-year-old young boy determined to learn his clan’s sacred arts. Even though this is forbidden thanks to his unsouled status, Lindon is no quitter. The series follows the growth of an under-hero who rises the ranks through hard work and sheer determination. It also comes with a complex and well-thought-out magic system. Add the fantastic action and diverse cast, and you have yourself an outstanding series.");
        TextView t3 = findViewById(R.id.link_website);
        t3.setMovementMethod(LinkMovementMethod.getInstance());

    }
}