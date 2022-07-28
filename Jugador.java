import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jugador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jugador extends Actor
{
    /**
     * Act - do whatever the Jugador wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Jugador()
    {
    }
    public void act()
    {
        //Se mueve de izquierda a derecha
        if(Greenfoot.isKeyDown("right"))
            setLocation(getX() + 4, getY());
        if(Greenfoot.isKeyDown("left"))
            setLocation(getX() - 4, getY());
    }
}
