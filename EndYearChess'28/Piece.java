import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
//test
/**
 * Write a description of class Piece here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Piece extends Actor
{
    private String color;
    private int value;
    private ChessWorld w;
    private Piece[][] b;
    private boolean added = false;
    private int oldX;
    private int oldY;
    public Piece(String color, int val) {
        this.color = color;
        value = val;
    }
    /**
     * Act - do whatever the Piece wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        handleDrag();
    }
     public int[] getLoc() {
       ChessWorld w = (ChessWorld)(getWorld());
       return w.getLoc(this);
    }
    public String getColor() {
        return color;
    }
    public void setOldX(int x) {
        oldX = x;
    }
    public void setOldY(int y) {
        oldY = y;
    }
    public int getOldX() {
        return oldX;
    }
    public int getOldY() {
        return oldY;
    }
    public boolean handleDrag() {
        ChessWorld world = (ChessWorld) getWorld();
        if (Greenfoot.mouseClicked(this)) {
            world.setSelectedPiece(this);
            setOldX(this.getX());
            setOldY(this.getY());
            if (world.getMarkersShown()) {
                world.clearMarkers();
                world.setMarkersShown(false);
            }
            world.showMarkers(getMoves(), this);
        }
        if (Greenfoot.mouseClicked(world.getBoardActor()) && world.getSelectedPiece() == this) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if (mouse != null) {
                world.pieceDropped(this, mouse.getX(), mouse.getY());
                world.setSelectedPiece(null);
                world.clearMarkers();
                return true;
            }
        }
        return false;
    }
    public abstract boolean isLegalMove(int startRow, int startCol, int targetRow, int targetCol, Piece[][] board);
    public abstract ArrayList<int[]> getMoves();
    public void addedToWorld() {
        added = true;
        w = (ChessWorld)getWorld();
        b = w.getBoard();
    }
}
