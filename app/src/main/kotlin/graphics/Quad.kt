package graphics

data class Quad(val topLeft: Point, val topRight: Point, val bottomRight: Point, val bottomLeft: Point) {
    constructor(rc: Rect): this(rc.topLeft, rc.topRight, rc.bottomRight, rc.bottomLeft)
}