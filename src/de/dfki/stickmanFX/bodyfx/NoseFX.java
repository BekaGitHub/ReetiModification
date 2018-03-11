/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.bodyfx;

import java.awt.Dimension;
import java.awt.Point;
import javafx.scene.paint.Color;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;

/**
 * @author Beka Aptsiauri
 */
public class NoseFX extends StickmanFXParts {

  public NoseFX.SHAPE mShape = NoseFX.SHAPE.DEFAULT;

  ;
  HeadFX mHeadFX;
  Path mPath;
  public NoseFX(HeadFX head) {
    mHeadFX = head;
    mLength = 16;
    mSize = new Dimension(mLength, mLength);
    mDefaultRotationPoint = mHeadFX.mDefaultRotationPoint;
    color = Color.rgb(0, 0, 0, (64 * 100 / 255) / 100f);
    mPath = new Path();
    this.getChildren().add(mPath);
    init();
  }

  @Override
  public void setShape(String s) {
    SHAPE shape = NoseFX.SHAPE.valueOf(s);
    mShape = (shape != null) ? shape : NoseFX.SHAPE.DEFAULT;
  }

  @Override
  public void resetShape() {
    mShape = NoseFX.SHAPE.DEFAULT;
  }

  @Override
  public void createShape() {
    mStart = mHeadFX.getNosePostion();
    mEnd = new Point(mStart.x, mStart.y + mLength);

    double movement;

    clearDrawObjects();
    clearChildren(this);

    mPath = new Path();

    switch (mShape) {
      case DEFAULT:
//            	if (head.mStickmanSwing.setCharacterInvisible == false)
//            		mColorRecorder = color;
        if (mHeadFX.mStickmanFX.setCharacterInvisible == true) {
          if (mHeadFX.mStickmanFX.fadeControler == true) //Added by Robbie
          {
            int fadeFactor = (int) (mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep * 3.2);
            if (fadeFactor <= 6) {
              fadeFactor = 0;
            }
            color = Color.rgb(0, 0, 0, (fadeFactor * 100 / 255) / 100f);
          } else {
            int fadeFactor = (int) ((20 - mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep) * 3.2);

            if (fadeFactor >= 54) {
              color = mColorRecorder;
            } else {
              color = Color.rgb(0, 0, 0, (fadeFactor * 100 / 255) / 100f);
            }
          }
        }

        mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
        mPath.getElements()
            .add(new QuadCurveTo((mStart.x - 10), mStart.y + 20, mEnd.x + 3, mEnd.y));
        break;
    }
    this.getChildren().add(mPath);
    addToDrawObjects(mPath);
    this.update();
  }

  protected void recordColor() {
    if (mHeadFX.mStickmanFX.setCharacterInvisible == false) {
      mColorRecorder = color;
    }
  }

  public static enum SHAPE {
    DEFAULT, ANGRY, ANGRYEND, DISGUSTED, DISGUSTEDEND, SURPRISED, SURPRISEDEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND
  }
}
