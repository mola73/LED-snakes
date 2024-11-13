
import java.awt.Rectangle;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author muham
 */
public class GuiFood {

    private Rectangle shape;
    private boolean eaten;
    private static Random rand = new Random();
    private final int boardheight;
    private final int boardlength;

    public GuiFood(Rectangle food, boolean eaten, int bh, int bl) {
        this.shape = food;
        this.eaten = eaten;
        this.boardheight = bh;
        this.boardlength = bl;
    }

    public GuiFood(int bh, int bl) {
        this.boardheight = bh;
        this.boardlength = bl;
        int boxY = rand.nextInt(bh - 30) + 10; //PUT BAKC INTO RADNOM
        int boxX = rand.nextInt(bl - 30) + 10;
        this.shape = new Rectangle(boxX, boxY, 10, 10);
        this.eaten = false;
    }

    public static GuiFood sponFood(int bh, int bl) {
        return new GuiFood(bh, bl);
    }

    public Rectangle getShape() {
        return shape;
    }

    public void setShape(Rectangle shape) {
        this.shape = shape;
    }

    public boolean isEaten() {
        return eaten;
    }

    public void resetShape() {
        this.setShape(sponFood(boardlength, boardheight).getShape());
        this.setEaten(false);
    }

    public void setEaten(boolean eaten) {// chnage this to spn food outside fofood class
        this.eaten = eaten;

        if (this.eaten == true) {
            this.resetShape();
        }

    }

}
