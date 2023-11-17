package softsuave.tech_matrix.draw_emoji_get_emoji.util

import android.content.Context
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.StringRes

object CenteredToast {

    fun show(context: Context, @StringRes message: Int, duration: Int) {
        val toast = Toast.makeText(context, message, duration)
        val layout = toast.view as LinearLayout
        (layout.getChildAt(0) as TextView?)?.apply {
            gravity = Gravity.CENTER_HORIZONTAL
        }
        toast.show()
    }
}
