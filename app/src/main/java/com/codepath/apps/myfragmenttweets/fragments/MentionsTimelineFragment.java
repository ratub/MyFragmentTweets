package com.codepath.apps.myfragmenttweets.fragments;

import com.codepath.apps.myfragmenttweets.TwitterClient;


import android.os.Bundle;
import android.util.Log;

import com.codepath.apps.myfragmenttweets.TwitterApplication;
import com.codepath.apps.myfragmenttweets.TwitterClient;
import com.codepath.apps.myfragmenttweets.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by rbhavsar on 3/16/2015.
 */
public class MentionsTimelineFragment extends com.codepath.apps.myfragmenttweets.fragments.TweetsListFragment {


    private TwitterClient client;
    private com.codepath.apps.myfragmenttweets.fragments.TweetsListFragment fragmentTweetsList;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        client = TwitterApplication.getRestClient(); //singleton client

        populateTimeLine();

        // Access the fragment
        /*if (savedInstanceState == null){

            fragmentTweetsList = (TweetsListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_timeline);

        }*/
    }

    // Send
    private void populateTimeLine(){

        client.getMentionsTimeLine(new JsonHttpResponseHandler() {

            // SUCCESS
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray json) {

                Log.d("Debug: ", json.toString());

                // JSON here
                // DESERIALIZE JSON
                // CREATE MODELS and add them adapter
                // LOAD DATA INTO LISTVIEW

                //ArrayList<Tweet> tweets = Tweet.fromJSONArray();

                addAll(Tweet.fromJSONArray(json));
                //Log.d("Debug :", aTweets.toString());

            }

            // FAILURE
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.d("Debug: ",errorResponse.toString());
            }
        });

    }
}