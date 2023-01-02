package co.araujoarthur.instagramremake.register.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.araujoarthur.instagramremake.R
import co.araujoarthur.instagramremake.databinding.ActivityLoginBinding
import co.araujoarthur.instagramremake.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment = RegisterEmailFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.register_fragment, fragment)
            .commit()
    }
}