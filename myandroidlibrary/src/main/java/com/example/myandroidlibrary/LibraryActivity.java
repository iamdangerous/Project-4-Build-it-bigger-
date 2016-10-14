package com.example.myandroidlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;

public class LibraryActivity extends AppCompatActivity {

    String joke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_activity_main);

        AppCompatTextView tv = (AppCompatTextView)findViewById(R.id.tv);

        getData();

        tv.setText(joke);
    }

    void getData(){
        Intent intent = getIntent();
        if(intent!=null){
            joke = intent.getStringExtra("joke");
        }
    }
}
