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
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

/**
 *
 * @author kerbrase
 */
public class VisitorJson implements Visitor {

    private StringBuilder result;
    private final Gson gson;

    public VisitorJson() {
        result = new StringBuilder();
        final GsonBuilder builder = new GsonBuilder();

        gson = builder.create();
    }

    @Override
    public void visit(Line line) {
        result.append(gson.toJson(line));
        System.out.println(result);
    }

    @Override
    public void visit(Circle circle) {
        result.append(gson.toJson(circle));
    }

    @Override
    public void visit(ShapeComposite group) {
        result.append(gson.toJson(group));
    }

    @Override
    public void visit(PolyLine polyLine) {
        result.append(gson.toJson(polyLine));
    }

    /**
     * @return the result
     */
    public String getResult() {
        return result.toString();
    }

}
