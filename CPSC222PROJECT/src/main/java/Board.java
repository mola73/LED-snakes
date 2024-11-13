/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author muham
 */
public class Board {

    private int length;
    private int height;

    public Board(int height, int length) {
        this.length = length;
        this.height = height;
    }

    public String toString() {
        return String.format("Length: %d\n Height: %d \n", this.getLength(), this.getHeight());
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
