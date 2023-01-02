package co.araujoarthur.instagramremake.login.data

import android.os.Handler
import android.os.Looper
import co.araujoarthur.instagramremake.common.model.Datasource

class LoginFakeDataBase: LoginDataBase {
    override fun login(email: String, password: String, callback: LoginCallback) {

        Handler(Looper.getMainLooper()).postDelayed({
            val userAuth = Datasource.userAuth.firstOrNull {
                email == it.email
            }
            when {
                userAuth == null -> {
                    callback.onFailure("Usuario não encontrado")
                }
                userAuth.password != password -> {
                    callback.onFailure("Senha está incorreta")
                }
                else -> {
                    Datasource.sessionAuth = userAuth
                    callback.onSuccess()
                }
            }
            callback.onComplete()


        },2000)

    }
}