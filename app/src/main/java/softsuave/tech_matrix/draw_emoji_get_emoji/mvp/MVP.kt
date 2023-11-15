package softsuave.tech_matrix.draw_emoji_get_emoji.mvp

interface MVP {

    interface View

    interface Presenter<V> {

        fun isViewBound(): Boolean

        fun bindView(view: V)

        fun unbindView()
    }
}
