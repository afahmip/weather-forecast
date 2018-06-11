package main.java.component;

import javax.swing.*;

public class MainFrame extends JFrame {
  private SearchPanel searchPanel;
  private DetailPanel detailPanel;

  public MainFrame() {
    super("Weather Forecast");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(1024,647);
    setVisible(true);
    setLayout(null);

    this.searchPanel = new SearchPanel();
    add(this.searchPanel);
    this.detailPanel = new DetailPanel();
    add(this.detailPanel);
  }
}
