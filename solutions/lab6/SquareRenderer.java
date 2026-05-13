package cg.bouncysquare;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView;
import android.content.Context;
import android.os.SystemClock;

public class SquareRenderer implements GLSurfaceView.Renderer {
    private final Square mSquare;
    private final Context context;
    private final long mStartTime;

    public SquareRenderer(Context context) {
        this.context = context;
        mSquare = new Square();
        mStartTime = SystemClock.uptimeMillis();
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();

        long elapsed = SystemClock.uptimeMillis() - mStartTime;
        int mode = (int) ((elapsed / 5000L) % 3L);
        float wave = (float) Math.sin(elapsed / 450.0f);

        if (mode == 0) {
            drawColorBlend(gl, wave);
        } else if (mode == 1) {
            drawTextureBlend(gl, wave);
        } else {
            drawMultiTexture(gl, wave);
        }
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();

        float ratio = (float) width / height;
        gl.glFrustumf(-ratio, ratio, -1, 1, 1, 10);
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glDisable(GL10.GL_DITHER);
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST);
        gl.glClearColor(0, 0, 0, 1);
        gl.glEnable(GL10.GL_CULL_FACE);
        gl.glShadeModel(GL10.GL_SMOOTH);
        gl.glDisable(GL10.GL_DEPTH_TEST);
        gl.glEnable(GL10.GL_BLEND);

        int resid = context.getResources().getIdentifier("hedly", "drawable", context.getPackageName());
        int secondResid = context.getResources().getIdentifier("black_stone", "drawable", context.getPackageName());
        if (resid != 0 && secondResid != 0) {
            mSquare.setTextures(gl, this.context, resid, secondResid);
        } else if (resid != 0) {
            mSquare.createTexture(gl, this.context, resid);
        }
    }

    private void drawColorBlend(GL10 gl, float wave) {
        gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);

        gl.glLoadIdentity();
        gl.glTranslatef(0.0f, wave, -3.0f);
        gl.glColor4f(0.0f, 0.0f, 1.0f, 1.0f);
        mSquare.drawSolid(gl);

        gl.glLoadIdentity();
        gl.glTranslatef((float) (Math.sin(wave) / 2.0f), 0.0f, -2.9f);
        gl.glColor4f(1.0f, 0.0f, 0.0f, 0.5f);
        mSquare.drawSolid(gl);
    }

    private void drawTextureBlend(GL10 gl, float wave) {
        gl.glBlendFunc(GL10.GL_ONE, GL10.GL_ONE);

        gl.glLoadIdentity();
        gl.glTranslatef(-0.1f, wave * 0.85f, -3.0f);
        gl.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        mSquare.drawTextured(gl, mSquare.getTexture(0));

        gl.glLoadIdentity();
        gl.glTranslatef((float) (Math.sin(wave) / 2.0f), 0.0f, -2.9f);
        gl.glColor4f(1.0f, 0.93f, 0.76f, 0.75f);
        mSquare.drawTextured(gl, mSquare.getTexture(1));
    }

    private void drawMultiTexture(GL10 gl, float wave) {
        gl.glDisable(GL10.GL_BLEND);

        gl.glLoadIdentity();
        gl.glTranslatef(0.0f, wave * 0.75f, -3.1f);
        gl.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        mSquare.drawMultiTextured(gl);
    }
}
