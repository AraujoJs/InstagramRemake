package co.araujoarthur.instagramremake.register.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.araujoarthur.instagramremake.R
import co.araujoarthur.instagramremake.common.base.DependencyInjector
import co.araujoarthur.instagramremake.common.util.TextWatcher
import co.araujoarthur.instagramremake.databinding.FragmentRegisterEmailBinding
import co.araujoarthur.instagramremake.databinding.FragmentRegisterNamePasswordBinding
import co.araujoarthur.instagramremake.register.RegisterEmail

class RegisterNamePassWordFragment: Fragment(R.layout.fragment_register_name_password) {
    private var binding: FragmentRegisterNamePasswordBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRegisterNamePasswordBinding.bind(view)
        val email = arguments?.getString(KEY_EMAIL)
        Log.i("Teste", email.toString())

    }



    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    companion object {
        const val KEY_EMAIL = "e-mail"
    }
}