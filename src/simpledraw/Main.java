package simpledraw;

import MVC.SecondaryFrame;

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
        frame.validate();
        frame.setVisible(true);
        MainFrame mainFrame2 = new MainFrame(myDrawing);
        mainFrame2.validate();
        mainFrame2.setVisible(true);
        SecondaryFrame secondFrame = new SecondaryFrame(myDrawing);
        secondFrame.setLocation(500, 0);
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
