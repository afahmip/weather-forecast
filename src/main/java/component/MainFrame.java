package main.java.component;

import main.java.retriever.Weather;

import javax.swing.*;
import java.io.IOException;

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

    Weather weather = new Weather("524901");
    try{
      weather.sendGET();
    } catch(IOException e) {
      System.out.println("Error");
    }
  }
}
