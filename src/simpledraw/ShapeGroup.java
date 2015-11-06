/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpledraw;

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
        for (Shape s : myShapes) {
            s.draw(g);
        }
    }

    @Override
    public void translateBy(int dx, int dy) {
        for (Shape s : myShapes) {
            s.translateBy(dx, dy);
        }
    }

    @Override
    public boolean isPickedBy(Point p) {
        for (Shape s : myShapes) {
            if (s.isPickedBy(p)) {
                return true;
            }
        }
        return false;
    }

}