package simpledraw;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mvc.SecondaryFrame;

/**
 * Main program of SimpleDraw
 *
 * @author Rémi Bastide
 * @version 1.0
 */
public class Main {

    /**
     * Construct the application
     */
    public static void start() {
        Drawing myDrawing = new Drawing();
        
        MainFrame frame = new MainFrame(myDrawing);
        frame.setLocation(50, 100);
        frame.validate();
        frame.setVisible(true);
        MainFrame mainFrame2 = new MainFrame(myDrawing);
        mainFrame2.setLocation(frame.getX() + frame.getWidth(), frame.getY());
        mainFrame2.validate();
        mainFrame2.setVisible(true);
        SecondaryFrame secondFrame = new SecondaryFrame(myDrawing);
        secondFrame.setLocation(mainFrame2.getX() + mainFrame2.getWidth(), mainFrame2.getY());
        secondFrame.validate();
        secondFrame.setVisible(true);
    }

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        start();
    }
}
