package co.araujoarthur.instagramremake.register.data

interface RegisterEmailCallback {
    fun onSuccess()
    fun onFailure(message: String)
    fun onComplete()
}