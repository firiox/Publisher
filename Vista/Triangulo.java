package Vista;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Write a description of class Triangulo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Triangulo
{
    private Punto punto1;
    private Punto punto2;
    private Punto punto3;
    private int color;
    private Stack<ArrayList<Punto>> trianguloP;
    public Triangulo(Punto p1, Punto p2, Punto p3,int color)
    {
        this.punto1 = p1;
        this.punto2 = p2;
        this.punto3 = p3;
        System.out.println(this.punto1.getCoordenada().getX() +"   "+this.punto1.getCoordenada().getY());
        System.out.println(this.punto2.getCoordenada().getX() +"  "+this.punto2.getCoordenada().getY());
        System.out.println(this.punto3.getCoordenada().getX()+"    "+this.punto3.getCoordenada().getY());
        System.out.println(" -------------------------------------------  ");
        trianguloP = new Stack<ArrayList<Punto>>();
        calcular();
    }
    public Stack<ArrayList<Punto>> getPuntos(){
        return trianguloP;
    }

    public void calcular(){      
        int x1,y1,x2,y2,x3,y3;
        x1 = this.punto1.getCoordenada().getX();
        y1 = this.punto1.getCoordenada().getY();
        x2 = this.punto2.getCoordenada().getX();
        y2 = this.punto2.getCoordenada().getY();
        x3 = this.punto3.getCoordenada().getX();
        y3 = this.punto3.getCoordenada().getY();
        
        //******************************************************************
        //Linea 1 del punto1 al punto2
        LibeaBresenham linea1 = new LibeaBresenham(punto1,punto2,color);       
        System.out.println("linea 1: "+x1+" "+y1);       
        System.out.println("linea 1: "+x2+" "+y2);
        ArrayList<Punto> lineaP1 = linea1.getPuntos();
        this.trianguloP.push(lineaP1);
        //******************************************************************
        //Linea 2 del punto2 al punto3
        LibeaBresenham linea2 = new LibeaBresenham(punto3,punto2,color);
        System.out.println("linea 2: "+x2+" "+y2);       
        System.out.println("linea 2: "+x3+" "+y3);
        ArrayList<Punto> lineaP2 = linea2.getPuntos();
        this.trianguloP.push(lineaP2);
        //******************************************************************
        //Linea 3 del punto3 al punto1
        LibeaBresenham linea3 = new LibeaBresenham(punto3,punto1,color);
        System.out.println("linea 3: "+x3+" "+y3);       
        System.out.println("linea 3: "+x1+" "+y1);
        ArrayList<Punto> lineaP3 = linea3.getPuntos();
        this.trianguloP.push(lineaP3);
        //******************************************************************
    }
}
