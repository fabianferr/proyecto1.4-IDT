package com.google.android.exoplayer2.video.spherical;

import android.opengl.GLES20;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.video.spherical.Projection;
import java.nio.FloatBuffer;

final class ProjectionRenderer {
    private static final String[] FRAGMENT_SHADER_CODE = {"#extension GL_OES_EGL_image_external : require", "precision mediump float;", "uniform samplerExternalOES uTexture;", "varying vec2 vTexCoords;", "void main() {", "  gl_FragColor = texture2D(uTexture, vTexCoords);", "}"};
    private static final float[] TEX_MATRIX_BOTTOM = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 1.0f, 1.0f};
    private static final float[] TEX_MATRIX_LEFT = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};
    private static final float[] TEX_MATRIX_RIGHT = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.5f, 1.0f, 1.0f};
    private static final float[] TEX_MATRIX_TOP = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};
    private static final float[] TEX_MATRIX_WHOLE = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};
    private static final String[] VERTEX_SHADER_CODE = {"uniform mat4 uMvpMatrix;", "uniform mat3 uTexMatrix;", "attribute vec4 aPosition;", "attribute vec2 aTexCoords;", "varying vec2 vTexCoords;", "void main() {", "  gl_Position = uMvpMatrix * aPosition;", "  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;", "}"};
    private MeshData leftMeshData;
    private int mvpMatrixHandle;
    private int positionHandle;
    private int program;
    private MeshData rightMeshData;
    private int stereoMode;
    private int texCoordsHandle;
    private int textureHandle;
    private int uTexMatrixHandle;

    ProjectionRenderer() {
    }

    public static boolean isSupported(Projection projection) {
        Projection.Mesh mesh = projection.leftMesh;
        Projection.Mesh mesh2 = projection.rightMesh;
        if (mesh.getSubMeshCount() == 1 && mesh.getSubMesh(0).textureId == 0 && mesh2.getSubMeshCount() == 1 && mesh2.getSubMesh(0).textureId == 0) {
            return true;
        }
        return false;
    }

    public void setProjection(Projection projection) {
        if (isSupported(projection)) {
            this.stereoMode = projection.stereoMode;
            this.leftMeshData = new MeshData(projection.leftMesh.getSubMesh(0));
            this.rightMeshData = projection.singleMesh ? this.leftMeshData : new MeshData(projection.rightMesh.getSubMesh(0));
        }
    }

    /* access modifiers changed from: package-private */
    public void init() {
        int compileProgram = GlUtil.compileProgram(VERTEX_SHADER_CODE, FRAGMENT_SHADER_CODE);
        this.program = compileProgram;
        this.mvpMatrixHandle = GLES20.glGetUniformLocation(compileProgram, "uMvpMatrix");
        this.uTexMatrixHandle = GLES20.glGetUniformLocation(this.program, "uTexMatrix");
        this.positionHandle = GLES20.glGetAttribLocation(this.program, "aPosition");
        this.texCoordsHandle = GLES20.glGetAttribLocation(this.program, "aTexCoords");
        this.textureHandle = GLES20.glGetUniformLocation(this.program, "uTexture");
    }

    /* access modifiers changed from: package-private */
    public void draw(int i, float[] fArr, boolean z) {
        float[] fArr2;
        MeshData meshData = z ? this.rightMeshData : this.leftMeshData;
        if (meshData != null) {
            GLES20.glUseProgram(this.program);
            GlUtil.checkGlError();
            GLES20.glEnableVertexAttribArray(this.positionHandle);
            GLES20.glEnableVertexAttribArray(this.texCoordsHandle);
            GlUtil.checkGlError();
            int i2 = this.stereoMode;
            if (i2 == 1) {
                fArr2 = z ? TEX_MATRIX_BOTTOM : TEX_MATRIX_TOP;
            } else if (i2 == 2) {
                fArr2 = z ? TEX_MATRIX_RIGHT : TEX_MATRIX_LEFT;
            } else {
                fArr2 = TEX_MATRIX_WHOLE;
            }
            GLES20.glUniformMatrix3fv(this.uTexMatrixHandle, 1, false, fArr2, 0);
            GLES20.glUniformMatrix4fv(this.mvpMatrixHandle, 1, false, fArr, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, i);
            GLES20.glUniform1i(this.textureHandle, 0);
            GlUtil.checkGlError();
            GLES20.glVertexAttribPointer(this.positionHandle, 3, 5126, false, 12, meshData.vertexBuffer);
            GlUtil.checkGlError();
            GLES20.glVertexAttribPointer(this.texCoordsHandle, 2, 5126, false, 8, meshData.textureBuffer);
            GlUtil.checkGlError();
            GLES20.glDrawArrays(meshData.drawMode, 0, meshData.vertexCount);
            GlUtil.checkGlError();
            GLES20.glDisableVertexAttribArray(this.positionHandle);
            GLES20.glDisableVertexAttribArray(this.texCoordsHandle);
        }
    }

    /* access modifiers changed from: package-private */
    public void shutdown() {
        int i = this.program;
        if (i != 0) {
            GLES20.glDeleteProgram(i);
        }
    }

    private static class MeshData {
        /* access modifiers changed from: private */
        public final int drawMode;
        /* access modifiers changed from: private */
        public final FloatBuffer textureBuffer;
        /* access modifiers changed from: private */
        public final FloatBuffer vertexBuffer;
        /* access modifiers changed from: private */
        public final int vertexCount;

        public MeshData(Projection.SubMesh subMesh) {
            this.vertexCount = subMesh.getVertexCount();
            this.vertexBuffer = GlUtil.createBuffer(subMesh.vertices);
            this.textureBuffer = GlUtil.createBuffer(subMesh.textureCoords);
            int i = subMesh.mode;
            if (i == 1) {
                this.drawMode = 5;
            } else if (i != 2) {
                this.drawMode = 4;
            } else {
                this.drawMode = 6;
            }
        }
    }
}