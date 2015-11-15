/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor;

import simpledraw.Circle;
import simpledraw.Line;
import simpledraw.PolyLine;
import simpledraw.ShapeComposite;

/**
 *
 * @author kerbrase
 */
public interface Visitor {

   
    void visit(Line line);

    void visit(Circle circle);

    void visit(ShapeComposite group);

    void visit(PolyLine polyLine);

}
