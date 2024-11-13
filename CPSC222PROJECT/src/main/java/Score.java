
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author muham
 */
public class Score {

    private ArrayList<Player> players;
    private int winScore;

    public Score(ArrayList<Player> players, int score) {
        this.players = players;
        this.winScore = score;
    }

    public String toString() {
        return String.format("%s\n\n", this.getPlayers());
    }

    public void addScore(int rank) { // increments the score of a player by 1
        getPlayers().get(rank - 1).increment();
    }

    public boolean isWinner(int rank) {
        System.out.printf(".....................................................................Score:%d\n Win score: %d\n", this.getPlayers().get(rank - 1).getScore(), this.getWinScore());
        return this.getPlayers().get(rank - 1).getScore() >= this.getWinScore();
    }

    public int getWinScore() {
        return winScore;
    }

    public void setWinScore(int winnScore) {
        this.winScore = winnScore;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

}
