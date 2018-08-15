package com.example.carinacunha.musicalstructure;

public class Song {

    // Song Name
    private String songName;
    // Artist Name
    private String artistName;
    // Artist Picture
    private int artistPicture;

    /**
     * Create new Song
     *
     * @param songName      - Name of the Song
     * @param artistName    - Name of the Artist
     * @param artistPicture - ID of the picture
     */
    public Song(String songName, String artistName, int artistPicture) {
        this.songName = songName;
        this.artistName = artistName;
        this.artistPicture = artistPicture;
    }

    // Get and Set song Name
    public String getSongName() {
        return songName;
    }

    //This method is not used. Only in here as demonstrative.
    public void setSongName(String songName) {
        this.songName = songName;
    }

    // Get and Set artist Name
    public String getArtistName() {
        return artistName;
    }

    //This method is not used. Only in here as demonstrative.
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    // Get and Set artist Picture
    public int getArtistPicture() {
        return artistPicture;
    }

    public void setArtistPicture(int artistPicture) {
        this.artistPicture = artistPicture;
    }
}
