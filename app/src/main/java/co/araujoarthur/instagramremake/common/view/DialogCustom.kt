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
    private lateinit var dialogLayouts: Array<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_custom)
        linearLayout = findViewById(R.id.dialog_container)
    }

    fun addButton(vararg texts: Int, l: View.OnClickListener) {

        dialogLayouts = Array(texts.size) {
            TextView(context)
        }

        dialogLayouts.forEachIndexed { index, textView ->
            dialogLayouts[index].setText(texts[index])
            dialogLayouts[index].setOnClickListener(l)
        }
    }

    override fun show() {
        super.show()
        for (layout in dialogLayouts) {
            linearLayout.addView(layout)
        }
    }
}