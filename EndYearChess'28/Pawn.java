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
        ChessWorld w = ((ChessWorld)(getWorld()));
        Piece[][] b = w.getBoard();
        int[] pieceLoc = getLoc();
        int row = pieceLoc[0];
        int col = pieceLoc[1];
        ArrayList<int[]> possibleMoves = new ArrayList<>();
        if (getColor().equals("White")) {
            if (isFirstTurn) {
                if (w.inBounds(row+2, col)) {
                    if (b[row + 2][col] == null) {
                        int[] pos = {row+2, col};
                        possibleMoves.add(pos);
                    } 
                }
            }
            if (w.inBounds(row+1, col)) {
                    if (b[row+1][col] == null) {
                    int[] pos = {row+1, col};
                    possibleMoves.add(pos);
                }
            }
            if (w.inBounds(row+1, col+1)) {
                if (b[row+1][col+1] != null && !b[row+1][col+1].getColor().equals(this.getColor())) {
                    int[] pos = {row+1, col+1};
                    possibleMoves.add(pos);
                }
            }
            if (w.inBounds(row+1, col-1)) {
                if (b[row+1][col-1] != null && !b[row+1][col-1].getColor().equals(this.getColor())) {
                    int[] pos = {row+1, col-1};
                    possibleMoves.add(pos);
                }
            }
        } else {
            if (isFirstTurn) {
                if(b[row-2][col] == null) {
                    int[] pos = {row-2, col};
                    possibleMoves.add(pos);
                }
            }
            if (w.inBounds(row-1, col)) {
                    if (b[row-1][col] == null) {
                    int[] pos = {row-1, col};
                    possibleMoves.add(pos);
                }
            }
            if (w.inBounds(row-1, col+1)) {
                    if (b[row-1][col+1] != null && !b[row-1][col+1].getColor().equals(this.getColor())) {
                    int[] pos = {row-1, col+1};
                    possibleMoves.add(pos);
                }
            }
            if (w.inBounds(row -1, col-1)) {
                    if (b[row-1][col-1] != null && !b[row-1][col+1].getColor().equals(this.getColor())) {
                    int[] pos = {row-1, col+1};
                    possibleMoves.add(pos);
                } 
            }
        }
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
}
