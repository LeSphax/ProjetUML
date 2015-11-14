package mvc;

import simpledraw.CircleTool;
import simpledraw.Drawing;
import simpledraw.DrawingPanel;
import simpledraw.DrawingTool;
import simpledraw.LineTool;
import simpledraw.SelectionTool;
import simpledraw.Shape;
import simpledraw.ShapeComposite;

public class DrawingController {

    DrawingTool myCurrentTool;
    Drawing myDrawing;
    DrawingPanel myDrawingPanel;

    public DrawingController(Drawing drawing, DrawingPanel drawingPanel) {
        myDrawingPanel = drawingPanel;
        myDrawing = drawing;
        myCurrentTool = new SelectionTool(myDrawingPanel);
        activate(myCurrentTool);
    }

    public void activateSelectionTool() {
        terminate(myCurrentTool);
        myCurrentTool = new SelectionTool(myDrawingPanel);
        activate(myCurrentTool);
    }

    public void activateCircleTool() {
        terminate(myCurrentTool);
        myCurrentTool = new CircleTool(myDrawingPanel);
        activate(myCurrentTool);
        myDrawing.clearSelection();
    }

    public void activateLineTool() {
        terminate(myCurrentTool);
        myCurrentTool = new LineTool(myDrawingPanel);
        activate(myCurrentTool);
        myDrawing.clearSelection();
    }

    public void handlerGroupClicked() {
        if(!myDrawing.getSelection().isEmpty()){
            myDrawing.addShape(new ShapeComposite(myDrawing.getSelection()));
            for (Shape s : myDrawing.getSelection()) {
                myDrawing.deleteShape(s);
            }
            myDrawing.clearSelection();
        }
    }

    public void handlerUngroupClicked() {
        myDrawing.ungroupSelection();
    }

    private void terminate(DrawingTool t) {
        myDrawingPanel.removeKeyListener(t);
        myDrawingPanel.removeMouseListener(t);
        myDrawingPanel.removeMouseMotionListener(t);
    }

    private void activate(DrawingTool t) {
        myDrawingPanel.addKeyListener(t);
        myDrawingPanel.addMouseListener(t);
        myDrawingPanel.addMouseMotionListener(t);
    }

    public DrawingTool getMyCurrentTool() {
        return myCurrentTool;
    }
}
