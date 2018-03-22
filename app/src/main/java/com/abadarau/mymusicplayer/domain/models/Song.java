package com.abadarau.mymusicplayer.domain.models;

import java.io.Serializable;

/**
 * Created by abadarau on 3/22/2018.
 */

public class Song implements Serializable{
    private String title;
    private String artist;
    private String album;
    private String coverImageName;
    private Integer releaseYear;

    public Song() {
    }

    public Song(String title, String artist, String album, String coverImageName, Integer releaseYear) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.coverImageName = coverImageName;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getCoverImageName() {
        return coverImageName;
    }

    public void setCoverImageName(String coverImageName) {
        this.coverImageName = coverImageName;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }
}
