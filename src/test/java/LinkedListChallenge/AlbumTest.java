package LinkedListChallenge;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class AlbumTest {
    private Album testAlbum = new Album("testAlbum", "testArtist");
    private Song testSong = new Song("testSong", 1.00);

    @Test
    void doesSongExist() {
        // Should return true for songs that exist and false for those that don't
        testAlbum.addSong(testSong);
        assertTrue(testAlbum.doesSongExist("testSong"));
        assertFalse(testAlbum.doesSongExist("nonExistent"));
    }

    @Test
    void addSong() {
        // Should not be able to add same song twice
        testAlbum.addSong(testSong);
        assertEquals(testSong, testAlbum.getSongs().get(0));
        assertFalse(testAlbum.addSong(testSong));
    }

    @Test
    void getSong() {
        // Should return a song if it exists and null if it doesn't
        testAlbum.addSong(testSong);
        assertEquals(testSong, testAlbum.getSong("testSong").get());
        assertEquals(Optional.empty(), testAlbum.getSong("nonExistent"));
    }
}