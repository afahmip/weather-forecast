package component;

import org.json.simple.JSONObject;
import retriever.MainController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MainPanel extends JPanel {

  private SearchPanel searchPanel;
  private DetailPanel detailPanel;
  private JButton searchButton;
  private MainController mainController;

  public MainPanel() {
    setBounds(0, 0, 1024, 720);
    setLayout(null);

    this.detailPanel = new DetailPanel();
    add(this.detailPanel);
    this.searchPanel = new SearchPanel();
    add(this.searchPanel);
    initSearchButton();
    this.mainController = new MainController();
  }

  private void initSearchButton() {
    this.searchButton = new JButton("Find City");
    this.searchButton.setBounds(29,100,175,33);
    this.searchButton.setBackground(new Color(209, 209, 209));
    this.searchButton.setForeground(new Color(51, 51, 51));
    this.searchButton.setFont(new Font("Varela Round", Font.PLAIN, 15));
    this.searchPanel.add(this.searchButton);

    this.searchButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        searchPanel.findCity();
        String foundId = searchPanel.getFoundId();
        if(foundId.equals("MANY")) {
          showResultPanels(searchPanel.getCityResult());
        } else if(foundId.length() > 0) {
          mainController.getWeatherData(foundId);
          updateWeatherData(mainController.parseWeatherData());
        } else if(foundId.equals("")) {
          detailPanel.showWelcomePanel();
        }
      }
    });
  }

  private void showResultPanels(ArrayList<JSONObject> list) {
    JPanel searchResultPanel = new JPanel();
    searchResultPanel.setBounds(10, 165, 215, list.size()*100);
    searchResultPanel.setBackground(new Color(255, 255, 255, 0));
    searchResultPanel.setLayout(null);

    for(int i=0; i<list.size(); i++) {
      JPanel panel = createResultPanel(list.get(i), i*78);
      searchResultPanel.add(panel);
    }

    JScrollPane scrollResultPanel = new JScrollPane(searchResultPanel);
    scrollResultPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    scrollResultPanel.setBounds(10, 165, 215, 450);
    this.searchPanel.setScrollResultPanel(scrollResultPanel);
    revalidate();
    repaint();
  }

  private JPanel createResultPanel(JSONObject data, int y) {
    String resultId = data.get("id").toString();
    JPanel panel = new JPanel();
    panel.setBounds(0, y, 235, 70);
    panel.setBackground(new Color(255, 255, 255));
    panel.setLayout(null);

    JLabel name = new JLabel(data.get("name").toString());
    name.setBounds(8,8, 150,30);
    name.setFont(new Font("Varela Round", Font.PLAIN, 18));
    panel.add(name);

    JSONObject coord = (JSONObject) data.get("coord");
    String lat = coord.get("lat").toString();
    String lon = coord.get("lon").toString();
    String country = data.get("country").toString();
    String label = country + " [" + lon + ", " + lat + "]";

    JLabel detailLabel = new JLabel(label);
    detailLabel.setBounds(8,33, 220,30);
    detailLabel.setFont(new Font("Varela Round", Font.PLAIN, 13));
    panel.add(detailLabel);

    panel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        searchPanel.setFoundId(resultId);
        mainController.getWeatherData(resultId);
        updateWeatherData(mainController.parseWeatherData());
      }
    });

    return panel;
  }

  private void updateWeatherData(JSONObject data) {
    remove(this.detailPanel);
    this.detailPanel = new DetailPanel();
    add(this.detailPanel);
    this.detailPanel.updateData(data);
  }

}
