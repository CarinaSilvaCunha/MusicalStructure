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

public class SongList extends AppCompatActivity implements ListView.OnItemClickListener {

    private String intentMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_layout);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            intentMessage = bundle.getString("message");
        }
        // Get available songs list
        getSongsList();
    }

    // Creates content for the app
    public void getSongsList() {
        ArrayList<Song> songList = new ArrayList<>();
        if (intentMessage.equals(getString(R.string.rock))) {
            // Add song
            songList.add(new Song(getString(R.string.queenBohemian), getString(R.string.queen), R.drawable.queen));
            songList.add(new Song(getString(R.string.ledZeppelinStarway), getString(R.string.ledZeppelin), R.drawable.ledzepplin));
            songList.add(new Song(getString(R.string.nirvanaSmells), getString(R.string.nirvana), R.drawable.nirvana));
        }
        if (intentMessage.equals(getString(R.string.pop))) {
            // Add song
            songList.add(new Song(getString(R.string.britneyToxic), getString(R.string.britney), R.drawable.britneyspears));
            songList.add(new Song(getString(R.string.duaNew), getString(R.string.dua), R.drawable.dualipa));
            songList.add(new Song(getString(R.string.demiHeart), getString(R.string.demi), R.drawable.demilovato));
        }
        if (intentMessage.equals(getString(R.string.classical))) {
            // Add song
            songList.add(new Song(getString(R.string.charlesAve), getString(R.string.charles), R.drawable.charlesgounod));
            songList.add(new Song(getString(R.string.gustavFive), getString(R.string.gustav), R.drawable.gustavmahler));
            songList.add(new Song(getString(R.string.vivaldiFour), getString(R.string.vivaldi), R.drawable.antoniovivaldi));
        }
        // Connect the SongAdapter to the object created
        SongAdapter songAdapter = new SongAdapter(this, songList);

        // Connect the ListView created with the respective layout
        ListView listView = findViewById(R.id.songLayout);

        // Connect the Listview with the adapter
        assert listView != null;
        listView.setAdapter(songAdapter);
        // Connect the setOnItemClickListener with the listview.
        listView.setOnItemClickListener(this);
    }

    // Get the ListView item with the SongList and the genre layout, send everything to the CurrentlyPlaying
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        final Context context = this;
        String intentSongs;

        TextView songSelected = view.findViewById(R.id.currentSong);
        String songChosenPlay = songSelected.getText().toString();

        TextView artistSelected = view.findViewById(R.id.artist);
        String artistChosenPlay = artistSelected.getText().toString();

        intentSongs = artistChosenPlay + " + " + songChosenPlay;
        Intent intent = new Intent(context, CurrentlyPlaying.class);
        intent.putExtra("message", intentSongs);
        startActivity(intent);
    }
}