package main.java.component;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class DetailPanel extends JPanel {

  public DetailPanel() {
    setBounds(235, 0, 789, 647);
    setBackground(new Color(0, 133, 248));
    setLayout(null);
  }

  public void updateData(JSONObject data) {
//    JLabel tempLabel = new JLabel("25°C");
//    tempLabel.setBounds(305,50, 150,70);
//    tempLabel.setForeground(Color.white);
//    tempLabel.setFont(new Font("Segoe UI", Font.PLAIN, 70));
//    add(tempLabel);

    JLabel cityLabel = new JLabel();
    cityLabel.setText(getCityName(data));
    cityLabel.setBounds(50,120, 300,40);
    cityLabel.setForeground(Color.white);
    cityLabel.setFont(new Font("Varela Round", Font.PLAIN, 30));
    add(cityLabel);

    JSONArray arr = (JSONArray) data.get("list");
    JSONObject obj = (JSONObject) arr.get(0);

    JLabel tempLabel = new JLabel();
    tempLabel.setText(getDailyTemp(obj) + "°C");
    tempLabel.setBounds(50,50, 300,80);
    tempLabel.setForeground(Color.white);
    tempLabel.setFont(new Font("Varela Round", Font.PLAIN, 60));
    add(tempLabel);

    JLabel weatherLabel = new JLabel();
    weatherLabel.setText(getDailyWeather(obj));
    weatherLabel.setBounds(50,155, 300,40);
    weatherLabel.setForeground(Color.white);
    weatherLabel.setFont(new Font("Varela Round", Font.PLAIN, 20));
    add(weatherLabel);

//    JLabel timeLabel = new JLabel("09.15 PM");
//    timeLabel.setBounds(475,97, 300,25);
//    timeLabel.setForeground(Color.white);
//    timeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
//    add(timeLabel);

    JPanel detailInfo = new JPanel();
    detailInfo.setLayout(new BoxLayout(detailInfo, BoxLayout.X_AXIS));
    detailInfo.setBounds(305, 389, 649, 163);
    detailInfo.setBackground(Color.white);
    add(detailInfo);

    repaint();
  }

  private void dailyPanel(JSONObject data, int x) {
    JPanel panel = new JPanel();
    panel.setBounds(x, 444, 120, 163);
    panel.setBackground(new Color(64, 166, 255));
  }

  private String getCityName(JSONObject data) {
    JSONObject detail = (JSONObject) data.get("city");
    return detail.get("name").toString();
  }

  private String getDailyTemp(JSONObject data) {
    JSONObject detail = (JSONObject) data.get("main");
    Double temp = ((Double) detail.get("temp")) - 273.15;
    DecimalFormat df = new DecimalFormat("#.#");
    return String.valueOf(df.format(temp));
  }

  private String getDailyWeather(JSONObject data) {
    JSONArray weather = (JSONArray) data.get("weather");
    JSONObject detail = (JSONObject) weather.get(0);
    return detail.get("description").toString();
  }

  private JSONArray getDailyList(JSONObject data) {
    JSONArray list = (JSONArray) data.get("list");
    JSONArray result = new JSONArray();

    for(Object obj : list) {
      JSONObject dailyData = new JSONObject();
      dailyData.put("temp", getDailyTemp((JSONObject) obj));
    }

    return result;
  }

}
