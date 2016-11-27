package com.das.calypso

import android.opengl.GLES20
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4

import java.nio.IntBuffer

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    @Throws(Exception::class)
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()

        assertEquals("com.das.calypso", appContext.packageName)

        val buffer = IntBuffer.allocate(1)
        GLES20.glGetIntegerv(GLES20.GL_TEXTURE_BINDING_2D, buffer)

        assertEquals(buffer.get(0), 0)
    }
}
