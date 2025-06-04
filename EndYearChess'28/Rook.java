import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
//test
/**
 * Write a description of class Rook here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rook extends Piece implements LinearMovement, PromotableTo
{
    public Rook(String color) {
        super(color, 5);
    }
    /**
     * Act - do whatever the Rook wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    public boolean isLegalMove(int startRow, int startCol, int targetRow, int targetCol, Piece[][] board) {
        return true;
    }
     public ArrayList<int[]> getMoves() {
        ArrayList<int[]> possibleMoves = new ArrayList<>();
        int x = getLoc()[0];
        int y = getLoc()[1];
        ChessWorld w = (ChessWorld)(getWorld());
        for (int i = 0; i < 8; i++) {
            if (w.getBoard()[i][y] == null || !this.getColor().equals(w.getBoard()[i][y].getColor())) {
                int[] add = {i, y};
                possibleMoves.add(add);
            }
            if (w.getBoard()[x][i] == null|| !this.getColor().equals(w.getBoard()[x][i].getColor())) {
                int[] add = {x, i};
                possibleMoves.add(add);
            }
        }
        ((ChessWorld)getWorld()).showMarkers(possibleMoves, this);
        return possibleMoves;
    }
    public void linearMove(int row, int col) {
        
    }
    public void promoteTo() {
        
    }
}
