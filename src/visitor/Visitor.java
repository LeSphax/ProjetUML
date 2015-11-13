/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor;

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

   
    public abstract String visit(Line line);

    public abstract String visit(Circle circle);

    public abstract String visit(ShapeGroup group);

    public abstract String visit(PolyLine polyLine);

}
