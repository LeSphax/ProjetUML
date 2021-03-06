package simpledraw;

/**
 * The tool to create circles
 **/

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class CircleTool
	extends DrawingTool {
	private boolean iAmActive = false;
	private Point myCenter;
	private int myRadius;

	public CircleTool(DrawingPanel panel) {
		super(panel);
	}

        @Override
	public void mousePressed(MouseEvent e) {
		if (!iAmActive) {
			// Center
			iAmActive = true;
			myCenter = e.getPoint();
			myRadius = 0;
			myPanel.setCursor(
				Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR)
				);
		} else {
			// Radius
			iAmActive = false;
                        myPanel.setCursor(Cursor.getDefaultCursor());
			myDrawing.addShape(
				new Circle(myCenter, myRadius)
				);
		}
	}

        @Override
	public void mouseMoved(MouseEvent e) {
		if (iAmActive) {
			myRadius = (int) (
				myCenter.distance(e.getPoint())
				);
			myPanel.repaint();
		}
	}
        @Override
	public void mouseDragged(MouseEvent e) {
            mouseMoved(e);
        }

        @Override
	void draw(Graphics2D g) {
		if (iAmActive) {
			g.setColor(Color.red);
			g.drawOval(
				myCenter.x - myRadius,
				myCenter.y - myRadius,
				myRadius * 2,
				myRadius * 2
				);
		}
	}
}