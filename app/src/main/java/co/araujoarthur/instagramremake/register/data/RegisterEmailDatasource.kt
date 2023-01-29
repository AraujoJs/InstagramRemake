package co.araujoarthur.instagramremake.register.data

interface RegisterEmailDatasource {
    fun login(email: String, callback: RegisterEmailCallback)
}