package LinkedListChallenge;

public class LinkedListChallengeApp {
    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        Album albumOne = new Album("testAlbum", "testArtist");
        Album albumTwo = new Album("testAlbumTwo", "testArtistTwo");
        mediaPlayer.addAlbum(albumOne);
        mediaPlayer.addAlbum(albumTwo);
        mediaPlayer.showAlbums();
    }
}
