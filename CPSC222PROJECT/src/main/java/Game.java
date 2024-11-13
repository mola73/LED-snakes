

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author muham
 */
public class Game {

    private Preparation prep;

    public static void startGame(int x) {
GameFrame.startstuff2(x);// parameter of number of snakes
    }
    

//    public  String EndGame(){
//        
//    }
    public Game(Preparation prep) {
        this.prep = prep;

    }
    

    public Preparation getPrep() {
        return prep;
    }

    public void setPrep(Preparation prep) {
        this.prep = prep;
    }

    public static void main(String[] args) { // Make making players, snakes, list of snakes automatic
startGame(7);
    }

}
