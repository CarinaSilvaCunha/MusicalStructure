package com.example.carinacunha.musicalstructure;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class SongAdapter extends ArrayAdapter<Song> {

    // Inflate Layout
    public SongAdapter(Activity context, ArrayList<Song> song) {
        super(context, 0, song);
    }

    public View getView(int position, View inflateView, ViewGroup parent) {
        // Verify is the view is being used, if null, inflate view
        View songListView = inflateView;
        if (songListView == null) {
            songListView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_items, parent, false);
        }

        // From the Song, get the object position
        Song currentlyPlayingSong = getItem(position);
        // Pass info to the the songTextView and the song_items.xml
        TextView songTextView = songListView.findViewById(R.id.currentSong);
        // Get the current song name with get from Song and set on the TextView
        assert currentlyPlayingSong != null;
        songTextView.setText(currentlyPlayingSong.getSongName());
        // Get the artist name
        TextView currentlyPlayingArtistName = songListView.findViewById(R.id.artist);
        String currentlyArtist = currentlyPlayingSong.getArtistName();

        currentlyPlayingArtistName.setText(currentlyArtist);

        // Get the ImageView to the song_items.xml
        ImageView currentArtistPicture = songListView.findViewById(R.id.songPicture);

        // Get the current song picture
        currentArtistPicture.setImageResource(currentlyPlayingSong.getArtistPicture());

        // Return all information
        return songListView;
    }
}