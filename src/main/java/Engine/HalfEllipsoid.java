package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_POLYGON;

public class HalfEllipsoid extends Circle{
    float radiusZ;
    int stackCount;
    int sectorCount;
    public HalfEllipsoid(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float radiusZ,
                  int sectorCount,int stackCount) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        this.radiusZ = radiusZ;
        this.stackCount = stackCount;
        this.sectorCount = sectorCount;
        createHalfEllipsoid();
        setupVAOVBO();
    }

    public void createHalfEllipsoid(){
        float pi = (float)Math.PI;

        float sectorStep = 2 * (float)Math.PI / sectorCount;
        float stackStep = (float)Math.PI / (stackCount/2); //mengubah jumlah stack menjadi setengah dari jumlah aslinya
        float sectorAngle, StackAngle, x, y, z;

        for (int i = 0; i <= stackCount/2; ++i) //mengubah jumlah stack menjadi setengah dari jumlah aslinya
        {
            StackAngle = pi / 2 - i * stackStep;
            x = radiusX / 2 * (float)Math.cos(StackAngle); //membagi radiusX dengan 2
            y = radiusY / 2 * (float)Math.cos(StackAngle); //membagi radiusY dengan 2
            z = radiusZ * (float)Math.sin(StackAngle);

            for (int j = 0; j <= sectorCount; ++j)
            {
                sectorAngle = j * sectorStep;
                Vector3f temp_vector = new Vector3f();
                temp_vector.x = centerPoint.get(0) + x * (float)Math.cos(sectorAngle);
                temp_vector.y = centerPoint.get(1) + y * (float)Math.sin(sectorAngle);
                temp_vector.z = centerPoint.get(2) + z;
                vertices.add(temp_vector);
            }
        }
    }
}