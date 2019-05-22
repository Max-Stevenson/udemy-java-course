package GenericsChallenge;

import java.util.ArrayList;
import java.util.Collections;

public class League <T extends Team> {
    private ArrayList<T> league;
    private String name;

    public League(String name) {
        this.name = name;
        this.league = new ArrayList<>();
    }

    public boolean addTeam(T t) {
        if (this.league.contains(t)) {
            System.out.println(t.getName() +  " is already present in league");
            return false;
        } else {
            this.league.add(t);
            return true;
        }
    }

    public void showLeageTable(){
        Collections.sort(league);
        for (T t : league) {
            System.out.println(t.getName() + ": " + t.getRanking());
        }
    }
}
