package Vista;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Write a description of class Opcione here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Opciones extends JFrame implements ChangeListener
{
    // private Dibujo canvas;
    private JRadioButton check0,check1,check2,check3,check4,check5;
    private ButtonGroup bg;
    public Opciones(){
        setLayout(null);
        
        bg = new ButtonGroup();
        check0 = new JRadioButton("default");
        check0.setBounds(10,10,150,30);
        check0.addChangeListener(this);
        add(check0);
        bg.add(check0);
        check1 = new JRadioButton("Linea");
        check1.setBounds(10,10,150,30);
        check1.addChangeListener(this);
        add(check1);
        bg.add(check1);
        check2 = new JRadioButton("Circulo");
        check2.setBounds(10,50,150,30);
        check2.addChangeListener(this);
        add(check2);
        bg.add(check2);
        check3 = new JRadioButton("triangulo");
        check3.setBounds(10,100,150,30);
        check3.addChangeListener(this);
        add(check3);
        bg.add(check3);
        check4 = new JRadioButton("Cuadrilatero");
        check4.setBounds(10,150,150,30);
        check4.addChangeListener(this);
        add(check4);
        bg.add(check4);
        check5 = new JRadioButton("figura");
        check5.setBounds(10,200,150,30);
        check5.addChangeListener(this);
        add(check5); 
        bg.add(check5);
    }
    // public void canvas(Dibujo canvas){
        // this.canvas = canvas;
    // }
    
    public void stateChanged(ChangeEvent e){
        String cad ="";
        if(check1.isSelected() == true){
            cad = "dibujar linea";
        }
        if(check2.isSelected() == true){
            cad = "dibujar circunferencia";
        }
        if(check3.isSelected() == true){
            cad = "dibujar triangulo";
        }
        if(check4.isSelected() == true){
            cad = "dibujar cuadrilatero";
        }
        if(check5.isSelected() == true){
            cad = "dibujar figura";
        }
        setTitle(cad);
    }
    
    public static void main(String arg[]){
        Opciones opciones = new Opciones();
        opciones.setBounds(0,0,600,600);
        opciones.setVisible(true);
        opciones.setResizable(false);
        opciones.setLocationRelativeTo(null);
    }
}
