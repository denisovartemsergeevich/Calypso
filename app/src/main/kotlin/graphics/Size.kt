package graphics

data class Size(val width: Float = 0f, val height: Float = 0f) {
    fun isNull()
            = (width == 0f) && (height == 0f)

    fun isEmpty()
            = (width <= 0) || (height <=0)

    fun transposed()
            = Size(height, width)

    operator fun minus(s: Size)
            = Size(width - s.width, height - s.height)

    operator fun plus(s: Size)
            = Size(width + s.width, height + s.height)

    operator fun times(k: Number)
            = Size(width*k.toFloat(), height*k.toFloat())

    fun scaledByExpanding(s: Size): Size {
        if (equals(s)) return Size(width, height)
        if (isNull()) return Size(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
        if ((height == 0f) && (s.height == 0f)) return s

        val aspect1 = width / height
        val aspect2 = s.width / s.height
        return if (aspect1 < aspect2)
            Size(s.width, s.width / aspect1)
        else
            Size(s.height * aspect1, s.height)
    }

    fun scaledByReducing(s: Size): Size {
        if ((width == 0f) && (height == 0f)) return Size()
        if (width == 0f) return Size(0f, s.height)
        if (height == 0f) return Size(s.width, 0f)
        if ((s.width == 0f) || (s.height == 0f)) return Size()

        val aspect1 = width / height
        val aspect2 = s.width / s.height
        return if (aspect1 > aspect2)
            Size(s.width, s.width / aspect1)
        else
            Size(s.height * aspect1, s.height)
    }
}

operator fun Number.times(s: Size)
        = s*toFloat()