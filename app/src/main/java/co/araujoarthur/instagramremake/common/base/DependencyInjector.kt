package co.araujoarthur.instagramremake.common.base

import co.araujoarthur.instagramremake.login.data.LoginFakeDataBase
import co.araujoarthur.instagramremake.login.data.LoginRepository
import co.araujoarthur.instagramremake.register.RegisterEmail
import co.araujoarthur.instagramremake.register.RegisterNameAndPassword
import co.araujoarthur.instagramremake.register.data.FakeRegisterDatasource
import co.araujoarthur.instagramremake.register.data.RegisterRepository
import co.araujoarthur.instagramremake.register.presentation.RegisterEmailPresenter
import co.araujoarthur.instagramremake.register.presentation.RegisterNamePasswordPresenter

object DependencyInjector {
    fun loginRepository(): LoginRepository {
        return LoginRepository(LoginFakeDataBase())
    }

    private fun registerRepository(): RegisterRepository {
        return RegisterRepository(FakeRegisterDatasource())
    }

    fun registerEmailPresenter(view: RegisterEmail.View): RegisterEmailPresenter {
        return RegisterEmailPresenter(view, registerRepository())
    }

    fun registerNamePasswordPresenter(view: RegisterNameAndPassword.View): RegisterNamePasswordPresenter {
        return RegisterNamePasswordPresenter(view, registerRepository())
    }

}