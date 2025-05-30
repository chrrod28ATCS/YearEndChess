import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChessWorld extends World
{
    private Piece[][] board = new Piece[8][8];
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public ChessWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640, 640, 1);
        displayBoard();
    }
    public void act() {
        prepare();
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
    public boolean setPiece(int row, int col, Piece p) {
        if(board[row][col] != null && board[row][col].getColor().equals(p.getColor())) {
            return false;
        }
        board[row][col] = p;
        return true;
    }
    public void displayBoard() {
        for (Piece[] row: board) {
            for (Piece current: row) {
                if (current != null) {
                int[] loc = getLoc(current);
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
    public void updateBoard() {
        List<Piece> actors = getObjects(Piece.class);
        for (Piece current: actors) {
            int x = current.getX();
            int y = current.getY();
            if (x % 80 == 0) {
                x--;
            }
            if (y % 80 == 0) {
                y--;
            }
            setPiece(x / 80, y/80, current);
        }
    }
    public void pieceDropped(Piece p) {
        int x = p.getX();
        int y = p.getY();
        int row = (x+40)/80;
    }
    
    public int[] getLoc(Piece p) {
        int[] loc = new int[2];
        for (int i = 0; i<board.length; i++) {
            for (int j = 0; j<board[i].length; j++) {
                if (board[i][j] == p) {
                    loc[0] = i;
                    loc[1] = j;
                }
            }
        }
        return loc;
    }
}
