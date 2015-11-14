package simpledraw;

/**
 * Drawing, a collection of Shapes
 *
 * @author Rémi Bastide
 * @version 1.0
 * @see simpledraw.Shape
 */
import mvc.MyObservable;
import visitor.VisitorJson;
import java.util.*;

import java.awt.Point;
import visitor.VisitorUngroup;

public class Drawing extends MyObservable {

    /**
     * A drawing is a collection of shapes
     */
    private final List<Shape> myShapes = new LinkedList<>();

    public Drawing() {
    }

    /**
     * Add a shape to the Drawing
     *
     * @param s The Shape to add
     *
     */
    public void addShape(Shape s) {
        getMyShapes().add(s);
        notifyObservers();
    }

    /**
     * Delete a shape from the Drawing
     *
     * @param s The Shape to delete
     *
     */
    public void deleteShape(Shape s) {
        getMyShapes().remove(s);
        notifyObservers();
    }

    /**
     * Determines whether the given Point lies whithin a Shape
     *
     * @param p The Point to test
     * @return A Shape selected by this Point or null if no Shape is there
     *
     */
    public Shape pickShapeAt(Point p) {
        Shape result = null;
        for (Shape s : getMyShapes()) {
            if (s.isPickedBy(p)) {
                result = s;
                break;
            }
        }
        return result;
    }

    /**
     * Ensures that no Shape is currently selected
     */
    public void clearSelection() {
        for (Shape s : getMyShapes()) {
            s.setSelected(false);
        }
        notifyObservers();
    }

    /**
     * @return the myShapes
     */
    public List<Shape> getMyShapes() {
        return myShapes;
    }
    
    public void setChanged(){
        notifyObservers();
    }

    public void saveJson() {
//        String result = "";
//
//        return result;
        accept(new VisitorJson());
    }

    public void accept(visitor.Visitor v) {
//    String result = "";
//        for (Shape s : myShapes) {
//            result += s.accept(v);
//        }
        for(Shape s : getSelection()){
            s.accept(v);
        }
    }
    

    public List<Shape> getSelection() {
        List<Shape> listSelected = new ArrayList<>();
        for (Shape s : myShapes) {
            if (s.isSelected()) {
                listSelected.add(s);
            }
        }
        return listSelected;
    }
    
    public void ungroupSelection() {
        visitor.Visitor sv = new VisitorUngroup(this);
        accept(sv);
        clearSelection();
        notifyObservers();
    }
}
