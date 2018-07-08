package main.java.component;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import main.java.retriever.DetailController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class DetailPanel extends JPanel {

  private Image wallpaper;
  private DetailController detailController;
  private JPanel dailyDetailPanel;
  private JPanel welcomePanel;

  public DetailPanel() {
    this.detailController = new DetailController();
    setBounds(235, 0, 789, 720);
    setBackground(new Color(216, 216, 216));
    setLayout(null);
    showWelcomePanel();
  }

  public void updateData(JSONObject data) {
    JLabel cityLabel = new JLabel();
    cityLabel.setText(this.detailController.getCityName(data));
    cityLabel.setBounds(50,120, 300,40);
    cityLabel.setForeground(Color.white);
    cityLabel.setFont(new Font("Varela Round", Font.PLAIN, 30));
    add(cityLabel);

    if(this.isAncestorOf(this.welcomePanel)) remove(this.welcomePanel);
    JSONArray list = (JSONArray) data.get("list");
    JSONObject obj = (JSONObject) list.get(0);
    showDailyDetails(obj);
    generateDailyPanels(list);

    String path = new File("src/main/resource/images/night.jpg").getAbsolutePath();
    this.wallpaper = new ImageIcon(path).getImage();
    revalidate();
    repaint();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(wallpaper, 0, 0, null);
  }

  public void showWelcomePanel() {
    if(this.isAncestorOf(this.dailyDetailPanel)) remove(this.dailyDetailPanel);

    this.welcomePanel = new JPanel();
    this.welcomePanel.setBounds(0, 0, 789, 720);
    this.welcomePanel.setBackground(new Color(255, 255, 255));
    this.welcomePanel.setLayout(null);

    JLabel welcome = new JLabel();
    welcome.setText("Welcome to");
    welcome.setBounds(308, 240, 300, 30);
    welcome.setForeground(new Color(140, 140, 140));
    welcome.setFont(new Font("Varela Round", Font.PLAIN, 25));
    this.welcomePanel.add(welcome);

    JLabel weather = new JLabel();
    weather.setText("WEATHER");
    weather.setBounds(275, 290, 300, 30);
    weather.setForeground(new Color(140, 140, 140));
    weather.setFont(new Font("Varela Round", Font.PLAIN, 40));
    this.welcomePanel.add(weather);

    JLabel forecast = new JLabel();
    forecast.setText("FORECAST");
    forecast.setBounds(272, 335, 300, 30);
    forecast.setForeground(new Color(140, 140, 140));
    forecast.setFont(new Font("Varela Round", Font.PLAIN, 40));
    this.welcomePanel.add(forecast);

    add(this.welcomePanel);

    revalidate();
    repaint();
  }

  private void showDailyDetails(JSONObject obj) {
    if(this.isAncestorOf(this.dailyDetailPanel)) remove(this.dailyDetailPanel);
    this.dailyDetailPanel = new JPanel();
    this.dailyDetailPanel.setBounds(50, 0, 789, 720);
    this.dailyDetailPanel.setBackground(new Color(216, 216, 216, 0));
    this.dailyDetailPanel.setLayout(null);

    JLabel tempLabel = new JLabel();
    tempLabel.setText(this.detailController.getDailyTemp(obj) + "\u00b0c");
    tempLabel.setBounds(0,50, 300,80);
    tempLabel.setForeground(Color.white);
    tempLabel.setFont(new Font("Varela Round", Font.PLAIN, 60));
    this.dailyDetailPanel.add(tempLabel);

    JLabel weatherLabel = new JLabel();
    weatherLabel.setText(this.detailController.getDailyWeatherDetail(obj));
    weatherLabel.setBounds(0,155, 300,40);
    weatherLabel.setForeground(Color.white);
    weatherLabel.setFont(new Font("Varela Round", Font.PLAIN, 20));
    this.dailyDetailPanel.add(weatherLabel);

    JLabel timeLabel = new JLabel();
    String text = this.detailController.getDailyDayFull(obj) + ", " + this.detailController.getDailyMonth(obj)
            + " " + this.detailController.getDailyDate(obj) + " " + this.detailController.getDailyYear(obj);
    timeLabel.setText(text);
    timeLabel.setBounds(0,380, 300,40);
    timeLabel.setForeground(Color.white);
    timeLabel.setFont(new Font("Varela Round", Font.PLAIN, 18));
    this.dailyDetailPanel.add(timeLabel);

    JLabel windLabel = new JLabel();
    windLabel.setText(this.detailController.getDailyWindSpeed(obj) + " m/s");
    windLabel.setBounds(0,220, 300,40);
    windLabel.setForeground(Color.white);
    windLabel.setFont(new Font("Varela Round", Font.PLAIN, 22));
    this.dailyDetailPanel.add(windLabel);

    JLabel wind = new JLabel();
    wind.setText("Wind speed");
    wind.setBounds(0,245, 300,40);
    wind.setForeground(Color.white);
    wind.setFont(new Font("Varela Round", Font.PLAIN, 13));
    this.dailyDetailPanel.add(wind);

    JLabel humidLabel = new JLabel();
    humidLabel.setText(this.detailController.getDailyHumidity(obj) + "%");
    humidLabel.setBounds(180,220, 300,40);
    humidLabel.setForeground(Color.white);
    humidLabel.setFont(new Font("Varela Round", Font.PLAIN, 22));
    this.dailyDetailPanel.add(humidLabel);

    JLabel humid = new JLabel();
    humid.setText("Humidity");
    humid.setBounds(180,245, 300,40);
    humid.setForeground(Color.white);
    humid.setFont(new Font("Varela Round", Font.PLAIN, 13));
    this.dailyDetailPanel.add(humid);

    JLabel windSpeedLabel = new JLabel();
    windSpeedLabel.setText(this.detailController.getDailyWindDirection(obj) + "°");
    windSpeedLabel.setBounds(360,220, 300,40);
    windSpeedLabel.setForeground(Color.white);
    windSpeedLabel.setFont(new Font("Varela Round", Font.PLAIN, 22));
    this.dailyDetailPanel.add(windSpeedLabel);

    JLabel windDir = new JLabel();
    windDir.setText("Wind direction");
    windDir.setBounds(360,245, 300,40);
    windDir.setForeground(Color.white);
    windDir.setFont(new Font("Varela Round", Font.PLAIN, 13));
    this.dailyDetailPanel.add(windDir);

    JLabel cloudLabel = new JLabel();
    cloudLabel.setText(this.detailController.getDailyCloud(obj) + "%");
    cloudLabel.setBounds(0,285, 300,40);
    cloudLabel.setForeground(Color.white);
    cloudLabel.setFont(new Font("Varela Round", Font.PLAIN, 22));
    this.dailyDetailPanel.add(cloudLabel);

    JLabel cloud = new JLabel();
    cloud.setText("Cloudiness");
    cloud.setBounds(0,310, 300,40);
    cloud.setForeground(Color.white);
    cloud.setFont(new Font("Varela Round", Font.PLAIN, 13));
    this.dailyDetailPanel.add(cloud);

    JLabel pressureLabel = new JLabel();
    pressureLabel.setText(this.detailController.getDailyPressure(obj) + " hPa");
    pressureLabel.setBounds(180,285, 300,40);
    pressureLabel.setForeground(Color.white);
    pressureLabel.setFont(new Font("Varela Round", Font.PLAIN, 22));
    this.dailyDetailPanel.add(pressureLabel);

    JLabel pressure = new JLabel();
    pressure.setText("Pressure");
    pressure.setBounds(180,310, 300,40);
    pressure.setForeground(Color.white);
    pressure.setFont(new Font("Varela Round", Font.PLAIN, 13));
    this.dailyDetailPanel.add(pressure);

    add(this.dailyDetailPanel);

    revalidate();
    repaint();
  }

  private void generateDailyPanels(JSONArray list) {
    String date;
    int index = 0;
    JSONObject tmp = (JSONObject) list.get(0);
    date = this.detailController.getDateTime(tmp).split(" ")[0];
    createDailyPanel(tmp, 50+(index*135), index);
    this.detailController.pushIndex(tmp);
    index++;

    for(int i=1; i<list.size(); i++) {
      tmp = (JSONObject) list.get(i);
      String tmpDate =this.detailController. getDateTime(tmp).split(" ")[0];
      if(!tmpDate.equals(date)) {
        date = tmpDate;
        createDailyPanel(tmp, 50+(index*135), index);
        this.detailController.pushIndex(tmp);
        index++;
        if(index == 5) break;
      }
    }
  }

  private void createDailyPanel(JSONObject data, int x, int idx) {
    JPanel panel = new JPanel();
    panel.setBounds(x, 430, 120, 168);
    panel.setBackground(new Color(255, 255, 255, 80));
    panel.setLayout(null);

    JLabel dateLabel = new JLabel();
    dateLabel.setText(this.detailController.getDailyDaySimplified(data) + " " + this.detailController.getDailyDate(data));
    dateLabel.setBounds(5,-12, 120,80);
    dateLabel.setForeground(Color.white);
    dateLabel.setFont(new Font("Varela Round", Font.PLAIN, 23));
    panel.add(dateLabel);

    JLabel tempLabel = new JLabel();
    tempLabel.setText(this.detailController.getDailyTemp(data) + "\u00b0c");
    tempLabel.setBounds(5,75, 120,80);
    tempLabel.setForeground(Color.white);
    tempLabel.setFont(new Font("Varela Round", Font.PLAIN, 27));
    panel.add(tempLabel);

    JLabel weatherLabel = new JLabel();
    weatherLabel.setText(this.detailController.getDailyWeatherMain(data));
    weatherLabel.setBounds(5,103, 120,80);
    weatherLabel.setForeground(Color.white);
    weatherLabel.setFont(new Font("Varela Round", Font.PLAIN, 16));
    panel.add(weatherLabel);

    panel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        JSONObject obj = detailController.getData(idx);
        showDailyDetails(obj);
      }
    });

    add(panel);
  }

}
