package softsuave.tech_matrix.mvp

interface MVP {

    interface View

    interface Presenter<V> {

        fun isViewBound(): Boolean

        fun bindView(view: V)

        fun unbindView()
    }
}
