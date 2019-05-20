package GenericsChallenge;

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>> {

    private String name;
    private ArrayList<T> members = new ArrayList<>();
    private int gamesPlayed = 0;
    private int gamesWon = 0;
    private int gamesLost = 0;
    private int gamesTied = 0;

    public Team (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean addPlayer (T player) {
        if (members.contains(player)) {
            System.out.println(player.getName() + " is already on this team!");
            return false;
        } else {
            members.add(player);
            System.out.println(player.getName() + " added to team!");
            return true;
        }
    }

    public int getTeamSize() {
        return this.members.size();
    }

    public int getRanking() {
        return (this.gamesWon * 2) + this.gamesTied;
    }

    public void scoreMatch(Team<T> opponent, int ownScore, int opponentScore) {
        this.gamesPlayed ++;
        if (ownScore > opponentScore) {
            this.gamesWon ++;
        } else if (opponentScore > ownScore) {
            this.gamesLost ++;
        } else {
            this.gamesTied ++;
        }
        if (opponent != null) {
            opponent.scoreMatch(null, opponentScore, ownScore);
        }
    }

    @Override
    public int compareTo(Team<T> team) {
        if (this.getRanking() > team.getRanking()) {
            return -1;
        } else if (this.getRanking() < team.getRanking()) {
            return 1;
        } else {
            return 0;
        }
    }
}
