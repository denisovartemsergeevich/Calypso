package graphics

import org.junit.Test
import org.junit.Assert.*

class QuadTest {
    @Test
    fun init() {
        val pt1 = Point(1f, 3f)
        val pt2 = Point(10f, 3f)
        val pt3 = Point(14f, 35f)
        val pt4 = Point(1f, 32f)

        val quad = Quad(pt1, pt2, pt3, pt4)
        assertEquals(quad.topLeft, pt1)
        assertEquals(quad.topRight, pt2)
        assertEquals(quad.bottomRight, pt3)
        assertEquals(quad.bottomLeft, pt4)
    }

    @Test
    fun initFromRect() {
        val rc = Rect(0f, 2f, 34f, 56f)
        val quad = Quad(rc)
        assertEquals(quad.topLeft, quad.topLeft)
        assertEquals(quad.topRight, quad.topRight)
        assertEquals(quad.bottomRight, quad.bottomRight)
        assertEquals(quad.bottomLeft, quad.bottomLeft)
    }
}