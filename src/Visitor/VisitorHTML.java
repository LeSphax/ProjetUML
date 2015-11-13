/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visitor;

import simpledraw.Circle;
import simpledraw.Line;
import simpledraw.PolyLine;
import simpledraw.ShapeGroup;

/**
 *
 * @author kerbrase
 */
public class VisitorHTML extends Visitor {
    
    

    @Override
    public String visitLine(Line line) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String visitCircle(Circle circle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String visitGroup(ShapeGroup group) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String visitPolyLine(PolyLine polyLine) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
