
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author muham
 */
public class Shape extends JComponent {

    public void paintComponenet(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK); //make this dpendent on rank with swithc statement
        Ellipse2D.Double ellipse = new Ellipse2D.Double(10, 10, 100, 100);
        g2.draw(ellipse);
    }
}
