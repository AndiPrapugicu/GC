package cg.bouncycube;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView;

public class CubeRenderer implements GLSurfaceView.Renderer {
    public static final int SS_SUNLIGHT = GL10.GL_LIGHT0;

    private Cube mCube;
    private float mTransY;
    private float mAngle;

    public CubeRenderer() {
        mCube = new Cube();
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();

        gl.glTranslatef(0.0f, (float) Math.sin(mTransY), -7.0f);
        mTransY += 0.075f;

        gl.glRotatef(mAngle, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(mAngle, 1.0f, 0.0f, 0.0f);
        mAngle += 0.4f;

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);

        mCube.draw(gl);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        gl.glViewport(0, 0, width, height);

        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();

        float fieldOfView = 30.0f / 57.3f;
        float aspectRatio = (float) width / (float) height;
        float zNear = 0.1f;
        float zFar = 1000.0f;
        float size = zNear * (float) Math.tan(fieldOfView / 2.0f);

        gl.glFrustumf(-size, size, -size / aspectRatio, size / aspectRatio, zNear, zFar);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glDisable(GL10.GL_DITHER);
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST);
        gl.glClearColor(0, 0, 0, 0);
        gl.glEnable(GL10.GL_CULL_FACE);
        gl.glShadeModel(GL10.GL_SMOOTH);
        gl.glEnable(GL10.GL_DEPTH_TEST);
        initLighting(gl);
    }

    protected static FloatBuffer makeFloatBuffer(float[] array) {
        ByteBuffer bb = ByteBuffer.allocateDirect(array.length * 4);
        bb.order(ByteOrder.nativeOrder());
        FloatBuffer fb = bb.asFloatBuffer();
        fb.put(array);
        fb.position(0);
        return fb;
    }

    private void initLighting(GL10 gl) {
        float[] diffuseLight = {1.0f, 1.0f, 1.0f, 1.0f};
        float[] ambientLight = {0.15f, 0.15f, 0.15f, 1.0f};
        float[] specularLight = {1.0f, 1.0f, 1.0f, 1.0f};
        float[] position = {6.0f, 5.0f, 8.0f, 1.0f};

        float[] diffuseMaterial = {0.0f, 1.0f, 0.0f, 1.0f};
        float[] ambientMaterial = {0.1f, 0.35f, 0.1f, 1.0f};
        float[] specularMaterial = {1.0f, 1.0f, 1.0f, 1.0f};
        float[] globalAmbient = {0.1f, 0.1f, 0.1f, 1.0f};
        float[] spotDirection = {-0.6f, -0.5f, -0.8f};

        gl.glLightfv(SS_SUNLIGHT, GL10.GL_POSITION, makeFloatBuffer(position));
        gl.glLightfv(SS_SUNLIGHT, GL10.GL_DIFFUSE, makeFloatBuffer(diffuseLight));
        gl.glLightfv(SS_SUNLIGHT, GL10.GL_AMBIENT, makeFloatBuffer(ambientLight));
        gl.glLightfv(SS_SUNLIGHT, GL10.GL_SPECULAR, makeFloatBuffer(specularLight));
        gl.glLightf(SS_SUNLIGHT, GL10.GL_LINEAR_ATTENUATION, 0.06f);

        gl.glLightfv(SS_SUNLIGHT, GL10.GL_SPOT_DIRECTION, makeFloatBuffer(spotDirection));
        gl.glLightf(SS_SUNLIGHT, GL10.GL_SPOT_CUTOFF, 35.0f);
        gl.glLightf(SS_SUNLIGHT, GL10.GL_SPOT_EXPONENT, 20.0f);

        gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_DIFFUSE, makeFloatBuffer(diffuseMaterial));
        gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_AMBIENT, makeFloatBuffer(ambientMaterial));
        gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_SPECULAR, makeFloatBuffer(specularMaterial));
        gl.glMaterialf(GL10.GL_FRONT_AND_BACK, GL10.GL_SHININESS, 40.0f);

        gl.glLightModelfv(GL10.GL_LIGHT_MODEL_AMBIENT, makeFloatBuffer(globalAmbient));
        gl.glShadeModel(GL10.GL_SMOOTH);
        gl.glEnable(GL10.GL_LIGHTING);
        gl.glEnable(SS_SUNLIGHT);
    }
}
