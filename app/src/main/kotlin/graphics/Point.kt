package graphics

data class Point(val x: Float = 0f, val y: Float = 0f) {
    fun isNull()
            = (x == 0f) && (y == 0f)

    operator fun times(k: Number)
            = Point(x*k.toFloat(), y*k.toFloat())

    operator fun minus(p: Point)
            = Point(x-p.x, y-p.y)

    operator fun plus(p: Point)
            = Point(x+p.x, y+p.y)

    operator fun unaryMinus()
            = Point(-x, -y)

    operator fun div(k: Number)
            = Point(x/k.toFloat(), y/k.toFloat())
}

operator fun Number.times(p: Point)
        = p*toFloat()