package LinkedListChallenge;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

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
        testMediaPlayer.addAlbum(testAlbum);
        Optional <Album> albumOptional = testMediaPlayer.getAlbum("testAlbum", "testArtist");
        albumOptional.ifPresent(album -> assertEquals(testAlbum, album));
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