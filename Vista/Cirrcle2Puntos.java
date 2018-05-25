package Publisher.Vista;
import java.util.ArrayList;

/**
 * Write a description of class Cirrcle2Puntos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cirrcle2Puntos
{
    private Punto punto1;
    private Punto punto2;
    private int color;
    private Punto centro;
    private int radio;
    private int diametro;
    private ArrayList<Punto> puntos;
    public Cirrcle2Puntos(Punto punto1, Punto punto2, int color)
    {
        this.punto1 = punto1;
        this.punto2 = punto2;
        this.color = color;
        this.centro = centro();
        this.diametro = diametro();
        this.radio = diametro / 2;
        puntos = new ArrayList<>();
    }
    public void circulo(){
        Circle circle = new Circle(this.centro,this.radio,color);
        puntos = circle.getPuntos();
    }
    public Punto centro(){
        Punto centro;
        int x = (this.punto1.getCoordenada().getX() + this.punto2.getCoordenada().getY())/2;
        int y = (this.punto1.getCoordenada().getX() + this.punto2.getCoordenada().getY())/2;;
        centro = new Punto(x,y,this.color);
        return centro;
    }
    public int diametro(){
        int x2 = this.punto2.getCoordenada().getX() - this.punto1.getCoordenada().getX();
        int y2 = this.punto2.getCoordenada().getY() - this.punto1.getCoordenada().getY();
        return (int)Math.sqrt(Math.pow(x2,2) + Math.pow(y2,2));
    }
    public int getColor(){
        return color;
    }
    public void setColor(int c){
        this.color = c;
    }
    public void punto(Punto p1, Punto p2){
        this.punto1 = p1;
        this.punto2 = p2;
    }
    public Punto getPunto1(){
        return punto1;
    }
    public Punto getPunto2(){
        return punto2;
    }
    public ArrayList<Punto> getPuntos(){
        return puntos;
    }
}
