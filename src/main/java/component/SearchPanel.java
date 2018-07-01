package component;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
  private JPanel errorPanel;
  private JScrollPane scrollResultPanel;
  private String foundId;
  private ArrayList<JSONObject> cityResult;

  public SearchPanel() {
    setBounds(0, 0, 235, 720);
    setBackground(new Color(232,236,242));
    setLayout(null);

    this.cityFinder = new CityFinder();
    this.searchInput = new JTextField();
    this.searchInput.setBounds(29,50, 175,33);
    add(this.searchInput);
  }

  public void findCity() {
    String cityName = this.searchInput.getText();
    this.cityResult = this.cityFinder.findCityId(cityName);
    this.foundId = "";

    if(this.isAncestorOf(this.scrollResultPanel)) remove(this.scrollResultPanel);
    if(this.isAncestorOf(this.errorPanel)) remove(this.errorPanel);

    if (this.cityResult.size() == 1) {
      this.foundId = this.cityResult.get(0).get("id").toString();
      repaint();
    } else if (this.cityResult.size() == 0) {
      showErrorPanel();
      repaint();
    } else if (this.cityResult.size() > 1) {
      this.foundId = "MANY";
    }
  }

  public void setScrollResultPanel(JScrollPane pane) {
    this.scrollResultPanel = pane;
    add(this.scrollResultPanel);
  }

  public ArrayList<JSONObject> getCityResult() {
    return this.cityResult;
  }

  public String getFoundId() { return this.foundId; }

  public void setFoundId(String foundId) { this.foundId = foundId; }

  private void showErrorPanel() {
    this.errorPanel = new JPanel();
    this.errorPanel.setBounds(30,150, 175, 140);
    this.errorPanel.setBackground(new Color(255, 255, 255, 0));

    JLabel error404 = new JLabel("404");
    error404.setBounds(0,10, 150,70);
    error404.setForeground(new Color(112, 112, 112));
    error404.setFont(new Font("Varela Round", Font.PLAIN, 50));
    this.errorPanel.add(error404);

    JLabel notfound = new JLabel("City not found!");
    notfound.setBounds(0,80, 150,70);
    notfound.setForeground(new Color(112, 112, 112));
    notfound.setFont(new Font("Varela Round", Font.PLAIN, 18));
    this.errorPanel.add(notfound);

    add(this.errorPanel);
    revalidate();
    repaint();
  }

}
