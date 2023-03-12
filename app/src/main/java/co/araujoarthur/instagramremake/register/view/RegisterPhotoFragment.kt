package co.araujoarthur.instagramremake.register.view

import android.content.Context
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import co.araujoarthur.instagramremake.R
import co.araujoarthur.instagramremake.common.view.CustomDialog
import co.araujoarthur.instagramremake.common.view.ImageCropperFragment.Companion.KEY_URI
import co.araujoarthur.instagramremake.databinding.FragmentRegisterPhotoBinding

class RegisterPhotoFragment : Fragment(R.layout.fragment_register_photo) {

    private var binding: FragmentRegisterPhotoBinding? = null
    private var attachListener: FragmentAttachListener? = null
    override fun onDestroy() {
        binding = null
        attachListener = null
        super.onDestroy()
    }

    override fun onAttach(context: Context) {
        if (context is FragmentAttachListener) {
            attachListener = context
        }
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener("cropkey") { requestKey, bundle ->
            val uri = bundle.getParcelable<Uri>(KEY_URI)
            onCropImageView(uri)
        }
    }

    private fun onCropImageView(uri: Uri?) {
        if (uri != null) {
            val bitmap = if (Build.VERSION.SDK_INT >= 28) {
                val source = ImageDecoder.createSource(requireContext().contentResolver, uri)
                ImageDecoder.decodeBitmap(source)
            } else {
                MediaStore.Images.Media.getBitmap(requireContext().contentResolver, uri)
            }
            binding?.registerImgLogo?.setImageBitmap(bitmap)
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRegisterPhotoBinding.bind(view)

        binding?.let {
            with(it) {
                registerBtnEnter.isEnabled = true
                registerBtnEnter.setOnClickListener {
                    onCustomDialog()
                }

                registerBtnNext.setOnClickListener {
                    attachListener?.goToMainScreen()
                }
            }
        }

    }

    private fun onCustomDialog() {
        val customDialog = CustomDialog(requireContext())
        customDialog.addButton(R.string.gallery, R.string.photo) {
            when (it.id) {
                R.string.gallery -> {
                    attachListener?.goToGalleryScreen()
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