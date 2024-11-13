
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author muham
 */
public class GuiCircle extends Ellipse2D.Double {
    // make method to chnage direction of circle movement

    private boolean colored;
    private Shape circle;
    private int xorigin;
    private int yorigin;
    private int direction;
    private GuiCircle next;
    private boolean head;
    private boolean tail;

    public boolean isXCorrelated() {
        return this.getPrevious().getXorigin() == this.getXorigin();
    }

    public boolean isYCorrelated() {
        return this.getPrevious().getYorigin() == this.getYorigin();
    }

    public boolean isTail() {
        return tail;
    }

    public void setTail(boolean tail) {
        this.tail = tail;
    }

    public boolean isHead() {
        return head;
    }

    public void setHead(boolean head) {
        this.head = head;
    }

    public GuiCircle getNext() {
        return next;
    }

    public String toString() {
        return String.format("Cricle:\n coordinates:(%d,%d)\nprevious: %s\n next:%s \n ", this.getXorigin(), this.getYorigin(), this.getPrevious(), this.getNext());
    }

    public void setNext(GuiCircle next) {
        this.next = next;
    }

    public void setPrevious(GuiCircle previous) {
        this.previous = previous;
    }

    public GuiCircle getPrevious() {
        return previous;
    }
    private GuiCircle previous;

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getXorigin() {
        return xorigin;
    }

    public void setXorigin(int xorigin) {
        this.xorigin = xorigin;
    }

    public int getYorigin() {
        return yorigin;
    }

    public void setYorigin(int yorigin) {
        this.yorigin = yorigin;
    }

    public GuiCircle(int xorigin, int yorigin) {
        colored = false;
        circle = new Ellipse2D.Double(xorigin, yorigin, 10, 10);
        this.xorigin = xorigin;
        this.yorigin = yorigin;
        // System.out.println(this);
    }

    public void setShape(Shape circle) {
        this.circle = circle;
    }
   

    public GuiCircle getCircle() {
        return this;
    }

    public boolean ruColored() {
        return this.colored;
    }

    public Shape getShape() {
        return this.circle;

    }

    public void fillCircle() {
        this.colored = true;
        System.out.println("Circle filled");
    }

    public void travel(int direc) {
        switch (direc) {
            case 1:
                this.moveUp();
                break;
            case 2:
                this.moveR();
                break;
            case 3:
                this.moveD();
                break;
            case 4:
                this.moveL();
                break;

        }

    }

    public void moveUp() {
        //  System.out.printf("Circle before! \n %s\n----\n", this);
        this.setYorigin(yorigin - 10);
        this.setDirection(1);
        // System.out.printf("Circle moved! \n %s\n", this);

    }

    public void moveR() {
        //  System.out.printf("Circle before! \n %s\n----\n", this);
        this.setXorigin(xorigin + 10);
        this.setDirection(2);
        //  System.out.printf("Circle moved! \n %s\n", this);
    }

    public void moveD() {
        //  System.out.printf("Circle before! \n %s\n----\n", this);
        this.setYorigin(yorigin + 10);
        this.setDirection(3);

        // System.out.printf("Circle moved! \n %s\n", this);
    }

    public void moveL() {
        //  System.out.printf("Circle before! \n %s\n----\n", this);
        this.setXorigin(xorigin - 10);
        this.setDirection(4);
        //  System.out.printf("Circle moved! \n %s\n", this);
    }

    public static void main(String[] args) {
//        GuiCircle a= new GuiCircle(10,10);
//        System.out.println(a);
    }
}
