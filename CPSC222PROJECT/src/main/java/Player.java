/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author muham
 */
public class Player {

    Snake snake;
    private int eatennum;
    private boolean Human;
    private int rank;
    private int score;

    public Player(Snake x) {
        this.Human = x.isHuman();
        this.eatennum = 0;
        this.snake = x;
        this.rank = x.getRank();

    }

    public Player() {
        this.Human = false;
        this.eatennum = 0;
        this.snake = null;
        this.rank = 0;
    }

    public String toString() {
        return String.format("PLAYER%d: \n %s\nScore:%d\n\n", this.getRank(), this.getSnake(), this.getScore());
    }

    public static Player makePlayer(Snake x) {
        return new Player(x);
    }

    public void increment() {
        this.setScore(score + 1);
        this.getSnake().setFoodcount(score);

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public int getEatennum() {
        return eatennum;
    }

    public void setEatennum(int eatennum) {
        this.eatennum = eatennum;
    }

    public boolean isHuman() {
        return Human;
    }

    public void setHuman(boolean Human) {
        this.Human = Human;
    }

}
