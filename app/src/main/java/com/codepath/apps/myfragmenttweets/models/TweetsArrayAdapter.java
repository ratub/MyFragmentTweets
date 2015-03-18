package com.codepath.apps.myfragmenttweets.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.apps.myfragmenttweets.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by rbhavsar on 3/7/2015.
 */
// Taking the tweet object and turning them into views
    // that will be displayed in lists
public class TweetsArrayAdapter extends ArrayAdapter<Tweet> {



    public TweetsArrayAdapter(Context context, List<Tweet> tweets) {
        super(context, 0, tweets);
    }

    // override and setup custom template
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the tweet
        Tweet tweet = getItem(position);
            // Find or inflate the template
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_tweet, parent, false);

        }

        // find the subview to fill with data in template
        ImageView  ivProfileImage = (ImageView) convertView.findViewById(R.id.ivProfileImage);
        TextView  tvUserName = (TextView) convertView.findViewById(R.id.tvUserName);
        TextView  tvBody = (TextView) convertView.findViewById(R.id.tvBody);

        // populate data into subviews
        tvUserName.setText(tweet.getUser().getScreenName());

        tvBody.setText(tweet.getBody());
        // return the view to be inserted

        // clear out old image
        ivProfileImage.setImageResource(android.R.color.transparent);

        Picasso.with(getContext()).load(tweet.getUser().getProfileImageUrl()).into(ivProfileImage);
        return convertView;
    }

}
