package GenericsChallenge;

public class GenericsChallengeApp {
    public static void main(String[] args) {
        League<Team> worldCup = new League<>("World Cup");
        SoccerPlayer player1 = new SoccerPlayer("Harry Kane");
        RugbyPlayer player2 = new RugbyPlayer("Johnny Wilkinson");
        Team<SoccerPlayer> englandSoccer = new Team<>("England");
        Team<RugbyPlayer> englandRugby = new Team<>("England");
        englandSoccer.addPlayer(player1);
    }
}
