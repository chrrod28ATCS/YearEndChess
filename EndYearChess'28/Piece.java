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
    private MyWorld w = (MyWorld)(getWorld());
    private Piece[][] b = w.getBoard();
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
        
    }
    public int[] getLoc() {
       int row = 0;
       int col = 0;
       int[] loc = new int[2];
       for (int i = 0; i<b.length; i++) {
           for (int j = 0; j<b[i].length; j++) {
               if (b[i][j].equals(this)) {
                   row = i;
                   col = j;
               }
           }
       }
       loc[0] = row;
       loc[1] = col;
       return loc;
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
