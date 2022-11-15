package co.araujoarthur.instagramremake.login.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ProgressBar
import co.araujoarthur.instagramremake.R

class LoadingButton: FrameLayout {

    private lateinit var button: Button
    private lateinit var progress: ProgressBar
    private var btnText: String? = null

    constructor(context: Context): super(context)
    constructor(context: Context, attrs: AttributeSet?): super(context, attrs) {
        setUp(context, attrs)
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int): super(context, attrs, defStyleAttr) {
        setUp(context, attrs)
    }

    fun showProgress(enabled: Boolean) {
        if(enabled) {
            button.text = ""
            progress.visibility = View.VISIBLE
            button.isEnabled = false
        } else {
            button.text = btnText
            progress.visibility = View.GONE
            button.isEnabled = true
        }
    }

    private fun setUp(context: Context, attrs: AttributeSet?) {
        val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.button_loading, this)
        button = getChildAt(0) as Button
        progress = getChildAt(1) as ProgressBar

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.LoadingButton, 0, 0)
        btnText = typedArray.getString(R.styleable.LoadingButton_ola)

        button.text = btnText
        button.isEnabled = false

        typedArray.recycle()

    }

    override fun setOnClickListener(l: OnClickListener?) {
        button.setOnClickListener(l)
    }

    override fun setEnabled(enabled: Boolean) {
        button.isEnabled = enabled
    }

}