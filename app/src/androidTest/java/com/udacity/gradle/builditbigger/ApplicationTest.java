package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.util.Pair;
import android.test.ApplicationTestCase;

import com.udacity.gradle.builditbigger.Rest.MyRestOperations;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class ApplicationTest {

    @Test
    public void asyncShouldReturnNotnull(){
        String result = MyRestOperations.getJokeFromServer(null,new Pair<Context, String>(null, "Rahul"));

        if(BuildConfig.DEBUG)
        {
            if(null ==result )
                throw new AssertionError();

            if(result.equals(""))
                throw new AssertionError();
        }
    }
}