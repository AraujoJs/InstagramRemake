package co.araujoarthur.instagramremake.register.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import co.araujoarthur.instagramremake.R
import co.araujoarthur.instagramremake.databinding.FragmentRegisterNamePasswordBinding

class RegisterNamePassWordFragment: Fragment(R.layout.fragment_register_name_password) {
    private var binding: FragmentRegisterNamePasswordBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterNamePasswordBinding.bind(view)
        val email = arguments?.getString(KEY_EMAIL)
        Log.i("Teste", email.toString())
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object {
        const val KEY_EMAIL = "e-mail"
    }

}