package Publisher.Vista;
import Publisher.Modelo.Coordenada;

/**
 * Write a description of class Punto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Punto
{   
    private Coordenada punto;
    private int color;
    public Punto(int x, int y, int c)
    {
        this.punto = new Coordenada(x,y);
        color = c;
    }
    public void setColor(int c){
        this.color = c;
    }
    public void setCoordenada(int x, int y){
        this.punto = new Coordenada(x,y);
    }
    public int getC(){
        return color;
    }
    public Coordenada getCoordenada(){
        return punto;
    }
}
