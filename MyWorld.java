import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */    

    
    public Jugador jugador = new Jugador(); //Hacerlo local para toda la clase
    public Fondo fondo = new Fondo();
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        preparacion();
    }

    public void preparacion()
    {
        addObject(fondo, 300,300);
        addObject(jugador, 300, 550);
        for (int i = 0; i < 8; i++)
            for(int j = 0; j < 6; j++)
                addObject(new Bloques(), 60 + 70 * i, 20 + 30 * j); 
        //Nos dara 10 pixels de diferencia
        //30 pixels para dar medio bloque de espacio a lo largo de la X
        Bola bola = new Bola(jugador, this); //this es una palabra clave para hacer referencia a la instancia de cualquier clase en la que se encontraba y ahora estamos en la clase de mi mundo
        //Y ahora el this sabe que va a ser este mundo que se va a trabajar
        addObject(bola, 300, 450);
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */

}
