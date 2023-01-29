package co.araujoarthur.instagramremake.register.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import co.araujoarthur.instagramremake.R
import co.araujoarthur.instagramremake.common.base.DependencyInjector
import co.araujoarthur.instagramremake.common.util.TextWatcher
import co.araujoarthur.instagramremake.databinding.FragmentRegisterEmailBinding
import co.araujoarthur.instagramremake.register.RegisterEmail

class RegisterEmailFragment: Fragment(R.layout.fragment_register_email), RegisterEmail.View {
    override lateinit var presenter: RegisterEmail.Presenter
    private var binding: FragmentRegisterEmailBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = DependencyInjector.registerEmailPresenter(this)

        binding = FragmentRegisterEmailBinding.bind(view)
        binding?.let {
            with(it) {
                registerEditEmail.addTextChangedListener(textWatcher)
                registerTxtRegister.setOnClickListener {
                    activity?.finish()
                }
                registerBtnEnter.setOnClickListener {
                    presenter.create(registerEditEmail.text.toString())
                }
            }
        }
    }

    private val textWatcher = TextWatcher {
        binding?.registerBtnEnter?.isEnabled = it.isNotEmpty()
        binding?.registerEditEmailInput?.error = ""
    }

    override fun showProgress(enabled: Boolean) {
        binding?.registerBtnEnter?.showProgress(enabled)
    }

    override fun displayEmailFailure(emailError: Int?) {
        binding?.registerEditEmailInput?.error = emailError?.let { getString(it) }
    }

    override fun onEmailError(message: String) {
        binding?.registerEditEmailInput?.error = message
    }

    override fun goToNameAndPasswordScreen(email: String) {
    }

    override fun onDestroy() {
        presenter.onDestroy()
        binding = null
        super.onDestroy()
    }
}
