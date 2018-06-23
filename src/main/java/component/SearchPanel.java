package main.java.component;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.java.retriever.CityFinder;

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
    this.searchButton.setBorder(new RoundedBorder(10));
    this.searchButton.setBackground(new Color(51, 51, 51));
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

  private void findCity(String cityId) {
    this.cityFinder.findCityId(cityId);
  }
}
