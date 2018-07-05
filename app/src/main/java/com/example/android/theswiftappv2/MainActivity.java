package com.example.android.theswiftappv2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_page);


        //Find the view that shows the welcome page
        TextView welcome = (TextView) findViewById(R.id.welcome);

        //Set a click listener on that View
        welcome.setOnClickListener(new View.OnClickListener() {
            //The code in this method will be executed when the welcome view is clicked on.
            @Override
            public void onClick(View view){
                Intent menuIntent = new Intent(MainActivity.this, menu.class);
                startActivity(menuIntent);
            }
        });
    }
}
