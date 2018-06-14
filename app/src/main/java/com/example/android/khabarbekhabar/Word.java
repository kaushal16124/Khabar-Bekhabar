package com.example.android.khabarbekhabar;

public class Word {

    private String mTitle;
    private String mDescription;
    private String mPubAt;
    private String mImgUrl;

    public Word(String title, String description, String pubAt, String imgUrl)
    {
        mTitle=title;
        mDescription=description;
        mPubAt=pubAt;
        mImgUrl=imgUrl;
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

    public String getImgUrl(){
        return mImgUrl;
    }
}
