package co.araujoarthur.instagramremake.register.data

class RegisterEmailRepository(private val datasource: RegisterEmailDatasource) {
    fun login(email: String, callback: RegisterEmailCallback) {
        datasource.login(email, callback)
    }
}