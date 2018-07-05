package com.example.android.theswiftappv2;

/**
 * Created by Mia on 27/11/2017.
 */

public class Song {
    private String mSongName;
    private String mAlbumName;
    private int mImageId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;




    public Song (String songName, String albumName, int imageId) {
        mSongName = songName;
        mAlbumName = albumName;
        mImageId = imageId;
    }


    public String getSongName(){

        return mSongName;
    }

    public String getmAlbumName(){
        return mAlbumName;
    }

    public int getImageId(){
        return mImageId;
    }


    public boolean hasImage(){
        return mImageId != NO_IMAGE_PROVIDED;
    }

}
