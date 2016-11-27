package graphics

data class Rect(val x: Float, val y: Float, val width: Float, val height: Float) {
    val topLeft: Point
        get() = Point(x, y)

    val topRight: Point
        get() = Point(x + width, y)

    val bottomRight: Point
        get() = Point(x + width, y + height)

    val bottomLeft: Point
        get() = Point(x, y + height)

    val size: Size
        get() = Size(width, height)

    val center: Point
        get() = Point(x + width / 2f, y + height / 2f)

    val left: Float
        get() = x

    val top: Float
        get() = y

    val right: Float
        get() = x + width

    val bottom: Float
        get() = y + height

    constructor() : this(0f, 0f, 0f, 0f)

    constructor(topLeft: Point, size: Size):
            this(topLeft.x, topLeft.y, size.width, size.height)

    constructor(topLeft: Point, bottomRight: Point):
            this(topLeft.x, topLeft.y, bottomRight.x - topLeft.x, bottomRight.y - topLeft.y)

    fun adjusted(dx1: Float, dy1: Float, dx2: Float, dy2: Float)
            = Rect(x + dx1, y + dy1, width + dx2 - dx1, height + dy2 - dy1)

    fun isNull()
            = (width == 0f) && (height == 0f)

    fun isEmpty()
            = (width <= 0f) || (height <= 0f)

    fun isValid()
            = !isEmpty()

    fun contains(x: Float, y: Float)
            = (x >= left) && (y >= top)  && (x <= right) && (x <= bottom)

    fun contains(p:Point)
            = contains(p.x, p.y)

    fun contains(rc:Rect)
            = contains(rc.topLeft) && contains(rc.bottomLeft)

    fun movedCenter(x: Float, y: Float)
            = Rect(x - width / 2f, y - height / 2f, width, height)

    fun movedCenter(pt: Point)
            = movedCenter(pt.x, pt.y)

    fun movedLeft(x: Float)
            = Rect(x, y, width, height)

    fun movedTop(y: Float)
            = Rect(x, y, width, height)

    fun movedRight(x: Float)
            = Rect(x - width, y, width, height)

    fun movedBottom(y: Float)
            = Rect(x, y - height, width, height)

    fun movedTopLeft(x: Float, y: Float)
            = Rect(x, y, width, height)

    fun movedTopLeft(pt: Point)
            = movedTopLeft(pt.x, pt.y)

    fun movedTopRight(x: Float, y: Float)
            = Rect(x - width, y, width, height)

    fun movedTopRight(pt: Point)
            = movedTopRight(pt.x, pt.y)

    fun movedBottomRight(x: Float, y: Float)
            = Rect(x - width, y - height, width, height)

    fun movedBottomRight(pt: Point)
            = movedBottomRight(pt.x, pt.y)

    fun movedBottomLeft(x: Float, y: Float)
            = Rect(x, y - height, width, height)

    fun movedBottomLeft(pt: Point)
            = movedBottomLeft(pt.x, pt.y)

    fun intersects(rc: Rect)
            = (rc.bottom >= top) && (rc.right >= left) && (rc.top <= bottom) && (rc.left <= right)

    fun intersected(rc: Rect): Rect {
        val l = Math.max(rc.left, left)
        val t = Math.max(rc.top, top)
        val r = Math.min(rc.right, right)
        val b = Math.min(rc.bottom, bottom)
        return Rect(l, t, r - l, b - t)
    }

    fun united(rc: Rect): Rect {
        val l = Math.min(rc.left, left)
        val t = Math.min(rc.top, top)
        val r = Math.max(rc.right, right)
        val b = Math.max(rc.bottom, bottom)
        return Rect(l, t, r - l, b - t)
    }
}