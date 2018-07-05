package com.example.android.theswiftappv2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 * Created by Mia on 25/11/2017.
 */

public class menu extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);


        //create a new gridview object by locating the gridview view
        GridView gridView = (GridView) findViewById(R.id.gridview);

        //attach the imageadapter to the gridview
        gridView.setAdapter(new ImageAdapter(this));


        //set an onclicklistener so that when an item in the gridview is clicked on,
        // an intent will be created to send the user to the next activity
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)  {

                if(position == 0) {
                    Intent musicIntent = new Intent(menu.this, music.class);
                    startActivity(musicIntent);
                }
                else if(position == 1) {
                    Intent catsIntent = new Intent(menu.this, cats.class);
                    startActivity(catsIntent);
                }
                else if(position ==2){
                    Intent toursIntent = new Intent(menu.this, tours.class);
                    startActivity(toursIntent);
                }
                else if(position == 3){
                    Intent picturesIntent = new Intent(menu.this, squad.class);
                    startActivity(picturesIntent);
                }
                else if(position == 4) {
                    Intent taylorIntent = new Intent(menu.this, taylor.class);
                    startActivity(taylorIntent);
                }
                else if(position ==5){
                    Intent reputationIntent = new Intent(menu.this, reputation.class);
                    startActivity(reputationIntent);
                }
            }
        });
    }
}
