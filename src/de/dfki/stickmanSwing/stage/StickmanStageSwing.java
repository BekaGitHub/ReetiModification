package de.dfki.stickmanSwing.stage;

import de.dfki.common.AgentsOnStage;
import de.dfki.common.interfaces.AgentStage;
import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.util.StickmanStageLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import javafx.scene.layout.HBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * @author Patrick Gebhard
 */
public class StickmanStageSwing extends JFrame implements AgentStage {

  public static final float STICKMAN_SIZE_FACTOR = 0.8f;
  public static final float HEIGHT_ADJUSTMENT = 2 / 3.0f;
  public static final float STICKMAN_IN_BETWEEN_DISTANCE_FACTOR = 0.9f;
  // logging
  public static final Logger mLogger = Logger.getAnonymousLogger();
  static float sScale = 1.0f;
  private final HashMap<String, StickmanSwing> sStickmansOnStage = new HashMap<>();
  protected boolean sFullScreen = false;
  private JPanel sStickmanPanel;

  public StickmanStageSwing() {
    super("StickmanSwing Stage");
    sStickmanPanel = new JPanel();
    sStickmanPanel.setLayout(new StickmanStageLayout());
    sStickmanPanel.setOpaque(false);
    add(sStickmanPanel);
    setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE); // This one is needed by SceneMaker
    ConsoleHandler ch = new ConsoleHandler();
    ch.setFormatter(new StickmanStageLogFormatter());
  }

  public static void sendTimeMarkInformation(String timemark) {
  }

  public static void sendAnimationUpdate(String state, String id) {
  }

  public void setFullScreenSize() {
    Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    ;
    /*        setUndecorated(true);*/

    setBackground(new Color(128, 0, 5, 255));
    setMinimumSize(size);
    setPreferredSize(size);
    sStickmanPanel.revalidate();
    sStickmanPanel.repaint();
  }

  public void addStickmanToPanel(StickmanSwing s) {
    sStickmanPanel.add(s);
    sStickmanPanel.revalidate();
  }

  public StickmanSwing getStickman(String name) {
    if (sStickmansOnStage.containsKey(name.toLowerCase())) {
      return sStickmansOnStage.get(name.toLowerCase());
    } else {
      return null;
    }
  }

  public void showStickmanName(boolean show) {
    for (StickmanSwing s : sStickmansOnStage.values()) {
      s.mShowName = show;
    }
  }

  @Override
  public float getFullScreenScale() {
    Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    float mHeight = (float) size.getHeight();
    return mHeight / (float) StickmanSwing.mDefaultSize.height * sScale * STICKMAN_SIZE_FACTOR;
  }

  @Override
  public Dimension getFullScreenDimension() {
    Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    float mHeight = (float) size.getHeight();
    return new Dimension(new Float(mHeight * HEIGHT_ADJUSTMENT * sScale).intValue(),
        new Float(mHeight * sScale * STICKMAN_IN_BETWEEN_DISTANCE_FACTOR).intValue());
  }

  @Override
  public void addAgentToStage(String stageIdentifier) {

  }

  @Override
  public void setStageFullScreen(String stageIdentifier) {
    sFullScreen = true;
  }

  @Override
  public void setAgentsOnStage(AgentsOnStage stickamnsOnStage, String identifier) {
    AgentsOnStage stickamnsOnStage1 = stickamnsOnStage;
  }

  @Override
  public HBox getAgentBox(String stageIdentifier) throws Exception {
    return null;
  }

  public void clearStage() {
    dispose();
  }

  @Override
  public BufferedImage getStageAsImage(String stageIdentifier) {
    BufferedImage image = new BufferedImage(sStickmanPanel.getWidth(), sStickmanPanel.getHeight(),
        BufferedImage.TYPE_INT_RGB);
    Graphics g = image.createGraphics();
    sStickmanPanel.paint(g);
    g.dispose();
    return image;
  }

  @Override
  public void addAgentToStage(String mStageIdentifier, StickmanFX mStickmanFX) throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public void launcher() {

  }

  @Override
  public void clearStage(String stageIdentifier) {

  }

  @Override
  public void showStage(String configStage) {

  }

  @Override
  public String createNewStage(int x, int y, boolean decoration) throws IOException {
    return null;
  }

  private static class StickmanStageLogFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
      return ((new StringBuffer()).append(record.getLevel()).append(": ")
          .append(record.getMessage()).append("\n")).toString();
    }
  }
}
