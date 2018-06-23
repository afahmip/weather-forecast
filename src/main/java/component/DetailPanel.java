package main.java.component;

import javax.swing.*;
import java.awt.*;

public class DetailPanel extends JPanel {

  public DetailPanel() {
    setBounds(301, 0, 723, 647);
    setBackground(new Color(0, 133, 248));
    setLayout(null);

    JLabel tempLabel = new JLabel("25°C");
    tempLabel.setBounds(305,50, 150,70);
    tempLabel.setForeground(Color.white);
    tempLabel.setFont(new Font("Segoe UI", Font.PLAIN, 70));
    add(tempLabel);

    JLabel cityLabel = new JLabel();
    cityLabel.setText("Bandung");
    cityLabel.setBounds(475,52, 300,40);
    //cityLabel.setSize(cityLabel.getPreferredSize());
    cityLabel.setForeground(Color.white);
    cityLabel.setFont(new Font("Segoe UI", Font.PLAIN, 30));
    add(cityLabel);

    JLabel timeLabel = new JLabel("09.15 PM");
    timeLabel.setBounds(475,97, 300,25);
    timeLabel.setForeground(Color.white);
    timeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
    add(timeLabel);

    JPanel detailInfo = new JPanel();
    detailInfo.setLayout(new BoxLayout(detailInfo, BoxLayout.X_AXIS));
    detailInfo.setBounds(305, 389, 649, 163);
    detailInfo.setBackground(Color.white);
    add(detailInfo);
  }



}
