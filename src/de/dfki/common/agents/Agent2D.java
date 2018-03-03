package de.dfki.common.agents;

import java.awt.Dimension;
import javafx.scene.paint.Color;

/**
 * Created by EmpaT on 14.07.2017.
 */
public abstract class Agent2D extends AgentFX {

  public final static Color sFOREGROUND = Color.rgb(188, 188, 188, (128 * 100 / 255) / 100f);
  public static Dimension mDefaultSize = new Dimension(300, 550);
  public Dimension mSize = new Dimension(mDefaultSize);
  public String backgroundRecord = null;
  public boolean fadeControler = false;
}
