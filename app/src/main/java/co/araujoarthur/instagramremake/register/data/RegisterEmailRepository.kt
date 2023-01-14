package co.araujoarthur.instagramremake.register.data

class RegisterEmailRepository(private val datasource: RegisterEmailDatasource) {
    fun create(email: String, callback: RegisterEmailCallback) {
        datasource.create(email, callback)
    }
}