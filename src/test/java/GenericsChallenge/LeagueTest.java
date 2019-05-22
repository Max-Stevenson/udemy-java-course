package GenericsChallenge;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class LeagueTest {
    private League<Team<SoccerPlayer>> worldCup = new League<>("World Cup");
    private Team<SoccerPlayer> englandSoccer = new Team<>("England");
    private Team<SoccerPlayer> germanSoccer = new Team<>("Germany");
    private SoccerPlayer player1 = new SoccerPlayer("Harry Kane");
    private SoccerPlayer player2 = new SoccerPlayer("Manuel Neuer");

    @Test
    void addTeam() {
        // Should only be able to add a team once to the league
        englandSoccer.addPlayer(player1);
        assertTrue(worldCup.addTeam(englandSoccer));
        assertFalse(worldCup.addTeam(englandSoccer));
    }

    @Test
    void showLeageTable() {
        // Should System out the teams in order of ranking
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        worldCup.addTeam(englandSoccer);
        worldCup.addTeam(germanSoccer);
        englandSoccer.scoreMatch(germanSoccer, 2, 1);

        String expected = "England: 2\nGermany: 0\n";
        worldCup.showLeageTable();
        assertEquals(expected, outContent.toString());

        System.setOut(originalOut);
    }
}