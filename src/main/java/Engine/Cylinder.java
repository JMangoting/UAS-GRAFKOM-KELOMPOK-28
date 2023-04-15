package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_POLYGON;

public class Cylinder extends Circle {
    int stackCount;
    int sectorCount;

    float radius;

    float height;

    public Cylinder(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radius, Float height,
                    int sectorCount, int stackCount) {
        super(shaderModuleDataList, vertices, color, centerPoint);
        this.radius = radius;
        this.height = height;
        this.sectorCount = sectorCount;
        this.stackCount = stackCount;
        createCylinder();
        setupVAOVBO();
    }


    public void createCylinder() {
        float pi = (float) Math.PI;
        float sectorStep = 2 * pi / sectorCount;
        float stackStep = height / stackCount;
        float sectorAngle, x, y, z;

        for (int i = 0; i <= stackCount; ++i) {
            z = i * stackStep - height / 2;

            for (int j = 0; j <= sectorCount; ++j) {
                sectorAngle = j * sectorStep;
                x = radius * (float) Math.cos(sectorAngle);
                y = radius * (float) Math.sin(sectorAngle);
                Vector3f temp_vector = new Vector3f();
                temp_vector.x = centerPoint.get(0) + x;
                temp_vector.y = centerPoint.get(1) + y;
                temp_vector.z = centerPoint.get(2) + z;
                vertices.add(temp_vector);
            }
        }

        // add top face vertices
        Vector3f topCenter = new Vector3f(centerPoint.get(0), centerPoint.get(1), centerPoint.get(2) + height / 2);
        for (int j = 0; j <= sectorCount; ++j) {
            sectorAngle = j * sectorStep;
            x = radius * (float) Math.cos(sectorAngle);
            y = radius * (float) Math.sin(sectorAngle);
            Vector3f temp_vector = new Vector3f();
            temp_vector.x = topCenter.get(0) + x;
            temp_vector.y = topCenter.get(1) + y;
            temp_vector.z = topCenter.get(2);
            vertices.add(temp_vector);
        }

        // add bottom face vertices
        Vector3f bottomCenter = new Vector3f(centerPoint.get(0), centerPoint.get(1), centerPoint.get(2) - height / 2);
        for (int j = 0; j <= sectorCount; ++j) {
            sectorAngle = j * sectorStep;
            x = radius * (float) Math.cos(sectorAngle);
            y = radius * (float) Math.sin(sectorAngle);
            Vector3f temp_vector = new Vector3f();
            temp_vector.x = bottomCenter.get(0) + x;
            temp_vector.y = bottomCenter.get(1) + y;
            temp_vector.z = bottomCenter.get(2);
            vertices.add(temp_vector);
        }
    }
}