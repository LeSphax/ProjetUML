/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visitor;

import java.util.List;
import simpledraw.Circle;
import simpledraw.Drawing;
import simpledraw.Line;
import simpledraw.PolyLine;
import simpledraw.Shape;
import simpledraw.ShapeGroup;

/**
 *
 * @author kerbrase
 */
public abstract class Visitor {

    public String visit(Drawing drawing) {
        List<Shape> shapes = drawing.getMyShapes();
        String result = "";
        for (Shape s : shapes) {
            result += s.accept(this);
        }
        return result;
    }

    public abstract String visitLine(Line line);

    public abstract String visitCircle(Circle circle);

    public abstract String visitGroup(ShapeGroup group);

    public abstract String visitPolyLine(PolyLine polyLine);

}
