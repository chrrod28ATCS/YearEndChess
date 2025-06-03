import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Pawn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pawn extends Piece implements LinearMovement, DiagonalMovement
{
    private boolean isFirstTurn;
    public Pawn(String color) {
        super(color, 1);
        GreenfootImage img = getImage();
        img.scale(img.getWidth()/2, img.getHeight()/2);
        setImage(img);
        isFirstTurn = true;
    }
    /**
     * Act - do whatever the Pawn wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        handleDrag();
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
    public boolean checkFirstTurn() {
        return isFirstTurn;
    }
    public void setFirstTurn(boolean first) {
        isFirstTurn = first;
    }
    public boolean handleDrag() {
        boolean hasMoved = super.handleDrag();
        if (hasMoved) {
            setFirstTurn(false);
        }
        return hasMoved;
    }
}
