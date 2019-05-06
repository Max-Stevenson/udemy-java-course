package LinkedListChallenge;

public class Song {

    private final String songTitle;
    private final double duration;

    public Song(String songTitle, double duration) {
        this.songTitle = songTitle;
        this.duration = duration;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public double getDuration() {
        return duration;
    }
}
