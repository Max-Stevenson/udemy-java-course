package LinkedListChallenge;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Optional;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class MediaPlayerTest {
    private MediaPlayer testMediaPlayer = new MediaPlayer();
    private Album testAlbum = new Album("testAlbum", "testArtist");
    private Song testSong = new Song("testSong", 1.00);


    @Test
    void doesAlbumExist() {
        //Should return true for albums that exist and false for those that don't
        testMediaPlayer.addAlbum(testAlbum);
        assertTrue(testMediaPlayer.doesAlbumExist("testAlbum", "testArtist"));
        assertFalse(testMediaPlayer.doesAlbumExist("nonExistent", "testArtist"));
    }

    @Test
    void getAlbum() {
        //Should return the specified album
        //Should return an Optional.empty() for non existent albums
        testMediaPlayer.addAlbum(testAlbum);
        Optional <Album> albumOptional = testMediaPlayer.getAlbum("testAlbum", "testArtist");
        albumOptional.ifPresent(album -> assertEquals(testAlbum, album));
        assertEquals(Optional.empty(), testMediaPlayer.getAlbum("nonExistent", "testArtist"));
    }

    @Test
    void addSongToPlaylist() {
        testAlbum.addSong(testSong);
        testMediaPlayer.addAlbum(testAlbum);
        testMediaPlayer.createNewPlaylist("testPlaylist");
        testMediaPlayer.addSongToPlaylist("testSong",
                "testAlbum", "testArtist", "testPlaylist");
        assertEquals(testSong, testMediaPlayer.getPlaylist("testPlaylist").get().getSongs().get(0));
    }
}