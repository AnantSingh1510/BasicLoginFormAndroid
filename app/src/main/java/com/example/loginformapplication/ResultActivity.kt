package com.example.loginformapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.loginformapplication.databinding.ActivityResultBinding

@Suppress("DEPRECATION")
class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrieveUser()
        setParameters()
        setListeners()
    }

    private lateinit var user : UserDetails
    private lateinit var binding: ActivityResultBinding

    private fun retrieveUser() {
        user = intent.getSerializableExtra("User") as UserDetails
    }

    private fun setParameters() {
        val fullName = findViewById<TextView>(R.id.fullName_textView)
        val phoneNo = findViewById<TextView>(R.id.phoneNumber_textView)
        val email = findViewById<TextView>(R.id.email_textView)

        fullName.text = user.getFullName()
        phoneNo.text = user.phone
        email.text = user.email
    }

    private fun setListeners() {
        binding.emailTextView.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto: ${user.email}")
            startActivity(intent)
        }
        binding.phoneNumberTextView.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${user.phone}")
            startActivity(intent)
        }
    }
}