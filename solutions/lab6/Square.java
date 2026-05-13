package cg.bouncysquare;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;

public class Square {
    private final FloatBuffer mFVertexBuffer;
    private final ByteBuffer mIndexBuffer;
    private final FloatBuffer mTextureBuffer;
    private final int[] textures = new int[2];
    private final float[] textureCoords = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};

    public Square() {
        float vertices[] = {
                -1.0f, -1.0f,
                 1.0f, -1.0f,
                -1.0f,  1.0f,
                 1.0f,  1.0f
        };

        byte indices[] = {
                0, 3, 1,
                0, 2, 3
        };

        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        mFVertexBuffer = vbb.asFloatBuffer();
        mFVertexBuffer.put(vertices);
        mFVertexBuffer.position(0);

        mIndexBuffer = ByteBuffer.allocateDirect(indices.length);
        mIndexBuffer.put(indices);
        mIndexBuffer.position(0);

        ByteBuffer tbb = ByteBuffer.allocateDirect(textureCoords.length * 4);
        tbb.order(ByteOrder.nativeOrder());
        mTextureBuffer = tbb.asFloatBuffer();
        mTextureBuffer.put(textureCoords);
        mTextureBuffer.position(0);
    }

    public void drawSolid(GL10 gl) {
        gl.glDisable(GL10.GL_TEXTURE_2D);
        gl.glFrontFace(GL11.GL_CW);
        gl.glVertexPointer(2, GL11.GL_FLOAT, 0, mFVertexBuffer);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        gl.glDrawElements(GL11.GL_TRIANGLES, 6, GL11.GL_UNSIGNED_BYTE, mIndexBuffer);

        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glFrontFace(GL11.GL_CCW);
    }

    public void drawTextured(GL10 gl, int textureId) {
        gl.glEnable(GL10.GL_TEXTURE_2D);
        gl.glBindTexture(GL10.GL_TEXTURE_2D, textureId);

        gl.glFrontFace(GL11.GL_CW);
        gl.glVertexPointer(2, GL11.GL_FLOAT, 0, mFVertexBuffer);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, mTextureBuffer);
        gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);

        gl.glDrawElements(GL11.GL_TRIANGLES, 6, GL11.GL_UNSIGNED_BYTE, mIndexBuffer);

        gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisable(GL10.GL_TEXTURE_2D);
        gl.glFrontFace(GL11.GL_CCW);
    }

    public void drawMultiTextured(GL10 gl) {
        GL11 gl11 = (GL11) gl;

        gl.glEnable(GL10.GL_TEXTURE_2D);
        gl11.glActiveTexture(GL11.GL_TEXTURE0);
        gl.glBindTexture(GL10.GL_TEXTURE_2D, textures[0]);
        gl11.glClientActiveTexture(GL11.GL_TEXTURE0);
        gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, mTextureBuffer);
        gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);

        gl11.glActiveTexture(GL11.GL_TEXTURE1);
        gl.glBindTexture(GL10.GL_TEXTURE_2D, textures[1]);
        gl11.glClientActiveTexture(GL11.GL_TEXTURE1);
        gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, mTextureBuffer);
        gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);

        gl11.glTexEnvf(GL10.GL_TEXTURE_ENV, GL10.GL_TEXTURE_ENV_MODE, GL10.GL_MODULATE);

        gl.glFrontFace(GL11.GL_CW);
        gl.glVertexPointer(2, GL11.GL_FLOAT, 0, mFVertexBuffer);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        gl.glDrawElements(GL11.GL_TRIANGLES, 6, GL11.GL_UNSIGNED_BYTE, mIndexBuffer);

        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl11.glClientActiveTexture(GL11.GL_TEXTURE1);
        gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
        gl11.glClientActiveTexture(GL11.GL_TEXTURE0);
        gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
        gl11.glActiveTexture(GL11.GL_TEXTURE1);
        gl.glBindTexture(GL10.GL_TEXTURE_2D, 0);
        gl11.glActiveTexture(GL11.GL_TEXTURE0);
        gl.glBindTexture(GL10.GL_TEXTURE_2D, 0);
        gl.glDisable(GL10.GL_TEXTURE_2D);
        gl.glFrontFace(GL11.GL_CCW);
    }

    public int getTexture(int index) {
        return textures[index];
    }

    public void createTexture(GL10 gl, Context context, int resource) {
        textures[0] = loadTexture(gl, context, resource);
    }

    public void setTextures(GL10 gl, Context context, int resource0, int resource1) {
        textures[0] = loadTexture(gl, context, resource0);
        textures[1] = loadTexture(gl, context, resource1);
    }

    private int loadTexture(GL10 gl, Context context, int resource) {
        Bitmap image = BitmapFactory.decodeResource(context.getResources(), resource);
        int[] textureHandle = new int[1];
        gl.glGenTextures(1, textureHandle, 0);
        gl.glBindTexture(GL10.GL_TEXTURE_2D, textureHandle[0]);
        GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, image, 0);
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR);
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);
        image.recycle();
        return textureHandle[0];
    }
}
