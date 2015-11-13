package simpledraw;

import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;



    
 public class SelectionTool
        extends DrawingTool {

    private Point myLastPoint;

    public SelectionTool(DrawingPanel panel) {
        super(panel);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_DELETE) {  
                for (Shape s : myDrawing.getSelection()) {
                    myDrawing.deleteShape(s);
            }
        }
    }

    public void mousePressed(MouseEvent e) {
        Shape pickedShape = myDrawing.pickShapeAt(e.getPoint());
        myLastPoint = e.getPoint();

        if (pickedShape == null) {
            myDrawing.clearSelection();
            return;
        }

        if (e.isShiftDown()) {
            if(pickedShape.isSelected()){
                pickedShape.setSelected(false);
            }else{
                pickedShape.setSelected(true);
            }
        } else {
            myDrawing.clearSelection();
            pickedShape.setSelected(true);
        }
        myPanel.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        myDrawing.setChanged();
    }

    public void mouseReleased(MouseEvent e) {
        mouseMoved(e);
    }

    public void mouseMoved(MouseEvent e) {
        Shape pickedShape = myDrawing.pickShapeAt(e.getPoint());
        if (pickedShape != null) {
//                        myDrawing.clearSelection();
//                        pickedShape.setSelected(true);
            myPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        } else {
            myPanel.setCursor(Cursor.getDefaultCursor());
        }
    }

    public void mouseDragged(MouseEvent e) {
//		if (!listSelectedShape.isEmpty()) {
        for (Shape s : myDrawing.getSelection()) {
            s.translateBy(
                    e.getX() - myLastPoint.x,
                    e.getY() - myLastPoint.y
            );
        }
        myLastPoint = e.getPoint();
               myDrawing.setChanged();
//		}
    }

    void draw(Graphics2D g) {
    }

}
