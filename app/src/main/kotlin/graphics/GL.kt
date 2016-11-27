package graphics

import android.opengl.GLES20

import java.nio.IntBuffer

object GL {
    fun getBoundTextureId()
            = getInteger(GLES20.GL_TEXTURE_BINDING_2D)

    private fun getInteger(paramName:Int) : Int {
        var buffer = IntBuffer.allocate(1)
        GLES20.glGetIntegerv(paramName, buffer)
        return buffer.get(0)
    }
}