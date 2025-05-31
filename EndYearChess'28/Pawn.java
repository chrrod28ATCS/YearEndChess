import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pawn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pawn extends Piece implements LinearMovement, DiagonalMovement
{
    //test
    public Pawn(String color) {
        super(color, 1);
        GreenfootImage img = getImage();
        img.scale(img.getWidth()/2, img.getHeight()/2);
        setImage(img);
    }
    /**
     * Act - do whatever the Pawn wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        super.act();
    }
    public void diagonalMove() {
        
    }
    public void diagonalCapture() {
        
    }
    public void linearMove(int row, int col) {
        
    }
}
