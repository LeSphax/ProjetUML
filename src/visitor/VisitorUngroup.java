/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor;

import simpledraw.Circle;
import simpledraw.Drawing;
import simpledraw.Line;
import simpledraw.PolyLine;
import simpledraw.Shape;
import simpledraw.ShapeComposite;

public class VisitorUngroup implements Visitor {

    private Drawing drawing;

    public VisitorUngroup(Drawing d) {
        drawing = d;
    }

    @Override
    public void visit(Line line) {
    }

    @Override
    public void visit(Circle circle) {
    }

    @Override
    public void visit(ShapeComposite group) {
        if (group.isSelected()) {
            for (Shape s : group.getChildren()) {
                drawing.addShape(s);
            }
            drawing.deleteShape(group);
        }
    }

    @Override
    public void visit(PolyLine polyLine) {
    }

}
