/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.ui.test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author HaRy7x
 */
public class Shapes extends JFrame{
	
	public JFrame mf = new JFrame("Paint");
    DrawArea da = new DrawArea();

        JToggleButton lineButton = new JToggleButton(new ImageIcon("line.gif"));
        JToggleButton brushButton = new JToggleButton();
        JToggleButton pencilButton = new JToggleButton();
        JToggleButton eraserButton = new JToggleButton(new ImageIcon("eraser_icon.png"));
        JToggleButton rectangleButton = new JToggleButton();
        JToggleButton ovalButton = new JToggleButton();

    Shapes() {


        da.setBounds(120, 50, 500, 350);
        da.setBackground(Color.YELLOW);
        mf.setSize(700, 500);
        mf.setLayout(null);

        lineButton.setBounds(0, 50, 40, 40);
        brushButton.setBounds(40, 50, 40, 40);
        eraserButton.setBounds(0, 90, 40, 40);
        pencilButton.setBounds(40, 90, 40, 40);
        rectangleButton.setBounds(0, 130, 40, 40);
        ovalButton.setBounds(40, 130, 40, 40);

        mf.setBackground(Color.red);
        mf.add(lineButton);
        mf.add(brushButton);
        mf.add(pencilButton);
        mf.add(eraserButton);
        mf.add(rectangleButton);
        mf.add(ovalButton);
        mf.add(da);
        mf.show();
        mf.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        mf.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                System.out.println("x:" + e.getX() + "y:" + e.getY() + "\n" + "x2:" + e.getXOnScreen() + "y2:" + e.getYOnScreen());
            }
        });
        eraserButton.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e)
            {
            eraserButton.setSelectedIcon(new ImageIcon("eraser_icon_selected.png"));
        }
        });
        lineButton.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e)
            {
              lineButton.setSelectedIcon(new ImageIcon("line_selected.png"));
        }
        });
        da.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                da.setXvalue(e.getX());
                da.setYvalue(e.getY());



            }

            public void mouseReleased(MouseEvent e) {

                da.setX2value(e.getX());
                da.setY2value(e.getY());
                da.repaint();
            }
        });
        da.addMouseMotionListener(new MouseAdapter() {

            public void mouseDragged(MouseEvent e) {
                da.repaint();
                da.setX2value(e.getX());
                da.setY2value(e.getY());

            }
        });

    }
}



class DrawArea extends JPanel {
    int x1value,y1value,x2value,y2value;

    public int getX2value() {
        return x2value;
    }

    public void setX2value(int x2value) {
        this.x2value = x2value;
    }

    public int getY2value() {
        return y2value;
    }

    public void setY2value(int y2value) {
        this.y2value = y2value;
    }
    public JPanel dra=new JPanel();

    public int getXvalue() {
        return x1value;
    }

    public void setXvalue(int xvalue) {
        this.x1value = xvalue;
    }

    public int getYvalue() {
        return y1value;
    }

    public void setYvalue(int yvalue) {
        this.y1value = yvalue;
    }

    public void paint(Graphics g)
    {
      super.paint(g);
      g.setColor(Color.red);
      g.drawLine(getXvalue(),getYvalue(),getX2value(),getY2value());

}
}

    class Paint extends JPanel

{ 

    public static void main(String args[])
            {
               Shapes s=new Shapes();

            }
}
