package com.example.android.musicapp.adapter;

import java.util.Map;

public class MediaAlbum {

    private String artistName;
    private String albumName;
    private int albumCover;
    private String releaseDate;
    private Map<String, String> songMap;
    private MediaType mediaType;

    public MediaAlbum(String artistName, String albumName, int albumCover, String releaseDate, Map<String, String> songMap, MediaType mediaType) {
        this.artistName = artistName;
        this.albumName = albumName;
        this.albumCover = albumCover;
        this.releaseDate = releaseDate;
        this.songMap = songMap;
        this.mediaType = mediaType;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public int getAlbumCover() {
        return albumCover;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public Map<String, String> getSongMap() {
        return songMap;
    }

    public MediaType getMediaType() {
        return mediaType;
    }
}
