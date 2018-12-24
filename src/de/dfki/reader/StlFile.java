package de.dfki.reader;

import com.interactivemesh.jfx.importer.stl.StlMeshImporter;
import de.dfki.style.Material;
import java.net.URL;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;

public class StlFile {

  public MeshView read(String path) {
    URL url = getClass().getClassLoader().getResource(path);
    StlMeshImporter stlMeshImporter = new StlMeshImporter();
    stlMeshImporter.read(url);

    TriangleMesh triangleMesh = stlMeshImporter.getImport();
    MeshView meshView = new MeshView(triangleMesh);

    meshView.setMaterial(Material.getInstance().getMaterial());

    meshView.setRotationAxis(Rotate.X_AXIS);
    return meshView;
  }
}
