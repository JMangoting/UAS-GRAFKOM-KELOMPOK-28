import Engine.*;
import Engine.Object;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.glfwSetErrorCallback;
import static org.lwjgl.glfw.GLFW.glfwTerminate;


import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main {
    private Window window = new Window(800,800,"Hello World!");
    private ArrayList<Object> objects = new ArrayList<>();

    private ArrayList<Object> objectsRectangle = new ArrayList<>();

    private ArrayList<Rectangle> objectStar = new ArrayList<>();

    private Circle c1;
    private Circle c2;

    private Circle triangle;
    private Circle square;
    private Circle random;
    private Circle randomInOrder;

    private Circle oval1;
    private Circle oval2;
    private Circle oval3;



    public void init(){
        window.init();
        GL.createCapabilities();

        //code


        objectsRectangle.add(new Rectangle(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-1.0f,-0.5f,0.0f),
                                        new Vector3f(1.0f, -0.5f, 0.0f),
                                        new Vector3f(-1.0f, -1.0f, 0.0f),
                                        new Vector3f(1.0f, -1.0f, 0.0f)
                                )
                        ),
                    new Vector4f(0.0f, 1.0f, 0.0f, 1.0f),
                    Arrays.asList(0,1,2,1,2,3)

                )
        );

        objectsRectangle.add(new Rectangle(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f,0.0f,0.0f),
                                        new Vector3f(-0.5f, -0.6f, 0.0f),
                                        new Vector3f(0.5f, 0.0f, 0.0f),
                                        new Vector3f(0.5f, -0.6f, 0.0f)
                                )
                        ),
                        new Vector4f(1.0f, 1.0f, 0.0f, 1.0f),
                        Arrays.asList(0,1,2,1,2,3)

                )
        );

        objectsRectangle.add(new Rectangle(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.4f,0.25f,0.0f),
                                        new Vector3f(-0.6f, -0.15f, 0.0f),
                                        new Vector3f(0.4f, 0.25f, 0.0f),
                                        new Vector3f(0.6f, -0.15f, 0.0f)
                                )
                        ),
                        new Vector4f(0.6f, 0.6f, 0.3f, 1.0f),
                        Arrays.asList(0,1,2,1,2,3)
                )
        );

        objectsRectangle.add(new Rectangle(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f,-0.1f,0.0f),
                                        new Vector3f(-0.5f, -0.2f, 0.0f),
                                        new Vector3f(-0.2f, -0.1f, 0.0f),
                                        new Vector3f(-0.2f, -0.2f, 0.0f)
                                )
                        ),
                        new Vector4f(1.0f, 1.0f, 0.0f, 1.0f),
                        Arrays.asList(0,1,2,1,2,3)
                )
        );

        objectsRectangle.add(new Rectangle( // cerobong batang
                Arrays.asList(
                        //lokasi shaderFile menyusaikan objectnya
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)

                ), new ArrayList<>(List.of(
                new Vector3f(0.2f, 0.2f, 0.0f),
                new Vector3f(0.2f, 0.3f, 0.0f),
                new Vector3f(0.3f, 0.3f, 0.0f),
                new Vector3f(0.3f, 0.2f, 0.0f)
        )
        ), new Vector4f(1.0f,0.6f,0.0f,1.0f),
                Arrays.asList(0,1,2,2,0,3)
        ));

        objectsRectangle.add(new Rectangle( // cerobong ujung
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)

                ), new ArrayList<>(List.of(
                new Vector3f(0.18f, 0.3f, 0.0f),
                new Vector3f(0.18f, 0.35f, 0.0f),
                new Vector3f(0.32f, 0.35f, 0.0f),
                new Vector3f(0.32f, 0.3f, 0.0f)
        )
        ), new Vector4f(219/255f,38/255f,18/255f,1.0f),
                Arrays.asList(0,1,2,2,0,3)
        ));

        objects.add(new Object(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f,-0.1f,0.0f),
                                        new Vector3f(-0.15f, -0.17f, 0.0f),
                                        new Vector3f(-0.35f, 0.2f, 0.0f)
                                )
                        ),
                        new Vector4f(1.0f, 1.0f, 0.0f, 1.0f)
//                        new ArrayList<>(
//                                List.of(
//                                        new Vector3f(1.0f,0.0f,0.0f),
//                                        new Vector3f(1.0f, 0.0f  , 0.0f),
//                                        new Vector3f(1.0f, 0.0f, 0.0f)
//                                )
//                        )
                )
        );

        objectStar.add(new Rectangle( // bintang garis kuning kanan
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)

                ), new ArrayList<>(List.of(
                new Vector3f(0.80f,0.85f,0.0f),
                new Vector3f(0.91f,0.875f,0.0f),
                new Vector3f(0.825f,0.79f,0.0f),
                new Vector3f(0.85f,0.91f,0.0f),
                new Vector3f(0.89f,0.805f,0.0f)
        )
        ), new Vector4f(255/255f,255/255f,0/255f,1.0f)
        ));

        objectStar.add(new Rectangle( // bintang garis kuning tengah
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)

                ), new ArrayList<>(List.of(
                new Vector3f(0.40f,0.45f,0.0f),
                new Vector3f(0.51f,0.475f,0.0f),
                new Vector3f(0.425f,0.39f,0.0f),
                new Vector3f(0.45f,0.51f,0.0f),
                new Vector3f(0.49f,0.405f,0.0f)
        )
        ), new Vector4f(255/255f,255/255f,0/255f,1.0f)
        ));

        objectStar.add(new Rectangle( // bintang garis kuning kiri
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)

                ), new ArrayList<>(List.of(
                new Vector3f(-0.20f,0.75f,0.0f),
                new Vector3f(-0.31f,0.775f,0.0f),
                new Vector3f(-0.225f,0.69f,0.0f),
                new Vector3f(-0.25f,0.81f,0.0f),
                new Vector3f(-0.29f,0.705f,0.0f)
        )
        ), new Vector4f(255/255f,255/255f,0/255f,1.0f)
        ));

        c1 = (new Circle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new Vector4f(255/255f,255/255f,0/255f,1.0f),
                0.2f
        ));
        c1.createCircle(-0.7f,0.6f);

        c2 = new Circle(Arrays.asList(
                new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new Vector4f(0.0f,0.0f,1.0f,1.0f),
                0.2f
        );
        c2.createCircle(-0.6f,0.69f);

        oval1 = new Circle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new Vector4f(238/225f, 238/255f, 238/255f, 1.0f),
                0.05f
        );
        oval1.createOval(0.25f,0.43f);

        oval2 = new Circle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new Vector4f(238/225f, 238/255f, 238/255f, 1.0f),
                0.05f
        );
        oval2.createOval(0.3f,0.48f);

        oval3 = new Circle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new Vector4f(238/225f, 238/255f, 238/255f, 1.0f),
                0.05f
        );
        oval3.createOval(0.35f,0.53f);


//        triangle = new Circle(Arrays.asList(
//                new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//        ), new Vector4f(11/255f,227/255f,51/255f,1.0f),
//                1.0f
//        );
//        triangle.createTriangle(0.0f,0.0f);

//        square = new Circle(Arrays.asList(
//                new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//        ), new Vector4f(11/255f,227/255f,51/255f,1.0f),
//                1.0f
//        );
//        square.createSquare(0.0f,0.0f);

//        random = new Circle(Arrays.asList(
//                new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//        ), new Vector4f(11/255f,227/255f,51/255f,1.0f),
//                1.0f
//        );
//        random.createShapeWithCircle(0.0f,0.0f, 6);

//        randomInOrder = new Circle(Arrays.asList(
//                new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//        ), new Vector4f(11/255f,227/255f,51/255f,1.0f),
//                Arrays.asList(0,1,2,0,2,3,0,3,4,0,4,5),
//                1.0f
//        );
//        randomInOrder.createShapeWithCircle(0.0f,0.0f, 6);

//        Arrays.asList(0,3,1,4,2,0),


//        oval1 = new Circle(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ), new Vector4f(238/225f, 238/255f, 238/255f, 1.0f),
//                0.05f
//        );
//        oval1.createOval(0.2f,0.25f);

//        oval2 = new Circle(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ), new Vector4f(238/225f, 238/255f, 238/255f, 1.0f),
//                0.035f
//        );
//        oval2.createOval(0.5f,0.57f);
//
//        oval3 = new Circle(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ), new Vector4f(238/225f, 238/255f, 238/255f, 1.0f),
//                0.05f
//        );
//        oval3.createOval(0.32f,0.64f);




    }

    public void loop(){
        while (window.isOpen()){
            window.update();
            glClearColor(0.0f,0.0f,1.0f,0.0f);
            GL.createCapabilities();

            //code
            for (Object object: objectsRectangle){
                object.draw();
            }

            for (Object object: objects){
                object.draw();
            }

            for (Rectangle object : objectStar){
                object.drawLine();
            }

            c1.draw();
            c2.draw();

//            triangle.draw();
//            square.draw();
//            random.draw();
//            randomInOrder.randomDraw();
            oval1.draw();
            oval2.draw();
            oval3.draw();
            //restore state
            glDisableVertexAttribArray(0);

            //poll for windows events
            //the keycallback abovw will only be
            //invoked during this call
            glfwPollEvents();
        }
    }
    public void run(){
        init();
        loop();
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }
    public static void main(String[] args) {
        new Main().run();

    }
}