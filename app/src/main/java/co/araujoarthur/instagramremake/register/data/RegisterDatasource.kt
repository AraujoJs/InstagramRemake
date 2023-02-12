package co.araujoarthur.instagramremake.register.data

interface RegisterDatasource {
    fun create(email: String, callback: RegisterCallback)
    fun create(email: String, name: String, password: String, callback: RegisterCallback)
}