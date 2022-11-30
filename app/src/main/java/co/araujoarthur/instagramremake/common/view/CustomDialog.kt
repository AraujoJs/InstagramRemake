package co.araujoarthur.instagramremake.common.view

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import co.araujoarthur.instagramremake.R

class CustomDialog(context: Context): Dialog(context) {

    private lateinit var dialogLinearLayout: LinearLayout
    private lateinit var textViews: Array<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_custom)
        dialogLinearLayout = findViewById(R.id.dialog_container)
    }

    fun addButton(vararg texts: Int, listenner: View.OnClickListener) {
        textViews = Array(texts.size) {
            TextView(context)
        }

        texts.forEachIndexed { index, textId ->
            textViews[index].id = textId
            textViews[index].setText(textId)
            textViews[index].setOnClickListener {
                listenner.onClick(it)
                dismiss()
            }
        }
    }

    override fun show() {
        super.show()
        for (textView in textViews) {
            val layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            layoutParams.setMargins(30, 50, 30, 50)
            dialogLinearLayout.addView(textView, layoutParams)
        }
    }

}