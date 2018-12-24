package de.dfki.style;

import java.net.URL;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;

public class Material {

  private static Material materialInstance = null;
  private PhongMaterial material;

  private Material() {
    URL imageUrl = getClass().getClassLoader().getResource("Images/difuseMap2.png");
    Image image = new javafx.scene.image.Image(imageUrl.toExternalForm());
    material = new PhongMaterial();
    material.setDiffuseColor(Color.WHITE);
    material.setDiffuseMap(image);
    material.setSelfIlluminationMap(image);
  }

  public static Material getInstance() {
    if (materialInstance == null) {
      materialInstance = new Material();
    }
    return materialInstance;
  }

  public PhongMaterial getMaterial() {
    return material;
  }
}
