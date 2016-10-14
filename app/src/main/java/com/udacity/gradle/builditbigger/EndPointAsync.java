package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import com.example.lohra.myapplication.backend.myApi.MyApi;
import com.example.myandroidlibrary.LibraryActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.Rest.MyRestOperations;

import java.io.IOException;

/**
 * Created by lohra on 10/14/2016.
 */

public class EndPointAsync extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        context = params[0].first;
        String name = params[0].second;
        String result = MyRestOperations.getJokeFromServer(myApiService,params);
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(context, LibraryActivity.class);
        intent.putExtra("joke",result);
        context.startActivity(intent);

    }
}