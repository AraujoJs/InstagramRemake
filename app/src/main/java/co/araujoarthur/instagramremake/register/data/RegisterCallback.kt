package co.araujoarthur.instagramremake.register.data

interface RegisterCallback {
    fun onSuccess()
    fun onFailure(message: String)
    fun onComplete()
}