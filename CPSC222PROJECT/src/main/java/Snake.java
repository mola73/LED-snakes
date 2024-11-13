/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author muham
 */
public class Snake implements slitherable {

    private int length;
    private int foodcount;
    private boolean human;
    private int Rank;

    public Snake(boolean human, int rank) {
        this.length = 3;
        this.foodcount = 0;
        this.human = human;
        this.Rank = rank;
    }

    public Snake(int Rank) {
        this.Rank = Rank;
    }

    public String toString() {
        return String.format("SNAKE%d: \n Length of Snake:%d\n #of food(s) eaten:%d, \n Is Human?: %b\n Rank: %d\n\n", this.getRank(), this.getLength(), this.getFoodcount(), this.isHuman(), this.getRank());
    }

    public static Snake makeSnakeh(int rank) {
        return new Snake(true, rank);
    }

    public static Snake makeSnakecpu(int rank) {
        return new Snake(false, rank);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getRank() {
        return Rank;
    }

    public void setRank(int Rank) {
        this.Rank = Rank;
    }

    public int getFoodcount() {
        return foodcount;
    }

    public void setFoodcount(int foodcount) {
        this.foodcount = foodcount;
    }

    public boolean isHuman() {
        return human;
    }

    public void setHuman(boolean human) {
        this.human = human;
    }

    @Override
    public void moveRight() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void moveLeft() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void moveUp() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void moveDown() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Eat() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void travel(int direc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
