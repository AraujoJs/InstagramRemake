package co.araujoarthur.instagramremake.register.view

interface FragmentAttachListener {
    fun goToNameAndPasswordScreen(email: String)
    fun goToWelcomeScreen(name: String)
    fun goToPhotoScreen()
    fun goToMainScreen()
    fun goToGalleryScreen()
}