/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpledraw;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import visitor.Visitor;

public class ShapeComposite extends Shape {
    
    private List<Shape> myShapes = new ArrayList<>();
    
    public ShapeComposite(List<Shape> list) {
        myShapes.addAll(list);
    }
    
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
        Shape result = null;
        for (Shape s : myShapes) {
            if (s.isPickedBy(p)) {
                result = s;
                break;
            }
        }
        return result != null;
    }
    
    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        for (Shape s : myShapes) {
            s.setSelected(selected);
        }
    }
    
    public void remove(Shape s) {
        myShapes.remove(s);
    }
    
    public void add(Shape s) {
        myShapes.add(s);
    }
    
    public List<Shape> getChildren() {
        return myShapes;
    }
    
    @Override
    public String toString() {
        return "Group composed of " + myShapes.size() + " shapes";
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
   
}
