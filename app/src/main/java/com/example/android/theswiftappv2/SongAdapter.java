package com.example.android.theswiftappv2;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mia on 27/11/2017.
 */

public class SongAdapter extends ArrayAdapter<Song> {
    private int mColorResourceId;

    public SongAdapter(Context context, ArrayList<Song> songs, int colorResourceId) {
        super(context, 0, songs);
        mColorResourceId = colorResourceId;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.music, parent, false);
        }

        // Get the  object located at this position in the list
        Song currentSong = getItem(position);

        // Find the TextView in the music.xml layout with the song name
        TextView songTextView = (TextView) listItemView.findViewById(R.id.song_name);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        songTextView.setText(currentSong.getSongName());

        // Find the TextView in the music.xml layout with the album name
        TextView albumTextView = (TextView) listItemView.findViewById(R.id.album_name);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        albumTextView.setText(currentSong.getmAlbumName());


        // Find the ImageView in the music.xml layout with the ID album_art
        ImageView albumImageView = (ImageView) listItemView.findViewById(R.id.album_art);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView



        if(currentSong.hasImage()){
            albumImageView.setImageResource(currentSong.getImageId());
            albumImageView.setVisibility(View.VISIBLE);
        }
        else {
            albumImageView.setVisibility(View.GONE);
        }


        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);



        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
