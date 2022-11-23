package co.araujoarthur.instagramremake.common.view

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import co.araujoarthur.instagramremake.R
import org.w3c.dom.Text

class DialogCustom(context: Context): Dialog(context) {

    private lateinit var linearLayout: LinearLayout
    private lateinit var textViews: Array<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_custom)
        linearLayout = findViewById(R.id.dialog_container)
    }

    fun addButton(vararg texts: Int, l: View.OnClickListener) {

        textViews = Array(texts.size) {
            TextView(context)
        }

        textViews.forEachIndexed { index, textView ->
            textViews[index].setText(texts[index])
            textViews[index].setOnClickListener(l)
        }
    }

    override fun show() {
        super.show()
        textViews.forEachIndexed { index, textView ->
            linearLayout.addView(textView)
        }
    }
}