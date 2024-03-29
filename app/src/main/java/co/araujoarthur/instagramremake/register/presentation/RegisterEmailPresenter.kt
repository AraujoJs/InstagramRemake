package co.araujoarthur.instagramremake.register.presentation

import android.util.Patterns
import co.araujoarthur.instagramremake.R
import co.araujoarthur.instagramremake.register.RegisterEmail
import co.araujoarthur.instagramremake.register.data.RegisterCallback
import co.araujoarthur.instagramremake.register.data.RegisterRepository

class RegisterEmailPresenter(
    private var view: RegisterEmail.View? = null,
    private val repository: RegisterRepository
): RegisterEmail.Presenter {
    override fun create(email: String) {
        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()
        if (!isEmailValid) {
            view?.displayEmailFailure(R.string.invalid_email)
        } else {
            view?.showProgress(true)
            repository.create(email, object : RegisterCallback {
                override fun onSuccess() {
                    view?.goToNameAndPasswordScreen(email)
                }

                override fun onFailure(message: String) {
                    view?.onEmailError(message)
                }

                override fun onComplete() {
                    view?.showProgress(false)
                }

            })
        }
    }

    override fun onDestroy() {
        view = null
    }

}