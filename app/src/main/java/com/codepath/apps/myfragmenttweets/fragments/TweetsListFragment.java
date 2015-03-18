package com.codepath.apps.myfragmenttweets.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.codepath.apps.myfragmenttweets.R;
import com.codepath.apps.myfragmenttweets.models.Tweet;
import com.codepath.apps.myfragmenttweets.models.TweetsArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rbhavsar on 3/16/2015.
 */
public class TweetsListFragment extends Fragment {

    private ArrayList<Tweet> tweets;
    private TweetsArrayAdapter aTweets;
    private ListView lvTweets;
    // Inflation Login

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tweets_list,parent,false);

        lvTweets = (ListView) v.findViewById(R.id.lvTweets);
        lvTweets.setAdapter(aTweets);

        return v;
    }


    // Creation lifecycle


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tweets = new ArrayList();

        aTweets = new TweetsArrayAdapter(getActivity(),tweets);

    }

    public void addAll(List tweets){
        aTweets.addAll(tweets);
    }

}
