package com.example.jordy.madlibs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        story_full.setText(story);}

        public void newButton(View view){
            Intent getFillableIntent = new Intent(this, Fillable.class);

            startActivity(getFillableIntent);

        }

}
