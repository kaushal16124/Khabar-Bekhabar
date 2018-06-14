package com.example.android.khabarbekhabar;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {


    public WordAdapter(Activity context, ArrayList<Word> words){

        super(context,0,words);
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

        View textContainer=(View)listItemView.findViewById(R.id.text_container);

        return listItemView;
    }
}
