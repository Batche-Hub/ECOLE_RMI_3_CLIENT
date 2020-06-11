/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.ecole.vue.swingPerso;

import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Objects;
import javax.swing.border.AbstractBorder;

/**
 *
 * @author Boule
 */
public class RoundedCornerBorder extends AbstractBorder {

    private static final long serialVersionUID = 4778684725214901226L;

    int rayon;

    public RoundedCornerBorder(int rayon) {
        this.rayon = rayon;
    }
    
    
    
    
  @Override public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
    Graphics2D g2 = (Graphics2D) g.create();
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    
    int rayon2 = rayon;
    int w = width - 1;
    int h = height - 1;

    Area round = new Area(new RoundRectangle2D.Double(x, y, w, h, rayon2, rayon2));

    Container parent = c.getParent();
    if (Objects.nonNull(parent)) {
      g2.setPaint(parent.getBackground());
      Area corner = new Area(new Rectangle2D.Double(x, y, width, height));
      corner.subtract(round);
      g2.fill(corner);
    }
    g2.setPaint(c.getForeground());
    g2.draw(round);
    g2.dispose();
  }

  @Override public Insets getBorderInsets(Component c) {
    return new Insets(2, 8, 2, 8);
  }

  @Override public Insets getBorderInsets(Component c, Insets insets) {
    insets.set(15, 30, 15, 30);
    return insets;
  }
}
