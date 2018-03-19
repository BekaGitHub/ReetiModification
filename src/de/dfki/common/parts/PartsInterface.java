package de.dfki.common.parts;

/**
 * Created by EmpaT on 15.07.2017.
 */
public interface PartsInterface {

   default void setText(String text) {
  }

  default void set_X_Rotation(int degree) {
  }

  default void set_Y_Rotation(int degree) {
  }

  default void set_Z_Rotation(int degree) {
  }

  default void setTilt(int degree) {
  }

  default void set_X_Translation(int length) {
  }

  default void set_Y_Translation(int length) {
  }

  default void set_Z_Translation(int length) {
  }

  default void setShape(String s) {
  }

  default void setRotation(int degree) {
  }

  default void setTranslation(int length) {
  }

  default void calculate_X_Rotation(int step) {
  }

  default void calculate_Y_Rotation(int step) {
  }

  default void calculate_Z_Rotation(int step) {
  }

  default void calculate_X_Translation(int step) {
  }

  default void calculate_Y_Translation(int step) {
  }

  default void calculate_Z_Translation(int step) {
  }

  default void calculateShape(int step) {
  }

  default void reset_X_Rotation() {
  }

  default void reset_Y_Rotation() {
  }

  default void reset_Z_Rotation() {
  }

  default void resetRotation() {
  }

  default void resetTranslation() {
  }

  default void calculateRotation(int step) {
  }

  default void calculateTranslation(int step) {
  }
}
