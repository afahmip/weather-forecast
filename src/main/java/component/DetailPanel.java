package main.java.component;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DetailPanel extends JPanel {

  private Image wallpaper;

  public DetailPanel() {
    setBounds(235, 0, 789, 720);
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
    timeLabel.setText(getDailyDayFull(obj) + ", " + getDailyMonth(obj) + " " + getDailyDate(obj) + " " + getDailyYear(obj));
    timeLabel.setBounds(50,380, 300,40);
    timeLabel.setForeground(Color.white);
    timeLabel.setFont(new Font("Varela Round", Font.PLAIN, 18));
    add(timeLabel);

    JLabel windLabel = new JLabel();
    windLabel.setText(getDailyWind(obj) + " m/s");
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
    humidLabel.setText(getDailyHumidity(obj) + "%");
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
    cloudLabel.setText(getDailyCloud(obj) + "%");
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
    pressureLabel.setText(getDailyPressure(obj) + " hPa");
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
    String tmpDate = getDateTime(tmp).split(" ")[0];
    date = getDateTime(tmp).split(" ")[0];
    createDailyPanel(tmp, 50+(index*135));
    index++;

    for(int i=1; i<list.size(); i++) {
      tmp = (JSONObject) list.get(i);
      tmpDate = getDateTime(tmp).split(" ")[0];
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
    dateLabel.setText(getDailyDaySimplified(data) + " " + getDailyDate(data));
    dateLabel.setBounds(5,-12, 120,80);
    dateLabel.setForeground(Color.white);
    dateLabel.setFont(new Font("Varela Round", Font.PLAIN, 23));
    panel.add(dateLabel);

    JLabel tempLabel = new JLabel();
    tempLabel.setText(getDailyTemp(data) + "°c");
    tempLabel.setBounds(5,75, 120,80);
    tempLabel.setForeground(Color.white);
    tempLabel.setFont(new Font("Varela Round", Font.PLAIN, 27));
    panel.add(tempLabel);

    JLabel weatherLabel = new JLabel();
    weatherLabel.setText(getDailyWeatherMain(data));
    weatherLabel.setBounds(5,103, 120,80);
    weatherLabel.setForeground(Color.white);
    weatherLabel.setFont(new Font("Varela Round", Font.PLAIN, 16));
    panel.add(weatherLabel);

    add(panel);
  }

  private String getCityName(JSONObject data) {
    JSONObject detail = (JSONObject) data.get("city");
    return detail.get("name").toString();
  }

  private String getDailyWind(JSONObject data) {
    JSONObject detail = (JSONObject) data.get("wind");
    return detail.get("speed").toString();
  }

  private String getDailyCloud(JSONObject data) {
    JSONObject detail = (JSONObject) data.get("clouds");
    return detail.get("all").toString();
  }

  private String getDailyHumidity(JSONObject data) {
    JSONObject detail = (JSONObject) data.get("main");
    return detail.get("humidity").toString();
  }

  private String getDailyPressure(JSONObject data) {
    JSONObject detail = (JSONObject) data.get("main");
    return detail.get("pressure").toString();
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

  private String getDailyDaySimplified(JSONObject data) {
    String result = "";
    String dateTime = data.get("dt_txt").toString();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try {
      Date date = format.parse(dateTime);
      SimpleDateFormat dateFormat = new SimpleDateFormat("E");
      result = dateFormat.format(date);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  private String getDailyDayFull(JSONObject data) {
    String result = "";
    String dateTime = data.get("dt_txt").toString();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try {
      Date date = format.parse(dateTime);
      SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE");
      result = dateFormat.format(date);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  private String getDailyMonth(JSONObject data) {
    String result = "";
    String dateTime = data.get("dt_txt").toString();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try {
      Date date = format.parse(dateTime);
      SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM");
      result = dateFormat.format(date);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  private String getDailyYear(JSONObject data) {
    String result = "";
    String dateTime = data.get("dt_txt").toString();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try {
      Date date = format.parse(dateTime);
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
      result = dateFormat.format(date);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  private String getDailyDate(JSONObject data) {
    String result = "";
    String dateTime = data.get("dt_txt").toString();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try {
      Date date = format.parse(dateTime);
      SimpleDateFormat dateFormat = new SimpleDateFormat("d");
      result = dateFormat.format(date);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
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
