package GenericsChallenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {
    private String teamName = "Test Team";
    private Team<Player> testTeam = new Team<>(teamName);
    private Team<Player> opponentTestTeam = new Team<>(teamName);
    private Player testPlayer = new Player("Test Player");

    @Test
    void getName() {
        assertEquals(teamName, testTeam.getName());
    }

    @Test
    void addPlayer() {
        // Can only add a player once per team
        testTeam.addPlayer(testPlayer);
        assertFalse(testTeam.addPlayer(testPlayer));
    }

    @Test
    void getTeamSize() {
        // Should return total players in team
        testTeam.addPlayer(testPlayer);
        assertEquals(1, testTeam.getTeamSize());
    }

    @Test
    void getRanking() {
        // Implicit testing of scoreMatch()
        // Should return (gamesWon * 2) + gamesTied
        testTeam.scoreMatch(opponentTestTeam, 1, 0);
        testTeam.scoreMatch(opponentTestTeam, 1,1);
        assertEquals(3, testTeam.getRanking());

    }

    @Test
    void compareTo() {
        testTeam.scoreMatch(opponentTestTeam, 1, 0);
        testTeam.scoreMatch(opponentTestTeam, 1,1);
        assertEquals(-1, testTeam.compareTo(opponentTestTeam));
        assertEquals(1, opponentTestTeam.compareTo(testTeam));
        opponentTestTeam.scoreMatch(testTeam, 1, 0);
        assertEquals(0, testTeam.compareTo(opponentTestTeam));


    }
}