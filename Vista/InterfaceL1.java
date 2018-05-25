package Vista;
import javax.swing.*;
import java.awt.event.*;
/**
 * Write a description of class InterfaceL1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InterfaceL1 extends JFrame implements ActionListener
{
    private Dibujo canvas;
    private JButton pintar;
    private JButton cancel;
    private JLabel etiquetax;
    private JLabel etiquetay;
    private JLabel etiquetam;
    private JTextField x;
    private JTextField y ;
    private JTextField pendiente;
    public InterfaceL1()
    {
        
        setLocationRelativeTo(null);
        setLayout(null);
        label();
        textFiled();
        button();
        setSize(200, 200);
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
        this.etiquetam = new JLabel();
        this.etiquetam.setText("m");
        this.etiquetam.setBounds(10,100,50,30);
        add(etiquetam);
    }
    public void textFiled(){
        x = new JTextField();
        x.setBounds(25,15,30,20);
        y = new JTextField();
        y.setBounds(25,65,30,20);
        pendiente = new JTextField();
        pendiente.setBounds(25,115,30,20);
        add(x);
        add(y);
        add(pendiente);
    }    
    public void button(){
        pintar = new JButton("pintar");
        pintar.setBounds(60,110,100,30);
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
        int x1,y1,m;
        if(e.getSource() == pintar){
            x1 = Integer.parseInt(x.getText());
            y1 = Integer.parseInt(y.getText());
            m = Integer.parseInt(pendiente.getText());;
            canvas.linea(x1,y1,m);
            setVisible(false);
        }
    }
    
    public static void main(String arg[]){
        InterfaceL1 linea = new InterfaceL1();
    }
}
