package LinkedListChallenge;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Predicate;

public class MediaPlayer {
    private ArrayList<Album> albums;
    private ArrayList<Playlist> playlists;

    public MediaPlayer() {
        this.albums = new ArrayList<>();
        this.playlists = new ArrayList<>();
    }

    public void addSongToPlaylist(String songTitle, String albumTitle, String playlistTitle) {
    }

    public void addAlbum(Album album) {
        if(!doesAlbumExist(album.getAlbumTitle(), album.getArtist())) {
            this.albums.add(album);
        }
    }

    public boolean doesAlbumExist(String albumTitle, String albumArtist) {
        return this.albums.stream()
                .anyMatch(album -> albumTitle.equals(album.getAlbumTitle()) && albumArtist.equals(album.getArtist()));
    }

    public Optional<Album> getAlbum(String albumTitle, String albumArtist) {
        if (doesAlbumExist(albumTitle, albumArtist)) {
            return this.albums.stream().filter(album -> albumTitle.equals(album.getAlbumTitle())).findAny();
        }
        return Optional.empty();
    }

    public void showAlbums() {
        this.albums.stream().forEach(album -> System.out.println(album.getAlbumTitle() +": "+ album.getArtist()));
    }

}
