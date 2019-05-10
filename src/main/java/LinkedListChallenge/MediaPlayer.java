package LinkedListChallenge;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

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

    public void playPlaylist(String playlistName) {
        Scanner scanner = new Scanner(System.in);
        AtomicBoolean quit = new AtomicBoolean(false);
        AtomicBoolean forward = new AtomicBoolean(true);
        Optional<Playlist> playlist = this.getPlaylist(playlistName);
        ListIterator<Song> listIterator = null;
        if (playlist.isPresent()) {
             listIterator = playlist.get().getSongs().listIterator();
        }
        ListIterator<Song> finalListIterator = listIterator;
        playlist.ifPresent(p -> {
            if (!p.getSongs().isEmpty()) {
                System.out.println("Now Playing " + finalListIterator.next().toString());
            } else {
                System.out.println("No songs in playlist!");
            }
            while (!quit.get()){
                int action = scanner.nextInt();
                scanner.nextLine();

                switch (action) {
                    case 0:
                        System.out.println("Playlist complete");
                        quit.set(true);
                        break;
                    case 1:
                        if (!forward.get()) {
                            if(finalListIterator.hasNext()) {
                                finalListIterator.next();
                            }
                            forward.set(true);
                        }
                        if (finalListIterator.hasNext()) {
                            System.out.println("Now Playing " + finalListIterator.next().toString());
                        } else {
                            System.out.println("End of playlist " + p.getPlaylistName());
                            forward.set(false);
                        }
                        break;
                    case 2:
                        if (forward.get()) {
                            if (finalListIterator.hasPrevious()) {
                                finalListIterator.previous();
                            }
                            forward.set(false);
                        }
                        if (finalListIterator.hasPrevious()) {
                            System.out.println("Now Playing " + finalListIterator.previous().toString());
                        } else {
                            System.out.println("Start of playlist " + p.getPlaylistName());
                            forward.set(true);
                        }
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;

                }
            }
        });
    }


}
