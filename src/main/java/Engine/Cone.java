package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_POLYGON;

public class Cone extends Circle{
    float baseRadius;
    float height;
    int stackCount;
    int sectorCount;
    int pilihan;
    ArrayList<Integer> indices = new ArrayList<>();
    public Cone(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint,
                Float baseRadius, Float height, int sectorCount,int stackCount, int pilihan) {
        super(shaderModuleDataList, vertices, color, centerPoint);
        this.baseRadius= baseRadius;
        this.height = height;
        this.stackCount = stackCount;
        this.sectorCount = sectorCount;
        this.pilihan = pilihan;
        if (pilihan == 1){
            createCone();
        } else if (pilihan == 2){
            createConeRev();
        }
        setupVAOVBO();
    }

    public void createCone() {
        float pi = (float) Math.PI;

        float sectorStep = 2 * pi / sectorCount;
        float heightStep = height / stackCount;
        float sectorAngle, x, y, z;

        for (int i = 0; i <= stackCount; i++) {
            float currentHeight = i * heightStep;
            float radius = (height - currentHeight) / height * baseRadius;
            for (int j = 0; j <= sectorCount; j++) {
                sectorAngle = j * sectorStep;
                x = radius * (float) Math.cos(sectorAngle);
                y = radius * (float) Math.sin(sectorAngle);
                z = currentHeight;
                Vector3f temp_vector = new Vector3f();
                temp_vector.x = centerPoint.get(0) + x;
                temp_vector.y = centerPoint.get(1) + y;
                temp_vector.z = centerPoint.get(2) + z;
                vertices.add(temp_vector);
            }
        }


        int k1, k2;
        for (int i = 0; i < stackCount; i++) {
            k1 = i * (sectorCount + 1);
            k2 = k1 + sectorCount + 1;
            for (int j = 0; j < sectorCount; j++, k1++, k2++) {
                if (i != 0) {
                    indices.add(k1);
                    indices.add(k2);
                    indices.add(k1 + 1);
                }
                if (i != stackCount - 1) {
                    indices.add(k1 + 1);
                    indices.add(k2);
                    indices.add(k2 + 1);
                }
            }
        }
    }

    public void createConeRev() {
        float pi = (float) Math.PI;

        float sectorStep = 2 * pi / sectorCount;
        float heightStep = height / stackCount;
        float sectorAngle, x, y, z;

        for (int i = 0; i <= stackCount; i++) {
            float currentHeight = i * heightStep;
            float radius = (height - currentHeight) / height * baseRadius;
            for (int j = 0; j <= sectorCount; j++) {
                sectorAngle = j * sectorStep;
                x = radius * (float) Math.cos(sectorAngle);
                y = radius * (float) Math.sin(sectorAngle);
                z = -currentHeight;
                Vector3f temp_vector = new Vector3f();
                temp_vector.x = centerPoint.get(0) + x;
                temp_vector.y = centerPoint.get(1) + y;
                temp_vector.z = centerPoint.get(2) + z;
                vertices.add(temp_vector);
            }
        }


        int k1, k2;
        for (int i = 0; i < stackCount; i++) {
            k1 = i * (sectorCount + 1);
            k2 = k1 + sectorCount + 1;
            for (int j = 0; j < sectorCount; j++, k1++, k2++) {
                if (i != 0) {
                    indices.add(k1);
                    indices.add(k2);
                    indices.add(k1 + 1);
                }
                if (i != stackCount - 1) {
                    indices.add(k1 + 1);
                    indices.add(k2);
                    indices.add(k2 + 1);
                }
            }
        }
    }

}