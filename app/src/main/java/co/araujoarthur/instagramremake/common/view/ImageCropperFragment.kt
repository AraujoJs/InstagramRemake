package co.araujoarthur.instagramremake.common.view

import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import co.araujoarthur.instagramremake.R
import co.araujoarthur.instagramremake.databinding.FragmentImageCropperBinding
import java.io.File

class ImageCropperFragment: Fragment(R.layout.fragment_image_cropper) {
    private var binding: FragmentImageCropperBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentImageCropperBinding.bind(view)
         val uri = arguments?.getParcelable<Uri>(KEY_URI)
        binding?.let {
            with(it) {
                cropperContainer.setImageUriAsync(uri)
                cropperContainer.setAspectRatio(1, 1)
                cropperContainer.setFixedAspectRatio(true)
                cropperBtnCancel.setOnClickListener {
                    parentFragmentManager.popBackStack()
                }
                cropperBtnSave.setOnClickListener {
                    val dir = context?.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
                    if (dir != null) {
                        val uriSaved = Uri.fromFile(File(dir.path, System.currentTimeMillis().toString() + ".jpeg"))
                        cropperContainer.saveCroppedImageAsync(uriSaved)
                    }
                }

                cropperContainer.setOnCropImageCompleteListener { view, result ->
                    setFragmentResult("cropkey", bundleOf(KEY_URI to result.uri))
                    parentFragmentManager.popBackStack()
                }
            }
        }
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    companion object {
        const val KEY_URI = "key_uri"
    }
}