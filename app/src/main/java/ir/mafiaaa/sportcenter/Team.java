package ir.mafiaaa.sportcenter;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;

import java.util.ArrayList;

/**
 * Created by ARG on 9/14/2017 - 10:33 PM
 */

public class Team implements Comparable<Team>
{
    private String name;
    private Coach coach;
    private int ranking;
    private Leagues league;
    private Bitmap logo;
    private ArrayList<Player> players;
    public static Team myTeam;

    public Team()
    {
        coach = new Coach();
        players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coach getCoach() {
        return coach;
    }

    public Bitmap getLogo() {
        return logo;
    }

    public static Team getMyTeam() {
        return myTeam;
    }

    public static void setMyTeam(Team myTeam) {
        Team.myTeam = myTeam;
    }

    public void setLogo(Bitmap logo) {
        this.logo = logo;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public Leagues getLeague() {
        return league;
    }

    public void setLeague(Leagues league) {
        this.league = league;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    @Override
    public int compareTo(@NonNull Team team) {
        return this.ranking - team.getRanking();
    }

    @Override
    public String toString() {
        return ranking + " - " + name;
    }
}
