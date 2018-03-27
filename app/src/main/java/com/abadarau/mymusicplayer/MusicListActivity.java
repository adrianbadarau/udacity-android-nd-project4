package com.abadarau.mymusicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.abadarau.mymusicplayer.adapters.SongAdapter;
import com.abadarau.mymusicplayer.domain.models.Song;

import java.util.List;

public class MusicListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_list);
        List<Song> songs = (List<Song>)  MainActivity.SESSION.get(MainActivity.SONGS_KEY);
        SongAdapter songList = new SongAdapter(this,R.layout.music_list_item, songs);
        ListView songListView = findViewById(R.id.lv_song_list);
        songListView.setAdapter(songList);

        Button backBtn = findViewById(R.id.go_to_main_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
