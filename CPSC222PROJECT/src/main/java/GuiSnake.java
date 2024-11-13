
import java.awt.Color;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author muham
 */
public class GuiSnake implements slitherable, Runnable {

    private ArrayList<GuiCircle> snake;
    private int color;
    private int Player;
    private Thread thread;

    private int boardh;
    private int boardl;
    private GameFrame gameframe;
    private int direction;//up=1,right=2,down=3,left=4
    private GuiCircle head;
    private GuiCircle tail;
    private boolean up;
    private boolean right;
    private boolean down;
    private boolean left;
    private boolean running;
    private boolean correlated;
    private volatile int cpumov;
    private volatile int cpucheck;
    private Random rand;
    private boolean epileptic;

    public boolean isEpileptic() {
        return epileptic;
    }

    public void setEpileptic(boolean epileptic) {
        this.epileptic = epileptic;
    }

    public void epilepticSwitch() {
        if (this.isEpileptic()) {
            this.setEpileptic(false);
        } else {
            this.setEpileptic(true);
        }
    }

    public Random getRand() {
        return rand;
    }

    @Override
    public void run() {
        while (running) {
            if (this.isHuman()) {
                this.humanControl();
            } else {
                this.cpuControl();
            }
        }
        if (!running) {
            System.out.println("  SNAKE HAS STOPPED SNAE HAS STOPPED SNAE HAS STOPPED SNAE HAS STOPPED SNAE HAS STOPPEDV SNAE HAS STOPPEDV SNAE HAS STOPPEDSNAE HAS STOPPEDSNAE HAS STOPPED");
        }

    }

    public synchronized void cpuControl() {
        while (this.isUp()) {
            try {

                Thread.sleep(100);
                this.travel(1);
                this.getGameframe().repaint();
            } catch (InterruptedException ex) {
                Logger.getLogger(GuiSnake.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (this.canEat()) {
                System.out.println("FOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOD");
                this.Eat();

            }
//            cpumov++;
//           this.cpuChangeDirection();
        }
        while (this.isRight()) {
            try {
                Thread.sleep(100);
                this.travel(2);
                this.getGameframe().repaint();
            } catch (InterruptedException ex) {
                Logger.getLogger(GuiSnake.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (this.canEat()) {
                System.out.println(
                        "FOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOD");
                this.Eat();

            }
//            cpumov++;
//            
//           this.cpuChangeDirection();

        }
        while (this.isDown()) {
            try {
                Thread.sleep(100);
                this.travel(3);
                this.getGameframe().repaint();
            } catch (InterruptedException ex) {
                Logger.getLogger(GuiSnake.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (this.canEat()) {
                System.out.println(
                        "FOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOD");
                this.Eat();
            }
//            cpumov++;
//            this.cpuChangeDirection();
        }
        while (this.isLeft()) {
            try {
                Thread.sleep(100);
                this.travel(4);
                this.getGameframe().repaint();
            } catch (InterruptedException ex) {
                Logger.getLogger(GuiSnake.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (this.canEat()) {
                System.out.println(
                        "FOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOD");
                this.Eat();
            }
//            cpumov++;
//            this.cpuChangeDirection();

            if (!running) {
                System.out.println("  SNAE HAS STOPPED SNAE HAS STOPPED SNAE HAS STOPPED SNAE HAS STOPPED SNAE HAS STOPPEDV SNAE HAS STOPPEDV SNAE HAS STOPPEDSNAE HAS STOPPEDSNAE HAS STOPPED");
            }
        }
    }

    public synchronized void humanControl() {
        while (this.isUp()) {
            try {

                Thread.sleep(100);
                this.travel(1);
                this.getGameframe().repaint();
            } catch (InterruptedException ex) {
                Logger.getLogger(GuiSnake.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (this.canEat()) {
                System.out.println("FOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOD");
                this.Eat();

            }
        }
        while (this.isRight()) {
            try {
                Thread.sleep(100);
                this.travel(2);
                this.getGameframe().repaint();
            } catch (InterruptedException ex) {
                Logger.getLogger(GuiSnake.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (this.canEat()) {
                System.out.println(
                        "FOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOD");
                this.Eat();

            }
        }
        while (this.isDown()) {
            try {
                Thread.sleep(100);
                this.travel(3);
                this.getGameframe().repaint();
            } catch (InterruptedException ex) {
                Logger.getLogger(GuiSnake.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (this.canEat()) {
                System.out.println(
                        "FOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOD");
                this.Eat();
            }
        }
        while (this.isLeft()) {
            try {
                Thread.sleep(100);
                this.travel(4);
                this.getGameframe().repaint();
            } catch (InterruptedException ex) {
                Logger.getLogger(GuiSnake.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (this.canEat()) {
                System.out.println(
                        "FOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOD");
                this.Eat();
            }
        }
    }

    public boolean isHuman() {
        return this.getGameframe().getPrep().getPlayers().get(this.getPlayer() - 1).isHuman();
    }

    public boolean isFoodinRangeX() {
        boolean a = this.head.getXorigin() <= (this.getGameframe().getFood().getShape().getX() + 5);// if the head is within 10 pixels from the food to the right
        boolean b = this.head.getXorigin() >= (this.getGameframe().getFood().getShape().getX() - 5);// if the head is within 10 pixels from the food to the left

        return b && a;
    }

    public boolean isFoodinRangeY() {

        boolean a = this.head.getYorigin() <= (this.getGameframe().getFood().getShape().getY() + 5);// if the head is within 10 pixels from the food  upwards
        boolean b = this.head.getYorigin() >= (this.getGameframe().getFood().getShape().getY() - 5);// if the head is within 10 pixels from the food to the downwards

        return b && a;

    }

    public boolean canEat() {

        return this.isFoodinRangeX() && this.isFoodinRangeY();
    }

    public void setCorrelated(boolean cor) {
        this.correlated = cor;
    }

    public boolean isCorrelated() {
        return this.correlated;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getPlayer() {
        return Player;
    }

    public boolean isUp() {
        return up;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread() {
        this.thread = new Thread(this);
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public GameFrame getGameframe() {
        return gameframe;
    }

    public void setGameframe(GameFrame gameframe) {
        this.gameframe = gameframe;
    }

    public int getBh() {
        return boardh;
    }

    public void setBh(int bh) {
        this.boardh = bh;
    }

    public int getBl() {
        return boardl;
    }

    public void setBl(int bl) {
        this.boardl = bl;
    }

    public String toString() {
        return String.format("%s \n color: %d\n direction: %d\n", this.getSnake(), this.getColor(), this.getDirection());
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        if (color <= 4) {
            this.color = color;
        } else {
            this.color = 1;
        }
    }

    public ArrayList<GuiCircle> getSnake() {
        return snake;
    }

    public GuiCircle getHead() {
        return head;
    }

    public Color getGuiColor() {
        Color x = Color.BLACK;
        switch (this.getColor()) {
            case 1:
                x = Color.GREEN;
                break;
            case 2:
                x = Color.yellow;
                break;

            case 3:
                x = Color.magenta;
                break;
            case 4:
                x = Color.black;
                break;

        }
        return x;

    }

    public GuiSnake(int color, int rank, int bh, int bl) {
        this.snake = new ArrayList<GuiCircle>();
        this.color = color;
        this.Player = rank;
        for (int i = 100; i >= 1; i -= 10) {

            snake.add(new GuiCircle(i, rank * 100));

        }
        for (int j = 0; j < snake.size(); j += 1) {
            switch (j) { //assigning each circle  previous and next circle to aid corelation
                case 0://first case
                    snake.get(j).setNext(snake.get(j + 1));
                    snake.get(j).setPrevious(snake.get(j)); //Make its previous itslef to alway make correlation true
                    break;
                case 9: //last case
                    snake.get(j).setPrevious(snake.get(j - 1));
                    snake.get(j).setNext(snake.get(j));//Make its next itslef to always make correlation true
                    break;

                default: // all other cases

                    snake.get(j).setNext(snake.get(j + 1));
                    snake.get(j).setPrevious(snake.get(j - 1));

            }
            //DON'T BOTHER PRINTING GUI CIRCLES BECAUSE THEY WILL RECURSIVELY CALL LEADING TO A NULL POINTER AND STACK OVERFLOW

        }
        this.rand = new Random();
        this.head = snake.get(0);
        head.setHead(true);
        this.tail = snake.get(9);
        tail.setTail(true);

        this.boardh = bh;

        this.boardl = bl;

        this.direction = 2;//right

        this.right = true;

        this.running = true;
        this.correlated = true;

    }

    public static ArrayList<GuiSnake> makeSnakes(Preparation prep, ArrayList<Player> players, GameFrame gf) {
        ArrayList<GuiSnake> snakes = new ArrayList<GuiSnake>();
        for (Player x : players) {
            snakes.add(new GuiSnake(x.getRank() % 5, x.getRank(), prep.getBoardlength(), prep.getBoardheight()));

        }
        for (GuiSnake x : snakes) {
            x.setGameframe(gf);
            x.setThread();
            x.getThread().start();// starting thread

        }
        // System.out.println("Snakes are made");
        return snakes;
    }

    @Override
    public void moveRight() {
        if (this.correlateCheck()) {
            if (this.inRange()) {

                this.setDirection(2);
                this.setDown(false);
                this.setLeft(false);
                this.setUp(false);
                this.setRight(true);

                this.getGameframe().repaint();
            }
        }
    }

    @Override
    public void moveLeft() {
        if (this.correlateCheck()) {
            if (this.inRange()) {

                this.setDirection(4);
                this.setDown(false);
                this.setRight(false);
                this.setUp(false);
                this.setLeft(true);
                // System.out.println(this);
                this.getGameframe().repaint();
            }
        }

    }

    @Override
    public void moveUp() {
        if (this.correlateCheck()) {
            if (this.inRange()) {

                this.setDirection(1);
                this.setDown(false);
                this.setLeft(false);
                this.setRight(false);
                this.setUp(true);
                //   System.out.println(this);
                this.getGameframe().repaint();
            }
        }

    }

    public boolean inRange() {
        for (GuiCircle x : this.getSnake()) {
            if (x.getXorigin() < 10 || x.getXorigin() > (this.getGameframe().getFramelength() - 10)) {
                return false;
            }
            if (x.getYorigin() < 10 || x.getXorigin() > (this.getGameframe().getFrameheight() - 10)) {
                return false;

            }
        }
        return true;
    }

    @Override
    public void moveDown() {
        if (this.correlateCheck()) {
            if (inRange()) {
                this.setDirection(3);
                this.setLeft(false);
                this.setRight(false);
                this.setUp(false);
                this.setDown(true);
                // System.out.println(this);
                this.getGameframe().repaint();
            }
        }
    }

    @Override
    public void Eat() {
        this.getGameframe().getFood().setEaten(true);// confirm food was eaten
        this.getGameframe().getPrep().getScore().addScore(this.getPlayer());//incremnt score of snake
        System.out.println(this.getGameframe().getPrep().getScore());
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        int x = this.getGameframe().getPrep().getScore().getPlayers().get(this.getPlayer() - 1).getScore(); // get score of this snake
        this.snake.get(x - 1).fillCircle(); //color next cirlc to represent score
        this.gameframe.repaint(100);

        if (checkWinner()) {
            this.getGameframe().stopGame();
        }
    }

    public void correlate(GuiCircle circle) {
        circle.travel(direction); // keep going in previous direction of the snake

    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public boolean correlateCheck() {
        for (GuiCircle x : this.getSnake()) {
            if (x.getDirection() != this.getHead().getDirection()) {
                return false;
            }
        }
        return true;

    }

    public synchronized boolean checkWinner() {
        return this.getGameframe().getPrep().getScore().isWinner(this.getPlayer());
    }

    //There is a problem with correlation and movement they do not move one by one
    public synchronized void travel(int direc) {

        for (GuiCircle x : this.getSnake()) {
            System.out.println("Next Circle");
            switch (direc) {

                case 1://Up
                    System.out.print("going up");
                    if (x.isXCorrelated()) {// check if this circle and head correlated
                        // System.out.println("It is correlated with previous");
                        if (x.getYorigin() >= 1) { // check if circle is within border of frame
                            // System.out.println("It is not at end of board, keep going");
                            x.travel(direc);// shift up
                            System.out.println("It has moved up");
                        } else {
                            x.setYorigin(this.getBh() - 10);// start at beggining of board
                            //  System.out.println("It is at end of board, put at beggining");
                        }
                    } else {
                        this.setCorrelated(false);
                        this.correlate(x);// correlate this circle and the head 
                        // System.out.println("not in place for movevemnt, correlate it");

                    }

                    x.setShape(new Ellipse2D.Double(x.getXorigin(), x.getYorigin(), 10, 10));
                    break;
                case 2://right
                    System.out.print("going right");
                    if (x.isYCorrelated()) {// check if this circle and head correlated
                        //   System.out.println("It is correlated with previous");
                        if (x.getXorigin() < this.getBl()) {
                            //   System.out.println("It is not at end of board, keep going");
                            x.travel(direc);// shift right
                            //      System.out.println("It has moved up");

                        } else {
                            x.setXorigin(1);// start at beggining of board
                            System.out.println("It is at end of board, put at beggining");
                        }

                    } else {
                        this.setCorrelated(false);
                        this.correlate(x);// correlate this circle and the head 
                        System.out.println("not in place for movevemnt, correlate it");

                    }

                    x.setShape(new Ellipse2D.Double(x.getXorigin(), x.getYorigin(), 10, 10));

                    break;
                case 3: //move down
                    System.out.print("going down");
                    if (x.isXCorrelated()) {// check if this circle and head correlated
                        //System.out.println("It is correlated with previous");
                        if (x.getYorigin() < this.getBh()) {
                            //          System.out.println("It is not at end of board, keep going");
                            x.travel(direc);// shift down
                            //            System.out.println("It has moved up");

                        } else {
                            x.setYorigin(1);
                            //          System.out.println("It is at end of board, put at beggining");
                        }
                    } else {
                        this.setCorrelated(false);
                        this.correlate(x);// correlate this circle and the head 
                        //         System.out.println("not in place for movevemnt, correlate it");

                    }
                    x.setShape(new Ellipse2D.Double(x.getXorigin(), x.getYorigin(), 10, 10));
                    break;
                case 4: // move left
                    System.out.print("going left");
                    if (x.isYCorrelated()) {// check if this circle and head correlated
                        //           System.out.println("It is correlated with previous");
                        if (x.getXorigin() > 1) {
                            //            System.out.println("It is not at end of board, keep going");
                            x.travel(direc);// shift left
                            System.out.println("It has moved up");
                        } else {
                            x.setXorigin(this.getBl() - 10);// start at beggining of board
                            //               System.out.println("It is at end of board, put at beggining");
                        }
                    } else {
                        this.setCorrelated(false);
                        this.correlate(x);// correlate this circle and the head 
                        //       System.out.println("not in place for movevemnt, correlate it");

                    }
                    x.setShape(new Ellipse2D.Double(x.getXorigin(), x.getYorigin(), 10, 10));
                    break;

            }

        }

        if (this.correlateCheck()) {// if all circles int the snake are correlated then change the direction of the snake
            this.setCorrelated(true);
            this.setDirection(direc);
            System.out.println("The snake is aligned and the direction has fully changed");
        }
        if (this.isEpileptic()) {
            this.setColor(color + 1);
        }
    }

    public static void main(String[] args) {
        //  GuiSnake a= new GuiSnake(1,2,100,100);
    }

}
