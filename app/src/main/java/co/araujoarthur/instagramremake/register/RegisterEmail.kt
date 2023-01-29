package co.araujoarthur.instagramremake.register

import androidx.annotation.StringRes
import co.araujoarthur.instagramremake.common.base.BasePresenter
import co.araujoarthur.instagramremake.common.base.BaseView

interface RegisterEmail {

    interface Presenter: BasePresenter {
        fun create(email: String)
    }

    interface View: BaseView<Presenter> {
        fun showProgress(enabled: Boolean)
        fun displayEmailFailure(@StringRes emailError: Int?)
        fun onEmailError(message: String)
        fun goToNameAndPasswordScreen(email: String)

    }
}