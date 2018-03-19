package de.dfki.common.parts;

import java.awt.Dimension;
import java.awt.Point;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


/**
 * Created by EmpaT on 15.07.2017.
 */
public abstract class FXParts extends Pane implements PartsInterface {

  public int mShapeAnimationStep = 0;
  public int mDefaultTranslation = 0;
  public int mDefaultRotation = 0;
  public Color color = Color.rgb(0, 0, 0);
  public String mText = "";


  @Override
  public void setText(String text) {
    this.mText = text;
  }

  public enum SHAPE {
    DEFAULT
  }
}
