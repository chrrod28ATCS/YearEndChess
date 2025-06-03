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
    private Piece selectedPiece = null;
    private BoardActor b = new BoardActor();
    private boolean hasTwoKings;
    private Player white = new Player("White");
    private Player black = new Player("Black");
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public ChessWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 640, 1);
        setPaintOrder(Piece.class, Marker.class);
        prepare();
    }
    public void act() {
        
    }
    private void prepare() {
        addObject(b, 640, 320);
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
        displayBoard();
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
                addObject(current, 320+c*80-40, r*80-40);
                }
            }
        }
    }
    public int[] convertToArray(Piece p, int x, int y) {
        int col = (p.getOldX()-320)/80;
        int row = (p.getOldY()/80);
        return new int[]{col, row};
    }
    public Piece[][] getBoard() {
        return board;
    }
    public Piece getPieceAtPos(int row, int col) {
        return board[row][col];
    }
    /*public void updateBoard() {
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
    }*/
    public void pieceDropped(Piece p, int x, int y) {
        if (selectedPiece != null) {
            selectedPiece.setLocation(x,y);
            position(selectedPiece);
            checkIllegalMove(p, p.getOldX(), p.getOldY(), x, y);
        }
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
    public void setSelectedPiece(Piece p) {
        selectedPiece = p;
    }
    public Piece getSelectedPiece() {
        return selectedPiece;
    }
    public BoardActor getBoardActor() {
        return b;
    }
    public void setHasTwoKings(boolean twoKings) {
        hasTwoKings = twoKings;
    }
    public void checkIllegalMove(Piece p, int oldX, int oldY, int newX, int newY) {
        int[] oldPos = convertToArray(p, oldX, oldY);
        int[] newPos = convertToArray(p, newX, newY);
        int oldRow = oldPos[1];
        int oldCol = oldPos[0];
        int newRow = newPos[1];
        int newCol = newPos[0];
        Piece check = board[newPos[1]][newPos[0]];
        if (p instanceof Pawn) {
            boolean firstTurn = ((Pawn)(p)).checkFirstTurn();
            if (firstTurn) {
                if (checkPlace(p, check)) {
                    setPiece(newPos[1], newPos[0], p); 
                } else {
                    
                }
            }
        }
    }
    public boolean checkPlace(Piece p, Piece check) {
        if (check == null || !check.getColor().equals(p.getColor())) {
            return true;
        }
        return false;
    }
    public void position(Piece p) {
        int boardLeft = 320;        
        int boardTop = 0;           
        int tileSize = 80;          
        int col = (p.getX() - boardLeft) / tileSize;
        int row = (p.getY() - boardTop) / tileSize;
        col = Math.max(0, Math.min(7, col));
        row = Math.max(0, Math.min(7, row));
        int x = boardLeft + (col * tileSize) + tileSize / 2;
        int y = boardTop + (row * tileSize) + tileSize / 2;
        p.setLocation(x, y);
    }
}
