package simpledraw;

import visitor.Visitor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

public class PolyLine
	extends Shape {
	/**
	 * The points of this PolyLine
	 */
	private final List<Point> myPoints;

	public PolyLine(Collection<Point> points) {
		if (points.size() < 2) {
			throw new IllegalArgumentException(
				"A PolyLine needs at least 2 Points");
		}
		myPoints = new ArrayList<>(points);
	}

        @Override
	public void translateBy(int dx, int dy) {
		Iterator i = getMyPoints().iterator();
		while (i.hasNext()) {
			Point p = (Point) i.next();
			p.translate(dx, dy);
		}
	}

        @Override
	public void draw(Graphics2D g) {
		g.setColor(
			isSelected() ?
			Color.red :
			Color.black
			);

		Iterator<Point> points = getMyPoints().iterator();
		// A polyline has at least two points
		Point last = points.next();
		do {
			Point current = points.next();
			g.drawLine(last.x, last.y, current.x, current.y);
			last = current;
		}
		while (points.hasNext());
	}

	public boolean isPickedBy(Point p) {
		boolean result = false;
		Iterator<Point> points = getMyPoints().iterator();
		// A polyline has at least two points
		Point last = points.next();
		do {
			Point current = points.next();
			if (Line.segmentIsPickedBy(last, current, p)) {
				result = true;
				break;
			}
			last = current;
		}
		while (points.hasNext());

		return result;
	}

    @Override
    public void accept(Visitor v) {
       v.visit(this);
    }

    /**
     * @return the myPoints
     */
    public List<Point> getMyPoints() {
        return myPoints;
    }



}
