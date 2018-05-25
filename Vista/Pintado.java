package Publisher.Vista;


/**
 * Write a description of class Pintado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pintado
{
    private int x,y;    
    public Pintado(Punto punto)
    {
        this.x = punto.getCoordenada().getX();
        this.y = punto.getCoordenada().getY();
    }
    public void pintar(){
       
    }
    public boolean valido(int whith, int head){
        boolean valido = false;
        if(whith > 0 && head > 0 && whith < 500 && head > 500){
            valido = true;
        }
        return valido;
    }
}
