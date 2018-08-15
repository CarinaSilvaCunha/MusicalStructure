package com.example.carinacunha.musicalstructure;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.media.AudioManager.STREAM_MUSIC;

public class CurrentlyPlaying extends AppCompatActivity implements View.OnClickListener {
    private ImageButton play;
    private ImageButton stop;
    private ImageButton pause;
    private String artistPlay;
    private String songPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[] intentMessage;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currently_playing);
        setContentView(R.layout.currently_playing);
        setVolumeControlStream(STREAM_MUSIC);

        play = findViewById(R.id.currentPlayButton);
        pause = findViewById(R.id.pauseButton);
        stop = findViewById(R.id.stopButton);
        ImageButton goHome = findViewById((R.id.goHomeButton));

        // Set OnClickListeners on buttons
        play.setOnClickListener(this);
        stop.setOnClickListener(this);
        pause.setOnClickListener(this);

        // Get info from List
        Bundle bundle = getIntent().getExtras();

        // Treat intent
        String intents = null;
        if (bundle != null) {
            intents = bundle.getString("message");
        }

        // Receives name and artist
        assert intents != null;
        intentMessage = intents.split("\\+");
        artistPlay = intentMessage[0];
        songPlay = intentMessage[1];

        playingNow();

        //This brings the user back to the home screen
        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backSongs = new Intent(CurrentlyPlaying.this, SongList.class);
                CurrentlyPlaying.this.startActivity(backSongs);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // goHome
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void playingNow() {

        //Artist Name
        String artistCurrentPlayName = artistPlay.replaceAll(" ", "").toLowerCase();

        //get the artist atributtes
        ImageView playArtistPicture = findViewById(R.id.artistPicture);
        TextView playCurrentSong = findViewById(R.id.currentSong);
        TextView playCurrentArtist = findViewById(R.id.artist);

        //get the picture
        Context context = getApplicationContext();
        int id = context.getResources().getIdentifier("drawable/" + artistCurrentPlayName, null, context.getPackageName());
        playArtistPicture.setImageResource(id);

        //Show song and artist name
        playCurrentSong.setText(songPlay);
        playCurrentArtist.setText(artistPlay);
    }

    //On click play, pausing and stopping
    @Override
    public void onClick(View v) {
        if (v.equals(play)) {
            Toast.makeText(this, getString(R.string.play), Toast.LENGTH_SHORT).show();
        }
        if (v.equals(pause)) {
            Toast.makeText(this, getString(R.string.pause), Toast.LENGTH_SHORT).show();
        }
        if (v.equals(stop)) {
            Toast.makeText(this, getString(R.string.stop), Toast.LENGTH_SHORT).show();
        }
    }

}
