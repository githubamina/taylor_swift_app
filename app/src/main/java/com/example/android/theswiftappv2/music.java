package com.example.android.theswiftappv2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Mia on 27/11/2017.
 */

public class music extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        final ArrayList<Song> songs = new ArrayList<Song>();

        songs.add(new Song("Tim McGraw","Taylor Swift, 2006", R.mipmap.ts1));
        songs.add(new Song("Picture To Burn","Taylor Swift, 2006", R.mipmap.ts1));
        songs.add(new Song("Love Story","Fearless, 2008", R.mipmap.fearless));
        songs.add(new Song("Fearless","Fearless, 2008", R.mipmap.fearless));
        songs.add(new Song("Mean","Speak Now, 2010", R.mipmap.speaknow));
        songs.add(new Song("Sparks Fly","Speak Now, 2010", R.mipmap.speaknow));
        songs.add(new Song("22","Red, 2012", R.mipmap.red));
        songs.add(new Song("Red","Red, 2012", R.mipmap.red));
        songs.add(new Song("Out Of The Woods","1989, 2014", R.mipmap.a1989));
        songs.add(new Song("New Romantics","1989, 2014", R.mipmap.a1989));
        songs.add(new Song("Look What You Made Me Do","Reputation, 2017", R.mipmap.reputation));
        songs.add(new Song("...Ready For It?","Reputation, 2017", R.mipmap.reputation));

        SongAdapter songAdapter = new SongAdapter(this, songs, R.color.song_list);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(songAdapter);


        View header = View.inflate(this, R.layout.header, null);
// where "this" is a context / activity...

        listView.addHeaderView(header, null, false);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)  {

                if(position == 1) {
                    Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=GkD20ajVxnY"));
                    startActivity(browser);
                }
                else if(position == 2) {
                    Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=yCMqcFAigRg"));
                    startActivity(browser);
                }
                else if(position == 3){
                    Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=8xg3vE8Ie_E"));
                    startActivity(browser);
                }
                else if(position == 4){
                    Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=ptSjNWnzpjg"));
                    startActivity(browser);
                }
                else if(position == 5) {
                    Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=jYa1eI1hpDE"));
                    startActivity(browser);
                }
                else if(position ==6){
                    Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=oKar-tF__ac"));
                    startActivity(browser);
                }
                else if(position == 7) {
                    Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=AgFeZr5ptV8"));
                    startActivity(browser);
                }
                else if(position == 8){
                    Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Zlot0i3Zykw"));
                    startActivity(browser);
                }
                else if(position == 9){
                    Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=JLf9q36UsBk"));
                    startActivity(browser);
                }
                else if(position == 10) {
                    Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=wyK7YuwUWsU"));
                    startActivity(browser);
                }
                else if(position == 11){
                    Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=3tmd-ClpJxA"));
                    startActivity(browser);
                }
                else if(position == 12){
                    Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=wIft-t-MQuE"));
                    startActivity(browser);
                }
            }
        });
}}
