package Publisher.Vista;
import java.util.ArrayList;

/**
 * Write a description of class CirculoBresenham here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CirculoBresenham
{
    private ArrayList<Punto> puntos;
    private int xc;
    private int yc;
    private int radio;
    private int color;
    public CirculoBresenham(Punto punto,int radio , int color)
    {
        this.xc = punto.getCoordenada().getX();
        this.yc = punto.getCoordenada().getY();
        this.radio = radio;
        this.color = color;
        this.puntos = new ArrayList<>();
        calcular();
        imprimir();
    }
    public void imprimir(){
        int tam = this.puntos.size();
        for(int recorrido = 0; recorrido < tam; recorrido++){
            System.out.print(this.puntos.get(recorrido).getCoordenada().getX());
            System.out.print("" + this.puntos.get(recorrido).getCoordenada().getX());
            System.out.print("\n");
        }
    }
    public ArrayList<Punto> getPuntos(){
        return puntos;
    }
    public void calcular(){
        int x = this.radio;
        int y = 0;
        int e = 0;
        while(x >= y){
            puntos.add(new Punto((xc + x),(yc + y), this.color));
            puntos.add(new Punto((xc + y),(yc + x), this.color));
            puntos.add(new Punto((xc - x),(yc + y), this.color));
            puntos.add(new Punto((xc - y),(yc + x), this.color));

            puntos.add(new Punto((xc + x),(yc - y), this.color));
            puntos.add(new Punto((xc + y),(yc - x), this.color));
            puntos.add(new Punto((xc - x),(yc - y), this.color));
            puntos.add(new Punto((xc - y),(yc - x), this.color));
            e = e + (2*y) + 1;
            y = y+1;
            if((2 * e) > ((2*x)-1)){
                x = x - 1;
                e = e - (2*x) + 1;
            }
        }        
    }

    public void trasladar(Punto punto){
        xc = punto.getCoordenada().getX();
        yc = punto.getCoordenada().getY();
    }
    
    
}
