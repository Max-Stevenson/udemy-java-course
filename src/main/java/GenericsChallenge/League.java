package GenericsChallenge;

import java.util.ArrayList;

public class League <T extends Team> {
    private ArrayList<T> league;
    private String name;

    public League(String name) {
        this.name = name;
        this.league = new ArrayList<>();
    }

    public void addTeam(T t) {
        this.league.add(t);
    }
}
