package co.araujoarthur.instagramremake.common.base

import co.araujoarthur.instagramremake.login.data.LoginFakeDataBase
import co.araujoarthur.instagramremake.login.data.LoginRepository
import co.araujoarthur.instagramremake.register.RegisterEmail
import co.araujoarthur.instagramremake.register.data.FakeRegisterEmailDatasource
import co.araujoarthur.instagramremake.register.data.RegisterEmailRepository
import co.araujoarthur.instagramremake.register.presentation.RegisterEmailPresenter

object DependencyInjector {
    fun loginRepository(): LoginRepository {
        return LoginRepository(LoginFakeDataBase())
    }

    private fun registerEmailRepository(): RegisterEmailRepository {
        return RegisterEmailRepository(FakeRegisterEmailDatasource())
    }

    fun registerEmailPresenter(view: RegisterEmail.View?): RegisterEmailPresenter {
        return RegisterEmailPresenter(view, registerEmailRepository())
    }

}