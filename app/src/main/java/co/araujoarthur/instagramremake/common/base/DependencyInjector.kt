package co.araujoarthur.instagramremake.common.base

import co.araujoarthur.instagramremake.login.data.LoginFakeDataBase
import co.araujoarthur.instagramremake.login.data.LoginRepository

object DependencyInjector {
    fun loginRepository(): LoginRepository {
        return LoginRepository(LoginFakeDataBase())
    }
}