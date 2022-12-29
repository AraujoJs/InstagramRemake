package co.araujoarthur.instagramremake.login.data

import android.os.Handler
import android.os.Looper

class LoginFakeDataBase: LoginDataBase {
    override fun login(email: String, password: String, callback: LoginCallback) {

        Handler(Looper.getMainLooper()).postDelayed({
            val validEmail = "a@a.com"
            val validPassword = "12345678"

            if (email == validEmail && password == validPassword) {
                callback.onSuccess()
            } else {
                callback.onFailure("Usuario não encontrado.")
            }
            callback.onComplete()
        },2000)

    }
}