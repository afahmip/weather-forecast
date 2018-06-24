package main.java.component;

import component.MainPanel;

import javax.swing.*;

public class MainFrame extends JFrame {

  private MainPanel mainPanel;

  public MainFrame() {
    super("Weather Forecast");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.mainPanel = new MainPanel();
    getContentPane().add(this.mainPanel);

    setSize(1024,647);
    setVisible(true);
    setLayout(null);
  }
}
