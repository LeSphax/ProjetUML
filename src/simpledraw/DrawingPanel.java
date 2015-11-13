package simpledraw;

import MVC.MyObservable;
import MVC.MyObserver;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

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

    DrawingTool myCurrentTool;
    Drawing myDrawing;

    public DrawingPanel(Drawing drawing) {
        super();
        setBackground(java.awt.Color.white);
        myDrawing = drawing;
        myDrawing.addObserver(this);
        myCurrentTool = new SelectionTool(this);
        activate(myCurrentTool);
    }

    void activateSelectionTool() {
        terminate(myCurrentTool);
        myCurrentTool = new SelectionTool(this);
        activate(myCurrentTool);
    }

    void activateCircleTool() {
        terminate(myCurrentTool);
        myCurrentTool = new CircleTool(this);
        activate(myCurrentTool);
        myDrawing.clearSelection();
        repaint();
    }

    void activateLineTool() {
        terminate(myCurrentTool);
        myCurrentTool = new LineTool(this);
        activate(myCurrentTool);
        myDrawing.clearSelection();
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHints(qualityHints);
        draw(g2);
        myCurrentTool.draw(g2);
    }

    private void terminate(DrawingTool t) {
        removeKeyListener(t);
        removeMouseListener(t);
        removeMouseMotionListener(t);
    }

    private void activate(DrawingTool t) {
        addKeyListener(t);
        addMouseListener(t);
        addMouseMotionListener(t);
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

    void groupButtonPressed() {

    }

    @Override
    public void update(MyObservable o) {
        repaint();
    }

}
