package com.islamistudio.rss.ui.list;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.islamistudio.rss.R;

public class FeedListActivity extends AppCompatActivity {

    public static final String EXTRA_FEED = "extra_feed";

    public static void open(Activity activity, String url) {
        Intent intent = new Intent(activity, FeedListActivity.class);
        intent.putExtra(EXTRA_FEED, url);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_list);

        TextView tvExtra = findViewById(R.id.tv_extra);
        String url = getIntent().getStringExtra(EXTRA_FEED);
        tvExtra.setText(url);

    }
}
