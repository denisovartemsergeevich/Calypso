package graphics

import org.junit.Assert.*
import org.junit.Test

class SizeTest {
    @Test
    fun init() {
        val w = 5f; val h = 3f
        val size = Size(w,h)
        assertEquals(size.width, w)
        assertEquals(size.height, h)
    }

    @Test
    fun initWithoutParams() {
        val size = Size()
        assertEquals(size.width, 0f)
        assertEquals(size.height, 0f)
    }

    @Test
    fun equals() {
        val w = 5f; val h = 3f
        assertEquals(Size(w,h), Size(w,h))
        assertNotEquals(Size(7f,2f), Size(4f,6f))
    }

    @Test
    fun isNull() {
        assertTrue(Size().isNull())
        assertTrue(Size(0f,0f).isNull())
        assertFalse(Size(1f,0f).isNull())
    }

    @Test
    fun isEmpty() {
        assertTrue(Size().isEmpty())
        assertTrue(Size(0f,0f).isEmpty())
        assertTrue(Size(0f,-1f).isEmpty())
        assertTrue(Size(-1f,-1f).isEmpty())
        assertTrue(Size(-1f,1f).isEmpty())
        assertTrue(Size(1f,0f).isEmpty())
        assertTrue(Size(0f,2f).isEmpty())
        assertFalse(Size(1f,2f).isEmpty())
    }

    @Test
    fun transposedTest() {
        val w = 45f; val h = 67f
        assertEquals(Size(w,h).transposed(), Size(h,w))
    }

    @Test
    fun minusTest() {
        val w1 = 43f; val h1 = 54f
        val w2 = 75f; val h2 = 2f
        assertEquals(Size(w1,h1)-Size(w2,h2), Size(w1-w2,h1-h2))
    }

    @Test
    fun plusTest() {
        val w1 = 43f; val h1 = 54f
        val w2 = 75f; val h2 = 2f
        assertEquals(Size(w1,h1)+Size(w2,h2), Size(w1+w2,h1+h2))
    }

    @Test
    fun timesTest() {
        val w = 45f; val h = 67f
        val k = 3f
        assertEquals(Size(w,h)*k, Size(w*k, h*k))
        assertEquals(k*Size(w,h), Size(w*k, h*k))
    }

    private fun reducingTest(expectedSize:Size, s1:Size, s2:Size) {
        assertEquals(expectedSize, s1.scaledByReducing(s2))
    }

    @Test
    fun scaledWithReducing() {
        reducingTest(Size(40f,20f), Size(20f,10f), Size(40f,40f))
        reducingTest(Size(40f,20f), Size(200f,100f), Size(40f,40f))
        reducingTest(Size(10f,10f), Size(40f,40f), Size(20f,10f))
        reducingTest(Size(10f,10f), Size(5f,5f), Size(20f,10f))
        reducingTest(Size(10f,0f), Size(5f,0f), Size(10f,10f))
        reducingTest(Size(0f,10f), Size(0f,4f), Size(10f,10f))
        reducingTest(Size(0f,0f), Size(5f,5f), Size(0f,10f))
        reducingTest(Size(0f,0f), Size(5f,5f), Size(10f,0f))
        reducingTest(Size(0f,0f), Size(0f,0f), Size(10f,30f))
        reducingTest(Size(0f,0f), Size(10f,45f), Size(0f,0f))
        reducingTest(Size(20f,0f), Size(10f,0f), Size(20f,0f))
        reducingTest(Size(0f,0f), Size(0f,10f), Size(20f,0f))
        reducingTest(Size(0f,0f), Size(10f,0f), Size(0f,20f))
        reducingTest(Size(0f,20f), Size(0f,10f), Size(0f,20f))
    }

    private fun expandingTest(expectedSize:Size, s1:Size, s2:Size) {
        assertEquals(expectedSize, s1.scaledByExpanding(s2))
    }

    @Test
    fun scaledWithExpanding() {
        expandingTest(Size(80f,40f), Size(20f,10f), Size(40f,40f))
        expandingTest(Size(40f,80f), Size(10f,20f), Size(40f,40f))
        expandingTest(Size(20f,40f), Size(10f,20f), Size(0f,40f))
        expandingTest(Size(40f,80f), Size(10f,20f), Size(40f,0f))
        expandingTest(Size(0f,0f), Size(10f,20f), Size(0f,0f))
        expandingTest(Size(10f, Float.POSITIVE_INFINITY), Size(0f,20f), Size(10f,10f))
        expandingTest(Size(Float.POSITIVE_INFINITY, 10f), Size(10f,0f), Size(10f,10f))
        expandingTest(Size(10f, 0f), Size(10f,0f), Size(10f,0f))
        expandingTest(Size(0f, 10f), Size(0f,20f), Size(0f,10f))
        expandingTest(Size(10f, 0f), Size(20f,0f), Size(10f,0f))
        expandingTest(Size(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY), Size(0f,0f), Size(10f,10f))
    }
}