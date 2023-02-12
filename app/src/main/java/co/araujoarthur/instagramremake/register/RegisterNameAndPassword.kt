package co.araujoarthur.instagramremake.register

import androidx.annotation.StringRes
import co.araujoarthur.instagramremake.common.base.BasePresenter
import co.araujoarthur.instagramremake.common.base.BaseView

interface RegisterNameAndPassword {
    interface Presenter: BasePresenter {
        fun create(email: String, name: String, password: String, confirm: String)
    }
    interface View: BaseView<Presenter> {
        fun showProgress(enabled: Boolean)
        fun displayNameFailure(@StringRes nameError: Int?)
        fun displayPasswordFailure(@StringRes passError: Int?)
        fun onCreateSuccess(name: String)
        fun onCreateFailure(message: String)

    }
}