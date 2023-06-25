import Engine.*;
import Engine.Object;
import org.joml.*;
import org.lwjgl.opengl.GL;

import java.io.IOException;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;

public class Main {
    private Window window = new Window(1080, 1080, "Hello World");
    ArrayList<Object> objectCar = new ArrayList<>();
    ArrayList<Object> objectGround = new ArrayList<>();
    ArrayList<Object> objectTree = new ArrayList<>();
    ArrayList<Object> objectBarrier = new ArrayList<>();
    Camera camera = new Camera();
    Projection projection = new Projection(window.getWidth(), window.getHeight());
    float distance = 1f;
    float angle = 0f;
    float move = 0.01f;
    List<Float> temp;
    int cameraMode = 0;
    public void run() throws IOException {

        init();
        loop();

        // Terminate GLFW and free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public void init() throws IOException {
        window.init();
        GL.createCapabilities();
        camera.setPosition(0f, 0.5f, 0f);

        // mobil (ObjectObj(0))
        objectCar.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.5f,0.5f,0.5f,1.0f),
                "resources/model/mobil/mobil.obj"
        ));
        objectCar.get(0).scaleObject(4f,4f,4f);
        objectCar.get(0).translateObject(0f, -0.05f, 2.4f);

//        // mobil (ObjectObj(1))
//        objectCar.add(new Model(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.5f,0.5f,0.5f,1.0f),
//                "resources/model/mobil/mobil.obj"
//        ));
//        objectCar.get(1).scaleObject(4f,4f,4f);
//        objectCar.get(1).translateObject(0.85f, 0f, -1.8f);

        // rumput objectBottom0
        objectGround.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.01f,0.59f,0.17f,1.0f),
                "resources/model/bottom/Terrain_Grass_Flat_1x1.obj"
        ));
        objectGround.get(0).scaleObject(5f ,1f, 7f);
        objectGround.get(0).translateObject(0f, -0.565f, 0f);

        // jalan kiri objectBottom1
        objectGround.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.05f,0.05f,0.05f,1.0f),
                "resources/model/bottom/Terrain_Grass_Flat_1x1.obj"
        ));
        objectGround.get(1).scaleObject(1.1f ,0.5f, 7f);
        objectGround.get(1).translateObject(-0.55f, -0.312f, 0f);

        // jalan kanan objectBottom2
        objectGround.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.05f,0.05f,0.05f,1.0f),
                "resources/model/bottom/Terrain_Grass_Flat_1x1.obj"
        ));
        objectGround.get(2).scaleObject(1.1f ,0.5f, 7f);
        objectGround.get(2).translateObject(0.55f, -0.312f, 0f);

        // barrier kiri objectBarrier0
        objectBarrier.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.7f,0.7f,0.7f,1.0f),
                "resources/model/barrier/box.obj"
        ));
        objectBarrier.get(0).scaleObject(0.05f ,0.04f, 3.5f);
        objectBarrier.get(0).translateObject(-1.2f, 0f, 0f);

        // barrier kanan objectBarrier1
        objectBarrier.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.7f,0.7f,0.7f,1.0f),
                "resources/model/barrier/box.obj"
        ));
        objectBarrier.get(1).scaleObject(0.05f ,0.04f, 3.5f);
        objectBarrier.get(1).translateObject(1.2f, 0f, 0f);

        //pohon objectTree0 (BAGIAN KIRI)
        objectTree.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0f,0f,1.0f),
                "resources/model/pohon/pohon.obj"
        ));
        objectTree.get(0).scaleObject(0.05f ,0.05f, 0.05f);
        objectTree.get(0).translateObject(-1.4f, -0.05f, 0f);

        //pohon objectTree1
        objectTree.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0f,0f,1.0f),
                "resources/model/pohon/pohon.obj"
        ));
        objectTree.get(1).scaleObject(0.05f ,0.05f, 0.05f);
        objectTree.get(1).translateObject(-1.4f, -0.05f, 0.5f);

        //pohon objectTree2
        objectTree.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0f,0f,1.0f),
                "resources/model/pohon/pohon.obj"
        ));
        objectTree.get(2).scaleObject(0.05f ,0.05f, 0.05f);
        objectTree.get(2).translateObject(-1.4f, -0.05f, 1f);

        //pohon objectTree3
        objectTree.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0f,0f,1.0f),
                "resources/model/pohon/pohon.obj"
        ));
        objectTree.get(3).scaleObject(0.05f ,0.05f, 0.05f);
        objectTree.get(3).translateObject(-1.4f, -0.05f, 1.5f);

        //pohon objectTree4
        objectTree.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0f,0f,1.0f),
                "resources/model/pohon/pohon.obj"
        ));
        objectTree.get(4).scaleObject(0.05f ,0.05f, 0.05f);
        objectTree.get(4).translateObject(-1.4f, -0.05f, 2f);

        //pohon objectTree5
        objectTree.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0f,0f,1.0f),
                "resources/model/pohon/pohon.obj"
        ));
        objectTree.get(5).scaleObject(0.05f ,0.05f, 0.05f);
        objectTree.get(5).translateObject(-1.4f, -0.05f, 2.5f);

        //pohon objectTree6
        objectTree.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0f,0f,1.0f),
                "resources/model/pohon/pohon.obj"
        ));
        objectTree.get(6).scaleObject(0.05f ,0.05f, 0.05f);
        objectTree.get(6).translateObject(-1.4f, -0.05f, 2.5f);

        //pohon objectTree7
        objectTree.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0f,0f,1.0f),
                "resources/model/pohon/pohon.obj"
        ));
        objectTree.get(7).scaleObject(0.05f ,0.05f, 0.05f);
        objectTree.get(7).translateObject(-1.4f, -0.05f, -0.5f);

        //pohon objectTree8
        objectTree.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0f,0f,1.0f),
                "resources/model/pohon/pohon.obj"
        ));
        objectTree.get(8).scaleObject(0.05f ,0.05f, 0.05f);
        objectTree.get(8).translateObject(-1.4f, -0.05f, -1f);

        //pohon objectTree9
        objectTree.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0f,0f,1.0f),
                "resources/model/pohon/pohon.obj"
        ));
        objectTree.get(9).scaleObject(0.05f ,0.05f, 0.05f);
        objectTree.get(9).translateObject(-1.4f, -0.05f, -1.5f);

        //pohon objectTree10
        objectTree.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0f,0f,1.0f),
                "resources/model/pohon/pohon.obj"
        ));
        objectTree.get(10).scaleObject(0.05f ,0.05f, 0.05f);
        objectTree.get(10).translateObject(-1.4f, -0.05f, -2f);

        //pohon objectTree11 (BAGIAN KANAN)
        objectTree.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0f,0f,1.0f),
                "resources/model/pohon/pohon.obj"
        ));
        objectTree.get(11).scaleObject(0.05f ,0.05f, 0.05f);
        objectTree.get(11).translateObject(1.4f, -0.05f, 0f);

        //pohon objectTree12
        objectTree.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0f,0f,1.0f),
                "resources/model/pohon/pohon.obj"
        ));
        objectTree.get(12).scaleObject(0.05f ,0.05f, 0.05f);
        objectTree.get(12).translateObject(1.4f, -0.05f, 0.5f);

        //pohon objectTree13
        objectTree.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0f,0f,1.0f),
                "resources/model/pohon/pohon.obj"
        ));
        objectTree.get(13).scaleObject(0.05f ,0.05f, 0.05f);
        objectTree.get(13).translateObject(1.4f, -0.05f, 1f);

        //pohon objectTree14
        objectTree.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0f,0f,1.0f),
                "resources/model/pohon/pohon.obj"
        ));
        objectTree.get(14).scaleObject(0.05f ,0.05f, 0.05f);
        objectTree.get(14).translateObject(1.4f, -0.05f, 1.5f);

        //pohon objectTree15
        objectTree.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0f,0f,1.0f),
                "resources/model/pohon/pohon.obj"
        ));
        objectTree.get(15).scaleObject(0.05f ,0.05f, 0.05f);
        objectTree.get(15).translateObject(1.4f, -0.05f, 2f);

        //pohon objectTree16
        objectTree.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0f,0f,1.0f),
                "resources/model/pohon/pohon.obj"
        ));
        objectTree.get(16).scaleObject(0.05f ,0.05f, 0.05f);
        objectTree.get(16).translateObject(1.4f, -0.05f, 2.5f);

        //pohon objectTree17
        objectTree.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0f,0f,1.0f),
                "resources/model/pohon/pohon.obj"
        ));
        objectTree.get(17).scaleObject(0.05f ,0.05f, 0.05f);
        objectTree.get(17).translateObject(1.4f, -0.05f, 2.5f);

        //pohon objectTree18
        objectTree.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0f,0f,1.0f),
                "resources/model/pohon/pohon.obj"
        ));
        objectTree.get(18).scaleObject(0.05f ,0.05f, 0.05f);
        objectTree.get(18).translateObject(1.4f, -0.05f, -0.5f);

        //pohon objectTree19
        objectTree.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0f,0f,1.0f),
                "resources/model/pohon/pohon.obj"
        ));
        objectTree.get(19).scaleObject(0.05f ,0.05f, 0.05f);
        objectTree.get(19).translateObject(1.4f, -0.05f, -1f);

        //pohon objectTree20
        objectTree.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0f,0f,1.0f),
                "resources/model/pohon/pohon.obj"
        ));
        objectTree.get(20).scaleObject(0.05f ,0.05f, 0.05f);
        objectTree.get(20).translateObject(1.4f, -0.05f, -1.5f);

        //pohon objectTree21
        objectTree.add(new Model(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0f,0f,1.0f),
                "resources/model/pohon/pohon.obj"
        ));
        objectTree.get(21).scaleObject(0.05f ,0.05f, 0.05f);
        objectTree.get(21).translateObject(1.4f, -0.05f, -2f);
    }

    public void input() {
        temp = objectCar.get(0).getCenterPoint();
        angle = angle % (float) Math.toRadians(360);

        if (window.isKeyPressed(GLFW_KEY_1)){
            cameraMode = 1;
            System.out.println("Camera Mode: " + cameraMode);
        }

        if (window.isKeyPressed(GLFW_KEY_2)){
            cameraMode = 2;
            System.out.println("Camera Mode: " + cameraMode);
        }

        if (window.isKeyPressed(GLFW_KEY_W)) {
            if (cameraMode == 0) {
                camera.moveForward(move);
            } else if (cameraMode == 1) {
                objectCar.get(0).translateObject(0f, 0f, -move);
                camera.setPosition(temp.get(0), temp.get(1) + 0.3f, temp.get(2));
                camera.moveBackwards(distance);
            }
            else if (cameraMode == 2) {
                objectCar.get(0).translateObject(0f, 0f, -move);
                camera.setPosition(temp.get(0), temp.get(1) + 0.15f , temp.get(2) - 1.15f);
                camera.moveBackwards(distance);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_A)) {
            if (cameraMode == 0) {
                camera.moveLeft(move);
            } else if (cameraMode == 1) {
                objectCar.get(0).translateObject(-move, 0f, 0f);
                camera.setPosition(temp.get(0), temp.get(1) + 0.3f, temp.get(2));
                camera.moveBackwards(distance);
            }
            else if (cameraMode == 2) {
                objectCar.get(0).translateObject(-move, 0f, 0f);
                camera.setPosition(temp.get(0), temp.get(1) + 0.15f , temp.get(2) - 1.15f);
                camera.moveBackwards(distance);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_S)) {
            if (cameraMode == 0) {
                camera.moveBackwards(move);
            } else if (cameraMode == 1) {
                objectCar.get(0).translateObject(0f, 0f, move);
                camera.setPosition(temp.get(0), temp.get(1) + 0.3f, temp.get(2));
                camera.moveBackwards(distance);
            }
            else if (cameraMode == 2) {
                objectCar.get(0).translateObject(0f, 0f, move);
                camera.setPosition(temp.get(0), temp.get(1) + 0.15f , temp.get(2) - 1.15f);
                camera.moveBackwards(distance);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_D)) {
            if (cameraMode == 0) {
                camera.moveRight(move);
            } else if (cameraMode == 1) {
                objectCar.get(0).translateObject(move, 0f, 0f);
                camera.setPosition(temp.get(0), temp.get(1) + 0.3f, temp.get(2));
                camera.moveBackwards(distance);
            }
            else if (cameraMode == 2) {
                objectCar.get(0).translateObject(move, 0f, 0f);
                camera.setPosition(temp.get(0), temp.get(1) + 0.15f , temp.get(2) - 1.15f);
                camera.moveBackwards(distance);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_UP)) {
            if (cameraMode == 0) {
                camera.addRotation(-0.01f, 0f);
            } else {
                camera.moveForward(distance);
                camera.addRotation(-0.01f, 0f);
                camera.moveBackwards(distance);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_DOWN)) {
            if (cameraMode == 0) {
                camera.addRotation(0.01f, 0f);
            } else {
                camera.moveForward(distance);
                camera.addRotation(0.01f, 0f);
                camera.moveBackwards(distance);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_LEFT)) {
            if (cameraMode == 0) {
                camera.addRotation(0f, -0.01f);
            } else {
                camera.moveForward(distance);
                camera.addRotation(0f, -0.01f);
                camera.moveBackwards(distance);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_RIGHT)) {
            if (cameraMode == 0) {
                camera.addRotation(0f, 0.01f);
            } else {
                camera.moveForward(distance);
                camera.addRotation(0f, 0.01f);
                camera.moveBackwards(distance);
            }
        }

        if (window.getMouseInput().isRightButtonPressed()) {
            Vector2f displVec = window.getMouseInput().getDisplVec();
            if (cameraMode == 2) {
                camera.addRotation((float) Math.toRadians(displVec.x * 0.1f), (float) Math.toRadians(displVec.y * 0.1f));
            } else {
                camera.moveForward(distance);
                camera.addRotation((float) Math.toRadians(displVec.x * 0.1f), (float) Math.toRadians(displVec.y * 0.1f));
                camera.moveBackwards(distance);
            }
        }

        if (window.getMouseInput().getScroll().y != 0) {
            projection.setFOV(projection.getFOV() - (window.getMouseInput().getScroll().y * 0.1f));
            window.getMouseInput().setScroll(new Vector2f());
        }

        if (window.isKeyPressed(GLFW_KEY_SPACE)) {
            if (cameraMode == 0) {
                camera.moveUp(move);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)) {
            if (cameraMode == 0) {
                camera.moveDown(move);
            }
        }

//        if (window.isKeyPressed(GLFW_KEY_1) && !delay3) { // look back
//
//            camera.setPosition(-temp.get(0), -temp.get(1), -temp.get(2));
//            camera.addRotation(0, (float) Math.toRadians(180f));
//            camera.setPosition(temp.get(0), temp.get(1), temp.get(2));
//            camera.moveBackwards(distance);
//
//            delay3 = true;
//        }
    }

    public void loop() {
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            GL.createCapabilities();

            input();

            // code here
            for (Object object: objectCar) {
                object.draw(camera, projection);
            }

            for (Object object: objectGround) {
                object.draw(camera, projection);
            }

            for (Object object: objectTree) {
                object.draw(camera, projection);
            }

            for (Object object: objectBarrier) {
                object.draw(camera, projection);
            }

            // Restore state
            glDisableVertexAttribArray(0);
            // Poll for window events.
            // The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}
