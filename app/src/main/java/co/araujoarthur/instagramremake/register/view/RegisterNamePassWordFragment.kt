package co.araujoarthur.instagramremake.register.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import co.araujoarthur.instagramremake.R
import co.araujoarthur.instagramremake.common.base.DependencyInjector
import co.araujoarthur.instagramremake.common.util.TextWatcher
import co.araujoarthur.instagramremake.databinding.FragmentRegisterNamePasswordBinding
import co.araujoarthur.instagramremake.register.RegisterNameAndPassword

class RegisterNamePassWordFragment: Fragment(R.layout.fragment_register_name_password)
    , RegisterNameAndPassword.View {

    override lateinit var presenter: RegisterNameAndPassword.Presenter
    private var binding: FragmentRegisterNamePasswordBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = DependencyInjector.registerNamePasswordPresenter(this)
        binding = FragmentRegisterNamePasswordBinding.bind(view)
        val email = arguments?.getString(KEY_EMAIL) ?: throw IllegalArgumentException("Email not found")

        binding?.let {
            with(it) {
                registerNameEditName.addTextChangedListener(watcher)
                registerPasswordEditPassword.addTextChangedListener(watcher)
                registerConfirmPasswordEditConfirm.addTextChangedListener(watcher)

                registerTxtRegister.setOnClickListener {
                    activity?.finish()
                }

                registerNameBtnEnter.setOnClickListener {
                    presenter.create(
                        email,
                        registerNameEditName.text.toString(),
                        registerPasswordEditPassword.text.toString(),
                        registerConfirmPasswordEditConfirm.text.toString()
                    )
                }
            }
        }

    }

    private val watcher = TextWatcher {
        binding?.registerNameBtnEnter?.isEnabled = binding?.registerNameEditName?.text.toString().isNotEmpty()
                && binding?.registerPasswordEditPassword?.text.toString().isNotEmpty()
                && binding?.registerConfirmPasswordEditConfirm?.text.toString().isNotEmpty()
    }

    override fun showProgress(enabled: Boolean) {
        binding?.registerNameBtnEnter?.showProgress(enabled)
    }

    override fun displayNameFailure(nameError: Int?) {
        binding?.registerNameEditNameInput?.error = nameError?.let { getString(it) }
    }

    override fun displayPasswordFailure(passError: Int?) {
        binding?.registerPasswordEditPasswordInput?.error = passError?.let { getString(it) }
    }

    override fun onCreateSuccess(name: String) {
        // TODO: Go to welcome screen
    }

    override fun onCreateFailure(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object {
        const val KEY_EMAIL = "e-mail"
    }

}