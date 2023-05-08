import Engine.*;
import Engine.Object;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main {
    private Window window =
            new Window
                    (800,800,"Hello World");

    private ArrayList<Object> makeBox
            = new ArrayList<>();

    private ArrayList<Object> makeCylinder
            = new ArrayList<>();

    private ArrayList<Object> makeEllipsoid
            = new ArrayList<>();

    private ArrayList<Object> makeCone
            = new ArrayList<>();

    private ArrayList<Object> makeSphere
            = new ArrayList<>();

    private ArrayList<Object> objectsPointsControl
            = new ArrayList<>();

    private MouseInput mouseInput;
    int countDegree = 0;
    Projection projection = new Projection(window.getWidth(),window.getHeight());
    Camera camera = new Camera();
    public void init(){
        window.init();
        GL.createCapabilities();
        mouseInput = window.getMouseInput();
        camera.setPosition(0.0f,0.35f,1.4f);
        glEnable(GL_DEPTH_TEST);
        glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
        glDepthMask(true);
        glDepthFunc(GL_LEQUAL);
        glDepthRange(0.0f, 2.0f);
        camera.setPosition(0.0f,0.25f,1.3f);
        camera.setRotation((float)Math.toRadians(0.0f),(float)Math.toRadians(0.0f));
        //code
        //wall-e character
        makeBox.add(new Box(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.960f, 0.914f, 0.0480f,1.0f),
                Arrays.asList(0.0f,0.075f,0.0f),
                0.1f,
                0.1f,
                0.1f,
                36,
                18
        ));

        makeBox.add(new Box(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.480f, 0.478f, 0.446f,1.0f),
                Arrays.asList(0.0f,0.145f,0.0f),
                0.025f,
                0.04f,
                0.02f,
                36,
                18
        ));
        //left eye steel
        makeCylinder.add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.960f, 0.914f, 0.0480f,1.0f),
                Arrays.asList(-0.025f,0.165f,0.0f),
                0.025f,
                0.03f,
                36,
                18
        ));
        //right eye steel
        makeCylinder.add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.960f, 0.914f, 0.0480f,1.0f),
                Arrays.asList(0.025f,0.165f,0.0f),
                0.025f,
                0.03f,
                36,
                18
        ));
        //left eye putih
        makeEllipsoid.add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,1.0f,1.0f,1.0f),
                Arrays.asList(-0.025f,0.165f,0.01f),
                0.02f,
                0.02f,
                0.02f,
                36,
                18,
                1
        ));
        //right eye putih
        makeEllipsoid.add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,1.0f,1.0f,1.0f),
                Arrays.asList(0.025f,0.165f,0.01f),
                0.02f,
                0.02f,
                0.02f,
                36,
                18,
                1
        ));
        //black eye left
        makeEllipsoid.add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,0.0f,0.0f,1.0f),
                Arrays.asList(-0.025f,0.165f,0.015f),
                0.017f,
                0.017f,
                0.017f,
                36,
                18,
                1
        ));
        //black eye right
        makeEllipsoid.add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,0.0f,0.0f,1.0f),
                Arrays.asList(0.025f,0.165f,0.015f),
                0.017f,
                0.017f,
                0.017f,
                36,
                18,
                1
        ));
        //right hand
        makeBox.add(new Box(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.480f, 0.478f, 0.446f,1.0f),
                Arrays.asList(0.06f,0.075f,0.0f),
                0.02f,
                0.05f,
                0.05f,
                36,
                18
        ));
        //left hand
        makeBox.add(new Box(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.480f, 0.478f, 0.446f,1.0f),
                Arrays.asList(-0.06f,0.075f,0.0f),
                0.02f,
                0.05f,
                0.05f,
                36,
                18
        ));
        //left back wheel
        makeEllipsoid.add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,1.0f,1.0f,1.0f),
                Arrays.asList(-0.05f,0.025f,-0.05f),
                0.017f,
                0.017f,
                0.017f,
                36,
                18,
                1
        ));

        //left front wheel
        makeEllipsoid.add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,1.0f,1.0f,1.0f),
                Arrays.asList(-0.05f,0.025f,0.05f),
                0.017f,
                0.017f,
                0.017f,
                36,
                18,
                1
        ));
        //right front wheel
        makeEllipsoid.add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,1.0f,1.0f,1.0f),
                Arrays.asList(0.05f,0.025f,0.05f),
                0.017f,
                0.017f,
                0.017f,
                36,
                18,
                1
        ));

        //right back wheel
        makeEllipsoid.add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,1.0f,1.0f,1.0f),
                Arrays.asList(0.05f,0.025f,-0.05f),
                0.017f,
                0.017f,
                0.017f,
                36,
                18,
                1
        ));

        //rocket
        makeCylinder.add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.217f, 0.0979f, 0.890f,1.0f),
                Arrays.asList(-0.4f,0.7f,-0.05f),
                0.05f,
                0.3f,
                36,
                18
        ));

        //moncong roket - cone
        makeCone.add(new Cone(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.860f, 0.051f, 0.0f,1.0f),
                Arrays.asList(-0.4f,0.7f,0.1f),
                0.05f,
                0.2f,
                36,
                18,
                1
        ));

        //kaki roket kiri
        makeBox.add(new Box(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.690f, 0.697f, 0.697f,1.0f),
                Arrays.asList(-0.46f,0.7f,-0.1f),
                0.02f,
                0.02f,
                0.2f,
                36,
                18
        ));

        //kaki roket kanan
        makeBox.add(new Box(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.690f, 0.697f, 0.697f,1.0f),
                Arrays.asList(-0.34f,0.7f,-0.1f),
                0.02f,
                0.02f,
                0.2f,
                36,
                18
        ));

        //planet - half ellipsoid
        makeEllipsoid.add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.320f, 0.315f, 0.304f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.8f,
                0.7f,
                0.8f,
                36,
                18,
                2
        ));

        //BACKGROUND
        //pohon 1
        //batang pohon 1
        makeCylinder.add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.550f, 0.348f, 0.00f,1.0f),
                Arrays.asList(-0.6f,0.0f,-0.1f),
                0.05f,
                0.2f,
                36,
                18
        ));
        makeCylinder.get(3).rotateObject((float) Math.toRadians(90.0f),1.0f,0.0f,0.0f);
        //daun pohon
        makeCone.add(new Cone(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.8f, 0.00f,1.0f),
                Arrays.asList(-0.6f,0.0f,0.1f),
                0.15f,
                0.25f,
                36,
                18,
                1
        ));
        makeCone.get(1).rotateObject((float) Math.toRadians(-90.0f),1.0f,0.0f,0.0f);
        makeCone.add(new Cone(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.8f, 0.00f,1.0f),
                Arrays.asList(-0.6f,0.0f,0.17f),
                0.15f,
                0.25f,
                36,
                18,
                1
        ));
        makeCone.get(2).rotateObject((float) Math.toRadians(-90.0f),1.0f,0.0f,0.0f);
        makeCone.add(new Cone(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.8f, 0.00f,1.0f),
                Arrays.asList(-0.6f,0.0f,0.24f),
                0.15f,
                0.25f,
                36,
                18,
                1
        ));
        makeCone.get(3).rotateObject((float) Math.toRadians(-90.0f),1.0f,0.0f,0.0f);
        //pohon 2
        //batang pohon 2
        makeCylinder.add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.550f, 0.348f, 0.00f,1.0f),
                Arrays.asList(0.6f,0.0f,-0.1f),
                0.05f,
                0.2f,
                36,
                18
        ));
        makeCylinder.get(4).rotateObject((float) Math.toRadians(90.0f),1.0f,0.0f,0.0f);
        //daun pohon
        makeCone.add(new Cone(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.8f, 0.00f,1.0f),
                Arrays.asList(0.6f,0.0f,0.1f),
                0.15f,
                0.25f,
                36,
                18,
                1
        ));
        makeCone.get(4).rotateObject((float) Math.toRadians(-90.0f),1.0f,0.0f,0.0f);
        makeCone.add(new Cone(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.8f, 0.00f,1.0f),
                Arrays.asList(0.6f,0.0f,0.17f),
                0.15f,
                0.25f,
                36,
                18,
                1
        ));
        makeCone.get(5).rotateObject((float) Math.toRadians(-90.0f),1.0f,0.0f,0.0f);
        makeCone.add(new Cone(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.8f, 0.00f,1.0f),
                Arrays.asList(0.6f,0.0f,0.24f),
                0.15f,
                0.25f,
                36,
                18,
                1
        ));
        makeCone.get(6).rotateObject((float) Math.toRadians(-90.0f),1.0f,0.0f,0.0f);
        //batang pohon 3
        makeCylinder.add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.550f, 0.348f, 0.00f,1.0f),
                Arrays.asList(-0.6f,0.2f,0.0f),
                0.05f,
                0.1f,
                36,
                18
        ));
        makeCylinder.get(5).rotateObject((float) Math.toRadians(90.0f),1.0f,0.0f,0.0f);
        //batang pohon 4
        makeCylinder.add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.550f, 0.348f, 0.00f,1.0f),
                Arrays.asList(-0.45f,0.1f,0.0f),
                0.05f,
                0.1f,
                36,
                18
        ));
        makeCylinder.get(6).rotateObject((float) Math.toRadians(90.0f),1.0f,0.0f,0.0f);
        //batang pohon 5
        makeCylinder.add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.550f, 0.348f, 0.00f,1.0f),
                Arrays.asList(0.6f,0.2f,0.0f),
                0.05f,
                0.1f,
                36,
                18
        ));
        makeCylinder.get(7).rotateObject((float) Math.toRadians(90.0f),1.0f,0.0f,0.0f);
        //batang pohon 6
        makeCylinder.add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.550f, 0.348f, 0.00f,1.0f),
                Arrays.asList(0.45f,0.1f,0.0f),
                0.05f,
                0.1f,
                36,
                18
        ));
        makeCylinder.get(8).rotateObject((float) Math.toRadians(90.0f),1.0f,0.0f,0.0f);

        //EVE character
        // eve's body
        makeEllipsoid.add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f,1.0f),
                Arrays.asList(0.25f,0.15f,0.0f),
                0.05f,
                0.15f,
                0.025f,
                36,
                18,
                2
        ));
        // eve's head
        makeEllipsoid.add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f,1.0f),
                Arrays.asList(0.25f,0.165f,0.0f),
                0.05f,
                0.055f,
                0.025f,
                36,
                18,
                3
        ));
        // eve's face
        makeEllipsoid.add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                Arrays.asList(0.25f, 0.17f, 0.0185f),
                0.035f,
                0.045f,
                0.01f,
                36,
                18,
                3
        ));

        // eve's right eye
        makeEllipsoid.add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.20f,0.73f,1.0f,1.0f),
                Arrays.asList(0.235f, 0.185f, 0.0295f),
                0.01f,
                0.0065f,
                0.01f,
                36,
                18,
                1
        ));

        // eve's left eye
        makeEllipsoid.add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.20f,0.73f,1.0f,1.0f),
                Arrays.asList(0.265f, 0.185f, 0.0295f),
                0.01f,
                0.0065f,
                0.01f,
                36,
                18,
                1
        ));

        // eve's right hand
        makeEllipsoid.add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f,1.0f),
                Arrays.asList(0.3f,0.15f,0.0f),
                0.025f,
                0.095f,
                0.025f,
                36,
                18,
                4
        ));

        // eve's left hand
        makeEllipsoid.add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f,1.0f),
                Arrays.asList(0.2f,0.15f,0.0f),
                0.025f,
                0.095f,
                0.025f,
                36,
                18,
                5
        ));

        // SATELIT
        // top left
        makeBox.add(new Box(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.49f, 0.73f, 0.91f,1.0f),
                Arrays.asList(-0.4f, 0.945f, 0.0f),
                0.05f,
                0.05f,
                0.08f,
                36,
                18
        ));

        // bottom left
        makeBox.add(new Box(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.49f, 0.73f, 0.91f,1.0f),
                Arrays.asList(-0.4f, 0.885f, 0.0f),
                0.05f,
                0.05f,
                0.08f,
                36,
                18
        ));

        // midbox
        makeBox.add(new Box(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.49f, 0.73f, 0.91f,1.0f),
                Arrays.asList(-0.355f, 0.925f, 0.0f),
                0.05f,
                0.05f,
                0.08f,
                36,
                18
        ));

        // top right
        makeBox.add(new Box(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.49f, 0.73f, 0.91f,1.0f),
                Arrays.asList(-0.310f, 0.945f, 0.0f),
                0.05f,
                0.05f,
                0.08f,
                36,
                18
        ));

        // bottom right
        makeBox.add(new Box(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.49f, 0.73f, 0.91f,1.0f),
                Arrays.asList(-0.310f, 0.885f, 0.0f),
                0.05f,
                0.05f,
                0.08f,
                36,
                18
        ));
        // main body
        makeSphere.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                Arrays.asList(-0.355f, 0.925f, 0.0f),
                0.065f,
                0.065f,
                0.06f,
                36,
                18
        ));
        // tail
        makeCylinder.add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                Arrays.asList(-0.355f, 0.925f, 0.1f),
                0.015f,
                0.15f,
                36,
                18
        ));
        // tail(2)
        makeCone.add(new Cone(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.49f, 0.73f, 0.91f,1.0f),
                Arrays.asList(-0.355f, 0.925f, 0.175f),
                0.035f,
                0.055f,
                36,
                18,
                2
        ));

    }





    public void rotate(){
        for ( float i = 0.0f; i <= (float) Math.toRadians(360.0f); i++){
            countDegree++;
            makeCylinder.get(2).rotateObject((float) Math.toRadians(0.1f),0.0f,1.0f,0.0f);
            makeCone.get(0).rotateObject((float) Math.toRadians(0.1f),0.0f,1.0f,0.0f);
            makeBox.get(4).rotateObject((float) Math.toRadians(0.1f),0.0f,1.0f,0.0f);
            makeBox.get(5).rotateObject((float) Math.toRadians(0.1f),0.0f,1.0f,0.0f);
        }
        // satelite's rotation
        for (float i = (float) Math.toRadians(360.0f); i >= 0.0f; i -= (float) Math.toRadians(1.0f)) {
            countDegree++;
            makeSphere.get(0).rotateObject(-(float) Math.toRadians(1.0f), 0.0f, 1.0f, 0.0f);
            makeBox.get(6).rotateObject(-(float) Math.toRadians(1.0f), 0.0f, 1.0f, 0.0f);
            makeBox.get(7).rotateObject(-(float) Math.toRadians(1.0f), 0.0f, 1.0f, 0.0f);
            makeBox.get(8).rotateObject(-(float) Math.toRadians(1.0f), 0.0f, 1.0f, 0.0f);
            makeBox.get(9).rotateObject(-(float) Math.toRadians(1.0f), 0.0f, 1.0f, 0.0f);
            makeBox.get(10).rotateObject(-(float) Math.toRadians(1.0f), 0.0f, 1.0f, 0.0f);
            makeCylinder.get(9).rotateObject(-(float) Math.toRadians(1.0f), 0.0f, 1.0f, 0.0f);
            makeCone.get(7).rotateObject(-(float) Math.toRadians(1.0f), 0.0f, 1.0f, 0.0f);
        }
    }


    public void input() {

        //move wall-e
        if (window.isKeyPressed(GLFW_KEY_UP)) {
            for (int i = 0; i < 4; i++){
                makeBox.get(i).translateObject(0.0f, 0.0f, -0.01f);
            }
            makeCylinder.get(0).translateObject(0.0f, 0.0f, -0.01f);
            makeCylinder.get(1).translateObject(0.0f, 0.0f, -0.01f);
            for (int i = 0; i < 8; i++){
                makeEllipsoid.get(i).translateObject(0.0f, 0.0f, -0.01f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_DOWN)) {
            for (int i = 0; i < 4; i++){
                makeBox.get(i).translateObject(0.0f, 0.0f, 0.01f);
            }
            makeCylinder.get(0).translateObject(0.0f, 0.0f, 0.01f);
            makeCylinder.get(1).translateObject(0.0f, 0.0f, 0.01f);
            for (int i = 0; i < 8; i++){
                makeEllipsoid.get(i).translateObject(0.0f, 0.0f, 0.01f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_RIGHT)) {
            for (int i = 0; i < 4; i++){
                makeBox.get(i).translateObject(0.01f, 0.0f, 0.0f);
            }
            makeCylinder.get(0).translateObject(0.01f, 0.0f, 0.0f);
            makeCylinder.get(1).translateObject(0.01f, 0.0f, 0.0f);
            for (int i = 0; i < 8; i++){
                makeEllipsoid.get(i).translateObject(0.01f, 0.0f, 0.0f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_LEFT)) {
            for (int i = 0; i < 4; i++){
                makeBox.get(i).translateObject(-0.01f, 0.0f, 0.0f);
            }
            makeCylinder.get(0).translateObject(-0.01f, 0.0f, 0.0f);
            makeCylinder.get(1).translateObject(-0.01f, 0.0f, 0.0f);
            for (int i = 0; i < 8; i++){
                makeEllipsoid.get(i).translateObject(-0.01f, 0.0f, 0.0f);
            }
        }
        // eve's character movements
        // belakang
        if (window.isKeyPressed(GLFW_KEY_I)){
            for (int i = 9; i < 16; i++){
                makeEllipsoid.get(i).translateObject(0.0f, 0.0f, -0.01f);
            }
        }
        // depan
        if (window.isKeyPressed(GLFW_KEY_K)){
            for (int i = 9; i < 16; i++){
                makeEllipsoid.get(i).translateObject(0.0f, 0.0f, 0.01f);
            }
        }
        // kanan
        if (window.isKeyPressed(GLFW_KEY_L)){
            for (int i = 9; i < 16; i++){
                makeEllipsoid.get(i).translateObject(0.01f, 0.0f, 0.0f);
            }
        }
        // kiri
        if (window.isKeyPressed(GLFW_KEY_J)){
            for (int i = 9; i < 16; i++){
                makeEllipsoid.get(i).translateObject(-0.01f, 0.0f, 0.0f);
            }
        }

//            if (mouseInput.isLeftButtonPressed()) {
//                Vector2f pos = mouseInput.getCurrentPos();
//            System.out.println("x : "+pos.x+" y : "+pos.y);
//                pos.x = (pos.x - (window.getWidth()) / 2.0f) /
//                        (window.getWidth() / 2.0f);
//                pos.y = (pos.y - (window.getHeight()) / 2.0f) /
//                        (-window.getHeight() / 2.0f);
//                System.out.println("x : "+pos.x+" y : "+pos.y);
//
//                if ((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1))) {
//                    System.out.println("x : " + pos.x + " y : " + pos.y);
////                objectsPointsControl.get(0).addVertices(new Vector3f(pos.x,pos.y,0));
//                }
//            }

        if (window.isKeyPressed(GLFW_KEY_W)) {
            camera.moveForward(0.005f);
        }
        if (window.isKeyPressed(GLFW_KEY_S)) {
            camera.moveBackwards(0.005f);
        }
        if (window.isKeyPressed(GLFW_KEY_A)) {
            camera.moveLeft(0.005f);
        }
        if (window.isKeyPressed(GLFW_KEY_D)) {
            camera.moveRight(0.005f);
        }
        if (window.isKeyPressed(GLFW_KEY_SPACE)) {
            camera.moveUp(0.005f);
        }
        if (window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)) {
            camera.moveDown(0.005f);
        }
    }

    public ArrayList<Vector3f> generateBezierPoints(float firstX, float firstY, float firstZ, float secondX, float secondY, float secondZ, float thirdX, float thirdY, float thirdZ)
    {
        ArrayList<Vector3f> result = new ArrayList<>();
        float newX, newY, newZ;
        for(double i = 0; i <=1; i+= 0.01)
        {
            newX = (float) ((Math.pow((1-i), 2) * firstX) + (2 * (1-i) * i * secondX) + (Math.pow(i, 2) * thirdX));
            newY = (float) ((Math.pow((1-i), 2) * firstY) + (2 * (1-i) * i * secondY) + (Math.pow(i, 2) * thirdY));
            newZ = (float) ((Math.pow((1-i), 2) * firstZ) + (2 * (1-i) * i * secondZ) + (Math.pow(i, 2) * thirdZ));
            result.add(new Vector3f(newX, newY, newZ));
        }
        return result;
    }

    public void loop () {
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f,
                    0.0f, 0.0f,
                    0.0f);
            GL.createCapabilities();
            rotate();
            input();

            //code
//            for(Object object: makeSphere){
//                object.draw(camera,projection);
//            }

            for (Object object : makeBox) {
                object.draw(camera, projection);
            }

            for (Object object : makeCylinder) {
                object.draw(camera, projection);
            }

            for (Object object : makeEllipsoid) {
                object.draw(camera, projection);
            }

            for (Object object : makeCone) {
                object.draw(camera, projection);
            }
            for (Object object : makeSphere) {
                object.draw(camera, projection);
            }

//            for(Object object: objectsRectangle){
//                object.draw();
//            }
//            for(Object object: objectsPointsControl){
//                object.drawLine();
//            }

            // Restore state
            glDisableVertexAttribArray(0);

            // Poll for window events.
            // The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }
    }
    public void run() {

        init();
        loop();

        // Terminate GLFW and
        // free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }
    public static void main(String[] args) {
        new Main().run();
    }
}