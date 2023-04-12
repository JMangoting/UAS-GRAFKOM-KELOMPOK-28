package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15C.*;


public class Circle extends Object {
    List<Integer> index;

    int ibo;

    float r;

    public Circle (List<ShaderModuleData> shaderModuleDataList, Vector4f color, float r){
        super(shaderModuleDataList,color);
        this.r = r;
        this.color = color;
        this.vertices = new ArrayList<>();
    }
    public Circle (List<ShaderModuleData> shaderModuleDataList, Vector4f color, List<Integer> index, float r){
        super(shaderModuleDataList,color);
        this.r = r;
        this.index = index;
        this.color = color;
        this.vertices = new ArrayList<>();
        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,
                Utils.listoInt(index), GL_STATIC_DRAW);
    }

    public void createOval(float xR, float yR){
        double x,y;
        for(double i = 0;i<2*Math.PI;i+=Math.PI/360){
            x = 2*r * Math.cos(i) + xR;
            y = r * Math.sin(i) + yR;
            this.vertices.add(new Vector3f((float)x,(float)y,0.0f));
        }
        setupVAOVBO();
    }

    public void createCircle(float xR, float yR){
        double x,y;
        for(double i = 0;i<2*Math.PI;i+=Math.PI/360){
            x = r * Math.cos(i) + xR;
            y = r * Math.sin(i) + yR;
            this.vertices.add(new Vector3f((float)x,(float)y,0.0f));
        }
        setupVAOVBO();
    }
    public void createTriangle(float xR, float yR){
        double x,y;
        for(double i = 90;i<360;i+=120){
            double blah = Math.toRadians(i);
            x = r * Math.cos(blah) + xR;
            y = r * Math.sin(blah) + yR;
            this.vertices.add(new Vector3f((float)x,(float)y,0.0f));
        }
        setupVAOVBO();
    }

    public void createSquare(float xR, float yR){
        double x,y;
        for(double i = 45;i<360;i+=90){
            double blah = Math.toRadians(i);
            x = r * Math.cos(blah) + xR;
            y = r * Math.sin(blah) + yR;
            this.vertices.add(new Vector3f((float)x,(float)y,0.0f));
        }
        setupVAOVBO();
    }

    public void createShapeWithCircle(float xR, float yR, float jumlahVertice){
        double x,y;
        for(double i = 0;i<360;i+=(360/jumlahVertice)){
            double blah = Math.toRadians(i);
            x = r * Math.cos(blah) + xR;
            y = r * Math.sin(blah) + yR;
            this.vertices.add(new Vector3f((float)x,(float)y,0.0f));
        }
        setupVAOVBO();
    }

    public void randomDraw(){
        drawSetup();

        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glDrawElements(GL_TRIANGLES, index.size(), GL_UNSIGNED_INT, 0);
    }
    public void draw(){
        drawSetup();
        // Draw the vertices
        // Optional
        glLineWidth(0);//Ketebalan garis
        glPointSize(1);//Besar kecil vertex
        //wajib
        //GL_LINES
        //GL_LINE_STRIP
        //GL_LINE_LOOP
        //GL_TRIANGLES
        //GL_TRIANGLE_FAN
        //GL_POINT
        glDrawArrays(GL_TRIANGLE_FAN,0, vertices.size());
    }
}

