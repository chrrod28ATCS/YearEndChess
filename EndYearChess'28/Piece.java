import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    private boolean dragging = false;
    private boolean added = false;
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
    public void handleDrag() {
        if (Greenfoot.mouseClicked(this)) {
            dragging = true;
        }
        if (dragging) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if (mouse != null) {
                setLocation(mouse.getX(), mouse.getY());
            }
        }
        if (dragging && Greenfoot.mouseDragEnded(this)) {
            dragging = false;
            if (added) {
                w.pieceDropped(this);
            }
        }
    }
    public void addedToWorld() {
        added = true;
        w = (ChessWorld)getWorld();
        b = w.getBoard();
    }
}
