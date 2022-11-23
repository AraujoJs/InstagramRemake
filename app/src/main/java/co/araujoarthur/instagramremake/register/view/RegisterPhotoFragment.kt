package co.araujoarthur.instagramremake.register.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import co.araujoarthur.instagramremake.R
import co.araujoarthur.instagramremake.common.view.DialogCustom

class RegisterPhotoFragment: Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dialogCustom = DialogCustom(requireContext())
        dialogCustom.addButton(R.string.photo, R.string.gallery) {
            Log.i("Test", (it as TextView).text.toString())
            dialogCustom.dismiss()
        }

        dialogCustom.show()

    }
}