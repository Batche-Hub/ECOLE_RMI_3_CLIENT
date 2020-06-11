/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.ecole.vue.swingPerso;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.Icon;

/**
 *
 * @author Boule
 */
public class ArrowIcon implements Icon {
  private final Color color;
  private Color rollover;

  public ArrowIcon(Color color, Color rollover) {
    this.color = color;
    this.rollover = rollover;
  }

  @Override public void paintIcon(Component c, Graphics g, int x, int y) {
    Graphics2D g2 = (Graphics2D) g.create();
    g2.setPaint(color);
    int shift = 0;
    rollover = Color.ORANGE;
    if (c instanceof AbstractButton) {
      ButtonModel m = ((AbstractButton) c).getModel();
      if (m.isPressed()) {
        shift = 1;
      } else {
        if (m.isRollover()) {
          g2.setPaint(rollover);
        }
      }
    }
    g2.translate(x, y + shift);
    g2.drawLine(3, 4, 7, 4);
    g2.drawLine(4, 5, 6, 5);
    g2.drawLine(5, 6, 5, 6);
    g2.dispose();
  }

  @Override public int getIconWidth() {
    return 15;
  }

  @Override public int getIconHeight() {
    return 10;
  }
}
