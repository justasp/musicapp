package com.example.android.musicapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.musicapp.adapter.MediaAlbumAdapter;
import com.example.android.musicapp.adapter.MediaType;

import static com.example.android.musicapp.MediaFixture.getMusicAlbumsByType;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayoutManager recommendedAlbumsLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recommendedAlbumsList = findViewById(R.id.recommended_albums_list);
        recommendedAlbumsList.setLayoutManager(recommendedAlbumsLayoutManager);
        recommendedAlbumsList.setAdapter(new MediaAlbumAdapter(this, getMusicAlbumsByType(MediaType.MUSIC_ALBUM)));

        LinearLayoutManager bestForWeekAlbumsLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView bestForWeekAlbumsList = findViewById(R.id.best_for_week_album_list);
        bestForWeekAlbumsList.setLayoutManager(bestForWeekAlbumsLayoutManager);
        bestForWeekAlbumsList.setAdapter(new MediaAlbumAdapter(this, getMusicAlbumsByType(MediaType.MUSIC_ALBUM)));

        LinearLayoutManager podcastLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView podcastList = findViewById(R.id.podcast_list);
        podcastList.setLayoutManager(podcastLayoutManager);
        podcastList.setAdapter(new MediaAlbumAdapter(this, getMusicAlbumsByType(MediaType.PODCAST)));
    }

}
