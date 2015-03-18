package com.codepath.apps.myfragmenttweets.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by rbhavsar on 3/7/2015.
 */
public class User {

    // List attribjutes
    private String name;
    private long uid;
    private String screenName;
    private String profileImageUrl;
    private String tagline;
    private int followersCount;
    private int followingCount;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getTagline() {
        return tagline;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public int getFriendsCount() {
        return followingCount;
    }

    // Deserialize the user json =>
    public static User fromJSON(JSONObject json ) {
        User u = new User();
        // Extract and fill the values
        try {
            u.name = json.getString("name");
            u.uid = json.getLong("id");
            u.screenName = json.getString("screen_name");
            u.profileImageUrl = json.getString("profile_image_url");
            u.tagline= json.getString("description");
            u.followersCount=json.getInt("followers_count");
            u.followingCount=json.getInt("friends_count");

        } catch (JSONException e) {
            e.printStackTrace();

        }
        return u;
    }
}
