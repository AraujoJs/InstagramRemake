package co.araujoarthur.instagramremake.register.data

interface RegisterEmailDatasource {
    fun create(email: String, callback: RegisterEmailCallback)
}