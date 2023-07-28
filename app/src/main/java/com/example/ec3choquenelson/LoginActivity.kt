package com.example.ec3choquenelson

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.example.ec3choquenelson.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.isEnabled = false

        binding.emailEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // No es necesario implementar nada en este método
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // No es necesario implementar nada en este método
            }

            override fun afterTextChanged(s: Editable?) {
                val email = s.toString()
                val isEmailValid = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() && email.length >= 8
                binding.loginButton.isEnabled = isEmailValid
            }
        })

        binding.loginButton.setOnClickListener{
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            if (email == "ejemplo@idat.edu.pe" && password == "123456") {
                // Aquí podrías implementar la lógica para iniciar sesión con las credenciales ingresadas
            } else {
                // Credenciales incorrectas, muestra un mensaje de error
                Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
            }
        }
    }
}