package LinkedListChallenge;

import java.util.ArrayList;
import java.util.Optional;

public class Album {
    private final String albumTitle;
    private final String artist;
    private final ArrayList<Song> songs;

    public Album(String albumTitle, String artist) {
        this.albumTitle = albumTitle;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean doesSongExist(String songTitle) {
        return this.songs.stream().anyMatch(song -> songTitle.equals(song.getSongTitle()));
    }

    public boolean addSong(Song song) {
        if(!doesSongExist(song.getSongTitle())) {
            this.songs.add(song);
            return true;
        } else {
            System.out.println("A song with that title already exists in this album!");
            return false;
        }
    }

    public Optional<Song> getSong(String songTitle) {
        if (doesSongExist(songTitle)) {
            return this.songs.stream().filter(x -> songTitle.equals(x.getSongTitle())).findAny();
        }
        System.out.println("No song with that title exists in this album!");
        return Optional.empty();
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public String getArtist() {
        return artist;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }
}
