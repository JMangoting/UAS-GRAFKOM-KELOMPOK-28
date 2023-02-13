import Engine.Window;
import org.lwjgl.opengl.GL;
import static org.lwjgl.glfw.GLFW.glfwSetErrorCallback;
import static org.lwjgl.glfw.GLFW.glfwTerminate;


import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;




public class Main {
    private Window window = new Window(800,800,"Hello World!");

    public void init(){
        window.init();
        GL.createCapabilities();

        //code

    }

    public void loop(){
        while (window.isOpen()){
            window.update();
            glClearColor(0.0f,0.0f,0.0f,0.0f);
            GL.createCapabilities();

            //code

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