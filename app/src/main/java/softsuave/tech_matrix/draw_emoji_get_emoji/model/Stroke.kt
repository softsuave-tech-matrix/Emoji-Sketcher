package softsuave.tech_matrix.draw_emoji_get_emoji.model

class Stroke {

    val xcoords = mutableListOf<Int>()
    val ycoords = mutableListOf<Int>()

    fun addPoint(x: Int, y: Int) {
        xcoords.add(x)
        ycoords.add(y)
    }
}