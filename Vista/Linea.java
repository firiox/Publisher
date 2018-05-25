package Publisher.Vista;
import java.util.ArrayList;

/**
 * Write a description of class Linea here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Linea
{
    private int m;
    private Punto punto;
    private int color;
    private ArrayList<Punto> puntos;
    public Linea(Punto punto, int m, int color){
        this.m = m;
        this.punto = punto;
        this.color = color;
        puntos = new ArrayList<>();        
    }
    public void linea(int fila, int columna){
        int x0 = punto.getCoordenada().getX();
        int y0 = punto.getCoordenada().getY();
        int x = 0;
        int y = 0;
        while((x >= 0 && x < fila - 1) && (y >= 0 && y < columna - 1)){
            //System.out.println(fila+" ////// "+columna);
            y = (m*(x - x0)) + y0;
            puntos.add(new Punto(x,y,this.color));
            x+=1;
        }        
    }
    public int getM(){
        return m;
    }
    public void setM(int m){
        this.m = m;
    }
    public ArrayList<Punto> getPuntos(){
        return puntos;
    }
    public void punto(Punto punto){
        this.punto = punto;
    }
    public Punto getPunto(){
        return punto;
    }
    public int getCo(){
        return color;
    }
    public void setCo(int c){
        this.color = c;
    }
}