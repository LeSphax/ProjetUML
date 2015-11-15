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
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import visitor.VisitorUngroup;

public class Drawing extends MyObservable {

    /**
     * A drawing is a collection of shapes
     */
    private final LinkedList<Shape> myShapes = new LinkedList<>();

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

    public void setChanged() {
        notifyObservers();
    }

    public void saveJson() throws FileNotFoundException {
        VisitorJson visitorJson = new VisitorJson();
        accept(visitorJson);
        PrintWriter out = new PrintWriter("Saving.txt");
        out.print(visitorJson.getResult());
        out.close();
    }

    public void ungroupSelection() {
        visitor.Visitor sv = new VisitorUngroup(this);
        accept(sv);
        clearSelection();
        notifyObservers();
    }

    public void accept(visitor.Visitor v) {
        LinkedList<Shape> copy = (LinkedList) myShapes.clone();
        for (Shape s : copy) {
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
}
