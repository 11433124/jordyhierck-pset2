package com.example.jordy.madlibs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Jordy Hierck on 11-11-2016.
 * 11433124
 * Minor Programmeren
 * Universiteit van Amsterdam
 *
 * Shows the full story with the user-inputted words
 */
public class StoryFull extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story);

        // get intent from fillable page
        Intent inputWords = getIntent();

        // makes a string to show story
        String story = inputWords.getExtras().getString("Story");

        // set the textview to show the story
        TextView story_full = (TextView) findViewById(R.id.story_full);

        // actually show the story string
        story_full.setText(story);}

        // button to go back fillable page
        public void newButton(View view){
            Intent getFillableIntent = new Intent(this, Fillable.class);

            startActivity(getFillableIntent);

        }

}
