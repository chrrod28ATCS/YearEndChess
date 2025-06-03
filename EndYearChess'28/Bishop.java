import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Bishop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bishop extends Piece implements DiagonalMovement, PromotableTo
{
    public Bishop(String color) {
        super(color, 3);
    }
    /**
     * Act - do whatever the Bishop wants to do. This method is called whenever
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
        return possibleMoves;
    }
    public void diagonalMove() {
        
    }
    public void diagonalCapture() {
        
    }
    public void promoteTo() {
        
    }
}
