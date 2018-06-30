package main.java.component;

import component.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MainFrame extends JFrame {

  private MainPanel mainPanel;

  public MainFrame() {
    super("Weather Forecast");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    initFonts();

    this.mainPanel = new MainPanel();
    getContentPane().add(this.mainPanel);

    setSize(1024,720);
    setVisible(true);
    setLayout(null);
  }

  private void initFonts() {
    try {
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/resource/fonts/VarelaRound-Regular.ttf")));
    } catch (IOException e) {
      e.printStackTrace();
    } catch(FontFormatException e) {
      e.printStackTrace();
    }
  }
}
