package simpledraw;

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
    public Main() {
        Drawing myDrawing = new Drawing();

        MainFrame frame = new MainFrame(myDrawing);
        frame.validate();
        frame.setVisible(true);
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
        new Main();
    }
}
