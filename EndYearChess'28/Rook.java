import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
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
    }
    public void linearMove(int row, int col) {
        
    }
    public void promoteTo() {
        
    }
}
