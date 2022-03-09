package de.thu.cradlequizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
//One of the menus explaining the rules to the user
public class Rules extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        TextView textView = findViewById(R.id.explaining_rules);
        textView.setText("\nWelcome to Cradle Quiz Game\n" +
                "\nThis game is intended to the people who have\n" +
                "read the books, as the questions are specific and not general knowledge.\n" +
                "\nThe game contains 40 questions." +
                "The game will have 12 ranks based on the books.\n" +
                "   1. Foundation - start\n" +
                "   2. Copper - is reached with the first question answered correctly\n" +
                "   3. Iron - by the 2nd correct answer\n" +
                "   4. Jade - by the 3rd correct answer\n" +
                "   5. Low gold - by the 5th correct answer\n" +
                "   6. High gold - by the 7th correct answer\n" +
                "   7. True gold - by the 10th correct answer\n" +
                "   8. Underlord/Underlady - by the 15th correct answer\n" +
                "   9. Overlord/Overlady - by the 20th correct answer\n" +
                "   10. Archlord/Archlady - by the 25th correct answer\n" +
                "   11. Herald - by the 32nd correct answer. \n" +
                "   12. Monarch - by the 40th correct answer, i.e. the game is completed.\n" +
                "\nIf you answer incorrectly, then you have only 2 more chances to find the correct" +
                " answer. If you still fail, you will start over.");
    }
}