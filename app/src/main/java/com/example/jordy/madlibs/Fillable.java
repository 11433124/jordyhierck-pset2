package com.example.jordy.madlibs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.io.InputStream;

/**
 * Created by Jordy Hierck on 11-11-2016.
 * Minor Programmeren
 * Universiteit van Amsterdam
 *
 * Adds user-inputted words to madlibs story file
 */

public class Fillable extends Activity{

    // Global variables to use later on
    private EditText word_input;
    private TextView wordcount;
    private Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fillable);

        // set variable to xml-id
        word_input = (EditText) findViewById(R.id.word_input);
        wordcount = (TextView) findViewById(R.id.wordcount);

        // set the story
        createStory();

        // Initiate with maximum words to fill in
        word_input.setHint("Fill in a(n) " + story.getNextPlaceholder());
        wordcount.setText(story.getPlaceholderRemainingCount() + " words remaining");
    }

    // create story from text file
    public Story createStory(){
        InputStream university = getResources().openRawResource(R.raw.madlib2_university);
        story = new Story(university);
        return story;
    }

    // get input from user and return for later use
    public String getInput(){
        String input = String.valueOf(word_input.getText());
        return input;
    }

    // store the words and update view
    public void setWords(View view){
        // check if user input field is not empty
        if (word_input.length() == 0){
            word_input.setError("This field can not be blank.");
            return;
        }
        // get input from user, set textbox back to normal
        story.fillInPlaceholder(getInput());
        word_input.setText("");
        word_input.setHint("Fill in a " + story.getNextPlaceholder());
        // update remaining words
        wordcount.setText(story.getPlaceholderRemainingCount() + " words remaning");

        // make intent to call upon in final story
        if (story.getPlaceholderRemainingCount() == 0){
            Intent goToStory = new Intent(this, StoryFull.class);
            goToStory.putExtra("Story", story.toString());
            startActivity(goToStory);
        }
    }
}
