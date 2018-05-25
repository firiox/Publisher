package Vista;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Write a description of class Cuadrilatero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cuadrilatero
{
    private Punto punto1;
    private Punto punto2;
    private Punto punto3;
    private Punto punto4;
    private int color;
    private Stack<ArrayList<Punto>> puntos;
    public Cuadrilatero(Punto punto1, Punto punto4,int color)
    {
        this.color = color;
        puntos = new Stack<>();
        this.punto1 = punto1;
        this.punto4 = punto4;
        this.punto2 = new Punto(punto4.getCoordenada().getX(),punto1.getCoordenada().getY(),color);
        this.punto3 = new Punto(punto1.getCoordenada().getX(),punto4.getCoordenada().getY(),color);
        
        //imprimePunto();
        calcular();
    }
    public Cuadrilatero(Punto p1, Punto p2, Punto p3, Punto p4){
        this.punto2 = p1;
        this.punto2 = p2;
        this.punto2 = p3;
        this.punto2 = p4;
        calcular();
    }
    public void calcular(){
        LibeaBresenham linea1 = new LibeaBresenham(this.punto2,this.punto1,color);
        LibeaBresenham linea2 = new LibeaBresenham(this.punto2,this.punto4,color);
        LibeaBresenham linea3 = new LibeaBresenham(this.punto3,this.punto4,color);
        LibeaBresenham linea4 = new LibeaBresenham(this.punto3,this.punto1,color);
        this.puntos.push(linea1.getPuntos());
        this.puntos.push(linea2.getPuntos());
        this.puntos.push(linea3.getPuntos());
        this.puntos.push(linea4.getPuntos());
    }
    public Stack<ArrayList<Punto>> getPuntos(){
        return puntos;
    }
    public void imprimePunto(){
        System.out.println("x :"+"y :");
        System.out.println(this.punto1.getCoordenada().getX()+" "+this.punto1.getCoordenada().getY());
        System.out.println(this.punto2.getCoordenada().getX()+" "+this.punto2.getCoordenada().getY());
        System.out.println(this.punto3.getCoordenada().getX()+" "+this.punto3.getCoordenada().getY());
        System.out.println(this.punto4.getCoordenada().getX()+" "+this.punto4.getCoordenada().getY());
    }
}
