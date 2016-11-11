package com.example.jordy.madlibs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.io.InputStream;

/**
 * Created by Jordy on 11-11-2016.
 */

public class Fillable extends Activity{
    private EditText word_input;
    private TextView wordcount;
    private Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fillable);

        word_input = (EditText) findViewById(R.id.word_input);
        wordcount = (TextView) findViewById(R.id.wordcount);

        createStory();

        word_input.setHint("Fill in a(n) " + story.getNextPlaceholder());
        wordcount.setText(story.getPlaceholderRemainingCount() + " words remaining");
    }

    public Story createStory(){
        InputStream university = getResources().openRawResource(R.raw.madlib2_university);
        story = new Story(university);
        return story;
    }

    public String getInput(){
        String input = String.valueOf(word_input.getText());
        return input;
    }

    public void setWords(View view){
        if (word_input.length() == 0){
            word_input.setError("This field can not be blank.");
            return;
        }
        story.fillInPlaceholder(getInput());
        word_input.setText("");
        word_input.setHint("Fill in a " + story.getNextPlaceholder());
        wordcount.setText(story.getPlaceholderRemainingCount() + " words remaning");

        if (story.getPlaceholderRemainingCount() == 0){
            Intent goToStory = new Intent(this, StoryFull.class);
            goToStory.putExtra("Story", story.toString());
            startActivity(goToStory);
        }
    }
}
