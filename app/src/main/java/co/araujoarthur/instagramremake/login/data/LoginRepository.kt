package co.araujoarthur.instagramremake.login.data

class LoginRepository(private val database: LoginDataBase) {
    fun login(email: String, password: String, callback: LoginCallback) {
        database.login(email, password, callback)
    }

}