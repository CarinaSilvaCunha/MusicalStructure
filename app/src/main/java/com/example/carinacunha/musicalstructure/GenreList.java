package com.example.carinacunha.musicalstructure;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class GenreList extends AppCompatActivity implements ListView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.genre_layout);

        // Create genres to be handled by the app
        final ArrayList<Genre> genre = new ArrayList<>();
        genre.add(new Genre(getString(R.string.rock), R.drawable.rock));
        genre.add(new Genre(getString(R.string.pop), R.drawable.pop));
        genre.add(new Genre(getString(R.string.classical), R.drawable.classical));

        // Connect the GenreAdapter to the object created
        GenreAdapter genreAdapter = new GenreAdapter(this, genre);

        // Connect the ListView created with the respective layout
        ListView listView = findViewById(R.id.genreLayout);

        // Connect the Listview with the adapter
        assert listView != null;
        listView.setAdapter(genreAdapter);

        // Connect the setOnItemClickListener with the listview.
        listView.setOnItemClickListener(this);
    }

    // Get the ListView item with the SongList and the genre layout
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final Context context = this;

        TextView genreTextViewOnClick = view.findViewById(R.id.genreText);
        String genreTextDisplay = genreTextViewOnClick.getText().toString();

        Intent intent = new Intent(context, SongList.class);
        intent.putExtra("message", genreTextDisplay);
        startActivity(intent);
    }
}