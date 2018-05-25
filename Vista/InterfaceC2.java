package Vista;
import javax.swing.*;
import java.awt.event.*;
/**
 * Write a description of class InterfaceL2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InterfaceC2 extends JFrame implements ActionListener
{
    
    private Dibujo canvas;
    
    private JButton pintar;    
    private JButton cancel;
    
    private JLabel etiquetax;
    private JLabel etiquetay;
    private JLabel etiquetax1;
    private JLabel etiquetay1;
    
    private JTextField x;
    private JTextField y;
    private JTextField x1;
    private JTextField y1;
    
    public InterfaceC2()
    {
        
        setLocationRelativeTo(null);
        setLayout(null);
        label();
        textFiled();
        button();
        setSize(150, 200);
        setVisible(true);
        setResizable(false);
    }
    public void label(){
        this.etiquetax = new JLabel();
        this.etiquetax.setText("x");
        this.etiquetax.setBounds(10, 10, 50, 30);
        add(etiquetax);
        
        this.etiquetay = new JLabel();
        this.etiquetay.setText("y");
        this.etiquetay.setBounds(10,50, 50, 30);
        add(etiquetay);
        
        this.etiquetax1 = new JLabel();
        this.etiquetax1.setText("x1");
        this.etiquetax1.setBounds(70, 10, 50, 30);
        add(etiquetax1);
        
        this.etiquetay1 = new JLabel();
        this.etiquetay1.setText("y1");
        this.etiquetay1.setBounds(70,50, 50, 30);
        add(etiquetay1);
        
    }
    public void textFiled(){
        x = new JTextField();
        x.setBounds(25,15,30,20);
        y = new JTextField();
        y.setBounds(25,65,30,20);
        
        x1 = new JTextField();
        x1.setBounds(100,15,30,20);
        y1 = new JTextField();
        y1.setBounds(100,65,30,20);
        add(x);
        add(y);
        add(x1);
        add(y1);
                        
    }    
    public void button(){
        pintar = new JButton("pintar");
        pintar.setBounds(10,100,100,30);
        pintar.addActionListener(this);
        add(pintar);
        cancel = new JButton("cancel");
    }    
    public JButton getAceptar(){
        return pintar;
    } 
    public JButton getCancel(){
        return cancel;
    }
    public void canvas(Dibujo canvas){
        this.canvas = canvas;
    }
    public void actionPerformed(ActionEvent e){
        int puntox,puntoy,puntox1,puntoy1;
        if(e.getSource() == pintar){
            puntox = Integer.parseInt(x.getText());
            puntoy = Integer.parseInt(y.getText());
            puntox1 = Integer.parseInt(x1.getText());
            puntoy1 = Integer.parseInt(y1.getText());
            canvas.circulo2P(puntox,puntoy,puntox1,puntoy1);
            setVisible(false);
        }
    }
    public static void main(String arg[]){
        InterfaceC2 circle2puntos = new InterfaceC2();
    }
}
