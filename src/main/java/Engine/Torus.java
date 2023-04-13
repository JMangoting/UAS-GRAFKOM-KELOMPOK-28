package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_POLYGON;

public class Torus extends Circle{
    float radiusX;

    float radiusY;
    int stackCount;
    int sectorCount;
    public Torus(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, int sectorCount, int stackCount){
        super(shaderModuleDataList, vertices, color, centerPoint);
        this.radiusX = radiusX;
        this.radiusY = radiusY;
        this.sectorCount = sectorCount;
        this.stackCount = stackCount;
        createTorus();
        setupVAOVBO();
    }

    public void createTorus() {
        vertices.clear();

        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double i = 0; i < 2 * Math.PI; i += 2 * Math.PI / sectorCount) {
            for (double j = 0; j < 2 * Math.PI; j += 2 * Math.PI / stackCount) {
                float x = (float) ((radiusX + radiusY * Math.cos(j)) * Math.cos(i));
                float y = (float) ((radiusX + radiusY * Math.cos(j)) * Math.sin(i));
                float z = (float) (radiusY * Math.sin(j));
                temp.add(new Vector3f(x + centerPoint.get(0), y + centerPoint.get(1), z + centerPoint.get(2)));
            }
        }
        vertices = temp;
    }
}