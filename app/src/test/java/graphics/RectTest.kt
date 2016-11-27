package graphics

import org.junit.Assert.*
import org.junit.Test

class RectTest {
    @Test
    fun init() {
        val rect = Rect()
        assertEquals(rect.x, 0f)
        assertEquals(rect.y, 0f)
        assertEquals(rect.width, 0f)
        assertEquals(rect.height, 0f)
    }

    @Test
    fun init2() {
        val x = 4f; val y = 65f; val w = 12f; val h = 76f
        val rect = Rect(x, y, w, h)
        assertEquals(rect.x, x)
        assertEquals(rect.y, y)
        assertEquals(rect.width, w)
        assertEquals(rect.height, h)
    }

    @Test
    fun init3() {
        val x = 4f; val y = 65f; val w = 12f; val h = 76f
        val rect = Rect(Point(x, y), Size(w, h))
        assertEquals(rect.x, x)
        assertEquals(rect.y, y)
        assertEquals(rect.width, w)
        assertEquals(rect.height, h)
    }

    @Test
    fun init4() {
        val x = 4f; val y = 65f; val w = 12f; val h = 76f
        val rect = Rect(Point(x, y), Point(x + w, y + h))
        assertEquals(rect.x, x)
        assertEquals(rect.y, y)
        assertEquals(rect.width, w)
        assertEquals(rect.height, h)
    }

    @Test
    fun corners() {
        val x = 4f; val y = 65f; val w = 12f; val h = 76f
        val rect = Rect(Point(x, y), Size(w, h))
        assertEquals(rect.topLeft, Point(x, y))
        assertEquals(rect.topRight, Point(x + w, y))
        assertEquals(rect.bottomRight, Point(x + w, y + h))
        assertEquals(rect.bottomLeft, Point(x, y + h))
    }

    @Test
    fun size() {
        assertEquals(Rect(0f, 0f, 45f, 32f).size, Size(45f, 32f))
    }

    @Test
    fun right() {
        val x = 4f; val y = 65f; val w = 12f; val h = 76f
        val rect = Rect(x, y, w, h)
        assertEquals(rect.right, x + w)
    }

    @Test
    fun bottom() {
        val x = 4f; val y = 65f; val w = 12f; val h = 76f
        val rect = Rect(x, y, w, h)
        assertEquals(rect.bottom, y + h)
    }

    @Test
    fun center() {
        val x = 4f; val y = 65f; val w = 12f; val h = 76f
        val rect = Rect(x, y, w, h)
        assertEquals(rect.center, Point(x + w / 2f, y + h / 2f))
    }

    @Test
    fun adjusted() {
        val x = 4f; val y = 65f; val w = 12f; val h = 76f
        val l = 2f; val t = 3f; val r = 5f; val b = 2f
        val rect = Rect(x, y, w, h)
        assertEquals(rect.adjusted(l, t, r, b), Rect(rect.topLeft + Point(l, t), rect.bottomRight + Point(r, b)))
    }

    @Test
    fun isNull() {
        assertTrue(Rect(45f, 67f, 0f, 0f).isNull())
        assertFalse(Rect(45f, 67f, 1f, 0f).isNull())
        assertFalse(Rect(45f, 67f, 0f, 1f).isNull())
    }

    @Test
    fun isEmpty() {
        assertTrue(Rect(45f, 23f, 0f, 0f).isEmpty())
        assertTrue(Rect(45f, 23f, -1f, -1f).isEmpty())
        assertTrue(Rect(45f, 23f, 1f, 0f).isEmpty())
        assertTrue(Rect(45f, 23f, 0f, 1f).isEmpty())
        assertFalse(Rect(45f, 23f, 1f, 1f).isEmpty())
    }

    @Test
    fun isValid() {
        assertFalse(Rect(45f, 23f, 0f, 0f).isValid())
        assertFalse(Rect(45f, 23f, -1f, -1f).isValid())
        assertFalse(Rect(45f, 23f, 1f, 0f).isValid())
        assertFalse(Rect(45f, 23f, 0f, 1f).isValid())
        assertTrue(Rect(45f, 23f, 1f, 1f).isValid())
    }

    @Test
    fun containsPoint() {
        val x1 = 4f; val y1 = 65f; val x2 = 12f; val y2 = 76f
        val rect = Rect(Point(x1, y1), Point(x2, y2))

        assertTrue(rect.contains(x1, y1))
        assertTrue(rect.contains(x2, y2))
        assertTrue(rect.contains(rect.center))
        assertFalse(rect.contains(x1 - 1f, y1 + 1f))
    }

    @Test
    fun containsRect() {
        val x1 = 4f; val y1 = 65f; val x2 = 12f; val y2 = 76f
        val rect = Rect(Point(x1, y1), Point(x2, y2))

        assertTrue(rect.contains(rect))
        assertTrue(rect.contains(Rect(Point(x1 + 1f, y1 + 1f), Point(x2 - 1f, y2 - 1f))))
        assertFalse(rect.contains(Rect(Point(x1 - 1f, y1), Point(x2, y2))))
    }

    @Test
    fun moveCenter() {
        val rect = Rect(0f, 5f, 34f, 76f)
        val pt = Point(67f, 34f)
        assertEquals(rect.movedCenter(pt.x, pt.y).center, pt)
        assertEquals(rect.movedCenter(pt).center, pt)
    }

    @Test
    fun moveLeft() {
        val rect = Rect(0f, 5f, 34f, 76f)
        val x = 45f
        assertEquals(rect.movedLeft(x).x, x)
    }

    @Test
    fun moveTop() {
        val rect = Rect(0f, 5f, 34f, 76f)
        val y = 675f
        assertEquals(rect.movedTop(y).y, y)
    }

    @Test
    fun moveRight() {
        val rc = Rect(0f, 5f, 34f, 76f)
        val x = 34f
        assertEquals(rc.movedRight(x), Rect(x - rc.width, rc.y, rc.width, rc.height))
    }

    @Test
    fun moveBottom() {
        val rc = Rect(0f, 5f, 34f, 76f)
        val y = 675f
        assertEquals(rc.movedBottom(y), Rect(rc.x, y - rc.height, rc.width, rc.height))
    }

    @Test
    fun moveTopLeft() {
        val rc = Rect(0f, 5f, 34f, 76f)
        val pt = Point(23f, 78f)
        assertEquals(rc.movedTopLeft(pt.x, pt.y), Rect(pt, rc.size))
        assertEquals(rc.movedTopLeft(pt), Rect(pt, rc.size))
    }

    @Test
    fun moveTopRight() {
        val rc = Rect(0f, 5f, 34f, 76f)
        val pt = Point(23f, 78f)
        assertEquals(rc.movedTopRight(pt.x, pt.y), rc.movedRight(pt.x).movedTop(pt.y))
        assertEquals(rc.movedTopRight(pt), rc.movedRight(pt.x).movedTop(pt.y))
    }

    @Test
    fun moveBottomRight() {
        val rc = Rect(0f, 5f, 34f, 76f)
        val pt = Point(23f, 78f)
        assertEquals(rc.movedBottomRight(pt.x, pt.y), rc.movedRight(pt.x).movedBottom(pt.y))
        assertEquals(rc.movedBottomRight(pt), rc.movedRight(pt.x).movedBottom(pt.y))
    }

    @Test
    fun moveBottomLeft() {
        val rc = Rect(0f, 5f, 34f, 76f)
        val pt = Point(23f, 78f)
        assertEquals(rc.movedBottomLeft(pt.x, pt.y), rc.movedLeft(pt.x).movedBottom(pt.y))
        assertEquals(rc.movedBottomLeft(pt), rc.movedLeft(pt.x).movedBottom(pt.y))
    }

    @Test
    fun intersects() {
        val rc = Rect(0f, 5f, 34f, 76f)
        assertTrue(rc.intersects(rc))
        assertTrue(rc.intersects(rc.movedRight(rc.left)))
        assertTrue(rc.intersects(rc.movedBottom(rc.top)))
        assertTrue(rc.intersects(rc.movedTop(rc.bottom)))
        assertTrue(rc.intersects(rc.movedLeft(rc.right)))
        assertFalse(rc.intersects(rc.movedRight(rc.left - 1f)))
        assertFalse(rc.intersects(rc.movedBottom(rc.top - 1f)))
        assertFalse(rc.intersects(rc.movedTop(rc.bottom + 1f)))
        assertFalse(rc.intersects(rc.movedLeft(rc.right + 1f)))
    }

    @Test
    fun intersected() {
        val rc = Rect(0f, 0f, 100f, 50f)
        assertEquals(rc.intersected(Rect(-10f, -5f, 60f, 45f)), Rect(0f, 0f, 50f, 40f))
        assertEquals(rc.intersected(Rect(90f, 40f, 60f, 45f)), Rect(90f, 40f, 10f, 10f))
        assertEquals(rc.intersected(Rect(-10f, -10f, 120f, 40f)), Rect(0f, 0f, 100f, 30f))
        assertEquals(rc.intersected(Rect(-10f, -10f, 120f, 80f)), Rect(0f, 0f, 100f, 50f))
        assertFalse(rc.intersected(Rect(-100f, -100f, 20f, 80f)).isValid())
    }

    @Test
    fun united() {
        val rc = Rect(0f, 0f, 100f, 50f)
        assertEquals(rc.united(Rect(-10f, -5f, 60f, 45f)), Rect(-10f, -5f, 110f, 55f))
        assertEquals(rc.united(Rect(90f, 40f, 60f, 45f)), Rect(0f, 0f, 150f, 85f))
        assertEquals(rc.united(Rect(-10f, -10f, 120f, 40f)), Rect(-10f, -10f, 120f, 60f))
        assertEquals(rc.united(Rect(-10f, -10f, 120f, 80f)), Rect(-10f, -10f, 120f, 80f))
        assertEquals(rc.united(Rect(10f, 10f, 80f, 20f)), Rect(0f, 0f, 100f, 50f))
        assertEquals(rc.united(Rect(-100f, -100f, 20f, 80f)), Rect(-100f, -100f, 200f, 150f))
    }
}