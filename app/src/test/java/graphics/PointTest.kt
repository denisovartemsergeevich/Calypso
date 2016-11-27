package graphics

import org.junit.Assert.*
import org.junit.Test

class PointTest {
    @Test
    fun init() {
        val x = 34f
        val y = 56f
        val point = Point(x, y)
        assertEquals(point.x, x)
        assertEquals(point.y, y)
    }

    @Test
    fun initWithoutParams() {
        val point = Point()
        assertEquals(point.x, 0f)
        assertEquals(point.y, 0f)
    }

    @Test
    fun compare() {
        assertNotEquals(Point(1f, 3f), Point(3f, 1f))
        assertEquals(Point(1f, 3f), Point(1f, 3f))
    }

    @Test
    fun isNull() {
        assertEquals(Point(0f, 0f).isNull(), true)
    }

    @Test
    fun timesToNumber() {
        val x = 453f
        val y = 56f
        val k = 34f
        assertEquals(Point(x, y) * k, Point(x * k, y * k))
        assertEquals(k * Point(x, y), Point(x * k, y * k))
    }

    @Test
    fun minus() {
        val x1 = 34f; val y1 = 3f
        val x2 = 5f; val y2 = 57f
        assertEquals(Point(x1,y1) - Point(x2,y2), Point(x1-x2, y1-y2))
    }

    @Test
    fun plus() {
        val x1 = 34f; val y1 = 3f
        val x2 = 5f; val y2 = 57f
        assertEquals(Point(x1,y1) + Point(x2,y2), Point(x1+x2, y1+y2))
    }

    @Test
    fun unaryMinus() {
        val x = 4f; val y = 6f
        assertEquals(-Point(x,y), Point(-x,-y))
    }

    @Test
    fun div() {
        val x = 453f
        val y = 56f
        val k = 34f
        assertEquals(Point(x, y) / k, Point(x / k, y / k))
    }
}