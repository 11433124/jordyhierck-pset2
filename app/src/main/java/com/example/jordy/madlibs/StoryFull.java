package com.example.jordy.madlibs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Jordy on 11-11-2016.
 */
public class StoryFull extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story);


        Intent inputWords = getIntent();

        String story = inputWords.getExtras().getString("Story");

        TextView story_full = (TextView) findViewById(R.id.story_full);

        story_full.setText(story);
    }
}
