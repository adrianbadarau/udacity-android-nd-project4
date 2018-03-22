package com.abadarau.mymusicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.abadarau.mymusicplayer.domain.models.Song;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final String PASS_KEY = "chosenSong";
    List<Song> songList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        songList = initSongs(15);
        Button playRandom = findViewById(R.id.nav_play_random_btn);
        playRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goTo = new Intent(getBaseContext(), PlayItemActivity.class);
                goTo.putExtra(PASS_KEY, songList.get(new Random().nextInt(songList.size())));
                startActivity(goTo);
            }
        });
    }


    private List<Song> initSongs(int number) {
        List<String> possibleImages = Arrays.asList("picture1.jpg", "picture2.jpg", "picture3.jpg");
        List<String> possibleNames = Arrays.asList(
                "Yearning Of Mercy",
                "Give My Echo",
                "Woman Promises",
                "She Hopes He's A Troublemaker",
                "Numb Angel",
                "Afternoon Of My Girl",
                "Rusty Soul",
                "She Heard He's Into You",
                "Forsaken Mind",
                "Lines Of Paradise",
                "There Goes His Groove",
                "He Said He's A Dancer",
                "Magic Of Midnight"
        );
        Random random = new Random();
        ArrayList<Song> songs = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Song song = new Song(
                    possibleNames.get(random.nextInt(possibleNames.size())),
                    possibleNames.get(random.nextInt(possibleNames.size())),
                    possibleNames.get(random.nextInt(possibleNames.size())),
                    possibleImages.get(random.nextInt(possibleImages.size())),
                    1900 + random.nextInt(118)
            );
            songs.add(song);
        }

        return songs;
    }
}
