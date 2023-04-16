package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;

public class Torus extends Circle {
    private float innerRadius;
    private int sides;
    private int rings;

    public Torus(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, float radius, float innerRadius, int sides, int rings) {
        super(shaderModuleDataList, vertices, color, centerPoint, radius, radius);
        this.innerRadius = innerRadius;
        this.sides = sides;
        this.rings = rings;
        createTorus();
        setupVAOVBO();
    }

    private void createTorus() {
        vertices.clear();

        ArrayList<Vector3f> temp = new ArrayList<>();

        for(int i = 0; i < rings; i++) {
            for(int j = 0; j < sides; j++) {
                float theta = (float) (i * 2 * Math.PI / rings);
                float phi = (float) (j * 2 * Math.PI / sides);
                float x = (radiusX + innerRadius * (float) Math.cos(theta)) * (float) Math.cos(phi);
                float y = (radiusY + innerRadius * (float) Math.cos(theta)) * (float) Math.sin(phi);
                float z = innerRadius * (float) Math.sin(theta);
                temp.add(new Vector3f(x + centerPoint.get(0), y + centerPoint.get(1), z + centerPoint.get(2)));
            }
        }

        vertices = temp;
    }
}
