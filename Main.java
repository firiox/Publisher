package Publisher;
import Publisher.Vista.*;
import Publisher.Controlador.*;
import Publisher.Modelo.*;

/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String arg[])throws InterruptedException{   
          Frame frame = new Frame();
          ClienteControl controlador = new ClienteControl(frame);
    }
}
