package com.example.jordy.madlibs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.example.jordy.madlibs.Story;
/**
 * Created by Jordy on 11-11-2016.
 */

public class Fillable extends Activity{

    private Button button_word_input;
    private EditText word_input;
    private TextView wordcount;
    private Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fillable);

        button_word_input = (Button) findViewById(R.id.button_word_input);
        word_input = (EditText) findViewById(R.id.word_input);
        wordcount = (TextView) findViewById(R.id.wordcount);

        createStory();

        word_input.setHint("Fill in a(n) " + story.getNextPlaceholder());
        wordcount.setText(story.getPlaceholderRemainingCount() + " words remaining");
    }

    public Story createStory(){
        InputStream test = getResources().openRawResource(R.raw.madlib0_simple);
        story = new Story(test);
        return story;
    }

    public String getInput(){
        String Input = String.valueOf(word_input.getText());
        return Input;
    }

    public void setWords(View view){
        story.fillInPlaceholder(getInput());
        word_input.setText("");
        word_input.setHint("Fill in a " + story.getNextPlaceholder());
        wordcount.setText(story.getPlaceholderRemainingCount() + " words remaning");

        if (story.getPlaceholderRemainingCount() == 0){
            goToStory();
        }
    }

    public void goToStory(){
        Intent goToStory = new Intent(this, StoryFull.class);
        goToStory.putExtra("Story", story.toString());
        startActivity(goToStory);

    }

}
