package component;

import main.java.component.SearchPanel;
import main.java.component.DetailPanel;
import org.json.simple.JSONObject;
import retriever.MainController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {

  private SearchPanel searchPanel;
  private DetailPanel detailPanel;
  private JButton searchButton;
  private MainController mainController;

  public MainPanel() {
    setBounds(0, 0, 1024, 647);
    setLayout(null);

    this.searchPanel = new SearchPanel();
    add(this.searchPanel);
    this.detailPanel = new DetailPanel();
    add(this.detailPanel);
    initSearchButton();
    this.mainController = new MainController();
  }

  private void initSearchButton() {
    this.searchButton = new JButton("Find City");
    this.searchButton.setBounds(29,100,175,33);
    this.searchButton.setBackground(new Color(209, 209, 209));
    this.searchButton.setForeground(new Color(51, 51, 51));
    add(this.searchButton);

    this.searchButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        searchPanel.findCity();
        String foundId = searchPanel.getFoundId();
        mainController.getWeatherData(foundId);
        updateWeatherData(mainController.parseWeatherData());
      }
    });
  }

  private void updateWeatherData(JSONObject data) {
    this.detailPanel.updateData(data);
  }

}
