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
    private ArrayList<Object> makeSphere
            = new ArrayList<>();

    private ArrayList<Object> makeBox
            = new ArrayList<>();

    private ArrayList<Object> makeCylinder
            = new ArrayList<>();

    private ArrayList<Object> makeEllipsoid
            = new ArrayList<>();

    private ArrayList<Object> makeTorus
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
        camera.setPosition(0.0f,0.25f,1f);
        camera.setRotation((float)Math.toRadians(0.0f),(float)Math.toRadians(0.0f));
        //code
//        objects.add(new Object2d(
//            Arrays.asList(
//                //shaderFile lokasi menyesuaikan objectnya
//                new ShaderProgram.ShaderModuleData
//                ("resources/shaders/scene.vert"
//                , GL_VERTEX_SHADER),
//                new ShaderProgram.ShaderModuleData
//                ("resources/shaders/scene.frag"
//                , GL_FRAGMENT_SHADER)
//            ),
//            new ArrayList<>(
//                List.of(
//                    new Vector3f(0.0f,0.5f,0.0f),
//                    new Vector3f(-0.5f,-0.5f,0.0f),
//                    new Vector3f(0.5f,-0.5f,0.0f)
//                )
//            ),
//            new Vector4f(0.0f,1.0f,1.0f,1.0f)
//        ));
//        objects.add(new Object(
//            Arrays.asList(
//                //shaderFile lokasi menyesuaikan objectnya
//                new ShaderProgram.ShaderModuleData
//                ("resources/shaders/" +
//                    "sceneWithVerticesColor.vert"
//                        , GL_VERTEX_SHADER),
//                new ShaderProgram.ShaderModuleData
//                    ("resources/shaders/" +
//                    "sceneWithVerticesColor.frag"
//                            , GL_FRAGMENT_SHADER)
//        ),
//        new ArrayList<>(
//                List.of(
//                    new Vector3f(0.0f,0.5f,0.0f),
//                    new Vector3f(-0.5f,-0.5f,0.0f),
//                    new Vector3f(0.5f,-0.5f,0.0f)
//                )
//            ),
//        new ArrayList<>(
//            List.of(
//                new Vector3f(1.0f,0.0f,0.0f),
//                new Vector3f(0.0f,1.0f,0.0f),
//                new Vector3f(0.0f,0.0f,1.0f)
//            )
//        )
//        ));
//        objectsRectangle.add(new Rectangle(
//            Arrays.asList(
//                //shaderFile lokasi menyesuaikan objectnya
//                new ShaderProgram.ShaderModuleData
//                ("resources/shaders/scene.vert"
//                , GL_VERTEX_SHADER),
//                new ShaderProgram.ShaderModuleData
//                ("resources/shaders/scene.frag"
//                , GL_FRAGMENT_SHADER)
//            ),
//            new ArrayList<>(
//                List.of(
//                    new Vector3f(0.0f,0.0f,0.0f),
//                    new Vector3f(0.5f,0.0f,0.0f),
//                    new Vector3f(0.0f,0.5f,0.0f),
//                    new Vector3f( 0.5f,0.5f,0.0f)
//                )
//            ),
//            new Vector4f(0.0f,1.0f,1.0f,1.0f),
//            Arrays.asList(0,1,2,1,2,3)
//
//        ));
//        objectsPointsControl.add(new Object(
//            Arrays.asList(
//                //shaderFile lokasi menyesuaikan objectnya
//                new ShaderProgram.ShaderModuleData
//                ("resources/shaders/scene.vert"
//                , GL_VERTEX_SHADER),
//                new ShaderProgram.ShaderModuleData
//                ("resources/shaders/scene.frag"
//                , GL_FRAGMENT_SHADER)
//            ),
//            new ArrayList<>(),
//            new Vector4f(0.0f,1.0f,1.0f,1.0f)
//        ));
//        makeSphere.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1.0f,1.0f,0.0f,1.0f),
//                Arrays.asList(0.0f,0.0f,0.0f),
//                0.250f,
//                0.250f,
//                0.250f,
//                36,
//                18
//        ));
        //wall-e character
        makeBox.add(new Box(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
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
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
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
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
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
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
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
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
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
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
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
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
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
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
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
        //masih fail
        makeTorus.add(new Torus(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,1.0f,1.0f,1.0f),
                Arrays.asList(0.5f,0.5f,0.5f),
                0.017f,
                0.017f,
                36,
                18
        ));


        //rocket
        makeCylinder.add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,1.0f,0.3f,1.0f),
                Arrays.asList(0.0f,0.5f,0.0f),
                0.08f,
                0.1f,
                36,
                18
        ));

        //planet
        makeEllipsoid.add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.75f,0.75f,0.75f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.250f,
                0.250f,
                0.250f,
                36,
                18,
                2
        ));

        makeTorus.add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.7f,0.7f,0.7f,1.0f),
                Arrays.asList(1.0f,1.0f,1.0f),
                0.250f,
                0.250f,
                0.250f,
                36,
                18,
                2
        ));


//        objects.get(0).translateObject(0.5f,0.0f,0.0f);
//        objects.get(0).scaleObject(5f,5f,5f);
//
//        objects.get(0).getChildObject().add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.0f,1.0f,0.0f,1.0f),
//                Arrays.asList(0.0f,0.0f,0.0f),
//                0.125f,
//                0.125f,
//                0.125f,
//                36,
//                18
//        ));
//        objects.get(0).getChildObject().get(0).translateObject(0.25f,0.0f,0.0f);
////        objects.get(0).getChildObject().get(0).setCenterPoint(Arrays.asList(0.25f,0.0f,0.0f));
//
//        objects.get(0).getChildObject().add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.0f,1.0f,0.0f,1.0f),
//                Arrays.asList(0.0f,0.0f,0.0f),
//                0.125f,
//                0.125f,
//                0.125f,
//                36,
//                18
//        ));
//        objects.get(0).getChildObject().get(1).translateObject(0.5f,0.0f,0.0f);
////        objects.get(0).getChildObject().get(1).setCenterPoint(Arrays.asList(0.5f,0.0f,0.0f));
//
//        objects.get(0).getChildObject().get(1).getChildObject().add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("Project1/GrafkomA/resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.0f,1.0f,0.0f,1.0f),
//                Arrays.asList(0.0f,0.0f,0.0f),
//                0.125f,
//                0.125f,
//                0.125f,
//                36,
//                18
//        ));
//        objects.get(0).getChildObject().get(1).getChildObject().get(0).scaleObject(0.5f,0.5f,0.5f);
//        objects.get(0).getChildObject().get(1).getChildObject().get(0).translateObject(0.5f,-0.1f,0.0f);
//        objects.get(0).getChildObject().get(1).getChildObject().get(0).setCenterPoint(Arrays.asList(0.5f,-0.1f,0.0f));
    }

    public void rotate(){
        for ( float i = 0.0f; i <= (float) Math.toRadians(360.0f); i++){
            countDegree++;
            makeCylinder.get(0).rotateObject((float) Math.toRadians(0.3f),0.0f,1.0f,0.0f);
        }
    }
    public void input(){
//        if (window.isKeyPressed(GLFW_KEY_W)) {
//            countDegree++;
//            //rotasi terhadap matahari
//            objects.get(0).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
//            for(Object child:objects.get(0).getChildObject()){
//                List<Float> temp = new ArrayList<>(child.getCenterPoint());
//                //rotasi terhadap sumbu masing-masing planet
//                child.translateObject(temp.get(0)*-1,temp.get(1)*-1,temp.get(2)*-1);
//                child.rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
//                child.translateObject(temp.get(0)*1,temp.get(1)*1,temp.get(2)*1);
//                for(Object y:objects.get(0).getChildObject().get(1).getChildObject()){
//                    //rotasi terhadap bumi
//                    List<Float> temp1 = new ArrayList<>(objects.get(0).getChildObject().get(1).getCenterPoint());
//                    y.translateObject(temp1.get(0)*-1,temp1.get(1)*-1,temp1.get(2)*-1);
//                    y.rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
//                    y.translateObject(temp1.get(0)*1,temp1.get(1)*1,temp1.get(2)*1);
//                    //rotasi terhadap sumbunya sendiri
//                    temp1 = new ArrayList<>(objects.get(0).getChildObject().get(1).getChildObject().get(0).getCenterPoint());
//                    y.translateObject(temp1.get(0)*-1,temp1.get(1)*-1,temp1.get(2)*-1);
//                    y.rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
//                    y.translateObject(temp1.get(0)*1,temp1.get(1)*1,temp1.get(2)*1);
//                }
//                child.rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
//            }
//        }

        if(mouseInput.isLeftButtonPressed()){
            Vector2f pos = mouseInput.getCurrentPos();
//            System.out.println("x : "+pos.x+" y : "+pos.y);
            pos.x = (pos.x - (window.getWidth())/2.0f) /
                    (window.getWidth()/2.0f);
            pos.y = (pos.y - (window.getHeight())/2.0f) /
                    (-window.getHeight()/2.0f);
            //System.out.println("x : "+pos.x+" y : "+pos.y);

            if((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1))){
                System.out.println("x : "+pos.x+" y : "+pos.y);
//                objectsPointsControl.get(0).addVertices(new Vector3f(pos.x,pos.y,0));
            }
        }

        if(window.isKeyPressed(GLFW_KEY_W)){
            camera.moveForward(0.005f);
        }
        if(window.isKeyPressed(GLFW_KEY_S)){
            camera.moveBackwards(0.005f);
        }
        if(window.isKeyPressed(GLFW_KEY_A)){
            camera.moveLeft(0.005f);
        }
        if(window.isKeyPressed(GLFW_KEY_D)){
            camera.moveRight(0.005f);
        }
        if(window.isKeyPressed(GLFW_KEY_SPACE)){
            camera.moveUp(0.005f);
        }
        if(window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)){
            camera.moveDown(0.005f);
        }



    }
    public void loop(){
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f,
                    0.0f, 0.0f,
                    0.0f);
            GL.createCapabilities();
//            rotate();
            input();

            //code
            for(Object object: makeSphere){
                object.draw(camera,projection);
            }

            for(Object object: makeBox){
                object.draw(camera,projection);
            }

            for(Object object: makeCylinder){
                object.draw(camera,projection);
            }

            for(Object object: makeEllipsoid){
                object.draw(camera,projection);
            }

            for(Object object: makeTorus){
                object.draw(camera,projection);
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