package LinkedListChallenge;

import java.util.ArrayList;
import java.util.Optional;

public class MediaPlayer {
    private ArrayList<Album> albums;
    private ArrayList<Playlist> playlists;

    public MediaPlayer() {
        this.albums = new ArrayList<>();
        this.playlists = new ArrayList<>();
    }

    public void addSongToPlaylist(String songTitle, String albumTitle, String albumArtist, String playlistName) {
         this.getAlbum(albumTitle, albumArtist).ifPresent
                 (album -> album.getSong(songTitle).ifPresent
                         (song -> this.getPlaylist(playlistName).ifPresent
                                 (playlist -> playlist.addSong(song))));
    }

    public void addAlbum(Album album) {
        if(!doesAlbumExist(album.getAlbumTitle(), album.getArtist())) {
            this.albums.add(album);
        }
    }

    boolean doesAlbumExist(String albumTitle, String albumArtist) {
        return this.albums.stream()
                .anyMatch(album -> albumTitle.equals(album.getAlbumTitle()) && albumArtist.equals(album.getArtist()));
    }

    boolean doesPlaylistExist(String playlistName) {
        return this.playlists.stream()
                .anyMatch(playlist -> playlistName.equals(playlist.getPlaylistName()));
    }

    public Optional<Album> getAlbum(String albumTitle, String albumArtist) {
        if (doesAlbumExist(albumTitle, albumArtist)) {
            return this.albums.stream().filter(album -> albumTitle.equals(album.getAlbumTitle())).findAny();
        }
        System.out.println("Album: " + albumTitle + " by: " + albumArtist + " does not exist!");
        return Optional.empty();
    }

    public void showAlbums() {
        this.albums.stream().forEach(album -> System.out.println(album.getAlbumTitle() +": "+ album.getArtist()));
    }

    public Optional<Playlist> getPlaylist(String playlistName) {
        if (doesPlaylistExist(playlistName)) {
            return this.playlists.stream().filter(playlist -> playlistName.equals(playlist.getPlaylistName())).findAny();
        }
        System.out.println("Playlist: " + playlistName + " does not exist!");
        return Optional.empty();
    }

    public void createNewPlaylist(String playlistName) {
        this.playlists.add(new Playlist(playlistName));
    }


}
