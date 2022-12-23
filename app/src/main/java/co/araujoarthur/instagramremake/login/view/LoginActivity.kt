package co.araujoarthur.instagramremake.login.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import co.araujoarthur.instagramremake.R
import co.araujoarthur.instagramremake.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginEditEmail.addTextChangedListener(watcher)
        binding.loginEditPassword.addTextChangedListener(watcher)



        val button = binding.loginBtnEnter
        button.setOnClickListener {
            button.showProgress(true)
            Handler(Looper.getMainLooper()).postDelayed({
                button.showProgress(false)
                findViewById<TextInputLayout>(R.id.login_edit_email_input)
                    .error = "Digite um e-mail valido"
                findViewById<TextInputLayout>(R.id.login_edit_password_input)
                    .error = "Senha incorreta"
            }, 2000)
        }

    }

    private val watcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            binding.loginBtnEnter.isEnabled = s.toString().isNotEmpty()
        }

        override fun afterTextChanged(s: Editable?) {
        }

    }

}