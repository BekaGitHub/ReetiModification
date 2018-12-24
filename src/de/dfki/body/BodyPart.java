/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import com.interactivemesh.jfx.importer.stl.StlMeshImporter;
import de.dfki.animationlogic.commonlogic.AnimationContentTest;
import de.dfki.animationlogic.commonlogic.AnimationTest;
import de.dfki.util.Constants;
import java.net.URL;
import java.util.logging.Logger;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;

/**
 * @author Beka Aptsiauri
 */
public abstract class BodyPart extends Pane {

  public static final Logger LOGGER = Logger.getLogger(BodyPart.class.getName());
  private static PhongMaterial material = null;

  public double x_Rotation = 0;
  public double y_Rotation = 0;
  public double z_Rotation = 0;

  public Color color = Color.rgb(0, 0, 0);

  public void init() {
    calculate(0);
  }

  public MeshView readStlFile(String path, int startRotationsGrad) {
    URL url = getClass().getClassLoader().getResource(path);
    StlMeshImporter stlMeshImporter = new StlMeshImporter();
    stlMeshImporter.read(url);

    TriangleMesh triangleMesh = stlMeshImporter.getImport();
    MeshView headMeshView = new MeshView(triangleMesh);

    headMeshView.setMaterial(getMaterial());

    headMeshView.setRotationAxis(Rotate.X_AXIS);
    headMeshView.setRotate(startRotationsGrad);
    return headMeshView;
  }

  MeshView readDaeFile(String path, int startRotationsGrad) {
    ColModelImporter importer = new ColModelImporter();
    URL url = getClass().getClassLoader().getResource(path);

    importer.read(url);
    return  (MeshView) importer.getImport()[0];
  }

  Group readDaeFile(String path) {
    URL url = getClass().getClassLoader().getResource(path);
    ColModelImporter importer = new ColModelImporter();
    importer.read(url);
    return (Group) importer.getImport()[0];
  }

  public synchronized void calculate(int step) {
  }

  public abstract void onAnimation(AnimationContentTest AnimationContentTest);

  protected PhongMaterial getMaterial() {
    if (material == null) {
      URL imageUrl = getClass().getClassLoader().getResource("Images/difuseMap2.png");
      Image image = new javafx.scene.image.Image(imageUrl.toExternalForm());
      material = new PhongMaterial();
      material.setDiffuseColor(color);
      material.setDiffuseMap(image);
      material.setSelfIlluminationMap(image);
    }
    return material;
  }

  void transformate(Node reetiBodyPart, double pivotX, double pivotY, double pivotZ) {
    Rotate rx = new Rotate(x_Rotation, pivotX, pivotY, pivotZ, Rotate.X_AXIS);
    Rotate ry = new Rotate(y_Rotation, pivotX, pivotY, pivotZ, Rotate.Y_AXIS);
    Rotate rz = new Rotate(z_Rotation, pivotX, pivotY, pivotZ, Rotate.Z_AXIS);

    reetiBodyPart.getTransforms().clear();
    reetiBodyPart.getTransforms().addAll(rz, ry, rx);
  }

  public static void addEffect(QuadCurve lipQadCurve) {
    lipQadCurve.setStroke(Color.BLACK);
    lipQadCurve.setStrokeWidth(1);
    lipQadCurve.setFill(Color.GRAY.brighter());
  }

  public void createLip(QuadCurve lip) {
    lip.setStartX(Constants.MOUTH_START_POINT_X);
    lip.setStartY(Constants.MOUTH_START_POINT_Y);
    lip.setControlX(Constants.MOUTH_START_POINT_X + Constants.MOUTH_LENGTH / 2);
    lip.setControlY(Constants.MOUTH_START_POINT_Y);
    lip.setEndX(Constants.MOUTH_START_POINT_X + Constants.MOUTH_LENGTH);
    lip.setEndY(Constants.MOUTH_START_POINT_Y);
    addEffect(lip);
  }
}
