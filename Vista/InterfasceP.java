package Vista;

import javax.swing.*;
import java.awt.event.*;
/**
 * Write a description of class interfasceP here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InterfasceP extends JFrame implements ActionListener
{
    private Dibujo canvas;
    private JLabel labelx;
    private JTextField x;
    private JLabel labely;
    private JTextField y;
    private JButton pintar;
    public InterfasceP(){
        setTitle("Punto");
        setBounds(0,0,200,200);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        // label de x
        labelx = new JLabel("x :");
        labelx.setBounds(10, 10, 50, 30);
        add(labelx);
        //cuadro de texto de x
        x = new JTextField(); 
        x.setBounds(25,15,30,20);
        add(x);
        // label de y
        labely = new JLabel("y :");
        labely.setBounds(10, 50, 30, 20);
        add(labely);
        //cuadro de texto de y
        y = new JTextField(); 
        y.setBounds(25,55,30,20);
        add(y);
        // boton
        pintar = new JButton("Pintar");
        pintar.setBounds(10,100,100,30);
        pintar.addActionListener(this);
        add(pintar);    
    }
    public JButton getPintar(){
        return pintar;
    }
    public void canvas(Dibujo canvas){
        this.canvas = canvas;
    }
                 
    public void actionPerformed(ActionEvent e){
        int x1,y1;
        if(e.getSource() == pintar){
            x1 = Integer.parseInt(this.x.getText());
            y1 = Integer.parseInt(this.y.getText());
            canvas.point(y1,x1);
            setVisible(false);
        }
    }
    /*
    public static void main(String arg[]){
        InterfasceP punto = new InterfasceP();
    } */       
}
