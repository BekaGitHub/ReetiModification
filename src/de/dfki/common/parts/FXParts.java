package de.dfki.common.parts;

import java.awt.Dimension;
import java.awt.Point;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


/**
 * Created by EmpaT on 15.07.2017.
 */
public abstract class FXParts extends Pane implements PartsInterface {

  public Dimension mSize = new Dimension(10, 10);
  public Point mStart = new Point(0, 0), mEnd = new Point(0, 0);
  public int mLength = 0;
  public int mShapeAnimationStep = 0;
  public int mDefaultTranslation = 0;
  public int mDefaultRotation = 0;
  public Point mDefaultRotationPoint = new Point(0, 0);
  public Color color = Color.rgb(0, 0, 0);
  public String mText = "";

  public void init() {
//    this.setPrefHeight(mSize.height);
//    this.setPrefWidth(mSize.width);
  }

  @Override
  public String getText() {
    return this.mText;
  }

  @Override
  public void setText(String text) {
    this.mText = text;
  }

  public enum SHAPE {
    DEFAULT
  }
}
