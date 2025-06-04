import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
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
    private boolean markersShown;
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
        int col = (x-320)/80;
        int row = (y/80);
        return new int[]{col, row};
    }
    public Piece[][] getBoard() {
        return board;
    }
    public Piece getPieceAtPos(int row, int col) {
        return board[row][col];
    }
    public void pieceDropped(Piece p, int x, int y) {
        if (selectedPiece != null) {
            selectedPiece.setLocation(x,y);
            position(selectedPiece);
            boolean legalMove = checkIllegalMove(p);
            if (legalMove) {
                if (selectedPiece instanceof Pawn) {
                    if (((Pawn)(selectedPiece)).checkFirstTurn()) {
                        ((Pawn)(selectedPiece)).setFirstTurn(false);
                    }
                }
                int[] pos = convertToArray(p, p.getX(), p.getY());
                setPiece(pos[0], pos[1], p);
                p.setOldX(p.getX());
                p.setOldY(p.getY());
            } else {
                p.setLocation(p.getOldX(), p.getOldY());
            }
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
    public boolean getTwoKings() {
        return hasTwoKings;
    }
    public void setHasTwoKings(boolean twoKings) {
        hasTwoKings = twoKings;
    }
    public boolean checkIllegalMove(Piece p) {
       int[] pos = convertToArray(p, p.getX(), p.getY());
       ArrayList<int[]> moves = p.getMoves();
       if (moves.contains(pos)) {
           return true;
       }
       return false;
    }
    public void showMarkers(ArrayList<int[]> moves, Piece p) {
        if (getMarkersShown()) {
            clearMarkers();
            setMarkersShown(false);
        }
        if (p == getSelectedPiece()) {
            for (int i = 0; i < moves.size(); i++) {
                int x = (moves.get(i)[1]+1)* 80 + 280;
                int y = (moves.get(i)[0]+1) * 80-40;
                addObject(new Marker(), x, y);
            }
            setMarkersShown(true);
        }
    }
    public boolean inBounds(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }
    public void clearMarkers() {
        removeObjects(getObjects(Marker.class));
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
    public boolean getMarkersShown() {
        return markersShown;
    }
    public void setMarkersShown(boolean shown) {
        markersShown = shown;
    }
}
