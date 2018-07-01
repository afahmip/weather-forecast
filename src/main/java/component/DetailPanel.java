package component;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import retriever.DetailController;
import javax.swing.*;
import java.awt.*;

public class DetailPanel extends JPanel {

  private Image wallpaper;
  private DetailController detailController;

  public DetailPanel() {
    this.detailController = new DetailController();
    setBounds(235, 0, 789, 720);
    setBackground(new Color(216, 216, 216));
    setLayout(null);
  }

  public void updateData(JSONObject data) {
    JLabel cityLabel = new JLabel();
    cityLabel.setText(this.detailController.getCityName(data));
    cityLabel.setBounds(50,120, 300,40);
    cityLabel.setForeground(Color.white);
    cityLabel.setFont(new Font("Varela Round", Font.PLAIN, 30));
    add(cityLabel);

    JSONArray list = (JSONArray) data.get("list");
    JSONObject obj = (JSONObject) list.get(0);
    showDailyDetails(obj);
    generateDailyPanels(list);

    this.wallpaper = new ImageIcon("./src/resource/images/night.jpg").getImage();

    revalidate();
    repaint();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(wallpaper, 0, 0, null);
  }

  private void showDailyDetails(JSONObject obj) {
    JLabel tempLabel = new JLabel();
    tempLabel.setText(this.detailController.getDailyTemp(obj) + "°c");
    tempLabel.setBounds(50,50, 300,80);
    tempLabel.setForeground(Color.white);
    tempLabel.setFont(new Font("Varela Round", Font.PLAIN, 60));
    add(tempLabel);

    JLabel weatherLabel = new JLabel();
    weatherLabel.setText(this.detailController.getDailyWeatherDetail(obj));
    weatherLabel.setBounds(50,155, 300,40);
    weatherLabel.setForeground(Color.white);
    weatherLabel.setFont(new Font("Varela Round", Font.PLAIN, 20));
    add(weatherLabel);

    JLabel timeLabel = new JLabel();
    String text = this.detailController.getDailyDayFull(obj) + ", " + this.detailController.getDailyMonth(obj)
            + " " + this.detailController.getDailyDate(obj) + " " + this.detailController.getDailyYear(obj);
    timeLabel.setText(text);
    timeLabel.setBounds(50,380, 300,40);
    timeLabel.setForeground(Color.white);
    timeLabel.setFont(new Font("Varela Round", Font.PLAIN, 18));
    add(timeLabel);

    JLabel windLabel = new JLabel();
    windLabel.setText(this.detailController.getDailyWind(obj) + " m/s");
    windLabel.setBounds(50,220, 300,40);
    windLabel.setForeground(Color.white);
    windLabel.setFont(new Font("Varela Round", Font.PLAIN, 22));
    add(windLabel);

    JLabel wind = new JLabel();
    wind.setText("Wind speed");
    wind.setBounds(50,245, 300,40);
    wind.setForeground(Color.white);
    wind.setFont(new Font("Varela Round", Font.PLAIN, 13));
    add(wind);

    JLabel humidLabel = new JLabel();
    humidLabel.setText(this.detailController.getDailyHumidity(obj) + "%");
    humidLabel.setBounds(230,220, 300,40);
    humidLabel.setForeground(Color.white);
    humidLabel.setFont(new Font("Varela Round", Font.PLAIN, 22));
    add(humidLabel);

    JLabel humid = new JLabel();
    humid.setText("Humidity");
    humid.setBounds(230,245, 300,40);
    humid.setForeground(Color.white);
    humid.setFont(new Font("Varela Round", Font.PLAIN, 13));
    add(humid);

    JLabel cloudLabel = new JLabel();
    cloudLabel.setText(this.detailController.getDailyCloud(obj) + "%");
    cloudLabel.setBounds(50,285, 300,40);
    cloudLabel.setForeground(Color.white);
    cloudLabel.setFont(new Font("Varela Round", Font.PLAIN, 22));
    add(cloudLabel);

    JLabel cloud = new JLabel();
    cloud.setText("Cloudiness");
    cloud.setBounds(50,310, 300,40);
    cloud.setForeground(Color.white);
    cloud.setFont(new Font("Varela Round", Font.PLAIN, 13));
    add(cloud);

    JLabel pressureLabel = new JLabel();
    pressureLabel.setText(this.detailController.getDailyPressure(obj) + " hPa");
    pressureLabel.setBounds(230,285, 300,40);
    pressureLabel.setForeground(Color.white);
    pressureLabel.setFont(new Font("Varela Round", Font.PLAIN, 22));
    add(pressureLabel);

    JLabel pressure = new JLabel();
    pressure.setText("Pressure");
    pressure.setBounds(230,310, 300,40);
    pressure.setForeground(Color.white);
    pressure.setFont(new Font("Varela Round", Font.PLAIN, 13));
    add(pressure);
  }

  private void generateDailyPanels(JSONArray list) {
    String date;
    int index = 0;
    JSONObject tmp = (JSONObject) list.get(0);
    String tmpDate = this.detailController.getDateTime(tmp).split(" ")[0];
    date = this.detailController.getDateTime(tmp).split(" ")[0];
    createDailyPanel(tmp, 50+(index*135));
    index++;

    for(int i=1; i<list.size(); i++) {
      tmp = (JSONObject) list.get(i);
      tmpDate =this.detailController. getDateTime(tmp).split(" ")[0];
      if(!tmpDate.equals(date)) {
        date = tmpDate;
        createDailyPanel(tmp, 50+(index*135));
        index++;
      }
    }
  }

  private void createDailyPanel(JSONObject data, int x) {
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
    tempLabel.setText(this.detailController.getDailyTemp(data) + "°c");
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

    add(panel);
  }

  private JSONArray getDailyList(JSONObject data) {
    JSONArray list = (JSONArray) data.get("list");
    JSONArray result = new JSONArray();

    for(Object obj : list) {
      JSONObject dailyData = new JSONObject();
      dailyData.put("temp", this.detailController.getDailyTemp((JSONObject) obj));
    }

    return result;
  }

}
