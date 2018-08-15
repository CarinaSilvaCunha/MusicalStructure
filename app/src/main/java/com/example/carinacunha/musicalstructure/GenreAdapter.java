package com.example.carinacunha.musicalstructure;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GenreAdapter extends ArrayAdapter<Genre> {

    // Inflate Layout
    public GenreAdapter(Activity context, ArrayList<Genre> genre) {
        super(context, 0, genre);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Verify is the view is being used, if null, inflate view
        View genrelistView = convertView;
        if (genrelistView == null) {
            genrelistView = LayoutInflater.from(getContext()).inflate(
                    R.layout.genre_items, parent, false);
        }
        // From the Genre, get the object position
        Genre currentGenre = getItem(position);
        // Pass info to the genre_items.xml - genreText TextView
        TextView genreTextView = genrelistView.findViewById(R.id.genreText);
        // Get the current genre name with get from Genre and set on the TextView
        assert currentGenre != null;
        genreTextView.setText(currentGenre.getGenreName());

        // Get the current genre picture with the get and set it on the ImageView
        ImageView genrePictureImageView = genrelistView.findViewById(R.id.songPicture);
        genrePictureImageView.setImageResource(currentGenre.getGenrePicture());

        // Return all information
        return genrelistView;
    }
}
