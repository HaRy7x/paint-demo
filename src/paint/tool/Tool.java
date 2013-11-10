/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.tool;

import java.awt.Point;
import java.awt.event.MouseEvent;
import paint.ui.Canvas;
import paint.ui.Paint;

/**
 *
 * @author HaRy7x
 */
public abstract class Tool implements ITool {

	protected final Paint parent;
	protected Point startPoint;
	protected Point endPoint;

	public Tool(Paint parent) {
		this.parent = parent;
	}

	@Override
	public void actionMouseClicked(MouseEvent evt, Canvas canvas) {
		startPoint = new Point(evt.getX(), evt.getY());
		endPoint = new Point(evt.getX(), evt.getY());
	}

	@Override
	public void actionMouseDragged(MouseEvent evt, Canvas canvas) {
		endPoint = new Point(evt.getX(), evt.getY());
	}

	@Override
	public void actionMouseReleased(MouseEvent evt, Canvas canvas) {
		endPoint = new Point(evt.getX(), evt.getY());
	}
}