import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
//test
/**
 * Write a description of class Queen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Queen extends Piece implements DiagonalMovement, LinearMovement, PromotableTo
{
    //test
    public Queen(String color) {
        super(color, 9);
    }
    /**
     * Act - do whatever the Queen wants to do. This method is called whenever
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
    public void linearMove(int row, int col) {
    
    }
    public void promoteTo() {
        
    }
}
