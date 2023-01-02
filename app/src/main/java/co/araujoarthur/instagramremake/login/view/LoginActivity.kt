package co.araujoarthur.instagramremake.login.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import co.araujoarthur.instagramremake.R
import co.araujoarthur.instagramremake.common.base.DependencyInjector
import co.araujoarthur.instagramremake.common.util.TextWatcher
import co.araujoarthur.instagramremake.databinding.ActivityLoginBinding
import co.araujoarthur.instagramremake.login.Login
import co.araujoarthur.instagramremake.login.data.LoginFakeDataBase
import co.araujoarthur.instagramremake.login.data.LoginRepository
import co.araujoarthur.instagramremake.login.presentation.LoginPresenter
import co.araujoarthur.instagramremake.main.view.MainActivity
import co.araujoarthur.instagramremake.register.view.RegisterActivity
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity(), Login.View {

    private lateinit var binding: ActivityLoginBinding
    override lateinit var presenter: Login.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = LoginPresenter(this, DependencyInjector.loginRepository())



        with(binding) {
            loginEditEmail.addTextChangedListener(watcher)
            loginEditPassword.addTextChangedListener(watcher)
            loginBtnEnter.setOnClickListener {
                presenter.login(loginEditEmail.text.toString(), loginEditPassword.text.toString())
            }
            loginTxtRegister.setOnClickListener {
                goToRegisterScreen()
            }
        }
    }

    private fun goToRegisterScreen() {
        startActivity(Intent(this, RegisterActivity::class.java))
    }

    private val watcher = TextWatcher {
        binding.loginBtnEnter.isEnabled = binding.loginEditEmail.text.toString().isNotEmpty()
                && binding.loginEditPassword.text.toString().isNotEmpty()
    }

    override fun showProgress(enabled: Boolean) {
        binding.loginBtnEnter.showProgress(enabled)
    }

    override fun displayEmailFailure(emailError: Int?) {
        binding.loginEditEmailInput.error = emailError?.let { getString(emailError) }
    }

    override fun displayPasswordFailure(passwordError: Int?) {
        binding.loginEditPasswordInput.error = passwordError?.let { getString(passwordError) }
    }

    override fun onUserAuthenticated() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    override fun onUserUnAuthorized(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

}