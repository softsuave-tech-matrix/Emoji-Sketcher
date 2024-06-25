package softsuave.tech_matrix.mvp

import io.reactivex.disposables.CompositeDisposable


internal abstract class BasePresenter<V : MVP.View> : MVP.Presenter<V> {

    protected var view: V? = null

    protected val disposables = CompositeDisposable()

    override fun bindView(view: V) {
        this.view = view
        initialize()
    }

    protected open fun initialize() {}

    override fun unbindView() {
        view = null
        disposables.clear()

    }

    override fun isViewBound(): Boolean {
        return view != null
    }
}
