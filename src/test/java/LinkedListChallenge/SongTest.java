package LinkedListChallenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {
    private String songTitle = "testSong";
    private double songDuration = 2.00;
    private Song testSong = new Song(songTitle, songDuration);

    @Test
    void getSongTitle() {
        assertEquals(songTitle, testSong.getSongTitle());
    }

    @Test
    void getDuration() {
        assertEquals(songDuration, testSong.getDuration());
    }

    @Test
    void toStringTest() {
        String expected = songTitle + ": " + songDuration;
        assertEquals(expected, testSong.toString());
    }
}