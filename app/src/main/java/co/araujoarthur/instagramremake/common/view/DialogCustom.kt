package co.araujoarthur.instagramremake.common.view

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import co.araujoarthur.instagramremake.R

class DialogCustom(context: Context): Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_custom)
    }


}