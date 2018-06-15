package com.example.android.khabarbekhabar;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.ImageViewTarget;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;



import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    ArrayList<Word> newsItemArrayList;
    Context context;
    private Activity activity;

    public WordAdapter(Activity context, ArrayList<Word> words){

        super(context,0,words);
        newsItemArrayList=words;
        activity=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView==null)
        {
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.item_list, parent,false);
        }

        Word currentWord = getItem(position);

        TextView titleText = (TextView)listItemView.findViewById(R.id.text_1);

        titleText.setText(currentWord.getTitle());

        TextView descriptionText = (TextView)listItemView.findViewById(R.id.text_2);

        descriptionText.setText(currentWord.getDescription());

        TextView pubAtText = (TextView)listItemView.findViewById(R.id.text_3);

        pubAtText.setText(currentWord.getPubAt());

        final ImageView imgUrlText = (ImageView)listItemView.findViewById(R.id.kbimg);

        Picasso.with(activity).load(currentWord.getImgUrl()).into(imgUrlText);

        View textContainer=(View)listItemView.findViewById(R.id.text_container);

        return listItemView;
    }
}
