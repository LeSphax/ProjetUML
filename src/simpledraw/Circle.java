package simpledraw;

import visitor.Visitor;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 * A circle
 *
 */
public class Circle
        extends Shape {

    private Point myCenter;
    private int myRadius;

    /**
     * Construct a Circle
     *
     * @param center The center of the circle
     * @param radius The radius of the circle
     *
     */
    public Circle(Point center, int radius) {
        myCenter = center;
        myRadius = radius;
    }

    public void draw(Graphics2D g) {
        g.setColor(
                isSelected()
                        ? Color.red
                        : Color.black
        );
        g.drawOval(getMyCenter().x - getMyRadius(),
                getMyCenter().y - getMyRadius(),
                getMyRadius() * 2,
                getMyRadius() * 2
        );
    }

    public void translateBy(int dx, int dy) {
        getMyCenter().translate(dx, dy);
    }

    public boolean isPickedBy(Point p) {
        return (Math.abs(getMyCenter().distance(p) - getMyRadius()) <= 2);
    }

    @Override
    public String toString() {
        return "Circle with (" + getMyCenter().x + "," + getMyCenter().y + ") as origin and a diameter of " + getMyRadius();
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    /**
     * @return the myCenter
     */
    public Point getMyCenter() {
        return myCenter;
    }

    /**
     * @return the myRadius
     */
    public int getMyRadius() {
        return myRadius;
    }

}
