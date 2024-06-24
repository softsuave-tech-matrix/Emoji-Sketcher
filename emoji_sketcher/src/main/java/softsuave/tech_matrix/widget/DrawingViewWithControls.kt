package softsuave.tech_matrix.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.softsuave.emoji_sketcher.databinding.DrawingViewWithControlsBinding

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import softsuave.tech_matrix.model.Stroke

//checkDebugAarMetadata
class DrawingViewWithControls @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0, defStyleRes: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr, defStyleRes) 
{

    private val skipPubSub = PublishSubject.create<Any>()
    private var binding: DrawingViewWithControlsBinding? = null

    init {
        binding = DrawingViewWithControlsBinding.inflate(LayoutInflater.from(context), this, true)

        binding?.undoButton?.setOnClickListener { binding?.drawingArea?.undo() }
        binding?.clearButton?.setOnClickListener { binding?.drawingArea?.clear() }
        binding?.redoButton?.setOnClickListener { binding?.drawingArea?.redo() }

    }

    val strokesObservable: Observable<List<Stroke>>?
        get() = binding?.drawingArea?.strokesObservable

    val skipObservable: Observable<Any>
        get() = skipPubSub


    fun clear() {
        binding?.drawingArea?.clear()
    }

}