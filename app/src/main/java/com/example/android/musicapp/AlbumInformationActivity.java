package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.musicapp.adapter.MediaAlbum;
import com.example.android.musicapp.adapter.SongListAdapter;

import static com.example.android.musicapp.MediaFixture.getByArtistNameAndAlbum;

public class AlbumInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_information);
        Intent intent = getIntent();
        String artistName = (String) intent.getExtras().get("artistName");
        String albumName = (String) intent.getExtras().get("albumName");
        MediaAlbum album = getByArtistNameAndAlbum(artistName, albumName);

        TextView artistNameTextView = findViewById(R.id.album_info_artist_name);
        artistNameTextView.setText(album.getArtistName());

        TextView albumNameTextView = findViewById(R.id.album_info_album_name);
        albumNameTextView.setText(album.getAlbumName());

        TextView releaseDateTextView = findViewById(R.id.album_info_release_date);
        releaseDateTextView.setText(album.getReleaseDate());

        ImageView albumCover = findViewById(R.id.album_info_album_cover);
        albumCover.setImageResource(R.drawable.gandalf); //For testing didn't wanted to upload a lot of photos

        LinearLayoutManager podcastLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView songList = findViewById(R.id.album_info_song_list);
        songList.setLayoutManager(podcastLayoutManager);
        songList.setAdapter(new SongListAdapter(album.getSongMap()));

    }
}
