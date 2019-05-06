package LinkedListChallenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistTest {
    private Playlist testPlaylist = new Playlist("testPlaylist");
    private Song testSong = new Song("testSong", 1.00);
    private Song testSongTwo = new Song("testSongTwo", 2.00);

    @Test
    public void addSong() {
        // Should be able to add a song to playlist
        testPlaylist.addSong(testSong);
        assertEquals(testSong, testPlaylist.getSongs().get(0));
    }

    @Test
    public void songOrder() {
        // Playlist should reflect order that songs are added
        testPlaylist.addSong(testSong);
        testPlaylist.addSong(testSongTwo);
        assertEquals(testSong, testPlaylist.getSongs().get(0));
        assertEquals(testSongTwo, testPlaylist.getSongs().get(1));
    }
}