package co.araujoarthur.instagramremake.login.presentation

import android.util.Patterns
import co.araujoarthur.instagramremake.R
import co.araujoarthur.instagramremake.login.Login
import co.araujoarthur.instagramremake.login.data.LoginCallback
import co.araujoarthur.instagramremake.login.data.LoginRepository

class LoginPresenter(
    private var view: Login.View? = null,
    private val repository: LoginRepository
): Login.Presenter {

    override fun login(email: String, password: String) {
        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val isPasswordValid = password.length >= 8

        if (!isEmailValid) {
            view?.displayEmailFailure(R.string.invalid_email)
        } else {
            view?.displayEmailFailure(null)
        }
        if (!isPasswordValid) {
            view?.displayPasswordFailure(R.string.invalid_password)
        } else {
            view?.displayPasswordFailure(null)
        }
        if (isEmailValid && isPasswordValid) {
            view?.showProgress(true)
            repository.login(email, password, object : LoginCallback {
                override fun onSuccess() {
                    view?.onUserAuthenticated()
                }

                override fun onFailure(message: String) {
                    view?.onUserUnAuthorized(message)
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