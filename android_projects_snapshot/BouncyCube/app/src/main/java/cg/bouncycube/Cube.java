package cg.bouncycube;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;

public class Cube {
    private FloatBuffer mFVertexBuffer;
    private FloatBuffer mNormalBuffer;
    private ByteBuffer mColorBuffer;
    private ByteBuffer mTFan1;
    private ByteBuffer mTFan2;
        private FloatBuffer mTextureBuffer;
        private int[] textures = new int[1];

    public Cube() {
        float vertices[] = {
                -1.0f,  1.0f,  1.0f,
                 1.0f,  1.0f,  1.0f,
                 1.0f, -1.0f,  1.0f,
                -1.0f, -1.0f,  1.0f,
                -1.0f,  1.0f, -1.0f,
                 1.0f,  1.0f, -1.0f,
                 1.0f, -1.0f, -1.0f,
                -1.0f, -1.0f, -1.0f
        };

        float normals[] = {
                -1.0f / (float) Math.sqrt(3),  1.0f / (float) Math.sqrt(3),  1.0f / (float) Math.sqrt(3),
                 1.0f / (float) Math.sqrt(3),  1.0f / (float) Math.sqrt(3),  1.0f / (float) Math.sqrt(3),
                 1.0f / (float) Math.sqrt(3), -1.0f / (float) Math.sqrt(3),  1.0f / (float) Math.sqrt(3),
                -1.0f / (float) Math.sqrt(3), -1.0f / (float) Math.sqrt(3),  1.0f / (float) Math.sqrt(3),
                -1.0f / (float) Math.sqrt(3),  1.0f / (float) Math.sqrt(3), -1.0f / (float) Math.sqrt(3),
                 1.0f / (float) Math.sqrt(3),  1.0f / (float) Math.sqrt(3), -1.0f / (float) Math.sqrt(3),
                 1.0f / (float) Math.sqrt(3), -1.0f / (float) Math.sqrt(3), -1.0f / (float) Math.sqrt(3),
                -1.0f / (float) Math.sqrt(3), -1.0f / (float) Math.sqrt(3), -1.0f / (float) Math.sqrt(3)
        };

        byte maxColor = (byte) 255;
        byte colors[] = {
                maxColor, 0, 0, maxColor,
                maxColor, 0, 0, maxColor,
                maxColor, 0, 0, maxColor,
                maxColor, 0, 0, maxColor,
                0, 0, 0, maxColor,
                0, 0, 0, maxColor,
                0, 0, 0, maxColor,
                0, 0, 0, maxColor
        };

        byte tFan1[] = {
                1, 0, 3,
                1, 3, 2,
                1, 2, 6,
                1, 6, 5,
                1, 5, 4,
                1, 4, 0
        };

        byte tFan2[] = {
                7, 4, 5,
                7, 5, 6,
                7, 6, 2,
                7, 2, 3,
                7, 3, 0,
                7, 0, 4
        };

        float textureCoords[] = {
                0.0f, 0.0f,
                1.0f, 0.0f,
                1.0f, 1.0f,
                0.0f, 1.0f,
                0.0f, 0.0f,
                1.0f, 0.0f,
                1.0f, 1.0f,
                0.0f, 1.0f
        };

        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        mFVertexBuffer = vbb.asFloatBuffer();
        mFVertexBuffer.put(vertices);
        mFVertexBuffer.position(0);

        ByteBuffer nbb = ByteBuffer.allocateDirect(normals.length * 4);
        nbb.order(ByteOrder.nativeOrder());
        mNormalBuffer = nbb.asFloatBuffer();
        mNormalBuffer.put(normals);
        mNormalBuffer.position(0);

        mColorBuffer = ByteBuffer.allocateDirect(colors.length);
        mColorBuffer.put(colors);
        mColorBuffer.position(0);

        mTFan1 = ByteBuffer.allocateDirect(tFan1.length);
        mTFan1.put(tFan1);
        mTFan1.position(0);

        mTFan2 = ByteBuffer.allocateDirect(tFan2.length);
        mTFan2.put(tFan2);
        mTFan2.position(0);

                ByteBuffer tcb = ByteBuffer.allocateDirect(textureCoords.length * 4);
                tcb.order(ByteOrder.nativeOrder());
                mTextureBuffer = tcb.asFloatBuffer();
                mTextureBuffer.put(textureCoords);
                mTextureBuffer.position(0);
    }

    public void draw(GL10 gl) {
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, mFVertexBuffer);
        gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, mColorBuffer);
        gl.glNormalPointer(GL10.GL_FLOAT, 0, mNormalBuffer);
        gl.glEnableClientState(GL10.GL_NORMAL_ARRAY);

                // enable texture mapping if a texture was created
                gl.glEnable(GL10.GL_TEXTURE_2D);
                gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
                gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, mTextureBuffer);
                gl.glBindTexture(GL10.GL_TEXTURE_2D, textures[0]);

        gl.glDrawElements(GL10.GL_TRIANGLE_FAN, 6 * 3, GL10.GL_UNSIGNED_BYTE, mTFan1);
        gl.glDrawElements(GL10.GL_TRIANGLE_FAN, 6 * 3, GL10.GL_UNSIGNED_BYTE, mTFan2);

                gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
                gl.glDisable(GL10.GL_TEXTURE_2D);
    }

        public void createTexture(GL10 gl, Context context, int resource) {
                Bitmap image = BitmapFactory.decodeResource(context.getResources(), resource);
                gl.glGenTextures(1, textures, 0);
                gl.glBindTexture(GL10.GL_TEXTURE_2D, textures[0]);
                GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, image, 0);
                gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR);
                gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);
                image.recycle();
        }
}
