import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private Piece[][] board = new Piece[8][8];
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640, 640, 1);
    }
    public void prepare() {
        board[0][0] = new Rook("White");
        
        for (int i = 0; i<8; i++) {
            setPiece(1, i, new Pawn("White"));
            setPiece(6, i, new Pawn("Black"));
        }
    }
    public void setPiece(int row, int col, Piece p) {
        board[row][col] = p;
    }
}
