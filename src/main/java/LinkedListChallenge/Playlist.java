package LinkedListChallenge;

import java.util.LinkedList;

public class Playlist {
    private String playlistName;
    private LinkedList<Song> songs;

    public Playlist(String playlistName) {
        this.playlistName = playlistName;
        songs = new LinkedList<>();
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public LinkedList<Song> getSongs() {
        return songs;
    }
}
