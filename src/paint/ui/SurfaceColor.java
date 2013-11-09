/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author HaRy7x
 */
public class SurfaceColor extends JPanel {
    JLabel red, green, blue;
    BufferedImage image;
 
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        int w = getWidth();
        int h = getHeight();
//        GradientPaint gp = new GradientPaint(0, 0, Color.blue,
//                                             w, h, Color.orange, true);
//        g2.setPaint(gp);
		g2.setColor(Color.red);
        g2.fillRect(0,0,w,h);
		
		g2.setColor(Color.BLUE);
		g2.fillRect(50, 50, 50, 50);
    }
 
    private JPanel getLast() {
        red = new JLabel(" ");
        Dimension d = red.getPreferredSize();
        d.width = 45;
        red.setPreferredSize(d);
        green = new JLabel(" ");
        green.setPreferredSize(d);
        blue = new JLabel(" ");
        blue.setPreferredSize(d);
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2,2,2,2);
        gbc.weightx = 1.0;
        addComponents(new JLabel("r = "), red,   panel, gbc);
        addComponents(new JLabel("g = "), green, panel, gbc);
        addComponents(new JLabel("b = "), blue,  panel, gbc);
        return panel;
    }
 
    private void addComponents(Component c1, Component c2, Container c,
                               GridBagConstraints gbc) {
        gbc.anchor = gbc.EAST;
        c.add(c1, gbc);
        gbc.anchor = gbc.WEST;
        c.add(c2, gbc);
    }
 
    private MouseMotionListener reader = new MouseMotionAdapter() {
        public void mouseMoved(MouseEvent e) {
            if(image == null && isDisplayable()) {
                initImage();
            }
            int rgb = image.getRGB(e.getX(), e.getY());
            red.setText(  String.valueOf((rgb >> 16) & 0xff));
            green.setText(String.valueOf((rgb >>  8) & 0xff));
            blue.setText( String.valueOf( rgb        & 0xff));
        }
    };
 
    private ComponentListener sizeMonitor = new ComponentAdapter() {
        public void componentResized(ComponentEvent e) {
            image = null;
        }
    };
 
    private void initImage() {
        image = (BufferedImage)createImage(getWidth(), getHeight());
        Graphics2D g2 = image.createGraphics();
        paint(g2);
        g2.dispose();
    }
 
    public static void main(String[] args) {
        SurfaceColor test = new SurfaceColor();
        test.addMouseMotionListener(test.reader);
        test.addComponentListener(test.sizeMonitor);
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(test);
        f.getContentPane().add(test.getLast(), "Last");
        f.setSize(400,400);
        f.setLocation(200,200);
        f.setVisible(true);
    }
}