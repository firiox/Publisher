package Vista;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JDialog;

/**
 * Write a description of class Frame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Frame extends JFrame 
{
    private JMenuBar menu;
    private Dibujo dibujo;
    
    private JMenu insert;
    private JMenu archive;
    private JMenu help;
    
    private JMenuItem punto;
    private JMenuItem linea;
    private JMenuItem circulo;
    private JMenuItem circulo2;
    
    private JButton lBresenham;
    private JButton cBresenham;
    private JButton cuadrilatero;
    private JButton triangulo;
    private JButton texto;
    private JButton color;
    
    private JLabel line;
    private JLabel circle;
    private JLabel cuadrado;
    private JLabel triangulos;
    private JLabel textos;
    private JLabel colores;
    public Frame()
    {
        menu = new JMenuBar();
        dibujo = new Dibujo();
        menu();
        insert();
        help();
        setJMenuBar(menu);
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(dibujo);
        setVisible(true);
    }

    private void menu(){
        this.archive = new JMenu("Archivo");
        archive.setFont(new Font("Arial",Font.PLAIN,16));
        
        JMenuItem nuevo = new JMenuItem("Nuevo");
        nuevo.setFont(new Font("Arial",Font.PLAIN,16));
        archive.add(nuevo);
        
        JMenuItem abrir = new JMenuItem("abrir");
        abrir.setFont(new Font("Arial",Font.PLAIN,16));    
        archive.add(abrir);
        
        JMenuItem ver = new JMenuItem("Ver");
        ver.setFont(new Font("Arial",Font.PLAIN,16));
        archive.add(ver);
        
        this.menu.add(archive);
    }
    private void insert(){
        this.insert = new JMenu("Insertar");
        insert.setFont(new Font("Arial",Font.PLAIN,16));
        
        this.punto = new JMenuItem("Punto");
        punto.setFont(new Font("Arial",Font.PLAIN,16));
        insert.add(punto);
  
        this.linea = new JMenuItem("Linea");
        linea.setFont(new Font("Ariel",Font.PLAIN,16));
        insert.add(linea);
        
        this.circulo = new JMenuItem("circulo");
        circulo.setFont(new Font("Ariel",Font.PLAIN,16));
        insert.add(circulo);
        
        this.circulo2 = new JMenuItem("circulo");
        circulo2.setFont(new Font("Ariel",Font.PLAIN,16));
        insert.add(circulo2);

        this.menu.add(insert);
    }
    private void help(){
        this.help = new JMenu("ayuda");
        help.setFont(new Font("Arial",Font.PLAIN,16));
       
        JMenuItem ayuda = new JMenuItem("ayuda");
        ayuda.setFont(new Font("Ariel",Font.PLAIN,16));
        this.help.add(ayuda);
        
        this.menu.add(this.help);
    }
    public void button(){
        line = new JLabel(new ImageIcon("imagen"));
        circle = new JLabel(new ImageIcon("imagen"));
        cuadrado = new JLabel(new ImageIcon("imagen"));
        triangulos = new JLabel(new ImageIcon("imagen"));
        textos = new JLabel(new ImageIcon("imagen"));
        colores = new JLabel(new ImageIcon("imagen"));
        
        lBresenham = new JButton(""+line);
        cBresenham = new JButton(""+circle);
        cuadrilatero = new JButton(""+cuadrado);
        triangulo = new JButton(""+triangulos);
        texto = new JButton(""+textos);
        color = new JButton(""+colores);
    }
    public JButton getLineBresenham(){
        return lBresenham;
    }
    public JButton getCBresenham(){
        return cBresenham;
    }
    public JButton getCuadrilatero(){
        return cuadrilatero;
    }
    public JButton getTriangulo(){
        return triangulo;
    }
    public JButton getTexto(){
        return texto;
    }
    public JButton getColor(){
        return color;
    }
    public Dibujo getCanvas(){
        return dibujo;
    }
    public JMenuItem getPunto(){
        return punto;
    }    
    public JMenuItem getLinea (){
        return linea;
    }
    public JMenuItem getCirculo(){
        return circulo;
    }
    public JMenuItem getCirculo2(){
        return circulo2;
    }
   
}
