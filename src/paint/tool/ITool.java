/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.tool;

import java.awt.event.MouseEvent;
import paint.ui.Canvas;

/**
 *
 * @author HaRy7x
 */
public interface ITool {

	public void actionMouseClicked(MouseEvent evt, Canvas canvas);
	public void actionMouseDragged(MouseEvent evt, Canvas canvas);
	public void actionMouseReleased(MouseEvent evt, Canvas canvas);

}