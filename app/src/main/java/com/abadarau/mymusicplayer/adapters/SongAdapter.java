package com.abadarau.mymusicplayer.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.abadarau.mymusicplayer.MainActivity;
import com.abadarau.mymusicplayer.PlayItemActivity;
import com.abadarau.mymusicplayer.R;
import com.abadarau.mymusicplayer.domain.models.Song;

import java.util.List;

/**
 * Created by abadarau on 3/25/2018.
 */

public class SongAdapter extends ArrayAdapter<Song> {
    public SongAdapter(@NonNull Context context, int resource, @NonNull List<Song> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Song current = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.music_list_item, parent, false);
        }
        addSongImage(current.getCoverImageName(), convertView);
        addSongTitle(current.getTitle(), current.getArtist(), convertView);
        addAlbumInfo(current.getAlbum(), current.getReleaseYear(), convertView);
        addLinkToButton(current, convertView);

        return convertView;
    }

    private void addSongImage(String imageName, View view){
        ImageView imgHolder = view.findViewById(R.id.iv_album_art);
        int pictureIdRef = getContext().getResources().getIdentifier(imageName, "drawable",getContext().getPackageName());
        imgHolder.setImageDrawable(getContext().getDrawable(pictureIdRef));
    }

    private void addSongTitle(String songName, String artistName, View view){
        TextView songField = view.findViewById(R.id.tv_song_lbl);
        songField.setText(songName + " : " + artistName);
    }

    private void addAlbumInfo(String album, Integer year, View view){
        TextView albumField = view.findViewById(R.id.tv_album_lbl);
        albumField.setText(album + " : " + year);
    }

    private void addLinkToButton(final Song song, View view){
        ImageButton playSongBTN = view.findViewById(R.id.btn_play_song);
        playSongBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PlayItemActivity.class);
                intent.putExtra(MainActivity.PASS_KEY, song);
                getContext().startActivity(intent);
            }
        });
    }
}
