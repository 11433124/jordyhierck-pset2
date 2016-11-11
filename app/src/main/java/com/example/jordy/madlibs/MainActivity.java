package com.example.jordy.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // make intent to go to fillable page - start the app.
    public void goToFillable(View view){
        Intent getFillableIntent = new Intent(this, Fillable.class);

        startActivity(getFillableIntent);

    }
}

