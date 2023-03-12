package co.araujoarthur.instagramremake.register.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.araujoarthur.instagramremake.R
import co.araujoarthur.instagramremake.databinding.FragmentRegisterWelcomeBinding

class RegisterWelcomeFragment: Fragment(R.layout.fragment_register_welcome){

    private var binding: FragmentRegisterWelcomeBinding? = null
    private var attachListener: FragmentAttachListener? = null

    override fun onAttach(context: Context) {
        if (context is FragmentAttachListener) {
            attachListener = context
        }
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterWelcomeBinding.bind(view)

        val name = arguments?.getString(KEY_NAME) ?: throw IllegalArgumentException("Name not found")

        binding?.let {
            with(it) {
                registerTxtWelcome.text = getString(R.string.welcome_to_instagram, name)
                registerBtnEnter.isEnabled = true
                registerBtnEnter.setOnClickListener {
                    attachListener?.goToPhotoScreen()
                }
            }
        }

    }

    companion object {
        const val KEY_NAME = "key_name"
    }
}