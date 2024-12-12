package com.example.task3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.task3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener {
            var username = binding.etText.text.toString().trim()
            val password = binding.etPassword.text.toString()

            if (username.isEmpty()) {
                binding.etText.error = "Username is required"
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.etPassword.error = "Password is required"
                return@setOnClickListener
            }

            if (password.length < 8) {
                binding.etPassword.error = "Password must be at least 8 characters"
                return@setOnClickListener
            }

            if (!password.matches(".*[a-zA-Z].*".toRegex())) {
                binding.etPassword.error = "Password must contain at least one letter"
                return@setOnClickListener
            }

            if (!password.matches(".*\\d.*".toRegex())) {
                binding.etPassword.error = "Password must contain at least one number"
                return@setOnClickListener
            }

            val intent = Intent(this, MoviesActivity::class.java)
            startActivity(intent)
            intent.putExtra("username", username)
            finish()
        }
    }
}