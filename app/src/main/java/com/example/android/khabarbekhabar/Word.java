package com.example.android.khabarbekhabar;

public class Word {

    private String mTitle;
    private String mDescription;
    private String mPubAt;
    private String mImgUrl;
    private String mUrl;

    public Word(String title, String description, String pubAt, String imgUrl, String url)
    {
        mTitle=title;
        mDescription=description;
        mPubAt=pubAt;
        mImgUrl=imgUrl;
        mUrl=url;
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

    public String getUrl1() {
        return mUrl;
    }
}
