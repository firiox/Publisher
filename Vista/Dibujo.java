package Vista;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*; 
import java.awt.Canvas;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Stack;

import java.awt.Dimension;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
 
/**
 * Write a description of class Canvas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dibujo extends Canvas 
{
    private Stack<Punto> pilaPuntos;
    private Punto punto;
    private Circle circle;    
    private BufferedImage canvas;
    private final int pixelSize = 10;
    //private Color color;
    public Dibujo()
    {
       setBackground(Color.BLACK);
       this.canvas = new BufferedImage(600,600, BufferedImage.TYPE_INT_ARGB);
       //circuloBresemhan(50,100,30,Color.YELLOW);
       //pintado(51,55,Color.RED);
       //lineaBresenham(50,50,200,200,Color.BLUE);
       //triangulo(0,0,0,50,50,0,Color.CYAN);
       triangulo(70,80,150,30,60,150,Color.YELLOW);
       // cuadrado(50,100,200,200,Color.RED);
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);  
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(canvas, null, null);
        g.translate(300,300);
    } 
    public void pintado(int x, int y, Color c){
        int color = c.getRGB();
        pinta(x,y,color);
    }
    private void pinta(int x, int y,int color){
        if(x < canvas.getWidth() && y < canvas.getHeight()){
            this.canvas.setRGB(x,y,color);
            repaint();
            if(canvas.getRGB(x,y) != color){
                pinta(x-1,y-1,color);
                pinta(x+1,y+1,color);
                pinta(x-1,y+1,color);
                pinta(x+1,y-1,color);
            }
            else{
                pinta(x-1,y-1,color);
                pinta(x+1,y+1,color);
                pinta(x-1,y+1,color);
                pinta(x+1,y-1,color);
            }
        }
    }

    public void rotar(){}
    public void segmentado(){
    }
    public void trasladar(){
    }
    
    
    public void lineaBresenham(int x, int y, int x1, int y1,Color c){
        int color = c.getRGB();
        LibeaBresenham linea = new LibeaBresenham(new Punto(x,y,color),new Punto(x1,y1,color),color);
        ArrayList<Punto> puntos = linea.getPuntos();
        int tam = puntos.size();
        Punto point;
        int xr;
        int yr;
        System.out.println("X    Y");
        System.out.println(tam);
        for(int recorrido = 0; recorrido < tam; recorrido++){
            point = puntos.get(recorrido);
            xr = point.getCoordenada().getX();
            yr = point.getCoordenada().getY();
            System.out.println(xr+"  "+yr);
            this.canvas.setRGB(xr,yr,color);    
        }
        repaint();
        
    }  
    
    public void cuadrado(int x1, int y1, int x2, int y2,Color c){
        int color = c.getRGB();
        Punto punto1 = new Punto(x1,y1,color);
        Punto punto4 = new Punto(x2,y2,color);        
        Cuadrilatero cuadrilatero = new Cuadrilatero(punto1,punto4,color);
        Stack<ArrayList<Punto>> puntos = new Stack<ArrayList<Punto>>();
        puntos = cuadrilatero.getPuntos();
        ArrayList<Punto> punto;
        int lon;
        int xr;
        int yr;
        Punto point;    
        while(!puntos.empty()){
            punto = puntos.pop();
            lon = punto.size();
            for(int pos =0; pos <lon;pos++){
                point = punto.get(pos);
                xr = point.getCoordenada().getX();
                yr = point.getCoordenada().getY();
                this.canvas.setRGB(xr,yr,color);
            }            
        }   
        repaint();
    }

    public void triangulo(int x1, int y1, int x2, int y2, int x3, int y3, Color c){
        int color = c.getRGB();
        //LibeaBresenham linea1 = new LibeaBresenham(new Punto(x1,y1,color),new Punto(x2,y2,color),color);
        //LibeaBresenham linea2 = new LibeaBresenham(new Punto(x1,y1,color),new Punto(x2,y2,color),color);
        //LibeaBresenham linea3 = new LibeaBresenham(new Punto(x1,y1,color),new Punto(x2,y2,color),color);
        lineaBresenham(x2,y2,x1,y1,c);
        lineaBresenham(x3,y3,x1,y1,c);
        lineaBresenham(x2,y2,x1,y1,c);
    }
    // public void triangulo(int x1, int y1, int x2, int y2, int x3, int y3,Color c){
        // int color  = c.getRGB();
        // Punto punto1 = new Punto(x1,y1,color);
        // Punto punto2 = new Punto(x2,y2,color);
        // Punto punto3 = new Punto(x3,y3,color);
        // Triangulo triangulo = new Triangulo(punto1,punto2,punto3,color);
        // Stack<ArrayList<Punto>> puntos = triangulo.getPuntos();
        // ArrayList<Punto> punto;
        // int lon;
        // Punto point;    
        // int xr,yr;
        // while(!puntos.empty()){
            // punto = puntos.pop();
            // lon = punto.size();
            // for(int pos = 0; pos < lon; pos++){
                // point = punto.get(pos);
                // xr =point.getCoordenada().getX();
                // yr =point.getCoordenada().getY();
                // System.out.println(xr +"  "+yr);
                // this.canvas.setRGB(xr,yr,color);
            // }
        // }   
        // repaint();
    // }
    
    public void circuloBresemhan(int x, int y,int radio, Color c){
        int color = c.getRGB();
        Punto centro = new Punto(x,y,color);
        CirculoBresenham circulo = new CirculoBresenham(centro,radio,color);
        ArrayList<Punto> puntos = circulo.getPuntos();
        int tam = puntos.size();
        Punto point;    
        int xr,yr;
        System.out.println("X          "+"Y");
        for(int recorrido =0; recorrido < tam; recorrido++){
            point = puntos.get(recorrido);
            xr = point.getCoordenada().getX();
            yr = point.getCoordenada().getY();
            System.out.println(xr+"     "+yr);
            this.canvas.setRGB(xr,yr,color);
        }
        repaint();
    }
    
    public void point(int x, int y){       
        point(x,y, Color.BLUE);
    }
    private void point(int x, int y,Color c){
        int color = c.getRGB();
        punto = new Punto(Math.abs(x),Math.abs(y),color);
        this.canvas.setRGB(punto.getCoordenada().getX(), punto.getCoordenada().getY(), color);
        repaint();
    }    
    public void circle(int x, int y, int r){
        circle(x,y,r,Color.BLUE);
    }
    private void circle(int x, int y, int r, Color c) {
        int color = c.getRGB();
        Punto centro = new Punto(Math.abs(x),Math.abs(y),color);
        circle = new Circle(centro,r,color);
        ArrayList<Punto> puntos = circle.getPuntos();
        int tam = puntos.size();
        Punto aux;
        for(int coordenada = 0; coordenada< tam; coordenada++){
            aux = puntos.get(coordenada);
            if(aux.getCoordenada().getX() >= 0 && aux.getCoordenada().getY() >= 0){
                this.canvas.setRGB(aux.getCoordenada().getX(),aux.getCoordenada().getY(),circle.getCo());
            }
        }
        repaint();
    }
    public void circulo2P(int x,int y, int x1, int y1){
        circulo2P(x,y,x1,y1,Color.RED);
    }
    public void circulo2P(int x, int y, int x1, int y1, Color c){
        int color = c.getRGB();
        Cirrcle2Puntos circulo2 = new Cirrcle2Puntos(new Punto(x,y,color), new Punto(x1,y1,color),color);
        circulo2.circulo();
        ArrayList<Punto> puntos = circulo2.getPuntos();
        int tam = puntos.size();
        Punto aux;
        for(int coordenada = 0; coordenada < tam; coordenada++){
            aux = puntos.get(coordenada);
            this.canvas.setRGB(aux.getCoordenada().getX(),aux.getCoordenada().getY(),circulo2.getColor());           
        }
        repaint();
    }    
    public void linea(int x, int y, int m){
        linea(x,y,m,Color.WHITE);
    }
    private void linea(int x, int y, int m, Color c){
        int pixel = c.getRGB();
        Linea linea = new Linea(new Punto(Math.abs(x),Math.abs(y),pixel),m,pixel);
        linea.linea(canvas.getWidth(),canvas.getHeight());
        ArrayList<Punto> puntos = linea.getPuntos();
        int tam = puntos.size();
        Punto aux;
        for(int coordenada = 0; coordenada < tam; coordenada++){
            this.canvas.setRGB(puntos.get(coordenada).getCoordenada().getX(), puntos.get(coordenada).getCoordenada().getY(),pixel);
        }
        repaint();
    }
}
