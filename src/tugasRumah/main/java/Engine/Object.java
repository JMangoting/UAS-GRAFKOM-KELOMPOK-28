package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL11C.glPointSize;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

public class Object extends ShaderProgram{

    List<Vector3f> verticesColor;
    //cuma ada 3 vao,ebo,vbo yang pasti vao,vbo
    List<Vector3f> vertices; //menyimpan nilai x,y,z
    int vao;
    int vbo;

    int vboColor;

    UniformsMap uniformsMap;

    Vector4f color;

    public Object(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        setupVAOVBO();
        uniformsMap = new UniformsMap(getProgramId());
        uniformsMap.createUniform("uni_color");
        this.color = color;
    }

    public Object(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, List<Vector3f> verticesColor) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        this.verticesColor = verticesColor;
        setupVAOVBOWithVerticesColor();
    }

    public Object(List<ShaderModuleData> shaderModuleDataList, Vector4f color) {
        super(shaderModuleDataList);
        this.color = color;
        uniformsMap = new UniformsMap(getProgramId());
        uniformsMap.createUniform("uni_color");
    }


    public void setupVAOVBO(){
        //set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        //set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices), GL_STATIC_DRAW);
    }

    public void setupVAOVBOWithVerticesColor(){
        //set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        //set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices), GL_STATIC_DRAW);

        //set vboColor
        vboColor = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(verticesColor), GL_STATIC_DRAW);
    }

    public void draw(){
        drawSetup();
        //draw vertices
        //opsional
        glLineWidth(1);//mengukur ketebalan
        glPointSize(0); //besar kecil vertex
        //wajib
        //yang sering GL_LINE, LINE_STRIP, LINE_LOOP, LINE_TRIANGLE, TRIANGLE_FAN, GL_POINT
        glDrawArrays(GL_TRIANGLES,0, vertices.size());
    }

    public void drawWithVerticesColor(){
        drawSetupWithVerticesColor();
        //draw vertices
        //opsional
        glLineWidth(1);//mengukur ketebalan
        glPointSize(0); //besar kecil vertex
        //wajib
        //yang sering GL_LINE, LINE_STRIP, LINE_LOOP, LINE_TRIANGLE, TRIANGLE_FAN, GL_POINT
        glDrawArrays(GL_TRIANGLES,0, vertices.size());
    }



    public void drawSetup(){
        bind();
        uniformsMap.setUniform("uni_color", color);
        //Bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0,3,GL_FLOAT, false,0,0);
    }

    public void drawSetupWithVerticesColor(){
        bind();

        //Bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0,3,GL_FLOAT, false,0,0);

        //Bind VBOColor
        glEnableVertexAttribArray(1);
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glVertexAttribPointer(1,3,GL_FLOAT, false,0,0);
    }
}
