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
        dialogCustom.setTitle(R.string.define_photo_profile)
        dialogCustom.addButton(R.string.photo, R.string.gallery) {
            when (it.id) {
                R.string.photo -> {
                    Log.i("Test", "photo")
                    //TODO: Abrir camera
                }
                R.string.gallery -> {
                    Log.i("test", "gallery")
                    //TODO: abrir galeria
                }
            }



            dialogCustom.dismiss()
        }

        dialogCustom.show()

    }
}