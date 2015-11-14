package simpledraw;

import mvc.MyObservable;
import mvc.MyObserver;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import mvc.DrawingController;

/**
 * A Panel that displays a Drawing, and maintains a current DrawingTool<BR>
 * Uses the "State" design pattern
 *
 * @author Rémi Bastide
 * @version 1.0
 * @see simpledraw.Drawing
 * @see simpledraw.DrawingTool
 */
public class DrawingPanel
        extends JPanel implements MyObserver {

    Drawing myDrawing;
    DrawingController myController;

    public DrawingPanel(Drawing drawing) {
        super();
        setBackground(java.awt.Color.white);
        myDrawing = drawing;
        myController = new DrawingController(drawing, this);
        myDrawing.addObserver(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHints(qualityHints);
        draw(g2);
        myController.getMyCurrentTool().draw(g2);
    }

    /**
     * Displays the drawing
     *
     * @param g The Graphics to display on
     *
     */
    public final void draw(Graphics2D g) {
        for (Shape s : myDrawing.getMyShapes()) {
            s.draw(g);
        }
    }

    @Override
    public void update(MyObservable o) {
        repaint();
    }

    void onSelectedClicked(ActionEvent e) {
        myController.activateSelectionTool();
    }

    void onLineClicked(ActionEvent e) {
        myController.activateLineTool();
    }

    void onCircleClicked(ActionEvent e) {
        myController.activateCircleTool();
    }

    void onGroupClicked(ActionEvent e) {
        myController.handlerGroupClicked();
    }

    void onUnGroupClicked(ActionEvent e) {
        myController.handlerUngroupClicked();
    }
}
