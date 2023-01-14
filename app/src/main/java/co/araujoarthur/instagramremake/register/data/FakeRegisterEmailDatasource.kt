package co.araujoarthur.instagramremake.register.data

import android.os.Handler
import android.os.Looper
import co.araujoarthur.instagramremake.common.model.Datasource

class FakeRegisterEmailDatasource: RegisterEmailDatasource {
    override fun create(email: String, callback: RegisterEmailCallback) {
        Handler(Looper.getMainLooper()).postDelayed({
            val userAuth = Datasource.userAuth.firstOrNull { email == it.email }
            if (userAuth != null) {
                callback.onFailure("Usuario já cadastrado")
            } else {
                callback.onSuccess()
            }
            callback.onComplete()
        }, 2000)
    }

}