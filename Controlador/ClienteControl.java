package Publisher.Controlador;
import Publisher.Vista.Frame;
import Publisher.Vista.InterfasceP;
import Publisher.Vista.InterfaceL1;
import Publisher.Vista.InterfasceC1;
import Publisher.Vista.InterfaceC2;
import javax.swing.*;
import java.awt.event.*;

/**
 * Write a description of class ClienteControl here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClienteControl implements MouseListener,ActionListener
{ 
    private Frame frame;
    private InterfasceP punto;
    private InterfaceL1 linea;
    private InterfasceC1 circulo;
    private InterfaceC2 circulo2;
    
    public ClienteControl(Frame vista){
        this.frame = vista; 
        this.frame.getPunto().addActionListener(this);
        this.frame.getLinea().addActionListener(this);
        this.frame.getCirculo().addActionListener(this);
        this.frame.getCirculo2().addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == frame.getPunto()){
            punto = new InterfasceP();    
            punto.canvas(frame.getCanvas());
        } 
        if(e.getSource() == frame.getLinea()){
            linea = new InterfaceL1();
            linea.canvas(frame.getCanvas());
        }
        if(e.getSource() == frame.getCirculo()){
            circulo = new InterfasceC1();
            circulo.canvas(frame.getCanvas());
        }        
        if(e.getSource() == frame.getCirculo2()){
            circulo2 = new InterfaceC2();
            circulo2.canvas(frame.getCanvas());
        }
    }
    
    public void mouseClicked(MouseEvent evento){
        
    }
    
    public void mousePressed(MouseEvent evento){
        
    }
    public void mouseReleased(MouseEvent evento){}
    public void mouseExited(MouseEvent evento){}
    public void mouseEntered(MouseEvent evento){}
    
}
