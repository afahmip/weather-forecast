package main.java.component;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class DetailPanel extends JPanel {

  public DetailPanel() {
    setBounds(235, 0, 789, 768);
    setBackground(new Color(0, 133, 248));
    setLayout(null);
  }

  public void updateData(JSONObject data) {
    JLabel cityLabel = new JLabel();
    cityLabel.setText(getCityName(data));
    cityLabel.setBounds(50,120, 300,40);
    cityLabel.setForeground(Color.white);
    cityLabel.setFont(new Font("Varela Round", Font.PLAIN, 30));
    add(cityLabel);

    JLabel daily = new JLabel();
    daily.setText("Daily");
    daily.setBounds(50,380, 300,30);
    daily.setForeground(Color.white);
    daily.setFont(new Font("Varela Round", Font.PLAIN, 25));
    add(daily);

    JSONArray list = (JSONArray) data.get("list");
    JSONObject obj = (JSONObject) list.get(0);
    showDailyDetails(obj);
    generateDailyPanels(list);

//    JPanel detailInfo = new JPanel();
//    detailInfo.setLayout(new BoxLayout(detailInfo, BoxLayout.X_AXIS));
//    detailInfo.setBounds(50, 389, 649, 163);
//    detailInfo.setBackground(Color.white);
//    add(detailInfo);

    revalidate();
    repaint();
  }

  private void showDailyDetails(JSONObject obj) {
    JLabel tempLabel = new JLabel();
    tempLabel.setText(getDailyTemp(obj) + "°c");
    tempLabel.setBounds(50,50, 300,80);
    tempLabel.setForeground(Color.white);
    tempLabel.setFont(new Font("Varela Round", Font.PLAIN, 60));
    add(tempLabel);

    JLabel weatherLabel = new JLabel();
    weatherLabel.setText(getDailyWeatherDetail(obj));
    weatherLabel.setBounds(50,155, 300,40);
    weatherLabel.setForeground(Color.white);
    weatherLabel.setFont(new Font("Varela Round", Font.PLAIN, 20));
    add(weatherLabel);

    JLabel timeLabel = new JLabel();
    timeLabel.setText(getDateTime(obj));
    timeLabel.setBounds(50,200, 300,40);
    timeLabel.setForeground(Color.white);
    timeLabel.setFont(new Font("Varela Round", Font.PLAIN, 20));
    add(timeLabel);
  }

  private void generateDailyPanels(JSONArray list) {
    String date;
    int index = 0;
    for(int i=0; i<list.size(); i++) {
      JSONObject obj = (JSONObject) list.get(i);
      date = getDateTime(obj).split(" ")[0];

      if(i+1 < list.size()) {
        JSONObject tmp = (JSONObject) list.get(i+1);
        String tmpDate = getDateTime(tmp).split(" ")[0];
        if(!tmpDate.equals(date)) {
          createDailyPanel(obj, 50+(index*135));
          index++;
        }
      }
    }
  }

  private void createDailyPanel(JSONObject data, int x) {
    JPanel panel = new JPanel();
    panel.setBounds(x, 430, 120, 163);
    panel.setBackground(new Color(255, 255, 255, 80));
    panel.setLayout(null);

    JLabel tempLabel = new JLabel();
    tempLabel.setText(getDailyTemp(data) + "°c");
    tempLabel.setBounds(5,75, 300,80);
    tempLabel.setForeground(Color.white);
    tempLabel.setFont(new Font("Varela Round", Font.PLAIN, 27));
    panel.add(tempLabel);

    JLabel weatherLabel = new JLabel();
    weatherLabel.setText(getDailyWeatherMain(data));
    weatherLabel.setBounds(5,103, 300,80);
    weatherLabel.setForeground(Color.white);
    weatherLabel.setFont(new Font("Varela Round", Font.PLAIN, 16));
    panel.add(weatherLabel);

    add(panel);
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

  private String getDailyWeatherMain(JSONObject data) {
    JSONArray weather = (JSONArray) data.get("weather");
    JSONObject detail = (JSONObject) weather.get(0);
    return detail.get("main").toString();
  }

  private String getDailyWeatherDetail(JSONObject data) {
    JSONArray weather = (JSONArray) data.get("weather");
    JSONObject detail = (JSONObject) weather.get(0);
    String input = detail.get("description").toString();
    String output = input.substring(0, 1).toUpperCase() + input.substring(1);
    return output;
  }

  private String getDateTime(JSONObject data) {
    return data.get("dt_txt").toString();
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
