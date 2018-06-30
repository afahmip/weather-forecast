package main.java.component;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import main.java.retriever.CityFinder;
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

  private JTextField searchInput;
  private CityFinder cityFinder;
  private String foundId;

  public SearchPanel() {
    setBounds(0, 0, 235, 720);
    setBackground(new Color(255,255,255));
    setLayout(null);

    this.cityFinder = new CityFinder();
    this.searchInput = new JTextField();
    this.searchInput.setBounds(29,50, 175,33);
    add(this.searchInput);
  }

  public void findCity() {
    String cityName = this.searchInput.getText();
    ArrayList<JSONObject> cityResult = this.cityFinder.findCityId(cityName);
    this.foundId = "";

    if (cityResult.size() == 1) {
      this.foundId = cityResult.get(0).get("id").toString();
    } else if (cityResult.size() == 0) {
      notFound();
      repaint();
    } else if (cityResult.size() > 1) {
      System.out.println("banyak");
    }
  }

  public String getFoundId() { return this.foundId; }

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

}
