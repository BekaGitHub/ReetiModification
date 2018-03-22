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
public class Head extends ReetiBodyPart {

  private Group headGroup;

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
    LOGGER.log(Level.INFO, "Head wurde erzeugt");
  }


  @Override
  public void init() {
    headGroup.setTranslateY(Constants.HEAD_Y_POSITION);
    headGroup.setTranslateZ(Constants.Z_TRANSLATION);
    super.init();
  }

  @Override
  public void calculate(int step) {
    transformate(headGroup, 0, 25, -25);
  }

  public Group getHeadGroup() {
    return headGroup;
  }

}
