package Publisher.Vista;
import java.util.ArrayList;

/**
 * Write a description of class Circle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Circle
{
    private ArrayList<Punto> puntos;
    private Punto centro;
    private int color;
    private int radio;
    private int r2;
    private int diametro;
    public Circle(Punto p, int r, int c)
    {
        this.centro = p;
        this.radio = r;
        this.r2 = radio * radio;
        this.diametro = radio + radio;
        puntos = new ArrayList<>();
        color = c;
        puntos();
    }
    public int getD(){
        return this.diametro;
    }
    public void setCo(int c){
        color = c;
    }
    public int getCo(){
        return color;
    }
    public void setR(int r){
        this.radio = r;
        this.r2 = r*r;
    }
    public Punto getCe(){
        return centro;
    }
    public void setCe(Punto c){
        this.centro = c;
    }
    public ArrayList<Punto> getPuntos(){
        return puntos;
    }
    public void puntos(){
        int xc = centro.getCoordenada().getX();
        int yc = centro.getCoordenada().getY();
        int x = 1;
        int y;
        puntos.add(new Punto(xc, yc + this.radio, this.color));
        puntos.add(new Punto(xc, yc - this.radio, this.color));
        puntos.add(new Punto(xc + this.radio, yc, this.color));
        puntos.add(new Punto(xc - this.radio,yc, this.color));
        y = (int)(Math.sqrt(this.r2 - 1) + 0.5);
        while(x < y){
            puntos.add(new Punto(xc + x, yc + y, this.color));
            puntos.add(new Punto(xc + x, yc - y, this.color));
            puntos.add(new Punto(xc - x, yc + y, this.color));
            puntos.add(new Punto(xc - x, yc - y, this.color));
            puntos.add(new Punto(xc + y, yc + x, this.color));
            puntos.add(new Punto(xc + y, yc - x, this.color));
            puntos.add(new Punto(xc - y, yc + x, this.color));
            puntos.add(new Punto(xc - y, yc - x, this.color));
            x+=1;
            y = (int)(Math.sqrt(this.r2 - x*x) +0.5);
        }
        if(x == y){
            puntos.add(new Punto(xc + x, yc + y, this.color));
            puntos.add(new Punto(xc + x, yc - y, this.color));
            puntos.add(new Punto(xc - x, yc + y, this.color));
            puntos.add(new Punto(xc - x, yc - y, this.color));
        }
    }
}