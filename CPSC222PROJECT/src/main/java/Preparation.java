
import java.awt.Image;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author muham
 */
public class Preparation {

    private Board board;
    private int playernum;
    private int boardlength;
    private Score score;
    private int boardheight;
    private ArrayList<Player> players;
    private GuiFood food;
  private ImageIcon background;

    public GuiFood getFood() {
        return food;
    }

    public void setFood(GuiFood food) {
        this.food = food;
    }

    public Preparation(Board board, int playernum, Score score, ArrayList<Player> p)  {
        this.board = board;
        this.playernum = playernum;
        this.players = p;
        this.score = score;
        this.boardlength = board.getLength();
        this.boardheight = board.getHeight();
        this.food = new GuiFood(boardheight, boardlength);
        
        this.background= new ImageIcon("snake game background.jpg");
       
    }

    public Image getBackground() {
        return background.getImage();
    }
   

    public void setBackground(Image background) {
        this.background.setImage(background);
    }

    public int getBoardheight() {
        return boardheight;
    }

    public void setBoardheight(int boardheight) {
        this.boardheight = boardheight;
    }

    public String toString() {
        return String.format("BOARD :\n%s\n Players: \n%s\n\n ", this.getBoard(), this.getPlayers());
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getPlayernum() {
        return playernum;
    }

    public void setPlayernum(int playernum) {
        this.playernum = playernum;
    }

    public int getBoardlength() {
        return boardlength;
    }

    public void setBoardlength(int boardlength) {
        this.boardlength = boardlength;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public static Preparation prepGame(int playernum, int humans, int boardlength, int boardheight, int winscore) {

        int num = humans;
        ArrayList<Player> players = new ArrayList<Player>();
        for (int i = 1; i <= playernum; i++) {// Make players dependng on if they are human or not.
            if (num > 0) {// cpu
                players.add(Player.makePlayer(Snake.makeSnakeh(i)));
            } else {// human
                players.add(Player.makePlayer(Snake.makeSnakecpu(i)));
            }
            num--;
        }
        Score score = new Score(players, winscore);
        Board board = new Board(boardheight, boardlength);
       
        return new Preparation(board, players.size(), score, players);
    }

    public static void main(String[] args) { // Make making players, snakes, list of snakes automatic
        System.out.println(prepGame(2, 1, 500, 500, 5));
    }
}
