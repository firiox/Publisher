package Vista;
import java.util.ArrayList;

/**
 * Write a description of class LibeaBresenham here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LibeaBresenham
{
    private ArrayList<Punto> puntos;
    private Punto punto1;
    private Punto punto2;
    private int color;
    public LibeaBresenham(Punto punto1, Punto punto2, int color)
    {
        this.punto1 = punto1;
        this.punto2 = punto2;
        this.puntos = new ArrayList<>();
        calcular();
        //imprimir();
    }
    public void imprimir(){
        int tam = puntos.size();
        for(int recorrido = 0; recorrido < tam ; recorrido++){
            System.out.print(this.puntos.get(recorrido).getCoordenada().getX());
            System.out.print("" + this.puntos.get(recorrido).getCoordenada().getX());
            System.out.print("\n");
        }
    }
    public ArrayList<Punto> getPuntos(){
        return puntos;
    }

    private void calcular(){
        int x0 = punto1.getCoordenada().getX();
        int y0 = punto1.getCoordenada().getY();
        int x1 = punto2.getCoordenada().getX();
        int y1 = punto2.getCoordenada().getX();
        drawLine(x0,y0,x1,y1,this.color);
    }
   
    private void drawLine(int x1, int y1, int x2, int y2,int color) {
        // delta of exact value and rounded value of the dependent variable
        int d = 0;
        
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
 
        int dx2 = 2 * dx; // slope scaling factors to
        int dy2 = 2 * dy; // avoid floating point
 
        int ix = x1 < x2 ? 1 : -1; // increment direction
        int iy = y1 < y2 ? 1 : -1;
 
        int x = x1;
        int y = y1;
 
        if (dx >= dy) {
            while (true) {
                puntos.add(new Punto(x,y,color));

                if (x == x2){
                    break;
                }
                x += ix;
                d += dy2;
                if (d > dx) {
                    y += iy;
                    d -= dx2;
                }
            }
        } else {
            while (true) {
                puntos.add(new Punto(x,y,color));
                if (y == y2)
                    break;
                y += iy;
                d += dx2;
                if (d > dy) {
                    x += ix;
                    d -= dy2;
                }
            }
        }

    }
    public void translacion(Punto punto){
        
    }
}
