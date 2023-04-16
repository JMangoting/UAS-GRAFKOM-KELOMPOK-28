package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_POLYGON;

public class Ellipsoid extends Circle{
    float radiusZ;
    int stackCount;
    int sectorCount;
    int pilihan;
    public Ellipsoid(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float radiusZ,
                  int sectorCount,int stackCount, int pilihan) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        this.radiusZ = radiusZ;
        this.stackCount = stackCount;
        this.sectorCount = sectorCount;
        this.pilihan = pilihan;
        if (pilihan == 1){
            createEllipsoid();
        } else if (pilihan == 2) {
            createHalfEllipsoid();
        } else if (pilihan == 3){
            createHalfEllipsoidUpper();
        } else if (pilihan == 4){
            createHalfEllipsoidRightSide();
        } else if (pilihan == 5){
            createHalfEllipsoidLeftSide();
        }
        setupVAOVBO();
    }


    public void createEllipsoid(){

        vertices.clear();

        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = radiusX * (float)(Math.cos(v) * Math.cos(u));
                float y = radiusY * (float)(Math.cos(v) * Math.sin(u));
                float z = radiusZ * (float)(Math.sin(v));
                temp.add(new Vector3f(x + centerPoint.get(0),y + centerPoint.get(1),z + centerPoint.get(2)));
            }
        }
        vertices=temp;
    }

    public void createHalfEllipsoid(){

        vertices.clear();

        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = 0; u<= Math.PI; u+=Math.PI/60){
                float x = radiusX * (float)(Math.cos(v) * Math.cos(u));
                float y = -Math.abs(radiusY * (float)(Math.cos(v) * Math.sin(u)));
                float z = radiusZ * (float)(Math.sin(v));
                temp.add(new Vector3f(x + centerPoint.get(0),y + centerPoint.get(1),z + centerPoint.get(2)));
            }
        }
        vertices=temp;
    }

    public void createHalfEllipsoidUpper(){

        vertices.clear();

        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = 0; u<= Math.PI; u+=Math.PI/60){
                float x = radiusX * (float)(Math.cos(v) * Math.cos(u));
                float y = Math.abs(radiusY * (float)(Math.cos(v) * Math.sin(u)));
                float z = radiusZ * (float)(Math.sin(v));
                temp.add(new Vector3f(x + centerPoint.get(0),y + centerPoint.get(1),z + centerPoint.get(2)));
            }
        }
        vertices=temp;
    }

    public void createHalfEllipsoidRightSide(){

        vertices.clear();

        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = 0; u<= Math.PI/2; u+=Math.PI/60){ // mengubah batas atas sudut u menjadi Math.PI/2
                float x = radiusX * (float)(Math.cos(v) * Math.cos(u));
                float y = -Math.abs(radiusY * (float)(Math.cos(v) * Math.sin(u)));
                float z = radiusZ * (float)(Math.sin(v));
                temp.add(new Vector3f(x + centerPoint.get(0),y + centerPoint.get(1),z + centerPoint.get(2)));
            }
        }
        vertices=temp;
    }

    public void createHalfEllipsoidLeftSide(){

        vertices.clear();

        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = Math.PI/2; v >= -Math.PI/2; v-=Math.PI/60){ // perulangan variabel v diubah arahnya
            for(double u = Math.PI/2; u >= 0; u-=Math.PI/60){ // perulangan variabel u diubah arahnya
                float x = -radiusX * (float)(Math.cos(v) * Math.cos(u));
                float y = -Math.abs(radiusY * (float)(Math.cos(v) * Math.sin(u)));
                float z = radiusZ * (float)(Math.sin(v));
                temp.add(new Vector3f(x + centerPoint.get(0),y + centerPoint.get(1),z + centerPoint.get(2)));
            }
        }
        vertices=temp;
    }




}