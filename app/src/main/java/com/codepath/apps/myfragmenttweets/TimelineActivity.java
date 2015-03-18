package com.codepath.apps.myfragmenttweets;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;
import com.codepath.apps.myfragmenttweets.fragments.HomeTimelineFragment;
import com.codepath.apps.myfragmenttweets.fragments.MentionsTimelineFragment;

public class TimelineActivity extends ActionBarActivity {

    int PAGE_COUNT = 2;
    private String tabTitles[] = {"Home", "Mentions"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        // Get the view pager
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Get the view page adapter for the page
        viewPager.setAdapter(new TweetsPageAdapter(getSupportFragmentManager()));

        // Find the page sliding tabs
        PagerSlidingTabStrip tabStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabStrip.setViewPager(viewPager);

        // Alter the pager tabs to viewpager

    }

    public void onProfileView (MenuItem mi){
        // Launch the profile view

        Intent i = new Intent(this, ProfileActivity.class);
        startActivity(i);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_timeline, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    public class TweetsPageAdapter extends FragmentPagerAdapter{


        public TweetsPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if (position == 0 )
                return new HomeTimelineFragment();
             else if (position == 1 ) {
                return new MentionsTimelineFragment();
            }
            else {
                return null;
            }

        }

        @Override
        public int getCount() {
            return tabTitles.length;
        }

        // Return Tab sliding


        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }
    }
}
