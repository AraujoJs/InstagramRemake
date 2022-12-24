package co.araujoarthur.instagramremake.login

import co.araujoarthur.instagramremake.common.base.BasePresenter
import co.araujoarthur.instagramremake.common.base.BaseView

interface Login {

    interface Presenter: BasePresenter {
        fun login(email: String, password: String)
    }

    interface View: BaseView<Presenter> {
        fun showProgress(enabled: Boolean)
        fun displayEmailFailure(emailError: Int?)
        fun displayPasswordFailure(passwordError: Int?)
        fun onUserAuthenticated()
        fun onUserUnAuthorized()
    }
}