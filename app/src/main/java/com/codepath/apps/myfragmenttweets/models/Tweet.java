package com.codepath.apps.myfragmenttweets.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**

 * Created by rbhavsar on 3/7/2015.
 */

// Parse the JSON, store the data, encapsulate logic or display logic

public class Tweet {

    //List out the attributes
    private String body;
    private long uid; // unique id for the tweety
    private User user;
    private String createdAt;

    // Deserialize the JSON
    // create method to convert Tweet.fromJson({..}") => <Tweet>


    public static Tweet fromJSON(JSONObject jsonObject) {
        Tweet tweet = new Tweet();

        // Extract the values from the json, store them

        try {
            tweet.body = jsonObject.getString("text");
            tweet.uid = jsonObject.getLong("id");
            tweet.createdAt = jsonObject.getString("created_at");
            tweet.user = User.fromJSON(jsonObject.getJSONObject("user"));

        } catch (JSONException e ){
            e.printStackTrace();

        }

        // Return the tweet object
        return tweet;

    }

    // Pass Json array and ourtout us list of tweets
    public static ArrayList<Tweet> fromJSONArray(JSONArray jsonArray) {

         ArrayList<Tweet> tweets = new ArrayList<>();

        // Iterrate the json array and create tweets
        for (int i=0; i< jsonArray.length() ; i++){

            try {
                JSONObject tweetJson = jsonArray.getJSONObject(i);

                Tweet tweet = Tweet.fromJSON(tweetJson);

                if (tweet != null ){
                    tweets.add(tweet);
                }

            } catch (JSONException e) {
                e.printStackTrace();
                continue;
            }

        }

        // return the finished list
        return tweets;

    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }
}
