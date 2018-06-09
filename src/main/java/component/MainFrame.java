package main.java.component;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
  public MainFrame() {
    super("Weather Forecast");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500,768);
    setVisible(true);
  }
}
