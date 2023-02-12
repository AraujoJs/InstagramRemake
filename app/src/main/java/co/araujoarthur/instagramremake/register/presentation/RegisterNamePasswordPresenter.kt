package co.araujoarthur.instagramremake.register.presentation

import co.araujoarthur.instagramremake.R
import co.araujoarthur.instagramremake.register.RegisterNameAndPassword
import co.araujoarthur.instagramremake.register.data.RegisterCallback
import co.araujoarthur.instagramremake.register.data.RegisterRepository

class RegisterNamePasswordPresenter(
    private var view: RegisterNameAndPassword.View?,
    private val repository: RegisterRepository
    ): RegisterNameAndPassword.Presenter {

    override fun create(email: String, name: String, password: String, confirm: String) {
        val isNameValid = name.length > 3
        val isPasswordValid = password.length >= 8
        val isConfirmValid = password == confirm

        if (!isNameValid) {
            view?.displayNameFailure(R.string.invalid_name)
        } else {
            view?.displayNameFailure(null)
        }

        if (!isPasswordValid) {
            view?.displayPasswordFailure(R.string.invalid_password)
        } else {
            if (!isConfirmValid) {
                view?.displayPasswordFailure(R.string.password_not_equal)
            } else {
                view?.displayPasswordFailure(null)
            }
        }

        if (isNameValid && isPasswordValid && isConfirmValid) {
            view?.showProgress(true)
            repository.create(email, name, password, object : RegisterCallback {
                override fun onSuccess() {
                    view?.onCreateSuccess(name)
                }

                override fun onFailure(message: String) {
                    view?.onCreateFailure(message)
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