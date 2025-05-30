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
        displayBoard();
    }
    public void prepare() {
        setPiece(0, 0, new Rook("White"));
        setPiece(0, 1, new Knight("White"));
        setPiece(0, 2, new Bishop("White"));
        setPiece(0, 3, new Queen("White"));
        setPiece(0, 4, new King("White"));
        setPiece(0, 5, new Bishop("White"));
        setPiece(0, 6, new Knight("White"));
        setPiece(0, 7, new Rook("White"));
        for (int i = 0; i<8; i++) {
            setPiece(1, i, new Pawn("White"));
            setPiece(6, i, new Pawn("Black"));
        }
        setPiece(6, 0, new Rook("Black"));
        setPiece(6, 1, new Knight("Black"));
        setPiece(6, 2, new Bishop("Black"));
        setPiece(6, 3, new Queen("Black"));
        setPiece(6, 4, new King("Black"));
        setPiece(6, 5, new Bishop("Black"));
        setPiece(6, 6, new Knight("Black"));
        setPiece(6, 7, new Rook("Black"));
    }
    public void setPiece(int row, int col, Piece p) {
        board[row][col] = p;
    }
    public void displayBoard() {
        for (Piece[] row: board) {
            for (Piece current: row) {
                if (current != null) {
                int[] loc = current.getLoc();
                int r = loc[0]+1;
                int c = loc[1]+1;
                addObject(current, r*80-40, c*80-40);
                }
            }
        }
    }
    public Piece[][] getBoard() {
        return board;
    }
    public int[] calcMoveLoc() {
    int temp[] = new int[1];
    return temp;
    }
    public int updateBoard() {
        ArrayList<Piece> = Greenfoot.getActors();
    }
}
