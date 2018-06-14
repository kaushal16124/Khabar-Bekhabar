package com.example.android.khabarbekhabar;

public class Word {

    private String mTitle;
    private String mDescription;
    private String mPubAt;

    public Word(String title, String description, String pubAt)
    {
        mTitle=title;
        mDescription=description;
        mPubAt=pubAt;
    }


    public String getTitle(){
        return mTitle;
    }

    public String getDescription(){
        return mDescription;
    }

    public String getPubAt(){
        return mPubAt;
    }
}
