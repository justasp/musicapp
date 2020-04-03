package com.example.android.musicapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.musicapp.R;

import java.util.Map;

public class SongListAdapter extends RecyclerView.Adapter<SongListAdapter.ViewHolder> {

    private Map<String, String> songMap;

    public SongListAdapter(Map<String, String> songMap) {
        this.songMap = songMap;
    }

    @NonNull
    @Override
    public SongListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rowItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_list_item, parent, false);
        return new ViewHolder(rowItem);
    }

    @Override
    public void onBindViewHolder(@NonNull SongListAdapter.ViewHolder holder, int position) {
        String songName = (String) songMap.keySet().toArray()[position];
        String duration = songMap.get(songName);
        holder.songNameTextView.setText(songName);
        holder.durationTextView.setText(duration);
    }

    @Override
    public int getItemCount() {
        return songMap.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView songNameTextView;
        TextView durationTextView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            songNameTextView = itemView.findViewById(R.id.song_name);
            durationTextView = itemView.findViewById(R.id.song_duration);
        }
    }
}
