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
    private ChessWorld w;
    private Piece[][] b;
    private boolean dragging = false;
    public Piece(String color) {
        this.color = color;
    }
    /**
     * Act - do whatever the Piece wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        w = (ChessWorld)getWorld();
        b = w.getBoard();
    }
     public int[] getLoc() {
       ChessWorld w = (ChessWorld)(getWorld());
       return w.getLoc(this);
    }
    public String getColor() {
        return color;
    }
    public void handleDrag() {
        if (Greenfoot.mousePressed(this)) {
            dragging = true;
        }
        if (dragging = true) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if (mouse != null) {
                setLocation(mouse.getX(), mouse.getY());
            }
        }
        if (dragging & Greenfoot.mouseDragEnded(this)) {
            dragging = false;
            w.pieceDropped(this);
        }
    }
}
