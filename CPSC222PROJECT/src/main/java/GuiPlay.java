
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author muham
 */
public class GuiPlay extends JComponent {

    private ArrayList<GuiSnake> snakes;
    private Preparation prep;
    private GameFrame gf;
    private boolean sponned;
    private GuiFood food;
    private Image background;

    public ArrayList<GuiSnake> getSnakes() {
        return snakes;
    }

    public String toString() {
        return String.format("%s\n", snakes);
    }

    public GuiPlay(GameFrame gf, Preparation prep, ArrayList<GuiSnake> snakelist) {// Cinsider in making a copy insted ofe xtending the pointer
        this.background= new ImageIcon(prep.getBackground()).getImage();// get image of background, little compilcation with Image abstract class decleration
        this.snakes = new ArrayList<GuiSnake>();
        this.prep = prep;
        this.gf = gf;
        for (GuiSnake x : snakelist) {
            snakes.add(x);
        }
        this.food = prep.getFood();

    }

    public GameFrame getGf() {
        return gf;
    }

    public void setGf(GameFrame gf) {
        this.gf = gf;
    }

    public Preparation getPrep() {
        return prep;
    }

//    public synchronized void travel() throws InterruptedException{
//        for( GuiSnake a: snakes){
//            a.travel(1);
//  
//      
//     
//       
//      
//       
//       
//     
//           
//       }
//    }
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
  
        for (GuiSnake a : snakes) {
            g2.setColor(a.getGuiColor());
            for (GuiCircle x : a.getSnake()) {

                if (x.ruColored()) {
                    g2.draw(x.getShape());
                    g2.fill(x.getShape());
                } else {
                    g2.draw(x.getShape());
                }

            }
            g2.setColor(Color.BLACK);

            g2.fill(this.getFood().getShape());

            g2.draw(this.getFood().getShape());

        }
         g2.drawImage(background, 0, 0,null);

    }

    public GuiFood getFood() {
        return food;
    }

}
