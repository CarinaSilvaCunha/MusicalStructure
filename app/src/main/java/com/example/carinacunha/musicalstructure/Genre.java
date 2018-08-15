package com.example.carinacunha.musicalstructure;

public class Genre {

    // Name of the Genre
    private String genreName;

    // Picture representative of the genre
    private int genrePicture;

    /**
     * Create a new Genre
     * @param genreName    is the name of the music genre
     * @param genrePicture is the id of the music genre picture
     */
    public Genre(String genreName, int genrePicture) {
        this.genreName = genreName;
        this.genrePicture = genrePicture;
    }

    // Get and Set for the Name of the Genre
    public String getGenreName() {
        return genreName;
    }

    //This method is not used. Only in here as demonstrative.
    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    // Get and Set for the Picture
    public Integer getGenrePicture() {
        return genrePicture;
    }

    // This method is not used. Only in here as demonstrative.
    public void setGenrePicture(int genrePicture) {
        this.genrePicture = genrePicture;
    }

}
