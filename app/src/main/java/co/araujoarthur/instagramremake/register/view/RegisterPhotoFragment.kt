package co.araujoarthur.instagramremake.register.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.araujoarthur.instagramremake.R
import co.araujoarthur.instagramremake.common.view.CustomDialog
import co.araujoarthur.instagramremake.databinding.FragmentRegisterPhotoBinding

class RegisterPhotoFragment : Fragment(R.layout.fragment_register_photo) {

    private var binding: FragmentRegisterPhotoBinding? = null

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRegisterPhotoBinding.bind(view)

        val customDialog = CustomDialog(requireContext())

        customDialog.addButton(R.string.gallery, R.string.photo) {
            when (it.id) {
                R.string.gallery -> {
                    // TODO: Open gallery
                    Log.i("Test", "Open gallery")
                }

                R.string.photo -> {
                    // TODO: Open Camera
                    Log.i("Test", "Open camera")
                }
            }
        }
        customDialog.show()
    }

}