package InnerClassesChallenge;

import java.util.ArrayList;
import java.util.Optional;

public class Album {
    private final String albumTitle;
    private final String artist;
    private SongList songlist;

    Album(String albumTitle, String artist) {
        this.albumTitle = albumTitle;
        this.artist = artist;
        this.songlist = new SongList();
    }

    public boolean addSong(Song song) {
        return this.songlist.addSong(song);
    }

    Optional<Song> getSong(String songTitle) {
        return this.songlist.getSong(songTitle);
    }

    private class SongList {
        private ArrayList<Song> songs;

        SongList() {
            this.songs = new ArrayList<>();
        }

        boolean addSong(Song song) {
            if(!this.doesSongExist(song.getSongTitle())) {
                this.songs.add(song);
                return true;
            } else {
                System.out.println("A song with that title already exists in this album!");
                return false;
            }
        }

        boolean doesSongExist(String songTitle) {
            return this.songs.stream().anyMatch(song -> song.getSongTitle().equals(songTitle));
        }

        Optional<Song> getSong(String songTitle) {
            if (this.doesSongExist(songTitle)) {
                return this.songs.stream().filter(song -> song.getSongTitle().equals(songTitle)).findAny();
            }
            System.out.println("No song with that title exists in this album!");
            return Optional.empty();
        }
    }

    String getAlbumTitle() {
        return albumTitle;
    }

    String getArtist() {
        return artist;
    }
}
