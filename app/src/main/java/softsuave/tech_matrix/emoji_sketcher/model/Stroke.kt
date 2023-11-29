package softsuave.tech_matrix.emoji_sketcher.model

class Stroke {

    val xcoords = mutableListOf<Int>()
    val ycoords = mutableListOf<Int>()

    fun addPoint(x: Int, y: Int) {
        xcoords.add(x)
        ycoords.add(y)
    }
}