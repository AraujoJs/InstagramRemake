package co.araujoarthur.instagramremake.register.data

import android.os.Handler
import android.os.Looper
import co.araujoarthur.instagramremake.common.model.Datasource

class FakeRegisterEmailDatasource: RegisterEmailDatasource {
    override fun login(email: String, callback: RegisterEmailCallback) {

        Handler(Looper.getMainLooper()).postDelayed({
            val userAuth = Datasource.userAuth.firstOrNull { email == it.email }
            if (userAuth != null) {
                callback.onFailure("Usuario já existe.")
            } else {
                callback.onSuccess()
            }
            callback.onComplete()
        }, 2000)
    }

}