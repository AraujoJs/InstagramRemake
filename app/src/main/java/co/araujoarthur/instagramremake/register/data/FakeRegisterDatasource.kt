package co.araujoarthur.instagramremake.register.data

import android.os.Handler
import android.os.Looper
import co.araujoarthur.instagramremake.common.model.Datasource
import co.araujoarthur.instagramremake.common.model.UserAuth
import java.util.*

class FakeRegisterDatasource: RegisterDatasource {
    override fun create(email: String, callback: RegisterCallback) {

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

    override fun create(email: String, name: String, password: String, callback: RegisterCallback) {
        Handler(Looper.getMainLooper()).postDelayed({
            val userAuth = Datasource.userAuth.firstOrNull { email == it.email }
            if (userAuth != null) {
                callback.onFailure("Usuario já cadastrado.")
            } else {
                val created = Datasource.userAuth.add(
                    UserAuth(
                        UUID.randomUUID().toString(),
                        email,
                        name,
                        password
                    )
                )
                if (created) {
                    callback.onSuccess()
                } else {
                    callback.onFailure("Erro interno do servidor")
                }
            }
            callback.onComplete()
        }, 1000)
    }
}