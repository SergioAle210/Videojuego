import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bola here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bola extends Actor
{
    /**
     * Act - do whatever the Bola wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int dy = 5;
    int dx = 0;
    public int contador = 0;
    public Jugador jugador; // Permite que el bola pueda ver la clase
    public World myWorld;
    public Bola(Jugador jugador, World world)
    {
        myWorld = world;
        //Jugador del tipo de objeto jugador sera igual al parametro
        this.jugador = jugador;
        getImage().scale(getImage().getWidth()/2, getImage().getHeight()/2);
    }
        public void act()
    {
        movimiento();
        rebote();
        reboteFueraBorde();
        golpeBloque();
        perder();
        ganar();
    }
    public void movimiento()
    {   //dx es la distancia desde la x
        setLocation(getX() + dx, getY() + dy);
    }
    public void rebote()
    {   //Se esta obteniendo un grado menor al del rebote
        if(isTouching(Jugador.class) && this.jugador.getX() > getX() + 50)
        {
            dy = -dy; //Para que vaya en sentido contrario
            dx-= 6; //Se le suma eso para la direccion que va a tomar la pelota
        }
        else if(isTouching(Jugador.class) && this.jugador.getX() < getX() - 50)
        {
            dy = -dy; 
            dx+= 6; 
        }
        else if(isTouching(Jugador.class) && this.jugador.getX() > getX() + 40) 
        {
            dy = -dy;
            dx-= 5;
        }
        else if(isTouching(Jugador.class) && this.jugador.getX() < getX() - 40)
        {
            dy = -dy;
            dx+= 5;
        }
        else if(isTouching(Jugador.class) && this.jugador.getX() > getX() + 30) 
        {
            dy = -dy;
            dx-= 4;
        }
        else if(isTouching(Jugador.class) && this.jugador.getX() < getX() - 30)
        {
            dy = -dy;
            dx+= 4;
        }
        else if(isTouching(Jugador.class) && this.jugador.getX() > getX() + 20) 
        {
            dy = -dy;
            dx-= 3;
        }
        else if(isTouching(Jugador.class) && this.jugador.getX() < getX() - 20)
        {
            dy = -dy;
            dx+= 3;
        }
        else if(isTouching(Jugador.class) && this.jugador.getX() > getX() + 10) 
        {
            dy = -dy;
            dx-= 2;
        }
        else if(isTouching(Jugador.class) && this.jugador.getX() < getX() - 10)
        {
            dy = -dy;
            dx+= 2;
        }
        else if(isTouching(Jugador.class) || isTouching(Bloques.class)) 
        {
            dy = -dy;
        }
    }
    public void reboteFueraBorde()
    {
        if(getX() >= getWorld().getWidth() - 1)
        {
            dx = -dx;
        }
        if(getX() <= 0)
        {
            dx = -dx;
        }
        if(getY() <= 0)
        {
            dy = -dy;
        }
        /*/  Esto es para que el usuario no pueda perder y que rebote cuando toca la parte inferior
        if(getY() >= getWorld().getHeight() -1)
        {
            dy = -dy;
        }
        /*/
    }
    public void golpeBloque()
    {
        Actor bloque = getOneIntersectingObject(Bloques.class);
        if(bloque != null && bloque.getX() > getX() + 30)
        {
            getWorld().removeObject(bloque);
            dx = -dx;
            Greenfoot.playSound("export.wav");
            contador++;
        }
        else if(bloque != null && bloque.getX() < getX() - 30)
        {
            getWorld().removeObject(bloque);
            dx = -dx;
            Greenfoot.playSound("export.wav");
            contador++;
        }
        else if(bloque != null)
        {
            getWorld().removeObject(bloque);
            Greenfoot.playSound("export.wav");
            contador++;
        }
        setImage(new GreenfootImage("Contador: " + contador, 20, Color.WHITE, Color.BLACK));
    }
    /*/public void mostrarContador(int contador)
    {
        addObject(this.contador, 205, 90);
    }
    /*/
    public void perder()
    {
        if(getY() >= getWorld().getHeight() - 1)
        {
            getWorld().showText("Perdiste, Intenta otra vez", getWorld().getWidth()/2, getWorld().getHeight()/2); //Esto es para que muestre un texto centrado
            Greenfoot.playSound("finish.wav");
            Greenfoot.stop();
        }
    }
    public void ganar()
    {
        if(contador == 48) //48 bloques que tiene el juego
        {
            getWorld().showText("Ganaste, Felicidades!!", getWorld().getWidth()/2, getWorld().getHeight()/2); //Esto es para que muestre un texto centrado
            Greenfoot.playSound("game.wav");
            Greenfoot.stop();
        }
    }
}
