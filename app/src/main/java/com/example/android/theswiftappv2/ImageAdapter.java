package com.example.android.theswiftappv2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Mia on 25/11/2017.
 */

// implements some required methods inherited from BaseAdapter
public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c){
        mContext = c;
    }

    //returns the number of images
    public int getCount() {
        return mMenuPics.length;
    }

    //returns the actual object at the specified position
    public Object getItem(int position){
        return null;
    }

    //returns row id of the object
    public long getItemId(int position){
        return 0;
    }

    //Create a new ImageView for each item referenced by the adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if(convertView == null) {
            //if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(400, 400));
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setPadding(4, 8, 4, 4);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mMenuPics[position]);
        return imageView;
    }

    //references to our images
    private Integer[] mMenuPics = {
            R.mipmap.i2, R.mipmap.i1,
            R.mipmap.i3, R.mipmap.i4,
            R.mipmap.i6, R.mipmap.i5,
    };






}
