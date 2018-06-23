package main.java.component;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import main.java.retriever.CityFinder;
import main.java.retriever.WeatherRetriever;
import org.json.simple.JSONObject;

public class SearchPanel extends JPanel {
  private static class RoundedBorder implements Border {

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

  private JButton searchButton;
  private JTextField searchInput;
  private CityFinder cityFinder;

  public SearchPanel() {
    setBounds(0, 0, 235, 647);
    setBackground(new Color(247,247,247));
    setLayout(null);

    //setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));

    initButton();
    this.cityFinder = new CityFinder();

    this.searchInput = new JTextField();
    this.searchInput.setBounds(29,50, 175,33);
    add(this.searchInput);
  }

  private void initButton() {
    this.searchButton = new JButton("Find City");
    this.searchButton.setBounds(29,100,175,33);
//    this.searchButton.setBorder(new RoundedBorder(10));
    this.searchButton.setBackground(new Color(209, 209, 209));
    this.searchButton.setForeground(new Color(51, 51, 51));

    this.searchButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String val = searchInput.getText();
        findCity(val);
      }
    });

    add(this.searchButton);
  }

  private void findCity(String cityName) {
    ArrayList<JSONObject> cityResult = this.cityFinder.findCityId(cityName);
    if (cityResult.size() == 1) {
      String cityId = cityResult.get(0).get("id").toString();
      getWeatherData(cityId);
    } else if (cityResult.size() == 0) {
      notFound();
      repaint();
    } else if (cityResult.size() > 1) {

    }
  }

  private void notFound() {
    JLabel error404 = new JLabel("404");
    error404.setBounds(72,150, 150,70);
    error404.setForeground(new Color(112, 112, 112));
    error404.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 50));
    add(error404);

    JLabel notfound = new JLabel("City not found!");
    notfound.setBounds(57,200, 150,70);
    notfound.setForeground(new Color(112, 112, 112));
    notfound.setFont(new Font("Segoe UI", Font.PLAIN, 18));
    add(notfound);
  }

  private void getWeatherData(String cityId) {
    WeatherRetriever retriever = new WeatherRetriever(cityId);
    try {
      retriever.sendGET();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
