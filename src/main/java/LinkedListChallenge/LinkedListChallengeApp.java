package LinkedListChallenge;

public class LinkedListChallengeApp {
    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        Album albumOne = new Album("testAlbum", "testArtist");
        Album albumTwo = new Album("testAlbumTwo", "testArtistTwo");
        Song songOne = new Song("song1", 1.00);
        Song songTwo = new Song("song2", 2.00);
        albumOne.addSong(songOne);
        albumTwo.addSong(songTwo);
        mediaPlayer.addAlbum(albumOne);
        mediaPlayer.addAlbum(albumTwo);
        mediaPlayer.createNewPlaylist("testPlaylist");
        mediaPlayer.addSongToPlaylist(
                "song1",
                "testAlbum",
                "testArtist",
                "testPlaylist");
        mediaPlayer.addSongToPlaylist(
                "song2",
                "testAlbumTwo",
                "testArtistTwo",
                "testPlaylist");
        mediaPlayer.playPlaylist("testPlaylist");

    }
}
