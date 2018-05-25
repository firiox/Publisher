package Vista;
import javax.swing.*;
import java.awt.event.*;
/**
 * Write a description of class InterfasC1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InterfasceC1 extends JFrame implements ActionListener
{
    private Dibujo canvas;
    private JButton pintar;
    private JButton cancel;
    private JLabel etiquetax;
    private JLabel etiquetay;
    private JLabel etiquetaradio;
    private JTextField x;
    private JTextField y ;
    private JTextField radio;
    public InterfasceC1()
    {
       
        setLocationRelativeTo(null);
        setLayout(null);
        label();
        textFiled();
        button();
        setSize(200, 250);
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
        
        this.etiquetaradio = new JLabel();
        this.etiquetaradio.setText("R");
        this.etiquetaradio.setBounds(10,100,50,30);
        add(etiquetaradio);
    }
    public void textFiled(){
        x = new JTextField();
        x.setBounds(25,15,30,20);
        y = new JTextField();
        y.setBounds(25,65,30,20);
        radio = new JTextField();
        radio.setBounds(25,115,30,20);
        add(x);
        add(y);
        add(radio);
    }    
    public void button(){
        pintar = new JButton("pintar");
        pintar.setBounds(10,150,100,30);
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
        int x1;
        int y1;
        int r;
        if(e.getSource() == pintar){
            x1 = Integer.parseInt(this.x.getText());
            y1 = Integer.parseInt(this.y.getText());
            r = Integer.parseInt(this.radio.getText());
            canvas.circle(x1,y1,r);
            setVisible(false);
            
        }
    }

    
    public static void main(String arg[]){
        InterfasceC1 linea = new InterfasceC1();
    }
}
