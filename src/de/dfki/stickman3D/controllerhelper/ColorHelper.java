package de.dfki.stickman3D.controllerhelper;

import de.dfki.common.Gender;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import javafx.scene.input.MouseEvent;

public class ColorHelper {

  public static void headColorChanger(StickmanStageController controller) {
    if (controller.currentStickman != null) {
      controller.currentStickman.mHead.color = controller.headColorPicker.getValue();
      controller.currentStickman.mHead.update();
      controller.headOpacitySlider.setValue(1);
    }
  }

  public static void hairColorChanger(StickmanStageController controller) {
    if (controller.currentStickman != null) {
      if (controller.currentStickman.mType == Gender.TYPE.MALE) {
        controller.currentStickman.mMaleHair.color = controller.hairColorPicker.getValue();
        controller.currentStickman.mMaleHair.update();
      } else {
        controller.currentStickman.mFemaleHair.color = controller.hairColorPicker.getValue();
        controller.currentStickman.mFemaleHair.update();
      }
      controller.hairOpacitySlider.setValue(1);
    }
  }

  public static void bodyColorChanger(StickmanStageController controller) {
    if (controller.currentStickman != null) {
      controller.currentStickman.mUpperBody.color = controller.bodyColorPicker.getValue();
      controller.currentStickman.mUpperBody.update();
      //controller.bodyOpacitySlider.setValue(1);
    }
  }

  public static void limbsColorChanger(StickmanStageController controller) {
    if (controller.currentStickman != null) {
      controller.currentStickman.mNeck.color = controller.limbsColorPicker.getValue();
      controller.currentStickman.mLeftUpperArm.color = controller.limbsColorPicker.getValue();
      controller.currentStickman.mLeftForeArm.color = controller.limbsColorPicker.getValue();
      controller.currentStickman.mLeftWrist.color = controller.limbsColorPicker.getValue();
      controller.currentStickman.mLeftFinger1.color = controller.limbsColorPicker.getValue();
      controller.currentStickman.mLeftFinger2.color = controller.limbsColorPicker.getValue();
      controller.currentStickman.mLeftFinger3.color = controller.limbsColorPicker.getValue();
      controller.currentStickman.mLeftFinger4.color = controller.limbsColorPicker.getValue();
      controller.currentStickman.mLeftUpperLeg.color = controller.limbsColorPicker.getValue();
      controller.currentStickman.mLeftForeLeg.color = controller.limbsColorPicker.getValue();

      controller.currentStickman.mRightUpperArm.color = controller.limbsColorPicker.getValue();
      controller.currentStickman.mRightForeArm.color = controller.limbsColorPicker.getValue();
      controller.currentStickman.mRightWrist.color = controller.limbsColorPicker.getValue();
      controller.currentStickman.mRightFinger1.color = controller.limbsColorPicker.getValue();
      controller.currentStickman.mRightFinger2.color = controller.limbsColorPicker.getValue();
      controller.currentStickman.mRightFinger3.color = controller.limbsColorPicker.getValue();
      controller.currentStickman.mRightFinger4.color = controller.limbsColorPicker.getValue();
      controller.currentStickman.mRightUpperLeg.color = controller.limbsColorPicker.getValue();
      controller.currentStickman.mRightForeLeg.color = controller.limbsColorPicker.getValue();

      controller.currentStickman.mNeck.update();
      controller.currentStickman.mLeftUpperArm.update();
      controller.currentStickman.mLeftForeArm.update();
      controller.currentStickman.mLeftWrist.update();
      controller.currentStickman.mLeftFinger1.update();
      controller.currentStickman.mLeftFinger2.update();
      controller.currentStickman.mLeftFinger3.update();
      controller.currentStickman.mLeftFinger4.update();
      controller.currentStickman.mLeftUpperLeg.update();
      controller.currentStickman.mLeftForeLeg.update();

      controller.currentStickman.mRightUpperArm.update();
      controller.currentStickman.mRightForeArm.update();
      controller.currentStickman.mRightWrist.update();
      controller.currentStickman.mRightFinger1.update();
      controller.currentStickman.mRightFinger2.update();
      controller.currentStickman.mRightFinger3.update();
      controller.currentStickman.mRightFinger4.update();
      controller.currentStickman.mRightUpperLeg.update();
      controller.currentStickman.mRightForeLeg.update();
      controller.limbsOpacitySlider.setValue(1);
    }
  }

  public static void shoesColorChanger(StickmanStageController controller) {
    if (controller.currentStickman != null) {
      controller.currentStickman.mLeftFoot.color = controller.shoesColorPicker.getValue();
      controller.currentStickman.mRightFoot.color = controller.shoesColorPicker.getValue();
      controller.currentStickman.mLeftFoot.update();
      controller.currentStickman.mRightFoot.update();
      controller.shoesOpacitySlider.setValue(1);
    }
  }

  public static void lipsColorChanger(StickmanStageController controller) {
    if (controller.currentStickman != null) {
      controller.currentStickman.mMouth.color = controller.lipsColorPicker.getValue();
      controller.currentStickman.mMouth.update();
      controller.lipsOpacitySlider.setValue(1);
    }
  }

  public static void eyeColorChanger(StickmanStageController controller) {
    if (controller.currentStickman != null) {
      controller.currentStickman.mLeftEye.color = controller.eyeColorPicker.getValue();
      controller.currentStickman.mRightEye.color = controller.eyeColorPicker.getValue();
      controller.currentStickman.mLeftEye.update();
      controller.currentStickman.mRightEye.update();
      controller.eyeOpacitySlider.setValue(1);
    }
  }

  public static void browColorChanger(StickmanStageController controller) {
    if (controller.currentStickman != null) {
      controller.currentStickman.mLeftEyebrow.color = controller.browColorPicker.getValue();
      controller.currentStickman.mRightEyebrow.color = controller.browColorPicker.getValue();
      controller.currentStickman.mLeftEyebrow.update();
      controller.currentStickman.mRightEyebrow.update();
      controller.browOpacitySlider.setValue(1);
    }
  }

  public static void noseColorChanger(StickmanStageController controller) {
    if (controller.currentStickman != null) {
      controller.currentStickman.mNose.color = controller.noseColorPicker.getValue();
      controller.currentStickman.mNose.update();
      controller.noseOpacitySlider.setValue(1);
    }
  }

  public static void handleHeadColorButtons(StickmanStageController sSC,
      MouseEvent ev) {
    if (sSC.currentStickman != null) {
      if (ev.getSource().equals(sSC.headColorBrighter)) {
        sSC.currentStickman.mHead.color = sSC.currentStickman.mHead.color.brighter();
        sSC.currentStickman.mHead.update();
      } else if (ev.getSource().equals(sSC.headColorDarker)) {
        sSC.currentStickman.mHead.color = sSC.currentStickman.mHead.color.darker();
        sSC.currentStickman.mHead.update();
      } else if (ev.getSource().equals(sSC.headColorReset)) {
        sSC.currentStickman.mHead.color = sSC.currentStickman.mHead.mColorRecorder;
        sSC.headOpacitySlider.setValue(1);
        sSC.currentStickman.mHead.update();
      }
    }
  }

  public static void handleHairColorButtons(StickmanStageController sSC,
      MouseEvent ev) {

    if (sSC.currentStickman != null) {
      if (ev.getSource().equals(sSC.hairColorBrighter)) {
        if (sSC.currentStickman.mType == Gender.TYPE.MALE) {
          sSC.currentStickman.mMaleHair.color = sSC.currentStickman.mMaleHair.color.brighter();
          sSC.currentStickman.mMaleHair.update();
        } else {
          sSC.currentStickman.mFemaleHair.color = sSC.currentStickman.mFemaleHair.color
              .brighter();
          sSC.currentStickman.mFemaleHair.update();
        }
      } else if (ev.getSource().equals(sSC.hairColorDarker)) {
        if (sSC.currentStickman.mType == Gender.TYPE.MALE) {
          sSC.currentStickman.mMaleHair.color = sSC.currentStickman.mMaleHair.color.darker();
          sSC.currentStickman.mMaleHair.update();
        } else {
          sSC.currentStickman.mFemaleHair.color = sSC.currentStickman.mFemaleHair.color.darker();
          sSC.currentStickman.mFemaleHair.update();
        }
      } else if (ev.getSource().equals(sSC.hairColorReset)) {
        if (sSC.currentStickman.mType == Gender.TYPE.MALE) {
          sSC.currentStickman.mMaleHair.color = sSC.currentStickman.mMaleHair.mColorRecorder;
          sSC.currentStickman.mMaleHair.update();
        } else {
          sSC.currentStickman.mFemaleHair.color = sSC.currentStickman.mFemaleHair.mColorRecorder;
          sSC.currentStickman.mFemaleHair.update();
        }
        sSC.hairOpacitySlider.setValue(1);
      }
    }
  }

  public static void handleBodyColorButtons(StickmanStageController sSC,
      MouseEvent ev) {
    if (sSC.currentStickman != null) {
      if (ev.getSource().equals(sSC.bodyColorBrighter)) {
        sSC.currentStickman.mUpperBody.color = sSC.currentStickman.mUpperBody.color.brighter();
        sSC.currentStickman.mUpperBody.update();
      } else if (ev.getSource().equals(sSC.bodyColorDarker)) {
        sSC.currentStickman.mUpperBody.color = sSC.currentStickman.mUpperBody.color.darker();
        sSC.currentStickman.mUpperBody.update();
      } else if (ev.getSource().equals(sSC.bodyColorReset)) {
        sSC.currentStickman.mUpperBody.color = sSC.currentStickman.mUpperBody.mColorRecorder;
        sSC.bodyOpacitySlider.setValue(1);
        sSC.currentStickman.mUpperBody.update();
      }
    }
  }

  public static void handlelimbsColorButtons(StickmanStageController sSC,
      MouseEvent ev) {
    if (sSC.currentStickman != null) {
      if (ev.getSource().equals(sSC.limbsColorBrighter)) {
        sSC.currentStickman.mNeck.color = sSC.currentStickman.mNeck.color.brighter();
        sSC.currentStickman.mLeftUpperArm.color = sSC.currentStickman.mLeftUpperArm.color
            .brighter();
        sSC.currentStickman.mLeftForeArm.color = sSC.currentStickman.mLeftForeArm.color
            .brighter();
        sSC.currentStickman.mLeftWrist.color = sSC.currentStickman.mLeftWrist.color.brighter();
        sSC.currentStickman.mLeftFinger1.color = sSC.currentStickman.mLeftFinger1.color
            .brighter();
        sSC.currentStickman.mLeftFinger2.color = sSC.currentStickman.mLeftFinger2.color
            .brighter();
        sSC.currentStickman.mLeftFinger3.color = sSC.currentStickman.mLeftFinger3.color
            .brighter();
        sSC.currentStickman.mLeftFinger4.color = sSC.currentStickman.mLeftFinger4.color
            .brighter();
        sSC.currentStickman.mLeftUpperLeg.color = sSC.currentStickman.mLeftUpperLeg.color
            .brighter();
        sSC.currentStickman.mLeftForeLeg.color = sSC.currentStickman.mLeftForeLeg.color
            .brighter();

        sSC.currentStickman.mRightUpperArm.color = sSC.currentStickman.mRightUpperArm.color
            .brighter();
        sSC.currentStickman.mRightForeArm.color = sSC.currentStickman.mRightForeArm.color
            .brighter();
        sSC.currentStickman.mRightWrist.color = sSC.currentStickman.mRightWrist.color.brighter();
        sSC.currentStickman.mRightFinger1.color = sSC.currentStickman.mRightFinger1.color
            .brighter();
        sSC.currentStickman.mRightFinger2.color = sSC.currentStickman.mRightFinger2.color
            .brighter();
        sSC.currentStickman.mRightFinger3.color = sSC.currentStickman.mRightFinger3.color
            .brighter();
        sSC.currentStickman.mRightFinger4.color = sSC.currentStickman.mRightFinger4.color
            .brighter();
        sSC.currentStickman.mRightUpperLeg.color = sSC.currentStickman.mRightUpperLeg.color
            .brighter();
        sSC.currentStickman.mRightForeLeg.color = sSC.currentStickman.mRightForeLeg.color
            .brighter();

        sSC.currentStickman.mNeck.update();
        sSC.currentStickman.mLeftUpperArm.update();
        sSC.currentStickman.mLeftForeArm.update();
        sSC.currentStickman.mLeftWrist.update();
        sSC.currentStickman.mLeftFinger1.update();
        sSC.currentStickman.mLeftFinger2.update();
        sSC.currentStickman.mLeftFinger3.update();
        sSC.currentStickman.mLeftFinger4.update();
        sSC.currentStickman.mLeftUpperLeg.update();
        sSC.currentStickman.mLeftForeLeg.update();

        sSC.currentStickman.mRightUpperArm.update();
        sSC.currentStickman.mRightForeArm.update();
        sSC.currentStickman.mRightWrist.update();
        sSC.currentStickman.mRightFinger1.update();
        sSC.currentStickman.mRightFinger2.update();
        sSC.currentStickman.mRightFinger3.update();
        sSC.currentStickman.mRightFinger4.update();
        sSC.currentStickman.mRightUpperLeg.update();
        sSC.currentStickman.mRightForeLeg.update();
      } else if (ev.getSource().equals(sSC.limbsColorDarker)) {
        sSC.currentStickman.mNeck.color = sSC.currentStickman.mNeck.color.darker();
        sSC.currentStickman.mLeftUpperArm.color = sSC.currentStickman.mLeftUpperArm.color
            .darker();
        sSC.currentStickman.mLeftForeArm.color = sSC.currentStickman.mLeftForeArm.color.darker();
        sSC.currentStickman.mLeftWrist.color = sSC.currentStickman.mLeftWrist.color.darker();
        sSC.currentStickman.mLeftFinger1.color = sSC.currentStickman.mLeftFinger1.color.darker();
        sSC.currentStickman.mLeftFinger2.color = sSC.currentStickman.mLeftFinger2.color.darker();
        sSC.currentStickman.mLeftFinger3.color = sSC.currentStickman.mLeftFinger3.color.darker();
        sSC.currentStickman.mLeftFinger4.color = sSC.currentStickman.mLeftFinger4.color.darker();
        sSC.currentStickman.mLeftUpperLeg.color = sSC.currentStickman.mLeftUpperLeg.color
            .darker();
        sSC.currentStickman.mLeftForeLeg.color = sSC.currentStickman.mLeftForeLeg.color.darker();

        sSC.currentStickman.mRightUpperArm.color = sSC.currentStickman.mRightUpperArm.color
            .darker();
        sSC.currentStickman.mRightForeArm.color = sSC.currentStickman.mRightForeArm.color
            .darker();
        sSC.currentStickman.mRightWrist.color = sSC.currentStickman.mRightWrist.color.darker();
        sSC.currentStickman.mRightFinger1.color = sSC.currentStickman.mRightFinger1.color
            .darker();
        sSC.currentStickman.mRightFinger2.color = sSC.currentStickman.mRightFinger2.color
            .darker();
        sSC.currentStickman.mRightFinger3.color = sSC.currentStickman.mRightFinger3.color
            .darker();
        sSC.currentStickman.mRightFinger4.color = sSC.currentStickman.mRightFinger4.color
            .darker();
        sSC.currentStickman.mRightUpperLeg.color = sSC.currentStickman.mRightUpperLeg.color
            .darker();
        sSC.currentStickman.mRightForeLeg.color = sSC.currentStickman.mRightForeLeg.color
            .darker();

        sSC.currentStickman.mNeck.update();
        sSC.currentStickman.mLeftUpperArm.update();
        sSC.currentStickman.mLeftForeArm.update();
        sSC.currentStickman.mLeftWrist.update();
        sSC.currentStickman.mLeftFinger1.update();
        sSC.currentStickman.mLeftFinger2.update();
        sSC.currentStickman.mLeftFinger3.update();
        sSC.currentStickman.mLeftFinger4.update();
        sSC.currentStickman.mLeftUpperLeg.update();
        sSC.currentStickman.mLeftForeLeg.update();

        sSC.currentStickman.mRightUpperArm.update();
        sSC.currentStickman.mRightForeArm.update();
        sSC.currentStickman.mRightWrist.update();
        sSC.currentStickman.mRightFinger1.update();
        sSC.currentStickman.mRightFinger2.update();
        sSC.currentStickman.mRightFinger3.update();
        sSC.currentStickman.mRightFinger4.update();
        sSC.currentStickman.mRightUpperLeg.update();
        sSC.currentStickman.mRightForeLeg.update();
      } else if (ev.getSource().equals(sSC.limbsColorReset)) {
        sSC.currentStickman.mNeck.color = sSC.currentStickman.mNeck.mColorRecorder;
        sSC.currentStickman.mLeftUpperArm.color = sSC.currentStickman.mLeftUpperArm.mColorRecorder;
        sSC.currentStickman.mLeftForeArm.color = sSC.currentStickman.mLeftForeArm.mColorRecorder;
        sSC.currentStickman.mLeftWrist.color = sSC.currentStickman.mLeftWrist.mColorRecorder;
        sSC.currentStickman.mLeftFinger1.color = sSC.currentStickman.mLeftFinger1.mColorRecorder;
        sSC.currentStickman.mLeftFinger2.color = sSC.currentStickman.mLeftFinger2.mColorRecorder;
        sSC.currentStickman.mLeftFinger3.color = sSC.currentStickman.mLeftFinger3.mColorRecorder;
        sSC.currentStickman.mLeftFinger4.color = sSC.currentStickman.mLeftFinger4.mColorRecorder;
        sSC.currentStickman.mLeftUpperLeg.color = sSC.currentStickman.mLeftUpperLeg.mColorRecorder;
        sSC.currentStickman.mLeftForeLeg.color = sSC.currentStickman.mLeftForeLeg.mColorRecorder;

        sSC.currentStickman.mRightUpperArm.color = sSC.currentStickman.mRightUpperArm.mColorRecorder;
        sSC.currentStickman.mRightForeArm.color = sSC.currentStickman.mRightForeArm.mColorRecorder;
        sSC.currentStickman.mRightWrist.color = sSC.currentStickman.mRightWrist.mColorRecorder;
        sSC.currentStickman.mRightFinger1.color = sSC.currentStickman.mRightFinger1.mColorRecorder;
        sSC.currentStickman.mRightFinger2.color = sSC.currentStickman.mRightFinger2.mColorRecorder;
        sSC.currentStickman.mRightFinger3.color = sSC.currentStickman.mRightFinger3.mColorRecorder;
        sSC.currentStickman.mRightFinger4.color = sSC.currentStickman.mRightFinger4.mColorRecorder;
        sSC.currentStickman.mRightUpperLeg.color = sSC.currentStickman.mRightUpperLeg.mColorRecorder;
        sSC.currentStickman.mRightForeLeg.color = sSC.currentStickman.mRightForeLeg.mColorRecorder;

        sSC.limbsOpacitySlider.setValue(1);

        sSC.currentStickman.mNeck.update();
        sSC.currentStickman.mLeftUpperArm.update();
        sSC.currentStickman.mLeftForeArm.update();
        sSC.currentStickman.mLeftWrist.update();
        sSC.currentStickman.mLeftFinger1.update();
        sSC.currentStickman.mLeftFinger2.update();
        sSC.currentStickman.mLeftFinger3.update();
        sSC.currentStickman.mLeftFinger4.update();
        sSC.currentStickman.mLeftUpperLeg.update();
        sSC.currentStickman.mLeftForeLeg.update();

        sSC.currentStickman.mRightUpperArm.update();
        sSC.currentStickman.mRightForeArm.update();
        sSC.currentStickman.mRightWrist.update();
        sSC.currentStickman.mRightFinger1.update();
        sSC.currentStickman.mRightFinger2.update();
        sSC.currentStickman.mRightFinger3.update();
        sSC.currentStickman.mRightFinger4.update();
        sSC.currentStickman.mRightUpperLeg.update();
        sSC.currentStickman.mRightForeLeg.update();
      }
    }
  }

  public static void handleShoesColorButtons(StickmanStageController sSC,
      MouseEvent ev) {
    if (sSC.currentStickman != null) {
      if (ev.getSource().equals(sSC.shoesColorBrighter)) {
        sSC.currentStickman.mLeftFoot.color = sSC.currentStickman.mLeftFoot.color.brighter();
        sSC.currentStickman.mRightFoot.color = sSC.currentStickman.mRightFoot.color.brighter();
        sSC.currentStickman.mLeftFoot.update();
        sSC.currentStickman.mRightFoot.update();
      } else if (ev.getSource().equals(sSC.shoesColorDarker)) {
        sSC.currentStickman.mLeftFoot.color = sSC.currentStickman.mLeftFoot.color.darker();
        sSC.currentStickman.mRightFoot.color = sSC.currentStickman.mRightFoot.color.darker();
        sSC.currentStickman.mLeftFoot.update();
        sSC.currentStickman.mRightFoot.update();
      } else if (ev.getSource().equals(sSC.shoesColorReset)) {
        sSC.currentStickman.mLeftFoot.color = sSC.currentStickman.mLeftFoot.mColorRecorder;
        sSC.currentStickman.mRightFoot.color = sSC.currentStickman.mRightFoot.mColorRecorder;
        sSC.shoesOpacitySlider.setValue(1);
        sSC.currentStickman.mLeftFoot.update();
        sSC.currentStickman.mRightFoot.update();
      }
    }
  }

  public static void handleLipsColorButtons(StickmanStageController sSC, MouseEvent ev) {
    if (sSC.currentStickman != null) {
      if (ev.getSource().equals(sSC.lipsColorBrighter)) {
        sSC.currentStickman.mMouth.color = sSC.currentStickman.mMouth.color.brighter();
        sSC.currentStickman.mMouth.update();
      } else if (ev.getSource().equals(sSC.lipsColorDarker)) {
        sSC.currentStickman.mMouth.color = sSC.currentStickman.mMouth.color.darker();
        sSC.currentStickman.mMouth.update();
      } else if (ev.getSource().equals(sSC.lipsColorReset)) {
        sSC.currentStickman.mMouth.color = sSC.currentStickman.mMouth.mColorRecorder;
        sSC.lipsOpacitySlider.setValue(1);
        sSC.currentStickman.mMouth.update();
      }
    }
  }

  public static void handleEyeColorButtons(StickmanStageController sSC,
      MouseEvent ev) {
    if (sSC.currentStickman != null) {
      if (ev.getSource().equals(sSC.eyeColorBrighter)) {
        sSC.currentStickman.mLeftEye.color = sSC.currentStickman.mLeftEye.color.brighter();
        sSC.currentStickman.mRightEye.color = sSC.currentStickman.mRightEye.color.brighter();
        sSC.currentStickman.mLeftEye.update();
        sSC.currentStickman.mRightEye.update();
      } else if (ev.getSource().equals(sSC.eyeColorDarker)) {
        sSC.currentStickman.mLeftEye.color = sSC.currentStickman.mLeftEye.color.darker();
        sSC.currentStickman.mRightEye.color = sSC.currentStickman.mRightEye.color.darker();
        sSC.currentStickman.mLeftEye.update();
        sSC.currentStickman.mRightEye.update();
      } else if (ev.getSource().equals(sSC.eyeColorReset)) {
        sSC.currentStickman.mLeftEye.color = sSC.currentStickman.mLeftEye.mColorRecorder;
        sSC.currentStickman.mRightEye.color = sSC.currentStickman.mRightEye.mColorRecorder;
        sSC.eyeOpacitySlider.setValue(1);
        sSC.currentStickman.mLeftEye.update();
        sSC.currentStickman.mRightEye.update();
      }
    }
  }

  public static void handleBrowColorButtons(StickmanStageController sSC, MouseEvent ev) {
    if (sSC.currentStickman != null) {
      if (ev.getSource().equals(sSC.browColorBrighter)) {
        sSC.currentStickman.mLeftEyebrow.color = sSC.currentStickman.mLeftEyebrow.color
            .brighter();
        sSC.currentStickman.mRightEyebrow.color = sSC.currentStickman.mRightEyebrow.color
            .brighter();
        sSC.currentStickman.mLeftEyebrow.update();
        sSC.currentStickman.mRightEyebrow.update();
      } else if (ev.getSource().equals(sSC.browColorDarker)) {
        sSC.currentStickman.mLeftEyebrow.color = sSC.currentStickman.mLeftEyebrow.color.darker();
        sSC.currentStickman.mRightEyebrow.color = sSC.currentStickman.mRightEyebrow.color
            .darker();
        sSC.currentStickman.mLeftEyebrow.update();
        sSC.currentStickman.mRightEyebrow.update();
      } else if (ev.getSource().equals(sSC.browColorReset)) {
        sSC.currentStickman.mLeftEyebrow.color = sSC.currentStickman.mLeftEyebrow.mColorRecorder;
        sSC.currentStickman.mRightEyebrow.color = sSC.currentStickman.mRightEyebrow.mColorRecorder;
        sSC.browOpacitySlider.setValue(1);
        sSC.currentStickman.mLeftEyebrow.update();
        sSC.currentStickman.mRightEyebrow.update();
      }
    }
  }

  public static void handleNoseColorButtons(StickmanStageController sSC, MouseEvent ev) {
    if (sSC.currentStickman != null) {
      if (ev.getSource().equals(sSC.noseColorBrighter)) {
        sSC.currentStickman.mNose.color = sSC.currentStickman.mNose.color.brighter();
        sSC.currentStickman.mNose.update();
      } else if (ev.getSource().equals(sSC.noseColorDarker)) {
        sSC.currentStickman.mNose.color = sSC.currentStickman.mNose.color.darker();
        sSC.currentStickman.mNose.update();
      } else if (ev.getSource().equals(sSC.noseColorReset)) {
        sSC.currentStickman.mNose.color = sSC.currentStickman.mNose.mColorRecorder;
        sSC.noseOpacitySlider.setValue(1);
        sSC.currentStickman.mNose.update();
      }
    }
  }

  public static void resetAll(Stickman3D currentStickman) {
    currentStickman.mHead.color = currentStickman.mHead.mColorRecorder;
    currentStickman.mHead.update();

    if (currentStickman.mType == Gender.TYPE.MALE) {
      currentStickman.mMaleHair.color = currentStickman.mMaleHair.mColorRecorder;
      currentStickman.mMaleHair.update();
    } else {
      currentStickman.mFemaleHair.color = currentStickman.mFemaleHair.mColorRecorder;
      currentStickman.mFemaleHair.update();
    }
    currentStickman.mUpperBody.color = currentStickman.mUpperBody.mColorRecorder;
    currentStickman.mUpperBody.update();
    currentStickman.mNeck.color = currentStickman.mNeck.mColorRecorder;
    currentStickman.mLeftUpperArm.color = currentStickman.mLeftUpperArm.mColorRecorder;
    currentStickman.mLeftForeArm.color = currentStickman.mLeftForeArm.mColorRecorder;
    currentStickman.mLeftWrist.color = currentStickman.mLeftWrist.mColorRecorder;
    currentStickman.mLeftFinger1.color = currentStickman.mLeftFinger1.mColorRecorder;
    currentStickman.mLeftFinger2.color = currentStickman.mLeftFinger2.mColorRecorder;
    currentStickman.mLeftFinger3.color = currentStickman.mLeftFinger3.mColorRecorder;
    currentStickman.mLeftFinger4.color = currentStickman.mLeftFinger4.mColorRecorder;
    currentStickman.mLeftUpperLeg.color = currentStickman.mLeftUpperLeg.mColorRecorder;
    currentStickman.mLeftForeLeg.color = currentStickman.mLeftForeLeg.mColorRecorder;
    currentStickman.mRightUpperArm.color = currentStickman.mRightUpperArm.mColorRecorder;
    currentStickman.mRightForeArm.color = currentStickman.mRightForeArm.mColorRecorder;
    currentStickman.mRightWrist.color = currentStickman.mRightWrist.mColorRecorder;
    currentStickman.mRightFinger1.color = currentStickman.mRightFinger1.mColorRecorder;
    currentStickman.mRightFinger2.color = currentStickman.mRightFinger2.mColorRecorder;
    currentStickman.mRightFinger3.color = currentStickman.mRightFinger3.mColorRecorder;
    currentStickman.mRightFinger4.color = currentStickman.mRightFinger4.mColorRecorder;
    currentStickman.mRightUpperLeg.color = currentStickman.mRightUpperLeg.mColorRecorder;
    currentStickman.mRightForeLeg.color = currentStickman.mRightForeLeg.mColorRecorder;
    currentStickman.mNeck.update();
    currentStickman.mLeftUpperArm.update();
    currentStickman.mLeftForeArm.update();
    currentStickman.mLeftWrist.update();
    currentStickman.mLeftFinger1.update();
    currentStickman.mLeftFinger2.update();
    currentStickman.mLeftFinger3.update();
    currentStickman.mLeftFinger4.update();
    currentStickman.mLeftUpperLeg.update();
    currentStickman.mLeftForeLeg.update();
    currentStickman.mRightUpperArm.update();
    currentStickman.mRightForeArm.update();
    currentStickman.mRightWrist.update();
    currentStickman.mRightFinger1.update();
    currentStickman.mRightFinger2.update();
    currentStickman.mRightFinger3.update();
    currentStickman.mRightFinger4.update();
    currentStickman.mRightUpperLeg.update();
    currentStickman.mRightForeLeg.update();
    currentStickman.mLeftFoot.color = currentStickman.mLeftFoot.mColorRecorder;
    currentStickman.mRightFoot.color = currentStickman.mRightFoot.mColorRecorder;
    currentStickman.mLeftFoot.update();
    currentStickman.mRightFoot.update();
    currentStickman.mMouth.color = currentStickman.mMouth.mColorRecorder;
    currentStickman.mMouth.update();
    currentStickman.mLeftEye.color = currentStickman.mLeftEye.mColorRecorder;
    currentStickman.mRightEye.color = currentStickman.mRightEye.mColorRecorder;
    currentStickman.mLeftEye.update();
    currentStickman.mRightEye.update();
    currentStickman.mLeftEyebrow.color = currentStickman.mLeftEyebrow.mColorRecorder;
    currentStickman.mRightEyebrow.color = currentStickman.mRightEyebrow.mColorRecorder;
    currentStickman.mLeftEyebrow.update();
    currentStickman.mRightEyebrow.update();
    currentStickman.mNose.color = currentStickman.mNose.mColorRecorder;
    currentStickman.mNose.update();
  }
}
