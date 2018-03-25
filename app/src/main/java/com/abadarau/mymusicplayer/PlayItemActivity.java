package com.abadarau.mymusicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.abadarau.mymusicplayer.domain.models.Song;

public class PlayItemActivity extends AppCompatActivity {

    Song song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_item);
        song = (Song) getIntent().getSerializableExtra(MainActivity.PASS_KEY);
        addSongImage(song.getCoverImageName());
        addSongTitle(song.getTitle());
        addAlbum(song.getAlbum(), song.getReleaseYear());
    }

    private void addSongImage(String imageName){
        ImageView imgHolder = findViewById(R.id.img_album_art);
        int pictureIdRef = getResources().getIdentifier(imageName, "drawable", getPackageName());
        imgHolder.setImageDrawable(getDrawable(pictureIdRef));
    }

    private void addSongTitle(String title){
        TextView songField = findViewById(R.id.tv_song_name);
        songField.setText(title);
    }

    private void addAlbum(String albumName, Integer albumDate){
        TextView albumField = findViewById(R.id.tv_album);
        albumField.setText(albumName + " : " + albumDate);
    }

    private void addAlbum(String albumName){
        TextView albumField = findViewById(R.id.tv_album);
        albumField.setText(albumName);
    }
}
