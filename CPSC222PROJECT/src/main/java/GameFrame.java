
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.black;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author muham
 */
public class GameFrame extends JFrame implements KeyListener {

    private GuiPlay eatPanel;
    private JPanel scorePanel;
    private int frameheight;
    private int framelength;
    private GuiFood Food;
    private Preparation prep;
   
//    public GameFrame(GuiPlay eatPanel, Preparation prep) {
//        JFrame gameFrame = new JFrame("Game");
//        this.prep = prep;
//        this.eatPanel = eatPanel;
//        this.frameheight = prep.getBoardheight();
//        this.framelength = prep.getBoardlength();
//        gameFrame.setSize(frameheight, framelength);
//        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        gameFrame.add(this.eatPanel);
//        gameFrame.setVisible(true);
//    }

    public GameFrame(Preparation prep) {
//BACKGROUND IS NOT SHOWING CHECK PREP AND FRAME CLASS
        super("Game");
      
     
        this.prep = prep;
        this.Food = prep.getFood();
        this.frameheight = prep.getBoardheight();
        this.framelength = prep.getBoardlength();
        this.addKeyListener(this);
        this.setSize(frameheight, framelength);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       

    }

    public Preparation getPrep() {
        return prep;
    }

    public GuiPlay getEatPanel() {
        return eatPanel;
    }

    public void setEatPanel(GuiPlay eatPanel) {
        this.eatPanel = eatPanel;
    }

    public JPanel getScorePanel() {
        return scorePanel;
    }

    public void setScorePanel(JPanel scorePanel) {
        this.scorePanel = scorePanel;
    }

    public int getFramelength() {
        return framelength;
    }

    public void setFramelength(int framelength) {
        this.framelength = framelength;
    }

    public int getFrameheight() {
        return frameheight;
    }

    public GuiFood getFood() {
        return Food;
    }

    public void setFood(GuiFood Food) {
        this.Food = Food;
    }

    public void stopGame() {// game is not stopping properly fix this
        for (GuiSnake x : this.getEatPanel().getSnakes()) {
            x.setRunning(false);
            x.setDown(false);
            x.setUp(false);
            x.setRight(false);
            x.setLeft(false);
        }
        System.out.println("STOTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
    }

    //FIND WAY TO IMPLEMENT SA LISTENER THAT XATCHES ANDEVENT FOR WHEN THE HEAD OF A SNAKE INTERSECTS WITH FOOD.
    public static void startstuff2(int num) {
        Preparation prep = Preparation.prepGame(num, 1, 800, 800, 3);
        GameFrame a = new GameFrame(prep);

        GuiPlay play = new GuiPlay(a, prep, GuiSnake.makeSnakes(prep, prep.getPlayers(), a));

        a.setEatPanel(play);


        a.add(a.getEatPanel());
         
        a.setVisible(true);

    }

    @Override
    public void keyTyped(KeyEvent e) {

        System.out.println("You pressed key char" + e.getKeyCode());
        switch (e.getKeyCode()) {
            case 38:
                this.getEatPanel().getSnakes().get(0).moveUp();

                break;
            case 39:
                this.getEatPanel().getSnakes().get(0).moveRight();

                break;
            case 40:
                this.getEatPanel().getSnakes().get(0).moveDown();

                break;
            case 37:
                this.getEatPanel().getSnakes().get(0).moveLeft();

                break;

        }
        switch (e.getKeyChar()) {
            case 'r':
                this.stopGame();
              Game.startGame(this.getEatPanel().getSnakes().size());
                break;
            case 'e': //make snakes epileptic
                for (int i = 1; i < this.eatPanel.getSnakes().size(); i++) {
                    GuiSnake x = this.eatPanel.getSnakes().get(i);
                    x.epilepticSwitch();

                }

        }
    }

    public synchronized void randomize() {
        for (int i = 1; i < this.eatPanel.getSnakes().size(); i++) {
            GuiSnake x = this.eatPanel.getSnakes().get(i);
            int num = x.getRand().nextInt(4) + 1;

            switch (num) {
                case 1:
                    if (x.correlateCheck()) {
                        x.moveUp();
                    }
                    break;
                case 2:
                    if (x.correlateCheck()) {
                        x.moveRight();
                    }
                    break;
                case 3:
                    if (x.correlateCheck()) {
                        x.moveDown();
                    }
                    break;
                case 4:
                    if (x.correlateCheck()) {
                        x.moveDown();
                    }
                    break;
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("You pressed key char" + e.getKeyCode());
        switch (e.getKeyCode()) {
            case 38:
                this.getEatPanel().getSnakes().get(0).moveUp();
                this.randomize();
                break;
            case 39:
                this.getEatPanel().getSnakes().get(0).moveRight();
                this.randomize();
                break;
            case 40:
                this.getEatPanel().getSnakes().get(0).moveDown();
                this.randomize();
                break;
            case 37:
                this.getEatPanel().getSnakes().get(0).moveLeft();
                this.randomize();
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("You released key char" + e.getKeyChar());

    }

    public static void main(String[] args) {
        startstuff2(5);
    }
    // fix the movement of the snake

}
