package LinkedListChallenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MediaPlayerTest {
    private MediaPlayer testMediaPlayer = new MediaPlayer();
    private Album testAlbum = new Album("testAlbum", "testArtist");

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
        assertEquals(testAlbum, testMediaPlayer.getAlbum("testAlbum", "testArtist").get());
    }
}