package Publisher.Vista;
import java.util.ArrayList;

/**
 * Write a description of class LineaBresenham here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LineaBresenham
{
    private ArrayList<Punto> puntos;
    private Punto punto1;
    private Punto punto2;
    public LineaBresenham(Punto punto1, Punto punto2)
    {
        this.punto1 = punto1;
        this.punto2 = punto2;
    }
    public void calcular(){
        int x = punto1.getCoordenada().getX();
        int y = punto1.getCoordenada().getX();
        int x1 = punto2.getCoordenada().getY();
        int y1 = punto2.getCoordenada().getY();
        calcular(x,y,x1,y1);
    }
    private void calcular(int X1, int Y1, int X2, int Y2){
          // 0 - Distancias que se desplazan en cada eje
          int dY = (Y2 - Y1);
          int dX = (X2 - X1);
          int IncXi;
          int IncYi;
          // 1 - Incrementos para las secciones con avance inclinado
          if(dY >= 0){
              IncYi = 1;
          }
          else{
              dY = -dY;
              IncYi = -1;
           }
        
          if(dX >= 0){
              IncXi = 1;
          }
          else{
              dX = -dX;
              IncXi = -1;
          }
          int IncYr;
          int IncXr;
          int k;
          // 2 - Incrementos para las secciones con avance recto:
          if(dX >= dY){
              IncYr = 0;
              IncXr = IncXi;
            }
          else{
              IncXr = 0;
              IncYr = IncYi;
              // Cuando dy es mayor que dx, se intercambian, para reutilizar el mismo bucle.
              // ver octantes blancos en la imagen encima del código
              k = dX;
              dX = dY;
              dY = k;
          }
        
          // 3  - Inicializar valores (y de error).
          int X = X1;
          int Y = Y1;
          int avR = (2 * dY);
          int av = (avR - dX);
          int avI = (av - dX);
          // 4  - Bucle para el trazado de las línea.
          do{
              puntos.add(new Punto(X, Y, 50)); // Como mínimo se dibujará siempre 1 píxel (punto).
              System.out.println(av + " "); // (debug) para ver los valores de error global que van apareciendo.
              if(av >= 0){
                  X = (X + IncXi);     // X aumenta en inclinado.
                  Y = (Y + IncYi);    // Y aumenta en inclinado.
                  av = (av + avI);    // Avance Inclinado
              }
              else{
                  X = (X + IncXr);     // X aumenta en recto.
                  Y = (Y + IncYr);     // Y aumenta en recto.
                  av = (av + avR);     // Avance Recto
              }
            }
          while(X == X2); // NOTA: La condición de 'Repetir Hasta', se debe cambiar si se elige 'Repetir Mientras'
     }
}
