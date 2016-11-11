package com.example.jordy.madlibs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.io.InputStream;
import java.util.Random;

/**
 * Created by Jordy Hierck on 11-11-2016.
 * 11433124
 * Minor Programmeren
 * Universiteit van Amsterdam
 *
 * Adds user-inputted words to madlibs story file
 */

public class Fillable extends Activity{

    // Global variables to use later on
    private EditText word_input;
    private TextView wordcount;
    private TextView name_story;
    private Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fillable);

        // set variable to xml-id
        word_input = (EditText) findViewById(R.id.word_input);
        wordcount = (TextView) findViewById(R.id.wordcount);
        name_story = (TextView) findViewById(R.id.name_story);

        // set the story
        createStory();

        // Initiate with maximum words to fill in
        word_input.setHint("Fill in a(n) " + story.getNextPlaceholder());
        wordcount.setText(story.getPlaceholderRemainingCount() + " words remaining");
    }

    // create story from text file
    public Story createStory(){
        // create random integer responding to different texts to display at random
        Random rand = new Random();
        int random_number = rand.nextInt(5);
        if (random_number == 0){
            InputStream text = getResources().openRawResource(R.raw.madlib0_simple);
            story = new Story(text);
            // set text to show what story you are typing
            name_story.setText("You are writing a simple story!");
        }
        if (random_number == 1){
            InputStream text = getResources().openRawResource(R.raw.madlib1_tarzan);
            story = new Story(text);
            name_story.setText("You are writing a story about Tarzan!");
        }
        if (random_number == 2){
            InputStream text = getResources().openRawResource(R.raw.madlib2_university);
            story = new Story(text);
            name_story.setText("You are writing a story about the life of a scholar!");
        }
        if (random_number == 3){
            InputStream text = getResources().openRawResource(R.raw.madlib3_clothes);
            story = new Story(text);
            name_story.setText("You are writing a story about clothes!");
        }
        if (random_number == 4){
            InputStream text = getResources().openRawResource(R.raw.madlib4_dance);
            story = new Story(text);
            name_story.setText("You are writing a story about dancing!");
        }
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
