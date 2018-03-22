package com.abadarau.mymusicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.abadarau.mymusicplayer.domain.models.Song;

public class PlayItemActivity extends AppCompatActivity {

    Song song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_item);
        song = (Song) getIntent().getSerializableExtra(MainActivity.PASS_KEY);
    }
}
