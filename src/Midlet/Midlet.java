package Midlet;

import Canves.Canves_1;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.midlet.*;

public class Midlet extends MIDlet {
    
    private Canves_1 canv_1;
    public static Display display;
    
    private void init() {
        
        display = Display.getDisplay(this);
        canv_1 = new Canves_1();
    }
    
    public void startApp() {
        init();
        display.setCurrent(canv_1);
        
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
}
