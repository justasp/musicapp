package com.example.android.musicapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.musicapp.AlbumInformationActivity;
import com.example.android.musicapp.R;

import java.util.List;

public class MediaAlbumAdapter extends RecyclerView.Adapter<MediaAlbumAdapter.ViewHolder> {

    private List<MediaAlbum> albums;
    private Context context;

    public MediaAlbumAdapter(Context context, List<MediaAlbum> albums) {
        this.albums = albums;
        this.context = context;
    }

    @NonNull
    @Override
    public MediaAlbumAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rowItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        rowItem.setOnClickListener(view -> {
            TextView albumNameTextView = rowItem.findViewById(R.id.album_name);
            TextView artistNameTextView = rowItem.findViewById(R.id.artist_name);
            Intent intent = new Intent(this.context, AlbumInformationActivity.class);
            intent.putExtra("albumName", albumNameTextView.getText());
            intent.putExtra("artistName", artistNameTextView.getText());
            context.startActivity(intent);
        });
        return new ViewHolder(rowItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MediaAlbumAdapter.ViewHolder holder, int position) {
        holder.artist.setText(this.albums.get(position).getArtistName());
        holder.album.setText(this.albums.get(position).getAlbumName());
        holder.albumCover.setImageResource(R.drawable.gandalf);
    }

    @Override
    public int getItemCount() {
        return this.albums.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView artist;
        TextView album;
        ImageView albumCover;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            artist = itemView.findViewById(R.id.artist_name);
            album = itemView.findViewById(R.id.album_name);
            albumCover = itemView.findViewById(R.id.album_cover_m);
        }
    }
}


