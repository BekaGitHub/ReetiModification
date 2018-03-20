package de.dfki.body;

import com.interactivemesh.jfx.importer.stl.StlMeshImporter;
import de.dfki.agent.Reeti;
import de.dfki.util.Constants;
import java.awt.Point;
import java.net.URL;
import java.util.logging.Level;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;

/**
 * @author Beka Aptsiauri
 */
public class Head extends ReetiParts {

  private static final int EARWITDH = 10;
  private Group headGroup;
  private int mHalfHeight;
  private int mHalfWidth;

  public Head(Reeti reeti) {
    color = Color.WHITE;

    URL url = getClass().getClassLoader().getResource("BodyParts/Reeti/v1.stl");
    StlMeshImporter im = new StlMeshImporter();
    im.read(url);

    headGroup = new Group();
    TriangleMesh triangleMesh = im.getImport();
    MeshView headMeshView = new MeshView(triangleMesh);

    headMeshView.setMaterial(getMaterial());

    headMeshView.setRotationAxis(Rotate.X_AXIS);
    headMeshView.setRotate(-92);

    headGroup.getChildren().add(headMeshView);

    init();
    getChildren().add(headGroup);
    LOGGER.log(Level.INFO,"Head wurde erzeugt");
  }


  @Override
  public void init() {
    headGroup.setTranslateY(Constants.HEAD_Y_POSITION);
    headGroup.setTranslateZ(Constants.Z_TRANSLATION);
    super.init();
  }

  public Point getLeftEyebrowPostion() {
    return new Point(mHalfWidth - 60, mHalfHeight - 152);
  }

  public Point getRightEyebrowPostion() {
    return new Point(mHalfWidth - 60, mHalfHeight - 105);
  }

  public Point getMouthPostion() {
    return new Point(mHalfWidth - 60, mHalfHeight - 110);
  }

  @Override
  public void calculate(int step) {

    Rotate rx = new Rotate(xRotation, 0, 25, -25, Rotate.X_AXIS);
    Rotate ry = new Rotate(y_Rotation, 0, 25, -25, Rotate.Y_AXIS);
    Rotate rz = new Rotate(z_Rotation, 0, 25, -25, Rotate.Z_AXIS);

    headGroup.getTransforms().clear();
    headGroup.getTransforms().addAll(rz, ry, rx);
  }

  public Group getHeadGroup() {
    return headGroup;
  }

}
