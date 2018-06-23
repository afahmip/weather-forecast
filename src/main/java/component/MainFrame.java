package main.java.component;

import main.java.retriever.WeatherRetriever;
import main.java.component.SearchPanel;
import main.java.component.DetailPanel;
import javax.swing.*;

public class MainFrame extends JFrame {
  private SearchPanel searchPanel;
  private DetailPanel detailPanel;

  public MainFrame() {
    super("Weather Forecast");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.searchPanel = new SearchPanel();
    getContentPane().add(this.searchPanel);
    this.detailPanel = new DetailPanel();
    getContentPane().add(this.detailPanel);

    setSize(1024,647);
    setVisible(true);
    setLayout(null);

  }
}
