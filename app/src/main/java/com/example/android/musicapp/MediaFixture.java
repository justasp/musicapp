package com.example.android.musicapp;

import com.example.android.musicapp.adapter.MediaAlbum;
import com.example.android.musicapp.adapter.MediaType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MediaFixture {

    public static final List<MediaAlbum> albumList = populateMediaList();

    private static List<MediaAlbum> populateMediaList() {
        MediaAlbum mediaAlbum1 = new MediaAlbum("Artist 1", "Album 1", 1, "2017", getSongList(), MediaType.MUSIC_ALBUM);
        MediaAlbum mediaAlbum2 = new MediaAlbum("Artist 1", "Album 2", 1, "2010", getSongList(), MediaType.MUSIC_ALBUM);
        MediaAlbum mediaAlbum3 = new MediaAlbum("Artist 2", "Album 1", 1, "2007", getSongList(), MediaType.MUSIC_ALBUM);
        MediaAlbum mediaAlbum4 = new MediaAlbum("Artist 2", "Album 2", 1, "2020", getSongList(), MediaType.MUSIC_ALBUM);
        MediaAlbum mediaAlbum5 = new MediaAlbum("Artist 2", "Album 3", 1, "2019", getSongList(), MediaType.MUSIC_ALBUM);
        MediaAlbum mediaAlbum6 = new MediaAlbum("Podcast person 1", "Podcast 1", 1, "2018", getSongList(), MediaType.PODCAST);
        MediaAlbum mediaAlbum7 = new MediaAlbum("Podcast person 2", "Podcast 2", 1, "2011", getSongList(), MediaType.PODCAST);
        MediaAlbum mediaAlbum8 = new MediaAlbum("Podcast person 3", "Podcast 3", 1, "2001", getSongList(), MediaType.PODCAST);
        MediaAlbum mediaAlbum9 = new MediaAlbum("Podcast person 4", "Podcast 4", 1, "2016", getSongList(), MediaType.PODCAST);
        MediaAlbum mediaAlbum10 = new MediaAlbum("Podcast person 5", "Podcast 5", 1, "2017", getSongList(), MediaType.PODCAST);

        return Arrays.asList(mediaAlbum1,
                mediaAlbum2,
                mediaAlbum3,
                mediaAlbum4,
                mediaAlbum5,
                mediaAlbum6,
                mediaAlbum7,
                mediaAlbum8,
                mediaAlbum9,
                mediaAlbum10);
    }

    private static Map<String, String> getSongList() {
        Map<String, String> songMapWithDuration = new TreeMap<>();
        songMapWithDuration.put("Song 1", "5:53");
        songMapWithDuration.put("Song 2", "5:00");
        songMapWithDuration.put("Song 3", "1:12");
        songMapWithDuration.put("Song 4", "3:14");
        songMapWithDuration.put("Song 5", "6:30");
        songMapWithDuration.put("Song 6", "1:17");
        songMapWithDuration.put("Song 7", "4:20");
        songMapWithDuration.put("Song 8", "4:42");
        songMapWithDuration.put("Song 9", "3:12");
        songMapWithDuration.put("Song 10", "5:21");
        return songMapWithDuration;
    }

    public static List<MediaAlbum> getMusicAlbumsByType(MediaType mediaType) {
        List<MediaAlbum> albums = new ArrayList<>();
        for (MediaAlbum album : albumList) {
            if (mediaType.equals(album.getMediaType())) {
                albums.add(album);
            }
        }
        return albums;
    }

    public static MediaAlbum getByArtistNameAndAlbum(String artistName, String albumName) {
        for (MediaAlbum album : albumList) {
            if (album.getArtistName().equalsIgnoreCase(artistName) && album.getAlbumName().equalsIgnoreCase(albumName)) {
                return album;
            }
        }
        throw new IllegalArgumentException("Not found");
    }
}
