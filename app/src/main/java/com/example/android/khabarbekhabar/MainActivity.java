package com.example.android.khabarbekhabar;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progress;
    ListView l1;
    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        final ArrayList<Word> words=new ArrayList<Word>();

        Button click = (Button) findViewById(R.id.button);
        progress =(ProgressBar)findViewById(R.id.pbar);
        l1 = (ListView)findViewById(R.id.list);
        wv = (WebView)findViewById(R.id.wbview);


        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progress.setVisibility(View.VISIBLE);
                wv.setVisibility(View.INVISIBLE);
                l1.setVisibility(View.VISIBLE);
                fetchData process = new fetchData();
                process.execute();
            }
        });


    }

    public class fetchData extends AsyncTask<Void,Void,Void> {
        String data="";
        String title="";
        String description="";
        String pubAt="";
        String imgUrl="";
        String url1="";


        final ArrayList<Word> words=new ArrayList<Word>();
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected Void doInBackground(Void... voids) {


            try {
                URL url= new URL("https://newsapi.org/v2/top-headlines?country=in&apiKey=ca4ff308ab6d4824b235e962e4c748ca");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                String line = " ";
                while (line!=null)
                {
                    line=bufferedReader.readLine();
                    data=data+line;
                }
                JSONObject JOO = new JSONObject(this.data);

                JSONArray JA = (JSONArray) JOO.get("articles");
                for(int i=0;i<JA.length();i++)
                {
                    JSONObject JO = (JSONObject) JA.get(i);
                    title =(String) JO.get("title");
                    description = (String) JO.getString("description");
                    pubAt = (String) JO.get("publishedAt");
                    imgUrl = (String) JO.getString("urlToImage");
                    url1 = (String) JO.getString("url");
                    words.add(new Word(title, description,pubAt,imgUrl,url1));
                }
            }
            catch (MalformedURLException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);


            final ListView listView = (ListView) findViewById(R.id.list);
            WordAdapter adapter = new WordAdapter(MainActivity.this, words);
            listView.setAdapter(adapter);
            progress.setVisibility(View.INVISIBLE);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    Word word1 = words.get(i);
//                    setContentView(R.layout.activity_web_view1);

                    ProgressBar progressBar = (ProgressBar)findViewById(R.id.pbar1);

                    WebView myWebView = (WebView) findViewById(R.id.wbview);
                    listView.setVisibility(View.INVISIBLE);
                    myWebView.clearCache(true);
                    myWebView.clearHistory();
                    myWebView.clearView();
                    myWebView.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.VISIBLE);

                    myWebView.clearView();

                    myWebView.clearCache(true);
                    myWebView.clearHistory();
                    WebSettings webSettings = myWebView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    myWebView.loadUrl(word1.getUrl1());
                    progressBar.setVisibility(View.INVISIBLE);
                    myWebView.setWebViewClient(new WebViewClient());
                }
            });
        }
    }}
