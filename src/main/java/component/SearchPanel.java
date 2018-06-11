package main.java.component;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

class RoundedBorder implements Border {

  private int radius;
  RoundedBorder(int radius) {
    this.radius = radius;
  }

  public Insets getBorderInsets(Component c) {
    return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
  }

  public boolean isBorderOpaque() {
    return true;
  }

  public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
    g.drawRoundRect(x, y, width-1, height-1, radius, radius);
  }
}

public class SearchPanel extends JPanel {
  public SearchPanel() {
    setBounds(0, 0, 301, 647);
    setBackground(new Color(247,247,247));

    JButton b1 = new JButton("button 1");
    b1.setBorder(new RoundedBorder(10));
    b1.setBounds(50,100,80,30);
    b1.setBackground(Color.yellow);
    add(b1);
  }
}
