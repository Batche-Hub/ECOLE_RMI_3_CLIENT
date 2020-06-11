/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.ecole.vue.swingPerso;

import fr.doranco.ecole.vue.swingPerso.RoundedCornerBorder;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.util.Objects;

/**
 *
 * @author Boule
 */
public class KamabokoBorder extends RoundedCornerBorder {

    public KamabokoBorder(int rayon) {
        super(rayon);
    }
  // private static TexturePaint makeCheckerTexture() {
  //   int cs = 6;
  //   int sz = cs * cs;
  //   BufferedImage bi = new BufferedImage(sz, sz, BufferedImage.TYPE_INT_ARGB);
  //   Graphics2D g2 = bi.createGraphics();
  //   g2.setPaint(new Color(200, 150, 100, 50));
  //   g2.fillRect(0, 0, sz, sz);
  //   for (int i = 0; i * cs < sz; i++) {
  //     for (int j = 0; j * cs < sz; j++) {
  //       if ((i + j) % 2 == 0) {
  //         g2.fillRect(i * cs, j * cs, cs, cs);
  //       }
  //     }
  //   }
  //   g2.dispose();
  //   return new TexturePaint(bi, new Rectangle(sz, sz));
  // }
  // private static TexturePaint tp = makeCheckerTexture();
  @Override public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
    Graphics2D g2 = (Graphics2D) g.create();
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    int r = 12;
    int w = width - 1;
    int h = height - 1;

    Path2D p = new Path2D.Double();
    p.moveTo(x, y + h);
    p.lineTo(x, y + r);
    p.quadTo(x, y, x + r, y);
    p.lineTo(x + w - r, y);
    p.quadTo(x + w, y, x + w, y + r);
    p.lineTo(x + w, y + h);
    p.closePath();
    Area round = new Area(p);

    // Area round = new Area(new RoundRectangle2D.Double(x, y, w, h, r, r));
    // Rectangle b = round.getBounds();
    // b.setBounds(b.x, b.y + r, b.width, b.height - r);
    // round.add(new Area(b));

    Container parent = c.getParent();
    if (Objects.nonNull(parent)) {
      g2.setPaint(parent.getBackground());
      Area corner = new Area(new Rectangle2D.Double(x, y, width, height));
      corner.subtract(round);
      g2.fill(corner);
    }
    // g2.setPaint(tp);
    // g2.fill(round);
    g2.setPaint(c.getForeground());
    g2.draw(round);
    g2.dispose();
  }
}
