package softsuave.tech_matrix.emoji_sketcher.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import softsuave.tech_matrix.emoji_sketcher.R
import softsuave.tech_matrix.emoji_sketcher.model.Stroke

class DrawingView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0, defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {

    private val paint: Paint
    private var currentPath: Path = Path()
    private val paths: MutableList<Path> = mutableListOf()
    private var redoPath: MutableList<Path> = mutableListOf()
    private lateinit var drawingCanvas: Canvas
    private lateinit var drawingBitmap: Bitmap

    private val strokes: MutableList<Stroke> = mutableListOf()
    private var redoStroke: MutableList<Stroke> = mutableListOf()
    private var currentStroke: Stroke = Stroke()

    private val pubsub = PublishSubject.create<List<Stroke>>()

    @ColorInt
    private val bgColor: Int

    @ColorInt
    private val paintColor: Int

    private val strokeWidth: Float


    init {
        val typedArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.DrawingView,
            0, 0
        )

        bgColor = typedArray.getColor(
            R.styleable.DrawingView_dv_backgroundColor,
            ContextCompat.getColor(context, android.R.color.white)
        )
        paintColor = typedArray.getColor(
            R.styleable.DrawingView_dv_paintColor,
            ContextCompat.getColor(context, android.R.color.black)
        )
        strokeWidth = typedArray.getFloat(R.styleable.DrawingView_dv_strokeWidth, 10f)

        typedArray.recycle()

        paint = Paint().apply {
            isAntiAlias = true
            isDither = true
            color = paintColor
            style = Paint.Style.STROKE
            strokeJoin = Paint.Join.ROUND
            strokeCap = Paint.Cap.ROUND
            strokeWidth = this@DrawingView.strokeWidth
        }
    }

    val strokesObservable: Observable<List<Stroke>>
        get() = pubsub


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        drawingBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
        drawingCanvas = Canvas(drawingBitmap)
        clearDrawingCanvas()
    }


    override fun onDraw(canvas: Canvas) {
        (paths + currentPath).map {
            drawingCanvas.drawPath(it, paint)
        }

        canvas.drawBitmap(drawingBitmap, 0f, 0f, paint)
    }


    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                currentPath.moveTo(event.x - 1, event.y - 1)
                currentPath.lineTo(event.x + 1, event.y + 1)
                currentStroke.addPoint(event.x.toInt(), event.y.toInt())
            }

            MotionEvent.ACTION_MOVE -> {
                currentPath.lineTo(event.x, event.y)
                currentStroke.addPoint(event.x.toInt(), event.y.toInt())
                invalidate()
            }

            MotionEvent.ACTION_UP -> {
                paths.add(currentPath)
                strokes.add(currentStroke)
                currentPath = Path()
                currentStroke = Stroke()
                invalidate()
                onStrokeAdded()
            }
        }

        return true
    }

    private fun onStrokeAdded() {
        pubsub.onNext(strokes)
    }

    fun clear() {
        paths.clear()
        strokes.clear()
        redoPath.clear()
        redoStroke.clear()
        pubsub.onNext(strokes)
        clearDrawingCanvas()
        invalidate()
    }

    fun undo() {
        if (paths.isNotEmpty()) {
            clearDrawingCanvas()
            val redoPathItem = paths.removeAt(paths.size - 1)
            val redoStrokeItem = strokes.removeAt(strokes.size - 1)
            redoPath.add(redoPathItem)
            redoStroke.add(redoStrokeItem)
            pubsub.onNext(strokes)
            invalidate()
        }
    }

    fun redo() {
        if (redoPath.isNotEmpty()) {
            val redoStrokeItem = redoStroke.last()
            val redoPathItem = redoPath.last()
            redoStroke.removeLast()
            redoPath.removeLast()
            strokes.add(redoStrokeItem)
            paths.add(redoPathItem)

            pubsub.onNext(strokes)
            invalidate()
        }
    }

    private fun clearDrawingCanvas() {
        drawingCanvas.drawColor(bgColor)
    }

}