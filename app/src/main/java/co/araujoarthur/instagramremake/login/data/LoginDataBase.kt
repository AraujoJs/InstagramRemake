package co.araujoarthur.instagramremake.login.data

interface LoginDataBase {
    fun login(email: String, password: String, callback: LoginCallback)
}