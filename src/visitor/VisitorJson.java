/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor;

import simpledraw.Circle;
import simpledraw.Line;
import simpledraw.PolyLine;
import simpledraw.ShapeGroup;

/**
 *
 * @author kerbrase
 */
public class VisitorJson extends Visitor {
    
    

    @Override
    public String visit(Line line) {
       return "<Line start=\"" ;
    }

    @Override
    public String visit(Circle circle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String visit(ShapeGroup group) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String visit(PolyLine polyLine) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
