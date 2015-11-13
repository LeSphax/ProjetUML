/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpledraw;

import visitor.Visitor;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author kerbrase
 */
public class ShapeGroup extends Shape {

    private List<Shape> myShapes = new LinkedList<Shape>();

    @Override
    public void draw(Graphics2D g) {
        for (Shape s : getMyShapes()) {
            s.draw(g);
        }
    }

    @Override
    public void translateBy(int dx, int dy) {
        for (Shape s : getMyShapes()) {
            s.translateBy(dx, dy);
        }
    }

    @Override
    public boolean isPickedBy(Point p) {
        for (Shape s : getMyShapes()) {
            if (s.isPickedBy(p)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String accept(Visitor v) {
        return v.visit(this);
    }

    /**
     * @return the myShapes
     */
    public List<Shape> getMyShapes() {
        return myShapes;
    }

}
