package de.dfki.stickmanFX.utils;

import de.dfki.common.AgentsOnStage;
import de.dfki.common.Gender;
import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.stage.StickmanStageFX;
import de.dfki.stickmanFX.stage.StickmansOnStageFX;
import de.dfki.stickmanFX.xmlsettings.StickmanDataFX;
import java.io.File;
import java.util.List;
import javafx.scene.paint.Color;

/**
 * Created by alvaro on 10/9/16.
 */
public class XmlStickmanLoader {

  private String mFilePath;
  private AgentsOnStage sStickmansOnStage;

  public XmlStickmanLoader(AgentsOnStage stickmansOnStage) {
    this.sStickmansOnStage = stickmansOnStage;
    mFilePath = stickmansOnStage.getmFilePath();
  }

  private void readXML() {
    File file = null;
    if (mFilePath != null) {
      file = new File(
          mFilePath + File.separator + "stickmanfx" + File.separator + "stickmanfx.xml");
    }

    if (file != null) {
      sStickmansOnStage.getmXmlTransform().loadStickmanDataFromFile(file);
    }
  }

  public void initialStickmanWithXml() {
    readXML();
    List<StickmanDataFX> mStickmanDataFX = ((StickmansOnStageFX) sStickmansOnStage)
        .getmXmlTransform()
        .getStickmanDataFXList();
    if (!(mStickmanDataFX.isEmpty())) {
      for (StickmanDataFX mStick : mStickmanDataFX) {
        String name = mStick.getName();
        if (sStickmansOnStage.getStickmanNames().contains(name.toLowerCase())) {
          String bodycolor = mStick.getbodyColor();
          float bodyColorOpacity = mStick.getbodyColorOpacity();
          if (bodycolor != null) {
            Runnable bodyRunnable = () ->
            {
              if (((StickmanFX) sStickmansOnStage.getAgent(name)).mType == Gender.TYPE.MALE) {
                ((StickmanFX) sStickmansOnStage.getAgent(name)).mBodyFX.mMaleColor = Color
                    .web(bodycolor, bodyColorOpacity);
                ((StickmanFX) sStickmansOnStage
                    .getAgent(name)).mBodyFX.mColoropacity = bodyColorOpacity;
                ((StickmanFX) sStickmansOnStage.getAgent(name)).update();

                ((StickmanFX) sStickmansOnStage.getAgent(name)).mBodyFX.mMaleColorRest = Color
                    .web(bodycolor, bodyColorOpacity);
                ((StickmanFX) sStickmansOnStage
                    .getAgent(name)).mBodyFX.mColoropacityRest = bodyColorOpacity;
              } else {
                ((StickmanFX) sStickmansOnStage.getAgent(name)).mBodyFX.mFemaleColor = Color
                    .web(bodycolor, bodyColorOpacity);
                ((StickmanFX) sStickmansOnStage
                    .getAgent(name)).mBodyFX.mColoropacity = bodyColorOpacity;
                ((StickmanFX) sStickmansOnStage.getAgent(name)).update();

                ((StickmanFX) sStickmansOnStage.getAgent(name)).mBodyFX.mFemaleColorRest = Color
                    .web(bodycolor, bodyColorOpacity);
                ((StickmanFX) sStickmansOnStage
                    .getAgent(name)).mBodyFX.mColoropacityRest = bodyColorOpacity;
              }
            };
            StickmanStageFX.getInstance().runLater(bodyRunnable);
          }

          String haircolor = mStick.gethairColor();
          float hairColorOpacity = mStick.gethairColorOpacity();
          if ((haircolor != null)) {
            Runnable hairColor = () ->
            {
              if (((StickmanFX) sStickmansOnStage.getAgent(name)).mType == Gender.TYPE.MALE) {
                ((StickmanFX) sStickmansOnStage.getAgent(name)).mMaleHairFX.color = Color
                    .web(haircolor, hairColorOpacity);
                ((StickmanFX) sStickmansOnStage
                    .getAgent(name)).mMaleHairFX.mColoropacity = hairColorOpacity;
                ((StickmanFX) sStickmansOnStage.getAgent(name)).update();

                ((StickmanFX) sStickmansOnStage.getAgent(name)).mMaleHairFX.mColorRest = Color
                    .web(haircolor, hairColorOpacity);
                ((StickmanFX) sStickmansOnStage
                    .getAgent(name)).mMaleHairFX.mColoropacityRest = hairColorOpacity;
              } else {
                ((StickmanFX) sStickmansOnStage.getAgent(name)).mFemaleHairFX.color = Color
                    .web(haircolor, hairColorOpacity);
                ((StickmanFX) sStickmansOnStage
                    .getAgent(name)).mFemaleHairFX.mColoropacity = hairColorOpacity;
                ((StickmanFX) sStickmansOnStage.getAgent(name)).update();

                ((StickmanFX) sStickmansOnStage.getAgent(name)).mFemaleHairFX.mColorRest = Color
                    .web(haircolor, hairColorOpacity);
                ((StickmanFX) sStickmansOnStage
                    .getAgent(name)).mFemaleHairFX.mColoropacityRest = hairColorOpacity;
              }
            };
            StickmanStageFX.getInstance().runLater(hairColor);
          }

          String headcolor = mStick.getheadColor();
          float headColorOpacity = mStick.getheadColorOpacity();
          if (headcolor != null) {
            Runnable headColor = () ->
            {
              ((StickmanFX) sStickmansOnStage.getAgent(name)).mHeadFX.color = Color.web(headcolor,
                  headColorOpacity);
              ((StickmanFX) sStickmansOnStage
                  .getAgent(name)).mHeadFX.mColoropacity = headColorOpacity;
              if (((StickmanFX) sStickmansOnStage.getAgent(name)).mHeadFX.color != null) {
                ((StickmanFX) sStickmansOnStage.getAgent(name)).update();
              }
              ((StickmanFX) sStickmansOnStage.getAgent(name)).mHeadFX.mColorRest = Color
                  .web(headcolor,
                      headColorOpacity);
              ((StickmanFX) sStickmansOnStage
                  .getAgent(name)).mHeadFX.mColoropacityRest = headColorOpacity;
            };
            StickmanStageFX.getInstance().runLater(headColor);
          }

          String limbscolor = mStick.getlimbsColor();
          float limbsColorOpacity = mStick.getlimbsColorOpacity();
          if (limbscolor != null) {
            Runnable limbsColor = () ->
            {
              ((StickmanFX) sStickmansOnStage.getAgent(name)).mLeftUpperLegFX.color = Color
                  .web(limbscolor, limbsColorOpacity);
              ((StickmanFX) sStickmansOnStage.getAgent(name)).mLeftForeLegFX.color = Color
                  .web(limbscolor, limbsColorOpacity);
              ((StickmanFX) sStickmansOnStage.getAgent(name)).mLeftFootFX.color = Color
                  .web(limbscolor, limbsColorOpacity);
              ((StickmanFX) sStickmansOnStage.getAgent(name)).mRightUpperLegFX.color = Color
                  .web(limbscolor, limbsColorOpacity);
              ((StickmanFX) sStickmansOnStage.getAgent(name)).mRightForeLegFX.color = Color
                  .web(limbscolor, limbsColorOpacity);
              ((StickmanFX) sStickmansOnStage.getAgent(name)).mRightFootFX.color = Color
                  .web(limbscolor, limbsColorOpacity);
              ((StickmanFX) sStickmansOnStage.getAgent(name)).mLeftHandFX.color = Color
                  .web(limbscolor, limbsColorOpacity);
              ((StickmanFX) sStickmansOnStage.getAgent(name)).mRightHandFX.color = Color
                  .web(limbscolor, limbsColorOpacity);
              ((StickmanFX) sStickmansOnStage.getAgent(name)).mLeftShoulderFX.color = Color
                  .web(limbscolor, limbsColorOpacity);
              ((StickmanFX) sStickmansOnStage.getAgent(name)).mRightShoulderFX.color = Color
                  .web(limbscolor, limbsColorOpacity);
              ((StickmanFX) sStickmansOnStage.getAgent(name)).mLeftUpperArmFX.color = Color
                  .web(limbscolor, limbsColorOpacity);
              ((StickmanFX) sStickmansOnStage.getAgent(name)).mLeftForeArmFX.color = Color
                  .web(limbscolor, limbsColorOpacity);
              ((StickmanFX) sStickmansOnStage.getAgent(name)).mRightUpperArmFX.color = Color
                  .web(limbscolor, limbsColorOpacity);
              ((StickmanFX) sStickmansOnStage.getAgent(name)).mRightForeArmFX.color = Color
                  .web(limbscolor, limbsColorOpacity);
              ((StickmanFX) sStickmansOnStage.getAgent(name)).mNeckFX.color = Color.web(limbscolor,
                  limbsColorOpacity);
              ((StickmanFX) sStickmansOnStage
                  .getAgent(name)).mLeftUpperLegFX.mColoropacity = limbsColorOpacity;
              ((StickmanFX) sStickmansOnStage.getAgent(name)).update();

              ((StickmanFX) sStickmansOnStage.getAgent(name)).mLeftUpperLegFX.mColorRest = Color
                  .web(limbscolor, limbsColorOpacity);
              ((StickmanFX) sStickmansOnStage
                  .getAgent(name)).mLeftUpperLegFX.mColoropacityRest = limbsColorOpacity;
            };
            StickmanStageFX.getInstance().runLater(limbsColor);
          }
        }
      }
    }
  }
}
