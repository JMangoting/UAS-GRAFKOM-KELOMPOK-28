package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_POLYGON;

public class Torus extends Circle{
    float radius;

    float ringRadius;
    int circleCount;
    int ringCount;
    public Torus(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radius, Float ringRadius, int circleCount, int ringCount) {
        super(shaderModuleDataList, vertices, color, centerPoint);
        this.radius = radius;
        this.ringRadius = ringRadius;
        this.circleCount = circleCount;
        this.ringCount = ringCount;
        createTorus();
        setupVAOVBO();
    }


    public void createTorus() {
        float pi = (float)Math.PI;

        float circleStep = 2 * (float)Math.PI / circleCount;
        float ringStep = 2 * (float)Math.PI / ringCount;
        float circleAngle = 0.0f, ringAngle= 0.0f , x, y, z;

        for (int i = 0; i <= ringCount; ++i) {
            ringAngle = i * ringStep;
            x = (radius + ringRadius * (float)Math.cos(ringAngle)) * (float)Math.cos(circleAngle);
            y = (radius + ringRadius * (float)Math.cos(ringAngle)) * (float)Math.sin(circleAngle);
            z = ringRadius * (float)Math.sin(ringAngle);

            for (int j = 0; j <= circleCount; ++j) {
                circleAngle = j * circleStep;
                Vector3f temp_vector = new Vector3f();
                temp_vector.x = centerPoint.get(0) + x;
                temp_vector.y = centerPoint.get(1) + y;
                temp_vector.z = centerPoint.get(2) + z * (float)Math.cos(circleAngle);
                vertices.add(temp_vector);
            }
        }
    }

}