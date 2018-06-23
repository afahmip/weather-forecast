package main.java.component;

import main.java.retriever.WeatherRetriever;

import javax.swing.*;
import java.io.IOException;

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

//    WeatherRetriever weather = new WeatherRetriever("1650357");
//    try{
//      weather.sendGET();
//    } catch(IOException e) {
//      System.out.println("Error");
//    }
  }
}
